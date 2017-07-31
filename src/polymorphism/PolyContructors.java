package polymorphism;

/**
 * Created by caoxiaohong on 16/11/27.
 * page164 practice15
 */

class Graph{
    void draw(){System.out.println("this is Graph draw()");}
    Graph(){
        System.out.println("this is graph before draw()");
        draw();
        System.out.println("this is graph after draw()");
    }
}
class RoundGraph extends Graph{
    private int redis=1;
    RoundGraph(int r){
        redis=r;
        System.out.println("this is redis="+redis);
    }
    void draw(){
        System.out.println("this is RoundGraph draw() and redis="+redis);
    }
}

public class PolyContructors {
    public static void main(String[] args){
        new RoundGraph(4);
    }
}
