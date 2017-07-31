package niukeWeb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by caoxiaohong on 17/6/25.
 * 给定mn矩阵,如果存在0元素,则将其所在的行和列均置为0
 * 算法:一次遍历数组,记录0位置下标.
 *     二次遍历数组,改值
 */
public class setZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)
            return;
        HashMap<Integer,String> index=new HashMap<Integer, String>();
        int rows=matrix.length;
        int columns=matrix[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]==0)
                    index.put(count++,Integer.toString(i)+","+Integer.toString(j));
            }
        }
        //存在0值,则赋值
        if(index!=null && index.size()!=0){
            Iterator a=index.entrySet().iterator();
            while(a.hasNext()){
                Map.Entry entry=(Map.Entry)a.next();
                String rowandcolumn=entry.getValue().toString();
                String[] temp=rowandcolumn.split(",");
                String row=temp[0];
                String column=temp[1];
                for(int i=0;i<columns;i++){
                    matrix[Integer.parseInt(row)][i]=0;
                }
                for(int j=0;j<rows;j++){
                    matrix[j][Integer.parseInt(column)]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        setZeroes test=new setZeroes();
        int[][] a={
                {3,5,5,6,9,1,4,5,0,5},
                {2,7,9,5,9,5,4,9,6,8},
                {6,0,7,8,1,0,1,6,8,1},
                {7,2,6,5,8,5,6,5,0,6},
                {2,3,3,1,0,4,6,5,3,5},
                {5,9,7,3,8,8,5,1,4,3},
                {2,4,7,9,9,8,4,7,3,7},
                {3,5,2,8,8,2,2,4,9,8}};

        test.setZeroes(a);
        for(int i=0;i<8;i++){
            for(int j=0;j<10;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
    }
}
