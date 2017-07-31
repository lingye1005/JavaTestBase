package polymorphism.music3;

/**
 * Created by caoxiaohong on 16/11/26.
 */
class Rodent{
    void r1(){
        r2();
    }
    void r2(){
        System.out.println("this is r2()");
    }
}
class Mouse extends Rodent{
    @Override
    void r2(){
        System.out.println("this is Mouse r2()");
    }
}
public class test {
    static void tes(Rodent rodent){
        rodent.r1();
    }
    public static void main(String[] args){
        Mouse mouse=new Mouse();
        tes(mouse);
    }
}
