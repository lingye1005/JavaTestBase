package schooloffer;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/15.
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，
 * 在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 * 算法实质:从左上角走到右下角:一种有阻碍方案数目m,一种没阻碍方案数目n.
 * 返回概率:1-m/n
 */
public class MushroomMatrix {
    //有无蘑菇
    static byte[][] has=new byte[21][21];
    //格子
    static float[][] dp=new float[21][21];

    public static void main(String[] args) {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner br=new Scanner(System.in);
        try{
            int N,M,K;
            while (br.hasNext()){
                String str=br.nextLine();
                String[] nmk=str.split(" ");
                N=Integer.valueOf(nmk[0]);//N行
                M=Integer.valueOf(nmk[1]);//M列
                K=Integer.valueOf(nmk[2]);// K个位置有蘑菇

                for(int i=0;i<K;i++){
                    String tmp=br.nextLine();
                    String[] mNum=tmp.split(" ");
                    int x=Integer.valueOf(mNum[0])-1;
                    int y=Integer.valueOf(mNum[1])-1;
                    has[x][y]=1;
                }

                //调用主算法
                float rate1=getRate(N,M);
                DecimalFormat df=new DecimalFormat("######0.00");
                System.out.println(df.format(rate1));
            }
        }catch (Exception e){
            System.out.println(-1);
        }
    }
    /**
     * m*n矩阵中,有阻碍位置block
     * 发现一直ac不了,原来要算概率,百度为啥这么喜欢概率问题
     * @param n
     * @param m
     * @return
     */
    private static float getRate(int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(has[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0)
                    dp[i][j]=1;
                else if(i==0 )
                    dp[i][j]=dp[i][j-1]*0.5f;
                else if(j==0)
                    dp[i][j]=dp[i-1][j]*0.5f;

                else if(i>0 && j>0 && i<n-1 && j<m-1)
                    dp[i][j]=dp[i-1][j]*0.5f+dp[i][j-1]*0.5f;

                else if(i==n-1 && j<m-1)
                    dp[i][j]=dp[i-1][j]*0.5f+dp[i][j-1];

                else if(j==m-1 && i<n-1)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]*0.5f;

                else if(i==n-1 && j==m-1)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
