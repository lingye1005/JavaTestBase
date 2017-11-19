package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/12 12:50.
 */
public class BlackStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNext()){
            N=scanner.nextInt();//1 ≤ n ≤ 30
            if(N==1){
                System.out.println(3);
            }else if(N==2){
                System.out.println(9);
            }else{
                //System.out.println((int)(Math.pow(3,N)-6*(N-2)));
            }
        }
    }
}
