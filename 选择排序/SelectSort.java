class SelectSort {
	/*
	简单排序原理：
	每一趟从待排序的数组中选出最小值，顺序放在已排好序的序列后面
	n(n-1)/2次比较（比较次数与数组的初始排序无关）
	交换次数：
	如果原始数组为正序，那么交换次数为0（最少）
	如果原始数组为反序，那么交换次数为3*n*(n-1)/2 次（最多）i
	综合的时间复杂度与比较次数和交换次数有关， O(n²)
	*/
	public static void main(String argv[]){
		int[] arr = {5,9,2,7,3,4};
		System.out.println("原始数组顺序");
		for (int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		System.out.println("排序后输出");
		sort(arr);
		for (int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}	
	//简单选择排序算法
	public static void sort(int[] arr){
		//说明：备注中的n，表示数组的长度
		//外层循环，从0开始到n-1结束(因为内层循环是到最后一位)
		for(int i = 0; i < arr.length-1; i++){
			int k= i;//定义一个临时变量，存储选定的最小值(哨兵)
			//内层循环，从第i+1开始到n结束，与哨兵进行比较，每轮进行n-i+1次循环
			for(int j = i+1; j < arr.length; j++){
				if(arr[k] > arr[j]){//比较找到比arr[k]小的值
					k = j;//将最小值下标进行重新赋值
				}
			}
			//内层循环完之后，找到当前轮次的最小值，进行数据交换
			if (i != k){
				int tmp = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp;
			}
		}
	}
}
