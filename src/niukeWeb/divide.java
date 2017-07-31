package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/12.
 * Divide two integers without using multiplication, division and mod operator.
 * 两个数相除,但不能使用乘法,除法,取余数操作.
 */
public class divide {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || dividend<divisor)
            return 0;
        else if(dividend==divisor){
            return 1;
        }else{
           return dividend/divisor;
        }
    }

    public static void main(String[] args) {
        divide de=new divide();
        int a=de.divide(81,2);
        System.out.println(a);
    }
}
