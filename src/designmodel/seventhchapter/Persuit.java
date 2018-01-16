package designmodel.seventhchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 21:00
 * @ProjectName: JavaBaseTest
 */
public class Persuit extends Gift {
    private SchoolGirl schoolGirl;
    Persuit(SchoolGirl girl){
        this.schoolGirl=girl;
    }

    @Override
    public void giveChocolate() {
        System.out.println("persuit gives chocolate");
    }

    @Override
    public void giveDolls() {
        System.out.println("persuit gives dolls");
    }

    @Override
    public void giveFlowers() {
        System.out.println("persuit gives flowers");
    }
}
