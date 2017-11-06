package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/3 17:27.
 * Fibonacci数列是这样定义的：....
 * Fibonacci变种,但很简单
 */
public class FibonacciTrans {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int idx=1;
            while (true){
                int min=getNthNumber(idx);
                int max=getNthNumber(idx+1);
                if(min<=n && max>=n){
                    System.out.println(Math.min(Math.abs(n-min),Math.abs(n-max)));
                    break;
                }
                idx++;
            }
        }
    }
    //矩阵快速幂求第n个Fibonacci数字是多少
    private  static int getNthNumber(int n){
        long[][] base=new long[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        long[][] ret={{1,0},{0,1}}; //初始化单位矩阵

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
                            tmp[i][j]+=ret[i][k]*base[k][j];
                        }
                    }
                }
                //更改ret值
                ret=Arrays.copyOf(tmp,tmp.length);
            }
            //base*base
            tmp=new long[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];
                    }
                }
            }
            //更改base值
            base=Arrays.copyOf(tmp,tmp.length);
            exp/=2;
        }
        return (int)ret[0][0];
    }
}
