package containers;

import java.util.*;

/**
 * Created by caoxiaohong on 17/3/12.
 */
public class Utilities {
    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        System.out.println(list);//1
        System.out.println("'list' disjoint(Four)?:"+ Collections.disjoint(list,Collections.singletonList("Four")));//两个集合没有任何相同元素返回true

        System.out.println("max:"+Collections.max(list));//返回最大最小值,比较方法使用collections里面的内置方法;
        System.out.println("min:"+Collections.min(list));

        System.out.println("max w/ comparator:"+Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator:"+Collections.min(list,String.CASE_INSENSITIVE_ORDER));

        List<String> sublist=Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSubList:"+Collections.indexOfSubList(list,sublist));
        System.out.println("lastindexOfSublist:"+Collections.lastIndexOfSubList(list,sublist));

        Collections.replaceAll(list,"one","Yo");
        System.out.println("replace one with Yo:"+list);

        Collections.reverse(list);
        System.out.println("reverse:"+list);

        Collections.rotate(list,3);
        System.out.println(list);

        List<String> source=Arrays.asList("in the matrix".split(" "));
        Collections.copy(list,source);
        System.out.println("copy:"+list);

        Collections.swap(list,0,list.size()-1);
        System.out.println("swap:"+list);

        Collections.shuffle(list,new Random(7));//随机交换list中的数据元素
        System.out.println("shuttled:"+list);

        Collections.fill(list,"pop");//pop填充list
        System.out.println("fill:"+list);

        System.out.println("frequency of 'pop':"+Collections.frequency(list,"pop"));

        List<String> dups=Collections.nCopies(3,"snap");
        System.out.println(dups);

        System.out.println("'list' disjoint 'dups'?:"+Collections.disjoint(list,dups));

        Enumeration<String> e=Collections.enumeration(dups);
        Vector<String> v=new Vector<String>();
        while(e.hasMoreElements()){
            v.addElement(e.nextElement());
        }
        ArrayList<String> arrayList=Collections.list(v.elements());
        System.out.println("arrayList:"+arrayList);
    }
}
