package designmodel.chapter19;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 22:28
 * @ProjectName: JavaBaseTest
 */
public class Client{
    public static void main(String[] args) {
        ConcreteCompany company=new ConcreteCompany("总公司");
        FinanceDepartment financeDepartment=new FinanceDepartment("总公司财务部");
        HRDepartment hrDepartment=new HRDepartment("总公司人力资源部");
        company.add(financeDepartment);
        company.add(hrDepartment);

        //一级分公司
        ConcreteCompany subCmp1=new ConcreteCompany("上海华东分公司");
        FinanceDepartment financeDepartment1=new FinanceDepartment("上海华东分公司财务部");
        HRDepartment hrDepartment1=new HRDepartment("上海华东分公司人力资源部");
        subCmp1.add(financeDepartment1);
        subCmp1.add(hrDepartment1);
        company.add(subCmp1);

        //二级分公司
        ConcreteCompany subCmp2=new ConcreteCompany("南京办事处");
        FinanceDepartment financeDepartment2=new FinanceDepartment("南京办事处财务部");
        HRDepartment hrDepartment2=new HRDepartment("南京办事处人力资源部");
        subCmp2.add(financeDepartment2);
        subCmp2.add(hrDepartment2);
        subCmp1.add(subCmp2);

        //二级分公司
        ConcreteCompany subCmp3=new ConcreteCompany("杭州办事处");
        FinanceDepartment financeDepartment3=new FinanceDepartment("杭州办事处财务部");
        HRDepartment hrDepartment3=new HRDepartment("杭州办事处人力资源部");
        subCmp3.add(financeDepartment3);
        subCmp3.add(hrDepartment3);
        subCmp1.add(subCmp3);

        //展示公司层级结构
        System.out.println("公司层级结构如下:");
        company.display(1);

        //展示各个部门职责
        System.out.println("各个部门职责如下:");
        company.lineOfDuty();
    }
}
