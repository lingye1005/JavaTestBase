package reusing;

/**
 * Created by caoxiaohong on 16/11/15.
 */
public class Detergent  extends Cleaner{
    public void scruib(){
        append("Detergent.scrub()");
        super.scruib();
    }
    public void foam(){append("Detergent.foam()");}
    public static void main(String[] args){
        Detergent detergent=new Detergent();
        detergent.apply();
        detergent.dilute();
        detergent.scruib();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("the next output is Cleaner`s content:");
        Cleaner.main(args);
    }
}
