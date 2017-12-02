package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 16:51
 * @ProjectName: JavaBaseTest
 * <袋鼠过河></>
 */
public class Kangaroo {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//1 ≤ N ≤ 10000
            int[] skip=new int[n];
            for(int i=0;i<n;i++){
                skip[i]=scanner.nextInt();
            }
            int[] dp=new int[n+1];
            //初始化
            dp[0]=0;
            for(int i=1;i<=n;i++){
                if(i<n && skip[i]!=0 && i<=skip[0]){
                    dp[i]=1;
                }else{
                    dp[i]=Integer.MAX_VALUE/2;//不能到达
                }
            }
            //dp过程
            for(int i=0;i<n;i++){
                if(i<n && skip[i]==0)
                    continue;
               for(int j=i;j<=n;j++){
                   if(i<n && i+skip[i]>=j && j<n && skip[j]!=0){
                       dp[j]=Math.min(dp[j],dp[i]+1);
                   }
                   if(j==n && i<n && i+skip[i]>=j){
                       dp[j]=Math.min(dp[j],dp[i]+1);
                   }
               }
            }
            //输出
            System.out.println(dp[n]==Integer.MAX_VALUE/2?-1:dp[n]);
        }
    }
}
