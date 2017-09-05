package jianzhioffer;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/27.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的)
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if((pushA==null && popA!=null) || (pushA!=null && popA==null))
            return false;
        if(popA==null && pushA==null)
            return true;
        if(pushA.length!=popA.length)
            return false;
        int len=pushA.length;
        Stack<Integer> stack=new Stack<Integer>();
        int index=0;
        for(int i=0;i<len;i++){
            while (stack.isEmpty() || stack.peek()!=popA[i]){
                if(index<len)
                    stack.push(pushA[index++]);
                else
                    break;
            }
            if(stack.peek()==popA[i])
                stack.pop();
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        IsPopOrder t=new IsPopOrder();
        int[] a={1,2,3,4,5};
        int[] b={4,5,3,2,1};
        int[] c={4,3,5,1,2};
        System.out.println(t.IsPopOrder(a,b));
        System.out.println(t.IsPopOrder(a,c));
    }
}
