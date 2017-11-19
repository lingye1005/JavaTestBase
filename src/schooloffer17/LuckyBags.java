package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/10 16:32.
 * <幸运的袋子></>
 */
public class LuckyBags {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;//n ≤ 1000 ,n 个数字
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[] ballNum=new int[n];
            for(int i=0;i<n;i++)
                ballNum[i]=scanner.nextInt();
            Arrays.sort(ballNum);//升序排序,为后面的搜索剪枝做准备.如果当前情况是sum<=mul 且ballNum[i]!=1,那么就不需要继续往下遍历了.
            //调用主算法
            System.out.println(dfs(0,0,1,ballNum,n));
        }
    }

    /**
     * dfs+回溯+剪枝
     * @param tmpIndex 数组当前被遍历元素的下标
     * @param sum 当前遍历过程中,符合要求的连续的所有元素的和
     * @param mul 当前遍历过程中,符合要求的连续的所有元素的积
     * @param ballNum 输入数组:球的编号信息
     * @param len 输入数组的的长度
     * @return
     */
    private static  int dfs(int tmpIndex,int sum,long mul,int[] ballNum,int len){
        int res=0;
        for(int i=tmpIndex;i<len;i++){
            sum+=ballNum[i];
            mul*=ballNum[i];
            if(sum>mul){
                res+=1+dfs(i+1,sum,mul,ballNum,len);
            }else if(ballNum[i]==1){
                res+=dfs(i+1,sum,mul,ballNum,len);
            }else{
                break;
            }
            sum-=ballNum[i];
            mul/=ballNum[i];
            /**下标范围[i+1,len-1]中,数值和ballNum[i]一样的数字,直接过滤掉,不再考虑.因为代码可以走到这里,
             * 是因为ballNum[i]不能符合要求,所以其它的和ballNum[i]一样的数字也就不用考虑了,这才能达到剪枝的
             * 目的,否则,依旧是对所有元素进行遍历
             */
            while(i<len-1 && ballNum[i]==ballNum[i+1]){
                i++;
            }
        }
        return res;
    }
}
