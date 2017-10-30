package schooloffer16;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/25.
 * 对于斐波纳契经典问题，我们都非常熟悉，通过递推公式F(n) = F(n - 1) + F(n - 2)，我们可以在线性时间内求出第n项F(n)，现在考虑斐波拉契的加强版，
 * 我们要求的项数n的范围为int范围内的非负整数，请设计一个高效算法，计算第n项F(n-1)。第一个斐波拉契数为F(0) = 1。
 * 算法关键:矩阵快速幂.
 */

public class Fibonacci2 {

    public int getNthNumber(int n) {
        // write code here
        long[][] base=new long[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        //求矩阵matrix的(n-1)次方;
        long[][] ret={{1,0},{0,1}};//初始化为单位矩阵E


        if(n==0 || n==1)
            return 1;
        int exp=n-1;
        long[][] tmp;

        while (exp>0){
            if((exp&1)>0){
                //ret*base
                tmp=new long[2][2];
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<2;k++){
                            tmp[i][j]+=ret[i][k]*base[k][j];//注意这里的code
                            if(tmp[i][j]>=1000000007)
                                tmp[i][j]%=1000000007;
                        }
                    }
                }
                ret=Arrays.copyOf(tmp,tmp.length);//ret改值
            }
            //base*base
            tmp=new long[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];//注意这里的code
                        if(tmp[i][j]>=1000000007)
                            tmp[i][j]%=1000000007;
                    }
                }
            }
            base=Arrays.copyOf(tmp,tmp.length);//ret改值
            //exp右移一位
            exp=exp>>1;
        }
        //最后:ret第一行和两行一列矩阵[1,1]进行相乘,得到一个整数,即为所求.所以可以简化为将ret第一行数字进行相加即为所求
        return (int)(ret[0][0]+ret[0][1])%1000000007;
    }


    //test code
    public static void main(String[] args) {
        Fibonacci2 t=new Fibonacci2();
        System.out.println(t.getNthNumber(12));
    }
}
