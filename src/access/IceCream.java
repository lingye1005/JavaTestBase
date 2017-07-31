package access;

/**
 * Created by caoxiaohong on 16/11/3.
 */
public class IceCream {

    public static void main(String[] args)
    {
        //Sundae s=new Sundae(); private
        Sundae s=Sundae.makeSundae();
        int test1=s.h1;
        int test2=s.h2;
    }
}
