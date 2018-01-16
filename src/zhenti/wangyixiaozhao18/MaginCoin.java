package zhenti.wangyixiaozhao18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 09:35
 * @ProjectName: JavaBaseTest
 * <魔法币></> 30%
 */
public class MaginCoin {
    static StringBuilder sb=new StringBuilder();
    static String res;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
            sb.append("1");
            ite(n,1);
            System.out.println(res);
        }
    }
    private static void ite(int n,int count){
        if(n==count) {
            res=sb.toString();
            return;
        }

    }
}
