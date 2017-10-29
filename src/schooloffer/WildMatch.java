package schooloffer;

/**
 * Created by caoxiaohong on 17/10/27.
 * 对于字符串A，其中绝对不含有字符’.’和’*’。再给定字符串B，其中可以含有’.’或’*’，....
 * 动态规划
 */
public class WildMatch {
    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // write code here
        boolean[][] dynamic = new boolean[lena + 1][lenb + 1];
        dynamic[0][0] = true;

        for (int i = 1; i < lena + 1; i++) {
            for (int j = 1; j < lenb + 1; j++) {
                if (B.charAt(j - 1) == '*') {
                    dynamic[i][j] = dynamic[i - 1][j] || dynamic[i][j-1];//添加1个字符 || 添加0个字符
                } else if (B.charAt(j - 1) == '.') {
                    dynamic[i][j] = dynamic[i - 1][j - 1];
                } else {
                    dynamic[i][j] = A.charAt(i - 1) == B.charAt(j - 1) && dynamic[i - 1][j - 1];
                }
            }
        }
        return dynamic[lena][lenb];
    }

    public static void main(String[] args) {
        WildMatch t=new WildMatch();
        System.out.println(t.chkWildMatch("abcd",4,".*",2));
    }
}
