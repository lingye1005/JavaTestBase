package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 11:39.
 * <n个数里最小的k个></>
 */
public class MinKs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] tmp=scanner.nextLine().split(" ");
            int[] num=new int[tmp.length-1];
            for(int i=0;i<tmp.length-1;i++){
                num[i]=Integer.valueOf(tmp[i]);
            }
            Arrays.sort(num);
            int k=Integer.valueOf(tmp[tmp.length-1]);
            for(int i=0;i<k-1;i++)
                System.out.print(num[i]+" ");
            System.out.println(num[k-1]);
        }
    }
}
