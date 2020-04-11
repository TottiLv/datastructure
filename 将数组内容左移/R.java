/*
设将n(n>1)个整数存放到一维数组R中，试设计一个在时间和空间两方面都尽可能高效的算法；
将R中保存的序列循环左移p个位置(0<p<n)个位置，即将R中的数据由
(x0,x1,......,xn-1)变换为(xp,xp+1,......xn-1,x0,x1,......xp-1)
*/
public class R{
	public static void main(String[] argv){
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int k = 3;
		//8,9,10,1,2,3,4,5,6,7
		nums = cut(nums, k);
		for(int i = 0;i<nums.length;i++){
			System.out.println("左移后的内容="+nums[i]);
		}
	}
	public static int[] cut(int[] nums, int k){
		//将原数组原地逆置 10,9,8,7,6,5,4,3,2,1
		nums = reverse(nums);
		//拆分为两个数组 
		//[10,9,8]
		int[] nums1 = java.util.Arrays.copyOfRange(nums, 0, k);
		//[7,6,5,4,3,2,1]
		int[] nums2 = java.util.Arrays.copyOfRange(nums, k, nums.length);
		//将nums1与nums逆置
		//8,9,10
		nums1 = reverse(nums1);
		//1,2,3,4,5,6,7
		nums2 = reverse(nums2);
		//合并nums1，nums即可
		nums = java.util.Arrays.copyOf(nums1, nums1.length+nums2.length);
		System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
		return nums;
	}
	//反转数组
	public static int[] reverse(int[] nums){
		int i = 0;
		int j = nums.length-1;
		while(j>i){
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
		return nums;
	}
}