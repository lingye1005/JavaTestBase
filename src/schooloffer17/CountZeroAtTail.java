package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/16 15:17.
 * <末尾0的个数></>
 */
public class CountZeroAtTail {
    static int[] num=new int[10004];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            Arrays.fill(num,0);
            num[0]=1;
            for(int i=1;i<=n;i++){
                for(int j=0,carry=0;j<10004;j++){
                    num[j]+=carry+num[j]*i;
                    carry=num[j]%10;
                    num[j]=num[j]/10;
                }
            }
            n=0;
            for(int i=0;i<10004;i++){
                if(num[i]==0)
                    n++;
                else
                    break;
            }
            System.out.println(n);
        }
    }
}
