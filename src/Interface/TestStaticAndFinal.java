package Interface;

/**
 * Created by caoxiaohong on 16/12/6.
 * page184 practice17
 */

interface  init{
    int n=1;
    public void play();
}

public class TestStaticAndFinal implements  init{
    static int m=0;
    public void play(){
       // n=0; 表示n不能被赋新值,所以n默认是final类型[1]
        System.out.println("this is play in main");
    }
    public static void main(String[] args){
       m=n+10;//n可以在static里面使用,说明n本身是static类型的数字.[2]
        // 综合[1]和[2]说明:接口中的域自动默认为static和final类型
    }
}
