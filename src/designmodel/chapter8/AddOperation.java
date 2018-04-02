package designmodel.chapter8;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:30
 * @ProjectName: JavaBaseTest
 */
public class AddOperation implements Operation {
    private int first,second;

    @Override
    public void setFirst(int first) {
        this.first=first;
    }

    @Override
    public void setSecond(int second) {
        this.second=second;
    }

    public int getResult(){
        return first+second;
    }
}
