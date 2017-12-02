package schooloffer17;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 16:01
 * @ProjectName: JavaBaseTest
 * <平方根></>
 */
public class SquireRoot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double n;
        int m;
        while (scanner.hasNext()){
            n=scanner.nextDouble();
            m=scanner.nextInt();
            double res=n;
            while (--m>0){
                res+=Math.sqrt(n);
                n=Math.sqrt(n);
            }
            /**保留两位小数,四舍五入
             * 注意通用格式:#.00保留2位小数,#.000保留3位小数...也就是小数点后面几个0则保留几位小数
             */
            DecimalFormat  df= new DecimalFormat("#.00");
            System.out.println(df.format(res));

            //下面几种输出格式是作为此题目的补充知识,再次巩固一下
            /**
             * 保留两位小数,不四舍五入
             */
            System.out.println(String.format("%.2f", res-0.005));
            /**
             * 保留三位小数,不四舍五入
             */
            System.out.println(String.format("%.3f",res-0.0005));
            /**
             * 小数不做处理,与上面形成参照
             */
            System.out.println(res);
        }
    }
}
