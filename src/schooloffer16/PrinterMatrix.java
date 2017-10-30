package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/9.
 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
 */
public class PrinterMatrix {
    public int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        int[] result=new int[n*m];
        int idx=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                for(int j=0;j<m;j++)
                    result[idx++]=mat[i][j];
            }else{
                for(int j=m-1;j>=0;j--)
                    result[idx++]=mat[i][j];
            }
        }
        return result;
    }
}
