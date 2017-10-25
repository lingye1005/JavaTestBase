package schooloffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/17.
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 */
public class TheHighestScore {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N,M;//N个学生,M个操作<Q或者U> ;取值范围:0 < N <= 30000,0 < M < 5000
            N=scanner.nextInt();
            M=scanner.nextInt();
            int[] score=new int[N+1];

            //输入成绩
            for(int i=1;i<N+1;i++){
                score[i]=scanner.nextInt();
            }
            //特别注意下面这行代码
            String invalid=scanner.nextLine();//为什么会有这个无用的读入:因为要把上面读入整数后面的换行符读取出来,才能读入下面的字符串,否则下面的字符串总是读入为空.

            //输入操作
            for(int i=0;i<M;i++){
                String str=scanner.nextLine();
                String[] tmp=str.split(" ");
                if(tmp[0].equals("Q")){
                    //Arrays.sort(score);全排序肯定是错,应该对A-B排序才对
                    int A=Math.min(Integer.valueOf(tmp[1]),Integer.valueOf(tmp[2]));
                    int B=Math.max(Integer.valueOf(tmp[1]),Integer.valueOf(tmp[2]));//A-B之间最高分
                    int[] tmpScore= Arrays.copyOfRange(score,A,B+1);
                    Arrays.sort(tmpScore);

                    System.out.println(tmpScore[tmpScore.length-1]);
                }else{
                    int id=Integer.valueOf(tmp[1]);
                    int scor=Integer.valueOf(tmp[2]);
                    score[id]=scor;
                }
            }
        }
    }
}
