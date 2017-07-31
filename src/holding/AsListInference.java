package holding;

import java.util.*;
import java.util.Map;
/**
 * Created by caoxiaohong on 17/2/21.
 */
class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {
    List<Snow> list= Arrays.asList(new Powder(),new Crusty(),new Slush());
    List<Snow> list1=Arrays.<Snow>asList(new Light(),new Heavy());//显示类型参数说明;
    static List<String> list2=Arrays.asList("cao","xiao","hong");
    Map<String,String> map=new HashMap<String, String>();
    static Map fill(Map<String,String> map){
        map.put("name","caoxh");
        map.put("sex","o1");
        map.put("num","001");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new HashMap<String, String>()));
        System.out.println(list2);
        List<String> list=new ArrayList<String>();
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("pear");

        ListIterator<String> iteratorba=list.listIterator();
        while(iteratorba.hasNext()){
            System.out.println(iteratorba.next()+","+iteratorba.nextIndex()+","+iteratorba.previousIndex());
        }

        System.out.println("1:"+list.contains("applea"));
        list.remove(1);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list,new Random(47));
        System.out.println(list);
        List<String> listNext=new ArrayList<String>();
        listNext=Arrays.asList("apple","appp");
        list.retainAll(listNext);
        System.out.println(list);
        //list.set(1,"");
        Object[] temp=list.toArray();
        //System.out.println(temp[1]);
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}



