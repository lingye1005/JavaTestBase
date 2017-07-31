package innerclasses;

import Interface.Interface1;

/**
 * Created by caoxiaohong on 16/12/17.
 */
//selector 接口;
interface  Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    //p192 practice2
    class getString{
        private String string;
        public String toString(String str){
            this.string=str;
            System.out.println(string);
            return  string;
        }
    }
    //
    private Object[] items;
    private  int next=0;
    public Sequence(int size){items=new Object[size];}
    public void add(Object x){
        if(next<items.length)
            items[next++]= x;
    }
    private  class SequenceSeletor implements Selector{
        private  int i=0;
        public boolean end(){
            return i==items.length;
            /*if(i==items.length) return true;
            else  return false;*/
        }
        public Object current(){
            return items[i];
        }
        public void next(){
            if(i<items.length)
                i++;
        }
        //内部类对外部类的引用;
        public Sequence  outer(){
            return Sequence.this;
        }
    }
    public Selector selector(){
        return new SequenceSeletor();
    }
    public static void main(String[] args){
        Sequence sequence=new Sequence(10);
        for(int i=0;i<10;i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector=sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
