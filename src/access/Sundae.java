package access;

/**
 * Created by caoxiaohong on 16/11/3.
 */
public class Sundae {
    public int h1=100;
    int h2=100;
    private int h3=100;

    private Sundae(){};
    static  Sundae makeSundae()
    {
        return  new Sundae();
    }
}
