package designmodel.eighthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/3 23:44
 * @ProjectName: JavaBaseTest
 */
public class DivOperation implements Operation {
    private int first,second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int getResult() {
        try{
            return first/second;
        }catch (Exception e){
            return 0;
        }
    }
}
