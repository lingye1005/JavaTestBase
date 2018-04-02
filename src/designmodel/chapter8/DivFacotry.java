package designmodel.chapter8;

/**
 * @Author: cxh
 * @CreateTime: 18/1/6 11:43
 * @ProjectName: JavaBaseTest
 */
public class DivFacotry implements CreateFactory {
    @Override
    public Operation getOperation() {
        return new DivOperation();
    }
}
