package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/5 09:55.
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏...
 * <动态规划/>
 */
public class DevideFields {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;//取值范围: 1~75
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();

            //接下来的 n 行，每行包含 m 个 0-9 之间的数字
            int[][] values=new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                String[] tmp=scanner.nextLine().split("");
                for(int j=1;j<=m;j++){
                    values[i][j]=Integer.valueOf(tmp[j]);
                }
            }

            /**dp过程
             * dp[i][j]:第i行作为划分时的第4部分的第1行;
             *          第j列作为划分时的第4部分的第1列.
             */
            int[][] dp=new int[n+1][m+1];
            /**
             * 行索引:3<=i<=n-1
             * 列索引:3<=j<=m-1
             */
            //第3行dp初始化

            //第3列dp初始化

        }
    }

    /**
     *行初识化函数
     * @param values
     * @param jTo 第4部分第1列
     * @param n
     * @param m
     * @return
     */
    private  static int  rowsInit(int[][] values,int jTo,int n,int m){
        int min=Integer.MIN_VALUE;//最小值
        int counts=jTo/3;//最少几列值作为一部分
        /**左上角矩阵
         * 行:1~3
         * 列:1~jTo-1
         */
        int sum1=0,sum2=0,sum3=0;
        for(int i=1;i<jTo-n;i++){
            for(int j=i;j<i+counts;j++){
                sum1+=values[1][j];
                sum2+=values[2][j];
                sum3+=values[3][j];
            }
        }
        min=Math.max(sum1,sum2);
        min=Math.max(min,sum3);

        /**分别求:第(iTo)~m列的和
         *
         */
        sum1=0;//第1行
        sum2=0;//第2行
        sum3=0;//第3行

        for(int j=jTo;j<=m;j++){
            sum1+=values[1][j];
            sum2+=values[2][j];
            sum3+=values[3][j];
        }
        min=Math.min(min,sum1);
        min=Math.min(min,sum2);
        min=Math.min(min,sum3);

        /**右下角矩阵和
         * 行:4~n
         * 列:iTo~m
         */
        sum1=0;
        for(int i=4;i<=n;i++){
            for(int j=jTo;j<=m;j++){
                sum1+=values[i][j];
            }
        }
        min=Math.min(min,sum1);

        /**
         * 行:4~n
         * 列:1~(iTo-1)
         */
        for(int j=1;j<jTo-counts;j++){
            sum1=0;
            for(int k=j;k<j+counts;k++){
                for(int i=4;i<=n;i++){
                    sum1+=values[i][k];
                }
            }
            min=Math.max(min,sum1);
        }
        return min;
    }

    /**
     * 列初始化
     * @param values
     * @param iTo
     * @param n
     * @param m
     * @return
     */
    private int colsInit(int[][] values,int iTo,int n,int m){
        return 0;
    }
}
