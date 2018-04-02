package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 14:42
 * @ProjectName: JavaBaseTest
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1)
            return 0;
        int len=getLenthOfN(n);
        if(len==1)
            return 1;

        int tmp1=powerOfBase(len-1);
        int highNum=n/tmp1;
        int first=highNum==1?n%tmp1+1:tmp1;
        int others=highNum*(len-1)*(tmp1/10);
        return first+others+NumberOf1Between1AndN_Solution(n%tmp1);
    }
    //获取n的长度
    private int getLenthOfN(int n){
        int res=0;
        while(n!=0){
            res++;
            n/=10;
        }
        return res;
    }
    //获取base长度范围内的10的最高次幂数
    private int powerOfBase(int base){
        return (int)Math.pow(10,base);
    }
}
