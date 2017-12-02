package sourcecode.analysis;

import java.math.BigDecimal;

public class testCode  {
    public static void main(String[] args){
        BigDecimal a=new BigDecimal(2.30);
        BigDecimal b=new BigDecimal(2.3);
        System.out.println("a.equals(b): "+a.equals(b));
        System.out.println("a.compareTo(b): "+a.compareTo(b));
    }
}
