package zhenti.wangyileihuo17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 19:14
 * @ProjectName: JavaBaseTest
 * <删除重复元素></>
 * 100%
 */
public class DeleteRepeatableWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[] sequences=new int[n];
            ArrayList<Integer> sets=new ArrayList<>();
            for(int i=0;i<n;i++)
                sequences[i]=scanner.nextInt();
            for(int i=n-1;i>=0;i--){
                if(!sets.contains(sequences[i]))
                    sets.add(sequences[i]);
            }
            n=sets.size();
            for(int i=n-1;i>0;i--)
                System.out.print(sets.get(i)+" ");
            System.out.println(sets.get(0));
        }
    }
}
