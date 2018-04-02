package jianzhioffer2;

import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 11:53
 * @ProjectName: JavaBaseTest
 */
public class LastRemaining_Solution2 {
    //test
    public static void main(String[] args) {
        LastRemaining_Solution2 t=new LastRemaining_Solution2();
        System.out.println(t.LastRemaining_Solution(5,3));

    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1)
            return -1;
        int[] numbers=new int[n];
        Arrays.setAll(numbers, i->i);


        int count=0;//记录已扫描的未被删除的元素个数
        int pre=-1;//上一次访问的非-1的元素索引

        for(int i=0;;){
            if(i==n){
                i=0;
                continue;
            }
            if(numbers[i]==-1){
                i++;
                continue;
            }
            if(numbers[i]!=-1){
                //只剩下一个数字,上一个非-1元素就是当前这个非-1元素
                if(pre!=-1 && i==pre) {
                    return i;
                }
                //更新上一个非-1的元素索引
                pre=i;
                count++;
                //如果这是第m个元素,则更新删除元素
                if(count==m){
                    numbers[i]=-1;
                    count=0;
                    pre=-1;
                }
                i++;
            }
        }
    }
}
