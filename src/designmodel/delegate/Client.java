package designmodel.delegate;

import java.util.Date;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 16:40
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        //观察者.  创建时起,开始做自己的事情
        NBAObserver nbaObserver=new NBAObserver();
        TVObserver tvObserver=new TVObserver();
        //主题(通知者)
        NotifierA notifierA=new NotifierA();

        //为主题添加观察者
        notifierA.addListener(nbaObserver,"stopWatchingNBA",new Date());
        notifierA.addListener(tvObserver,"stopWatchingTV",new Date());

        //主题状态改变,通知观察者
        notifierA.notifyX();
    }

}
