package designmodel.seventeenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:19
 * @ProjectName: JavaBaseTest
 */
public class ForwardsPlayer extends Player {
    private String name;
    ForwardsPlayer(String name){
        super();
        this.name=name;
    }
    @Override
    void attack() {
        System.out.println("前锋"+name+"进攻");
    }

    @Override
    void defend() {
        System.out.println("前锋"+name+"防守");
    }
}
