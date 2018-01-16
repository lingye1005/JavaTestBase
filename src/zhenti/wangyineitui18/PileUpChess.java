package zhenti.wangyineitui18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 20:05
 * @ProjectName: JavaBaseTest
 * <堆棋子></>
 * 40%
 */
public class PileUpChess {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//整数n(1 ≤ n ≤ 50),表示棋子的个数
            int[] xi=new int[n];//横坐标x[i](1 ≤ x[i] ≤ 10^9)
            int[] yi=new int[n];//纵坐标y[i](1 ≤ y[i] ≤ 10^9)
            for(int i=0;i<n;i++)
                xi[i]=scanner.nextInt();
            for(int i=0;i<n;i++)
                yi[i]=scanner.nextInt();
            //处理
            int[] res=new int[n];
            for(int k=1;k<=n;k++){//几个棋子
                int maxi=-1,maxj=-1;
                int mini=Integer.MAX_VALUE,minj=Integer.MAX_VALUE;
                for(int i=0;i<k;i++){
                    maxi=Math.max(xi[i],maxi);
                    maxj=Math.max(yi[i],maxj);
                    mini=Math.min(xi[i],mini);
                    minj=Math.min(yi[i],minj);
                }
                //中间位置
                int midi=(maxi+mini)/2;
                int midj=(maxj+minj)/2;
                //midi,midj是否应该+1
                int left=0,right=0;
                int up=0,down=0;
                for(int i=0;i<k;i++){
                    if(xi[i]<=midi)
                        left++;
                    else right++;
                }
                for(int i=0;i<k;i++){
                    if(yi[i]<=midj)
                        down++;
                    else
                        up++;
                }
                if(right>left)
                    midi++;
                if(up>down)
                    midj++;

                //不使用中间点,查找哪个点距离中间点最近
                int x=xi[0],y=yi[0];
                int disk=(int)Math.pow(maxi,2)+(int)Math.pow(maxj,2);//距离
                for(int i=1;i<k;i++){
                    if(Math.pow(xi[i],2)+Math.pow(yi[i],2)<disk){
                        x=xi[i];
                        y=yi[i];
                    }
                }
                //求和
                int count1=0;
                for(int i=0;i<k;i++){
                    count1+=Math.abs(xi[i]-x);
                    count1+=Math.abs(yi[i]-y);
                }

                //使用中间点
                int count2=0;
                for(int i=0;i<k;i++){
                    count2+=Math.abs(xi[i]-midi);
                    count2+=Math.abs(yi[i]-midj);
                }
                res[k-1]=count1<count2?count1:count2;
            }
            //输出
            for(int i=0;i<n-1;i++)
                System.out.print(res[i]+" ");
            System.out.println(res[n-1]);
        }
        /**
         *
         *
         * 输入例子1:
         4
         1 2 4 9
         1 1 1 1

         输出例子1:
         0 1 3 10
         --------------
         * 测试用例:
         5
         8 1 9 9 7
         7 7 7 7 10

         对应输出应该为:

         0 0 1 6 13

         你的输出为:

         0 7 10 13 20

         */
    }
}
