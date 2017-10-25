package schooloffer;

/**
 * Created by caoxiaohong on 17/9/28.
 */
public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int[][] dp=new int[n][m];
        //行初始化
        for(int j=0;j<m;j++){
            if(A.charAt(0)==B.charAt(j))
                dp[0][j]=1;
        }
        //列初始化
        for(int i=0;i<n;i++){
            if(B.charAt(0)==A.charAt(i))
                dp[i][0]=1;
        }
        //dp过程
        int max=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        LongestSubstring t=new LongestSubstring();
        System.out.println(t.findLongest("1AB2345CD",9,"12345EF",7));
    }
}
