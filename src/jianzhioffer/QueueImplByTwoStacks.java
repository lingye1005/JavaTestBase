package jianzhioffer;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/25.
 */
public class QueueImplByTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int temp= stack2.pop();
        //再将stack2中的元素放入stack1中
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }
}
