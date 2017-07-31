package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/19.
 * 给定int[] 数组price,
 * price[i]表示:第i天股票的价格.从第0天开始,到第(n-1)天结束.在此期间,你只能进行两次交易.一次交易包括买进卖出一次.且两次交易不能相交.即为第一次未卖出之前,不能进行第二次的买进.
 * 求最大的利润是多少.
 */
public class maxProfit {
    private int max=0; //记录最多利润
    public int maxProfit(int[] prices) {
        //一次交易
        int len=prices.length;
        if(len==0) return 0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(prices[j]-prices[i]>max)
                    max=prices[j]-prices[i];
            }
        }
        //两次交易:做(n-2)次划分.每次划分prices被分成2个数组,然后分别求这两个数组的最大利润,在求和.表示
        //n=len,数组1:0~i  \数组2:i+1~len-1
        for(int i=1;i<len-1;i++){
            int left=0,right=0;
            //数组1
            for(int j=0;j<i;j++){
                for(int k=j+1;k<=i;k++){
                    if(prices[k]-prices[j]>left)
                        left=prices[k]-prices[j];
                }
            }
            //数组2
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(prices[k]-prices[j]>right)
                        right=prices[k]-prices[j];
                }
            }
            if(left+right>max)
                max=left+right;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
