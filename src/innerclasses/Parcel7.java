package innerclasses;

/**
 * Created by caoxiaohong on 17/1/15.
 * P196 practice9
 */
interface inter1{
    String getStr();
}
public class Parcel7 {
    public inter1 getInter1(String s){
        class interImpl implements inter1{
            private String id;
            interImpl(String str){
                id=str;
            }
            public String getStr(){
                return id;
            }
        }
        interImpl inter=new interImpl("this is practice9");
        return inter;
    }
}
