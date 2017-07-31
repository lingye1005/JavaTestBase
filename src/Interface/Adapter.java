package Interface;

/**
 * Created by caoxiaohong on 16/12/3.
 */
public class Adapter  {
    private Adaptee adaptee;
    public  void getAdaptee(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    public void setExample1(){
        adaptee.setExample1();
    }
    public void setExample2(){
        System.out.println("this is Adapter setExamle2()");

    }
}
