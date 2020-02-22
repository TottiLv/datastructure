import java.util.HashMap;
class DLinkedList {
    int key ;
    int value ;
    DLinkedList pre;
    DLinkedList next;
}

public class LRUCache {
    int capacity = 0;
    int size = 0;
    DLinkedList head,tail = null;
    HashMap<Integer, DLinkedList> cache = new HashMap<Integer, DLinkedList>();
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        head.pre = null;
        tail = new DLinkedList();
        tail.next = null;
        head.next =tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedList linked = this.cache.get(key);
        if (null==linked){
            return -1;
        }
        //移动到第一位
        this.moveToHead(linked);
        return linked.value;
    }
    
    public void put(int key, int value) {
        DLinkedList linked = this.cache.get(key);
        if (linked==null){
            DLinkedList node = new DLinkedList();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.addNode(node);
            ++this.size;
        } else {
            linked.value = value;
            this.moveToHead(linked);
        }
        if (this.size>this.capacity) {
            DLinkedList remNode = this.popTail();
            this.cache.remove(remNode.key);
            --this.size;
        }
    }

    public void addNode(DLinkedList node){
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    public void moveToHead(DLinkedList node){
        this.removeNode(node);
        this.addNode(node);
    } 

    public void removeNode(DLinkedList node){
        DLinkedList preNode = node.pre;
        DLinkedList nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    public DLinkedList popTail(){
        DLinkedList pre = this.tail.pre;
        this.removeNode(pre);
        return pre;
    }

    public static void main(String[] argv){
	LRUCache cache = new LRUCache(2);
	cache.put(1,1);
	cache.put(2, 2);
	cache.get(1);       // 返回  1
	cache.put(3, 3);    // 该操作会使得密钥 2 作废
	cache.get(2);       // 返回 -1 (未找到)
	cache.put(4, 4);    // 该操作会使得密钥 1 作废
	cache.get(1);       // 返回 -1 (未找到)
	cache.get(3);       // 返回  3
	cache.get(4);       // 返回  4
    }
}
