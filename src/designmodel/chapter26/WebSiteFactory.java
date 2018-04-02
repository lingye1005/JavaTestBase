package designmodel.chapter26;

import java.util.HashMap;

/**
 * @Author: cxh
 * @CreateTime: 18/2/21 12:01
 * @ProjectName: JavaBaseTest
 */
public class WebSiteFactory {
    private HashMap<String,ConcreteWebSite> map=new HashMap<>();
    public ConcreteWebSite getWebSite(String type){
        if(!map.containsKey(type)){
            map.put(type,new ConcreteWebSite(type));
        }
        //输出当前网站类型的实例个数
        System.out.println("当前map大小:"+map.size());
        return map.get(type);
    }
}
