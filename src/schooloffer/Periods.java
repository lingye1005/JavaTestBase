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
        ArrayList<Integer> position=new ArrayList<Integer>();//记录出现s.charAt(0)的元素的位置
        for(int i=n-1;i>0;i--){
            if(s.charAt(i)==s.charAt(0))
                position.add(i);
        }
        int[] sums=new int[n];
        for(int i=0;i<position.size();i++){
            for(int k1=0,k2=position.get(i);k1<position.get(i) && k2<n;k1++,k2++){
                if(s.charAt(k1)==s.charAt(k2)){
                    /**如果之前sums[k2]之前已经被赋值过,则此处不会更新值.
                     * 否则,sums[k2]没有被赋值过,初始值为0,此时会被重新赋值为position.get(i);
                     * 这一步的思想比较重要
                     */
                    sums[k2]=sums[k2]>position.get(i)?sums[k2]:position.get(i);
                }else{
                    break;
                }
            }
        }
        //求和
        for(int i=0;i<n;i++)
            sum+=sums[i];
        return sum;
    }


    //test <code></code>
    public static void main(String[] args) {
        Periods t=new Periods();
        String a="babababa";
        System.out.println(t.getLongest(8,a));
    }
}
