package access;

//import access.ChocklateChip.*;
/**
 * Created by caoxiaohong on 16/11/3.
 */
public class Cake {
    public static void main(String[] args){
        Pie x=new Pie();
        x.f();
        ChocklateChip test=new ChocklateChip();
        test.chomp();
        test.ChocklateChip();
    }
    void test(){
        ChocklateChip test=new ChocklateChip();
        test.bite();
    }
     void testPackageProtected(){
        System.out.println("this is testPackageProtected");
    }
    public void testPackagePublic(){
        System.out.println("this is testPackagePublic");
    }
}
