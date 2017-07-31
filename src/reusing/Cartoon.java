package reusing;

/**
 * Created by caoxiaohong on 16/11/15.
 */
class Art{
        Art(){System.out.println("this is Art()");}
}
class Drawing extends Art{
    Drawing(){System.out.println("this is Drawing()");}
}
public class Cartoon extends Drawing{
    //public Cartoon(){System.out.println("this is Cartoon()");}
    public static void main(String[] args){
        Cartoon x=new Cartoon();
    }
}
