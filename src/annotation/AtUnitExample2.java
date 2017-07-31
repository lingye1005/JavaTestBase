package annotation;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by caoxiaohong on 17/3/19.
 */
public class AtUnitExample2 {
    public String methodOne(){
        return "This is methodOne";
    }
    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }
    @Test void assertExample(){
        assert 1==2:"What a surprise";
    }
    @Test void exceptionExample() throws IOException{
        new FileInputStream("nofile.txt");
    }
    @Test boolean assertAndReturn(){
        assert methodTwo()==2:"methodTwo must equals 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) throws Exception {
        //OSExecute.command("");
    }
}
