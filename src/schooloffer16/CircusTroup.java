package schooloffer16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/22.
 * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，....
 * 动态规划，用到了最长上升子序列问题。首先按照体重从小到大排序，体重相同时，身高高的在上，然后求最长身高上升子序列的长度。
 * 要求:叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。
 */
public class CircusTroup {
    static class People{
        int num;
        int weight;
        int height;
        public People(int num,int weight,int height){
            this.num=num;
            this.weight=weight;
            this.height=height;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNext()){
            N=scanner.nextInt();
            String inValid=scanner.nextLine();//无效
            People[]  peoples=new People[N];
            for(int i=0;i<N;i++){
                String[] str=scanner.nextLine().split(" ");
                peoples[i]=new People(Integer.valueOf(str[0]),Integer.valueOf(str[1]),Integer.valueOf(str[2]));
            }
            //第一处:注意地方
            //先按照体重升序,再按照身高降序
            //为什么身高要降序?因为:体重相同时，只有身高也相同才可以站在自己肩上，比自己矮是不能站在自己肩上的。
            //而身高降序就保证了:体重相同时,身高不同为降序,不是升序序列,则不能站在自己肩上.
            Arrays.sort(peoples, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    if(o1.weight==o2.weight){
                        return o2.height-o1.height;
                    }else{
                        return o1.weight-o2.weight;
                    }
                }
            });

            //第二处:注意地方
            //按身高求最大升序子序列,不是太会
            int[] dp=new int[N];
            dp[0]=1;
            int level=0;
            for(int i=1;i<N;i++){
                dp[i]=1;
                for(int j=0;j<i;j++){//通过这里的代码,可以知道:子序列并不需要连续,只要满足if条件就可以
                    if(peoples[j].height<=peoples[i].height && dp[j]+1>dp[i])
                        dp[i]=dp[j]+1;
                }
            }
            Arrays.sort(dp);
            level=dp[N-1];
            System.out.println(level);
        }
    }
}
