package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 11:33
 * @ProjectName: JavaBaseTest
 */
public class LastRemaining_Solution {
    public static void main(String[] args) {
        LastRemaining_Solution t=new LastRemaining_Solution();
        System.out.println(t.LastRemaining_Solution(5,3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1)
            return -1;
        int last=0;//n=1是,last 表示删除索引
        for(int i=2;i<=n;i++){
            last=(last+m)%i; //公式:f(n,m)=(f(n-1,m)+m)%n;
        }
        return last;
    }

}
