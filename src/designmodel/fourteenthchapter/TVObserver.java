package designmodel.fourteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/9 23:45
 * @ProjectName: JavaBaseTest
 */
public class TVObserver implements Observer {
    private String name;//看电视的人名字
    private Boss subject;//主题
    public TVObserver(String name,Boss subject){
        this.name=name;
        this.subject=subject;
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjetctState()+","+name+","+"快继续工作~");
    }
}
