package zhenti.wangyineitui18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 16:15
 * @ProjectName: JavaBaseTest
 * <等差数列></>
 * 100%
 */
public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();//n(2 ≤ n ≤ 50)
            int[] numbers=new int[n];
            for(int i=0;i<n;i++)
                numbers[i]=scanner.nextInt();
            if(n==2){
                System.out.println("Possible");
                continue;
            }
            Arrays.sort(numbers);//升序:和等差数列相反

            int disk=numbers[1]-numbers[0];
            //dist非法
            if(disk<0){
                System.out.println("Impossible");
                continue;
            }
            int i;
            for(i=1;i<n-1;i++){
                if(numbers[i+1]-numbers[i]!=disk)
                    break;
            }
            if(i==n-1)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }
}
