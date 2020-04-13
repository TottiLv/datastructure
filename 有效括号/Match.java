/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
*/
import java.util.*;
public class Match{
	public static void main(String[] argv){
		String ori = "[([][])]";
		boolean flag = match(ori);
		System.out.println("flag==="+flag);
	}
	/*
	将0个元素压栈
	遍历字符范围
	取栈顶字符
	检查该括号是左括号
		左：判断后面的字符data[i]是否是右括号，YES入栈/NO出栈
	遍历结束，判断栈是否为空
	*/
	public static boolean match(String ori){
		char[] oriArray = ori.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		stack.push(oriArray[0]);
		for(int i=1;i<oriArray.length;i++){
			char top = stack.peek();
			char cur = oriArray[i];
			switch (top) {
					case '(' :{
						if (cur==')') stack.pop();
						else stack.push(cur);
						break;
					}
					case '[' :{
						if (cur==']') stack.pop();
						else stack.push(cur);
						break;
					}
					case '{' :{
						if (cur=='}') stack.pop();
						else stack.push(cur);
						break;
					}
					default:
						break;
			}
		}
		return stack.empty();
	}
}