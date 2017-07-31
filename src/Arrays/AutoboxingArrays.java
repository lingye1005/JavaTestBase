package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caoxiaohong on 17/3/1.
 */
public class AutoboxingArrays {

    public static void main(String[] args) {
        Integer[][] a={
                {1,2,3,4},{3,21,2},{3,2,53,9}
        };
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.toString(a));
        //  List<String>[] ls=new ArrayList<String>[];  illegal
        int[] temp=new int[10];
        Arrays.fill(temp,1,6,3);
        System.out.println(Arrays.toString(temp));
    }
}
