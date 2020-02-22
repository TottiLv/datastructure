class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        //当m+n大于nums1的长度是的特殊情况处理
        if (m+n > nums1.length) {
            if (n > m) {
               for(int i=0;i<nums2.length;i++){
                    nums1[i] = nums2[i];
                } 
            }
            return;
        }
        //开辟一个新的数组空间
        int[] nums3 = new int[m+n];
        while(len1<m&&len2<n){
            //比较两个数组中小的值，将小的值放入到新数组中(从小开始放)
            if(nums1[len1]<nums2[len2]){
                nums3[len3] = nums1[len1];
                len3++;
                len1++;
            }else{
                nums3[len3] = nums2[len2];
                len3++;
                len2++;
            }
        }
        //如果数组1循环完，数组2还未完成，直接将数组1剩余内容添加到新数组尾部
        if (len1 >=m ){
            while(len2<n){
                this.additems(nums3,len3,nums2[len2]);
                len3++;
                len2++;
            }
        }
        //如果数组2循环完，数组1还未完成，直接将数组2剩余内容添加到新数组尾部
        if (len2 >=n){
            while(len1<m){
                this.additems(nums3,len3,nums1[len1]);
                len3++;
                len1++;
            }
        }
        //最后将数组从新赋值给nums1，返回
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nums3[i];
        }
    }

    public void additems(int[] nums1,int index, int value){
        nums1[index] = value;
    }

    public static void main(String[] argv){
        // int[] nums1 = {4,0,0,0,0,0};
        // int[] nums2 = {1,2,3,5,6};
        // int[] nums1 = {1,2,3,0,0,0};
        // int[] nums2 = {2,4,5};
        // int[] nums1 = {4,5,6,0,0,0};
        // int[] nums2 = {1,2,3};
        // int[] nums1 = {1,0};
        // int[] nums2 = {2};
        // int[] nums1 = {1,2,3,0,0,0};
        // int[] nums2 = {4,5,6};
        int[] nums1 = {0,0,3,0,0,0};
        int[] nums2 = {-1,1,1,1,2,3};
        Solution solution = new Solution();
        solution.merge(nums1,3,nums2,6);
        for(int i=0;i<nums1.length;i++) {
            System.out.println(nums1[i]);
        }
    }
}
