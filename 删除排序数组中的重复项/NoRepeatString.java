class NoRepeatString{

	public static void main(String[] argv){
		int[] num = {0,0,1,1,2,3,5,7,7,8};
		int len = removeDuplicates(num);
		System.out.println("移除后新数组长度"+len);
	}
	public static int removeDuplicates(int[] num){
		int len = num.length;
		if (len <=0 )
			return 0;
		int i = 0, j = 0;
		for(j=0;j<len;j++){
			if(num[i]!=num[j]){
				i++;
				num[i]=num[j];
			}
		}
		return i+1;
		
	}
}
