package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caoxiaohong on 17/3/18.
 * 自己写注解处理器
 */

//编写自定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
    public int id() default 1;
    public String description() default "no descrition >>>";
}
//应用自定义注解
class PasswordUtils{
    @Test(id=23,description = "pass1")
    public boolean pass11(){
        System.out.println("this is pass1");
        return true;
    }
    @Test(id=22,description = "pass2")
    public String pass2(){
        System.out.println("this is pass2");
        return "pass2";
    }
    @Test(id=21)
    public int pass3(){
        System.out.println("this is pass3");
        return 1;
    }
}
//如果没有一个可以读取注解的工具,那么注解就不会比注释更有用.使用注解的过程中,很重要的一个部分就是:创建与使用注解处理器.
//注解处理器
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for(Method m:cl.getDeclaredMethods()){//反射
            Test t=m.getAnnotation(Test.class);//反射
            if(t!=null){
                System.out.println("found use case:"+t.id()+" "+t.description());
                useCases.remove(new Integer(t.id()));//?????
            }
        }
        for(int i:useCases){
            System.out.println("warning :missing use case:"+i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        Collections.addAll(list,24,23,22,21);
        trackUseCases(list,PasswordUtils.class);
    }
}
