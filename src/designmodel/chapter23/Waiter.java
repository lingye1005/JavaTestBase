package designmodel.chapter23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxh
 * @CreateTime: 18/1/26 15:56
 * @ProjectName: JavaBaseTest
 */
public class Waiter{
    //用一个list保存很多请求的引用
    List<AbstractCommand> list=new ArrayList<>();
    //接受请求
    public void acceptRequest(AbstractCommand command){
        double a=Math.random()*10;
        if(a<=5){
            String type=command.getClass().getSimpleName();
            if(type.equals("BakeChickenWingCmd"))
                type="鸡翅";
            else
                type="羊肉";
            System.out.println("不好意思,"+type+"没有了,您可以看一下其他菜品");
        }else{
            list.add(command);
            System.out.println("记录下单日志,如桌号,时间等");
        }
    }
    //撤销请求
    public void cancelRequest(AbstractCommand command){
        list.remove(command);
    }
    //通知后厨做菜
    public void notifyCook(){
        list.forEach(command -> command.exeCommmand());
    }
}
