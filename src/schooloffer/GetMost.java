package schooloffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/14.
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物....
 * 求:从左上角到右下角的最大和
 * 要求:全过程中:只能向右或者向下走
 */
public class GetMost {
    public int getMost(int[][] board) {
        // write code here
        int[][] gift= Arrays.copyOf(board,board.length);
        //初始化第1行,第1列
        for(int i=1;i<6;i++){
            gift[0][i]+=board[0][i-1];
            gift[i][0]+=board[i-1][0];
        }
        for(int i=1;i<6;i++){
            for(int j=1;j<6;j++){
                gift[i][j]+=gift[i-1][j]>=gift[i][j-1]?gift[i-1][j]:gift[i][j-1];
            }
        }
        return gift[5][5];
    }


    //test code
    public static void main(String[] args) {
        int[][] a={{426,306,641,372,477,409}, {223,172,327,586,363,553},{292,645,248,316,711,295},
                   {127,192,495,208,547,175},{131,448,178,264,207,676},{655,407,309,358,246,714}};
        System.out.println(new GetMost().getMost(a));
    }
}
