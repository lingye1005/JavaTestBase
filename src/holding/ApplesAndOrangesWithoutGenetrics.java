package holding;

import java.util.ArrayList;
import java.util.*;
/**
 * Created by caoxiaohong on 17/2/21.
 */
class Apple{
    private static long counter;
    private final long id=counter++;
    public long id(){return id;}
}
class Orange{}

public class ApplesAndOrangesWithoutGenetrics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apple=new ArrayList();
        for(int i=0;i<3;i++){
            apple.add(new Apple());
        }
        apple.add(new Orange());
        for(int i=0;i<apple.size();i++){
            //虽然编译本身并未报错,但是运行时报异常:橘子无法转换为苹果
            ((Apple)apple.get(i)).id();//orange改为apple
        }

        //test2
        ArrayList<Apple> apples=new ArrayList<Apple>();
        for(int i=0;i<i;i++){
            apples.add(new Apple());
        }
        //apples.add(new Orange());
    }
}
