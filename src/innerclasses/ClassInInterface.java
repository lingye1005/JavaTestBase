package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 */
interface InterfaceWithClass{
   //public static void tete();
    void fun();
    class InnerClass {
        InnerClass(){
            System.out.println("constructor of innerclass!");
        }
        String getStr(){
            return "sssssss";
        }
        public void fun(){
            System.out.println("fun()");
        }
        public static void getFun(){
        }
    }
}
class getInterfaceWithClass implements InterfaceWithClass{
    @Override
    public  void fun(){
        System.out.println("fffff");
    }
}
class InterfaceWithClassImpl implements InterfaceWithClass{
   public void fun(){
       System.out.println("impl in IWCI()");
   }
    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}
public class ClassInInterface {
    public InterfaceWithClass getInterface(){
        return new InterfaceWithClassImpl();
    }
    InterfaceWithClass.InnerClass innerClass=new InterfaceWithClassImpl.InnerClass();

    public static void main(String[] args) {

    }
}
