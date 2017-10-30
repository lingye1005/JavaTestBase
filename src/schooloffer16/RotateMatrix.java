package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/9.
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
 * 左神的书:空间复杂度:O(1)
 */
public class RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int tR=0,tC=0;
        int dR=n-1,dC=n-1;
        while (tR<dR){
            helper(mat,tR++,tC++,dR--,dC--);
        }
        return mat;
    }
    private void helper(int[][] m,int tR,int tC,int dR,int dC){
        int times=dC-tC;//times就是"占据调整"的总的组数
        int tmp=0;
        for(int i=0;i!=times;i++){
            tmp=m[tR][tC+i];
            m[tR][tC+i]=m[dR-i][tC];
            m[dR-i][tC]=m[dR][dC-i];
            m[dR][dC-i]=m[tR+i][dC];
            m[tR+i][dC]=tmp;
        }
    }
}
