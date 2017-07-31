package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caoxiaohong on 17/3/3.
 */

class StringAddress{
    private String s;
    public StringAddress(String str){
        this.s=str;
    }
    public String toString(){
        return super.toString()+" "+s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list=new ArrayList<StringAddress>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("world"));
        System.out.println(list);
        list.add(new StringAddress("chx"));
        System.out.println(list);
    }
}
