package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/27.
 * 对于两个字符串，请设计一个高效算法，求他们的最长公共子序列的长度，这里的最长公共子序列定义为有两个序列U1,U2,U3...Un和V1,V2,V3...Vn,其中Ui&ltUi+1，Vi&ltVi+1。且A[Ui] == B[Vi]。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * 空间换时间
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        //dp过程
        int[][] dp=new int[n+1][m+1];//为什么列和行都多出一列,表示子串长度为0,即为子串为空串时,公共子串的长度,显然这一行和列的值均为0
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    if(A.charAt(i-1)==B.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LCS t=new LCS();
        System.out.println(t.findLCS("ABC",3,"ABD",3));
    }
}
