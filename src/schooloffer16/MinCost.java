package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/26.
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 动态规划
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {//c0,c1,c2 对应于:插入、删除和修改
        // write code here
        int[][] dynamic=new int[m+1][n+1];
        //初始化第一行
        for(int j=0;j<n+1;j++)
            dynamic[0][j]=j*c1;
        //初始化第一列
        for(int i=0;i<m+1;i++)
            dynamic[i][0]=i*c0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int tmp1=dynamic[i-1][j]+c0;//删除一个元素
                int tmp2=dynamic[i][j-1]+c1;//增加一个元素
                int tmp3;//替换一个元素
                if(B.charAt(i-1)==A.charAt(j-1))
                    tmp3=dynamic[i-1][j-1];
                else
                    tmp3=dynamic[i-1][j-1]+c2;
                dynamic[i][j]=Math.min(tmp1,Math.min(tmp2,tmp3));
            }
        }
        return dynamic[m][n];
    }

    //test <code></code>
    public static void main(String[] args) {
        MinCost t=new MinCost();
        //"abc",3,"adc",3,5,3,100
        String a="bbca",b="cabacab";
        System.out.println(t.findMinCost(a,4,b,7,1,2,7));
    }
}
