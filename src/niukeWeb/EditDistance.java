package niukeWeb;

/**
 * Created by caoxiaohong on 17/8/18.
 * 题意:从单词word1转为单词word2,需要花费的最少次数操作是多少?
 * 操作类型3种:插入,删除,替换
 * 注意:每次只能插入,删除,替换一个字符.称之为一次操作.
 * 算法思想:二维动态规划
 * d(i,j)表示:原串子串word1(0,i)转为目的子串word2(0,j)需要的最小步数
 * d(0,0)~d(0,j):1,2,3...
 * d(0,0)~d(i,0):1,2,3...
 * 求解过程:求d(i,j),这和三个数字相关,d(i-1,j-1),d(i,j-1),d(i-1,j)
 * 1,如果word1(i-1)和word2(j-1)相同,则d(i,j)=d(i-1,j-1);
 * 2,如果word1(i-1)和word2(j-1)不相同,则d(i,j)=min(d(i-1,j-1)+1,d(i-1,j)+1,d(i,j-1)+1);
 *   含义说明:d(i-1,j-1)+1:将word1(i)替换为word2(j)
 *       d(i-1,j)+1:在word1(i)后面添加一个word2(j)
 *       d(i,j-1)+1:将word1(i)删除
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word2.equals(""))
            return word1.length();
        int rows=word1.length()+1;
        int columns=word2.length()+1;
        int[][] dp=new int[rows][columns];
        //初始化第一列
        for(int i=0;i<rows;i++){
            dp[i][0]=i;
        }
        //初始化第一行
        for(int j=0;j<columns;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                //如果word1(i-1)和word2(j-1)相同
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{//如果word1(i-1)和word2(j-1)不相同
                    int len1=dp[i-1][j-1]+1;
                    int len2=dp[i-1][j]+1;
                    int len3=dp[i][j-1]+1;
                    int smaller=len1<len2?len1:len2;
                    int smallest=len3<smaller?len3:smaller;
                    dp[i][j]=smallest;
                }
            }
        }
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args) {
        EditDistance test=new EditDistance();
        System.out.println(test.minDistance("a","a"));
    }
}
