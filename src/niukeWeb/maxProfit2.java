package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/20.
 * price[i]表示:第i天股票的价格.从第0天开始,到第(n-1)天结束.在此期间,交易次数不限.一次交易包括买进卖出一次.但手上不能有两支股票.即为第一次未卖出之前,不能进行第二次的买进.
 * 求最大的利润是多少.
 * 动态规划
 */
public class maxProfit2 {
    public int maxProfit(int[] prices) {
        int max=0;
        int len=prices.length;
        if(len==0 || len==1) return 0;

        for(int i=1;i<len;i++){
            if(prices[i]-prices[i-1]>0)
                max+=prices[i]-prices[i-1];
        }
        return max;
    }
}
