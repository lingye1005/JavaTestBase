package schooloffer17;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by caoxiaohong on 17/10/30.
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。...
 */
public class ToKitchen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> set=new HashSet<String>();
        String[] tmp;
        while (scanner.hasNext()){
            tmp=scanner.nextLine().split(" ");
            for(String str:tmp)
                set.add(str);
        }
        System.out.println(set.size());
    }
}
