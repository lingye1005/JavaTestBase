package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/28.
 *
 */

public class uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;
        int rows=obstacleGrid.length;
        int columns=obstacleGrid[0].length;
        if(obstacleGrid[rows-1][columns-1]==1)
            return 0;
        int[][] result=new int[rows][columns];
        for(int i=0;i<columns;i++){//第0行
            if(obstacleGrid[0][i]==1){
                result[0][i]=0;
                break;
            }
            for(int j=0;j<i;j++){
                if(obstacleGrid[0][j]==1){
                    result[0][i]=0;
                    break;
                }
            }
            result[0][i]=1;
        }
        for(int i=0;i<rows;i++){ //第0列
            if(obstacleGrid[i][0]==1){
                result[i][0]=0;
                break;
            }
            for(int j=0;j<i;j++){
                if(obstacleGrid[i][0]==1){
                    result[i][0]=0;
                    break;
                }
            }
            result[i][0]=1;
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                if(obstacleGrid[i-1][j]!=1)
                    result[i][j]+=result[i-1][j];
                if(obstacleGrid[i][j-1]!=1)
                    result[i][j]+=result[i][j-1];
            }
        }
        return result[rows-1][columns-1];
    }
}
