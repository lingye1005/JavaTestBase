package innerclasses;

/**
 * Created by caoxiaohong on 17/1/16.
 * 接口内部类
 */
public interface ClassInInnerClass {
    void howdy();
    class Test implements ClassInInnerClass{
        public void howdy(){
            System.out.println("Howdy()");
        }
        public static void main(String[] args){
            new Test().howdy();
        }
    }
}
