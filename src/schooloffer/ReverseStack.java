package schooloffer;

/**
 * Created by caoxiaohong on 17/9/29.
 * 一个栈依次压入1,2,3,4,5那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现了栈中元素的逆序，
 * 请设计一个算法实现逆序栈的操作，但是只能用递归函数来实现，而不能用另外的数据结构。
 * 给定一个栈Stack以及栈的大小top，请返回逆序后的栈。
 */
public class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        // write code here
        int[] result=new int[top];
        helper(stack,0,result,top-1);
        return result;
    }
    private void helper(int[] stack,int from,int[] result,int idx){
        if(from>=stack.length)
            return;
        result[idx]=stack[from];
        helper(stack,++from,result,--idx);
    }

    //test code
    public static void main(String[] args) {
        ReverseStack t=new ReverseStack();
        int[] a={1,2,3,4,5};
        int[] b=t.reverseStackRecursively(a,5);
        for(int i:b)
            System.out.println(i);
    }
}