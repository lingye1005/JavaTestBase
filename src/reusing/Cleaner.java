package reusing;

/**
 * Created by caoxiaohong on 16/11/15.
 */
public class Cleaner {
    private String s="Cleaner";
    public void append(String s ){this.s+=s;}
    public void dilute(){append("dilute()");}
    public void apply(){append("apply()");}
    public void scruib(){append("scruib()");}
    public String toString(){return s;}

    public static void main(String[] args){
        Cleaner cleaner=new Cleaner();
        cleaner.dilute();
        cleaner.apply();
        cleaner.scruib();
        System.out.println(cleaner);
    }
}

