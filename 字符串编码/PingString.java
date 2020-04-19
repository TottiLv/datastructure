/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
*/
import java.util.*;
public class PingString{
	public static void main(String[] args) {
		String ori = "12[a8[def]]b";	
		// String ori = "";
		String result = ping(ori);
		System.out.println("result = " + result);
	}

	public static String ping(String ori){
		if(ori.length()<=0){
			return "";
		}
		//res用来保存最终生成的字符串
		StringBuilder res = new StringBuilder();
		//int类型sum，表示[前面数字
		int sum = 0;
		//digitList,用来保存[前面的数字
		LinkedList<Integer> digitList = new LinkedList<Integer>();
		//subStringList,用来保存[]里面的字符
		LinkedList<String> subStringList = new LinkedList<String>();
		/*
		1.遇到数字，将数字组装
		2.遇到字符，将字符进行组装
		3.遇到[,
			3.1将之前的数字存入到digitList中
			3.2将之前的字符串，存入到subStringList中
		4.遇到],从digitList中取出最后一个数字进行对[]中字符串(即res)进行copy
		*/
		char[] oriCharArray = ori.toCharArray();
		for(int i=0;i<oriCharArray.length;i++){
			char c = oriCharArray[i];
			if(c=='['){
				digitList.addLast(sum);
				subStringList.addLast(res.toString());
				sum = 0;
				res = new StringBuilder();
			}else if(c==']'){
				int curNum = digitList.removeLast();
				StringBuilder tmp = new StringBuilder();
				while(curNum>0){
					tmp.append(res.toString());
					curNum--;
				}
				res = new StringBuilder(subStringList.removeLast()+tmp.toString());
			}else if(c>='0' && c<='9'){
				sum = 10*sum+Integer.parseInt(c+"");
			}else{
				res.append(c);
			}
		}
		return res.toString();
	}
}