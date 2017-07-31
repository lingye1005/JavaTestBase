package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.text.Format;

/**
 * Created by caoxiaohong on 17/3/16.
 */

/*水果名称注解*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName{
    String value() default "";
}

/*水果颜色注解*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor{
    //颜色枚举
     public enum Color{Green,Yellow,Red}
    //颜色属性
     Color fruitColor() default Color.Red;
}

/*水果供应商的注解*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface  FruitProvider{
    //供应商编号
    public int id() default -1;
    //供应商名称
    public String name() default "";
    //供应商地址
    public String address() default "";
}

/*注解使用*/
class Apple{
    @FruitName("Apple")
    private String appleName;
    public String getAppleName() {
        return appleName;
    }
    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    @FruitColor()
    private String appleColor;
    public String getAppleColor() {
        return appleColor;
    }
    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    @FruitProvider(id=2,name="山东烟台红富士集团",address = "山东省烟台市燕达大厦98号3301")
    private  String appleProvider;
    public String getAppleProvider() {
        return appleProvider;
    }
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public void displayName(){
        System.out.println("水果的名字:苹果");
    }
}

/*注解处理器*/
class FruitInfoUtil{
    public static void getFruitInfo(Class<?> clazz){
        String strName="苹果名称:";
        String strColor="苹果颜色:";
        String strProvider="供应商信息:";
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName=(FruitName)field.getAnnotation(FruitName.class);
                strName+=fruitName.value();
                System.out.println(strName);
            }
            if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor=(FruitColor)field.getAnnotation(FruitColor.class);
                strColor+=fruitColor.fruitColor();
                System.out.println(strColor);
            }
            if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider=(FruitProvider)field.getAnnotation(FruitProvider.class);
                strProvider+="供应商编号:"+fruitProvider.id()+"供应商名称:"+fruitProvider.name()+"供应商地址:"+fruitProvider.address();
                System.out.println(strProvider);
            }
        }
    }
}

public class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
