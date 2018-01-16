package designmodel.thirteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 23:35
 * @ProjectName: JavaBaseTest
 */
public interface Builder {
    //为产品添加各个组成部分
    void buildPartA();
    void buildPartB();
    void buildPartC();

    //返回创建的产品
    Product getProduct();
}
