package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/3.
 * 数组顺时针选择90度
 * 第0行作为第n-1列;
 * 第1行作为第n-2列;....
 */
public class rotate {
    public void rotate(int[][] matrix) {
        int rows=matrix.length;
        int columns=matrix[0].length;

        int[][] re=new int[rows][columns];
        int right=columns-1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                re[j][right]=matrix[i][j];
            }
            right--;
        }
        System.arraycopy(re,0,matrix,0,rows);
    }

    public static void main(String[] args) {
        rotate t=new rotate();
        int[][] a=new int[3][3];
        int num=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                a[i][j]=num++;
        }
        t.rotate(a);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
