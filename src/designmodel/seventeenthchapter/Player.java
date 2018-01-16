package designmodel.seventeenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:14
 * @ProjectName: JavaBaseTest
 */
public  abstract class Player{
    private String name;
    Player(){}
    Player(String name){
        this.name=name;
    }
    //进攻
    abstract void attack();
    //防守
    abstract void defend();
    //get
    public String getName() {
        return name;
    }
}
