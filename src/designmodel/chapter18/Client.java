package designmodel.chapter18;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 09:38
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        GameRole role=new GameRole(11,22,33);
        //攻击前状态
        role.beforeAttack();
        //保存状态
        RoleStateMemento memento=role.getMemento();
        CareTaker careTaker=new CareTaker(memento);
        //攻击后状态
        role.afterAttack();
        //恢复后状态
        role.recover(careTaker);
    }
}
