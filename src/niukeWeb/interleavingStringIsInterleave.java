package niukeWeb;


/**
 * Created by caoxiaohong on 17/7/26.
 * 给定3个字符串,判定s3是否是由s2和s1相互插入组成的,并且s2和s3字符都保持相对位置不变
 * 动态规划
 * 这里的做法是说将S1和S2展开成一个矩阵，假设长度分别为n，m，那么就是构建一个n*m的DP矩阵，使用DP的方式来进行判断.
 *
 */
public class interleavingStringIsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3)
            return false;
        boolean[][] dp=new boolean[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0){
                    dp[i][j]=dp[i][j-1] & (s2.charAt(j-1)==s3.charAt(i+j-1));
                }else if(j==0){
                    dp[i][j]=dp[i-1][j] & (s1.charAt(i-1)==s3.charAt(i+j-1));
                }else{
                    dp[i][j]=(dp[i-1][j] & s1.charAt(i-1)==s3.charAt(i+j-1)) | (dp[i][j-1] & s2.charAt(j-1)==s3.charAt(i+j-1) );
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        interleavingStringIsInterleave test=new interleavingStringIsInterleave();
        String  s1 ="a";
        String  s2 ="b";
        System.out.println(test.isInterleave(s1,s2,"ab"));
    }
}
