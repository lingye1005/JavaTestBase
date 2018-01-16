package designmodel.sixteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 22:59
 * @ProjectName: JavaBaseTest
 */
public class AfterNoonState extends State {
    @Override
    void handler(Work work) {
        int curTime=work.time;
        if(curTime<=18){
            System.out.println("当前时间是:"+curTime+":00:00"+",效率一般的工作着");
        }else{
            work.setState(new NightState());
            work.working();
        }
    }
}
