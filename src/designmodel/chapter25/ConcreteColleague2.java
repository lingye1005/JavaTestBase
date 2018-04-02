package designmodel.chapter25;

/**
 * @Author: cxh
 * @CreateTime: 18/2/20 14:19
 * @ProjectName: JavaBaseTest
 */
public class ConcreteColleague2 extends Colleague {
    @Override
    public void send(String sendInfo) {
        System.out.println("提申请::美国->联合国安理会:"+sendInfo);
        super.mediate.declare(sendInfo,this);
    }

    @Override
    public void receive(String getInfo) {
        System.out.println("收通知::联合国安理会->美国:"+getInfo);
    }
}
