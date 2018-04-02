package designmodel.chapter19;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 21:46
 * @ProjectName: JavaBaseTest
 */
public abstract class Company {
    private String name;
    Company(){}
    public Company(String name){
        this.name=name;
    }
    //添加子公司
    public abstract void add(Company company);
    //移除子公司
    public abstract void delete(Company company);
    //输出公司层级结构
    public abstract void display(int depth);
    //输出当前部门or子公司的职责
    public abstract void lineOfDuty();
}
