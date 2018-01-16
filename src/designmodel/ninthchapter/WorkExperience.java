package designmodel.ninthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/7 11:50
 * @ProjectName: JavaBaseTest
 */
public class WorkExperience {
    private String workPlace;
    private int stayTime;
    private String job;

    public void setWorkSpace(String workSpace) {
        this.workPlace = workSpace;
    }

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWorkSpace() {
        return workPlace;
    }

    public int getStayTime() {
        return stayTime;
    }

    public String getJob() {
        return job;
    }
}
