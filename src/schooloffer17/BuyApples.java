package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/14 15:25.
 * <买苹果></>
 */
public class BuyApples {
    public static void main(String[] args) {
        int N;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            N=scanner.nextInt();//范围:1~100
            if(N%2==1){ //奇数:找不到解决方法,输出-1
                System.out.println(-1);
                continue;
            }
            System.out.println(minBags(N,0));
        }
    }

    /**
     * 回溯
     * @param num 要买苹果的个数
     * @param sum 目前已经买到的苹果个数
     * @return
     */
    private static int minBags(int num, int sum){
        int bags=0;
        if(num==sum)
            return bags;
        else if(num<sum){
            bags--;
            bags += minBags(num, sum - 8);
        }else{
            bags++;
            if(sum+8<=num) {
                bags += minBags(num, sum + 8);
            }
            else {
                bags += minBags(num, sum + 6);
            }
        }
        return bags;
    }
}
