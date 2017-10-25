package schooloffer;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/17.
 * 有一个投篮游戏。球场有p个篮筐，编号为0，1...，p-1。每个篮筐下有个袋子，每个袋子最多装一个篮球。有n个篮球，每个球编号xi 。
 * 规则是将数字为xi 的篮球投到xi 除p的余数为编号的袋里。若袋里已有篮球则球弹出游戏结束输出i，否则重复至所有球都投完。输出-1。问游戏最终的输出是什么？
 */
public class BasketballGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int P,N;
        while (scanner.hasNext()){
            P=scanner.nextInt();
            N=scanner.nextInt();

            HashSet<Integer> record=new HashSet<Integer>();
            int[] baskNum=new int[N+1];
            for(int i=1;i<=N;i++){
                baskNum[i]=scanner.nextInt();//球号xi
            }
            int i;
            for(i=1;i<=N;i++){
                int remainer=baskNum[i]%P;
                if(record.contains(remainer)){
                    System.out.println(i);
                    break;
                }else{
                    record.add(remainer);
                }
            }
            if(i==N+1)
                System.out.println(-1);
        }
    }
}
