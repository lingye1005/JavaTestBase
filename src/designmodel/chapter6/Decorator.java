package designmodel.chapter6;

/**
 * @Author: cxh
 * @CreateTime: 18/1/2 21:22
 * @ProjectName: JavaBaseTest
 */
public class Decorator extends Person {
    protected Person person;
    Decorator(){}

    public void decorator(Person person){
        this.person=person;
    }

    @Override
    public void operation() {
        if(person!=null)
            person.operation();
    }
}
