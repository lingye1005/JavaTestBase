package designmodel.chapter23;

/**
 * @Author: cxh
 * @CreateTime: 18/1/26 15:52
 * @ProjectName: JavaBaseTest
 */
public abstract class AbstractCommand{
    protected Barbecuer barbecuer;
    AbstractCommand(){}

    //执行命令
    public abstract void exeCommmand();
}
