package zhenti.wangyixiaozhao18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 16:10
 * @ProjectName: JavaBaseTest
 * 40%
 */
public class Chorus {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//正整数n(1 ≤ n ≤ 2000)
            int[] v=new int[n];
            for(int i=0;i<n;i++)
                v[i]=scanner.nextInt();
            Arrays.sort(v);
            //查找分开位置
            int max=Integer.MIN_VALUE;
            int res=0;
            for(int i=0;i<n-1;i++){
                res+=Math.abs(v[i]-v[i+1]);
                max=Math.max(max,Math.abs(v[i]-v[i+1]));
            }
            System.out.println(res-max);
        }
    }
}
