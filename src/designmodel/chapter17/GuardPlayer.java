package designmodel.chapter17;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:27
 * @ProjectName: JavaBaseTest
 */
public class GuardPlayer extends Player {
    private String name;
    GuardPlayer(String name){
        super();
        this.name=name;
    }


    @Override
    void attack() {
        System.out.println("后卫"+name+"进攻");
    }

    @Override
    void defend() {
        System.out.println("后卫"+name+"防守");
    }
}
