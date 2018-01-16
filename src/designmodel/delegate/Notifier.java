package designmodel.delegate;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 11:36
 * @ProjectName: JavaBaseTest
 */
public abstract class Notifier {
    private EventHandler eventHandler=new EventHandler();
    //增加需要帮忙放哨的同事
    public abstract void addListener(Object object,String name,Object... args);
    //告诉所有需要帮忙放哨的同事:领导回来啦
    public abstract void notifyX();

    //get,set
    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
}
