package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/5 09:55.
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏...
 */
public class DevideFields {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;//取值范围: 1~75
        while (scanner.hasNext()){
            String[] nm=scanner.nextLine().split(" ");
            n=Integer.valueOf(nm[0]);//n行
            m=Integer.valueOf(nm[1]);//m列

            int[][] fields=new int[n][m];
            for(int i=0;i<n;i++){
                String str=scanner.nextLine();
                for(int j=0;j<m;j++)
                    fields[i][j]=str.charAt(j)-'0';
            }

            /**
             * sum[i][j]表示满足条件左上角坐标为(0,0),右下角坐标为(i-1,j-1)的矩阵:中所有元素的和值
             */
            int[][] sum=new int[n+1][m+1];

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++) {
                    sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+fields[i-1][j-1];
                }
            }

            int low=0,high=sum[n][m];
            int mid;
            int res=0;
            while (low<=high){
                mid=(low+high)/2;
                if(isValid(mid,n,m,sum)){
                    low=mid+1;
                    res=mid;
                }else{
                    high=mid-1;
                }
            }
            System.out.println(res);
        }
    }

    /**
     * 是否存在一种切法,使得田地被切割后,最小块矩阵的价值>=mid(这一判定条件为true时:刀的横切数目>=4即可)
     * @param mid
     * @param n
     * @param m
     * @param sum
     * @return
     */
    private static  boolean isValid(int mid,int n,int m,int[][] sum){
        for(int i=1;i<=m-3;i++){
            for(int j=i+1;j<=m-2;j++){
                for(int k=j+1;k<=m-1;k++){
                    int lastRowNum=0;//记录上一次横切时的行号,因为fields[]是从0行开始的,所以这里从0开始
                    int count=0;//记录横切刀数
                    for(int r=1;r<=n;r++){
                        int c1=getMatrixValue(r,i,lastRowNum,0,sum);
                        int c2=getMatrixValue(r,j,lastRowNum,i,sum);
                        int c3=getMatrixValue(r,k,lastRowNum,j,sum);
                        int c4=getMatrixValue(r,m,lastRowNum,k,sum);
                        //可以横切一刀的条件
                        if(c1>=mid && c2>=mid && c3>=mid && c4>=mid){
                            lastRowNum=r;
                            count++;
                        }
                    }
                    if(count>=4)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * 设原始土地矩阵为:
     * 3 3 3 2
     * 3 2 3 3
     * 3 3 3 2
     * 2 3 2 3
     *
     * 那么sum矩阵为
     * 0   0   0   0   0
     * 0   3   6   9   11
     * 0   6   11  17  22
     * 0   9   17  26  33
     * 0   11  22  33  43
     *
     * 计算matrix矩阵中左上顶点(i,j)到右下顶点(x-1,y-1)确定的田地的价值和
     *
     * 例如x=4,y=4,i=1,y=2,则
     * 返回值=sum[4][4]-sum[1][4]-sum[4][2]+sum[1][2]=43-11-22+6=16
     * 显然子矩阵
     * 3 3
     * 3 2
     * 2 3
     * 的元素总和为16
     *
     * @param x
     * @param y
     * @param i
     * @param j
     * @param sum
     * @return
     */
    private static int getMatrixValue(int x,int y,int i,int j,int[][] sum){
        return sum[x][y]-sum[x][j]-sum[i][y]+sum[i][j];
    }
}
