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

	//使用for循环的方式进行堆构造
	public static void heapForBuilder(int[] arr, int s, int len){
		int tmp = arr[s];
		//j=2*s+1 是因为完全二叉树当前i节点的左孩子的序号一定是2*i，右孩子一定是2*i+1
		//j*=2+1 它们的孩子当然也就是以2的位数序号增加，因此j变量才这样循环
		for(int j=2*s+1;j<len;j*=2+1){//沿关键字较大的孩子节点向下筛选
			if(j+1<len && arr[j]<arr[j+1]){
				j++; //j为较大记录的下标
			}
			if(tmp>=arr[j])
				break;

			arr[s]=arr[j];//将较大的值赋值给s
			s = j;	
		}
		arr[s] = tmp;//插入原始值
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
