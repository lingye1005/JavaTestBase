package designmodel.ninthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 11:49
 * @ProjectName: JavaBaseTest
 */
public class Resume  implements Cloneable{
    private String name;
    private String sex;
    private int age;
    private WorkExperience experience;

    Resume(String name){
        this.name=name;
        experience=new WorkExperience();
    }

    @Override
    public Object clone() {
        return this;
    }



    //设置个人信息
    public void setSelfInfo(String sex,int age){
        this.sex=sex;
        this.age=age;
    }

    //设置工作经历
    public void setWorkExperience(String location,int time,String job){

        experience.setWorkSpace(location);
        experience.setStayTime(time);
        experience.setJob(job);
    }

    //打印简历信息
    public void print(){
        System.out.println("name:"+name);
        System.out.println("sex:"+sex);
        System.out.println("age:"+age);
        System.out.println("workSpace: 工作地点:"+experience.getWorkSpace()+",工作时长(年):"+experience.getStayTime()+",岗位:"+experience.getJob());
    }
}
