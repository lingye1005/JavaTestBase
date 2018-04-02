package designmodel.chapter16;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 22:43
 * @ProjectName: JavaBaseTest
 */
public class Work{
    //工作是否完成
    public boolean isFinished=false;
    //当前工作时间
    public int time;
    //工作状态
    private State state;
    Work(){
        state=new BeforeNoonState();
    }

    //设置工作状态
    public void setState(State state) {
        this.state = state;
    }

    //工作中
    public void working(){
        state.handler(this);
    }
}
