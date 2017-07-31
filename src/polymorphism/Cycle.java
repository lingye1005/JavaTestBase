package polymorphism;

/**
 * Created by caoxiaohong on 16/11/28.
 * page168 practice
 */

class CycleBase{
    void balance(){System.out.println("this is CycleBase balance()");}
}
class Ubicycle extends CycleBase{
    void balance(){System.out.println("this is Ubicycle balance()");}
}
class Bbicycle extends CycleBase{
    void balace(){System.out.println("this is Bbicycle balance()");}
}
abstract class Hbicycle {
   // void balance(){System.out.println("this is Hbicycle balance()");}
    abstract void f();
}
class  hb extends Hbicycle{
   void f(){}
}
abstract class Te{
    abstract void f();
}

public class Cycle {
    public static void main(String[] args){
        //Ubicycle ubicycle=new Ubicycle();
        CycleBase cycleBase=new CycleBase();
        cycleBase.balance();
        /*Hbicycle hbicycle=new Hbicycle();
        hbicycle.balance();*/

    }
}
