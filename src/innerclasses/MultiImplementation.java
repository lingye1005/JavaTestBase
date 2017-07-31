package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 */
class D{
    public void getCao(){
        System.out.println("this is getCao");
    }
    void h(){
        System.out.println("this is h()");
    }
    private int getNum(){
        System.out.println("this is getNum()");
        return 10;
    }
}
abstract class E{
    public int getInt(int i){
        return i;
    }
    void j(){
        System.out.println("this is j()");
    }
    private String getStr(){
        return "private getStr()";
    }
    //D getD(){return new D();}因为不是抽象类,所有可以这样写;
}
class Z extends D{
    E makeE(){
        return new E(){};
    }
}
public class MultiImplementation {
    static void takesD(D d){}
    static void takesE(E d){}
    public static void main(String[] args) {
        Z z=new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

