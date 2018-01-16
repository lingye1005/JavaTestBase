package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 19:23
 * @ProjectName: JavaBaseTest
 * <魔力手环></>
 * 60% 超时,大数据不过
 */
public class MagicBangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,k;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),
            k=scanner.nextInt();
            int[] numbers=new int[n];
            for(int i=0;i<n;i++)
                numbers[i]=scanner.nextInt();
            //处理
            for(int count=0;count<k;count++){
                int tmp0=numbers[0];//保存
                for(int i=0;i<n;i++){
                    if(i==n-1){
                        numbers[i]=(tmp0+numbers[i])%100;
                    }else{
                        numbers[i]=(numbers[i]+numbers[i+1])%100;
                    }
                }
            }
            //输出
            for(int i=0;i<n-1;i++){
                System.out.print(numbers[i]+" ");
            }
            System.out.println(numbers[n-1]);
        }
    }
}
