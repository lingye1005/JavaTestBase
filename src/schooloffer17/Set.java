package schooloffer17;

import java.util.*;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 16:42
 * @ProjectName: JavaBaseTest
 * <集合></>
 */
public class Set {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            TreeSet<Integer>  set=new TreeSet<Integer>();
            for(int i=0;i<n+m;i++)
                set.add(scanner.nextInt());
            Iterator<Integer> iterator=set.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next());
                if(iterator.hasNext())
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
    }
}
