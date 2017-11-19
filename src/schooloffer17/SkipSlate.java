package schooloffer17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by caoxiaohong on 17/11/12 11:17.
 * <跳石板/>
 */
public class SkipSlate {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N,M;
        while (scanner.hasNextInt()){
            N=scanner.nextInt();
            M=scanner.nextInt();

            //没加上这个N==M的判定条件,通过率60%,超时.加上就好了...
            if(N==M){
                System.out.println(0);
                continue;
            }

            int len=M-N+1;
            int[] dp=new int[len];//dp[i]:表示从位置N到i的最少步数
            //开始时:位置N是可达的,其余位置均不可达.
            for(int i=1;i<len;i++)
                dp[i]=Integer.MAX_VALUE;
            //dp过程
            for(int i=0;i<len;i++){
                if(dp[i]==Integer.MAX_VALUE){
                    dp[i]=0;
                    continue;
                }
                Set<Integer> approximateNum=getList(i+N);
                Iterator<Integer> iterator=approximateNum.iterator();
                while (iterator.hasNext()){
                    int x=iterator.next();//约数
                    if(i+N+x<=M){
                        dp[i+x]=Math.min(dp[i+x],dp[i]+1);
                    }
                }
            }
            if(dp[len-1]==0)
                System.out.println(-1);
            else
                System.out.println(dp[len-1]);
        }
    }

    /**
     * 获取num的所有公约数(当然除去1和num自身)
     * @param num
     * @return
     */
    private static HashSet<Integer> getList(int num){
        HashSet<Integer> res=new HashSet<Integer>();
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){//i是num的约数
                res.add(i);
                res.add(num/i);
            }
        }
        return res;
    }


}
