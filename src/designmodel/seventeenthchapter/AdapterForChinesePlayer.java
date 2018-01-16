package designmodel.seventeenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/15 23:31
 * @ProjectName: JavaBaseTest
 */
public class AdapterForChinesePlayer extends Player {
    private String name;
    //适配器自然是知道自己应该为谁服务的,所以必须持有被服务者对象实例.
    private ChineseGuardPlayer chineseGuardPlayer=new ChineseGuardPlayer();
    AdapterForChinesePlayer(String name){
        super();
        this.name=name;
    }
    @Override
    void attack(){
        chineseGuardPlayer.gongJi(name);
    }

    @Override
    void defend() {
        chineseGuardPlayer.fangShou(name);
    }
}
