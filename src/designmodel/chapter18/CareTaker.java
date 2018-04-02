package designmodel.chapter18;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 09:26
 * @ProjectName: JavaBaseTest
 */
public class CareTaker{
    private RoleStateMemento memento;
    CareTaker(RoleStateMemento memento){
        this.memento=memento;
    }
    //get
    public RoleStateMemento getMemento() {
        return memento;
    }
}
