package designmodel.delegate;

import java.util.Date;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 16:30
 * @ProjectName: JavaBaseTest
 */
public class NBAObserver{
    public NBAObserver(){
        System.out.println("正在观看NBA比赛!当前时间为:"+new Date());
    }
    public void stopWatchingNBA(Date date){
        System.out.println("领导回来了,快关闭NBA赛事直播!当前时间为:"+date);
    }
}
