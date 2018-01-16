package zhenti.wangyixiaozhao18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 10:19
 * @ProjectName: JavaBaseTest
 * <游历魔法王国></>
 * 60%
 */
public class TravelMagicKindom {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n,m;//n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100)
            n=scanner.nextInt();
            m=scanner.nextInt();

            int[] p=new int[n-1];
            for(int i=0;i<n-1;i++){
                p[i]=scanner.nextInt();
            }
            Arrays.sort(p);
            int index=p[0];
            for(int i=1;i<n-1;i++){
                if(p[i]==index+1)
                    index=p[i];
            }
            n=index+2;//单枝树:最长节点个数:n


            System.out.println(m>=n-1?n:m+1);
        }
    }
}
