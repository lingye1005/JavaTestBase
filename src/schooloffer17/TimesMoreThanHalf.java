package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 11:45.
 * <n个数里出现次数大于n/2的数字></>
 */
public class TimesMoreThanHalf {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] tmp=scanner.nextLine().split(" ");
            int n=tmp.length;
            String pre=tmp[0];//记录上一次出现的数字
            for(int i=1;i<n;i++){
                if(!tmp[i].equals(pre))
                    pre=tmp[i];
            }
            System.out.println(pre);
        }
    }
}
