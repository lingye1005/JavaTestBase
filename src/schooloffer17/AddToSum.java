package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/17 15:45.
 * <数字和为sum的方法数></>
 * 01背包问题
 */
public class AddToSum {
    public static void main(String[] args) {
        int n,sum;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            sum=scanner.nextInt();
            int[] numbers=new int[n+1];
            for(int i=1;i<=n;i++)
                numbers[i]=scanner.nextInt();

            //dp处理
            long[][] dp=new long[n+1][sum+1];//dp[i][j]:前i个数字中,和为j的组合情况有多少种
            //显然:dp[i][0]=1;
            for(int i=0;i<n+1;i++)
                dp[i][0]=1;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(numbers[i]>j){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-numbers[i]];
                    }
                }
            }
            System.out.println(dp[n][sum]);
        }
    }
}
