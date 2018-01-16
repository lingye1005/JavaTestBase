package designmodel.sixthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/2 21:31
 * @ProjectName: JavaBaseTest
 */
public class TShirts extends Decorator {
    @Override
    public void operation() {
        super.operation();
        //调用自己的方法
        funcSelf();
    }
    private void funcSelf(){
        System.out.println("衬衫");
    }
}
