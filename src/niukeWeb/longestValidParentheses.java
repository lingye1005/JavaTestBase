package niukeWeb;


import java.util.Stack;

/**
 * Created by caoxiaohong on 17/7/9.
 * 求最长连续的符号匹配
 * 找到第一个入栈元素"(",记录下标from;
 * 遇到")",则出栈;判断:如果此时栈空,记录字符下标end;求出此子串的长度.
 */
public class longestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2)
            return 0;
        int max=0;
        int last=-1;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    last=i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max=Math.max(max,i-last);
                    }else{
                        max=Math.max(max,i-stack.peek());
                    }
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        longestValidParentheses test=new longestValidParentheses();
        String s=")()())";//()(() or )()())
        System.out.println(test.longestValidParentheses(s));
    }
}
