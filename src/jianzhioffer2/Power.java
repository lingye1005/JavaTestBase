package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/24 18:35
 * @ProjectName: JavaBaseTest
 * 面试题11
 */
public class Power{
    public double Power(double base, int exponent) {
        if(base-0>=-0.00000001 && base-0<=0.00000001) //base=0的表达式,不能用==,因为double精度问题
            return 0;
        if(exponent==0)
            return 1;
        if(exponent>0){
            return getPow(base,exponent);
        }else{
            exponent=(~exponent)+1;
            return 1/getPow(base,exponent);
        }

    }

    /**
     * base>0 且 exponent>0
     * @param base
     * @param exponent
     * @return
     */
    private static double getPow(double base,int exponent){
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        double res=getPow(base,exponent>>1);
        res*=res;
        if((exponent & 1)==1)//如果exponent为奇数,则需要再乘一次base
            res*=base;
        return res;
    }

    //test
    public static void main(String[] args) {
        Power test=new Power();
        System.out.println(test.Power(0,0));
    }
}
