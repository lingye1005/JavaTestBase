package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/13 15:48.
 * <最大对奇约数></>
 */
public class MaxOddApproximate {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNextInt()) {
            N = scanner.nextInt();//1 ≤ N ≤ 1000000000
            long res = 0;
            while (N > 0) {
                for (int i = 1; i <= N; i += 2) {
                    res += i;
                }
                N >>= 1;
            }
            System.out.println(res);
        }
    }
}
