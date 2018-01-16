package designmodel.sixteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 23:00
 * @ProjectName: JavaBaseTest
 */
public class NightState extends State{
    @Override
    void handler(Work work) {
        if(work.isFinished){
            System.out.println("今天工作已完成,准备回家~");
            return;
        }else{
            int curTime=work.time;
            System.out.println("当前时间是:"+curTime+":00:00,"+"继续加班,疲惫至极!!!");
        }
    }
}
