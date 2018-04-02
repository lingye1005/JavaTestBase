package designmodel.chapter2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/1 11:38
 * @ProjectName: JavaBaseTest
 * 积分抵扣现金 类
 */
public class StrategyC extends Strategy {
    @Override
    public double getRealMoney(double money) {
        //积分得从账户获取,所以这里就用一个[1,10]的随机数字代表
        return money-10*Math.random();
    }
}
