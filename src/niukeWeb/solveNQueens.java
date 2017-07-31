package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/3.
 * n皇后问题.
 * 棋盘问题,常用回溯算法
 */
public class solveNQueens {
    ArrayList<String[]> result=new ArrayList<String[]>();//记录结果
    int[] state;  //state[i]=k 表示:第i行皇后的列位置为k
    //static int count=0;  count表示有多少种解决方案
    public ArrayList<String[]> solveNQueens(int n) {

        //为n个皇后的位置设置初始值-1
        state=new int[n];
        for(int i=0;i<n;i++)
            state[i]=-1;
        //辅助函数
        helper(state,0); //从第0行开始查找
        return result;
    }
    void helper(int[] state,int row){ //放置第row的皇后
         int len=state.length;
         if(row==len){  //递归到达最后一行,说明此次所有的皇后均已经找到合适的安放位置
             String[] temp=new String[len];
             //保存当前解决方案的皇后分布
             for(int i=0;i<len;i++){
                 StringBuilder levelStr=new StringBuilder();
                 for(int j=0;j<len;j++){
                     if(j==state[i])
                         levelStr.append("Q");
                     else
                         levelStr.append(".");
                 }
                 temp[i]=levelStr.toString();
             }
             //count++;
             result.add(temp);
             return;
         }
        for(int i=0;i<len;i++){ //查找合法位置
            if(isValid(state,row,i)){
                state[row]=i;
                helper(state,row+1);
                //state[row]=-1;
            }
        }
    }
    boolean isValid(int[] state,int row,int column){
        for(int i=0;i<row;i++){
            if(state[i]==column || Math.abs(row-i)==Math.abs(column-state[i]))  //列相同 or 在对角线上 :就这两种相邻情况
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens test=new solveNQueens();
        ArrayList<String[]> a=test.solveNQueens(4);
        for(String[] i:a){
            for(String j:i){
                System.out.println(j+",");
            }
            System.out.println();
        }
        //System.out.println(count);
    }
}
