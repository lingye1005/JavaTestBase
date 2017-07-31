package reusing;

/**
 * Created by caoxiaohong on 16/11/20.
 * 7.2 practice 9
 */
class Component1{
    Component1(){
        System.out.println("this is Component1 cons...");
    }
}
class Component2{
    Component2(){
        System.out.println("this is Component2 cons...");
    }
}
class Component3{
    Component3(){
        System.out.println("this is Component3 cons...");
    }
}
class root1{
    root1(){System.out.println("this is root1 cons...");}
    Component1 com1=new Component1();
    Component2 com2=new Component2();
    Component3 com3=new Component3();
}
class  root2 extends root1{
    root2(){System.out.println("this is root2 cons...");}
}

public class Root {
    public  static void main(String[] args){
        root2 r=new root2();
    }
}
