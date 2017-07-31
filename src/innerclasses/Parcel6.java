package innerclasses;

/**
 * Created by caoxiaohong on 17/1/15.
 * nesting a class within a scope   在某区域内嵌一个类
 */
public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){
                    id=s;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip trackingSlip=new TrackingSlip("slip");
            String s=trackingSlip.getSlip();
        }
        //cant use it in this scope;because it is out of scope;
        //TrackingSlip trackingSlip=new TrackingSlip("slip");
    }
    public void treack(){internalTracking(true);}
    public static void main(String[] args){
        Parcel6 p=new Parcel6();
        p.treack();
    }
}
