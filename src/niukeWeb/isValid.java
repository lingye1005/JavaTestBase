package niukeWeb;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/7/13.
 * 判定给出的字符串是否是有效的?里面包括(),[],{},如果能配对,则是有效的.
 */
public class isValid {
    public boolean isValid(String s) {
        int len=s.length();
        int size=0;
        Stack<String> stack=new Stack<String>() ;
        for(int i=0;i<len && size<=len/2;i++){
            String str=String.valueOf(s.charAt(i));
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(str);
                size++;
            }else{
                if(!stack.isEmpty()) {
                    String top = stack.peek();
                    if ((top.equals("(") && str.equals(")")) || (top.equals("[") && str.equals("]")) || (top.equals("{") && str.equals("}"))) {
                        stack.pop();
                        size--;
                    } else if (top.equals("(") && (str.equals("]") || str.equals("}")))
                        return false;
                    else if (top.equals("[") && (str.equals(")") || str.equals("}")))
                        return false;
                    else if (top.equals("{") && (str.equals(")") || str.equals("]")))
                        return false;
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        isValid test =new isValid();
        String s1="{{{{}}}}";
        String s2="]";
        System.out.println(test.isValid(s1));
        System.out.println(test.isValid(s2));
    }
}
