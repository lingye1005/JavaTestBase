package designmodel.chapter16;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 22:59
 * @ProjectName: JavaBaseTest
 */
public class NoonState extends State {
    @Override
    void handler(Work work) {
        int currTime=work.time;
        if(currTime<=13){
            System.out.println("当前时间是:"+currTime+":00:00"+",午饭后,休息中");
        }else{
            work.setState(new AfterNoonState());
            work.working();
        }
    }
}
