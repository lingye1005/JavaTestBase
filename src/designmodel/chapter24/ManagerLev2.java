package designmodel.chapter24;

/**
 * @Author: cxh
 * @CreateTime: 18/1/27 19:43
 * @ProjectName: JavaBaseTest
 */
public class ManagerLev2 extends Handler {
    @Override
    void getResult(Request request) {
        String name=request.getName();
        int days=request.getDays();
        if(days<=5){
            System.out.println(name+"请假"+days+"天的请求得到批准! and 请假级别:lev2");
        }else{
            super.handler.getResult(request);
        }
    }
}
