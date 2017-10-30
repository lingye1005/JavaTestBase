package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/9.
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会......
 */
public class CalculateMax {
    public int calculateMax(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int once=getMax(prices,0,prices.length-1);
        int second=Integer.MIN_VALUE;//一次最大值,二次最大值

        //有2次机会:长度必须>=4
        if(prices.length>=4){
            int rearFrom=2;
            int left=0,right=0;
            while(rearFrom<prices.length-1){
                left=getMax(prices,0,rearFrom-1);
                right=getMax(prices,rearFrom,prices.length-1);
                if(left+right>second)
                    second=left+right;
                rearFrom++;
            }
        }
        if(once <=0 && second<=0)
            return 0;
        return once>second?once:second;
    }
    private int getMax(int[] prices,int from,int to){
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

    public static void main(String[] args) {
        CalculateMax t=new CalculateMax();
        int[] a={3,8,5,1,7,8};
        System.out.println(t.calculateMax(a));
    }
}
