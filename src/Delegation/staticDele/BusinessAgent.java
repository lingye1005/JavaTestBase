package Delegation.staticDele;

/**
 * Created by caoxiaohong on 17/3/26.
 * 代理类实现接口sell方法
 */
public class BusinessAgent implements Sell{
    private Vender vender;

    public BusinessAgent(Vender v){
        this.vender=v;
    }
    @Override
    public void sell(){
        vender.sell();
    }
    @Override
    public void add(){
        vender.add();
    }
}
