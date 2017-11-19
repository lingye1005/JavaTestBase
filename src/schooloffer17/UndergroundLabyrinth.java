package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 10:47.
 * <地下迷宫></>
 */
public class UndergroundLabyrinth {
    public static void main(String[] args) {
        int n,m,p;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            p=scanner.nextInt();
            int[][] lab=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    lab[i][j]=scanner.nextInt();
            }

            //处理
            int[][] dp=new int[n][m];//存放能力值,dp[i][j]表示:到达点(i,j)时,最多剩余能力值
            dp[0][0]=p;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 && j==0)
                        continue;
                    else{
                        if(lab[i][j]==0)
                            dp[i][j]=-1;
                    }
                }
            }
            //初始化第一行
            for(int j=1;j<m && dp[0][j]!=-1;j++)
                dp[0][j]=dp[0][j-1]-1;
            //初始化第一列
            for(int i=1;i<n && dp[i][0]!=-1;i++)
                dp[i][0]=dp[i-1][0];
            //
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(dp[i][j]!=-1){

                    }
                }
            }
        }
    }
}

