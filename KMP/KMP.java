public class KMP {
    public static void main(String[] argv){
	String originStr = "BBCFABCDABFABCDABCDABDE";
	String subStr = "ABCDABD";
	boolean flag = hasSubString(originStr,subStr);
	System.out.println(flag);
    }
	
    public static boolean hasSubString(String originStr, String subString) {
        if ((null != originStr && null != subString) && (originStr.length() < subString.length())) {
            return false;
        }
        char[] originStrChars = originStr.toCharArray();
        char[] subStringChars = subString.toCharArray();
        return matchString(originStrChars, subStringChars);
    }

    /**
     * KMP中的核心算法，获得记录跳转状态的next数组
     *
     * @param c
     * @return
     */
    public static int[] matchTable(char[] c) {
        int length = c.length;
        int[] a = new int[length];
        int i, j;
        a[0] = 0;
        i = 0;
        for (j = 1; j < length; j++) {
            i = a[j - 1];
            if (c[j] == c[i]) {
                a[j] = i+1;
            } else {
                a[j] = 0;
            }
        }
        return a;
    }

    /**
     * 匹配字符串
     *
     * @param originStrChars
     * @param subStringChars
     * @return
     */
    public static boolean matchString(char[] originStrChars, char[] subStringChars) {
        int[] next = matchTable(subStringChars);
	int i = 0;
        int j = 0;
        while (i < originStrChars.length  && j < subStringChars.length) {
		if (j==0){
			if(originStrChars[i] == subStringChars[j]){
				j++;
				i++;
			}else{
				i++;
			}	
		}else {
			if (originStrChars[i] == subStringChars[j]){
				j++;
				i++;
			}else{
				j = next[j-1];
			}
			
		}
        }
        if (j < subStringChars.length) {
            return false;
        } else
            return true;
    }
}
