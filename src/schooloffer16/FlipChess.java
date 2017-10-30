package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/12.
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，
 * 要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 */
public class FlipChess {
    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        if(A==null)
            return null;
        int rows=A.length;
        int columns=A[0].length;

        for(int i=0;i<3;i++){
            int row=f[i][0];
            int column=f[i][1];
            //up
            if(row-2>=0 && row-2<rows && column-1>=0 && column-1<columns){
                if(A[row-2][column-1]==1)
                    A[row-2][column-1]=0;
                else
                    A[row-2][column-1]=1;
            }
            //down
            if(row<rows && row>=0  && column-1>=0 && column-1<columns){
                if(A[row][column-1]==1)
                    A[row][column-1]=0;
                else
                    A[row][column-1]=1;
            }
            //left
            if(row-1>=0 && row-1<rows && column-2>=0 && columns-2<columns){
                if(A[row-1][column-2]==1)
                    A[row-1][column-2]=0;
                else
                    A[row-1][column-2]=1;
            }
            //right
            if(row-1>=0 && row-1<rows && column>=0 && column<columns){
                if(A[row-1][column]==1)
                    A[row-1][column]=0;
                else
                    A[row-1][column]=1;
            }
        }
        return A;
    }
}
