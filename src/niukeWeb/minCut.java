package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/15.
 * 给定字符串s,进行切割,使得各个字串为回文串,且要求切割次数最少.
 * 求这个最少次数是多少,并返回
 */
public class minCut {
    public int minCutT(String s) {
        if(s==null || s.length()<2){
            return 0;
        }
        int len=s.length(); //字符串长度
        boolean[][] isPalindrom=new boolean[len][len];//记录字串是否为回文
        int[] cunNum=new int[len];//记录每个节点处的最少分割数目

        for(int i=0;i<len;i++){
            cunNum[i]=i;
            for(int j=i;j>-1;j--){
                //如果当前字串为回文序列:isPlain[j+1][i-1])画图可理解:i和j处字符相同 且 j+1 到i-1 这部分字符之前已经判定过为回文串.
                if(s.charAt(i)==s.charAt(j) && (i-j<2 || isPalindrom[j+1][i-1])){
                    isPalindrom[j][i]=true;
                    if(j==0)
                        cunNum[i]=0;
                    else
                        cunNum[i]=Math.min(cunNum[i],cunNum[j-1]+1);
                }
            }
        }
        return cunNum[len-1];
    }

    public static void main(String[] args) {
        minCut minCut=new minCut();
        String str="aabc";
        System.out.println(minCut.minCutT(str));
    }
}
