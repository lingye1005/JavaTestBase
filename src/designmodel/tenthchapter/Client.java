package designmodel.tenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 19:27
 * @ProjectName: JavaBaseTest
 */
public class Client{
    public static void main(String[] args) {
        //A试卷
        System.out.println("A试卷信息:");
        PaperA a=new PaperA();
        a.templateMethod();


        //B试卷
        System.out.println("B试卷信息:");
        PaperB b=new PaperB();
        b.templateMethod();
    }
}
