package schooloffer;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/9/29.
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，
 * 它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
 * 若两边都不存在比它大的数，那么它就是树根。请证明这个方法的正确性，同时设计O(n)的算法实现这个方法。
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        // write code here
        int[] result=new int[n];
        if(n<=0)
            return result;
        Stack<Integer> stack=new Stack<Integer>();//存放元素数组下标

        for(int i=0;i<n;i++){
            int pos=-1;
            //出栈:比A[i]小的数字
            while (!stack.isEmpty() && A[i]>A[stack.peek()]){
                int tmp=stack.peek();
                stack.pop();
                /** result[tmp]==-1:A数组下标为tmp的节点目前还没有遇到比它大的节点
                 ** A[result[tmp]]>A[i]:说明A数组下标为tmp的节点目之前已经遇到比它大的节点,但是新出现的节点A[i]比原来遇到的节点小,则更新A[i]的双亲节点.
                 **/
                if(result[tmp]==-1 || A[result[tmp]]>A[i])
                    result[tmp]=i;
            }
            //找到第一个比A[i]大的数字
            if(!stack.isEmpty()){
                pos=stack.peek();//注意,此处并未出栈,只是取出栈顶的值
            }
            stack.push(i);
            result[i]=pos;
        }
        return result;
    }
}
