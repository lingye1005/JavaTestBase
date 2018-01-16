package designmodel.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxh
 * @CreateTime: 18/1/12 11:23
 * @ProjectName: JavaBaseTest
 */
public class EventHandler {
    //保存了很多event的引用
    private List<Event> objects;
    public EventHandler(){
        objects=new ArrayList<>();
    }

    //添加某个event
    public void addEvent(Object object,String name,Object... args){
        objects.add(new Event(object,name,args));
    }
    //触发所有引用的event
    public void notifyEvents() throws Exception{
        for(Event e:objects)
            e.invoke();
    }
}
