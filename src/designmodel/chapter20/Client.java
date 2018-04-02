package designmodel.chapter20;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: cxh
 * @CreateTime: 18/1/24 21:23
 * @ProjectName: JavaBaseTest
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //生成迭代器并访问
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        System.out.println();
        System.out.println("-----");

        //jdk8新增方法,forEachRemaining
        iterator=list.iterator();
        iterator.forEachRemaining(a-> System.out.print((a+1)+","));
    }
    /**
     * 下面为ArrayList类的迭代器代码.
     *
     //下面这个方法,显然返回一个实现了Iterator接口的类,且这个类是ArrayList私有的,只是为了生成ArrayList的迭代器而存在的.
     public Iterator<E> iterator() {
        return new Itr();
    }

     // An optimized version of AbstractList.Itr
     //这是一个私有类,对抽象List的迭代器做了进一步优化.
    private class Itr implements Iterator<E> {
        int cursor;       // 返回元素的索引
        int lastRet = -1; // 上一次返回元素的索引.如果上一次没有返回值,则值为-1.
        int expectedModCount = modCount; //用于记录当前迭代过程中,ArrayList结构修改次数.初始化为创建迭代器时候ArrayList的结构修改次数.

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification(); //在返回下一个元素时,先对ArrayList结构是否做了修改做合法性检查
            int i = cursor;//i表示返回元素的数组下标
            if (i >= size)
                throw new NoSuchElementException();
            //为什么这里要声明一个elementData数组的引用呢?
            //查阅资料说:因为这里要使用elementData两次,而内部类访问外部类时,是通过保存了外部类的指针而实现的.为了避免两次指针书写上的
            //重复,所以这里声明了一个引用.
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1; //访问完一个元素后,游标cursor要+1
            return (E) elementData[lastRet = i]; //注意:这里既对lastRet赋值,又返回了索引为i的数组值.这种写法在jdk源码中很常见.
        }

        //迭代器的删除方式是:根据上次访问元素的下标,删除上次访问的元素.所以对集合ArrayList在遍历过程中同时删除元素的操作,直接调用
        //ArrayList的remove方法会出现错误,而通过迭代器删除元素却是可以的.要注意这一点.
        public void remove() {
            if (lastRet < 0)  //因为通过lastRet来删除元素,所以必须对它的合法性进行合法检查
                throw new IllegalStateException();
            checkForComodification();//

            try {
                ArrayList.this.remove(lastRet);//调用外部类方法remove(),上次上次访问的元素.
                cursor = lastRet;//更新迭代器游标:更改为上次访问元素的数组下标
                lastRet = -1;//remove()操作作为下一个操作的前一个操作,因为没有访问任何元素,所以把上次访问元素的索引lastRet置为-1
                expectedModCount = modCount; //因为此时ArrayList结构发生更改,所以迭代器记录结构更改的值也要同步更新.
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        //函数式接口的参数表明:这是jdk8加入的新方法
        //功能:通过迭代器直接操作迭代器里面包含的所有数据.
        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;//size值不可更改,就是当前ArrayList包含了几个元素
            int i = cursor;//开始索引为游标值
            if (i >= size) {
                return;
            }
            //这里和上面不一样地方是:添加了final,故elementData里面的值可以更改,但是大小不能再改.
            final Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            //执行消费者函数接口方法
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            //这里对游标cursor,lastRet的更改只有一次,是为了减少因为迭代操作导致的java堆写拥塞
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }
        //这是一个final方法,用于检测当前迭代过程中ArrayList结构是否发生变化.因为本身ArrayList不是线程安全的.
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
        **/
}
