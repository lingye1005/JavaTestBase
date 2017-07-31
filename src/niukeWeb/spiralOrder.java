package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/1.
 * 给定数组,返回其螺旋的表达形式
 */
public class spiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();//保存结果
        if(matrix==null || matrix.length==0)
            return result;
        int up=0,down=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        //一行
        if(up==down){
            for(int i=left;i<=right;i++){
                result.add(matrix[0][i]);
            }
            return result;
        }
        //一列
        if(left==right){
            for(int i=up;i<=down;i++){
                result.add(matrix[i][0]);
            }
            return result;
        }
        //多行多列
        while(up<=down && right>=left){
            for(int i=left;i<right;i++){
                result.add(matrix[up][i]);
            }
            for(int i=up;i<down;i++){
                result.add(matrix[i][right]);
            }
            for(int i=right;i>left;i--){
                result.add(matrix[down][i]);
            }
            for(int i=down;i>up;i--){
                result.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        if(matrix.length%2!=0 && matrix[0].length%2!=0){
            result.add(matrix[matrix.length/2][matrix.length/2]);
        }
        return result;
    }

    public static void main(String[] args) {
        spiralOrder test=new spiralOrder();
        int[][] a=new int[2][2];
        int[][] b=new int[3][3];
        int[][] c=new int[1][2];
        int[][] d=new int[1][3];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                a[i][j]=i+j;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                b[i][j]=i+j;
            }
        }
        c[0][0]=1;
        c[0][1]=2;
        d[0][0]=6;
        d[0][1]=9;
        d[0][2]=7;

        ArrayList<Integer> a1=test.spiralOrder(a);
        ArrayList<Integer> b1=test.spiralOrder(b);
        ArrayList<Integer> c1=test.spiralOrder(c);
        ArrayList<Integer> d1=test.spiralOrder(d);

        for(int i:a1){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("------------");

        for(int i:b1){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("---------");
        for(int i:c1){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("----------");
        for(int i:d1){
            System.out.print(i+",");
        }
    }
}
