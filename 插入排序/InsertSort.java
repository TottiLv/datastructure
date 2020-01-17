class InsertSort {
	/*
	插入排序，是将待排序数组(包含n个元素)，看成是一个有序数组和一个无序数组
	将无序数组插入到有序数组合适的位置
	开始有序数组只包含一个元素，无序数组包含n-1个元素
	*/
	public static void main(String argv[]){
		int[] arr = {12,8,9,4,10,3,1,6};
		System.out.println("Before Sort：");
		for (int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("After Sort：");
		sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	public static void sort(int[] arr){
		//外层循环，从1开始，将第0个元素看成是有序数组的元素
		for(int i = 1;i<arr.length;i++){
			//indexValue准备和前一个元素进行比较
			int indexValue = arr[i];//哨兵
			int index = i-1;
			//while循环（因为不知道次数，所以使用while循环，index用来做跳出while标志）
			//当arr[i-1]>arr[i]时，进行插入炒作
			while(index>=0 && indexValue<arr[index]){
				arr[index+1]=arr[index];
				index--;
			}
			//将哨兵插入到合适的位置（注意此处的也需要index+1,因为在while循环中有index--）
			arr[index+1] = indexValue;
		}
	}

}
