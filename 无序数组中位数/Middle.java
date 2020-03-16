public class Middle{
	/*
	将数组的前（n+1）／2个元素建立一个最小堆。然后，对于下一个元素，和堆顶的元素比较，
	如果小于等于，丢弃之，
	如果大于，则用该元素取代堆顶，再调整堆，接着看下一个元素。
	重复这个步骤，直到数组为空。当数组都遍历完了，堆顶的元素即是中位数。
	*/
	public static void main(String[] argv){
		int[] oriArr = {12, 34, 1, 209,17, 900, -10};
		int[] arr = {12, 34, 1, 209};
		heapSort(arr);
		adjustHeap(arr);
		System.out.println("中位数="+arr[0]);
	}
	//调整堆
	public static void adjustHeap(int[] arr){
		int[] arr1 = {17, 900, -10};
		for(int i=0;i<arr1.length;i++){
			if(arr1[i]>arr[0]){
				arr[0] = arr1[i];
				heapSort(arr);
			}
		}
	}
	//从第一个非叶子结点开始
	public static void heapSort(int[] arr){
		for(int i=(arr.length+1)/2;i>=0;i--){
			heapBuilder(arr,i,arr.length);
		}
	}
	//构建小顶堆
	public static void heapBuilder(int[] arr,int i,int len){
		int k = i;
		int index = 2*k+1;
		int guard = arr[k];
		while(index<len){
			if(index+1 < len){
				if(arr[index]>arr[index+1]){
					index++;
				}
			}
			if(guard>arr[index]){
				arr[k] = arr[index];
				k = index;
				index = 2*k+1;
			}else{
				break;
			}
		}
		arr[k] = guard;
	}
}