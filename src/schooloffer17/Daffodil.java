package schooloffer17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 16:33
 * @ProjectName: JavaBaseTest
 * <水仙花数></>
 */
public class Daffodil {
    public static void main(String[] args) {
        int m,n;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            //100 ≤ m ≤ n ≤ 999
            m=scanner.nextInt();
            n=scanner.nextInt();
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=m;i<=n;i++){
                if(Math.pow(i/100,3)+Math.pow(i%100/10,3)+Math.pow(i%100%10,3)==i)
                    list.add(i);
            }
            if(list.size()==0){
                System.out.println("no");
            }else{
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println(list.get(list.size()-1));
            }
        }
    }
}
