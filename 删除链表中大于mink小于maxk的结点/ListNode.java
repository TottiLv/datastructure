/*
设计一个算法，返回递增有序链表中，值大于mink且小于maxk的所有元素
*/
public class ListNode{
	public static void main(String[] argv){
		Node targetNode = buildNode();
		Node result = delNode(targetNode, 5, 9);
		while(result!=null){
			System.out.println(result.data);
			result = result.next;
		}
	}
	//删除大于mink,小于maxk的值
	public static Node delNode(Node head, int mink, int maxk){
		//定义一个临时链表
		Node dummy = new Node(0);
		//将临临时链表的next指向head
		dummy.next = head;
		//定义pre，pre将用来保存比mink小的结点
		Node pre = dummy;
		//定义preNext用来比较实用
		Node preNext = pre.next;
		while(head!=null && preNext!=null){
			//如果preNext的data>=mink,则跳出循环，此时pre就是比mink小的前一个结点
			if(preNext.data>=mink){
				break;
			}else{
				//否则，pre后移，preNext后移
				pre = pre.next;
				preNext = pre.next;
			}
		}
		//定义rear，rear即是上一轮循环找到的>=mink的结点，从改结点往后，寻找比maxk大的结点
		Node rear = preNext;
		preNext = rear.next;
		while(rear!=null&&preNext!=null){
			//如果preNext的data>=maxk,则跳出循环，此时preNext就是>=maxk一个结点
			if(preNext.data>=maxk){
				break;
			}else{
				//否则，rear后移，preNext后移
				rear = rear.next;
				preNext = rear.next;
			}
		}
		//将<=mink的结点pre的下一个结点，指向preNext的下一个结点
		pre.next = preNext.next;
		//返回dummy的下一个结点即可
		return dummy.next;
	}
	//构造链表
	public static Node buildNode(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		return node1;
	}
}
class Node{
	int data;
	Node next;
	public Node(int val){
		this.data = val;
	}
}