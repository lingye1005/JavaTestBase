package designmodel.delegate;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 16:13
 * @ProjectName: JavaBaseTest
 */
public class NotifierA extends Notifier{

    @Override
    public void addListener(Object object, String name, Object... args) {
        getEventHandler().addEvent(object,name,args);
    }

    @Override
    public void notifyX(){
        try{
            getEventHandler().notifyEvents();
        }catch (Exception e){
            System.out.println("通知同事时出错!!!");
        }
    }
}
