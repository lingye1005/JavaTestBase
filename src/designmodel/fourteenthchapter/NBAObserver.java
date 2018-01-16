package designmodel.fourteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/9 23:28
 * @ProjectName: JavaBaseTest
 */
public class NBAObserver implements Observer {
    private Subject subject;//关注主题
    private String name;//观察者名字
    public NBAObserver(String name,Subject subject){//参数Subject体现了:具体依赖抽象原则
        this.name=name;
        this.subject=subject;
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjetctState()+","+name+","+"快继续工作~");
    }
}
