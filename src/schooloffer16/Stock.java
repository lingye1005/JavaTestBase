package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/21.
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，
 * 请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 */
public class Stock {
    public int maxProfit(int[] prices, int n) {
        // write code here
        //购买1次
        int max=helper(prices,0,n-1);

        //购买2次
        for(int m=1;m<n-2;m++){ //可以有这么多种划分为2次购买的方式
            int money1=helper(prices,0,m);
            int money2=helper(prices,m+1,n-1);
            if(max<money1+money2)
                max=money1+money2;
        }
        return max;
    }

    /**
     * 求数组prices[] ,从from(包含)到to(包含)区间:两个数最大差值
     * @param prices
     * @param from
     * @param to
     * @return
     */
    private static int helper(int[] prices,int from ,int to){
        int max=Integer.MIN_VALUE;
        for(int i=from;i<to;i++){
            int maxj=prices[i+1];
            for(int j=i+2;j<=to;j++){
                if(prices[j]>maxj)
                    maxj=prices[j];
            }
            if(maxj-prices[i]>max)
                max=maxj-prices[i];
        }
        return max;
    }

    //test <code></code>
    public static void main(String[] args) {
        Stock t=new Stock();
        int[] prices={426,178,250,77,475};
        System.out.println(t.maxProfit(prices,5));
    }
}
