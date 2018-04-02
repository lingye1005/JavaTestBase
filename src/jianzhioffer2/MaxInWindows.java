package jianzhioffer2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: cxh
 * @CreateTime: 18/3/30 15:15
 * @ProjectName: JavaBaseTest
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res=new ArrayList<>();
        if(num==null || num.length==0 || size<=0 || size>num.length)
            return  res;
        if(size==1){
            for(int i=0;i<num.length;i++)
                res.add(num[i]);
            return res;
        }
        Deque<Integer> dq=new LinkedList<>();//元素为数组下标
        //初始化
        for(int i=0;i<num.length && i<size;i++){
            while(!dq.isEmpty() && num[i]>=num[dq.getLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        if(size>=num.length){
            res.add(num[dq.getFirst()]);
            return  res;
        }

        //deal
        for(int i=size;i<num.length;i++){
            res.add(num[dq.getFirst()]);
            while (!dq.isEmpty() && num[i]>=num[dq.getLast()])
                dq.removeLast();
            if(!dq.isEmpty() && dq.getFirst()+size<=i)
                dq.removeFirst();
            dq.addLast(i);
        }
        //添加最后一个窗口的最大值
        res.add(num[dq.getFirst()]);
        return  res;
    }

    //test
    public static void main(String[] args) {
        MaxInWindows t=new MaxInWindows();
        int[] a={2,3,4,2,6,2,5,1};
        ArrayList<Integer> res=t.maxInWindows(a,3);
        res.forEach(i-> System.out.print(i+","));
        System.out.println("-----");
    }
}
