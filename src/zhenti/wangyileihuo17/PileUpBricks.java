package zhenti.wangyileihuo17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 22:14
 * @ProjectName: JavaBaseTest
 * <堆砌砖块></>
 * 20% 栈溢出
 */
public class PileUpBricks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNext()) {
            n = scanner.nextInt();//n(1 ≤ n ≤ 50)
            int[] heights = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int  tmp=scanner.nextInt();
                heights[i] = tmp;
                sum+=tmp;
            }
            //height[i] (1 ≤ height[i] ≤ 500000)
            if(n==1 || sum%2==1){
                System.out.println(-1);
                continue;
            }
            Arrays.sort(heights);
            //调用迭代
            if(helper(heights,sum/2,0))
                System.out.println(sum/2);
            else
                System.out.println(-1);
        }
    }
    private static boolean helper(int[] heights,int sum,int present){
        if(sum==present)
            return true;
        for(int i=0;i<heights.length;i++){
            if(sum>present) {
                present += heights[i];
                helper(heights, sum, present);
            }
            present-=heights[i];
            helper(heights,sum,present);
        }
        return false;
    }
}
