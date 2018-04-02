package designmodel.chapter13;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 23:43
 * @ProjectName: JavaBaseTest
 * 指挥者
 */
public class Director {
    public void build(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
