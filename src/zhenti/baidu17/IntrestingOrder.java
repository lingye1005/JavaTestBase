package zhenti.baidu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/7 10:57
 * @ProjectName: JavaBaseTest
 * <有趣的排序></>
 */
public class IntrestingOrder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//N个整数。(N <= 50, 每个数的绝对值小于等于1000)
            int[] numbers=new int[n];
            for(int i=0;i<n;i++)
                numbers[i]=scanner.nextInt();
            int res=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(numbers[j]<numbers[i])
                        res++;
                }
            }
            System.out.println(res);
        }
    }
}
