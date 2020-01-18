class BinarySearch {
	public static void main(String[] argv){
		int[] arr = {1,16,24,35,47,59,62,73,88,99};
		int key = 62;	//待查找元素
		int index = search(arr,key);
		System.out.println(index);
	}
	/*二分查找*/	
	public static int search(int[] arr,int key){
		int low,high,mid;
		//定义最低下标为记录首位
		low = 0;
		//定义最高下标为记录末位
		high = arr.length-1;
		while(low<=high){
			//折半
			mid = (low+high)/2;
			if(key>arr[mid]){
			//若查找值比中值小，最高值调整到中位下标小一位
				low = mid+1;
			}else if (key <arr[mid]){
			//若查找值比中值大，最小值调整到中位下标大一位
				high = mid-1;
			}else{
			//若相等则说明mid即为查找到的位置
				return mid;
			}
		}
		return 0;
	}
}
