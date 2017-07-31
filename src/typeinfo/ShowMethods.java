package typeinfo;

import java.lang.reflect.*;
import java.util.Random;
import java.util.regex.*;

/**
 * Created by caoxiaohong on 17/2/28.
 * 类方法提取器
 */
public class ShowMethods {
    private static String usage=
            "usage:\n"+
                    "ShowMethods qualified.class.name\n"+
                    "To show all methods in class or:\n"+
                    "ShowMethods qualified.class.name word\n"+
                    "To search for methods involving 'word'";
    private static Pattern p=Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if(args.length<1){
            System.out.println(usage);
            System.exit(0);
        }
        int lines=0;
        try{
            Class<?> c=Class.forName(args[0]);
            Method[] methods=c.getMethods();
            Constructor[] ctors=c.getConstructors();

            if(args.length==1){
                for(Method method:methods){
                    p.matcher(method.toString()).replaceAll("");
                }
            }
            //Random rand=new Random(47);
            //int[][][] temp=new int[rand.nextInt()][][];

        } catch (ClassNotFoundException e){
            System.out.println("class not found"+e);
        }
    }
}
