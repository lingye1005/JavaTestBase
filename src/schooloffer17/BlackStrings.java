package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/12 12:50.
 * <暗黑的字符串></>
 */
public class BlackStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNext()){
            N=scanner.nextInt();//1 ≤ n ≤ 30
            long[] dp=new long[N+1];
            dp[1]=3;
            dp[2]=9;
            for(int i=3;i<=N;i++)
                dp[i]=2*dp[i-1]+dp[i-2];
            System.out.println(dp[N]);
        }
    }
}
