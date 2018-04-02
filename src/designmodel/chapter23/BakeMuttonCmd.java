package designmodel.chapter23;

/**
 * @Author: cxh
 * @CreateTime: 18/1/26 16:13
 * @ProjectName: JavaBaseTest
 */
public class BakeMuttonCmd extends AbstractCommand {
    BakeMuttonCmd(Barbecuer barbecuer){
        super.barbecuer=barbecuer;
    }
    @Override
    public void exeCommmand() {
        super.barbecuer.bakeMutton();
    }
}
