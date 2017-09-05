package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/27.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackIncludedMin {
    Stack<Integer> stack=new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        else
            return 0;
    }

    public int min() {
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> values=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            int tmp=stack.pop();
            if(min>tmp)
                min=tmp;
            values.add(tmp);
        }
        //恢复栈
        for(int i=values.size()-1;i>=0;i--){
            stack.push(values.get(i));
        }
        return min;
    }
}
