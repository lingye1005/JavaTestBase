package designmodel.chapter19;

import sourcecode.analysis.Consumer;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 21:58
 * @ProjectName: JavaBaseTest
 */
public class FinanceDepartment extends Company {
    private String name;
    public FinanceDepartment(String name){
        this.name=name;
    }
    @Override
    public void add(Company company) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public void display(int depth) {
        StringBuilder sb=new StringBuilder();
        while (depth-->0)
            sb.append("-");
        Consumer<String> consumer=s -> System.out.println(s);
        consumer.accept(sb+name);
    }

    @Override
    public void lineOfDuty() {
        Consumer<String> consumer=s -> System.out.println(s);
        consumer.accept(name+"工作职责:公司财务管理");
    }
}
