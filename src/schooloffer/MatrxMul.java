package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/20.
 * A[n,m]是一个n行m列的矩阵，a[i,j]表示A的第i行j列的元素，定义x[i,j]为A的第i行和第j列除了a[i,j]之外所有元素(共n+m-2个)的乘积，
 * 即x[i,j]=a[i,1]*a[i,2]*...*a[i,j-1]*...*a[i,m]*a[1,j]*a[2,j]...*a[i-1,j]*a[i+1,j]...*a[n,j],现输入非负整形的矩阵A[n,m]，求MAX(x[i,j])，即所有的x[i,j]中的最大值。
 */
public class MatrxMul {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            int[][] matrix=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    matrix[i][j]=scanner.nextInt();
            }
            int max=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    //行相乘
                    int mul1=1;
                    for(int p=0;p<m;p++){
                        if(j!=p)
                            mul1*=matrix[i][p];
                    }
                    //列相乘
                    int mul2=1;
                    for(int q=0;q<n;q++){
                        if(q!=i)
                            mul2*=matrix[q][j];
                    }
                    if(mul1*mul2>max)
                        max=mul1*mul2;
                }
            }
            System.out.println(Double.valueOf(max).intValue());
        }
    }
}
