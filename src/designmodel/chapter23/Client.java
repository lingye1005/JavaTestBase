package designmodel.chapter23;

/**
 * @Author: cxh
 * @CreateTime: 18/1/26 15:52
 * @ProjectName: JavaBaseTest
 */
public class Client{
    //测试类
    public static void main(String[] args) {
        Waiter waiter=new Waiter();
        Barbecuer cook=new Barbecuer();

        BakeChickenWingCmd chickenWingCmd=new BakeChickenWingCmd(cook);
        BakeMuttonCmd muttonCmd=new BakeMuttonCmd(cook);
        waiter.acceptRequest(chickenWingCmd);
        waiter.acceptRequest(muttonCmd);

        //通知厨师
        waiter.notifyCook();
    }
}
