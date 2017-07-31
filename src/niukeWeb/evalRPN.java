package niukeWeb;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/5/2.
 * 牛客网第2题
 * 实质:后缀表达式求运算结果
 * 例子:["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 */
public class evalRPN {
    Stack<Integer> stack=new Stack<Integer>();
    int length;
    int result;
    int evalRPN(String[] tokens) {
        length=tokens.length;
        if(length==1) return Integer.parseInt(tokens[0]);

        for(int i=0;i<length;i++){
            if(tokens[i].equals("+")){
                int a1=stack.pop();
                int b1=stack.pop();
                result=a1+b1;
                stack.push(result);
            }else if(tokens[i].equals("-")){
                int a1=stack.pop();
                int b1=stack.pop();
                result=b1-a1;
                stack.push(result);
            }else if(tokens[i].equals("*")){
                int a1=stack.pop();
                int b1=stack.pop();
                result=a1*b1;
                stack.push(result);
            }else if(tokens[i].equals("/")){
                int a1=stack.pop();
                int b1=stack.pop();
                result=b1/a1;
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(tokens[i].trim()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        evalRPN test=new evalRPN();
        String[] temp=new String[]{"2","1","+","3","*"};
        int eval=test.evalRPN(temp);
        System.out.println(eval);

        String[] temp2=new String[]{"2"};
        int eval2=test.evalRPN(temp2);
        System.out.println(eval2);

        String[] temp3=new String[]{"0","3","/"};
        int eval3=test.evalRPN(temp3);
        System.out.println(eval3);
    }
}
