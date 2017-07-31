package innerclasses;

/**
 * Created by caoxiaohong on 17/1/15.
 * p199 practice
 */
class First{
    First(int x){
        System.out.println("this is First constructor and the value of x is "+x);
    }
    public String getStr(){
        class AboutStr{
            public void print(){
                System.out.println("this is in print()");
            }
        }
        return "ssss";
    }
}

public class Parcel8 {
    public First getFirst(int i){
        return new First(i) {
        };
    }
}
