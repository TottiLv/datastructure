/*
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
*/
/*
我们需要找到比当前 T[i] 温度更高的位置，那么必须要记录哪些信息？
我们试着找到 T[0] 过后温度升高的位置。如果知道 T[10]=50，则 T[20]=50 是无效信息，
因为 T[i] 在 T[20] 以前已经到达了 50。如果 t[20]=100 将是有用的信息，
因为如果 t[0]=80，那么 T[20] 将有可能是它的下一个温度升高的位置，而 T[10] 则不可能是。

因此，我们需要记住一个索引的列表，索引代表的温度严格递增。我们可以利用栈来实现这样的效果
*/
import java.util.*;
public class Temperature{
	public static void main(String[] args) {
		int[] ori = {73, 74, 75, 71, 69, 72, 76, 73};		
		int[] res = up(ori);
		for (int i=0; i<res.length; i++) {
			System.out.println("res.i="+res[i]);
		}
	}	
	public static int[] up(int[] ori){
		int[] res = new int[ori.length];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=ori.length-1;i>=0;i--){
			while(!stack.isEmpty()&&ori[i]>=ori[stack.peek()]){
				stack.pop();
			}
			res[i] = stack.isEmpty() ? 0 : stack.peek()-i;
			stack.push(i);
		}
		return res;
	}
}