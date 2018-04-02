package designmodel.chapter24;

/**
 * @Author: cxh
 * @CreateTime: 18/1/27 19:41
 * @ProjectName: JavaBaseTest
 */
public abstract class Handler{
    protected Handler handler;
    Handler(){}
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    abstract void getResult(Request request);
}
