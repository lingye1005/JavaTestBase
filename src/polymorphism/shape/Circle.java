package polymorphism.shape;

/**
 * Created by caoxiaohong on 16/11/26.
 * 8.2转机 练习题2(1)
 */
public class Circle extends Shape {
    @Override
    public void draw(){System.out.println("this is circle draw()");}
    @Override
    public void erase(){System.out.println("this is circle erease()");}
    @Override
    public void print(){System.out.println("this is print belong to Circle");}
}
