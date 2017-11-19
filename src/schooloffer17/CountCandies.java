package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/14 16:54.
 * <计算糖果></>
 */
public class CountCandies {
    public static void main(String[] args) {
        int a,b,c,d;//范围:[-30,30]
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            a=scanner.nextInt();//A-B
            b=scanner.nextInt();//B-C
            c=scanner.nextInt();//A+B
            d=scanner.nextInt();//B+C
            int A=(a+c)>>1;
            int B=(b+d)>>1;
            int C=(d-b)>>1;
            //检测合法性
            if(A-B==a && B-C==b && A+B==c && B+C==d){
                System.out.println(A+" "+B+" "+C);
            }else{
                System.out.println("No");
            }
        }
    }
}
