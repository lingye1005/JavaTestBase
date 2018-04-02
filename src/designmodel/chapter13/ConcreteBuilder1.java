package designmodel.chapter13;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 23:39
 * @ProjectName: JavaBaseTest
 */
public class ConcreteBuilder1 implements Builder {
    Product product;
    ConcreteBuilder1(){
        product=new Product();
    }

    @Override
    public void buildPartA() {
        product.addProperties("添加部件A");
    }

    @Override
    public void buildPartB() {
        product.addProperties("添加部件B");
    }

    @Override
    public void buildPartC() {
        product.addProperties("添加部件C");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
