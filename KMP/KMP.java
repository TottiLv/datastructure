public class KMP{
	public static void main(String[] args) {
		//abcababcabx
		//abcabx
		// String ori = "BBCFABCDABFABCDABCDABDE";
		// String sub = "ABCDABD";
		String ori = "abcababcabx";
		String sub = "abcabx";
		boolean flag = judge(ori,sub);
		System.out.println("---flag="+flag);
	}

	//判断两个字符串是否相等
	public static boolean judge(String ori, String sub){
		// if((ori!=null && sub!=null) && ori.length()<sub.length()){
		// 	return false;
		// }
		char[] oriArray = ori.toCharArray();
		char[] subArray = sub.toCharArray();
		int i=0,j = 0;
		int[] kmpArray = next(sub);
		while(i<oriArray.length && j<subArray.length){
			if(oriArray[i]==subArray[j]){
				i++;
				j++;
			}else{
				if (j==0) {
					i++;
				}else{
					j=kmpArray[j];
				}
			}
		}
		if(j < subArray.length){
			return false;
		}
		return true;
	}

	//构建next数组（用于回溯）
	public static int[] next(String ori){
		/*
		核心就是对比当前index之前的字符前后缀知否一致
		求解next数组的4种情况
		1、默认next[0]=0,next[1]=0;
		2、当i为0时，表示应该从从开始 
		3、当ori[slow]==ori[fast],表示两个字符相等，则：slow++,fast++
		4、当ori[slow]!=ori[fast]，则需要讲fast回溯到合理的位置
		使用next数组来记录子串回溯的位置(即：主串与子串不相等的时候，回溯子串的位置)
		*/
		char[] oriArray = ori.toCharArray();
		int[] kmpArray = new int[oriArray.length];
		kmpArray[0] = 0;
		int slow = 0;
		int fast = 1;
		for(int i=1;i<oriArray.length;i++){
			if (i==1){
				kmpArray[i] = 0;
				continue;
			}
			if(oriArray[slow]==oriArray[fast]){
				slow++;
				kmpArray[i] = slow;
			}else{
				slow = kmpArray[i];
			}
			fast++;
		}	
		return kmpArray;
	}
}

