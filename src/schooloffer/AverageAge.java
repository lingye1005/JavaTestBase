package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/13.
 * 已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。
 从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(最后结果向上取整)。
 */
public class AverageAge {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int w,n;//总人数 && 第n年
        double y,x;//平均年龄 && 离职率

        while (scanner.hasNext()) {
            //w y x n
            w = scanner.nextInt();
            y = scanner.nextDouble();
            x = scanner.nextDouble();
            n = scanner.nextInt();

            while (n-- > 0) {
                //记得y是要+1的,老员工的年龄要增长啊...开始忘记了...
                double tmp = x * 21 + (1 - x) * (y + 1);
                y = tmp;
            }
            //168 26 0.40 78
            System.out.println((int) Math.ceil(y));
        }
    }
}
