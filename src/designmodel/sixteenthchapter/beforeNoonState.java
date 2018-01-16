package designmodel.sixteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 22:49
 * @ProjectName: JavaBaseTest
 */
public class BeforeNoonState extends State {
    @Override
    void handler(Work work) {
        int currTime=work.time;
        if(currTime<12){
            System.out.println("当前时间是:"+currTime+":00:00"+",精力充沛的工作");
        }else{
            work.setState(new NoonState());
            work.working();
        }
    }
}
