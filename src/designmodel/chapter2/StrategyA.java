package designmodel.chapter2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/1 11:21
 * @ProjectName: JavaBaseTest
 * 打折策略类
 */
public class StrategyA extends Strategy {
     private double discount;//折扣

     public StrategyA(double discount){
         this.discount=discount;
     }

    //获取折扣后的金额
    @Override
    public double getRealMoney(double money) {
        return money*discount;
    }
}
