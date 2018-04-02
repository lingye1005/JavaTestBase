package designmodel.chapter26;

/**
 * @Author: cxh
 * @CreateTime: 18/2/21 11:52
 * @ProjectName: JavaBaseTest
 */
public class ConcreteWebSite extends WebSite {
    public ConcreteWebSite(String webType) {
        super.webType = webType;
    }

    @Override
    public void display(User user) {
        System.out.println("网站分类:"+super.webType+" && 登陆用户为:"+user.getName());
    }
}
