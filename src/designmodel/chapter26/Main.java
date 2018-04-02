package designmodel.chapter26;

/**
 * @Author: cxh
 * @CreateTime: 18/2/21 12:09
 * @ProjectName: JavaBaseTest
 */
public class Main {
    public static void main(String[] args) {
        WebSiteFactory factory=new WebSiteFactory();
        ConcreteWebSite web1=factory.getWebSite("产品展示");
        web1.display(new User("李丽"));

        ConcreteWebSite web2=factory.getWebSite("合作商家");
        web2.display(new User("周青"));

        ConcreteWebSite web3=factory.getWebSite("经销商信息");
        web3.display(new User("黎洲"));

        ConcreteWebSite web4=factory.getWebSite("合作商家");
        web4.display(new User("李丽莉"));

    }
}
