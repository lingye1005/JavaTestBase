package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 11:58.
 * <倒置字符串></>
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strs=scanner.nextLine().split(" ");
            for(int i=strs.length-1;i>0;i--){
                System.out.print(strs[i]+" ");
            }
            System.out.println(strs[0]);
        }
    }
}
