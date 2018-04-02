package designmodel.chapter28;

/**
 * @Author: cxh
 * @CreateTime: 18/3/15 22:08
 * @ProjectName: JavaBaseTest
 */
public class ConcreteElmentA implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementA(this);
    }
}
