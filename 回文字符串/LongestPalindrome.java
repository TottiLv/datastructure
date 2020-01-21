class LongestPalindrome {

    public static void main(String[] argv){
        String s = "aababba";
	int max = longestPalindrome(s);
	System.out.println("字符串中包含的最长回文字符串长度="+max);
    }
    //获取字符串中包含的最长回文字符串长度
    public static int longestPalindrome(String s){
	//将原字符串转为字符数组
	char[] originStr = s.toCharArray();
	//在字符间插入一个不会在原字符数组中出现的字符(例如：#),是新的字符数组长度永远保持奇数
	//如：aababba 转换为：#a#a#b#a#b#b#a#，首尾全部添加，所以心的字符数组长度=2*就字符数组长度+1
	char[] changedStr = new char[originStr.length*2+1];
	int index = 0;
	for(int i=0;i<originStr.length;i++){
		changedStr[index++] = '#';
		changedStr[index++] = originStr[i];
	}
	changedStr[index++] = '#';
	
	//定义最大长度值，默认为0
	int max = 0;
	for(int i=0;i<changedStr.length;i++){
		//定义临时变量，记录每位对应的最长回文数
		int tmpLen = 0;
	 	if(i==0 || i==changedStr.length-1){
			continue;
		}
		//定义当前索引的前后索引
		int left = i-1;//前索引，默认为当前索引-1
		int right = i+1;//后索引，默认为当前索引+1
		//进行while循环，以当前索引为中心，向外扩散
		while(left>=0 && right<changedStr.length){
			//前后相等，则继续向外扩散... left--,right++
			if(changedStr[left]==changedStr[right]){
				left--;
				right++;
				tmpLen++;//前后相等则临时长度+1
			}else {
				left = -1;//用于跳出while循环
			}
		}
		//比较数组最大长度与当前索引对应的回文长度，然后赋值max
		if (max<=tmpLen) {
			max = tmpLen;
		}
	}
	return max;
    }

}
