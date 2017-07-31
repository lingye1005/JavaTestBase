package containers;

/**
 * Created by caoxiaohong on 17/3/10.
 */
public abstract class Test<C> {
    String name;
    public Test(String name){this.name=name;}
    //对不同对test复写这个方法,返回测试中重复次数的数值;
    abstract int test(C container,TestParam tp);
}
