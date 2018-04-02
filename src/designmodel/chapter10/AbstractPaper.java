package designmodel.chapter10;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 19:15
 * @ProjectName: JavaBaseTest
 */
public abstract class AbstractPaper {
    //三个抽象行为,作为逻辑骨架的组合内容.
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();
    public abstract void primitiveOperation3();

    //逻辑框架1,组合了1,2,3抽象行为
    public void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        primitiveOperation3();
    }
}
