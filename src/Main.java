/**
 * Created by cxh  on 17/07/21.
 */


public class Main {
    static void get(){
        System.out.println("testmethod");
    }
    private int i;
    Main(){
        this.j=2;
        this.i=0;
        yy=2;
        this.xx=1;
    }
    static int xx;
    static{
        xx=0;
        yy=0;
        Main a=new Main();
        a.i=0;
        //this.xx=0;
//        this.j=2;
//        this.i=0;
    }
    static int yy;
    static void ss(){
        j=0;
        xx=2;
        //i=0;
    }
    private  static int j;
    public static void main(String[] args) {

    }
}
