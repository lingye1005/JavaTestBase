package polymorphism.shape;

import java.util.Random;

/**
 * Created by caoxiaohong on 16/11/26.
 */
public class RandomShapGenerator {
    Random random=new Random(47);
    public Shape next(){
        int rand=random.nextInt(3);
        switch (rand){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return  new Triangle();
        }
    }
}
