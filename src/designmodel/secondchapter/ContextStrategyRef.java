package designmodel.secondchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/1 11:45
 * @ProjectName: JavaBaseTest
 */
public class ContextStrategyRef {
    private Strategy strategy;//保持对 促销策略的引用.
    //构造函数 ,确定实例化哪一个类
    public ContextStrategyRef(String selectedItem){
        switch (selectedItem){
            case "正常收费":
                strategy=new StrategyA(1);
                break;
            case "折扣7折":
                strategy=new StrategyA(0.7);
                break;
            case "满100减5":
                strategy=new StrategyB(100,5);
                break;
            case "1000积分抵扣1元":
                strategy=new StrategyC();

        }
    }
    public double getSum(double money){
        return strategy.getRealMoney(money);
    }
}
