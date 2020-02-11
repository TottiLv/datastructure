class ReverseInt{
	public static void main(String[] argv){
		int i = -321;
		int res = reverse(i);
		System.out.println("res="+res);
	}

	public static int reverse(int x){
		int res = 0;
		while(x!=0){
			int pop = x % 10;
			x /= 10;
			//判断是否正溢出
			//如果res*10+pop溢出，那么res>=Integer.MAX_VALUE/10
			//如果res>Integer.MAX_VALUE/10；那么res*10+pop溢出
			//如果res==Integer.MAX_VALUE/10；那么pop大于7则溢出
			if (res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && pop>7)){
				return 0;
			}
			//判断是否负溢出
			if (res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && pop<-8)){
				return 0;
			}
			res = res*10 + pop;
		}
		return res;
	}
}
