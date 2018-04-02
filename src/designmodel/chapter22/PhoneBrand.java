package designmodel.chapter22;

/**
 * @Author: cxh
 * @CreateTime: 18/1/25 22:40
 * @ProjectName: JavaBaseTest
 */
public abstract class PhoneBrand {
    //持有软件的引用
    protected PhoneSoftWare softWare;
    public void setSoftWare(PhoneSoftWare softWare) {
        this.softWare = softWare;
    }

    //调用软件功能方法
    public abstract void run();
}
