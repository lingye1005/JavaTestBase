package designmodel.chapter1;

/**
 * @Author: cxh
 * @CreateTime: 17/12/31 18:04
 * @ProjectName: JavaBaseTest
 */
public class OperationSubs extends Operation {

    @Override
    public int getResult() {
       return super.getFirst()-super.getSecond();
    }

    @Override
    public void setFirst(int first) {
        super.setFirst(first);
    }

    @Override
    public void setSecond(int second) {
        super.setSecond(second);
    }
}
