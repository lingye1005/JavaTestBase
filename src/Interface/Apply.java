package Interface;

import java.util.*;

/**
 * Created by caoxiaohong on 16/12/4.
 */

class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){return input;}
}
class Upcase extends Processor{
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Splitter extends Processor{
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

//main process
public class Apply {
    public static void process(Processor p,String s){
        System.out.println("Using Processor "+ p.name());
        System.out.println(p.process(s));
    }
    public static String string="i believe i can do the best job!";
    public static void main(String[] args){
        process(new Upcase(),string);
        process(new Downcase(),string);
        process(new Splitter(),string);
    }
}
