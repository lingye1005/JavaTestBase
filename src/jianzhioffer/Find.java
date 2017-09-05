package jianzhioffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/8/25.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序,每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        if(array==null ||array.length==0)
            return false;
        int rows=array.length;
        int columns=array[0].length;
        int i=0,j=columns-1;
        while(i<rows && j>=0){
            int temp=array[i][j];
            if(target==temp)
                return true;
            else if(target>temp){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        //int target=scanner.nextInt();
        //int rows=scanner.nextInt();
        //int columns=scanner.nextInt();
        int[][] arrays=new int[0][];
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                arrays[i][j]=scanner.nextInt();
//            }
//        }
        Find find=new Find();
        System.out.println(find.Find(4,new int[1][]));
    }
}
