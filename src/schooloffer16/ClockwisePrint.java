package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/9.
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 * 思想:还是占据调整的思想
 */
public class ClockwisePrint {
    int idx=0;
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] result=new int[n*m];
        int tR=0,tC=0;
        int dR=n-1,dC=m-1;
        while( (tR<=dR || tC<=dC)  && idx<m*n){
            helper(mat,tR++,tC++,dR--,dC--,result,idx);
        }
        return result;
    }
    private void helper(int[][] mat,int tr,int tc,int dr,int dc,int[] result,int idx){
        int curR=tr;
        int curC=tc;
        if(tc==dc){  //只剩下一列
            while (tr<=dr){
                result[idx++]=mat[tr++][tc];
            }
        }else if(tr==dr){ //只剩下一行
            while (tc<=dc){
                result[idx++]=mat[tr][tc++];
            }
        }else{ //一般情况
            //up
            while (curC<dc){
                result[idx++]=mat[tr][curC++];
            }
            //right
            while (curR<dr){
                result[idx++]=mat[curR++][dc];
            }
            //down
            while (curC>tc){
                result[idx++]=mat[dr][curC--];
            }
            //left
            while (curR>tr){
                result[idx++]=mat[curR--][tc];
            }
        }
        this.idx=idx;//注意:要修改idx值
    }

    public static void main(String[] args) {
        ClockwisePrint t=new ClockwisePrint();
        int[][] a={{60,26,6,67,90,47,1,65,11,31,15,32}};
        int[] b=t.clockwisePrint(a,1,12);
    }
}
