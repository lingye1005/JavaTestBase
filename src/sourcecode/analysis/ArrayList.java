//package sourcecode.analysis;
//
///**
// * Created by caoxiaohong on 17/11/6 17:51.
// */
//
//import java.util.*;
//
///**
// * Resizable-array implementation of the <tt>List</tt> interface.  Implements
// * all optional list operations, and permits all elements, including
// * <tt>null</tt>.  In addition to implementing the <tt>List</tt> interface,
// * this class provides methods to manipulate the size of the array that is
// * used internally to store the list.  (This class is roughly equivalent to
// * <tt>Vector</tt>, except that it is unsynchronized.)
// *
// * ArrayList实现了List接口,是一个大小可变的数组.
// * 它实现了list所有的操作,可存储任意元素,包括null.
// * 除了实现了List接口,这个类还提供了一些操作数组大小的方法,用于内部存储这个list.
// * 这个类可大致认为和Vector类相等,区别是 ArrayList不是线程安全的.
// *
// *
// * <p>The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
// * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
// * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
// * that is, adding n elements requires O(n) time.  All of the other operations
// * run in linear time (roughly speaking).  The constant factor is low compared
// * to that for the <tt>LinkedList</tt> implementation.
// *
// * 可在常量时间内完成的操作包括:size, isEmpty, get, set, iterator, listIterator.
// * 而add操作的时间复杂度为:分期常量时间,也就说,adding一个元素需要O(n)的时间.
// * 大致上,其它所有的操作执行时间都是线性的.
// * 和LinkedList相比,这一常量因素还是很低的.
// *
// *
// * <p>Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
// * the size of the array used to store the elements in the list.  It is always
// * at least as large as the list size.  As elements are added to an ArrayList,
// * its capacity grows automatically.  The details of the growth policy are not
// * specified beyond the fact that adding an element has constant amortized
// * time cost.
// *
// * 每一个ArrayList实例都有一个容量.
// * 容量表示了list中存储元素的数组大小,它至少应该和list的size大小一致.
// * 当一个元素被add到ArrayList中,它的capacity是自动增长的.
// * 关于增长策略的细节:唯一可以确定的是添加一个元素的时间代价是常量,其它一概是不确定的.
// *
// *
// * <p>An application can increase the capacity of an <tt>ArrayList</tt> instance
// * before adding a large number of elements using the <tt>ensureCapacity</tt>
// * operation.  This may reduce the amount of incremental reallocation.
// *
// * ArrayList实例在声明时,如果使用了确定capacity大小的操作,那么这一应用能够提升这个ArrayList实例的容量.
// * 说明1:
// *    Q:提升容量是什么意思?
// *    A:ArrayList在new的时候,如果没有指定大小,那么会有一个默认大小的capacity,这个值为10,而指定了capacity后,capacity会改变为指定值大
// *    小。指定capacity的这一操作,会减少为ArrayList重新分配内存的次数(这样性能会得到比较好的优化).
// *
// * 说明2:
// *    Q:为什么会出现为ArrayList重新分配内存的时候?
// *    A:因为ArrayList在添加元素后,如果size＋1>capacity，则会重新分配内存。
// *
// *
// * <p><strong>Note that this implementation is not synchronized.</strong>
// * If multiple threads access an <tt>ArrayList</tt> instance concurrently,
// * and at least one of the threads modifies the list structurally, it
// * <i>must</i> be synchronized externally.  (A structural modification is
// * any operation that adds or deletes one or more elements, or explicitly
// * resizes the backing array; merely setting the value of an element is not
// * a structural modification.)  This is typically accomplished by
// * synchronizing on some object that naturally encapsulates the list.
// *
// * 注意ArrayList是非线程安全的.如果多个线程同时作用于同一个ArrayList实例中的某个共同的元素,并且至少有一个线程更改了list的结构,那么
// * 我们必须为其添加额外的操作以达到线程安全的目的.这一操作,通常是通过同步封装在list中的几个元素来完成的(而不是让整个list中的元素
// * 都进行同步操作).
// * 更改list结构的操作有:
// * (1)add 或者 delete 一个或者多个元素;
// * (2)明确更改后台数组大小的操作;
// * 注意:仅仅更改ArrayList中某个元素的值并不属于更改list结构的操作.
// *
// *
// *
// * If no such object exists, the list should be "wrapped" using the
// * {@link Collections#synchronizedList Collections.synchronizedList}
// * method.  This is best done at creation time, to prevent accidental
// * unsynchronized access to the list:<pre>
// *   List list = Collections.synchronizedList(new ArrayList(...));</pre>
// *
// * 如果没有这样的对象存在,list应该使用Collections.synchronizedList这个方法将其封装成线程安全的.这个封装操作最好在list创建时候就完成,
// * 以避免在list中出现一些偶然的线程非同步现象.
// * 封装方法如下:
// * List list = Collections.synchronizedList(new ArrayList(...));
// *
// *
// * <p><a name="fail-fast"/>
// * The iterators returned by this class's {@link #iterator() iterator} and
// * {@link #listIterator(int) listIterator} methods are <em>fail-fast</em>:
// * if the list is structurally modified at any time after the iterator is
// * created, in any way except through the iterator's own
// * {@link ListIterator#remove() remove} or
// * {@link ListIterator#add(Object) add} methods, the iterator will throw a
// * {@link ConcurrentModificationException}.  Thus, in the face of
// * concurrent modification, the iterator fails quickly and cleanly, rather
// * than risking arbitrary, non-deterministic behavior at an undetermined
// * time in the future.
// *
// * ArrayList通过方法iterator()和listIterator(int)这两个方法返回的迭代器都会尽可能早的抛出异常:(所谓尽可能早的是意思是:)
// * 只要是迭代器创建之后,无论在何时,采用何种方式,只要list结构发生更改,迭代器都会抛出ConcurrentModificationException异常.
// * 注意:迭代器自己的操作remove和add则不会抛出上述异常.
// * 因此,面对并发修改(list结构),迭代器会迅速抛出异常而不能继续使用,而不是去冒一种在未来不确定的某时,发生一些不确定行为的风险.
// *
// *
// * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
// * as it is, generally speaking, impossible to make any hard guarantees in the
// * presence of unsynchronized concurrent modification.  Fail-fast iterators
// * throw {@code ConcurrentModificationException} on a best-effort basis.
// * Therefore, it would be wrong to write a program that depended on this
// * exception for its correctness:  <i>the fail-fast behavior of iterators
// * should be used only to detect bugs.</i>
// *
// * 注意:迭代器的这种尽可能早的抛出异常的行为并不是在出现上述更改list结构时,一定会出现的,一般来讲,在出现了非线程安全的并发修改list结构
// * 这种现象时,不能硬性保证一定会抛出异常.
// * 迭代器的的Fail-fast功能,只是尽可能的抛出ConcurrentModificationException这一异常.
// * 因此,如果一个程序的正确性完全依赖Fail-fast这一异常的话,这是一种错误的方式:迭代器的Fail-fast行为仅仅应该被用来查找bug.
// *
// * <p>This class is a member of the
// * <a href="{@docRoot}/../technotes/guides/collections/index.html">
// * Java Collections Framework</a>.
// *
// * @author  Josh Bloch
// * @author  Neal Gafter
// * @see     Collection
// * @see     List
// * @see     LinkedList
// * @see     Vector
// * @since   1.2
// */
//
///**
// * 从类名处分析:
// * (1)ArrayList<E>:表明ArrayList支持泛型
// * (2)继承1个类:AbstractList 继承了AbstractCollection类,并且含概了List接口方法的默认实现.
// * (3)实现4个接口:
// *   List:定义了列表必须实现的操作方法.
// *   RandomAccess:这是一个标记接口,接口里面没有任何方法和字段.这一接口存在的意义:实现了这一接口的类支持随机访问元素.对于一个被访问的列表来说,
// *                不管是随机访问还是顺序访问,这一接口的原始目的就是允许其通过泛型算法来更改其行为,来达到更好的性能.
// *   Cloneable: 接口里面没有任何方法和字段,实现了这个接口的类,才能使得调用java.lang.Object.clone()方法才是合法的.但是当前类必须通过override
// *              Object的clone()这个方法,才能使得这一功能得到实现.这个方法会返回当前类实例的一份浅拷贝.关于浅拷贝:比如ArrayList的
// *              clone()方法:只拷贝了其存储内容和当前实例list结构的修改次数modCount,同时modCount在拷贝时被置为0.
// *   java.io.Serializable:这也是一个里面没有任何方法和字段的接口,只有实现这一接口的类才允许被序列化.没有实现这一接口的类不允许序列化和反序
// *                        列化.如果一个类的父类是序列化的,那么这个子类自然也是可以序列化的.
// * @param <E>
// */
//public class ArrayList<E> extends AbstractList<E>
//        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{
//    /**
//     * 接下来是5个private型的实例变量,且前3个为常量.且前4个不会被序列化.
//     */
//
//    /**
//     * serialVersionUID:是JVM对字节流进行反序列化的标准.
//     * 如果被反序列化的字节流中的serialVersionUID和本地相应的java实体或者对象一致,则当然输入字节流可以进行反序列化;否则,会抛出InvalidClassException异常.
//     */
//    private static final long serialVersionUID = 8683452581122892189L;
//
//    /**
//     * Default initial capacity.
//     * ArrayList初始化默认的容量10,也就是在add操作不超过10个时, ArrayList不会进行扩容,超过后才进行扩容.
//     * 严重区别:capacity和size的区别
//     * capacity表示:在ArrayList扩容前,一共能容纳多少个元素.
//     * size:表示ArrayList当前真正存储了几个元素.
//     */
//    private static final int DEFAULT_CAPACITY = 10;
//
//    /**
//     * Shared empty array instance used for empty instances.
//     * ArrayList空实例的共享空数组空间.
//     * 也就说:当你new一个ArrayList时,如果调用了其无参构造器,则会默认给你一个空数组.尤其注意:这并不是后来我们add元素所存储的位置.
//     */
//    private static final Object[] EMPTY_ELEMENTDATA = {};
//
//    /**
//     * The array buffer into which the elements of the ArrayList are stored.
//     * The capacity of the ArrayList is the length of this array buffer. Any
//     * empty ArrayList with elementData == EMPTY_ELEMENTDATA will be expanded to
//     * DEFAULT_CAPACITY when the first element is added.
//     * elementData是ArrayList的元素存储在其中的数组缓冲区,所以说,这才是我们add的元素真正存储的数组位置.
//     * ArrayList的容量capacity是数组缓冲区的大小.
//     * 任何调用无参构造器生成的ArrayList实例,当其第一次执行add操作时,其容量capacity都会被初始化为默认容量10,
//     * 也就是DEFAULT_CAPACITY的值.
//     */
//    private transient Object[] elementData;
//
//    /**
//     * The size of the ArrayList (the number of elements it contains).
//     * ArrayList 实际存储了几个元素
//     * @serial
//     */
//    private int size;
//
//
//
//    /**
//     * 接下来时ArrayList的3个构造函数
//     */
//
//
//    /**
//     * Constructs an empty list with the specified initial capacity.
//     * 构造方法传入默认的容量capacity,设置默认数组大小为指定capacity的大小.
//     *
//     * @param  initialCapacity  the initial capacity of the list
//     * @throws IllegalArgumentException if the specified initial capacity
//     *         is negative
//     */
//    public ArrayList(int initialCapacity) {
//        super();
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal Capacity: "+
//                    initialCapacity);
//        this.elementData = new Object[initialCapacity];
//    }
//
//    /**
//     * Constructs an empty list with an initial capacity of ten.
//     * 创建一个空数组实例.也就是我们预先定义好的EMPTY_ELEMENTDATA.
//     *
//     */
//    public ArrayList() {
//        super();
//        this.elementData = EMPTY_ELEMENTDATA;
//    }
//
//    /**
//     * Constructs a list containing the elements of the specified
//     * collection, in the order they are returned by the collection's
//     * iterator.
//     * 构造方法传入一个Collection,再将Collection中的元素copy到ArrayList的数组elementData中.
//     * 如果通过Collection得到的数组elementData类型不是Object[]类型,则将其转为Object[]类型.
//     *
//     * @param c the collection whose elements are to be placed into this list
//     * @throws NullPointerException if the specified collection is null
//     */
//    public ArrayList(Collection<? extends E> c) {
//        //elementData = c.toArray();
//        size = elementData.length;
//        // c.toArray might (incorrectly) not return Object[] (see 6260652)
//        if (elementData.getClass() != Object[].class)
//            elementData = Arrays.copyOf(elementData, size, Object[].class);
//    }
//
//    /**
//     * Trims the capacity of this <tt>ArrayList</tt> instance to be the
//     * list's current size.  An application can use this operation to minimize
//     * the storage of an <tt>ArrayList</tt> instance.
//     * 缩减ArrayList实例的capacity为当前存储元素个数的大小.
//     * 这一方法的存在意义:如果capacity被分配过大,那么应用可以通过这个操作,将ArrayList实例的capacity的大小改为当前ArrayList实例
//     * 存储元素的个数,从而达到缩减ArrayList存储空间大小的目的.
//     */
//    public void trimToSize() {
//        modCount++;
//        if (size < elementData.length) {
//            elementData = Arrays.copyOf(elementData, size);
//        }
//    }
//
//    /**
//     * Increases the capacity of this <tt>ArrayList</tt> instance, if
//     * necessary, to ensure that it can hold at least the number of elements
//     * specified by the minimum capacity argument.
//     * 方法会传入用户指定ArrayList的容量,当然这个容量是用户认为的最小capacity.
//     * 如果有必要,ArrayList实例的capacity应该被增加,以保证ArrayList实例能够根据传入参数minCapacity这样的容量
//     * 去存储要存储的元素.
//     *
//     * minCapacity是什么呢?这一点可以从当前方法被调用的地方查看.
//     * 两种表达式:
//     * 如果add的是一个元素,则minCapacity=size+1;
//     * 如果add的是一个Collection,则minCapacity=size+Collection.size;
//     * @param   minCapacity   the desired minimum capacity
//     */
//    public void ensureCapacity(int minCapacity) {
//        /**扩容大小确定:如果ArrayList实例化用的无参构造器方法,且此时还没有被add过任何元素,则capacity最少扩容10;
//         *            如果ArrayList实例化用的无参构造器方法,且已经add过元素,则capacity最少扩容0;
//         *            如果ArrayList实例化用的另外两个构造器方法,则capacity最少扩容0;
//        **/
//        int minExpand = (elementData != EMPTY_ELEMENTDATA)
//                // any size if real element table
//                ? 0
//                // larger than default for empty table. It's already supposed to be
//                // at default size.
//                : DEFAULT_CAPACITY;
//
//        /**
//         * 如果最小capacity大于默认的容量minExpand,则按照minCapacity进行扩容.
//         */
//        if (minCapacity > minExpand) {
//            ensureExplicitCapacity(minCapacity);
//        }
//    }
//
//    private void ensureCapacityInternal(int minCapacity) {
//        if (elementData == EMPTY_ELEMENTDATA) {
//            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
//        }
//
//        ensureExplicitCapacity(minCapacity);
//    }
//
//    private void ensureExplicitCapacity(int minCapacity) {
//        modCount++;
//
//        // overflow-conscious code
//        /**
//         * 增加元素后,ArrayList中应该存储的元素个数为minCapacity,
//         * 所以,如果此时minCapacity>后台数组的长度(elementData.length),则要按照minCapacity进行扩容啦
//         */
//        if (minCapacity - elementData.length > 0)
//            grow(minCapacity);
//    }
//
//    /**
//     * The maximum size of array to allocate.
//     * Some VMs reserve some header words in an array.
//     * Attempts to allocate larger arrays may result in
//     * OutOfMemoryError: Requested array size exceeds VM limit
//     *
//     * MAX_ARRAY_SIZE:表示在java中,数组能分配的的最大存储空间.
//     * 一些虚拟机会在数组中保留一些标题字.
//     * 如果尝试分配比MAX_ARRAY_SIZE更大的存储空间,可能会导致内存溢出异常:请求数组大小超过啦虚拟机的限制.
//     */
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    /**
//     * Increases the capacity to ensure that it can hold at least the
//     * number of elements specified by the minimum capacity argument.
//     *
//     * 根据给定传入参数:最小capacity,来为ArrayList进行扩容.
//     * 这是面试中经常问到的问题:ArrayList是如何扩容的?其实代码不过如此简短且易理解.
//     * @param minCapacity the desired minimum capacity
//     */
//    private void grow(int minCapacity) {
//        // overflow-conscious code
//        //获取原后台数组的长度
//        int oldCapacity = elementData.length;
//        /**注意:这里就是所谓的按照1.5倍进行扩容的思想.显然如果如果原数组长度为偶数,
//         *     那么新数组长度就恰好是原后台数组的1.5倍;如果原后台数组的长度为奇数,则新数组长度应该比1.5倍少一个.**/
//        //新数组的长度=原后台数组的长度+原后台数组的长度/2
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        //如果按照1.5倍进行扩容后,capacity仍然比实际需要的小,则新数组的长度由原来的1.5倍  更改为 实际需要的大小minCapacity.
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        //如果新数组的长度比虚拟机能够提供给数组的最大存储空间大,则将新数组长度更改为最大正数:Integer.MAX_VALUE
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        // 所谓扩容,就是按照新的长度newCapacity创建一个新数组并返回,然后再将原数组中的内容copy到新数组中.
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ?
//                Integer.MAX_VALUE :
//                MAX_ARRAY_SIZE;
//    }
//
//    /**
//     * Returns the number of elements in this list.
//     *
//     * 返回ArrayList中存储的元素个数
//     *
//     * @return the number of elements in this list
//     */
//    public int size() {
//        return size;
//    }
//
//    /**
//     * Returns <tt>true</tt> if this list contains no elements.
//     *
//     * 根据ArrayList中是否有存储的元素,返回true或者false.
//     * 而这是根据size==0来判定的.
//     *
//     * @return <tt>true</tt> if this list contains no elements
//     */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /**
//     * Returns <tt>true</tt> if this list contains the specified element.
//     * More formally, returns <tt>true</tt> if and only if this list contains
//     * at least one element <tt>e</tt> such that
//     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
//     *
//     * 查看ArrayList中是否存在指定元素.
//     * 存在指定元素1个及以上,则返回true;
//     * 否则,返回false;
//     *
//     * @param o element whose presence in this list is to be tested
//     * @return <tt>true</tt> if this list contains the specified element
//     */
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//    /**
//     * Returns the index of the first occurrence of the specified element
//     * in this list, or -1 if this list does not contain the element.
//     *
//     * 这个方法唯一需要注意的:将查找对象o分为两种情况来查找:
//     * (1)如果o为null,用==
//     * (2)如果o为Object,用equals
//     * 因为:==比较的是地址或者是常量,而equals比较的是对象的内容.
//     *
//     * More formally, returns the lowest index <tt>i</tt> such that
//     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
//     * or -1 if there is no such index.
//     */
//    public int indexOf(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = 0; i < size; i++)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 此方法功能没什么好说的,注意事项也和上面的方法一样.
//     * Returns the index of the last occurrence of the specified element
//     * in this list, or -1 if this list does not contain the element.
//     * More formally, returns the highest index <tt>i</tt> such that
//     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
//     * or -1 if there is no such index.
//     */
//    public int lastIndexOf(Object o) {
//        if (o == null) {
//            for (int i = size-1; i >= 0; i--)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = size-1; i >= 0; i--)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
//     * elements themselves are not copied.)
//     *
//     * 这是对ArrayList实例的一个浅拷贝,即将ArrayList实例中的内容拷贝到一个新的ArrayList中,并且新的ArrayList中的操作不会对
//     * 原ArrayList产生影响.
//     *
//     * @return a clone of this <tt>ArrayList</tt> instance
//     */
//    public Object clone() {
//        try {
//            @SuppressWarnings("unchecked")
//            ArrayList<E> v = (ArrayList<E>) super.clone(); //内容拷贝
//            v.elementData = Arrays.copyOf(elementData, size); //为新的ArrayList的后台数组赋值
//            v.modCount = 0; //为新的ArrayList的结构更改次数字段赋值为0.
//            return v; //返回新数组.
//        } catch (CloneNotSupportedException e) {
//            // this shouldn't happen, since we are Cloneable
//            throw new InternalError();
//        }
//    }
//
//    /**
//     * Returns an array containing all of the elements in this list
//     * in proper sequence (from first to last element).
//     *
//     * 这又是一个浅拷贝的方法.将后台数组elementData中的内容赋值为一个新的Object[],并返回.
//     * Object[]中元素的顺序和原后台数组elementData中的一致.
//     * 对新的Object[]的操作不会影响后台数组elementData.
//     * 这一方法被看作是:连接数组和集合的桥梁.
//     *
//     * <p>The returned array will be "safe" in that no references to it are
//     * maintained by this list.  (In other words, this method must allocate
//     * a new array).  The caller is thus free to modify the returned array.
//     *
//     * <p>This method acts as bridge between array-based and collection-based
//     * APIs.
//     *
//     * @return an array containing all of the elements in this list in
//     *         proper sequence
//     */
//    public Object[] toArray() {
//        return Arrays.copyOf(elementData, size);
//    }
//
//    /**
//     * Returns an array containing all of the elements in this list in proper
//     * sequence (from first to last element); the runtime type of the returned
//     * array is that of the specified array.  If the list fits in the
//     * specified array, it is returned therein.  Otherwise, a new array is
//     * allocated with the runtime type of the specified array and the size of
//     * this list.
//     *
//     * 功能:将ArrayList转为数组
//     * 方法返回类型:和a一致.
//     * 方法返回数组大小:和a的大小有关.
//     *                如果a.length<size,则返回数组大小为size.
//     *                如果a.length>=size,则返回数组大小为a.length.
//     *
//     * 是否一定生成一个新数组:不一定.
//     *                      如果a.length<size,则会生成一个新的数组,并返回.
//     *                      如果a.length>=size,则不会生成新的数组.
//     *
//     * <p>If the list fits in the specified array with room to spare
//     * (i.e., the array has more elements than the list), the element in
//     * the array immediately following the end of the collection is set to
//     * <tt>null</tt>.  (This is useful in determining the length of the
//     * list <i>only</i> if the caller knows that the list does not contain
//     * any null elements.)
//     *
//     * @param a the array into which the elements of the list are to
//     *          be stored, if it is big enough; otherwise, a new array of the
//     *          same runtime type is allocated for this purpose.
//     * @return an array containing the elements of the list
//     * @throws ArrayStoreException if the runtime type of the specified array
//     *         is not a supertype of the runtime type of every element in
//     *         this list
//     * @throws NullPointerException if the specified array is null
//     */
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size)
//            // Make a new array of a's runtime type, but my contents:
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
//    }
//
//    /**
//     * 数组的随机访问:
//     * 将访问封装为方法的目的:
//     * 主要是避免每次取值都要强转===>设置值就没有封装成一个方法，因为设置值不需要强转
//     * @param index
//     * @return
//     */
//    // Positional Access Operations
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    /**
//     * Returns the element at the specified position in this list.
//     *
//     * 返回后台数组elementData[index]的值.
//     *
//     * @param  index index of the element to return
//     * @return the element at the specified position in this list
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public E get(int index) {
//        rangeCheck(index);
//
//        return elementData(index);
//    }
//
//    /**
//     * Replaces the element at the specified position in this list with
//     * the specified element.
//     *
//     * 替换数组elementData指定位置index的值为element
//     *
//     * @param index index of the element to replace
//     * @param element element to be stored at the specified position
//     * @return the element previously at the specified position
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public E set(int index, E element) {
//        rangeCheck(index);
//
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//    /**
//     * Appends the specified element to the end of this list.
//     *
//     * 在数组elementData结尾添加一个元素
//     * 注意:这里调用了ensureCapacityInternal()方法.在add方法里面就这里最重要.
//     *
//     * @param e element to be appended to this list
//     * @return <tt>true</tt> (as specified by {@link Collection#add})
//     */
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        elementData[size++] = e;
//        return true;
//    }
//
//    /**
//     * Inserts the specified element at the specified position in this
//     * list. Shifts the element currently at that position (if any) and
//     * any subsequent elements to the right (adds one to their indices).
//     *
//     * 在后台数组elementData指定位置index处添加元素element.
//     * 注意:这个方法还是比较费时的:因为涉及到数组元素的后移
//     *
//     * @param index index at which the specified element is to be inserted
//     * @param element element to be inserted
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        System.arraycopy(elementData, index, elementData, index + 1,
//                size - index);
//        elementData[index] = element;
//        size++;
//    }
//
//    /**
//     * Removes the element at the specified position in this list.
//     * Shifts any subsequent elements to the left (subtracts one from their
//     * indices).
//     *
//     * 将后台数组elementData指定位置index处的元素删除,然后左移索引index后面的元素.
//     * 并将删除元素作为结果返回.
//     *
//     * @param index the index of the element to be removed
//     * @return the element that was removed from the list
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public E remove(int index) {
//        rangeCheck(index);
//
//        modCount++;
//        E oldValue = elementData(index);
//
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        /**
//         * 注意这里啦:null的赋值,为JVM进行GC做了准备工作.
//         */
//        elementData[--size] = null; // clear to let GC do its work
//
//        return oldValue;
//    }
//
//    /**
//     * Removes the first occurrence of the specified element from this list,
//     * if it is present.  If the list does not contain the element, it is
//     * unchanged.  More formally, removes the element with the lowest index
//     *
//     * 删除ArrayList中指定的元素,如果这个元素在ArrayList中存在多个,则只删除最先出现的那个.
//     * 如果不存在,返回结果false,表示删除失败.
//     *
//     * <tt>i</tt> such that
//     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
//     * (if such an element exists).  Returns <tt>true</tt> if this list
//     * contained the specified element (or equivalently, if this list
//     * changed as a result of the call).
//     *
//     * @param o element to be removed from this list, if present
//     * @return <tt>true</tt> if this list contained the specified element
//     */
//    public boolean remove(Object o) {
//        if (o == null) {
//            for (int index = 0; index < size; index++)
//                if (elementData[index] == null) {
//                    fastRemove(index);
//                    return true;
//                }
//        } else {
//            for (int index = 0; index < size; index++)
//                if (o.equals(elementData[index])) {
//                    fastRemove(index);
//                    return true;
//                }
//        }
//        return false;
//    }
//
//    /*
//     * Private remove method that skips bounds checking and does not
//     * return the value removed.
//     */
//    private void fastRemove(int index) {
//        modCount++;
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        elementData[--size] = null; // clear to let GC do its work
//    }
//
//    /**
//     * Removes all of the elements from this list.  The list will
//     * be empty after this call returns.
//     *
//     * 清空后台数组elementData中的元素.
//     * 它会将elementData中所有的元素置为null.
//     * 并且重新设置size为0.
//     *
//     */
//    public void clear() {
//        modCount++;
//
//        /**
//         * 注意这里啦:null的赋值,为JVM进行GC做了准备工作.
//         */
//        // clear to let GC do its work
//        for (int i = 0; i < size; i++)
//            elementData[i] = null;
//
//        size = 0;
//    }
//
//    /**
//     * Appends all of the elements in the specified collection to the end of
//     * this list, in the order that they are returned by the
//     * specified collection's Iterator.  The behavior of this operation is
//     * undefined if the specified collection is modified while the operation
//     * is in progress.  (This implies that the behavior of this call is
//     * undefined if the specified collection is this list, and this
//     * list is nonempty.)
//     *
//     * 将集合c中的元素顺次添加到ArrayList实例尾部.
//     * 这里注意一个问题:因为ArrayList是非线程安全的,所以,如果在将c中的元素添加到ArrayList中时,
//     * c结构被更改了,这可能会出现问题.
//     *
//     * @param c collection containing elements to be added to this list
//     * @return <tt>true</tt> if this list changed as a result of the call
//     * @throws NullPointerException if the specified collection is null
//     */
//    public boolean addAll(Collection<? extends E> c) {
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityInternal(size + numNew);  // Increments modCount
//        System.arraycopy(a, 0, elementData, size, numNew);
//        size += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * Inserts all of the elements in the specified collection into this
//     * list, starting at the specified position.  Shifts the element
//     * currently at that position (if any) and any subsequent elements to
//     * the right (increases their indices).  The new elements will appear
//     * in the list in the order that they are returned by the
//     * specified collection's iterator.
//     *
//     * 将传入集合c中的元素添加到ArrayList实例,添加开始的位置为指定的index.
//     * 工作过程:
//     * 首先,重置elementData的大小;
//     * 然后,向后移动elementData中下标范围为:[index,index+numNew)的元素.
//     * 最后,将c中的元素拷贝到elementData中,elementData的拷贝位置从下标index开始.
//     *
//     *
//     * @param index index at which to insert the first element from the
//     *              specified collection
//     * @param c collection containing elements to be added to this list
//     * @return <tt>true</tt> if this list changed as a result of the call
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     * @throws NullPointerException if the specified collection is null
//     */
//    public boolean addAll(int index, Collection<? extends E> c) {
//        rangeCheckForAdd(index);
//
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityInternal(size + numNew);  // Increments modCount
//
//        int numMoved = size - index;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index, elementData, index + numNew,
//                    numMoved);
//
//        System.arraycopy(a, 0, elementData, index, numNew);
//        size += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * Removes from this list all of the elements whose index is between
//     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
//     * Shifts any succeeding elements to the left (reduces their index).
//     * This call shortens the list by {@code (toIndex - fromIndex)} elements.
//     * (If {@code toIndex==fromIndex}, this operation has no effect.)
//     *
//     *
//     * 移除ArrayList实例中下标为[fromIndex,toIndex)的元素.
//     * 注意:删除包括下标为fromIndex的元素,但不包括下标为toIndex的元素.
//     *
//     * @throws IndexOutOfBoundsException if {@code fromIndex} or
//     *         {@code toIndex} is out of range
//     *         ({@code fromIndex < 0 ||
//     *          fromIndex >= size() ||
//     *          toIndex > size() ||
//     *          toIndex < fromIndex})
//     */
//    protected void removeRange(int fromIndex, int toIndex) {
//        modCount++;
//        int numMoved = size - toIndex;
//        System.arraycopy(elementData, toIndex, elementData, fromIndex,
//                numMoved);
//
//        /**
//         * 这里又有和GC相关的操作啦
//         */
//        // clear to let GC do its work
//        int newSize = size - (toIndex-fromIndex);
//        for (int i = newSize; i < size; i++) {
//            elementData[i] = null;
//        }
//        size = newSize;
//    }
//
//    /**
//     * Checks if the given index is in range.  If not, throws an appropriate
//     * runtime exception.  This method does *not* check if the index is
//     * negative: It is always used immediately prior to an array access,
//     * which throws an ArrayIndexOutOfBoundsException if index is negative.
//     *
//     * 这个方法唯一注意地方:就是对于给定的数组下标index没有判定为负数情况,为什么没有判定?
//     * answer: 因为这一方法总是在访问数组之前被调用,如果index为负数,则抛出ArrayIndexOutOfBoundsException.
//     * 所以这里没有必要再判定一次index为负数的情况.那样就很冗余啦.
//     */
//    private void rangeCheck(int index) {
//        if (index >= size)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * A version of rangeCheck used by add and addAll.
//     *
//     * 本方法用于:add方法或者addall方法,检查插入位置index的合法性.
//     */
//    private void rangeCheckForAdd(int index) {
//        if (index > size || index < 0)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * Constructs an IndexOutOfBoundsException detail message.
//     * Of the many possible refactorings of the error handling code,
//     * this "outlining" performs best with both server and client VMs.
//     *
//     * 此方法功能:用于收集IndexOutOfBoundsException异常的细节信息.
//     * 在错误处理代码的许多可能的重构中,这一构造方式对于服务器和客户端的虚拟机表现都最好.
//     */
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//    /**
//     * Removes from this list all of its elements that are contained in the
//     * specified collection.
//     *
//     * 移除ArrayList实例中,和集合c中一样的元素.
//     * 注意:如果集合c中不允许有null值,但是ArrayList实例中有,则会抛出NullPointerException异常.
//     *
//     * @param c collection containing elements to be removed from this list
//     * @return {@code true} if this list changed as a result of the call
//     * @throws ClassCastException if the class of an element of this list
//     *         is incompatible with the specified collection
//     * (<a href="Collection.html#optional-restrictions">optional</a>)
//     * @throws NullPointerException if this list contains a null element and the
//     *         specified collection does not permit null elements
//     * (<a href="Collection.html#optional-restrictions">optional</a>),
//     *         or if the specified collection is null
//     * @see Collection#contains(Object)
//     */
//    public boolean removeAll(Collection<?> c) {
//        return batchRemove(c, false);
//    }
//
//    /**
//     * Retains only the elements in this list that are contained in the
//     * specified collection.  In other words, removes from this list all
//     * of its elements that are not contained in the specified collection.
//     *
//     * 移除ArrayList中元素:
//     * 被移除元素满足的条件是:在ArrayList实例中存在,而在集合c中不存在.
//     *
//     * @param c collection containing elements to be retained in this list
//     * @return {@code true} if this list changed as a result of the call
//     * @throws ClassCastException if the class of an element of this list
//     *         is incompatible with the specified collection
//     * (<a href="Collection.html#optional-restrictions">optional</a>)
//     * @throws NullPointerException if this list contains a null element and the
//     *         specified collection does not permit null elements
//     * (<a href="Collection.html#optional-restrictions">optional</a>),
//     *         or if the specified collection is null
//     * @see Collection#contains(Object)
//     */
//    public boolean retainAll(Collection<?> c) {
//        return batchRemove(c, true);
//    }
//
//    /**
//     * 这个方法是上面两个方法的辅助方法:
//     * 非常喜欢的一处代码:try里面的for循环代码,真的是太优雅了,好喜欢啊!!!一行代码,完成了两个方法的功能呢,如果是自己就估计写成if判定了...
//     *
//     * @param c
//     * @param complement
//     * @return
//     */
//    private boolean batchRemove(Collection<?> c, boolean complement) {
//        final Object[] elementData = this.elementData;
//        int r = 0, w = 0;
//        boolean modified = false;
//        try {
//            for (; r < size; r++) //将符合条件的elementData中的元素左移.
//                if (c.contains(elementData[r]) == complement)
//                    elementData[w++] = elementData[r];
//        } finally {
//            /**
//             * 这里的代码:是为了保持和AbstractCollection行为的兼容性.
//             * 尽管在上述的c.contains里面应该也会抛出异常的.但是这里还是处理了一下.
//             *
//             * 下面分析两个if的功能:
//             * 第一个if:表面上看起来r!=size的条件永远不会得到满足,因为上述try里面一直在r++呀.但是,你不要忘记,c.contains是可能抛出两类
//             * 异常的:ClassCastException和NullPointerException,这就会导致进入finally里面,也就执行了这个if语句.
//             *
//             * 第二个if:又是GC啦,将elementData下标从w开始的值置为null,以便告诉JVM可以对elementData下标为[w,size-1]的位置进行回收啦.
//             */
//            // Preserve behavioral compatibility with AbstractCollection,
//            // even if c.contains() throws.
//            if (r != size) {
//                System.arraycopy(elementData, r,
//                        elementData, w,
//                        size - r);
//                w += size - r;
//            }
//            if (w != size) {
//                // clear to let GC do its work
//                for (int i = w; i < size; i++)
//                    elementData[i] = null;
//                modCount += size - w;
//                size = w;
//                modified = true;
//            }
//        }
//        return modified;
//    }
//
//    /**
//     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
//     * is, serialize it).
//     *
//     * 将ArrayList进行序列化:保存一个ArrayList的状态到输出流中.
//     * 注意2点:
//     * 1.在将elementData中的元素写入到输出流之前,先将elementData的size写入到输出流中.
//     * 之前一直以为只向输出流中写入elementData中的数据呢.
//     * 2.defaultWriteObject方法功能:写入类的no-static和no-transient字段到输出流中.
//     * 那么问题来了,size应该是在这里就被写入到输出流了,那么下面为什么还有s.writeInt(size)这一句,是否重复呢?
//     * answer: 源码给出的解释是:作为clone()方法的兼容行为,且被作为capacity字段进行存储.同时,我们可以在方法readObject中发现,
//     * 在通过方法defaultReadObject读取了size以及其它隐藏属性后,下一个读取的int数据就是capacity.根据顺序输出和顺序读取的特点,我们知道
//     * 这个capacity就是我们在writeObject方法中s.writeInt(size).
//     *
//     * 3.defaultWriteObject方法再分析:,
//     * defaultReadObject（）和defaultWriteObject（）应该是readObject（ObjectInputStream o）和
//     * writeObject（ObjectOutputStream o）中的第一个方法调用。这些方法也有助于向后兼容.如果将来你为这个类添加了一些非瞬态的字段，
//     * 并且你试图通过旧版本的类来反序列化它，那么defaultReadObject（）方法将会忽略新添加的字段，类似地，如果你通过新的反序列化旧的
//     * 序列化对象版本，那么新的非瞬态字段将采取JVM中的默认值,比如int为0,boolean为false等.
//     *
//     * @serialData The length of the array backing the <tt>ArrayList</tt>
//     *             instance is emitted (int), followed by all of its elements
//     *             (each an <tt>Object</tt>) in the proper order.
//     */
//    private void writeObject(java.io.ObjectOutputStream s)
//            throws java.io.IOException{
//        // Write out element count, and any hidden stuff
//        int expectedModCount = modCount;
//        s.defaultWriteObject();
//
//        // Write out size as capacity for behavioural compatibility with clone()
//        s.writeInt(size);
//
//        // Write out all elements in the proper order.
//        for (int i=0; i<size; i++) {
//            s.writeObject(elementData[i]);
//        }
//
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
//     * deserialize it).
//     */
//    private void readObject(java.io.ObjectInputStream s)
//            throws java.io.IOException, ClassNotFoundException {
//        elementData = EMPTY_ELEMENTDATA;
//
//        //读入size字段值和其它隐藏属性值
//        // Read in size, and any hidden stuff
//        s.defaultReadObject();
//
//        //读入capacity字段值
//        // Read in capacity
//        s.readInt(); // ignored
//
//        if (size > 0) {
//            //基于size而非capacity进行内存分配
//            // be like clone(), allocate array based upon size not capacity
//            ensureCapacityInternal(size);
//
//            Object[] a = elementData;
//            // Read in all elements in the proper order.
//            for (int i=0; i<size; i++) {
//                a[i] = s.readObject();
//            }
//        }
//    }
//
//    /**
//     * 接下来是3个不同类型迭代器的方法,全都是fail-fast类型的.就是list结构发生改变,则迭代器会尽可能早的抛出异常.
//     */
//    /**
//     * Returns a list iterator over the elements in this list (in proper
//     * sequence), starting at the specified position in the list.
//     * The specified index indicates the first element that would be
//     * returned by an initial call to {@link ListIterator#next next}.
//     * An initial call to {@link ListIterator#previous previous} would
//     * return the element with the specified index minus one.
//     *
//     * 从指定下标index开始遍历ArrayList实例,包含index.
//     *
//     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public ListIterator<E> listIterator(int index) {
//        if (index < 0 || index > size)
//            throw new IndexOutOfBoundsException("Index: "+index);
//        return new ListItr(index);
//    }
//
//    /**
//     * Returns a list iterator over the elements in this list (in proper
//     * sequence).
//     *
//     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @see #listIterator(int)
//     */
//    public ListIterator<E> listIterator() {
//        return new ListItr(0);
//    }
//
//    /**
//     * Returns an iterator over the elements in this list in proper sequence.
//     *
//     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @return an iterator over the elements in this list in proper sequence
//     */
//    public Iterator<E> iterator() {
//        return new Itr();
//    }
//
//    /**
//     * An optimized version of AbstractList.Itr
//     * 这个方法是上述3个迭代器方法中第3个方法的辅助方法,也是它的核心算法实现.
//     * 关于cursor和数组元素下标的关系,这里再次书写一遍.例如elementData={1,2,3},则数组下标分别为0,1,2,那么加上类cursor后,该有的形式是:
//     * cursor0,0,cursor1,1,cursor2,2,cursor3.
//     * 也就是说cursor的值是在数组元素之间的值,故cursor并不指向数组元素.所以如果elementData长度为size,则cursor值有size+1个.
//     *
//     * 还要注意一点:Itr是个内部类.所以上述3个方法在调用时候,会使用到new字段,来生成这个内部类,然后才能调用这个类里面的方法.
//     *
//     */
//    private class Itr implements Iterator<E> {
//        int cursor;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such
//        /**
//         * new这个类的时候,首先获取当前ArrayList实例的modCount的值,是为了在进行迭代的时候,随时检查ArrayList实例的结构是否被更改,
//         * 一旦被更改,则尽可能早的抛出异常.这点就是迭代器抛出ConcurrentModificationException()一次的依据.
//         */
//        int expectedModCount = modCount;
//
//        public boolean hasNext() { //cursor取值范围:[0,size]
//            return cursor != size;
//        }
//
//        @SuppressWarnings("unchecked")
//        public E next() {
//            checkForComodification();
//            int i = cursor;
//            if (i >= size)
//                throw new NoSuchElementException();
//            /**
//             * 每次next,都要声明一个Object[] elementData,为什么不在开始初始化类Itr时就声明?
//             * 感觉好像应该是这样的:就是这个引用基本和其它方法完全没有关系,也就是elementData中的数据只和next()取值有关系,那么每次调用
//             * next()方法时,就获取一遍elementData的引用就行了.反正获取引用也不会生成新的存储空间,造成资源的浪费.这样封装起来的方法
//             * 看起来更舒服.
//             */
//            Object[] elementData = ArrayList.this.elementData;
//            if (i >= elementData.length)
//                throw new ConcurrentModificationException();
//            cursor = i + 1;
//            return (E) elementData[lastRet = i];//既返回了需要的值,又完成了对lastRet的赋值,完美!!!
//        }
//
//        /**
//         * 注意啦:这个方法是迭代器的remove方法,之前就说过,如果ArrayList实例在生成迭代器之后,如果再直接对ArrayList实例
//         * 改变结构的化,迭代器会抛出异常ConcurrentModificationException.
//         * 但是通过迭代器对ArrayList实例进行结构对改变,则不会抛出异常.这是怎么办到的呢?这就归因于下面try里面的代码啦.
//         * ok,分析一下try里面的代码工作过程:
//         * 已经在每行代码后面写好了……^_^
//         *
//         * 还有一点要注意的是:remove()方法删除的就是ArrayList实例中的元素值,但这不影响对elementData的遍历.因为每次删除对都是
//         * 上一次已经遍历过对值,这一点通过ArrayList.this.remove(lastRet)和cursor = lastRet可以知道.
//         * 所以remove()方法的实质:就是一边遍历,一遍删除.删除的都是上一次访问的元素.最后elementData中元素全为null.
//         */
//        public void remove() {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                ArrayList.this.remove(lastRet);//删除ArrayList实例中下标为lastRet的元素
//                cursor = lastRet; //将cursor值更新到上一次访问元素的下标值,也就是cursor=cursor-1.
//                lastRet = -1; //将上一次访问元素的数组下标置为-1,也就是初始化.
//                expectedModCount = modCount;//更新ArrayList实例结构被修改的次数,也就是expectedModCount=expectedModCount+1.
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * An optimized version of AbstractList.ListItr
//     * 这个方法是上面3个迭代方法中前2个方法中被调用的方法.
//     * 这个方法是对AbstractList中的方法ListItr的优化版本.
//     * 这里有2处要注意的地方:
//     * (1)set方法:不改变ArrayList的结构,只改变上一次访问的ArrayList中的元素值.
//     * (2)add方法:改变ArrayList的结构,新增元素的位置是:上一次访问的ArrayList中的元素的位置.
//     *
//     * 不管调用set方法还是add方法,ArrayList实例通过迭代器输出的内容都不会改变.
//     */
//    private class ListItr extends Itr implements ListIterator<E> {
//        ListItr(int index) {
//            super();
//            cursor = index;
//        }
//
//        public boolean hasPrevious() {
//            return cursor != 0;
//        }
//
//        public int nextIndex() {
//            return cursor;
//        }
//
//        public int previousIndex() {
//            return cursor - 1;
//        }
//
//        @SuppressWarnings("unchecked")
//        public E previous() {
//            checkForComodification();
//            int i = cursor - 1;
//            if (i < 0)
//                throw new NoSuchElementException();
//            Object[] elementData = ArrayList.this.elementData;
//            if (i >= elementData.length)
//                throw new ConcurrentModificationException();
//            cursor = i;
//            return (E) elementData[lastRet = i];
//        }
//
//        public void set(E e) {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                ArrayList.this.set(lastRet, e);//保证了只更新上一次被访问元素位置的值.
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        public void add(E e) {
//            checkForComodification();
//
//            try {
//                int i = cursor;
//                ArrayList.this.add(i, e);
//                cursor = i + 1;//保证了不访问新增的元素值
//                lastRet = -1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//    }
//
//    /**
//     * 接下来是对subList()方法的介绍.读懂了上面所有的代码,再看下面这些简直太容易了.
//     * 但是但是但是,重要事情说三遍:
//     * 还是有要非常注意的地方,也是容易引起误解的地方:
//     * subList()这个方法,功能是返回指定的列表部分的视图;
//     * 但是,它不是在java堆中新开辟的一个list对象,而是一个原列表视图的一部分，因此不管这两个列表谁发生了变化,都会体现在另一个列表上面.
//     * 这就和数据库中的视图一样,对视图的操作其实最终还是对生成视图的基本表的操作,而对于基本表的操作导致数据发生改变时,也会体现在视图上面.
//     */
//
//    /**
//     * Returns a view of the portion of this list between the specified
//     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
//     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
//     * empty.)  The returned list is backed by this list, so non-structural
//     * changes in the returned list are reflected in this list, and vice-versa.
//     * The returned list supports all of the optional list operations.
//     *
//     * <p>This method eliminates the need for explicit range operations (of
//     * the sort that commonly exist for arrays).  Any operation that expects
//     * a list can be used as a range operation by passing a subList view
//     * instead of a whole list.  For example, the following idiom
//     * removes a range of elements from a list:
//     * <pre>
//     *      list.subList(from, to).clear();
//     * </pre>
//     * Similar idioms may be constructed for {@link #indexOf(Object)} and
//     * {@link #lastIndexOf(Object)}, and all of the algorithms in the
//     * {@link Collections} class can be applied to a subList.
//     *
//     * <p>The semantics of the list returned by this method become undefined if
//     * the backing list (i.e., this list) is <i>structurally modified</i> in
//     * any way other than via the returned list.  (Structural modifications are
//     * those that change the size of this list, or otherwise perturb it in such
//     * a fashion that iterations in progress may yield incorrect results.)
//     *
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     * @throws IllegalArgumentException {@inheritDoc}
//     */
//    public List<E> subList(int fromIndex, int toIndex) {
//        subListRangeCheck(fromIndex, toIndex, size);
//        return new SubList(this, 0, fromIndex, toIndex);
//    }
//
//    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
//        if (fromIndex < 0)
//            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
//        if (toIndex > size)
//            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
//        if (fromIndex > toIndex)
//            throw new IllegalArgumentException("fromIndex(" + fromIndex +
//                    ") > toIndex(" + toIndex + ")");
//    }
//
//    private class SubList extends AbstractList<E> implements RandomAccess {
//        private final AbstractList<E> parent;
//        private final int parentOffset;
//        private final int offset;
//        int size;
//
//        SubList(AbstractList<E> parent,
//                int offset, int fromIndex, int toIndex) {
//            this.parent = parent;//设置了父类,从而为后面基于父类的操作做了准备工作
//            this.parentOffset = fromIndex;
//            this.offset = offset + fromIndex;
//            this.size = toIndex - fromIndex;
//            this.modCount = ArrayList.this.modCount;
//        }
//
//        public E set(int index, E e) {
//            rangeCheck(index);
//            checkForComodification();
//            E oldValue = ArrayList.this.elementData(offset + index);
//            ArrayList.this.elementData[offset + index] = e;
//            return oldValue;
//        }
//
//        public E get(int index) {
//            rangeCheck(index);
//            checkForComodification();
//            return ArrayList.this.elementData(offset + index);
//        }
//
//        public int size() {
//            checkForComodification();
//            return this.size;
//        }
//
//        public void add(int index, E e) {
//            rangeCheckForAdd(index);
//            checkForComodification();
//            parent.add(parentOffset + index, e);//为父类增加一个值
//           // this.modCount = parent.modCount; //更改父类的结构改变计数器
//            this.size++;
//        }
//
//        public E remove(int index) {
//            rangeCheck(index);
//            checkForComodification();
//            E result = parent.remove(parentOffset + index);//为父类删除一个值
//            //this.modCount = parent.modCount;//更改父类的结构改变计数器
//            this.size--;
//            return result;
//        }
//
//        protected void removeRange(int fromIndex, int toIndex) {
//            checkForComodification();
////            parent.removeRange(parentOffset + fromIndex,
////                    parentOffset + toIndex);
////            this.modCount = parent.modCount;//更改父类的结构改变计数器
//            this.size -= toIndex - fromIndex;
//        }
//
//        public boolean addAll(Collection<? extends E> c) {
//            return addAll(this.size, c);
//        }
//
//        public boolean addAll(int index, Collection<? extends E> c) {
//            rangeCheckForAdd(index);
//            int cSize = c.size();
//            if (cSize==0)
//                return false;
//
//            checkForComodification();
//            parent.addAll(parentOffset + index, c);//调用父类方法,为父类elementData增加新元素.
//            //this.modCount = parent.modCount;//更改父类的结构改变计数器
//            this.size += cSize;
//            return true;
//        }
//
//        public Iterator<E> iterator() {
//            return listIterator();
//        }
//
//        public ListIterator<E> listIterator(final int index) {
//            checkForComodification();
//            rangeCheckForAdd(index);
//            final int offset = this.offset;
//
//            return new ListIterator<E>() {
//                int cursor = index;
//                int lastRet = -1;
//                int expectedModCount = ArrayList.this.modCount;
//
//                public boolean hasNext() {
//                    return cursor != SubList.this.size;
//                }
//
//                @SuppressWarnings("unchecked")
//                public E next() {
//                    checkForComodification();
//                    int i = cursor;
//                    if (i >= SubList.this.size)
//                        throw new NoSuchElementException();
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (offset + i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i + 1;
//                    return (E) elementData[offset + (lastRet = i)];
//                }
//
//                public boolean hasPrevious() {
//                    return cursor != 0;
//                }
//
//                @SuppressWarnings("unchecked")
//                public E previous() {
//                    checkForComodification();
//                    int i = cursor - 1;
//                    if (i < 0)
//                        throw new NoSuchElementException();
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (offset + i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i;
//                    return (E) elementData[offset + (lastRet = i)];
//                }
//
//                public int nextIndex() {
//                    return cursor;
//                }
//
//                public int previousIndex() {
//                    return cursor - 1;
//                }
//
//                public void remove() {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        SubList.this.remove(lastRet);
//                        cursor = lastRet;
//                        lastRet = -1;
//                        expectedModCount = ArrayList.this.modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                public void set(E e) {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        ArrayList.this.set(offset + lastRet, e);
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
//                        SubList.this.add(i, e);
//                        cursor = i + 1;
//                        lastRet = -1;
//                        expectedModCount = ArrayList.this.modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                final void checkForComodification() {
//                    if (expectedModCount != ArrayList.this.modCount)
//                        throw new ConcurrentModificationException();
//                }
//            };
//        }
//
//        public List<E> subList(int fromIndex, int toIndex) {
//            subListRangeCheck(fromIndex, toIndex, size);
//            return new SubList(this, offset, fromIndex, toIndex);
//        }
//
//        private void rangeCheck(int index) {
//            if (index < 0 || index >= this.size)
//                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//        }
//
//        private void rangeCheckForAdd(int index) {
//            if (index < 0 || index > this.size)
//                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//        }
//
//        private String outOfBoundsMsg(int index) {
//            return "Index: "+index+", Size: "+this.size;
//        }
//
//        private void checkForComodification() {
//            if (ArrayList.this.modCount != this.modCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//}
