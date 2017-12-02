package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 16:28
 * @ProjectName: JavaBaseTest
 * <进制均值></>
 */
public class CarryAvg {
    public static void main(String[] args) {
        long A;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            A=scanner.nextInt();
            long sum=0;
            for(int i=2;i<A;i++){//进制
                long tmp=A;
                while (tmp!=0){
                    sum+=tmp%i;
                    tmp/=i;
                }
            }
            //化简
            for(long i=Math.min(sum,A-2);i>1;i--){
                if(sum%i==0 && (A-2)%i==0){
                    sum/=i;
                    A=(A-2)/i+2;
                }
            }
            System.out.println(sum+"/"+(A-2));
        }
    }
}
