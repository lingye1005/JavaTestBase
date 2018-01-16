package designmodel.eighthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:36
 * @ProjectName: JavaBaseTest
 */
public class SubFactory implements CreateFactory {
    @Override
    public Operation getOperation() {
        return new SubOperation();
    }
}
