package zhenti.wangyileihuo17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 18:00
 * @ProjectName: JavaBaseTest
 * <双核处理></>
 * 50%
 */
public class DoubleCPU {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//n(1 ≤ n ≤ 50)
            int[] times=new int[n];//length[i](1024 ≤ length[i] ≤ 4194304)
            for(int i=0;i<n;i++){
                times[i]=scanner.nextInt();
                times[i]>>=10;//右移10位
            }
            if(n==1){
                System.out.println(times[0]*1024);
                continue;
            }
            Arrays.sort(times);
            int a=times[n-1],b=times[n-2];
            for(int i=n-3;i>=0;i--){
                if(b<=a){
                    b+=times[i];
                }else{
                    a+=times[i];
                }
            }
            System.out.println(a>b?a<<10:b<<10);
        }
    }
}
