/*
如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
*/
class Solution {
    public static void main(String[] argv){
        int[] nums = {1,2,5,9,5,9,5,5,5};
        int result = majorityElement(nums);
        System.out.println("result="+result);
    }
    public static int majorityElement(int[] nums) {
        if(nums.length<=){
            return -1;
        }
        //给一个默认值作为哨兵
        int tmpVal = nums[0];
        //默认计数为1
        int count = 1;
        for(int i=1;i<nums.length;i++){
            //如果数组中内容与哨兵相等，则count++
            if(nums[i]==tmpVal){
                count++;
            }else{
            //如果数组中内容与哨兵不相等，则count--
                count--;
            }
            //如果count==0，则更换哨兵
            if(count==0){
                tmpVal = nums[i];
                count = 1;
            }
        }
        //获取大于数组一半的数字
        int moreHalfVal = nums.length/2+1;
        count = 0;
        //验证
        for(int num : nums){
            //如果数组中内容与哨兵相等，则count++
            if (num==tmpVal) count++;
            //如果哨兵存在的个数等与数组的一半+1，则说明此元素是主要元素
            if (moreHalfVal==count) return tmpVal;
        }
        //返回-1
        return -1;
    }
}