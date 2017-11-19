package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/19 09:42.
 * <素数对></>
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//3 ≤ n < 1000
            int count=0;//记录素数对个数
            for(int i=3;i<=n/2;i++){
                if(isPrime(i) && isPrime(n-i))
                    count++;
            }
            System.out.println(count);
        }
    }
    private static  boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
