package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/22 10:44
 * @ProjectName: JavaBaseTest
 * <拼凑面额></>
 */
public class TogetherMoney {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            long[] dp=new long[n+1];
            dp[0]=1;

            //dp[j]表示:可以凑合j块钱的方案数目.
            int[] money={1,5,10,20,50,100};


            for(int i=0;i<6;i++){
                for(int j=1;j<n+1;j++){
                    if(j>=money[i])
                        dp[j]+=dp[j-money[i]];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
