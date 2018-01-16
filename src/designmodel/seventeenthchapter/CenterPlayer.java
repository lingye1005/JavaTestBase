package designmodel.seventeenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:25
 * @ProjectName: JavaBaseTest
 */
public class CenterPlayer extends Player {
    private String name;
    CenterPlayer(String name){
        super();
        this.name=name;
    }
    @Override
    void attack() {
        System.out.println("中锋"+name+"进攻");
    }

    @Override
    void defend() {
        System.out.println("中锋"+name+"防守");
    }
}
