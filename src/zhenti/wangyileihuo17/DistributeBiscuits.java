package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 22:39
 * @ProjectName: JavaBaseTest
 * <分发饼干></>
 * 20%超时
 */
public class DistributeBiscuits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String k=scanner.nextLine();//数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
            int n=scanner.nextInt();
            scanner.nextLine();//换行
            long max,min;
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            for(int i=0;i<k.length();i++){
                if(k.charAt(i)=='X'){
                    //sb1.append("0");
                    sb2.append("9");
                }else{
                    sb1.append(k.charAt(i));
                    sb2.append(k.charAt(i));
                }
            }
            min=Long.valueOf(sb1.toString());
            max=Long.valueOf(sb2.toString());
            long res=0;
//            for(long i=min;i<=max;i++){
//                if(i%n==0)
//                    res++;
//            }
            //从min开始,找到第一个n的整数倍数
            if(min%n==0)
                min=min;
            else
                min+=n-min%n;
            res=(max-min+1)/n;
            System.out.println(res);
        }
    }
}
