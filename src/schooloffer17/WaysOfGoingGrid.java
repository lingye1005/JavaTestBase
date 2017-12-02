package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 20:21
 * @ProjectName: JavaBaseTest
 * <网格走法数目></>
 */
public class WaysOfGoingGrid {
    public static void main(String[] args) {
        int x,y;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] xy=scanner.nextLine().trim().split(" ");//题目说有逗号,然而测试用例根本就没有...
            x=Integer.valueOf(xy[0]);
            y=Integer.valueOf(xy[1]);
            int[][] dp=new int[x+1][y+1];
            //初始化第1行
            for(int j=0;j<=y;j++)
                dp[0][j]=1;
            //初始化第1列
            for(int i=0;i<=x;i++)
                dp[i][0]=1;
            for(int i=1;i<=x;i++){
                for(int j=1;j<=y;j++)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
            System.out.println(dp[x][y]);
        }
    }
}
