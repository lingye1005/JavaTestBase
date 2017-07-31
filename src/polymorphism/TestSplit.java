package polymorphism;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by caoxiaohong on 16/12/3.
 */
class Processor{
    String test(String intput){
        return Arrays.toString(intput.split(" "));
    }
    String process(){return getClass().getName();}
}
public class TestSplit {
    public static void main(String[] args){
        Processor processor=new Processor();
        System.out.println(processor.test("this is a test of split"));//输出:[this, is, a, test, of, split]
        System.out.print(processor.process());//输出:包名+类名----polymorphism.Processor
    }
}
