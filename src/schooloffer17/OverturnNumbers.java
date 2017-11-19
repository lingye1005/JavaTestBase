package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/13 15:28.
 * <数字翻转></>
 */
public class OverturnNumbers {
    public static void main(String[] args) {
        int x,y;//x、y(1 ≤ x、y ≤ 1000)
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            x=scanner.nextInt();
            y=scanner.nextInt();
            StringBuilder sb=new StringBuilder();
            sb.append(x);
            sb.reverse();
            StringBuilder bs=new StringBuilder();
            bs.append(y);
            bs.reverse();

            int sum=Integer.valueOf(sb.toString())+Integer.valueOf(bs.toString());
            sb.delete(0,sb.length());
            sb.append(sum);
            System.out.println(Integer.valueOf(sb.reverse().toString()));
        }
    }
}
