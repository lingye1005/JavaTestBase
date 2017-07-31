package innerclasses;

/**
 * Created by caoxiaohong on 16/12/18.
 */
public class DotThis {
    void f(){System.out.println("DotThis.f()");}
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }
    public static void main(String[] args){
        DotThis dotThis=new DotThis();//声明外部类;
        Inner inner=dotThis.inner();//声明内容类;
        inner.outer().f();//通过内部类调用外部类方法;
    }
}
