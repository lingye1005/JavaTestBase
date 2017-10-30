package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/23.
 * 兰博教训提莫之后,然后和提莫讨论起约德尔人,谈起约德尔人,自然少不了一个人,那 就是黑默丁格...
 */
public class BatteryTttack {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] str=scanner.nextLine().split(" ");
            if(str.length<9){
                System.out.println("0x");
                continue;
            }
            int R,x1,y1,x2,y2,x3,y3,x0,y0;
            R=Integer.valueOf(str[0]);
            x1=Integer.valueOf(str[1]);
            y1=Integer.valueOf(str[2]);
            x2=Integer.valueOf(str[3]);
            y2=Integer.valueOf(str[4]);
            x3=Integer.valueOf(str[5]);
            y3=Integer.valueOf(str[6]);
            x0=Integer.valueOf(str[7]);
            y0=Integer.valueOf(str[8]);

            double z1=Math.sqrt(Math.pow(Math.abs(x1-x0),2)+Math.pow(Math.abs(y1-y0),2));
            double z2=Math.sqrt(Math.pow(Math.abs(x2-x0),2)+Math.pow(Math.abs(y2-y0),2));
            double z3=Math.sqrt(Math.pow(Math.abs(x3-x0),2)+Math.pow(Math.abs(y3-y0),2));

            int result=0;
            if(R>=z1)
                result++;
            if(R>=z2)
                result++;
            if(R>=z3)
                result++;
            System.out.println(result+"x");
        }
    }
}
