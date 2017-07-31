package polymorphism.shape;

/**
 * Created by caoxiaohong on 16/11/26.
 */
public class Shapes {
    //shape生成工厂
    private static RandomShapGenerator randomShapGenerator=new RandomShapGenerator();

    public static void main(String[] args){
        Shape[] shapes=new Shape[10];
        for(int i =0;i<10;i++){
            shapes[i]=randomShapGenerator.next();
        }
        for(Shape s: shapes){
            s.print();
        }
    }
}
