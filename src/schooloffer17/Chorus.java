package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/30.
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生...
 * 动态规划
 */
public class Chorus {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        int k,d;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//n个学生
            int[] values=new int[n+1];
            for(int i=0;i<n;i++){ //输入各个学生的值
                values[i+1]=scanner.nextInt();
            }
            k=scanner.nextInt();//选定学生的个数
            d=scanner.nextInt();//相邻学生的之间的最大间隔

            /**动态规划:为什么要有两个数组呢?因为学生的价值可能为负数,那么就要有一个数组存最大值,一个存最小值.如果学生价值为负数,
            那么如果乘以一个不管是不是负数的最小值,才能得到最大值.这就是最小值数组存在的意义.**/
            //因为乘积结果最大值为:Math.pow(50,10)=Math.pow(5,10)*Math.pow(10,10),所以数组类型采用long

            long[][] max=new long[n+1][k+1];//max[i][j]:i为组成j个人的最后一个人
            long[][] min=new long[n+1][k+1];//min[i][j]:i为组成j个人的最后一个人
            //显然max[i][0],min[i][0]=0,所以第1列不用初始化
            //同理,第1行不用初始化.
            //但是第2列需要初始化
            for(int i=1;i<n+1;i++){
                max[i][1]=values[i];
                min[i][1]=values[i];
            }

            //dp过程:
            for(int j=2;j<k+1;j++){
                for(int i=j;i<n+1;i++){
                    long max0=Integer.MIN_VALUE;//记录下面for循环中出现的最大值,然后赋值给max[i][j]
                    long min0=Integer.MAX_VALUE;//记录下面for循环出现的最小值,然后赋值给min[i][j]
                   //求解,当j,i值确定时,最大的分割点
                    for(int left=Math.max(j-1,i-d);left<i;left++){
                        if(max0<Math.max(max[left][j-1]*values[i],min[left][j-1]*values[i])){
                            max0=Math.max(max[left][j-1]*values[i],min[left][j-1]*values[i]);
                        }
                        if(min0>Math.min(max[left][j-1]*values[i],min[left][j-1]*values[i])){
                            min0=Math.min(max[left][j-1]*values[i],min[left][j-1]*values[i]);
                        }
                    }
                    max[i][j]=max0;
                    min[i][j]=min0;
                }
            }
            //根据对max[i][j]的定义:第i个人作为选择的j个人的最后一个人,所以此时需要对max第k+1列进行遍历,找出最大值
            long result=Integer.MIN_VALUE;
            for(int i=k;i<n+1;i++){ //显然,第k+1列,从第k+1行开始,值才不为0;所以i从k开始.
                if(result<max[i][k])
                    result=max[i][k];
            }
            System.out.println(result);
        }
    }
}
