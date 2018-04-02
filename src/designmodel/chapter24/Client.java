package designmodel.chapter24;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/1/27 19:40
 * @ProjectName: JavaBaseTest
 */
public class Client{
    public static void main(String[] args) {
        ManagerLev1 lev1=new ManagerLev1();
        ManagerLev2 lev2=new ManagerLev2();
        ManagerLev3 lev3=new ManagerLev3();
        lev1.setHandler(lev2);
        lev2.setHandler(lev3);

        Request request1=new Request("李静",3);
        Request request2=new Request("黎明",10);
        Request request3=new Request("周青",4);
        Request request4=new Request("纪静",1);
        ArrayList<Request> list=new ArrayList<>();
        list.add(request1);
        list.add(request2);
        list.add(request3);
        list.add(request4);
        list.stream().forEach(request -> lev1.getResult(request));
    }
}
