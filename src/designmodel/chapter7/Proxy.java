package designmodel.chapter7;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 21:01
 * @ProjectName: JavaBaseTest
 */
public class Proxy extends Gift {
    private Persuit persuit;
    Proxy(SchoolGirl girl){
        persuit=new Persuit(girl);
    }


    @Override
    public void giveChocolate() {
        persuit.giveChocolate();
    }

    @Override
    public void giveDolls() {
        persuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        persuit.giveFlowers();
    }
}
