package designmodel.chapter19;

import sourcecode.analysis.Consumer;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 22:11
 * @ProjectName: JavaBaseTest
 */
public class ConcreteCompany extends Company{
    private String name;
    public ConcreteCompany(String name){
        this.name=name;
    }
    ArrayList<Company> filiale=new ArrayList<>();//下属子公司或部门


    @Override
    public void add(Company company) {
        filiale.add(company);
    }

    @Override
    public void delete(Company company) {
        filiale.remove(company);
    }

    @Override
    public void display(int depth) {
        final int x=depth;
        StringBuilder sb=new StringBuilder();
        while (depth-->0)
            sb.append("-");
        Consumer<String> consumer=s -> System.out.println(s);
        consumer.accept(sb+name);
        //子公司or部门显示
        filiale.stream().forEach(company -> company.display(x+2));
    }

    @Override
    public void lineOfDuty() {
        filiale.stream().forEach(company -> company.lineOfDuty());
    }
}
