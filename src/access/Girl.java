package access;

/**
 * Created by caoxiaohong on 17/1/18.
 */
public class Girl {
    private int age=28;
    public static int getAge(){
        return 18;
    }

    public static void main(String[] args) {
        if(Girl.getAge()<=20) {
            System.out.println("The real age of me in 2017 is " + Girl.getAge());
            System.out.println("and I'm still young  >_<");
        }
        else {
            System.out.println("The real age of me in 2017 is " + Girl.getAge());
            System.out.println("and I'm a little bit older ...");
        }
    }
}
