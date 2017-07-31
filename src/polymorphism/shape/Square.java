package polymorphism.shape;

/**
 * Created by caoxiaohong on 16/11/26.
 */
public class Square extends  Shape{
    @Override
    public void draw(){System.out.println("this is Square draw");}
    @Override
    public void erase(){System.out.println("this is Square erase");}
}
