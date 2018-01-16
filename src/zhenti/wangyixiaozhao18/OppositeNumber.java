package zhenti.wangyixiaozhao18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 09:40
 * @ProjectName: JavaBaseTest
 * <相反数></>
 * 100%
 */
public class OppositeNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//(1 ≤ n ≤ 10^5)
            StringBuilder sb=new StringBuilder(String.valueOf(n));
            sb=sb.reverse();
            int opp=Integer.valueOf(sb.toString());
            //输出结果
            System.out.println(n+opp);
        }
    }
}
