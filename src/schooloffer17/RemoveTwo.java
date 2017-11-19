package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/9 17:20.
 * <不要二></>
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1...
 * 一个数学问题,很简单,但是自己方法不够好,先这样写着吧..
 */
public class RemoveTwo {
    public static void main(String[] args) {
        int W,H;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            W=scanner.nextInt();//1 ≤ W、H ≤ 1000
            H=scanner.nextInt();
            int sum=0;
            boolean[][] matrix=new boolean[H][W];
            //初始化第1,2行
            for(int j=0;j<W;j+=4){
                matrix[0][j]=true;
                sum++;
                if(H>1) {
                    matrix[1][j] = true;
                    sum++;
                }
                if(j+1<W) {
                    matrix[0][j + 1] = true;
                    sum++;
                }
                if(H>1 && j+1<W) {
                    matrix[1][j + 1] = true;
                    sum++;
                }
            }
            //初始化第1,2列
            for(int i=4;i<H;i+=4){
                matrix[i][0]=true;
                sum++;
                if(W>1){
                    matrix[i][1]=true;
                    sum++;
                }
                if(i+1<H){
                    matrix[i+1][0]=true;
                    sum++;
                }
                if(i+1<H && W>1){
                    matrix[i+1][1]=true;
                    sum++;
                }
            }

            //填充matrix
            int flag=0;
            for(int i=2;i<H;i+=2){
                int j;
                if(flag==0){
                    j=2;
                    flag=1;
                }else{
                    j=4;
                    flag=0;
                }
                for(;j<W;j+=4){
                    if(matrix[i-2][j]==false && matrix[i-1][j]==false && matrix[i][j-2]==false && matrix[i][j-1]==false){
                        matrix[i][j]=true;
                        sum++;
                        if(j+1<W){
                            matrix[i][j+1]=true;
                            sum++;
                        }
                        if(i+1<H){
                            matrix[i+1][j]=true;
                            sum++;
                        }
                        if(i+1<H && j+1<W){
                            matrix[i+1][j+1]=true;
                            sum++;
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
