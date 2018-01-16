package designmodel.fourteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/9 23:29
 * @ProjectName: JavaBaseTest
 */
public abstract class Subject {
    abstract void add(Observer observer);
    abstract void delete(Observer observer);
    abstract void notifyObservers();
    private String subjetctState;

    //获取主题状态
    public String getSubjetctState() {
        return subjetctState;
    }
    //设置主题状态
    public void setSubjetctState(String subjetctState) {
        this.subjetctState = subjetctState;
    }
}
