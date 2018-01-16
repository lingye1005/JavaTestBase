package designmodel.delegate;

import java.util.Date;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 16:37
 * @ProjectName: JavaBaseTest
 */
public class TVObserver {
    public TVObserver(){
        System.out.println("正在观看电视剧<<甄嬛传>>,当前时间为:"+new Date());
    }
    public void stopWatchingTV(Date date){
        System.out.println("领导回来了,快关闭电视剧播放.当前时间为:"+date);
    }
}
