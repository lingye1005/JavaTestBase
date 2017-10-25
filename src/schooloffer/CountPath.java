package schooloffer;

/**
 * Created by caoxiaohong on 17/9/12.
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，
 * 他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 *
 * 注意:这个路径肯定默认是最短路径.所以同类问题是:机器人从矩形的一个对角走到另一个对角的题目.
 * 所以就是一个从左对角连续加到右对角数的过程.最后返回矩形右下角的数字,即为解决方案的数目.
 */
public class CountPath {
    public int countPath(int[][] map, int n, int m) {
        // write code here
        //查找1和2的坐标
        int i1=-1,j1=-1;
        int i2=-1,j2=-1;
        boolean isFind1=false,isFind2=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    i1=i;
                    j1=j;
                    isFind1=true;
                }else if(map[i][j]==2){
                    i2=i;
                    j2=j;
                    isFind2=true;
                }
                if(isFind1 && isFind2)
                    break;
            }
            if (isFind1 && isFind2)
                break;
        }
        if(!isFind1 || !isFind1)//只要有一个没有找到
            return 0;
        return helper(map,i1,j1,i2,j2);
    }

    /**
     * 从点[i1,j1]走到[i2,j2]这个点的方案数目
     * @param map
     * @param i1
     * @param j1
     * @param i2
     * @param j2
     * @return
     */
    int helper(int[][] map,int i1,int j1,int i2,int j2){
        //在同行
        if(i1==i2){
            int fromj=j1<j2?j1:j2;
            int toj=j1>j2?j1:j2;
            for(int j=fromj;j<=toj;j++){
                if(map[i1][j]==-1)
                    return 0;
            }
            return 1;
        }
        //在同列
        if(j1==j2){
            int fromi=i1<i2?i1:i2;
            int toi=i1>i2?i1:i2;
            for(int i=fromi;i<=toi;i++){
                if(map[i][j1]==-1)
                    return 0;
            }
            return 1;
        }
        //声明数组
        int[][] value=new int[i1>i2?(i1-i2+1):(i2-i1+1)][j1>j2?(j1-j2+1):(j2-j1+1)];
        //左上->右下
        if(i1<i2 && j1<j2){
            value[0][0]=0;
            //第一行赋值
            int j=1;
            for(int k=j1+1;k<=j2;k++){
                if(map[i1][k]==0)
                    value[0][j++]=1;
                else
                    value[0][j++]=0;
            }
            //第一列赋值
            int i=1;
            for(int k=i1+1;k<=i2;k++){
                if(map[k][j1]==0)
                    value[i++][0]=1;
                else
                    value[i++][0]=0;
            }
            //求和
            for(int m=1;m<value.length;m++){
                for(int n=1;n<value[0].length;n++){
                    value[m][n]=value[m][n-1]+value[m-1][n];
                }
            }
            return value[value.length-1][value[0].length-1];//结果值
        }
        else if(i1<i2 && j1>j2) {//右上->左下
            int j=0;
            //第一行值
            for(int k=j2;k<j1;k++){
                if(map[i1][k]==0)
                    value[0][j++]=1;
                else
                    value[0][j++]=0;
            }
            //最后一列赋值
            int i=1;
            for(int k=i1+1;k<=i2;k++){
                if(map[k][j1]==0)
                    value[i++][value[0].length-1]=1;
                else
                    value[i++][value[0].length-1]=0;
            }
            //求和
            for(int m=1;m<value.length;m++){
                for(int n=value[0].length-1;n>=0;n--){
                    value[m][n]=value[m][n+1]+value[m-1][n];
                }
            }
            return value[value.length-1][0];//结果值
        }
        else if(i1>i2 && j1<j2){//左下->右上
            //最后一行值
            int j=1;
            for(int m=j1+1;m<=j2;m++){
                if(map[i2][m]==0)
                    value[value.length-1][j++]=1;
                else
                    value[value.length-1][j++]=0;
            }
            //第1列值
            int i=0;
            for(int m=i2;m<i1;m++){
                if(map[m][j1]==0)
                    value[i++][0]=1;
                else
                    value[i++][0]=0;
            }
            //求和
            for(int m=value.length-2;m>=0;m--){
                for(int n=1;n<value[0].length;n++){
                    value[m][n]=value[m][n-1]+value[m+1][n];
                }
            }
            return value[0][value[0].length-1];
        }else{  //右下->左上
            //最后一行值
            int j=0;
            for(int k=j2;k<j1;k++){
                if(map[i2][k]==0)
                    value[value.length-1][j++]=1;
                else
                    value[value.length-1][j++]=0;
            }
            //最后一列值
            int i=0;
            for(int k=i2;k<i1;k++){
                if(map[k][j1]==0)
                    value[i++][value[0].length-1]=1;
                else
                    value[i++][value[0].length-1]=0;
            }
            //求和
            for(int m=value.length-2;m>=0;m--){
                for(int n=value[0].length-2;n>=0;n--){
                    value[m][n]=value[m][n+1]+value[m+1][n];
                }
            }
            return value[0][0];
        }
    }

    //test <code></code>
    public static void main(String[] args) {
        CountPath t=new CountPath();
        int[][] a={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}};

        System.out.println(t.countPath(a,7,5));
    }
}
