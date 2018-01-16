package designmodel.sixteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 23:12
 * @ProjectName: JavaBaseTest
 */
public class Client{
    //test
    public static void main(String[] args) {
        Work work=new Work();
        work.time=10;
        work.working();

        work.time=11;
        work.working();

        work.time=13;
        work.working();

        work.time=14;
        work.working();

        work.time=18;
        work.working();

        work.time=20;
        work.working();

        work.time=21;
        work.working();

        work.time=22;
        work.isFinished=true;
        work.working();
    }
}
