package designmodel.eighthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:37
 * @ProjectName: JavaBaseTest
 */
public class SubOperation implements Operation {
    private int first,second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int getResult() {
        return first-second;
    }
}
