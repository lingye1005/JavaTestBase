package netmethod;

/**
 * Created by caoxiaohong on 17/1/14.
 */
abstract class Person {
    public abstract void eat();
}
interface annimal{
    void run();
}
public class AnonymousClassTest {
    public static void main(String[] args){
        Person person=new Person() {
            @Override
            public void eat() {
                System.out.println("this is eat() in main()");
            }
        };
        person.eat();
        annimal annimal=new annimal() {
            @Override
            public void run() {
                System.out.println("this is run() in main()");
            }
        };
        annimal.run();
    }
}
