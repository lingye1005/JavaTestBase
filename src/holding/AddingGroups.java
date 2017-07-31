package holding;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

import java.util.*;

/**
 * Created by caoxiaohong on 17/2/7.
 */
public class AddingGroups {
    public static void main(String[] args) {
        /*Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts={6,7,8,9,10,1};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        List<Integer> list=Arrays.asList(moreInts);
        list.set(1,99);
        Collections.sort(list);
        System.out.println(list);
        List<Integer> onlyone=list.subList(2,5);
        System.out.println(onlyone);
        System.out.println(list.contains(19));*/
        Integer[] moreInts={1,2,3,4,5};
        Integer[] middleInts={3,4,5,6,7};
        Integer[] tailInts={6,7,8,9,10};
        List<Integer> morelist=Arrays.asList(moreInts);
        List<Integer>  middlist=Arrays.asList(middleInts);
        List<Integer>  tailInst=Arrays.asList(tailInts);
        List<Integer> ee=new ArrayList<Integer>();
        ee.retainAll(morelist);
        Collection<Integer> collections=new ArrayList<Integer>(Arrays.asList(2,3,3));
    }
}
