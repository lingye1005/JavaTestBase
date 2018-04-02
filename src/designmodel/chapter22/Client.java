package designmodel.chapter22;

/**
 * @Author: cxh
 * @CreateTime: 18/1/25 22:51
 * @ProjectName: JavaBaseTest
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        PhoneBrand brand;

        //手机品牌A1
        System.out.println("----手机品牌A1----");
        brand=new BrandA1();
        brand.setSoftWare(new SoftWareV1());
        brand.run();
        brand.setSoftWare(new SoftWareV2());
        brand.run();
        brand.setSoftWare(new SoftWareV3());
        brand.run();

        //手机品牌A2
        System.out.println("----手机品牌A2----");
        brand=new BrandA2();
        brand.setSoftWare(new SoftWareV1());
        brand.run();
        brand.setSoftWare(new SoftWareV2());
        brand.run();
        brand.setSoftWare(new SoftWareV3());
        brand.run();

        //手机品牌A3
        System.out.println("----手机品牌A3----");
        brand=new BrandB1();
        brand.setSoftWare(new SoftWareV1());
        brand.run();
        brand.setSoftWare(new SoftWareV2());
        brand.run();
        brand.setSoftWare(new SoftWareV3());
        brand.run();
    }
}
