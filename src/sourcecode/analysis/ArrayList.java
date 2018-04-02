//        package sourcecode.analysis;
//
//        /**
//         * Created by caoxiaohong on 17/11/6 17:51.
//         */
//
//        import java.util.*;
//        import java.util.function.*;
//        import java.util.function.Consumer;
//        import java.util.function.Predicate;
//        import java.util.function.UnaryOperator;
//
//        /**
//         * ArrayList实现了List接口,是一个大小可变的数组.
//         * 它实现了list所有的可选操作,可存储任意元素,包括null.
//         * 除了实现了List接口,这个类还提供了一些操作数组大小的方法,用于内部存储这个list.
//         * 这个类可大致认为和Vector类等价,区别是 ArrayList不是线程安全的.
//         *
//         * 可在常量时间内完成的操作包括:size, isEmpty, get, set, iterator, listIterator.
//         * 而add操作的时间复杂度为:分期常量时间,也就说,adding一个元素需要O(n)的时间.
//         * 大致上,其它所有的操作执行时间都是线性的.
//         * 和LinkedList相比,这一常量因素还是很低的.
//         *
//         * 每一个ArrayList实例都有一个容量.
//         * 容量表示了list中存储元素的数组大小,它至少应该和list的size大小一致.
//         * 当一个元素被add到ArrayList中,它的capacity是自动增长的.
//         * 关于增长策略的细节:唯一可以确定的是添加一个元素的时间代价是常量,其它一概是不确定的.
//         *
//         * ArrayList实例在声明时,如果使用了确定capacity大小的操作,那么这一应用能够提升这个ArrayList实例的容量.这
//         * 可能会降低自动扩容的次数.
//         * 说明1:
//         *    Q:提升容量是什么意思?
//         *    A:ArrayList在new的时候,如果没有指定大小,那么会有一个默认大小的capacity,这个值为10,而指定了capacity后,capacity会改变为指定值大
//         *    小。指定capacity的这一操作,会减少为ArrayList重新分配内存的次数(这样性能会得到比较好的优化).
//         *
//         * 说明2:
//         *    Q:为什么会出现为ArrayList重新分配内存的时候?
//         *    A:因为ArrayList在添加元素后,如果size＋1>capacity，则会重新分配内存。
//         *
//         * 注意ArrayList是非线程安全的.如果多个线程同时作用于同一个ArrayList实例中的某个共同的元素,并且至少有一个线程更改了list的结构,那么
//         * 我们必须为其添加额外的操作以达到线程安全的目的.这一操作,通常是通过同步封装在list中的几个元素来完成的(而不是让整个list中的元素
//         * 都进行同步操作).
//         * 更改list结构的操作有:
//         * (1)add 或者 delete 一个或者多个元素;
//         * (2)明确更改后台数组大小的操作;
//         * 注意:仅仅更改ArrayList中某个元素的值并不属于更改list结构的操作.
//         *
//         * 如果没有这样的对象存在,list应该使用Collections.synchronizedList这个方法将其封装成线程安全的.这个封装操作最好在list创建时候就完成,
//         * 以避免在list中出现一些偶然的线程非同步现象.
//         * 封装方法如下:
//         * List list = Collections.synchronizedList(new ArrayList(...));
//         *
//         * ArrayList通过方法iterator()和listIterator(int)这两个方法返回的迭代器都会尽可能早的抛出异常:(所谓尽可能早的是意思是:)
//         * 只要是迭代器创建之后,无论在何时,采用何种方式,只要list结构发生更改,迭代器都会抛出ConcurrentModificationException异常.
//         * 注意:迭代器自己的操作remove和add则不会抛出上述异常.
//         * 因此,面对并发修改(list结构),迭代器会迅速抛出异常而不能继续使用,而不是去冒一种在未来不确定的某时,发生一些不确定行为的风险.
//         *
//         * 注意:迭代器的这种尽可能早的抛出异常的行为并不是在出现上述更改list结构时,一定会出现的,一般来讲,在出现了非线程安全的并发修改list结构
//         * 这种现象时,不能硬性保证一定会抛出异常.
//         * 迭代器的的Fail-fast功能,只是尽可能的抛出ConcurrentModificationException这一异常.
//         * 因此,如果一个程序的正确性完全依赖Fail-fast这一异常的话,这是一种错误的方式:迭代器的Fail-fast行为仅仅应该被用来查找bug.
//         *
//         * @author  Josh Bloch
//         * @author  Neal Gafter
//         * @see     Collection
//         * @see     List
//         * @see     LinkedList
//         * @see     Vector
//         * @since   1.2
//         */
//
//        /**
//         * 从类名处分析:
//         * (1)ArrayList<E>:表明ArrayList支持泛型
//         * (2)继承1个类:AbstractList 继承了AbstractCollection类,并且含概了List接口方法的默认实现.
//         * (3)实现4个接口:
//         *   List:定义了列表必须实现的操作方法.
//         *   RandomAccess:这是一个标记接口,接口里面没有任何方法和字段.这一接口存在的意义:实现了这一接口的类支持随机访问元素.对于一个被访问的列表来说,
//         *                不管是随机访问还是顺序访问,这一接口的原始目的就是允许其通过泛型算法来更改其行为,来达到更好的性能.
//         *   Cloneable: 接口里面没有任何方法和字段,实现了这个接口的类,才能使得调用java.lang.Object.clone()方法才是合法的.但是当前类必须通过override
//         *              Object的clone()这个方法,才能使得这一功能得到实现.这个方法会返回当前类实例的一份浅拷贝.关于浅拷贝:比如ArrayList的
//         *              clone()方法:只拷贝了其存储内容和当前实例list结构的修改次数modCount,同时modCount在拷贝时被置为0.
//         *   java.io.Serializable:这也是一个里面没有任何方法和字段的接口,只有实现这一接口的类才允许被序列化.没有实现这一接口的类不允许序列化和反序
//         *                        列化.如果一个类的父类是序列化的,那么这个子类自然也是可以序列化的.
//         * @param <E>
//         */
//        public class ArrayList<E> extends AbstractList<E>
//                implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//        {
//
//             //接下来是5个private型的实例变量,且前3个为常量.且前4个不会被序列化.
//
//            /**
//             * serialVersionUID:是JVM对字节流进行反序列化的标准.
//             * 如果被反序列化的字节流中的serialVersionUID和本地相应的java实体或者对象一致,则当然输入字节流可以进行反序列化;否则,会抛出InvalidClassException异常.
//             */
//            private static final long serialVersionUID = 8683452581122892189L;
//
//            /**
//             * 默认的容量10,也就是在add操作不超过10个时, ArrayList不会进行扩容,超过后才进行扩容.
//             * 严重区别:capacity和size的区别
//             * capacity表示:在ArrayList扩容前,一共能容纳多少个元素.也就是底层数组的length
//             * size:表示ArrayList当前真正存储了几个元素.
//             * 关系:capacity>=size
//             */
//            private static final int DEFAULT_CAPACITY = 10;
//
//
//             //空实例的共享空数组.
//            private static final Object[] EMPTY_ELEMENTDATA = {};
//
//            /**
//             * 默认size空实例的共享空数组
//             * 我们将这与EMPTY_ELEMENTDATA区分开来，以知道在添加第一个元素时要扩容多少。
//             * 这一变量是JDK8添加的
//             */
//            private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//
//            /**
//             * elementData是ArrayList的元素数组缓冲区,这是add操作的存储位置.
//             * ArrayList的容量是这个数组缓冲区的长度。
//             * 当添加第一个元素时，任何具有elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
//             * 的空ArrayList将容量扩为:10=DEFAULT_CAPACITY
//             * 这一变量序列化时,为null
//             *
//             */
//            private transient Object[] elementData;
//
//            //ArrayList 实际存储了几个元素
//            private int size;
//
//
//
//            /*---------ArrayList的3个构造函数----------*/
//
//            //构造方法传入默认的容量capacity,设置默认数组大小为指定capacity的大小.
//            public ArrayList(int initialCapacity) {
//                if (initialCapacity > 0) {
//                    this.elementData = new Object[initialCapacity];
//                } else if (initialCapacity == 0) { //初始化容量指定为0,则用EMPTY_ELEMENTDATA数组
//                    this.elementData = EMPTY_ELEMENTDATA;
//                } else {
//                    throw new IllegalArgumentException("Illegal Capacity: "+
//                            initialCapacity);
//                }
//            }
//
//            //创建一个默认容量为10的空数组实例,用到了java8新增变量DEFAULTCAPACITY_EMPTY_ELEMENTDATA.
//            public ArrayList() {
//                super();
//                //jdk7代码:this.elementData=EMPTY_ELEMENTDATA
//                this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//            }
//
//            /**
//             * 构造方法传入一个Collection,再将Collection中的元素copy到ArrayList的数组elementData中.
//             * 如果通过Collection得到的数组elementData类型不是Object[]类型,则将其转为Object[]类型.
//             */
//            public ArrayList(Collection<? extends E> c) {
//                elementData = c.toArray();
//                if ((size = elementData.length) != 0) {
//                    //反射,获取数组类型,判定c.toArray类型是否为Object[]类型
//                    if (elementData.getClass() != Object[].class)
//                        elementData = Arrays.copyOf(elementData, size, Object[].class);
//                } else {
//                    // replace with empty array.
//                    this.elementData = EMPTY_ELEMENTDATA;
//                }
//            }
//
//            /**
//             * 缩减ArrayList实例的capacity为当前存储元素个数的大小.
//             * 这一方法的存在意义:如果capacity被分配过大,那么应用可以通过这个操作,将ArrayList实例的capacity的大小改为当前ArrayList实例
//             * 存储元素的个数,从而达到缩减ArrayList存储空间大小的目的.
//             */
//            public void trimToSize() {
//                modCount++;
//                if (size < elementData.length) {
//                    elementData = (size == 0)
//                            ? EMPTY_ELEMENTDATA
//                            : Arrays.copyOf(elementData, size);
//                }
//            }
//
//            /**
//             * 如果需要，增加此ArrayList实例的容量，以确保它至少能容纳最小容量参数指定的元素数量。
//             * 两种表达式:
//             * 如果add的是一个元素,则minCapacity=size+1;
//             * 如果add的是一个Collection,则minCapacity=size+Collection.size;
//             * @param   minCapacity   the desired minimum capacity
//             */
//            public void ensureCapacity(int minCapacity) {
//                //最小扩容量
//                int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
//                        // 如果elementData不是默认空数组,则扩容大小任意,这里默认为0
//                        ? 0
//                        //如果elementData是默认空数组,则扩容默认为10
//                        : DEFAULT_CAPACITY;
//                //如果最小容量>最小扩容量,则可能进行扩容,是否扩容取决于elementData.length
//                if (minCapacity > minExpand) {
//                    ensureExplicitCapacity(minCapacity);
//                }
//            }
//
//            private void ensureCapacityInternal(int minCapacity) {
//                if (elementData ==DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//                    //最小容量:max(10,minCapacity)
//                    minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
//                }
//                //针对最小容量,决定是否扩容
//                ensureExplicitCapacity(minCapacity);
//            }
//
//            private void ensureExplicitCapacity(int minCapacity) {
//                modCount++;
//
//                // overflow-conscious code
//                /**
//                 * 增加元素后,ArrayList中应该存储的元素个数为minCapacity,
//                 * 所以,如果此时minCapacity>后台数组的长度(elementData.length),则要按照minCapacity进行扩容啦
//                 */
//                if (minCapacity - elementData.length > 0)
//                    grow(minCapacity);
//            }
//
//            /**
//             * MAX_ARRAY_SIZE:表示在java中,数组能分配的的最大存储空间.
//             * 一些虚拟机会在数组中保留一些标题字.
//             * 如果尝试分配比MAX_ARRAY_SIZE更大的存储空间,可能会导致内存溢出异常:请求数组大小超过了虚拟机的限制.
//             */
//            private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//            /**
//             * 根据给定传入参数:最小capacity,来为ArrayList进行扩容.
//             * 这是面试中经常问到的问题:ArrayList是如何扩容的?其实代码如此简短且易理解.
//             * @param minCapacity the desired minimum capacity
//             */
//            private void grow(int minCapacity) {
//                // overflow-conscious code
//                //获取原后台数组的长度
//                int oldCapacity = elementData.length;
//                /**注意:这里就是所谓的按照1.5倍进行扩容的思想.显然如果如果原数组长度为偶数,
//                 *     那么新数组长度就恰好是原后台数组的1.5倍;如果原后台数组的长度为奇数,则新数组长度应该比1.5倍少一个.**/
//                //新数组的长度=原后台数组的长度+原后台数组的长度/2
//                int newCapacity = oldCapacity + (oldCapacity >> 1);
//                //如果按照1.5倍进行扩容后,capacity仍然比实际需要的小,则新数组的长度由原来的1.5倍  更改为 实际需要的大小minCapacity.
//                if (newCapacity - minCapacity < 0)
//                    newCapacity = minCapacity;
//                //如果新数组的长度比虚拟机能够提供给数组的最大存储空间大,则将新数组长度更改为最大正数:Integer.MAX_VALUE
//                if (newCapacity - MAX_ARRAY_SIZE > 0)
//                    newCapacity = hugeCapacity(minCapacity);
//                // minCapacity is usually close to size, so this is a win:
//                // 所谓扩容,就是按照新的长度newCapacity创建一个新数组并返回,然后再将原数组中的内容copy到新数组中.
//                elementData = Arrays.copyOf(elementData, newCapacity);
//            }
//
//            private static int hugeCapacity(int minCapacity) {
//                if (minCapacity < 0) // overflow
//                    throw new OutOfMemoryError();
//                return (minCapacity > MAX_ARRAY_SIZE) ?
//                        Integer.MAX_VALUE :
//                        MAX_ARRAY_SIZE;
//            }
//
//           //返回ArrayList中存储的元素个数
//            public int size() {
//                return size;
//            }
//
//           //根据ArrayList中是否有存储的元素,返回true或者false.根据size==0来判定的.
//            public boolean isEmpty() {
//                return size == 0;
//            }
//
//            /**
//             * 查看ArrayList中是否存在指定元素.
//             * 存在指定元素1个及以上,则返回true;
//             * 否则,返回false;
//             */
//            public boolean contains(Object o) {
//                return indexOf(o) >= 0;
//            }
//
//            /**
//             *
//             * 这个方法唯一需要注意的:将查找对象o分为两种情况来查找:
//             * (1)如果o为null,用==
//             * (2)如果o为Object,用equals
//             * 因为:==比较的是地址或者是常量,而equals比较的是对象的内容.
//             */
//            public int indexOf(Object o) {
//                if (o == null) {
//                    for (int i = 0; i < size; i++)
//                        if (elementData[i]==null)
//                            return i;
//                } else {
//                    for (int i = 0; i < size; i++)
//                        if (o.equals(elementData[i]))
//                            return i;
//                }
//                return -1;
//            }
//
//            //此方法功能没什么好说的,注意事项也和上面的方法一样.
//            public int lastIndexOf(Object o) {
//                if (o == null) {
//                    for (int i = size-1; i >= 0; i--)
//                        if (elementData[i]==null)
//                            return i;
//                } else {
//                    for (int i = size-1; i >= 0; i--)
//                        if (o.equals(elementData[i]))
//                            return i;
//                }
//                return -1;
//            }
//
//            /**
//             * 这是对ArrayList实例的一个浅拷贝,即将ArrayList实例中的内容拷贝到一个新的ArrayList中,
//             * 并且新的ArrayList中的操作不会对原ArrayList产生影响.
//             */
//            public Object clone() {
//                try {
//                    ArrayList<E> v = (ArrayList<E>) super.clone(); //内容拷贝
//                    v.elementData = Arrays.copyOf(elementData, size); //为新的ArrayList的后台数组赋值
//                    v.modCount = 0; //为新的ArrayList的结构更改次数字段赋值为0.
//                    return v; //返回新数组.
//                } catch (CloneNotSupportedException e) {
//                    // this shouldn't happen, since we are Cloneable
//                    throw new InternalError();
//                }
//            }
//
//            /**
//             * 这又是一个浅拷贝的方法.将后台数组elementData中的内容赋值为一个新的Object[],并返回.
//             * Object[]中元素的顺序和原后台数组elementData中的一致.
//             * 对新的Object[]的操作不会影响后台数组elementData.
//             * 这一方法被看作是:连接数组和集合的桥梁.
//             */
//            public Object[] toArray() {
//                return Arrays.copyOf(elementData, size);
//            }
//
//            /**
//             * 功能:将ArrayList转为数组
//             * 方法返回类型:和a一致.
//             * 方法返回数组大小:和a的大小有关.
//             * 如果a.length<size,则返回数组大小为size.
//             * 如果a.length>=size,则返回数组大小为a.length.
//             *
//             * 是否一定生成一个新数组:不一定.
//             * 如果a.length<size,则会生成一个新的数组,并返回.
//             * 如果a.length>=size,则不会生成新的数组.
//             */
//            public <T> T[] toArray(T[] a) {
//                if (a.length < size)
//                    //产生一个新的运行时数组,但数组内容不变
//                    return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//                //如果a.length>=size,则通过系统拷贝将a中元素拷贝到elementData中
//                System.arraycopy(elementData, 0, a, 0, size);
//                //如果a.length>size,则将a[size]=null,通知jvm可回收此空间
//                if (a.length > size)
//                    a[size] = null;
//                return a;
//            }
//            /**
//             * 数组的随机访问:
//             * 将访问封装为方法的目的:
//             * 主要是避免每次取值都要强转===>设置值就没有封装成一个方法，因为设置值不需要强转
//             * @param index
//             * @return
//             */
//            //  指定位置访问操作
//            E elementData(int index) {
//                return (E) elementData[index];
//            }
//
//            //返回后台数组elementData[index]的值.
//            public E get(int index) {
//                //索引合法性判定
//                rangeCheck(index);
//
//                return elementData(index);
//            }
//
//            //替换数组elementData指定位置index的值为element
//            public E set(int index, E element) {
//                //索引合法性判定
//                rangeCheck(index);
//                //旧值保存
//                E oldValue = elementData(index);
//                elementData[index] = element;
//                //返回旧值
//                return oldValue;
//            }
//
//            //在数组elementData结尾添加一个元素
//            public boolean add(E e) {
//                //容量合法性判定
//                ensureCapacityInternal(size + 1);  // 结构更改次数:modCount更改
//                elementData[size++] = e;
//                return true;
//            }
//
//            //在后台数组elementData指定位置index处添加元素element.
//            public void add(int index, E element) {
//                //索引合法性判定
//                rangeCheckForAdd(index);
//                //容量合法性判定
//                ensureCapacityInternal(size + 1);  //结构更改次数:modCount更改
//                //系统拷贝
//                System.arraycopy(elementData, index, elementData, index + 1,
//                        size - index);
//                elementData[index] = element;
//                size++;
//            }
//
//            /**
//             * 将后台数组elementData指定位置index处的元素删除,然后左移索引index后面的元素.
//             * 并将删除元素作为结果返回.
//             */
//            public E remove(int index) {
//                rangeCheck(index);//范围合法性检查
//
//                modCount++;//结构更改次数+1
//                E oldValue = elementData(index);//保存旧值
//
//                int numMoved = size - index - 1;//移动元素个数
//                if (numMoved > 0) //如果有有需要向前移动的元素
//                    System.arraycopy(elementData, index+1, elementData, index,
//                            numMoved);
//                //注意这里啦:null的赋值,为JVM进行GC做了准备工作
//                elementData[--size] = null; // clear to let GC do its work
//
//                return oldValue;
//            }
//
//            /**
//             * 删除ArrayList中指定的元素,如果这个元素在ArrayList中存在多个,则只删除最先出现的那个.
//             * 如果不存在,返回结果false,表示删除失败.
//             */
//            public boolean remove(Object o) {
//                if (o == null) {
//                    for (int index = 0; index < size; index++)
//                        if (elementData[index] == null) {
//                            fastRemove(index);//调用快速remove方法
//                            return true;
//                        }
//                } else {
//                    for (int index = 0; index < size; index++)
//                        if (o.equals(elementData[index])) {
//                            fastRemove(index);//调用快速remove方法
//                            return true;
//                        }
//                }
//                return false;
//            }
//
//            //私有快速remove方法,跳过边界检查,且不返回旧值
//            private void fastRemove(int index) {
//                //增加结构更改次数
//                modCount++;
//                //右移元素个数
//                int numMoved = size - index - 1;
//                if (numMoved > 0)
//                    System.arraycopy(elementData, index+1, elementData, index,
//                            numMoved);
//                //通知JVM进行可用对其进行GC操作
//                elementData[--size] = null; // clear to let GC do its work
//            }
//
//            /**
//             * 清空后台数组elementData中的元素.
//             * 它会将elementData中所有的元素置为null.
//             * 并且重新设置size为0.
//             */
//            public void clear() {
//                modCount++;
//
//                //注意这里啦:null的赋值,为JVM进行GC做了准备工作.
//                for (int i = 0; i < size; i++)
//                    elementData[i] = null;
//
//                size = 0;
//            }
//
//            /**
//             * 将集合c中的元素顺次添加到ArrayList实例尾部.
//             * 这里注意一个问题:因为ArrayList是非线程安全的,所以,如果在将c中的元素添加到ArrayList中时,
//             * c结构被更改了,这可能会出现问题.
//             */
//            public boolean addAll(Collection<? extends E> c) {
//                //转为Object数组
//                Object[] a = c.toArray();
//                //获取数组长度
//                int numNew = a.length;
//                //容量合法性判定
//                ensureCapacityInternal(size + numNew);  // Increments modCount
//                //系统拷贝到elementData
//                System.arraycopy(a, 0, elementData, size, numNew);
//                //更改size
//                size += numNew;
//                return numNew != 0;
//            }
//
//            /**
//             * 将传入集合c中的元素添加到ArrayList实例,添加开始的位置为指定的index.
//             * 工作过程:
//             * 首先,重置elementData的大小;
//             * 然后,向后移动elementData中下标范围为:[index,index+numNew)的元素.
//             * 最后,将c中的元素拷贝到elementData中,elementData的拷贝位置从下标index开始.
//             */
//            public boolean addAll(int index, Collection<? extends E> c) {
//                rangeCheckForAdd(index);
//
//                Object[] a = c.toArray();
//                int numNew = a.length;
//                ensureCapacityInternal(size + numNew);  // Increments modCount
//
//                int numMoved = size - index;
//                if (numMoved > 0)
//                    System.arraycopy(elementData, index, elementData, index + numNew,
//                            numMoved);
//
//                System.arraycopy(a, 0, elementData, index, numNew);
//                size += numNew;
//                return numNew != 0;
//            }
//
//            /**
//             * 移除ArrayList实例中下标为[fromIndex,toIndex)的元素.
//             * 注意:删除包括下标为fromIndex的元素,但不包括下标为toIndex的元素.
//             */
//            protected void removeRange(int fromIndex, int toIndex) {
//                modCount++;
//                int numMoved = size - toIndex;
//                System.arraycopy(elementData, toIndex, elementData, fromIndex,
//                        numMoved);
//
//                //这里又有和GC相关的操作啦
//                int newSize = size - (toIndex-fromIndex);
//                for (int i = newSize; i < size; i++) {
//                    elementData[i] = null;
//                }
//                size = newSize;
//            }
//
//            /**
//             * 这个方法唯一注意地方:就是对于给定的数组下标index没有判定为负数情况,为什么没有判定?
//             * answer: 因为这一方法总是在访问数组之前被调用,如果index为负数,则抛出ArrayIndexOutOfBoundsException.
//             * 所以这里没有必要再判定一次index为负数的情况.那样就很冗余啦.
//             */
//            private void rangeCheck(int index) {
//                if (index >= size)
//                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//            }
//
//            //本方法用于:add方法或者addall方法,检查插入位置index的合法性.
//            private void rangeCheckForAdd(int index) {
//                if (index > size || index < 0)
//                    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//            }
//
//            /**
//             * 此方法功能:用于收集IndexOutOfBoundsException异常的细节信息.
//             * 在错误处理代码的许多可能的重构中,这一构造方式对于服务器和客户端的虚拟机表现都最好.
//             */
//            private String outOfBoundsMsg(int index) {
//                return "Index: "+index+", Size: "+size;
//            }
//
//            /**
//             * 移除ArrayList实例中,和集合c中一样的元素.
//             * 注意:如果集合c中不允许有null值,但是ArrayList实例中有,则会抛出NullPointerException异常.
//             */
//            public boolean removeAll(Collection<?> c) {
//                Objects.requireNonNull(c);
//                return batchRemove(c, false);
//            }
//
//            /**
//             * 移除ArrayList中元素:
//             * 被移除元素满足的条件是:在ArrayList实例中存在,而在集合c中不存在.
//             */
//            public boolean retainAll(Collection<?> c) {
//                Objects.requireNonNull(c);
//                return batchRemove(c, true);
//            }
//
//            /**
//             * 批量删除方法
//             * 这个方法是上面两个方法的辅助方法:
//             * 非常喜欢的一处代码:try里面的for循环代码,很优雅的代码,完成了两个方法的功能,如果是自己就估计写成if判定了...
//             */
//            private boolean batchRemove(Collection<?> c, boolean complement) {
//                final Object[] elementData = this.elementData;
//                int r = 0, w = 0;//r记录从左到右遍历了list中几个元素; w记录了list中留下了几个元素
//                boolean modified = false;
//                try {
//                    for (; r < size; r++) //将符合条件的elementData中的元素左移.
//                        if (c.contains(elementData[r]) == complement)
//                            elementData[w++] = elementData[r];
//                } finally {
//                    /**
//                     * 这里的代码:是为了保持和AbstractCollection行为的兼容性.
//                     * 尽管在上述的c.contains里面应该也会抛出异常的.但是这里还是处理了一下.
//                     *
//                     * 下面分析两个if的功能:
//                     * 第一个if:表面上看起来r!=size的条件永远不会得到满足,因为上述try里面一直在r++呀.但是,你不要忘记,c.contains是可能抛出两类
//                     * 异常的:ClassCastException和NullPointerException,这就会导致进入finally里面,也就执行了这个if语句.
//                     *
//                     * 第二个if:又是GC啦,将elementData下标从w开始的值置为null,以便告诉JVM可以对elementData下标为[w,size-1]的位置进行回收啦.
//                     */
//                    //try里面的for循环未完成
//                    if (r != size) {
//                        System.arraycopy(elementData, r,
//                                elementData, w,
//                                size - r);
//                        w += size - r;
//                    }
//                    //原elementData后面有删除元素
//                    if (w != size) {
//                        // clear to let GC do its work
//                        for (int i = w; i < size; i++)
//                            elementData[i] = null;
//                        modCount += size - w;
//                        size = w;
//                        modified = true;
//                    }
//                }
//                return modified;
//            }
//
//            /**
//             * 将ArrayList进行序列化:保存一个ArrayList的状态到输出流中.
//             * 注意2点:
//             * 1.在将elementData中的元素写入到输出流之前,先将elementData的size写入到输出流中.
//             * 之前一直以为只向输出流中写入elementData中的数据呢.
//             * 2.defaultWriteObject方法功能:写入类的no-static和no-transient字段到输出流中.
//             * 那么问题来了,size应该是在这里就被写入到输出流了,那么下面为什么还有s.writeInt(size)这一句,是否重复呢?
//             * answer: 源码给出的解释是:作为clone()方法的兼容行为,且被作为capacity字段进行存储.同时,我们可以在方法readObject中发现,
//             * 在通过方法defaultReadObject读取了size以及其它隐藏属性后,下一个读取的int数据就是capacity.根据顺序输出和顺序读取的特点,我们知道
//             * 这个capacity就是我们在writeObject方法中s.writeInt(size).
//             *
//             * 3.defaultWriteObject方法再分析:,
//             * defaultReadObject（）和defaultWriteObject（）应该是readObject（ObjectInputStream o）和
//             * writeObject（ObjectOutputStream o）中的第一个方法调用。这些方法也有助于向后兼容.如果将来你为这个类添加了一些非瞬态的字段，
//             * 并且你试图通过旧版本的类来反序列化它，那么defaultReadObject（）方法将会忽略新添加的字段，类似地，如果你通过新的反序列化旧的
//             * 序列化对象版本，那么新的非瞬态字段将采取JVM中的默认值,比如int为0,boolean为false等.
//             */
//            private void writeObject(java.io.ObjectOutputStream s)
//                    throws java.io.IOException{
//                // Write out element count, and any hidden stuff
//                int expectedModCount = modCount;
//                s.defaultWriteObject();
//
//                // Write out size as capacity for behavioural compatibility with clone()
//                s.writeInt(size);
//
//                // Write out all elements in the proper order.
//                for (int i=0; i<size; i++) {
//                    s.writeObject(elementData[i]);
//                }
//
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException();
//                }
//            }
//
//            //根据stream中的描述信息,构造一个ArrayList实例
//            private void readObject(java.io.ObjectInputStream s)
//                    throws java.io.IOException, ClassNotFoundException {
//                elementData = EMPTY_ELEMENTDATA;
//
//                //读入size字段值和其它隐藏属性值
//                // Read in size, and any hidden stuff
//                s.defaultReadObject();
//
//                //读入capacity字段值
//                // Read in capacity
//                s.readInt(); // ignored
//
//                if (size > 0) {
//                    //基于size而非capacity进行内存分配
//                    // be like clone(), allocate array based upon size not capacity
//                    ensureCapacityInternal(size);
//
//                    Object[] a = elementData;
//                    // Read in all elements in the proper order.
//                    for (int i=0; i<size; i++) {
//                        a[i] = s.readObject();
//                    }
//                }
//            }
//
//            /*--------3个不同类型迭代器的方法-------全都是fail-fast类型的.*/
//
//            //从指定下标index开始遍历ArrayList实例,包含index.
//            public ListIterator<E> listIterator(int index) {
//                if (index < 0 || index > size)
//                    throw new IndexOutOfBoundsException("Index: "+index);
//                return new ListItr(index);
//            }
//
//            public ListIterator<E> listIterator() {
//                return new ListItr(0);
//            }
//
//            public Iterator<E> iterator() {
//                return new Itr();
//            }
//
//            /**
//             * An optimized version of AbstractList.Itr
//             * 这个方法是上述3个迭代器方法中第3个方法的辅助方法,也是它的核心算法实现.
//             * 关于cursor和数组元素下标的关系,这里再次书写一遍.例如elementData={1,2,3},则数组下标分别为0,1,2,那么加上类cursor后,该有的形式是:
//             * cursor0,0,cursor1,1,cursor2,2,cursor3.
//             * 也就是说cursor的值是在数组元素之间的值,故cursor并不指向数组元素.所以如果elementData长度为size,则cursor值有size+1个.
//             *
//             * 还要注意一点:Itr是个内部类.所以上述3个方法在调用时候,会使用到new字段,来生成这个内部类,然后才能调用这个类里面的方法.
//             */
//            private class Itr implements Iterator<E> {
//                int cursor;       // index of next element to return
//                int lastRet = -1; // index of last element returned; -1 if no such
//                /**
//                 * new这个类的时候,首先获取当前ArrayList实例的modCount的值,是为了在进行迭代的时候,随时检查ArrayList实例的结构是否被更改,
//                 * 一旦被更改,则尽可能早的抛出异常.这点就是迭代器抛出ConcurrentModificationException()一次的依据.
//                 */
//                int expectedModCount = modCount;
//
//                public boolean hasNext() { //cursor取值范围:[0,size]
//                    return cursor != size;
//                }
//
//                @SuppressWarnings("unchecked")
//                public E next() {
//                    checkForComodification();
//                    int i = cursor;
//                    if (i >= size)
//                        throw new NoSuchElementException();
//                    /**
//                     * 每次next,都要声明一个Object[] elementData,为什么不在开始初始化类Itr时就声明?
//                     * 感觉好像应该是这样的:就是这个引用基本和其它方法完全没有关系,也就是elementData中的数据只和next()取值有关系,那么每次调用
//                     * next()方法时,就获取一遍elementData的引用就行了.反正获取引用也不会生成新的存储空间,造成资源的浪费.这样封装起来的方法
//                     * 看起来更舒服.
//                     */
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i + 1;
//                    return (E) elementData[lastRet = i];//既返回了需要的值,又完成了对lastRet的赋值,完美!!!
//                }
//
//                /**
//                 * 注意啦:这个方法是迭代器的remove方法,之前就说过,如果ArrayList实例在生成迭代器之后,如果再直接对ArrayList实例
//                 * 改变结构的化,迭代器会抛出异常ConcurrentModificationException.
//                 * 但是通过迭代器对ArrayList实例进行结构对改变,则不会抛出异常.这是怎么办到的呢?这就归因于下面try里面的代码啦.
//                 * ok,分析一下try里面的代码工作过程:
//                 * 已经在每行代码后面写好了……^_^
//                 *
//                 * 还有一点要注意的是:remove()方法删除的就是ArrayList实例中的元素值,但这不影响对elementData的遍历.因为每次删除对都是
//                 * 上一次已经遍历过对值,这一点通过ArrayList.this.remove(lastRet)和cursor = lastRet可以知道.
//                 * 所以remove()方法的实质:就是一边遍历,一遍删除.删除的都是上一次访问的元素.最后elementData中元素全为null.
//                 */
//                public void remove() {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        ArrayList.this.remove(lastRet);//删除ArrayList实例中下标为lastRet的元素
//                        cursor = lastRet; //将cursor值更新到上一次访问元素的下标值,也就是cursor=cursor-1.
//                        lastRet = -1; //将上一次访问元素的数组下标置为-1,也就是初始化.
//                        expectedModCount = modCount;//更新ArrayList实例结构被修改的次数,也就是expectedModCount=expectedModCount+1.
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                @Override
//                @SuppressWarnings("unchecked")
//                public void forEachRemaining(java.util.function.Consumer<? super E> consumer) {
//                    //传入函数接口不为空
//                    Objects.requireNonNull(consumer);
//                    //记录size大小
//                    final int size = ArrayList.this.size;
//                    //记录游标
//                    int i = cursor;
//                    //如果游标到达最后一个元素的后面
//                    if (i >= size) {
//                        return;
//                    }
//                    //记录当前elementData数组
//                    final Object[] elementData = ArrayList.this.elementData;
//                    //如果游标>elementData数组长度
//                    if (i >= elementData.length) {
//                        throw new ConcurrentModificationException();
//                    }
//                    //对游标后的每一个元素都执行函数接口定义对accept操作.
//                    while (i != size && modCount == expectedModCount) {
//                        consumer.accept((E) elementData[i++]);
//                    }
//                    // update once at end of iteration to reduce heap write traffic
//                    //更新游标
//                    cursor = i;
//                    //更新上一个访问元素的下标值
//                    lastRet = i - 1;
//                    //并发检查
//                    checkForComodification();
//                }
//
//                final void checkForComodification() {
//                    if (modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            /**
//             * 这个方法是上面3个迭代方法中前2个方法中被调用的方法.
//             * 这个方法是对AbstractList中的方法ListItr的优化版本.
//             * 这里有2处要注意的地方:
//             * (1)set方法:不改变ArrayList的结构,只改变上一次访问的ArrayList中的元素值.
//             * (2)add方法:改变ArrayList的结构,新增元素的位置是:上一次访问的ArrayList中的元素的位置.
//             *
//             * 不管调用set方法还是add方法,ArrayList实例通过迭代器输出的内容都不会改变.
//             */
//            private class ListItr extends Itr implements ListIterator<E> {
//                ListItr(int index) {
//                    super();
//                    cursor = index;
//                }
//
//                public boolean hasPrevious() {
//                    return cursor != 0;
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
//                @SuppressWarnings("unchecked")
//                public E previous() {
//                    checkForComodification();
//                    int i = cursor - 1;
//                    if (i < 0)
//                        throw new NoSuchElementException();
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i;
//                    return (E) elementData[lastRet = i];
//                }
//
//                public void set(E e) {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        ArrayList.this.set(lastRet, e);//保证了只更新上一次被访问元素位置的值.
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
//                        ArrayList.this.add(i, e);
//                        cursor = i + 1;//保证了不访问新增的元素值
//                        lastRet = -1;
//                        expectedModCount = modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//            }
//
//            /**
//             * 接下来是对subList()方法的介绍.读懂了上面所有的代码,再看下面这些简直太容易了.
//             * 但是但是但是,重要事情说三遍:
//             * 还是有要非常注意的地方,也是容易引起误解的地方:
//             * subList()这个方法,功能是返回指定列表的部分视图;
//             * 但是,它不是在java堆中新开辟的一个list对象,而是一个原列表视图的一部分，因此不管这两个列表谁发生了变化,都会体现在另一个列表上面.
//             * 这就和数据库中的视图一样,对视图的操作其实最终还是对生成视图的基本表的操作,而对于基本表的操作导致数据发生改变时,也会体现在视图上面.
//             */
//
//            public List<E> subList(int fromIndex, int toIndex) {
//                subListRangeCheck(fromIndex, toIndex, size);
//                return new SubList(this, 0, fromIndex, toIndex);
//            }
//
//            static void subListRangeCheck(int fromIndex, int toIndex, int size) {
//                if (fromIndex < 0)
//                    throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
//                if (toIndex > size)
//                    throw new IndexOutOfBoundsException("toIndex = " + toIndex);
//                if (fromIndex > toIndex)
//                    throw new IllegalArgumentException("fromIndex(" + fromIndex +
//                            ") > toIndex(" + toIndex + ")");
//            }
//
//            private class SubList extends AbstractList<E> implements RandomAccess {
//                private final AbstractList<E> parent;
//                private final int parentOffset;
//                private final int offset;
//                int size;
//
//                SubList(AbstractList<E> parent,
//                        int offset, int fromIndex, int toIndex) {
//                    this.parent = parent;//设置了父类,从而为后面基于父类的操作做了准备工作
//                    this.parentOffset = fromIndex;
//                    this.offset = offset + fromIndex;
//                    this.size = toIndex - fromIndex;
//                    this.modCount = ArrayList.this.modCount;
//                }
//
//                public E set(int index, E e) {
//                    rangeCheck(index);
//                    checkForComodification();
//                    E oldValue = ArrayList.this.elementData(offset + index);
//                    ArrayList.this.elementData[offset + index] = e;
//                    return oldValue;
//                }
//
//                public E get(int index) {
//                    rangeCheck(index);
//                    checkForComodification();
//                    return ArrayList.this.elementData(offset + index);
//                }
//
//                public int size() {
//                    checkForComodification();
//                    return this.size;
//                }
//
//                public void add(int index, E e) {
//                    rangeCheckForAdd(index);
//                    checkForComodification();
//                    parent.add(parentOffset + index, e);//为父类增加一个值
//                   // this.modCount = parent.modCount; //更改父类的结构改变计数器
//                    this.size++;
//                }
//
//                public E remove(int index) {
//                    rangeCheck(index);
//                    checkForComodification();
//                    E result = parent.remove(parentOffset + index);//为父类删除一个值
//                    //this.modCount = parent.modCount;//更改父类的结构改变计数器
//                    this.size--;
//                    return result;
//                }
//
//                protected void removeRange(int fromIndex, int toIndex) {
//                    checkForComodification();
//        //            parent.removeRange(parentOffset + fromIndex,
//        //                    parentOffset + toIndex);
//        //            this.modCount = parent.modCount;//更改父类的结构改变计数器
//                    this.size -= toIndex - fromIndex;
//                }
//
//                public boolean addAll(Collection<? extends E> c) {
//                    return addAll(this.size, c);
//                }
//
//                public boolean addAll(int index, Collection<? extends E> c) {
//                    rangeCheckForAdd(index);
//                    int cSize = c.size();
//                    if (cSize==0)
//                        return false;
//
//                    checkForComodification();
//                    parent.addAll(parentOffset + index, c);//调用父类方法,为父类elementData增加新元素.
//                    //this.modCount = parent.modCount;//更改父类的结构改变计数器
//                    this.size += cSize;
//                    return true;
//                }
//
//                public Iterator<E> iterator() {
//                    return listIterator();
//                }
//
//                public ListIterator<E> listIterator(final int index) {
//                    checkForComodification();
//                    rangeCheckForAdd(index);
//                    final int offset = this.offset;
//
//                    return new ListIterator<E>() {
//                        int cursor = index;
//                        int lastRet = -1;
//                        int expectedModCount = ArrayList.this.modCount;
//
//                        public boolean hasNext() {
//                            return cursor != SubList.this.size;
//                        }
//
//                        @SuppressWarnings("unchecked")
//                        public E next() {
//                            checkForComodification();
//                            int i = cursor;
//                            if (i >= SubList.this.size)
//                                throw new NoSuchElementException();
//                            Object[] elementData = ArrayList.this.elementData;
//                            if (offset + i >= elementData.length)
//                                throw new ConcurrentModificationException();
//                            cursor = i + 1;
//                            return (E) elementData[offset + (lastRet = i)];
//                        }
//
//                        public boolean hasPrevious() {
//                            return cursor != 0;
//                        }
//
//                        @SuppressWarnings("unchecked")
//                        public E previous() {
//                            checkForComodification();
//                            int i = cursor - 1;
//                            if (i < 0)
//                                throw new NoSuchElementException();
//                            Object[] elementData = ArrayList.this.elementData;
//                            if (offset + i >= elementData.length)
//                                throw new ConcurrentModificationException();
//                            cursor = i;
//                            return (E) elementData[offset + (lastRet = i)];
//                        }
//                        //jdk8新增
//                        @SuppressWarnings("unchecked")
//                        public void forEachRemaining(Consumer<? super E> consumer) {
//                            Objects.requireNonNull(consumer);
//                            final int size = SubList.this.size;
//                            int i = cursor;
//                            if (i >= size) {
//                                return;
//                            }
//                            final Object[] elementData = ArrayList.this.elementData;
//                            if (offset + i >= elementData.length) {
//                                throw new ConcurrentModificationException();
//                            }
//                            while (i != size && modCount == expectedModCount) {
//                                consumer.accept((E) elementData[offset + (i++)]);
//                            }
//                            // update once at end of iteration to reduce heap write traffic
//                            lastRet = cursor = i;
//                            checkForComodification();
//                        }
//
//                        public int nextIndex() {
//                            return cursor;
//                        }
//
//                        public int previousIndex() {
//                            return cursor - 1;
//                        }
//
//                        public void remove() {
//                            if (lastRet < 0)
//                                throw new IllegalStateException();
//                            checkForComodification();
//
//                            try {
//                                SubList.this.remove(lastRet);
//                                cursor = lastRet;
//                                lastRet = -1;
//                                expectedModCount = ArrayList.this.modCount;
//                            } catch (IndexOutOfBoundsException ex) {
//                                throw new ConcurrentModificationException();
//                            }
//                        }
//
//                        public void set(E e) {
//                            if (lastRet < 0)
//                                throw new IllegalStateException();
//                            checkForComodification();
//
//                            try {
//                                ArrayList.this.set(offset + lastRet, e);
//                            } catch (IndexOutOfBoundsException ex) {
//                                throw new ConcurrentModificationException();
//                            }
//                        }
//
//                        public void add(E e) {
//                            checkForComodification();
//
//                            try {
//                                int i = cursor;
//                                SubList.this.add(i, e);
//                                cursor = i + 1;
//                                lastRet = -1;
//                                expectedModCount = ArrayList.this.modCount;
//                            } catch (IndexOutOfBoundsException ex) {
//                                throw new ConcurrentModificationException();
//                            }
//                        }
//
//                        final void checkForComodification() {
//                            if (expectedModCount != ArrayList.this.modCount)
//                                throw new ConcurrentModificationException();
//                        }
//                    };
//                }
//
//                public List<E> subList(int fromIndex, int toIndex) {
//                    subListRangeCheck(fromIndex, toIndex, size);
//                    return new SubList(this, offset, fromIndex, toIndex);
//                }
//
//                private void rangeCheck(int index) {
//                    if (index < 0 || index >= this.size)
//                        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//                }
//
//                private void rangeCheckForAdd(int index) {
//                    if (index < 0 || index > this.size)
//                        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//                }
//
//                private String outOfBoundsMsg(int index) {
//                    return "Index: "+index+", Size: "+this.size;
//                }
//
//                private void checkForComodification() {
//                    if (ArrayList.this.modCount != this.modCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            //和上面forEachRemaining基本一样
//            @Override
//            public void forEach(Consumer<? super E> action) {
//                //传入函数接口不为空
//                Objects.requireNonNull(action);
//                //获取当前list结构更改次数
//                final int expectedModCount = modCount;
//                //获取当前数组elementData
//                @SuppressWarnings("unchecked")
//                final E[] elementData = (E[]) this.elementData;
//                //获取当前ArrayList中元素个数
//                final int size = this.size;
//                //对每一个元素执行函数接口定义的操作
//                for (int i=0; modCount == expectedModCount && i < size; i++) {
//                    action.accept(elementData[i]);
//                }
//                //结构改变异常检查
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException();
//                }
//            }
//
//            /**创建一个延迟绑定,快速失效的迭代器Spliterator
//             * @since 1.8
//             */
//            @Override
//            public Spliterator<E> spliterator() {
//                return new ArrayListSpliterator<>(this, 0, -1, 0);
//            }
//
//
//            //基于索引分成两个延迟初始化分割器
//            //ArrayList分割器,实现了分割器接口
//            static final class ArrayListSpliterator<E> implements Spliterator<E> {
//
//                /**
//                  * 如果ArrayList不可更改,or在结构不可变,我们可以用Arrays.spliterator来实现它们的分隔器.
//                  * 相反，我们在遍历过程中检测到的干扰与实际情况一样多，不会牺牲太多性能
//                  * 我们主要依靠modcounts,但这并不能保证并发冲突,而且有时在线程冲突方面过于保守,但为了在实践中检测到足够的问题这样做是值得的.
//                  *
//                  * 为了做到这一点,
//                  * (1)延迟初始化fence,expectedModCount,直到我们需要提交到我们正在检查的状态的最后一点;从而提升准确度.(这
//                  * 并不适用于SubList,它在创建spliterator时,并未使用延迟加载策略)
//                  *
//                  * (2)我们只是在forEach方法的最后进行了并发异常检查.当使用forEach时,我们在action后检测异常,而并非之前.
//                  * 更深层次的CME触发器适用于所有其它的违反假设的情况,例如:null或者给定由于并发导致size特别小的elementData,.
//                  * 这允许forEach在内部循环时,不再做更深层次的检查,简化了lambda表达式的action操作.
//                  * 虽然这需要进行多次检查，但请注意，在list.stream().forEach()的常见情况下，除了forEach本身之外，不会执行任何检查或其他计算.
//                  * 其它一些不常用的方法无法利用stream流提供的大多数优势.
//                  */
//
//                private final ArrayList<E> list;
//                private int index; // current index, modified on advance/split当前索引,在前进,分割时发生值的更改.
//                private int fence; // -1 until used; then one past last index,未使用前是-1
//                private int expectedModCount; // initialized when fence set,当fence设定值时,为其初始化.
//
//                /** Create new spliterator covering the given  range */
//                //根据给定的索引范围创建新的分割器.
//                ArrayListSpliterator(ArrayList<E> list, int origin, int fence,
//                                     int expectedModCount) {
//                    this.list = list; // OK if null unless traversed
//                    this.index = origin;
//                    this.fence = fence;
//                    this.expectedModCount = expectedModCount;
//                }
//
//                //第一次使用时,为fence初始化
//                private int getFence() {
//                    int hi; //forEach方法中,一个指定出现的变量.
//                    ArrayList<E> lst;
//                    //如果hi=fence<0
//                    if ((hi = fence) < 0) {
//                        //如果list==null,则fence=0
//                        if ((lst = list) == null)
//                            hi = fence = 0;
//                        //如果list!=null,则fence=list.size;  同时初始化expectedModCount
//                        else {
//                            expectedModCount = lst.modCount;
//                            hi = fence = lst.size;
//                        }
//                    }
//                    //返回fence
//                    return hi;
//                }
//
//                //尝试获取后面一半的分割器.
//                public ArrayListSpliterator<E> trySplit() {
//                    //hi=fence
//                    //lo=index
//                    //mid=(hi+lo)/2
//                    int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//                    //将分隔范围一分为二;如果索引范围太小,则不分割
//                    //如果分割,则返回的分割器范围是:[lo,mid).
//                    return (lo >= mid) ? null : // divide range in half unless too small
//                            new ArrayListSpliterator<E>(list, lo, index = mid,
//                                    expectedModCount);
//                }
//
//                /**
//                 * 利用传入函数接口,对elementData[index]处理;
//                 * 处理成功:返回true;
//                 * 处理失败:返回false;
//                 */
//                public boolean tryAdvance(Consumer<? super E> action) {
//                    //判定函数接口是否为null
//                    if (action == null)
//                        throw new NullPointerException();
//                    //前置索引i ,后置分割索引hi
//                    int hi = getFence(), i = index;
//                    //前置索引必须<后置索引,否则返回false
//                    if (i < hi) {
//                        //前置索引+1
//                        index = i + 1;
//                        //获取第一个元素,利用函数接口对其处理
//                        @SuppressWarnings("unchecked") E e = (E)list.elementData[i];
//                        action.accept(e);
//                        //并发异常检查
//                        if (list.modCount != expectedModCount)
//                            throw new ConcurrentModificationException();
//                        return true;
//                    }
//                    return false;
//                }
//
//                //利用传入函数接口,对elementData中每一个元素做处理.
//                public void forEachRemaining(Consumer<? super E> action) {
//                    int i, hi, mc; // hoist accesses and checks from loop
//                    ArrayList<E> lst; Object[] a;
//                    if (action == null)
//                        throw new NullPointerException();
//                    if ((lst = list) != null && (a = lst.elementData) != null) {
//                        if ((hi = fence) < 0) {
//                            mc = lst.modCount;
//                            hi = lst.size;
//                        }
//                        else
//                            mc = expectedModCount;
//                        if ((i = index) >= 0 && (index = hi) <= a.length) {
//                            for (; i < hi; ++i) {
//                                @SuppressWarnings("unchecked") E e = (E) a[i];
//                                action.accept(e);
//                            }
//                            if (lst.modCount == mc)
//                                return;
//                        }
//                    }
//                    throw new ConcurrentModificationException();
//                }
//
//                //预估分割器size
//                public long estimateSize() {
//                    return (long) (getFence() - index);
//                }
//
//                //ArrayList的SplIterator一些属性值
//                public int characteristics() {
//                    return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
//                }
//            }
//
//            @Override
//            public boolean removeIf(Predicate<? super E> filter) {
//                Objects.requireNonNull(filter);
//                //记录删除元素个数
//                int removeCount = 0;
//                //BitSet用每一位存储一个true或者false值,通过set方法设定.
//                //删除元素位置设为true.
//                final BitSet removeSet = new BitSet(size);
//                final int expectedModCount = modCount;
//                final int size = this.size;
//                //循环删除
//                for (int i=0; modCount == expectedModCount && i < size; i++) {
//                    @SuppressWarnings("unchecked")
//                    final E element = (E) elementData[i];
//                    if (filter.test(element)) {
//                        removeSet.set(i);
//                        removeCount++;
//                    }
//                }
//                //并发异常检查
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException();
//                }
//
//                // shift surviving elements left over the spaces left by removed elements
//                final boolean anyToRemove = removeCount > 0;
//                //如果有元素删除,则对elementData数组左移
//                if (anyToRemove) {
//                    //新size大小
//                    final int newSize = size - removeCount;
//                    for (int i=0, j=0; (i < size) && (j < newSize); i++, j++) {
//                        i = removeSet.nextClearBit(i);//返回值为false的索引,因为这样索引位置处的值没有删除
//                        elementData[j] = elementData[i];
//                    }
//                    //null设定,为GC准备
//                    for (int k=newSize; k < size; k++) {
//                        elementData[k] = null;  // Let gc do its work
//                    }
//                    //更新size值
//                    this.size = newSize;
//                    //并发异常检查
//                    if (modCount != expectedModCount) {
//                        throw new ConcurrentModificationException();
//                    }
//                    //结构更改次数+1
//                    modCount++;
//                }
//                //返回true:如果有元素删除;反之false
//                return anyToRemove;
//            }
//
//            //利用传入函数接口,更新elementData中每一个值
//            @Override
//            @SuppressWarnings("unchecked")
//            public void replaceAll(UnaryOperator<E> operator) {
//                Objects.requireNonNull(operator);
//                final int expectedModCount = modCount;
//                final int size = this.size;
//                for (int i=0; modCount == expectedModCount && i < size; i++) {
//                    elementData[i] = operator.apply((E) elementData[i]);
//                }
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException();
//                }
//                modCount++;
//            }
//
//            //根据传入比较器,对ArrayList排序
//            @Override
//            @SuppressWarnings("unchecked")
//            public void sort(Comparator<? super E> c) {
//                final int expectedModCount = modCount;
//                Arrays.sort((E[]) elementData, 0, size, c);
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException();
//                }
//                modCount++;
//            }
//        }
