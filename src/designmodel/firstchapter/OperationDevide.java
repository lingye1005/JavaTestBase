package designmodel.firstchapter;

/**
 * @Author: cxh
 * @CreateTime: 17/12/31 18:28
 * @ProjectName: JavaBaseTest
 */
public class OperationDevide extends Operation {
    @Override
    public int getResult() {
        try{
            return super.getFirst()/super.getSecond();
        }catch (Exception e){
            System.out.println("错误信息列表:"+e);
            return -1;
        }
    }

    @Override
    public void setFirst(int first) {
        super.setFirst(first);
    }

    @Override
    public void setSecond(int second) {
        super.setSecond(second);
    }
}
