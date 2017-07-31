package Interface;

/**
 * Created by caoxiaohong on 16/12/17.
 */

interface Service {
    void method1();
    void method2();
}
interface ServiceFactory{
    Service getService();
}

class Implementstation1 implements Service{
    Implementstation1(){}
    int temp=0;
    public void method1(){System.out.println("Implementstation1 method1()");
        this.temp=1;
        System.out.println(this.temp);
        int temp=3;
        System.out.println(temp);
    }
    public void method2(){System.out.println("Implementstation1 method2()");}
}
class  ImplementstationFactory1 implements  ServiceFactory{
    ImplementstationFactory1(){}
    public Service getService(){
        return new Implementstation1();//注意此处返回的为接口的实现类,创建一个这样的类;
    }
}
class Implementstation2 implements Service{
    Implementstation2(){}
    public void method1(){System.out.println("Implementstation2 method1()");}
    public void method2(){System.out.println("Implementstation2 method2()");}
    //start 简直不能更加优雅,是不是呢
    public static ServiceFactory factory=new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementstation2();
        }
    };
    //end
}
class ImplementstatonFaction2 implements ServiceFactory{
    ImplementstatonFaction2(){}
    public Service getService(){
        return new Implementstation2();
    }
}


public class Factories {
    public static void serviceConsumer(ServiceFactory fact){
        Service s=fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        serviceConsumer(new ImplementstationFactory1());
        serviceConsumer(new ImplementstatonFaction2());
    }
}
