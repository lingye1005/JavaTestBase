package annotation;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/3/19.
 */
public class StackL<T> {
    private LinkedList<T> list=new LinkedList<T>();
    public void push(T v){list.addFirst(v);}
    public T top(){return list.getFirst();}
    public T pop(){return list.removeFirst();}
}
