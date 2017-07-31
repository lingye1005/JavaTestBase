package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/3.
 * n皇后问题
 * 求最多有多少种解法
 */
public class totalNQueens {
    int[] state;  //state[i]=k 表示:第i行皇后的列位置为k
    int count=0;//记录解决方案的数量

    public int totalNQueens(int n) {
        state=new int[n];
        for(int i=0;i<n;i++)
            state[i]=-1;
        helper(state,0);
        return  count;
    }
    void helper(int[] state,int row){  //判定第row行是否找到合适位置安放皇后
        int n=state.length;
        if(n==row){  //从第0行到第(n-1)行已经找到一种解决方案
            count++;
            return ;
        }
        for(int i=0;i<n;i++) {  //为第row行的皇后寻找合适的列,列值从0到n-1
            if (isValid(state,row,i)) { //安放第row行的皇后{
                state[row] = i;
                helper(state, row + 1); //递归到下一行,继续查找
            }
        }
    }
    boolean isValid(int[] state,int row,int column){
        for(int i=0;i<row;i++){
            if(state[i]==column || Math.abs(row-i)==Math.abs(column-state[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        totalNQueens test=new totalNQueens();
        System.out.println(test.totalNQueens(4));
    }
}
