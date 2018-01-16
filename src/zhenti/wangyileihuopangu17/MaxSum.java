package zhenti.wangyileihuopangu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/17 10:10
 * @ProjectName: JavaBaseTest
 * <最大和></>
 * 85%
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N,D;
        while (scanner.hasNext()){
            N=scanner.nextInt();
            D=scanner.nextInt();
            int[][] matrix=new int[N][N];//0~100,故最大值<=10000
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    matrix[i][j]=scanner.nextInt();
                }
            }
            //行最大值
            int max1=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N-D;j++){
                    int tmp=0;
                    for(int k=j;k<j+D;k++)
                        tmp+=matrix[i][k];
                    max1=Math.max(max1,tmp);
                }
            }
            //列最大值
            int max2=0;
            for(int j=0;j<N;j++){
                for(int i=0;i<N-D;i++){
                    int tmp=0;
                    for(int k=i;k<i+D;k++)
                        tmp+=matrix[k][j];
                    max2=Math.max(max2,tmp);
                }
            }
            //倾斜:左上->右下:最大值
            int max31=0;
            //左下角
            for(int i=0;i<=N-D;i++){//行号
                for(int j=0;j<N-D;j++){
                    int tmp=0;
                    for(int k=0;k<D;k++){
                        tmp+=matrix[i+k][j+k];
                    }
                    max31=Math.max(max31,tmp);
                }
            }
            //右下角
            int max32=0;
            for(int i=0;i<=N-D;i++){
                for(int j=1;j<N-D;j++){
                    int tmp=0;
                    for(int k=0;k<D;k++){
                        tmp+=matrix[i+k][j+k];
                    }
                    max32=Math.max(max32,tmp);
                }
            }

            //倾斜:右上->左下:最大值
            //左上角
            int max41=0;
            for(int i=0;i<=N-D;i++){//行号
                for(int j=D-1;j<N;j++){
                    int tmp=0;
                    for(int k=0;k<D;k++){
                        tmp+=matrix[i+k][j-k];
                    }
                    max41=Math.max(max41,tmp);
                }
            }
            //右下角
            int max42=0;
            for(int i=1;i<=N-D;i++){
                for(int j=N-1;j>=D-1;j--){
                    int tmp=0;
                    for(int k=0;k<D;k++){
                        tmp+=matrix[i+k][j-k];
                    }
                    max42=Math.max(max42,tmp);
                }
            }

            int res=0;
            res=Math.max(res,max1);
            res=Math.max(res,max2);
            res=Math.max(res,max31);
            res=Math.max(res,max32);
            res=Math.max(res,max41);
            res=Math.max(res,max42);
            System.out.println(res);
        }
    }
}
