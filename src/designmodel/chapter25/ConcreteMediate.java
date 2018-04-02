package designmodel.chapter25;

/**
 * @Author: cxh
 * @CreateTime: 18/2/20 14:22
 * @ProjectName: JavaBaseTest
 */
public class ConcreteMediate extends Mediate {
    private ConcreteColleague1 concreteColleague1;
    private ConcreteColleague2 concreteColleague2;

    public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }

    @Override
    public void declare(String messgae, Colleague colleague) {
        if(colleague instanceof ConcreteColleague1 && concreteColleague1!=null){
            concreteColleague1.receive("朝鲜须接受美国提出的任何条件!");
        }else if(colleague instanceof ConcreteColleague2 && concreteColleague2!=null){
            concreteColleague2.receive("美国可以向朝鲜提出任何条件!");
        }else{
            System.out.println("error");
        }
    }
}
