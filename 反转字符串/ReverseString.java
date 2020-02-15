class ReverseString{

	public static void main(String[] argv){
		String org = "abcdefghijklmn";
		reverse(org);
	}
	/*
	反转字符串
	*/
	public static void reverse(String s){
		//字符串转换为字符数组
		char[] sc = s.toCharArray();
		int begin = 0;
		int end = sc.length-1;
		while(begin<end) {
			char tmp = sc[end];
			sc[end] = sc[begin];
			sc[begin] = tmp;
			begin++;
			end--;
		}
		System.out.println("转换后字符串="+new String(sc));
		System.out.println("原始字符串"+s);
	}

}
