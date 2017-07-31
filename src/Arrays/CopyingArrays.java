package Arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.arraycopy;

/**
 * Created by caoxiaohong on 17/3/2.
 */

class getFromBtoS implements Comparator<Integer>{
    public int compare(Integer o1,Integer o2){
        return o1>o2?1:0;
    }
}
public class CopyingArrays {
    public static void main(String[] args) {
        int[] a=new int[10];
        int[] b=new int[16];
        Arrays.fill(a,10);
        Arrays.fill(b,16);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        arraycopy(a,0,b,0,a.length);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.equals(a,b));
        Integer[] h=new Integer[]{1,2,8,3,4,5,6};
        System.out.println("before sorting:"+Arrays.toString(h));
        Arrays.sort(h, new getFromBtoS());
        System.out.println("after sorting:"+Arrays.toString(h));
    }
}
