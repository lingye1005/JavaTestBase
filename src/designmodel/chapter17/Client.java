package designmodel.chapter17;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:36
 * @ProjectName: JavaBaseTest
 */
public class Client{
    public static void main(String[] args) {
        //英国前锋
        ForwardsPlayer fp=new ForwardsPlayer("乔治");
        fp.attack();
        fp.defend();

        //英国中锋
        CenterPlayer cp=new CenterPlayer("约翰");
        cp.attack();
        cp.defend();

        //英国后卫
        GuardPlayer gp=new GuardPlayer("布莱克");
        gp.attack();
        gp.defend();

        //中国后卫
        Player chinese=new AdapterForChinesePlayer("姚明");
        chinese.attack();
        chinese.defend();
    }
}
