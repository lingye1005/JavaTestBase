package reusing;

/**
 * Created by caoxiaohong on 16/11/26.
 */
 class Cycle{
    void ride(Cycle cycle){
        System.out.println("this is Cycle"+cycle.toString());
    }
}
class Unicylce extends Cycle{
    void rideUnic(Cycle cycle){
        System.out.println("this is Unicycle"+cycle.toString());
    }
}
class  Bicycle extends Cycle{
    static int x;//静态变量只能在域中声明,不能在方法中声明;
    void rideBicy(Cycle cycle){
        System.out.println("this is Bicycle"+cycle.toString());
    }
}
class  Tricycle extends Cycle{
     void rideTric(Cycle cycle){
        System.out.println("this is Tricycle"+cycle);
    }
}
public class upcastingTest {

    public static void main(String[] args){
        Unicylce unicylce=new Unicylce();
        Bicycle bicycle=new Bicycle();
        Tricycle tricycle=new Tricycle();
        unicylce.rideUnic(unicylce);
        bicycle.rideBicy(bicycle);
        tricycle.rideTric(tricycle);
    }
}
