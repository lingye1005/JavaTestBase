package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 */
interface xx{
    void fn();
    //void fh();
    class xxImpl implements xx{
        public void fn(){
            System.out.println("fn() in xxImpl()");
        }
        public xx getXx(){
            return new xxImpl();
        }
    }
}

class MNA{
    private void f(){}
    class A{
        private void g(){}
        class B{
            void h(){
                f();
                g();
            }
        }
    }
}
    /*class ee{}
    class dd extends ee,MNA{}*/
    /*interface GA{}
    interface  xm{}
    class tu implements GA,xm{}*/

public class MultiNestingAccessing {
    public static void main(String[] args) {
        MNA mna=new MNA();
        MNA.A a=mna.new A();
        MNA.A.B b=a.new B();
        //MNA.A.B x=new MNA.A.B();只能通过上面的方法创建内部类;.new方法;
        b.h();
    }
}
