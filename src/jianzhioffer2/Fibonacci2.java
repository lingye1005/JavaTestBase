package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 15:06
 * @ProjectName: JavaBaseTest
 * 假如: n从1开始,故F(1)=0,F(2)=1,F(3)=2....
 * 这里的算法和Fibonacci区别地方只有2个地方:
 * (1)方法开始的if判定条件不同
 * (2)最后的返回值处表示不同
 */
public class Fibonacci2 {
    //输入n:表示第n项,故求F(n-1)的值
    final int[][] fin={{1,1},{1,0}};
    public int Fibonacci(int n) {//n<0,输入非法
        if(n==0)
            return 1;
        int[][] base={{1,1},{1,0}};
        int exp=n-1;//base的阶乘次数,最小为1
        if(exp%2==0){
            //base先求exp/2的矩阵a,然后求a*a
            for(int i=0;i<exp/2-1;i++)
                base=mulDiffMatrix(base,fin);
            base=mulDiffMatrix(base,base);
        }else if(exp>1){
            //base先求exp/2的矩阵a,然后求a*a,然后再乘以原始的base
            for(int i=0;i<exp/2-1;i++)
                base=mulDiffMatrix(base,fin);
            base=mulDiffMatrix(base,base);
            base=mulDiffMatrix(base,fin);
        }
        return base[1][0];
    }
    /**
     * 方阵相乘
     * @param matrix1
     * @param matrix2
     * @return
     */
    private int[][] mulDiffMatrix(int[][] matrix1,int[][] matrix2){
        int[][] result=new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                int add=0;
                for(int k=0;k<2;k++)
                    add+=matrix1[i][k]*matrix2[k][j];
                result[i][j]=add;
            }
        }
        return result;
    }

    //test
    public static void main(String[] args) {
        Fibonacci2 test=new Fibonacci2();
        System.out.println(test.Fibonacci(3));
    }
}
