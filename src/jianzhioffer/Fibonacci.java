package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 佩波那契序列:求第n个数字是多少
 * f(n)=f(n-1)+f(n-2);
 * 1,1,2,3,5...
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        else{
            int add1=1,add2=1;
            for(int i=3;i<=n;i++){
                int tmp=add2;
                add2=add1+add2;
                add1=tmp;
            }
            return add2;
        }
    }

    //test code
    public static void main(String[] args) {
        Fibonacci test=new Fibonacci();
        System.out.println(test.Fibonacci(39));
    }
}
