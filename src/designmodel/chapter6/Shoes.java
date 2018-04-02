package designmodel.chapter6;

/**
 * @Author: cxh
 * @CreateTime: 18/1/2 21:36
 * @ProjectName: JavaBaseTest
 */
public class Shoes extends Decorator {
    @Override
    public void operation() {
        super.operation();
        //调用自己的方法
        funcSelf();
    }
    private void funcSelf(){
        System.out.println("高跟鞋");
    }
}
