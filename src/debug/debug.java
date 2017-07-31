package debug;

/**
 * Created by caoxiaohong on 16/11/6.
 */
public class debug {
    public static int ht=100;
    static int htt=100;
    private int htttt=100;
    public static void debug1()
    {
        System.out.println("this is debug");
    }
    private debug(){};
    public static debug makeAsundae()
    {
        return new debug();
    }
    protected void testProtected(){};
}
