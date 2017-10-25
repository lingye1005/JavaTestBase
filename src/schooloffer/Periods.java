package schooloffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/23.
 * 重复词
 * 对于两个字符串B和C，我们定义BC为将C接在B的后面形成的新串。一个字符串P是串A的前缀，....
 * 4个概念:
 * (1)前缀:A＝PB,则P为A的前缀,且B可以为空串.
 * (2)真前缀:A＝PB,则P为A的前缀,但B不可以为空串.
 * (3)重复词:A=PB,P为A的真前缀,且A是PP的前缀.故: P长度<A长度 且 PP长度>=A长度(P长度>=1/2A长度)
 * (4)最长重复词:重复词中长度最大的.
 *
 */
public class Periods {
    public  long getLongest(int n, String s) {
        long sum=0;
        char[] chars=s.toCharArray();
        for(int i=1;i<n;i++){
            sum+=getMaxRepeatWords(chars,i,i+1);//子串范围:0~i,包含边界
        }
        return  sum;
    }
    private  int getMaxRepeatWords(char[] chars,int to,int n){
        int from=n%2==0?n/2-1:n/2;
        ArrayList<Integer> pos=new ArrayList<Integer>();
        for(int i=to-1;i>=from;i--){
            if(chars[0]==chars[i+1])//划分:0~i,i+1~to两个范围
                pos.add(i+1);
        }
        if(pos.size()==0)
            return 0;
        for(int i:pos){
            int idx1=0,idx2=i;
            for(;idx2<n;idx1++,idx2++){
                if(chars[idx1]!=chars[idx2])
                   break;
            }
            if(idx2==n)
                return i;
        }
        return to;
    }

    //test <code></code>
    public static void main(String[] args) {
        Periods t=new Periods();
        System.out.println(t.getLongest(8,"babababa"));
    }
}
