import java.util.ArrayList;
import java.util.List;

/**
 * created by cxh on 17/7/27
 */

class Base{
    private class a{}
    protected class b{}
    public class  c{}
    class d{}

}
public class TempTest extends Base {
    public static void main(String[] args) {
        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
        Boolean.valueOf(true);
    }
}



