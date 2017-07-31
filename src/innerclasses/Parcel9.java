package innerclasses;

/**
 * Created by caoxiaohong on 17/1/16.
 * static inner class
 */
public class Parcel9 {
    private static class ParcelContents implements Contents{
        private int i=11;
        public int value(){return i;}
    }
    //嵌入类
    private static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label=whereTo;
        }
        public String readLabel(){return label;}

        //潜入类能包含任何其他静态元素:静态方法\静态变量\静态类
        public static void f(){}
        public static String str="so hot!";
        static class AnotherLevel{
            public static void f(){};
            public int i=10;
        }
    }
    public static Destination destination(String str){
        return new ParcelDestination(str);
    }
    public static Contents contents(){
        return new ParcelContents();
    }
    public static void main(String[] args){
        Contents contents=contents();
        Destination destination=destination("sh3sh3sh3");
    }
}
