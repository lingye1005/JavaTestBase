package designmodel.sixthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/2 21:20
 * @ProjectName: JavaBaseTest
 */
public class Person {
    private String name;
    Person(){}//子类实例化时,默认调用父类的无参数构造器方法.如果没有这个方法,则编译报错.

    Person(String name){
        this.name=name;
    }
    public void operation(){
        System.out.println("this is :"+name);
    }
}
