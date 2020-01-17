class QuickSort {

	public static void main(String[] argv){
		int[] arr = {50,10,90,30,70,40,80,60,20};
		System.out.println("排序前...");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		sort(arr,0,arr.length-1);
		System.out.println("排序后...");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	//分割数组	
	public static int position(int[] arr, int low, int high){
		//哨兵值（此值很关键，决定整个排序的复杂度）
		int targetValue = arr[low];
		while(low < high){
			/*
			第一轮：(50,10,90,30,70,40,80,60,20)
			low=0，high=8, low<high
			targetValue = 50
			arr[high]=20<50
			20<50,while循环不走，high=8，low=0
			
			第二轮：(20,10,50,30,70,40,80,60,90)
			low=2,high=8, low<high
			arr[high]=90>50
			进入到while循环high--
			low=2,high=7, low<high
			arr[high]=60>50
			进入while循环high--
			low=2,high=6,low<high
			arr[high]=80>50
			进行while循环high--
			low=2，high=5,low<high
			arr[high]=40 < 50
			跳出while循环，high= 5，low = 2
			
			第三轮：（20,10,40,30,50,70,80,60,90）
			low=4,high=5,low<high
			arr[high]= 70>50
			进入while循环，high--
			low=4,high=4,low==high不执行while继续向下
			*/
			while(low<high&&arr[high]>=targetValue){
				high--;
			}
			/*
			第一轮：(50,10,90,30,70,40,80,60,20)
			arr[high]=20 < 50
			执行if内容
			交换low与high的值
			至此数组变更为：20,10,90,30,70,40,80,60,50
			第二轮：(20,10,50,30,70,40,80,60,90)
			arr[high]=40<50
			进入到if块
			交换low与high的值
			至此数组变更为：20,10,40,30,70,50,80,60,90
			if(arr[high]>=targetValue)
				int tmp = arr[high];
				arr[high]=arr[low];
				arr[low] = tmp;
			}
			/*
			第一轮：(20,10,90,30,70,40,80,60,50)
			low=0,high=8,low<high
			arr[low]=20<50
			进入while循环low++
			low=1,high=8,low<high
			arr[low]=10<50
			进入while循环low++
			low=2,high=8,low<high
			arr[low]=90>50
			跳出循环,low=2,high=8
			第二轮：(20,10,40,30,70,50,80,60,90)
			low=2，high=5,low<high
			arr[low]=40<50
			进入到while循环low++
			low=3,high=5,low<high
			arr[low]=30<50
			进入到while循环low++
			low=4,high=5,low<high
			arr[low]=70>50
			跳出循环，low=4，high=5
			*/
			while(low<high&&arr[low]<=targetValue){
				low++;
			}
			/*
			第一轮：：(20,10,90,30,70,40,80,60,50)
			arr[low]=90 > 50
			执行if块
			至此数组变更为：20,10,50,30,70,40,80,60,90
			第二轮：(20,10,40,30,70,50,80,60,90)
			arr[low]=70 > 50
			执行if块
			至此数组变更为：20,10,40,30,50,70,80,60,90
			*/
			if(arr[low]>=targetValue){
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		}
		//返回low=4
		return low;
	}
	
	public static void sort(int[] arr, int low, int high){
		if (low < high) {
			int p = position(arr,low,high);
			sort(arr, low, p-1);
			sort(arr, p+1, high);
		}
	}
}
