import java.util.*;
/*
解题关键:
 字典序: 字符串之间比较和数字比较不一样; 字符串比较是从头往后挨个字符比较,那个字符串大取决于两个字符串中第一个对应不相等的字符; 例如 任意一个a开头的字符串都大于任意一个b开头的字符串;例如字典中apple 大于 book;
 题目的意思,你去除重复字母后,需要按最小的字典序返回.并且不能打乱其他字母的相对位置;
 例如 bcabc 你应该返回abc, 而不是bca,cab;
 例如 cbacdcbc 应该返回acdb,而不是cbad,bacd,adcb
 例如 zab,应该返回zab,而不是abz;
 
 思路:
 1. 判断字符串可能出现的特殊情况
 2. 用一个record数组记录字符串中字母出现的次数;
 3. 申请一个字符串栈stack用来存储去除重复字母的结果,并利用它的特性帮助我们找到正确的次序;
 4. 遍历字符串s
 5. 遍历stack 判断当前字符s[i]是否存在于栈stack中
    如果当前字符是否存在于栈的定义一个falg 标记isExist, 0表示不存在, 1表示存在
 6.如果isExist存在,record[s[i]]位置上的出现次数减一，并继续遍历下一个字符; 表示当前的stack已经有这个字符了没有必要处理这个重复的字母;
 7.如果isExist不存在,则
    如果不存在,则需要循环一个找到一个正确的位置,然后在存储起来;
    如果不存在，跳过栈中所有比当前字符大、且后面还会出现的元素，然后将当前字符入栈
    !stack.isEmpty() 表示栈不为空
    stack.peek() > sCharArray[i]表示栈顶元素比当前元素大
    record[stack.peek()-'a'] > 1表示后面还会出现
 通过一个while循环找到将栈中位置错误的数据,出栈. 找当前合适的位置,则结束while循环;
 找到合理的位置后,则将当前字符s[i]入栈;
 
 8.直到遍历完所有字符后,则为字符串栈stack
*/
class Solution {
    public static void main(String[] argv){
        String str = "cbacdcbc";
        String res =  removeDuplicateLetters(str);
        System.out.println("res=="+res);
    }
    public static String removeDuplicateLetters(String s) {
        //边界条件判断
        if (s==null || s.length()<2){
            return s;
        }
        //申请一个栈(字符栈)，利用栈帮助找到正确的位置
        Stack<Character> stack = new Stack<Character>();
        //声明record数组，用来存储字符出现的次数
        int[] record = new int[26];
        char[] sCharArray = s.toCharArray();
        //循环用来获取字符出现的次数
        for(int i=0; i<sCharArray.length; i++){
            //ASCII a从95开始，所以所有减去a，则得到索引值
            int v = sCharArray[i]-'a';
            record[v]++;
        }
        //循环用来过滤字符串并且按字典排序
        for(int i=0; i<sCharArray.length; i++){
            int v = sCharArray[i]-'a';
            //定义一个标志，判断当前字符是否已经存在于栈中
            int isExist = 0;
            for(Character c : stack){
                if (sCharArray[i]==c) {
                    isExist = 1;
                    break;
                }
            }
            //如果已经存在于栈中，则跳出当前循环，并将record中记录数-1
            if(isExist==1){
                record[v]--;
                continue;
            }
            /*
            出栈条件
            1.stack不为空
            2.栈顶元素大于当前元素
            3.栈顶元素对应的次数大于1
            */
            while(!stack.isEmpty() && record[stack.peek()-'a']>1 && stack.peek()>sCharArray[i]){
                record[stack.peek()-'a']--;
                stack.pop();
            }
            stack.push(sCharArray[i]);
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
}