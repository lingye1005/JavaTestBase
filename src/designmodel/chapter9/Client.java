package designmodel.chapter9;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 11:49
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        Resume resume1=new Resume("李沁");
        resume1.setSelfInfo("女",22);
        resume1.setWorkExperience("北京",11,"技术研发");
        resume1.print();

        //原型模式的使用:根据指定对象resume1创建同类型的新对象resume2,且对对象的创建做定制,定制通过两个set方法完成.
        Resume resume2=(Resume)resume1.clone();
        resume2.setSelfInfo("女",25);
        resume2.setWorkExperience("天津",9,"技术支持");
        resume2.print();

        //clone()方法对引用的拷贝是浅拷贝
        resume1.print();
    }
}
