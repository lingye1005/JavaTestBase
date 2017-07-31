package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 * 将测试代码放在嵌套类中
 * {main:TestBed$Tester}
 */
public class TestBed {
    public void f(){
        System.out.println("f()");
    }
    public static class Tester{
        public static void main(String[] args){
            TestBed testBed=new TestBed();
            testBed.f();
        }
    }
}
