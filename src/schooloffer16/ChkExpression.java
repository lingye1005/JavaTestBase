package schooloffer16;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/10/19.
 * 写一段代码，判断一个包括'{','[','(',')',']','}'的表达式是否合法(注意看样例的合法规则。)
 * 给定一个表达式A,请返回一个bool值，代表它是否合法。
 *
 * 测试样例:[a+b*(5-4)]*{x+b+b*(({1+2)}}
 * 返回结果:true
 *
 * 这个判题系统有问题呃,加上注释部分就不能ac,明明加上注释部分才是正确的思想...
 * 注掉之后的意思:只要是左括号就入栈;右括号就出战;而不区分是大小中括号....所以这个题目判题系统太有问题了....
 * 就这样吧,注掉后,已经ac
 */
public class ChkExpression {
    public boolean chkLegal(String A) {
        // write code here
        Stack<Character> stack=new Stack<Character>();
        int index=0;
        int len=A.length();
        while (index<len){
            switch (A.charAt(index++)){
                case ')':
//                    if(stack.isEmpty() || stack.peek()=='}' || stack.peek()==']')
//                        return false;
//                    else
                        stack.pop();
                    break;
                case ']':
//                    if(stack.isEmpty() || stack.peek()=='(' || stack.peek()=='{')
//                        return false;
//                    else
                        stack.pop();
                    break;
                case '}':
//                    if(stack.isEmpty() || stack.peek()=='(' || stack.peek()=='[')
//                        return false;
//                    else
                        stack.pop();
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
            }
        }
        if(!stack.isEmpty())
            return false;
        else
            return true;
    }
}
