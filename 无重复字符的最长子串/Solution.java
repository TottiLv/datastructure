class Solution {
	public static void main(String[] argv){
		String s = "abcabcbb";
		int len = lengthOfLongestSubstring(s);
		System.out.println("长度为len="+len);
	}
	
	public static int lengthOfLongestSubstring(String s){
		int n = s.length(), ans = 0;
		int[] index = new int[128];
		for(int j=0,i=0;j<n;j++){
			i = Math.max(index[s.charAt(j)],i);
			ans = Math.max(ans,j-i+1);
			index[s.charAt(j)] = j+1;
		}
		return ans;
	}
}
