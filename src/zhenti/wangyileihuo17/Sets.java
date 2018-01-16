package zhenti.wangyileihuo17;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 21:08
 * @ProjectName: JavaBaseTest
 * <集合></>
 * 20%
 */
public class Sets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int w,x,y,z;//w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100)
        while (scanner.hasNextInt()){
            w=scanner.nextInt();
            x=scanner.nextInt();
            y=scanner.nextInt();
            z=scanner.nextInt();
            Set<Integer> sets=new HashSet<>();
            if(w<z)
                sets.add(0);
            for(int i=w;i<=x;i++){
                for(int j=y;j<=z && i>=j;j++)
                    sets.add(i/j);
            }
            System.out.println(sets.size());
        }
    }
}
