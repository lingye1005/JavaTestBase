package designmodel.fourteenthchapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxh
 * @CreateTime: 18/1/10 09:11
 * @ProjectName: JavaBaseTest
 */
public class Boss extends Subject{
    private List<Observer> list=new ArrayList<>();

    //增加观察者
    public void add(Observer observer){
        list.add(observer);
    }
    //删除观察者
    public void delete(Observer observer){
        list.remove(observer);
    }
    //通知
    public void notifyObservers(){
        for(Observer s:list)
            s.update();
    }
}
