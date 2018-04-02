package designmodel.chapter8;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:34
 * @ProjectName: JavaBaseTest
 */
public class AddFactory implements CreateFactory {
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }

}
