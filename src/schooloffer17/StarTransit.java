package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/1.
 * 航天飞行器是一项复杂而又精密的仪器...
 * 大数处理
 */
public class StarTransit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long h; //h （1 <= h <= 10^18）
        while (scanner.hasNextLong()){
            h=scanner.nextLong();
            for(long i=(long)Math.sqrt(h);;i--){
                if(i+Math.pow(i,2)<=h){
                    System.out.println(i);
                    break;//10000 00000 00000 00000
                }
            }
        }
    }
}
