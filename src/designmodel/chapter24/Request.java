package designmodel.chapter24;

/**
 * @Author: cxh
 * @CreateTime: 18/1/27 19:45
 * @ProjectName: JavaBaseTest
 */
public class Request {
    private String name;
    private int days;

    Request(String name, int d) {
        this.name = name;
        this.days = d;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }
}
