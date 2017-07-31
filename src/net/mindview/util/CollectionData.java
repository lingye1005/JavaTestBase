package net.mindview.util;

import java.util.*;

/**
 * Created by caoxiaohong on 17/3/3.
 */

public class CollectionData<T> extends ArrayList<T>{
    public static void main(String[] args) {
        //String[] str=new String[]{"this","is","a","test"};
       /* List<String> lst= Arrays.asList(str);
        lst.set(1,"en");
        System.out.println(lst);*/
       /* lst.add("ooo");
        System.out.println(lst);
        Collections.unmodifiableList(lst);
        lst.add("aaa");
        System.out.println(lst);*/
        //Collections.unmodifiableList(lst);
        //List<String> list=new ArrayList<String>();
        List<String> list=new LinkedList<String>();
        List<String> result=new LinkedList<String>();
        list.add("this");
        list.add("is");
        list.add("a");
        list.add("test");
        result.add("xx");
        result.add("xx");
        result.add("xx");
        result.add("xx");
        //ListIterator<String> x=list.listIterator();
       /* while(li.hasNext()){
            System.out.println(li.next());
        }*/
        //list.remove("");
       // x.next();
        //x.add("xx.add()");
        ListIterator<String> list1=list.listIterator();
        ListIterator<String> result1=result.listIterator();
        while (list1.hasNext()){
            result1.next();
            result1.add(list1.next());
           /* result1.next();
            list1.next();
            result1.add(list1.next());*/
        }

        for(String temp:result){
            System.out.println(temp);
        }
    }
}
