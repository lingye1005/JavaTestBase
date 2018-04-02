package designmodel.chapter24;

/**
 * @Author: cxh
 * @CreateTime: 18/1/27 19:43
 * @ProjectName: JavaBaseTest
 */
public class ManagerLev3 extends Handler {
    @Override
    void getResult(Request request) {
        String name=request.getName();
        int days=request.getDays();
        System.out.println(name+"请假"+days+"天的请求得到批准! and 请假级别:lev3");
    }
}
