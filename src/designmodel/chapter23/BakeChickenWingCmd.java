package designmodel.chapter23;

/**
 * @Author: cxh
 * @CreateTime: 18/1/26 16:10
 * @ProjectName: JavaBaseTest
 */
public class BakeChickenWingCmd extends AbstractCommand{
    BakeChickenWingCmd(Barbecuer barbecuer){
        super.barbecuer=barbecuer;
    }
    @Override
    public void exeCommmand() {
        super.barbecuer.bakeChickenWing();
    }
}
