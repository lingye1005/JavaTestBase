package designmodel.secondchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/1 11:25
 * @ProjectName: JavaBaseTest
 * 满减 类
 */
public class StrategyB extends Strategy {
    private int condition,mongeyReturn;
    public StrategyB(int condition,int mreturn){
        this.condition=condition;
        this.mongeyReturn=mreturn;
    }

    @Override
    public double getRealMoney(double money) {
        if(money>=condition)
            return money-mongeyReturn;
        else
            return money;
    }
}
