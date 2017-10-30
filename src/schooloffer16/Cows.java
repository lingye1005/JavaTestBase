package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/20.
 * 在农场中，奶牛家族是一个非常庞大的家族，对于家族中的母牛，从它出生那年算起，第三年便能成熟，成熟的母牛每年可以生出一只小母牛。
 * 即母牛从出生开始的第三年便能做妈妈。最开始农场只有一只母牛，它从第二年开始生小母牛。请设计一个高效算法，返回第n年的母牛总数，已知n的范围为int范围内的正整数。
 */
public class Cows {
    public int countSum(int n) {
        // write code here
        if(n==1 || n==2 || n==3)
            return n;
        //n>3
        int exp=n-3;
        long[][] base=new long[3][3];
        base[0][0]=1;base[0][1]=0;base[0][2]=1;
        base[1][0]=1;base[1][1]=0;base[1][2]=0;
        base[2][0]=0;base[2][1]=1;base[2][2]=0;

        long[][] ret=new long[3][3];//单位矩阵E
        ret[0][0]=1;
        ret[1][1]=1;
        ret[2][2]=1;

        //对base求n-3次方
        long[][] tmp;
        while (exp>0){
            //ret=ret*base
            if((exp&1)>0){
                ret=matrixMul(ret,base);
            }
            //base=base*base
            base=matrixMul(base,base);
            //exp>>1
            exp=exp>>1;
        }

        //base第一行和3行1列矩阵[F(3) F(2) F(1)]相乘,得到结果.
        //第一次一直不能ac,原因是3个数字相加时候,没有做取余运算

        int res=(int)(ret[0][0]*3%1000000007);
        res+=(int)(ret[0][1]*2)%1000000007;
        res%=1000000007;
        res+=(int)(ret[0][2])%1000000007;
        return res%1000000007;
    }

    /**
     * 求矩阵a和矩阵b的乘积
     * @param a
     * @param b
     */
    private static long[][] matrixMul(long[][] a,long[][] b){
        long[][] res=new long[a.length][b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b[0].length;j++){
                for(int k=0;k<a[0].length;k++){
                    res[i][j]+=a[i][k]*b[k][j];
                    if(res[i][j]>=1000000007)
                        res[i][j]%=1000000007;
                }
            }
        }
        return res;
    }


    //test code
    public static void main(String[] args) {
        Cows cows=new Cows();
        System.out.println(cows.countSum(411910837));//411910837
                                       //257149905
    }
}
