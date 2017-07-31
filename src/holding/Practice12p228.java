package holding;

import java.util.*;



/**
 * Created by caoxiaohong on 17/2/22.
 */
public class Practice12p228 {

    public static void main(String[] args) {
        /*List<String> list1= Arrays.asList("111","222","333");
        List<String> list1Copy=new ArrayList<String>();
        ListIterator<String> strOut=list1.listIterator(3);

        while(strOut.hasPrevious()){
            list1Copy.add(strOut.previous());
        }
        System.out.println(list1Copy);*/
        //String[] temp=new String[]{"111","222","333"};
        LinkedList<String> linkedList=new LinkedList<String>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("555");
        linkedList.add("666");
        System.out.println(linkedList);

        System.out.println("getFirst()"+linkedList.getFirst());
        System.out.println("element()"+linkedList.element());
        System.out.println("peek()"+linkedList.peek());

        System.out.println("remove()"+linkedList.remove());
        System.out.println("removeFirst()"+linkedList.removeFirst());
        System.out.println("poll()"+linkedList.poll());

        System.out.println(linkedList);

        //linkedList.add("777");
        linkedList.addFirst("777");
        linkedList.offer("888");
        linkedList.addLast("999");

        System.out.println("removeLast()"+linkedList.removeLast());
        List list=Collections.synchronizedList(new LinkedList());
    }
}
