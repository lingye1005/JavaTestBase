package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/23.
 * 搜狐进行了一次黑客马拉松大赛，全公司一共分为了N个组，每组一个房间排成一排开始比赛...
 */
public class Bonus {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N=scanner.nextInt();//输入参加比赛的团队数目
            if(N==1)
                System.out.println(1);
            else if(N==2)
                System.out.println(3);
            //3个团队及以上
            int[] score=new int[N];
            for(int i=0;i<N;i++){
                score[i]=scanner.nextInt();
            }

            //对于任何一个点i:考虑两个方向:从i向左查找满足条件的值,找到一个+1,不满足条件则停止查找.
            //从i向右查找满足条件的值,找到一个+1,不满足条件停止查找.
            int[] bonus=new int[N];
            for(int i=0;i<N;i++){
                int b1=1;
                for(int j=i-1;j>=0;j--){
                    if(score[j+1]>score[j])
                        b1++;
                    else
                        break;
                }
                int b2=1;
                for(int j=i+1;j<N;j++){
                    if(score[j-1]>score[j])
                        b2++;
                    else
                        break;
                }
                bonus[i]=Math.max(b1,b2);
            }
            int sum=0;
            for(int i:bonus)
                sum+=i;
            System.out.println(sum);
        }
    }
}
