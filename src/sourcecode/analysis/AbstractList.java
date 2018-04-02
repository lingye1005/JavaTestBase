//        package sourcecode.analysis;
//
//        /**
//         * @Author: cxh
//         * @CreateTime: 18/3/12 09:11
//         * @ProjectName: JavaBaseTest
//         */
//
//        import java.util.*;
//        import java.util.List;
//
//        /**
//         * 此类提供了List接口的骨架实现(也称为:抽象接口),以最大限度地减少实现由“随机访问”数据存储（如数组）
//         * 所支持的接口所需的工作量.
//         * 对于顺序访问数据(如链表),应该使用AbstractSequentialList类.
//         *
//         * 为了实现一个不可修改的list,程序员上仅仅需要扩展此类,并提供一个get()方法和size()方法的实现即可.
//         *
//         * 为了实现一个可以修改的类,程序员上必须额外覆盖set(int,Object),set(int,E)方法.
//         * 如果list的大小是可变的,则程序员上应该额外覆盖add()方法,remove()方法.
//         *
//         * 根据接口规范中的建议,程序员一般应该提供一个无参构造器方法.
//         *
//         * 和其它抽象集合实现不同,程序员上不必提供给一个迭代器实现:迭代器和list迭代器;迭代器和list迭代器已经在此类
//         * 中实现,在"random access"方法之上.
//         *
//         * 本类中非抽象方法都描述了其实现的细节.如果集合希望实现一个高性能的方法,有些方法需要被覆写.
//         *
//         * 此类是java集合框架中的一员.
//         */
//
//        public abstract class AbstractList<E> extends AbstractCollection<E> implements java.util.List<E> {
//
//            //唯一构造器.(通常由子类构造函数隐式调用,因为protected修饰,且无参数,所以可以被子类使用)
//            protected AbstractList() {
//            }
//
//            /**
//             * 注意:
//             * 1.这一方法如果没有被覆写,则直接抛出异常.因为add(size(),ze)这个add方法抛异常
//             * 2.这一方法调用了size方法
//             */
//            public boolean add(E e) {
//                add(size(), e);
//                return true;
//            }
//
//
//            //@throws 抛出异常IndexOutOfBoundsException
//            abstract public E get(int index);
//
//            //这一方法总是抛出异常UnsupportedOperationException
//            public E set(int index, E element) {
//                throw new UnsupportedOperationException();
//            }
//
//            //这一方法总是抛出异常UnsupportedOperationException
//            public void add(int index, E element) {
//                throw new UnsupportedOperationException();
//            }
//
//            //这一方法总是抛出异常UnsupportedOperationException
//            public E remove(int index) {
//                throw new UnsupportedOperationException();
//            }
//
//
//
//            /*--------查询操作------*/
//            /**
//             * 这一方法使用了list迭代器.
//             * 然后,在list中查找指定元素(从前到后查找)
//             */
//            public int indexOf(Object o) {
//                ListIterator<E> it = listIterator();
//                if (o==null) {
//                    while (it.hasNext())
//                        if (it.next()==null)
//                            return it.previousIndex();
//                } else {
//                    while (it.hasNext())
//                        if (o.equals(it.next()))
//                            return it.previousIndex();
//                }
//                return -1;
//            }
//
//            /**
//             * 这一方法使用了list迭代器.
//             * 然后,在list中查找指定的元素(从后向前查找)
//             */
//            public int lastIndexOf(Object o) {
//                ListIterator<E> it = listIterator(size());
//                if (o==null) {
//                    while (it.hasPrevious())
//                        if (it.previous()==null)
//                            return it.nextIndex();
//                } else {
//                    while (it.hasPrevious())
//                        if (o.equals(it.previous()))
//                            return it.nextIndex();
//                }
//                return -1;
//            }
//
//
//            /*-------块操作--------*/
//
//            /**
//             * 这一方法调用了removeRange(0, size())方法.
//             * 如果remove()和removeRange()没有被覆写,则这一实现会抛出异常UnsupportedOperationException
//             */
//            public void clear() {
//                removeRange(0, size());
//            }
//
//            /**
//             * 这一方法指定集合c的迭代器,然后对其迭代遍历,每次遍历插入一个元素到指定位置.
//             * 为了提高性能,许多实现都覆写啦这一方法
//             *
//             * 如果add方法没有被覆写,则这一实现会抛出异常UnsupportedOperationException.因为这一方法调用啦add()方法.
//             */
//            public boolean addAll(int index, Collection<? extends E> c) {
//                rangeCheckForAdd(index);
//                boolean modified = false;
//                for (E e : c) {
//                    add(index++, e);
//                    modified = true;
//                }
//                return modified;
//            }
//
//
//            /*---------迭代--------*/
//
//            /**
//             * 这一实现是对iterator接口的直接实现,依赖于list中size(),get(),add(),remove()方法.
//             *
//             * 并发修改中,这一实现会抛出运行时异常,抛出异常的根据是modeCount域的值.
//             */
//            public Iterator<E> iterator() {
//                return new Itr();
//            }
//
//            //这一方法返回listIterator
//            public ListIterator<E> listIterator() {
//                return listIterator(0);
//            }
//
//            /**
//             * 这一方法是ListIterator接口的直接实现.
//             * ListIterator实现依赖于list支持的多个方法,包括:get,set,add,remove
//             *
//             * 如果list并没有覆写remove,set,add方法,则这一方法会抛出异常UnsupportedOperationException.
//             *
//             * 并发修改会给这一方法带来运行时异常.
//             */
//            public ListIterator<E> listIterator(final int index) {
//                rangeCheckForAdd(index);
//
//                return new ListItr(index);
//            }
//
//            //私有内部类,继承Iterator
//            private class Itr implements Iterator<E> {
//                //被下一个next方法调用元素的索引
//                int cursor = 0;
//
//                //被大多数最近next或者previous方法调用的元素索引.如果这个元素被删除了,则返回-1.
//                int lastRet = -1;
//
//
//                //迭代器希望list应该有的结构修改次数(也就是生成迭代器时的list的modCount).
//                //如果这一域是violate类型的,则迭代器就能查看并发修改的值.
//                int expectedModCount = modCount;
//
//                public boolean hasNext() {
//                    return cursor != size();
//                }
//
//                public E next() {
//                    checkForComodification();
//                    try {
//                        int i = cursor;
//                        E next = get(i);
//                        lastRet = i;
//                        cursor = i + 1;
//                        return next;
//                    } catch (IndexOutOfBoundsException e) {
//                        checkForComodification();
//                        throw new NoSuchElementException();
//                    }
//                }
//
//                public void remove() {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        AbstractList.this.remove(lastRet);
//                        if (lastRet < cursor)
//                            cursor--;
//                        lastRet = -1;
//                        expectedModCount = modCount;
//                    } catch (IndexOutOfBoundsException e) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                final void checkForComodification() {
//                    if (modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            //私有内部类,继承ListIterator接口
//            private class ListItr extends Itr implements ListIterator<E> {
//                ListItr(int index) {
//                    cursor = index;
//                }
//
//                public boolean hasPrevious() {
//                    return cursor != 0;
//                }
//
//                public E previous() {
//                    checkForComodification();
//                    try {
//                        int i = cursor - 1;
//                        E previous = get(i);
//                        lastRet = cursor = i;
//                        return previous;
//                    } catch (IndexOutOfBoundsException e) {
//                        checkForComodification();
//                        throw new NoSuchElementException();
//                    }
//                }
//
//                public int nextIndex() {
//                    return cursor;
//                }
//
//                public int previousIndex() {
//                    return cursor-1;
//                }
//
//                public void set(E e) {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        AbstractList.this.set(lastRet, e);
//                        expectedModCount = modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                public void add(E e) {
//                    checkForComodification();
//
//                    try {
//                        int i = cursor;
//                        AbstractList.this.add(i, e);
//                        lastRet = -1;
//                        cursor = i + 1;
//                        expectedModCount = modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//            }
//
//            /**
//             * 这一实现返回一个AbstractList的子类.
//             * 这一子类以私有域的方式,存储了:子list对原list的位移+子list的size+原list的modCount.
//             * 子类有两个变量,其中一个实现了RandomAccess接口.
//             * 如果原list实现了RandomAccess接口,则返回的子list将是一个实现了RandomAccess接口的实例.
//             *
//             * 子类的方法:set,get,add,remove,addAll,removeRange在执行时,
//             * 首选进行边界的合法性检查;
//             * 然后代理给抽象list对应的方法中继续执行.
//             *
//             * listIterator(int)方法,返回的是一个基于list对于的迭代器的包装对象.
//             * 迭代器方法仅仅返回listIterator();
//             * size()方法仅仅返回子list的size域.
//             *
//             * 所有的方法都先检查原list中modCount和子list中modCount这两个值是否相等.
//             * 如果不等,则抛出并发异常ConcurrentModificationException
//             */
//            public java.util.List<E> subList(int fromIndex, int toIndex) {
//                return (this instanceof RandomAccess ?
//                        new RandomAccessSubList<>(this, fromIndex, toIndex) :
//                        new SubList<>(this, fromIndex, toIndex));
//            }
//
//            /*-----比较 and hash操作*/
//
//            //经典equals格式写法,不解释
//            public boolean equals(Object o) {
//                if (o == this)
//                    return true;
//                if (!(o instanceof java.util.List))
//                    return false;
//
//                ListIterator<E> e1 = listIterator();
//                ListIterator<?> e2 = ((java.util.List<?>) o).listIterator();//类型转换
//                while (e1.hasNext() && e2.hasNext()) {
//                    E o1 = e1.next();
//                    Object o2 = e2.next();
//                    if (!(o1==null ? o2==null : o1.equals(o2)))
//                        return false;
//                }
//                return !(e1.hasNext() || e2.hasNext());
//            }
//
//            //
//            public int hashCode() {
//                //初始值:1
//                int hashCode = 1;
//                //*31
//                //遍历:加上每一个元素的hashcode
//                for (E e : this)
//                    hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
//                return hashCode;
//            }
//
//            /**
//             * 这一方法被clear()调用.
//             * 这一方法使用到了ListIterator迭代器.如果迭代器的remove方法执行时间是线性的,则此方法时间复杂度为平方级:O(N*N)
//             */
//            protected void removeRange(int fromIndex, int toIndex) {
//                ListIterator<E> it = listIterator(fromIndex);
//                for (int i=0, n=toIndex-fromIndex; i<n; i++) {
//                    it.next();
//                    it.remove();
//                }
//            }
//
//            /**
//             * 这是一个很重要的变量域.
//             * modCount记录了list的结构修改次数.
//             *
//             * modCount域被iterator迭代器和ListIterator迭代器使用.
//             * 如果modCount值和预期不一样,则抛出并发异常ConcurrentModificationException.
//             * 如果一个实现的迭代器不提供快速实现的功能,则可以不使用这一域.
//             * ignored.
//             */
//            protected transient int modCount = 0;
//
//            private void rangeCheckForAdd(int index) {
//                if (index < 0 || index > size())
//                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//            }
//
//            private String outOfBoundsMsg(int index) {
//                return "Index: "+index+", Size: "+size();
//            }
//        }
//
//        class SubList<E> extends AbstractList<E> {
//            private final AbstractList<E> l;//复用
//            private final int offset;//位移
//            private int size;//存储元素个数
//
//            SubList(AbstractList<E> list, int fromIndex, int toIndex) {
//                if (fromIndex < 0)
//                    throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
//                if (toIndex > list.size())
//                    throw new IndexOutOfBoundsException("toIndex = " + toIndex);
//                if (fromIndex > toIndex)
//                    throw new IllegalArgumentException("fromIndex(" + fromIndex +
//                            ") > toIndex(" + toIndex + ")");
//                l = list;
//                offset = fromIndex;
//                size = toIndex - fromIndex;
//                this.modCount = l.modCount;
//            }
//
//            public E set(int index, E element) {
//                rangeCheck(index);
//                checkForComodification();
//                return l.set(index+offset, element);
//            }
//
//            public E get(int index) {
//                rangeCheck(index);
//                checkForComodification();
//                return l.get(index+offset);
//            }
//
//            public int size() {
//                checkForComodification();
//                return size;
//            }
//
//            public void add(int index, E element) {
//                rangeCheckForAdd(index);
//                checkForComodification();
//                l.add(index+offset, element);
//                this.modCount = l.modCount;
//                size++;
//            }
//
//            public E remove(int index) {
//                rangeCheck(index);
//                checkForComodification();
//                E result = l.remove(index+offset);
//                this.modCount = l.modCount;
//                size--;
//                return result;
//            }
//
//            protected void removeRange(int fromIndex, int toIndex) {
//                checkForComodification();
//                l.removeRange(fromIndex+offset, toIndex+offset);
//                this.modCount = l.modCount;
//                size -= (toIndex-fromIndex);
//            }
//
//            public boolean addAll(Collection<? extends E> c) {
//                return addAll(size, c);
//            }
//
//            public boolean addAll(int index, Collection<? extends E> c) {
//                rangeCheckForAdd(index);
//                int cSize = c.size();
//                if (cSize==0)
//                    return false;
//
//                checkForComodification();
//                l.addAll(offset+index, c);
//                this.modCount = l.modCount;
//                size += cSize;
//                return true;
//            }
//
//            public Iterator<E> iterator() {
//                return listIterator();
//            }
//
//            public ListIterator<E> listIterator(final int index) {
//                checkForComodification();
//                rangeCheckForAdd(index);
//
//                return new ListIterator<E>() {
//                    private final ListIterator<E> i = l.listIterator(index+offset);
//
//                    public boolean hasNext() {
//                        return nextIndex() < size;
//                    }
//
//                    public E next() {
//                        if (hasNext())
//                            return i.next();
//                        else
//                            throw new NoSuchElementException();
//                    }
//
//                    public boolean hasPrevious() {
//                        return previousIndex() >= 0;
//                    }
//
//                    public E previous() {
//                        if (hasPrevious())
//                            return i.previous();
//                        else
//                            throw new NoSuchElementException();
//                    }
//
//                    public int nextIndex() {
//                        return i.nextIndex() - offset;
//                    }
//
//                    public int previousIndex() {
//                        return i.previousIndex() - offset;
//                    }
//
//                    public void remove() {
//                        i.remove();
//                        SubList.this.modCount = l.modCount;
//                        size--;
//                    }
//
//                    public void set(E e) {
//                        i.set(e);
//                    }
//
//                    public void add(E e) {
//                        i.add(e);
//                        SubList.this.modCount = l.modCount;
//                        size++;
//                    }
//                };
//            }
//
//            public java.util.List<E> subList(int fromIndex, int toIndex) {
//                return new SubList<>(this, fromIndex, toIndex);
//            }
//
//            private void rangeCheck(int index) {
//                if (index < 0 || index >= size)
//                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//            }
//,,,,,,,,,,,,,,
//            private void rangeCheckForAdd(int index) {
//                if (index < 0 || index > size)
//                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//            }
//
//            private String outOfBoundsMsg(int index) {
//                return "Index: "+index+", Size: "+size;
//            }
//
//            private void checkForComodification() {
//                if (this.modCount != l.modCount)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
//            RandomAccessSubList(AbstractList<E> list, int fromIndex, int toIndex) {
//                super(list, fromIndex, toIndex);
//            }
//
//            public List<E> subList(int fromIndex, int toIndex) {
//                return new RandomAccessSubList<>(this, fromIndex, toIndex);
//            }
//        }}
