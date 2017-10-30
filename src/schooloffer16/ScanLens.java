package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/23.
 * 扫描透镜
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,...
 */
public class ScanLens {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N,M,K;//,N,M代表了草地的大小 ;  1≤N,M≤20,K≤100
            String[] str1=scanner.nextLine().split(" ");
            N=Integer.valueOf(str1[0]);
            M=Integer.valueOf(str1[1]);
            K=Integer.valueOf(str1[2]);

            //接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
            int[][]  location=new int[N+1][M+1];

            for(int i=1;i<=K;i++){
                String[] str=scanner.nextLine().split(" ");
                int x=Integer.valueOf(str[0]);
                int y=Integer.valueOf(str[1]);
                location[x][y]+=1;
            }
            if(N<=3 && M<=3){
                int count=0;
                for(int i=1;i<=N;i++){
                    for(int j=1;j<=M;j++){
                        if(location[i][j]==1)
                            count+=1;
                        else if(location[i][j]==2)
                            count+=2;
                    }
                }
                System.out.println(count);
            }else{
                int max=0;//记录结果值
                int idx1=0,idy1=0;
                int maxSum1=0;
                //第一次遍历
                for(int i=1;i<=N-2;i++){
                    for(int j=1;j<=M-2;j++){
                        int count=0;
                        for(int p=i;p<i+3;p++){
                            for(int q=j;q<j+3;q++){
                                if(location[p][q]>=1)
                                    count++;
                            }
                        }
                        if(count>maxSum1){//记录3*3方格开始的的第一个方格的i,j
                            idx1=i;
                            idy1=j;
                            maxSum1=count;
                        }
                    }
                }
                //遍历完后修改location对应值
                for(int i=idx1;i<=idx1+2;i++){
                    for(int j=idy1;j<=idy1+2;j++){
                        if(location[i][j]>0)
                            location[i][j]-=1;
                    }
                }
                //第二次遍历
                int idx2=0,idy2=0;
                int maxSum2=0;
                for(int i=1;i<=N-2;i++){
                    for(int j=1;j<=M-2;j++){
                        int count=0;
                        for(int p=i;p<i+3;p++){
                            for(int q=j;q<j+3;q++){
                                if(location[p][q]>=1)
                                    count++;
                            }
                        }
                        if(count>maxSum2){
                            idx2=i;
                            idy2=j;
                            maxSum2=count;
                        }
                    }
                }
                max=maxSum1+maxSum2;
                System.out.println(max);
            }
        }
    }
}
