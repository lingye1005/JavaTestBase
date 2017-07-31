package innerclasses.controller;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by caoxiaohong on 17/1/19.
 */
abstract class Event{
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime=delayTime;
    }
    public void start(){
        eventTime=System.nanoTime()+delayTime;
    }
    public boolean ready(){
        return System.nanoTime()>=eventTime;
    }
    public abstract void action();
}

class Controller {
    private List<Event> eventList=new ArrayList<Event>();
    public void addEvent(Event e){
        eventList.add(e);
    }
    public void run(){
        while (eventList.size()>0){
            for(Event e:new ArrayList<Event>(eventList)){
                if(e.ready()){
                    System.out.println(e);//输出e是森么?
                    e.action();//执行e事件
                    eventList.remove(e);//删除e对象
                }
            }
        }
    }
}
public class GreenhouseControls extends Controller{
    //灯控制
    private boolean light=false;
    public class LightOn extends Event{
        public LightOn(long delayTime){super(delayTime);}//内部类没有默认构造器,需要自己写好
        public  void action(){}
    }
}
