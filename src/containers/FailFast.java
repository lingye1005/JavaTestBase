package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by caoxiaohong on 17/3/13.
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();
        Iterator<String> it=c.iterator();
        c.add("object");
        try{
            it.next();
        }catch (ConcurrentModificationException e){
            System.out.println(e);
        }
    }
}
