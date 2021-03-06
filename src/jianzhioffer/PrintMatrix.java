package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)
            return result;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int up=0,down=rows-1;
        int left=0,right=columns-1;
        while(up<=down && left<=right){
            //up
            int tmp1=left;
            while(up<=down && left<=right){
                result.add(matrix[up][left++]);
            }
            up++;
            left=tmp1;
            //right
            int tmp2=up;
            while(up<=down && left<=right){
                result.add(matrix[up++][right]);
            }
            right--;
            up=tmp2;
            //down
            int tmp3=right;
            while(up<=down && left<=right){
                result.add(matrix[down][right--]);
            }
            down--;
            right=tmp3;
            //left
            int tmp4=down;
            while(up<=down && left<=right){
                result.add(matrix[down--][left]);
            }
            left++;
            down=tmp4;
        }
        return result;
    }

    //test code
    public static void main(String[] args) {
        PrintMatrix t=new PrintMatrix();
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] b={{1},{2},{3},{4},{5}};
        ArrayList<Integer>  out=t.printMatrix(a);
        for(int i:out){
            System.out.print(i+",");
        }
    }
}
