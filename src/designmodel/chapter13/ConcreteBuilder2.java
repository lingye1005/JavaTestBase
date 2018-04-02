package designmodel.chapter13;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 23:41
 * @ProjectName: JavaBaseTest
 */
public class ConcreteBuilder2 implements Builder {
    Product product;
    ConcreteBuilder2(){
        product=new Product();
    }

    @Override
    public void buildPartA() {
        product.addProperties("添加部件X");
    }

    @Override
    public void buildPartB() {
        product.addProperties("添加部件Y");
    }

    @Override
    public void buildPartC() {
        product.addProperties("添加部件Z");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
