package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/7 15:14.
 * <洗牌>
 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程...
 * </洗牌>
 */
public class Shuffle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T,n,k;
        while (scanner.hasNext()){
            T=scanner.nextInt();//T ≤ 100
            while (T-->0){
                n=scanner.nextInt();//1 ≤ n,k ≤ 100
                k=scanner.nextInt();
                int[] cards=new int[2*n];
                for(int i=0;i<2*n;i++)
                    cards[i]=scanner.nextInt();//1 ≤ ai ≤ 1000000000
                while (k-->0)
                    helper(cards,2*n);
                //输出
                for(int i=0;i<2*n;i++){
                    if(i==2*n-1)
                        System.out.println(cards[i]);
                    else
                        System.out.print(cards[i]+" ");
                }
            }
        }
    }

    private static void helper(int[] cards,int n){
        int[] pre= Arrays.copyOfRange(cards,0,n/2);
        int[] rear=Arrays.copyOfRange(cards,n/2,n);
        int idx=0;
        for(int i=0;i<n/2;i++){
            cards[idx++]=pre[i];
            cards[idx++]=rear[i];
        }
    }
}
