package containers;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

import java.util.*;

/**
 * Created by caoxiaohong on 17/3/13.
 */

public class ReadOnly {
    static Collection<String> data=new ArrayList<String>();
    public static void main(String[] args) {
        for(int i=0;i<6;i++){
            data.add("str"+i);
        }
        Collection<String> c= Collections.unmodifiableCollection(new ArrayList<String>(data));
        System.out.println(c);
        //c.add("one");编译报错,不支持的操作类型;
        List<String> list=Collections.unmodifiableList(new ArrayList<String>(data));
        //list.add("aa");
        Set<String> set1=Collections.unmodifiableSortedSet(new TreeSet<String>());
        //set1.add("ddd");
        Set<String> set2=Collections.unmodifiableSet(new HashSet<String>(data));
        //set2.add("333");
        Map<Integer,String> map=new HashMap<Integer, String>();
        for(int i=0;i<6;i++){
            map.put(i,"str"+i);
        }
        Map<Integer,String> map1=Collections.unmodifiableMap(new HashMap<Integer, String>(map));
        System.out.println(map1);
        //map1.put(8,"aaa");
    }
}
