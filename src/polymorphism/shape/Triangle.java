package polymorphism.shape;

/**
 * Created by caoxiaohong on 16/11/26.
 */
public class Triangle extends Shape {
    @Override
    public void draw(){System.out.println("this is triangle draw");}
    @Override
    public void erase(){System.out.println("this is triangle erase");}
}
