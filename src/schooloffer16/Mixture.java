package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/13.
 * 对于三个字符串A，B，C。我们称C由A和B交错组成当且仅当C包含且仅包含A，B中所有字符，且对应的顺序不改变。请编写一个高效算法，判断C串是否由A和B交错组成。...
 * 算法思想:dp思想
 */
public class Mixture {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        if(n+m!=v)
            return false;
        boolean[][] res=new boolean[n+1][m+1];
        res[0][0]=true;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(res[i][j]){
                    if(i<n && A.charAt(i)==C.charAt(i+j))
                        res[i+1][j]=true;
                    if(j<m && B.charAt(j)==C.charAt(i+j))
                        res[i][j+1]=true;
                }
            }
        }
        return res[n][m];
    }

    public static void main(String[] args) {
        Mixture t=new Mixture();
        String A="bcbccabccacccbcac";
        String B="abbbacaabccbccaaaabbcbcbaaacccbaaba";
        String C="babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac";
        System.out.println(t.chkMixture(A,17,B,35,C,52));
    }
}
