package designmodel.chapter14;

/**
 * @Author: cxh
 * @CreateTime: 18/1/10 09:08
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        Boss boss=new Boss();
        NBAObserver nbaObserver=new NBAObserver("李明浩",boss);
        TVObserver tvObserver=new TVObserver("李沁",boss);
        //add
        boss.add(nbaObserver);
        boss.add(tvObserver);
        //delegate

        //boss状态转变,通知观察者
        boss.setSubjetctState("领导回来了");
        boss.notifyObservers();
    }
}
