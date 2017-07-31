package reusing;

import java.util.Random;

/**
 * Created by caoxiaohong on 16/11/24.
 * 7.8final 练习题18
 */

class finalTest{
    public void tt1(){}
    public final void tt2(){}
    private final void tt3(){}
}

public class testFinal extends finalTest{

    @Override
    public void tt1(){}
    //@Override ---final 方法无法进行覆盖
    //public final void tt2(){}

    testFinal(final int i){System.out.println(i);}

    private static Random random=new Random(47);

    static int t1=random.nextInt();

    final int t3=random.nextInt();

    static final int t2=33;

    void testArgFinal(final int i){
        //i++;
        System.out.println(i);
    }

    public static void main(String[] args){
        testFinal testFinal=new testFinal(2);
        System.out.print(testFinal.t1);System.out.println("");
        System.out.print(testFinal.t2);System.out.println("");
        System.out.print(testFinal.t3);System.out.println("");
    }
}
