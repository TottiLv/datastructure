class HeapSort {
	public static void main(String[] argv){
		int[] arr = {50,10,90,40,60,80,70,30,20};
		System.out.println("排序前...");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("排序后...");
		heapSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	//堆构造
	public static void heapBuilder(int[] arr, int s, int length){
		int k = s;
		int guard = arr[s];
		//此处为什么index = 2*k+1完全二叉树的特性决定，第i个节点其左子节点为2i，右子节点为2i+1
		//而数组的索引从0开始，所以此处需要+1
		int index = 2*k +1;
		while(index<length){
			if(index+1 < length){
				if(arr[index]<arr[index+1]){
					index++;
				}
			}
			if(arr[index] > guard){
				arr[k] = arr[index];
				k = index;
				index = 2*k +1;	
			} else {
				break;
			}
		}
		arr[k] = guard;
	}

	public static void heapSort(int[] arr){
		//堆构造，从第一个非子叶节点开始(arr.length/2-1)
		for(int i=arr.length/2-1;i>=0;i--){
			heapBuilder(arr,i,arr.length);
		}
				
		for(int i = arr.length-1;i>0;i--){
			//通过交换，将最大值放入到堆的末尾
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			heapBuilder(arr,0,i);			
		}
	}	
}
