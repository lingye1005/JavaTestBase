package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/19.
 */
public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        long r,avg;  //开始r,avg用的int类型,通过率90%,改为long就好了.因为sum=n*avg;保证了sum不会溢出.
        while (scanner.hasNext()){
            n=scanner.nextInt();//n门课程
            r=scanner.nextInt();//课程总分
            avg=scanner.nextInt();//平均分

            long sum=n*avg;
            long[][] score=new long[n][2];
            long ishava=0;
            for(int i=0;i<n;i++){
                score[i][0]=scanner.nextLong();//平时成绩
                score[i][1]=scanner.nextLong();//每增加期末成绩1分,则需要复习时间分钟数
                ishava+=score[i][0];
            }
            if(ishava>=sum)
                System.out.println(0);
            else {
                long disk=sum-ishava;
                long minutes=0;
                //排序
                score=sort(score);
                for(int i=0;i<n;i++){
                    //可以增加分数
                    long canAdd=r-score[i][0];
                    while (canAdd>0 && disk>0){
                        minutes+=score[i][1];
                        canAdd--;
                        disk--;
                    }
                    if(disk==0)
                        break;
                }
                System.out.println(minutes);
            }
        }
    }

    //对二维数组,按照[][1]排序
    static long[][] sort(long[][] array){
        int len=array.length;
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=len-1;j>i;j--){
                if(array[j][1]<array[j-1][1]){
                    long tmp1=array[j][1];
                    array[j][1]=array[j-1][1];
                    array[j-1][1]=tmp1;
                    long tmp2=array[j][0];
                    array[j][0]=array[j-1][0];
                    array[j-1][0]=tmp2;
                    flag=true;
                }
            }
            if(!flag)
                break;

        }
        return array;
    }
}
