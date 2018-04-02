package designmodel.chapter8;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:43
 * @ProjectName: JavaBaseTest
 */
public class MulOperation implements Operation {
    private int first,second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int getResult() {
        return first*second;
    }
}
