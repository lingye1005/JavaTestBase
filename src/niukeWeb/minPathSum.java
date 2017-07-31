package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/28.
 * 动态规划
 * 给定m*n的表格,每个格子里面有一个非负的数字,从其左上角走到右下角,路径上格子数相加最小的路径.并返回路径和
 * 思想:每次只能向下或者向右移动,每次选择一个其中的较小的值即可.
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int rows=grid.length; //行数
        int columns=grid[0].length; //列数
        int[][] result=grid;
        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i==0 && j==0){
                    result[0][0]=grid[0][0];
                }else if(i==0){
                    result[0][j]+=result[0][j-1];
                }else if(j==0){
                    result[i][0]+=result[i-1][0];
                }else{
                    result[i][j]+=Math.min(result[i][j-1],result[i-1][j]);
                }
            }
        }
        return result[rows-1][columns-1];
    }
}
