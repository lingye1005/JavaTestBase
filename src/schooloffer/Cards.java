package schooloffer;

/**
 * Created by caoxiaohong on 17/10/27.
 * 有一个整型数组A，代表数值不同的纸牌排成一条线。....
 * 动态规划
 * 规定:
 * (1)玩家a先拿，玩家B后拿.
 * (2)每个玩家每次只能拿走最左或最右的纸牌.
 * (3)玩家a和玩家b都绝顶聪明，他们总会采用最优策略。
 * (4)请返回最后获胜者的分数
 *
 * 关于本题一个比较重要的思想:就是code中的第二层for循环里面的a[i][j]和b[i][j]的表达式是怎么得来的.解释如下:
 * (11)对于选手a,在纸牌范围为[i...j]时,a[i][j]如何表达?
 *    如果选择A[i],则依赖于选手b的下一次在纸牌范围为[i+1...j]时,a尽量获取本次取牌的最大值且保证b获取下次取牌的尽量较小的值;
 *    如果选择A[j],则依赖于选手b的下一次在纸牌范围为[i...j-1]时,a尽量获取本次取牌的最大值且保证b获取下次取牌的尽量较小的值.
 * (22)对于选手b,在纸牌范围为[i...j]时,b[i][j]如何表达?
 *    作为后手,因为a是足够聪明的,所以b的取值已经被a限制了,b只能取a在[i...j]取完牌后,在a下次取牌前,取出a可以在下次取牌时两种选择状态中值最小的那个,因为a要获得较大的那个嘛
 *    如果a选择了A[i],那么b只能在纸牌范围为[i+1...j]中选择;
 *    如果a选择了A[j],那么b只能在纸牌范围为[i...j-1]中选择.
 */
public class Cards {
    public int cardGame(int[] A, int n) {
        // write code here
        int[][] a=new int[n][n];//玩家a , a[i][j]表示:纸牌为[i...j]时,玩家a可以获得的最多分数
        int[][] b=new int[n][n];//玩家b , b[i][j]表示:纸牌为[i...j]时,玩家b可以获得的最多分数

        for(int j=0;j<n;j++){
            a[j][j]=A[j];
            for(int i=j-1;i>=0;i--){
                a[i][j]=Math.max(A[i]+b[i+1][j],A[j]+b[i][j-1]);//来源于(11)说明
                b[i][j]=Math.min(a[i+1][j],a[i][j-1]);//来源于(22)说明
            }
        }
        return Math.max(a[0][n-1],b[0][n-1]);
    }

    //test <code></code>
    public static void main(String[] args) {
        Cards t=new Cards();
        int[] a={1,2,100,4};
        System.out.println(t.cardGame(a,4));
    }
}
