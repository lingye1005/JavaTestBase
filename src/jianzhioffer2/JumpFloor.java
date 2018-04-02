package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 17:02
 * @ProjectName: JavaBaseTest
 * 和Fibonacci不同之处:就是exp起始值不同.
 */
public class JumpFloor{
    final int[][] fin={{1,1},{1,0}};
    public int  JumpFloor(int target) {
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        //deal
        int[][] base={{1,1},{1,0}};
        int exp=target;
        if(exp%2==0){
            for(int i=0;i<exp/2-1;i++)
                base=mulMatrix(base,fin);
            base=mulMatrix(base,base);
        }else if(exp>1){
            for(int i=0;i<exp/2-1;i++)
                base=mulMatrix(base,fin);
            base=mulMatrix(base,base);
            base=mulMatrix(base,fin);
        }
        return base[0][0];
    }
    //矩阵相乘
    private int[][] mulMatrix(int[][] matrix1,int[][] matrix2){
        int rows1=matrix1.length;
        int colu1=matrix1[0].length;
        int colu2=matrix2[0].length;
        int[][] res=new int[rows1][colu2];
        //mul
        int add;
        for(int i=0;i<rows1;i++){
            for(int j=0;j<colu2;j++){
                add=0;
                for(int k=0;k<colu1;k++){
                    add+=matrix1[i][k]*matrix2[k][j];
                }
                res[i][j]=add;
            }
        }
        return res;
    }
}
