package reusing;

/**
 * Created by caoxiaohong on 16/11/15.
 */
public class DetegentNext extends Detergent {
    public void sterilize(){append("this is DetegentNext.sterlize()");}
    public void scruib(){
        append("this is DetegentNext.scruib()");
    }

    public static void main(String[] args){
        DetegentNext detegentNext=new DetegentNext();
        detegentNext.foam();
        detegentNext.scruib();//覆盖scrub();
        detegentNext.dilute();
        System.out.println(detegentNext);
    }
}
