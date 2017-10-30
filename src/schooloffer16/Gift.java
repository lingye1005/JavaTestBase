package schooloffer16;

import java.util.HashMap;

/**
 * Created by caoxiaohong on 17/9/20.
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 若没有金额超过总数的一半，返回0。
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int mid=n%2==0?n/2:n/2+1;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<gifts.length;i++){
            if(map.containsKey(gifts[i])){
                map.put(gifts[i],map.get(gifts[i])+1);
                if(map.get(gifts[i])==mid)
                    return gifts[i];
            }else{
                map.put(gifts[i],1);
            }
        }
        return 0;
    }
}
