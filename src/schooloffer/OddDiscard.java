package schooloffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/20.
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 */
public class OddDiscard {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<=n;i++){
                list.add(i);
            }

            //循环删除
            while (list.size()>1){
                //注意:不能一边遍历一边删除,这样size一直在改变,奇偶位就不定了
                for(int i=0;i<list.size();i++){
                    if((i+1)%2==1)
                        list.set(i,-1);
                }
                //统一删除-1
                for(int i=0;i<list.size();i++){
                    if(list.get(i)==-1)
                        list.remove(i);
                }
            }
            System.out.println(list.get(0));
        }
    }
}
