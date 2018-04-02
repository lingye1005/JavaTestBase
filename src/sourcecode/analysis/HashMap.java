//    package sourcecode.analysis;
//
//    import java.io.IOException;
//    import java.io.InvalidObjectException;
//    import java.io.Serializable;
//    import java.lang.*;
//    import java.lang.reflect.ParameterizedType;
//    import java.lang.reflect.Type;
//    import java.util.*;
//    import java.util.function.*;
//    import java.util.function.BiFunction;
//    import java.util.function.Consumer;
//
//    /**
//     * Created by caoxiaohong on 17/11/9 20:30.
//     */
//
//
//    /**
//     * HashMap是实现了Map接口的哈希表.HashMap实现了map所有该有的操作.并且key和value都允许为null.
//     * (HashMap和HashTable唯一不同的是:前者是非线程安全的,后者是线程安全的.因此除去线程安全这一点,我们可以粗略的认为HashMap
//     * 和HashTable是等价的.)
//     * HashMap存储的元素是没有顺序性的;特别是:不能保证现有的顺序随着时间的推移不会发生变化.
//     *
//     * 如果哈希函数能够把存储的元素均匀的分配到各个bucket里面,那么get和put操作的时间性能都是常数级别的.
//     * 关于HashMap的迭代器,它的执行时间和两个因素有关,且成比例增长:
//     * (1)当前HashMap实例有几个bucket.
//     * (2)当前HashMap实例究竟存储了几个元素.
//     * 所以,如果在一个应用中经常用到迭代器的话,那么将HashMap实例的capacity设置的太大(也就是负载因子过低),这是不合理的.因为这会严重影响其性能.
//     *
//     * 有两个参数会影响HashMap实例的性能:(1)初始化capacity的大小.(2)负载因子的大小.
//     * capacity是指:哈希表拥有的bucket的数量.而初始化的capacity就是哈希表创建时的capacity.
//     * 负载因子是指:它其实是HashMap实例的capacity自动增长的指标.
//     * 当哈希表的条目超过了负载因子和capacity二者的乘积,哈希表会被rehash(也就是说,哈希表的内部数据结构会被重建),这样才能保证哈希表的bucket
//     * 的个数大约增长为之前的2倍大小.
//     *
//     * 通用规则是:默认的负载因子大小为0.75.这个数字是在时间和空间的损耗上面做了一个平衡的值.较大的负载因子虽然会提升空间利用率,
//     * 但是却提升了查找成本(查找成本在HashMap类中主要体现的操作就是get和put).当初始化一个HashMap的capacity的时候,条目的个数和负载因子
//     * 这两个因素都应该被考虑进去,从而尽量减少rehash的次数.如果初始化的capacity比最多条目数除以负载因子的值还大,那么rehash的操作
//     * 绝不会出现.
//     *
//     * 如果我们确定一定会在HashMap实例中存储很多的条目,那么在HashMap初始化时设置一个比较大的capacity要比设置一个小的capacity而让其
//     * 后期自动增长的效率高得多.
//     *
//     * 注意:HashMap类是非线程安全的.
//     * 如果多个线程同时操作一个HashMap实例,并且至少一个线程修改了HashMap实例的结构,要想实现线程安全,那么必须要有额外的措施来保证这一点.
//     * (结构修改是指:为HashMap实例add或者delete一个或者多个映射;仅仅更改某个已经存在的key对应的value值,这并不是结构的改变.)
//     * 这通常是通过同步一些map已经封装的对象,来实现线程同步的.
//     *
//     *  如果找不到map已经封装好的对象,那么就需要使用Collections.synchronizedMap的方法来包装map.
//     *  这一包装操作最好在创建HashMap实例的时候就完成,以防止在操作map的时候发生一些偶然的非线程安全的问题.
//     *  创建时的包装方式如下:
//     *  Map m = Collections.synchronizedMap(new HashMap(...));
//     *
//     * 所有通过这个类的"集合视图方法"返回的迭代器:(如果通过迭代器遍历的过程中遇到问题,)都会尽可能早的抛出异常的.
//     * 也就说:如果HashMap实例在创建完迭代器后,无论以何种方式,只要其结构发生了改变,迭代器都会抛出异常ConcurrentModificationException,
//     * 当然唯一例外的情况就是:迭代器自己的remove方法,虽然会改变HashMap实例的结构,但是这并不会导致迭代器抛出异常.(为什么呢?通过
//     * 后面的源码,我们自然可以理解到.因为迭代器自己的remove方法,始终删除的HashMap实例上一次刚刚访问的元素,而且更新了下一次访问的游标,所以
//     * 这就保证了不用抛出异常.)
//     *
//     * 注意:迭代器的尽可能早的抛出异常的功能,并不是完全得到保障的.一般来讲,在出现了非线程安全的修改问题时,没有硬性保障一定会抛出异常.
//     * 迭代器尽可能早的抛出异常是说:它只是会尽力做到这一点.
//     * 因此,如果一个程序完全依赖于这一异常的正确性,这可能会出现问题:迭代器的这一功能只能用来去查找一些bug.
//     *
//     * @see     Object#hashCode()
//     * @see     Collection
//     * @see     Map
//     * @see     TreeMap
//     * @see     Hashtable
//     * @since   1.2
//     */
//
//    /**
//     * 类名分析:
//     * (1)继承类:AbstractMap<K,V>
//     * (2)实现接口:
//     *  Map<K,V>:
//     *  Cloneable:表示这个类可以调用Object的clone()方法,但是这个接口里面并没有提供任何方法,所以要想实现对象HashMap的浅拷贝,则需要在此类中
//     *  手动写出clone()方法的拷贝过程.
//     *  Serializable:表示HashMap可以序列化,反序列化.
//     */
//
//    public class HashMap<K,V> extends AbstractMap<K,V>
//            implements Map<K,V>, Cloneable, Serializable {
//        private static final long serialVersionUID = 362498820763181265L;
//        /**
//         * 变量定义了:HashMap初始化容量的大小为:16.
//         * 变量定义的特征:
//         * 1.static final类型;
//         * 2.默认大小必须为2的整数次幂;
//         */
//        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
//
//        /**
//         * 变量定义了:HashMap初始化最大的容量.这个变量什么时候起作用呢?就是在初始化HashMap时,如果传入构造器中的参数>(1<<30),则初始化
//         * HashMap时,不能使用传入参数,而使用变量MAXIMUM_CAPACITY.
//         * 变量定义特征:
//         * 1.static final类型;
//         * 2.1<<30==1073741824;
//         *
//         */
//        static final int MAXIMUM_CAPACITY = 1 << 30;
//
//        /**
//         * HashMap初始化时的默认负载因子为:0.75;
//         * 当然负载因子也可以在构造器参数中进行指定.
//         * 变量定义特征:
//         * 1.static final类型;
//         * 2.(0,1)的取值范围;
//         */
//        static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//        /**
//         * 将链表转为红黑树的阈值
//         * 当一个元素在被添加时,如果链表中node的个数已经达到了8个,链表将转为红黑树形式.
//         * 这个值的设定必须大于2,且至少为8,显然源码中已经设定为8.原因是:
//         */
//        static final int TREEIFY_THRESHOLD = 8;
//
//        /**
//         * 将红黑树转为链表的阈值
//         * 红黑树中node个数必须小于阈值.
//         * 阈值最大为6,这里阈值设定为6
//         */
//        static final int UNTREEIFY_THRESHOLD = 6;
//
//        /**
//         * 桶被转为树的最小容量.
//         * (桶的结构变化方式有两种:resize方式+转为树)
//         * 为了避免桶的机构在选择变化方式时产生冲突,这一容量的设定值至少为32,那么可以看到在源码中已经设定这个值为64.
//         */
//        static final int MIN_TREEIFY_CAPACITY = 64;
//
//        /**
//         * Basic hash bin node, used for most entries.  (See below for
//         * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
//         * 基本哈希bin节点,用于大多数条目.
//         *
//         */
//        static class Node<K,V> implements Map.Entry<K,V> {
//            final int hash;
//            final K key;
//            V value;
//            Node<K,V> next;
//
//            Node(int hash, K key, V value, Node<K,V> next) {
//                this.hash = hash;
//                this.key = key;
//                this.value = value;
//                this.next = next;
//            }
//
//            public final K getKey()        { return key; }
//            public final V getValue()      { return value; }
//            public final String toString() { return key + "=" + value; }
//
//            //条目的哈希值=key和value的哈希值求异或
//            public final int hashCode() {
//                return Objects.hashCode(key) ^ Objects.hashCode(value);
//            }
//
//            public final V setValue(V newValue) {
//                V oldValue = value;
//                value = newValue;
//                return oldValue;
//            }
//            //equals方法还是正常的判定
//            public final boolean equals(Object o) {
//                if (o == this)
//                    return true;
//                if (o instanceof Map.Entry) {
//                    Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                    if (Objects.equals(key, e.getKey()) &&
//                            Objects.equals(value, e.getValue()))
//                        return true;
//                }
//                return false;
//            }
//        }
//
//        /* ---------------- Static utilities 静态工具类-------------- */
//
//        /**
//         *  计算key的哈希值h,再将h和(h无符号右移16位)进行异或.因为table使用了2的整数次幂的掩码,所以在当前
//         *  掩码二进制位处的哈希值集合,总会发生碰撞.(在已知的例子中是Float键的集合,在小table中保持连续的整数)
//         *  所以我们采取了h>>>>16的措施,使得这种影响从高位转移到低位.为什么选择右移16位,而不是18位等等,这其实是在速度,实用性,
//         *  性能方面作出的一个权衡.因为很多哈希集合已经分配的很合理了(这样的哈希集合是不会从h>>>16位得到好处的),同时,因为
//         *  我们使用红黑树来处理容器中大量集合的碰撞问题,为了降低系统损耗,我们采用了最廉价的方式,即对更改的二进制位进行了异或操作,
//         *  同时消除了由于表边界而不会用于索引计算的最高位的影响.
//         */
//        static final int hash(Object key) {
//            int h;
//            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        }
//
//        /**
//         * 如果传入参数x实现了Comparable接口,则返回类x,否则返回null.
//         */
//        static Class<?> comparableClassFor(Object x) {
//            if (x instanceof java.lang.Comparable) {
//                Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
//                //如果x是String类型,则返回String
//                if ((c = x.getClass()) == String.class) // bypass checks
//                    return c;
//                //如果c实现的接口不为空
//                if ((ts = c.getGenericInterfaces()) != null) {
//                    for (int i = 0; i < ts.length; ++i) { //对实现接口进行遍历
//                        if (((t = ts[i]) instanceof ParameterizedType) &&
//                                ((p = (ParameterizedType)t).getRawType() ==
//                                        java.lang.Comparable.class) &&
//                                (as = p.getActualTypeArguments()) != null &&
//                                as.length == 1 && as[0] == c) // type arg is c
//                            return c;
//                    }
//                }
//            }
//            return null;
//        }
//
//        /**
//         * Returns k.compareTo(x) if x matches kc (k's screened comparable
//         * class), else 0.
//         * 如果x和kc类型相同,则返回k.compareTo(x)结果;否则返回0.
//         */
//        @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
//        static int compareComparables(Class<?> kc, Object k, Object x) {
//            return (x == null || x.getClass() != kc ? 0 :
//                    ((java.lang.Comparable)k).compareTo(x));
//        }
//
//        /**
//         * Returns a power of two size for the given target capacity.
//         * 返回一个2倍capacity的整数次幂.
//         * 这是一个static final类型的变量
//         */
//        static final int tableSizeFor(int cap) {
//            int n = cap - 1;
//            n |= n >>> 1;
//            n |= n >>> 2;
//            n |= n >>> 4;
//            n |= n >>> 8;
//            n |= n >>> 16;
//            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//        }
//
//        /* ---------------- Fields 域-------------- */
//
//        /**
//         * table在第一次使用时,进行初始化,如果有必要会有resize的操作.
//         * 当分配好大小后,table的大小总是2的整数次幂.
//         * (我们还允许在某些操作中允许长度为零,以允许当前不需要的引导机制)
//         *
//         * transient类型变量,序列化时,table=null
//         */
//        transient Node<K,V>[] table;
//
//        /**
//         * 保存缓存的entrySet（）。请注意，AbstractMap字段用于keySet（）和values（）
//         * 序列化时,entrySet=null
//         */
//        transient Set<Map.Entry<K,V>> entrySet;
//
//        /**
//         * map中键值对的个数
//         * 序列化时,size没有值
//         */
//        transient int size;
//
//        /**
//         * map结构的更改次数.结构更改是:键值对个数发生改变 or 其它改变map内部结构的操作,如resize时.
//         * 这又是一个transient类型的域
//         */
//        transient int modCount;
//
//        /**
//         * 下一次resize的阈值大小:阈值=map容量*负载因子.(threshold=capacity*load factor)
//         */
//        int threshold;
//
//        /**
//         * 哈希表的负载因子
//         * final类型字段,构造器给定后,不可更改
//         * @serial
//         */
//        final float loadFactor;
//
//        /* ---------------- Public operations -------------- */
//
//        /**
//         * public实例构造器,参数指定了:map初始化时的容量+负载因子
//         */
//        public HashMap(int initialCapacity, float loadFactor) {
//            if (initialCapacity < 0)
//                throw new IllegalArgumentException("Illegal initial capacity: " +
//                        initialCapacity);
//            if (initialCapacity > MAXIMUM_CAPACITY)
//                initialCapacity = MAXIMUM_CAPACITY;
//            if (loadFactor <= 0 || Float.isNaN(loadFactor))
//                throw new IllegalArgumentException("Illegal load factor: " +
//                        loadFactor);
//            this.loadFactor = loadFactor;
//            this.threshold = tableSizeFor(initialCapacity);
//        }
//
//        /**
//         * public实例构造器,参数指定:初始容量.
//         * 通过调用上面的构造函数,负载因子为默认的0.75
//         */
//        public HashMap(int initialCapacity) {
//            this(initialCapacity, DEFAULT_LOAD_FACTOR);
//        }
//
//        /**
//         * public实例构造器,无参数.
//         * 默认的初始化容量为16 && 负载因子为默认的0.75
//         */
//        public HashMap() {
//            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
//        }
//
//        /**
//         * 创建一个新的HashMap,并用参数m来初始化其键值对.
//         * 这个新的map负载因子为0.75,容量大小:以足够存放键值对为目标.
//         */
//        public HashMap(Map<? extends K, ? extends V> m) {
//            this.loadFactor = DEFAULT_LOAD_FACTOR;
//            putMapEntries(m, false);//调用的就是下面的方法
//        }
//
//        /**
//         * 这一方法实现了Map.putAll和Map构造器的功能.
//         * 当初始化map时,evict值为false,其它时候为true.
//         * 这是一个final类型的方法
//         */
//        final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//            //传入map中键值对的个数
//            int s = m.size();
//            //如果m中有键值对
//            if (s > 0) {
//                //如果table为null
//                if (table == null) { // pre-size
//                    //初始化容量为ft=s/loadFactor+1.
//                    float ft = ((float)s / loadFactor) + 1.0F;
//                    //如果ft>MAXIMUM_CAPACITY,则令t=MAXIMUM_CAPACITY;否则令t=ft.
//                    int t = ((ft < (float)MAXIMUM_CAPACITY) ?
//                            (int)ft : MAXIMUM_CAPACITY);
//                    //如果t>阈值,更改阈值.将阈值更改为2t的整数次幂.
//                    if (t > threshold)
//                        threshold = tableSizeFor(t);
//                }
//                //如果m中键值对个数>阈值
//                else if (s > threshold)
//                    resize();
//                for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//                    K key = e.getKey();
//                    V value = e.getValue();
//                    putVal(hash(key), key, value, false, evict);
//                }
//            }
//        }
//
//        //不解释
//        public int size() {
//            return size;
//        }
//        //不解释
//        public boolean isEmpty() {
//            return size == 0;
//        }
//
//        /**
//         * 就是map的get(key)方法.
//         * 返回结果2种情况:null 或者 某个具体值.
//         * 唯一需要注意的是:返回结果为null并不是说map中没有对应key的映射,因为HashMap中key和value都允许为null.
//         * 这可能key本来对应的value就是null.
//         * 如果区分到底是不存在这样的映射?还是说key对应的value就是null?-->containsKey()方法可以解决这个问题.
//         */
//        public V get(Object key) {
//            Node<K,V> e;
//            //调用了getNode方法,参数为:key的哈希值和key
//            return (e = getNode(hash(key), key)) == null ? null : e.value;
//        }
//
//        /**
//         * 实现Map.get()及相关算法.
//         * final类型方法.包级私有
//         */
//        final Node<K,V> getNode(int hash, Object key) {
//            Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
//            //赋值:tab=table  &  n=tab.length  &  first=tab[(n - 1) & hash]]
//            //table不为空 & table长度>0 & table[(n - 1) & hash]]!=null
//            if ((tab = table) != null && (n = tab.length) > 0 &&
//                    (first = tab[(n - 1) & hash]) != null) {
//                //总是先检查first节点是否符合条件,这是从性能角度出发的,这一点要注意
//                if (first.hash == hash && // always check first node
//                        ((k = first.key) == key || (key != null && key.equals(k))))
//                    return first;
//                //e=first.next节点
//                //next节点不为空
//                if ((e = first.next) != null) {
//                    //如果first节点为红黑树节点,则采用红黑树的查找方式去找key对应的value,并返回
//                    if (first instanceof TreeNode)
//                        return ((TreeNode<K,V>)first).getTreeNode(hash, key);
//                    //如果first节点为链表节点,则顺序查找key对应的value.
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k))))
//                            return e;
//                    } while ((e = e.next) != null);
//                }
//            }
//            return null;
//        }
//
//        /**
//         * 如果map中包含对应的映射,则返回true;否则false.
//         */
//        public boolean containsKey(Object key) {
//            return getNode(hash(key), key) != null;
//        }
//
//        /**
//         * map的put操作,如果map中已经有了key,则key对应的原来的value会被替换掉.
//         * 调用了下面的final类型方法.
//         */
//        public V put(K key, V value) {
//            return putVal(hash(key), key, value, false, true);
//        }
//
//        /**
//         * 实现了map.put()及其相关的方法.
//         * @param onlyIfAbsent 为true时,则不覆盖key对应的value值,但是put在调用这个方法时,赋值false,说明覆盖原始value.
//         * @param evict 为false时,table处于创建模式.
//         */
//        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                       boolean evict) {
//            Node<K,V>[] tab; Node<K,V> p; int n, i;
//            /**如果table为null,或者table.length==0,通过调用resize()方法为table初始化大小.
//             * tab=table或者tab = resize();
//             * n=tab.length 或者 n=(tab = resize()).length
//             */
//            if ((tab = table) == null || (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            /**如果first节点为null,则为tab[first=i]赋值.
//             * p=tab[i = (n - 1) & hash]
//             */
//            if ((p = tab[i = (n - 1) & hash]) == null)
//                tab[i] = newNode(hash, key, value, null);
//            else {
//                Node<K,V> e; K k;
//                //如果p节点和插入节点的hash和key相同,则e=p.
//                if (p.hash == hash &&
//                        ((k = p.key) == key || (key != null && key.equals(k))))
//                    e = p;
//                //如果p是红黑树节点,调用红黑树节点插入法.
//                else if (p instanceof TreeNode)
//                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//                //如果p为链表节点
//                else {
//                    for (int binCount = 0; ; ++binCount) {
//                        //链表结尾处插入节点
//                        if ((e = p.next) == null) {
//                            p.next = newNode(hash, key, value, null);
//                            //如果链表节点个数到达在插入新的节点后,达到转为红黑树的阈值,则还需要将此链表转为红黑树.
//                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                                treeifyBin(tab, hash);
//                            break;
//                        }
//                        //如果插入节点和原链表中的某个key具有相同的hash且key相同,停止查找.
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k))))
//                            break;
//                        p = e;
//                    }
//                }
//                if (e != null) { // existing mapping for key
//                    V oldValue = e.value;
//                    //替换原value值
//                    if (!onlyIfAbsent || oldValue == null)
//                        e.value = value;
//                    afterNodeAccess(e);
//                    return oldValue;
//                }
//            }
//            //map结构更改次数+1
//            ++modCount;
//            //键值对个数>阈值,更新table容量为原来2倍.这说明,HashMap扩容为原来2倍.
//            if (++size > threshold)
//                resize();
//            afterNodeInsertion(evict);
//            return null;
//        }
//
//        /**
//         * 初始化table的大小或者将table的大小增大为两倍.
//         * 如果table==null,将table的大小设置为指定阈值threshold大小;
//         * 否则,因为我们使用的增长策略是2的整数次幂方式,table的容量在更改时,同一元素在table中的索引要么不变,要么移动到相对原位置
//         * 而言,距离2的整数次幂的一个位置.
//         * 最终返回table.
//         */
//        final Node<K,V>[] resize() {
//            Node<K,V>[] oldTab = table;
//            int oldCap = (oldTab == null) ? 0 : oldTab.length;
//            int oldThr = threshold;
//            int newCap, newThr = 0;
//            //如果原map容量>0
//            if (oldCap > 0) {
//                //如果原容量>=最大容量,更改阈值为Integer最大值,并返回原table,程序停止执行.
//                if (oldCap >= MAXIMUM_CAPACITY) {
//                    threshold = Integer.MAX_VALUE;
//                    return oldTab;
//                }
//                //为新阈值赋值:oldThr << 1
//                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                        oldCap >= DEFAULT_INITIAL_CAPACITY)
//                    newThr = oldThr << 1; // double threshold
//            }
//            //如果原阈值>0
//            else if (oldThr > 0) // initial capacity was placed in threshold
//            //新阈值=原阈值
//                newCap = oldThr;
//            else {               // zero initial threshold signifies using defaults
//                newCap = DEFAULT_INITIAL_CAPACITY;
//                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//            }
//            //如果新阈值==0
//            if (newThr == 0) {
//                //ft为新阈值
//                float ft = (float)newCap * loadFactor;
//                //新阈值赋值
//                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                        (int)ft : Integer.MAX_VALUE);
//            }
//            //table阈值赋值
//            threshold = newThr;
//            @SuppressWarnings({"rawtypes","unchecked"})
//            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
//            //table赋值
//            table = newTab;
//            //如果原table不为null
//            if (oldTab != null) {
//                //遍历旧table各个bucket
//                for (int j = 0; j < oldCap; ++j) {
//                    Node<K,V> e;
//                    //如果原table[j]!=null
//                    if ((e = oldTab[j]) != null) {
//                        //将原table[j]处置为null,释放空间.
//                        oldTab[j] = null;
//                        //如果e无后继节点
//                        if (e.next == null)
//                            //将e值付给新table的e对应的first节点
//                            newTab[e.hash & (newCap - 1)] = e;
//                        //e如果为红黑树类型节点
//                        else if (e instanceof TreeNode)
//                            //重构红黑树结构,到新table中
//                            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                        //e如果为链表节点
//                        else { // preserve order
//                            Node<K,V> loHead = null, loTail = null;
//                            Node<K,V> hiHead = null, hiTail = null;
//                            Node<K,V> next;
//                            do {
//                                next = e.next;
//                                if ((e.hash & oldCap) == 0) {
//                                    if (loTail == null)
//                                        loHead = e;
//                                    else
//                                        loTail.next = e;
//                                    loTail = e;
//                                }
//                                else {
//                                    if (hiTail == null)
//                                        hiHead = e;
//                                    else
//                                        hiTail.next = e;
//                                    hiTail = e;
//                                }
//                            } while ((e = next) != null);
//                            if (loTail != null) {
//                                loTail.next = null;
//                                newTab[j] = loHead;
//                            }
//                            if (hiTail != null) {
//                                hiTail.next = null;
//                                newTab[j + oldCap] = hiHead;
//                            }
//                        }
//                    }
//                }
//            }
//            return newTab;
//        }
//
//        /**
//         * 将桶数组table转为红黑树.
//         */
//        final void treeifyBin(Node<K,V>[] tab, int hash) {
//            int n, index; Node<K,V> e;
//            //如果table为空或者桶数组table太小,不符合转为红黑树的条件.
//            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
//                //桶数组table扩容
//                resize();
//            //如果符合转为红黑树的条件,且hash对应的桶不为null
//            else if ((e = tab[index = (n - 1) & hash]) != null) {
//                TreeNode<K,V> hd = null, tl = null;
//                //遍历链表
//                do {
//                    TreeNode<K,V> p = replacementTreeNode(e, null);
//                    if (tl == null)
//                        hd = p;
//                    else {
//                        p.prev = tl;
//                        tl.next = p;
//                    }
//                    tl = p;
//                } while ((e = e.next) != null);
//                if ((tab[index] = hd) != null)
//                    hd.treeify(tab);
//            }
//        }
//
//
//        //将指定m中的键值对映射到调用putAll方法的map中.如果key有重复,则value值被覆盖.
//        public void putAll(Map<? extends K, ? extends V> m) {
//            putMapEntries(m, true);
//        }
//
//        //删除指定key的条目
//        public V remove(Object key) {
//            Node<K,V> e;
//            /**
//             * null:显然传入的value=null,说明需要忽略value,所以matchValue必定为false.
//             * true:删除当前节点时,会移动其它节点.
//             */
//            return (e = removeNode(hash(key), key, null, false, true)) == null ?
//                    null : e.value;
//        }
//
//        /**
//         * Map.remove方法及其相关方法的实现
//         * @param matchValue 如果为true,则删除一个node的条件是:key和value都一致,才删除.
//         * @param movable 如果为false,则删除当前节点时,不会移动其它节点.
//         */
//        final Node<K,V> removeNode(int hash, Object key, Object value,
//                                   boolean matchValue, boolean movable) {
//            Node<K,V>[] tab; Node<K,V> p; int n, index;
//            /**如果table不为null 且 table.leng>0 且 table[first]!=null
//             * 赋值:tab=table  &  n=tab.length  &  p=tab[first] & index=first
//             * first=(n-1) & hash :这个索引到底是什么?其实就是key在table的下标.所以如果如果tab[index]=null,说明
//             * 这个索引值处没有存储元素,也就是table中未存储这个索引值的任何node,故不需要再往下查找啦,直接返回null.
//             */
//            if ((tab = table) != null && (n = tab.length) > 0 &&
//                    (p = tab[index = (n - 1) & hash]) != null) {
//                Node<K,V> node = null, e; K k; V v;
//                /**
//                 * 这里的写法和插入node写法一致.首先检查bucket中第一个node是否符合条件,也就是检查p是否符合条件;
//                 * 如果p(=tab[index])的hash和key都一致,则node=p;
//                 */
//                if (p.hash == hash &&
//                        ((k = p.key) == key || (key != null && key.equals(k))))
//                    node = p;
//                //如果p后面有节点,即hash值相同的节点个数>1
//                else if ((e = p.next) != null) {
//                    //如果p节点类型为红黑树节点,则调用红黑树节点的查找方法.
//                    if (p instanceof TreeNode)
//                        node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
//                    //如果p节点为链表节点,则顺序查找链表节点
//                    else {
//                        do {
//                            if (e.hash == hash &&
//                                    ((k = e.key) == key ||
//                                            (key != null && key.equals(k)))) {
//                                node = e;
//                                break;
//                            }
//                            p = e;
//                        } while ((e = e.next) != null);
//                    }
//                }
//                /**如果找到指定hash的node,且保证删除策略matchValue,则可以删除.
//                 * 1.matchValue=true,需要根据value是否一致来确定是否删除;
//                 * 2.matchValue=false,则删除.
//                 */
//                if (node != null && (!matchValue || (v = node.value) == value ||
//                        (value != null && value.equals(v)))) {
//                    //node类型为红黑树节点,调用红黑树节点删除方法.
//                    if (node instanceof TreeNode)
//                        ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
//                    /**p:需要被删除节点node的前驱
//                     * 如果p节点和node节点是同一个,更改bucket中的值/
//                     * buckt=tab[index]=node--->node.next
//                     */
//                    else if (node == p)
//                        tab[index] = node.next;
//                    //直接更改链接指针,则删除node节点.
//                    else
//                        p.next = node.next;
//                    //结构更改次数+1
//                    ++modCount;
//                    //键值对个数-1
//                    --size;
//                    //回调函数
//                    afterNodeRemoval(node);
//                    //返回删除节点
//                    return node;
//                }
//            }
//            return null;
//        }
//
//        /**
//         * 删除map中所有的键值对.此方法调用后,map实例将为null,因为方法中对tab[i]=null的赋值
//         */
//        public void clear() {
//            Node<K,V>[] tab;
//            modCount++;
//            if ((tab = table) != null && size > 0) {
//                size = 0;
//                //注意:tab[i]=null,则告诉jvm可以对table的内存进行回收,同时table也不再拥有其内存空间.
//                for (int i = 0; i < tab.length; ++i)
//                    tab[i] = null;
//            }
//        }
//
//        /**
//         * 这个方法没啥好说的
//         */
//        public boolean containsValue(Object value) {
//            Node<K,V>[] tab; V v;
//            if ((tab = table) != null && size > 0) {
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K,V> e = tab[i]; e != null; e = e.next) {
//                        if ((v = e.value) == value ||
//                                (value != null && value.equals(v)))
//                            return true;
//                    }
//                }
//            }
//            return false;
//        }
//
//        /**
//         * 返回map中key的集合视图.
//         * 这一集合由map做后台支撑,因此map中key的更改会影响key的Set集合,反之亦然.
//         * 如果在key的集合迭代过程中,map中key被更改了,会产生什么结果并未定义.
//         * 这一set支持删除元素,通过Iterator.remove(), Set.remove(),
//         * removeAll(), retainAll(), clear()方法,会从map中删除整个条目.
//         * 这一set不支持add()和addAll()方法.
//         */
//        public Set<K> keySet() {
//            Set<K> ks = keySet;
//            if (ks == null) {
//                ks = new KeySet();
//                keySet = ks;
//            }
//            return ks;
//        }
//
//        /**继承于set骨架实现的内部final类
//         */
//        final class KeySet extends AbstractSet<K> {
//            public final int size()                 { return size; }
//            public final void clear()               { HashMap.this.clear(); }
//            public final Iterator<K> iterator()     { return new KeyIterator(); }
//            public final boolean contains(Object o) { return containsKey(o); }
//            public final boolean remove(Object key) {
//                return removeNode(hash(key), key, null, false, true) != null;
//            }
//            public final Spliterator<K> spliterator() {
//                return new KeySpliterator<>(HashMap.this, 0, -1, 0, 0);
//            }
//            public final void forEach(java.util.function.Consumer<? super K> action) {
//                Node<K,V>[] tab;
//                if (action == null)
//                    throw new NullPointerException();
//                if (size > 0 && (tab = table) != null) {
//                    int mc = modCount;
//                    for (int i = 0; i < tab.length; ++i) {
//                        for (Node<K,V> e = tab[i]; e != null; e = e.next)
//                            action.accept(e.key);
//                    }
//                    if (modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//        }
//
//        /**
//         * 获取map中values的一个Collection视图.
//         * 这个collection是以map作为后台支撑的,所以map中value的更改会影响这个collection,反之亦然.
//         * 当迭代这个collection时,如果map发生了改变,迭代结果会受到什么影响并未定义.
//         * 这个collection支持元素的删除,通过Iterator.remove(),
//         * Collection.remove(), removeAll(),
//         * retainAll(),clear()方法,均可进行删除,此时删除的是一个条目.
//         * 这个collection不支持元素的添加,即为不支持add()和addAll()方法.
//         */
//        public Collection<V> values() {
//            Collection<V> vs = values;
//            if (vs == null) {
//                vs = new Values();
//                values = vs;
//            }
//            return vs;
//        }
//        //继续collection骨架实现的内部final类
//        final class Values extends AbstractCollection<V> {
//            public final int size()                 { return size; }
//            public final void clear()               { HashMap.this.clear(); }
//            public final Iterator<V> iterator()     { return new ValueIterator(); }
//            public final boolean contains(Object o) { return containsValue(o); }
//            public final Spliterator<V> spliterator() {
//                return new ValueSpliterator<>(HashMap.this, 0, -1, 0, 0);
//            }
//            public final void forEach(java.util.function.Consumer<? super V> action) {
//                Node<K,V>[] tab;
//                if (action == null)
//                    throw new NullPointerException();
//                if (size > 0 && (tab = table) != null) {
//                    int mc = modCount;
//                    for (int i = 0; i < tab.length; ++i) {
//                        for (Node<K,V> e = tab[i]; e != null; e = e.next)
//                            action.accept(e.value);
//                    }
//                    if (modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//        }
//
//        /**
//         * 返回map中条目的一个set.
//         * 这个set后台由map支撑,故在结构上,二者互相影响.
//         * 支持删除操作,不支持添加操作.
//         */
//        public Set<Map.Entry<K,V>> entrySet() {
//            Set<Map.Entry<K,V>> es;
//            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
//        }
//        //继承set骨架实现的内部final类
//        final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
//            public final int size()                 { return size; }
//            public final void clear()               { HashMap.this.clear(); }
//            public final Iterator<Map.Entry<K,V>> iterator() {
//                return new EntryIterator();
//            }
//            public final boolean contains(Object o) {
//                if (!(o instanceof Map.Entry))
//                    return false;
//                Map.Entry<?,?> e = (Map.Entry<?,?>) o;
//                Object key = e.getKey();
//                Node<K,V> candidate = getNode(hash(key), key);
//                return candidate != null && candidate.equals(e);
//            }
//            public final boolean remove(Object o) {
//                if (o instanceof Map.Entry) {
//                    Map.Entry<?,?> e = (Map.Entry<?,?>) o;
//                    Object key = e.getKey();
//                    Object value = e.getValue();
//                    return removeNode(hash(key), key, value, true, true) != null;
//                }
//                return false;
//            }
//            public final Spliterator<Map.Entry<K,V>> spliterator() {
//                return new EntrySpliterator<>(HashMap.this, 0, -1, 0, 0);
//            }
//            public final void forEach(java.util.function.Consumer<? super Entry<K,V>> action) {
//                Node<K,V>[] tab;
//                if (action == null)
//                    throw new NullPointerException();
//                if (size > 0 && (tab = table) != null) {
//                    int mc = modCount;
//                    for (int i = 0; i < tab.length; ++i) {
//                        for (Node<K,V> e = tab[i]; e != null; e = e.next)
//                            action.accept(e);
//                    }
//                    if (modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//        }
//
//        // Overrides of JDK8 Map extension methods
//
//        /**
//         * 以下为:jdk8中map的扩展方法
//         */
//        @Override
//        public V getOrDefault(Object key, V defaultValue) {
//            Node<K,V> e;
//            return (e = getNode(hash(key), key)) == null ? defaultValue : e.value;
//        }
//
//        @Override
//        public V putIfAbsent(K key, V value) {
//            return putVal(hash(key), key, value, true, true);
//        }
//
//        @Override
//        public boolean remove(Object key, Object value) {
//            return removeNode(hash(key), key, value, true, true) != null;
//        }
//
//        @Override
//        public boolean replace(K key, V oldValue, V newValue) {
//            Node<K,V> e; V v;
//            if ((e = getNode(hash(key), key)) != null &&
//                    ((v = e.value) == oldValue || (v != null && v.equals(oldValue)))) {
//                e.value = newValue;
//                afterNodeAccess(e);
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        public V replace(K key, V value) {
//            Node<K,V> e;
//            if ((e = getNode(hash(key), key)) != null) {
//                V oldValue = e.value;
//                e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//            return null;
//        }
//
//        @Override
//        public V computeIfAbsent(K key,
//                                 java.util.function.Function<? super K, ? extends V> mappingFunction) {
//            if (mappingFunction == null)
//                throw new NullPointerException();
//            int hash = hash(key);
//            Node<K,V>[] tab; Node<K,V> first; int n, i;
//            int binCount = 0;
//            TreeNode<K,V> t = null;
//            Node<K,V> old = null;
//            if (size > threshold || (tab = table) == null ||
//                    (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            if ((first = tab[i = (n - 1) & hash]) != null) {
//                if (first instanceof TreeNode)
//                    old = (t = (TreeNode<K,V>)first).getTreeNode(hash, key);
//                else {
//                    Node<K,V> e = first; K k;
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k)))) {
//                            old = e;
//                            break;
//                        }
//                        ++binCount;
//                    } while ((e = e.next) != null);
//                }
//                V oldValue;
//                if (old != null && (oldValue = old.value) != null) {
//                    afterNodeAccess(old);
//                    return oldValue;
//                }
//            }
//            V v = mappingFunction.apply(key);
//            if (v == null) {
//                return null;
//            } else if (old != null) {
//                old.value = v;
//                afterNodeAccess(old);
//                return v;
//            }
//            else if (t != null)
//                t.putTreeVal(this, tab, hash, key, v);
//            else {
//                tab[i] = newNode(hash, key, v, first);
//                if (binCount >= TREEIFY_THRESHOLD - 1)
//                    treeifyBin(tab, hash);
//            }
//            ++modCount;
//            ++size;
//            afterNodeInsertion(true);
//            return v;
//        }
//
//        public V computeIfPresent(K key,
//                                  java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//            if (remappingFunction == null)
//                throw new NullPointerException();
//            Node<K,V> e; V oldValue;
//            int hash = hash(key);
//            if ((e = getNode(hash, key)) != null &&
//                    (oldValue = e.value) != null) {
//                V v = remappingFunction.apply(key, oldValue);
//                if (v != null) {
//                    e.value = v;
//                    afterNodeAccess(e);
//                    return v;
//                }
//                else
//                    removeNode(hash, key, null, false, true);
//            }
//            return null;
//        }
//
//        @Override
//        public V compute(K key,
//                         java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//            if (remappingFunction == null)
//                throw new NullPointerException();
//            int hash = hash(key);
//            Node<K,V>[] tab; Node<K,V> first; int n, i;
//            int binCount = 0;
//            TreeNode<K,V> t = null;
//            Node<K,V> old = null;
//            if (size > threshold || (tab = table) == null ||
//                    (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            if ((first = tab[i = (n - 1) & hash]) != null) {
//                if (first instanceof TreeNode)
//                    old = (t = (TreeNode<K,V>)first).getTreeNode(hash, key);
//                else {
//                    Node<K,V> e = first; K k;
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k)))) {
//                            old = e;
//                            break;
//                        }
//                        ++binCount;
//                    } while ((e = e.next) != null);
//                }
//            }
//            V oldValue = (old == null) ? null : old.value;
//            V v = remappingFunction.apply(key, oldValue);
//            if (old != null) {
//                if (v != null) {
//                    old.value = v;
//                    afterNodeAccess(old);
//                }
//                else
//                    removeNode(hash, key, null, false, true);
//            }
//            else if (v != null) {
//                if (t != null)
//                    t.putTreeVal(this, tab, hash, key, v);
//                else {
//                    tab[i] = newNode(hash, key, v, first);
//                    if (binCount >= TREEIFY_THRESHOLD - 1)
//                        treeifyBin(tab, hash);
//                }
//                ++modCount;
//                ++size;
//                afterNodeInsertion(true);
//            }
//            return v;
//        }
//
//        @Override
//        public V merge(K key, V value,
//                       java.util.function.BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
//            if (value == null)
//                throw new NullPointerException();
//            if (remappingFunction == null)
//                throw new NullPointerException();
//            int hash = hash(key);
//            Node<K,V>[] tab; Node<K,V> first; int n, i;
//            int binCount = 0;
//            TreeNode<K,V> t = null;
//            Node<K,V> old = null;
//            if (size > threshold || (tab = table) == null ||
//                    (n = tab.length) == 0)
//                n = (tab = resize()).length;
//            if ((first = tab[i = (n - 1) & hash]) != null) {
//                if (first instanceof TreeNode)
//                    old = (t = (TreeNode<K,V>)first).getTreeNode(hash, key);
//                else {
//                    Node<K,V> e = first; K k;
//                    do {
//                        if (e.hash == hash &&
//                                ((k = e.key) == key || (key != null && key.equals(k)))) {
//                            old = e;
//                            break;
//                        }
//                        ++binCount;
//                    } while ((e = e.next) != null);
//                }
//            }
//            if (old != null) {
//                V v;
//                if (old.value != null)
//                    v = remappingFunction.apply(old.value, value);
//                else
//                    v = value;
//                if (v != null) {
//                    old.value = v;
//                    afterNodeAccess(old);
//                }
//                else
//                    removeNode(hash, key, null, false, true);
//                return v;
//            }
//            if (value != null) {
//                if (t != null)
//                    t.putTreeVal(this, tab, hash, key, value);
//                else {
//                    tab[i] = newNode(hash, key, value, first);
//                    if (binCount >= TREEIFY_THRESHOLD - 1)
//                        treeifyBin(tab, hash);
//                }
//                ++modCount;
//                ++size;
//                afterNodeInsertion(true);
//            }
//            return value;
//        }
//
//        @Override
//        public void forEach(BiConsumer<? super K, ? super V> action) {
//            Node<K,V>[] tab;
//            if (action == null)
//                throw new NullPointerException();
//            if (size > 0 && (tab = table) != null) {
//                int mc = modCount;
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K,V> e = tab[i]; e != null; e = e.next)
//                        action.accept(e.key, e.value);
//                }
//                if (modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        @Override
//        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
//            Node<K,V>[] tab;
//            if (function == null)
//                throw new NullPointerException();
//            if (size > 0 && (tab = table) != null) {
//                int mc = modCount;
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K,V> e = tab[i]; e != null; e = e.next) {
//                        e.value = function.apply(e.key, e.value);
//                    }
//                }
//                if (modCount != mc)
//                    throw new ConcurrentModificationException();
//            }
//        }
//
//        /* ------------------------------------------------------------ */
//        // clone和序列化实现
//        /**
//         * 返回map实例的浅拷贝:key和value本身不会被clone,因为key和value均为对象.
//         */
//        @SuppressWarnings("unchecked")
//        @Override
//        public Object clone() {
//            HashMap<K,V> result;
//            try {
//                result = (HashMap<K,V>)super.clone();
//            } catch (CloneNotSupportedException e) {
//                // this shouldn't happen, since we are Cloneable
//                throw new InternalError(e);
//            }
//            //将result实例的一些域进行赋值,要么为null,要么为0.因为result和原map共享table,所以所有域的值都不再有任何意义.
//            result.reinitialize();
//            //使用map初始化result
//            result.putMapEntries(this, false);
//            return result;
//        }
//
//        //这些方法在序列化HasSet时,同样适用.
//        final float loadFactor() { return loadFactor; }
//        //如果table不为null,返回容量为table的长度;
//        //如果table为null,如果阈值>0,返回容量为阈值;如果阈值<=0,返回默认初始化容量.
//        final int capacity() {
//            return (table != null) ? table.length :
//                    (threshold > 0) ? threshold :
//                            DEFAULT_INITIAL_CAPACITY;
//        }
//
//        /**
//         * 保存当前HashMap实例到流中(如序列化时)
//         * 序列化数据格式:
//         * 1.HashMap的容量(=桶数组的长度).
//         * 2.size(键值对个数)
//         * 3.键值对(顺序不确定)
//         */
//        private void writeObject(java.io.ObjectOutputStream s)
//                throws IOException {
//            int buckets = capacity();
//            // Write out the threshold, loadfactor, and any hidden stuff
//            //写入:阈值,负载因子,其它隐藏信息
//            s.defaultWriteObject();
//            //写入:bucket个数(容量)
//            s.writeInt(buckets);
//            //写入size
//            s.writeInt(size);
//            //写入:键值对
//            internalWriteEntries(s);
//        }
//
//        /**
//         * 从流重建HashMap(如反序列化时)
//         */
//        private void readObject(java.io.ObjectInputStream s)
//                throws IOException, ClassNotFoundException {
//            //读取:阈值(忽略),负载因子,其它隐藏信息
//            s.defaultReadObject();
//            //初始化map,对HashMap的一些域初始化.
//            reinitialize();
//            //如果负载因子<=0 or 为非数字值,则抛出异常.
//            if (loadFactor <= 0 || Float.isNaN(loadFactor))
//                throw new InvalidObjectException("Illegal load factor: " +
//                        loadFactor);
//            /**
//             *读取buckets值,且忽略.
//             * 忽略是什么意思?
//             * 因为stream的读取必须是一个个二进制位的读取,所以读入顺序同序列化顺序一致.比如,必须先读取bucket才能读取size.
//             * 所以虽然读取了bucket的值,但是只是为了整个流的读取,不会对这个值进行处理.
//             */
//            s.readInt();
//            //读取size,并保存
//            int mappings = s.readInt();
//            //如果键值对个数<0,则抛出异常.
//            if (mappings < 0)
//                throw new InvalidObjectException("Illegal mappings count: " +
//                        mappings);
//            //如果键值对个数>0
//            else if (mappings > 0) { // (if zero, use defaults)
//                // Size the table using given load factor only if within
//                // range of 0.25...4.0
//                //负载因子
//                float lf = Math.min(Math.max(0.25f, loadFactor), 4.0f);
//                //容量(必然大于键值对个数)
//                float fc = (float)mappings / lf + 1.0f;
//                //根据fc进一步确定容量cap
//                int cap = ((fc < DEFAULT_INITIAL_CAPACITY) ?
//                        DEFAULT_INITIAL_CAPACITY :
//                        (fc >= MAXIMUM_CAPACITY) ?
//                                MAXIMUM_CAPACITY :
//                                tableSizeFor((int)fc));
//                //阈值=容量*负载因子
//                float ft = (float)cap * lf;
//                //根据ft确定阈值
//                threshold = ((cap < MAXIMUM_CAPACITY && ft < MAXIMUM_CAPACITY) ?
//                        (int)ft : Integer.MAX_VALUE);
//                //为table申请内存空间个数:cap
//                @SuppressWarnings({"rawtypes","unchecked"})
//                Node<K,V>[] tab = (Node<K,V>[])new Node[cap];
//                table = tab;
//
//                //table建好后,将键值对拷贝到table中.
//                for (int i = 0; i < mappings; i++) {
//                    @SuppressWarnings("unchecked")
//                    K key = (K) s.readObject();
//                    @SuppressWarnings("unchecked")
//                    V value = (V) s.readObject();
//                    putVal(hash(key), key, value, false, false);
//                }
//            }
//        }
//
//        /* ------------------------------------------------------------ */
//        // hash迭代器
//        //抽象类
//        abstract class HashIterator {
//            Node<K,V> next;        // next entry to return
//            Node<K,V> current;     // current entry
//            int expectedModCount;  // for fast-fail
//            int index;             // current slot
//
//            HashIterator() {
//                expectedModCount = modCount;//保证了在map结构发生改变时,迭代器失效
//                Node<K,V>[] t = table;
//                current = next = null;
//                index = 0;
//                //找到迭代的第一个入口
//                if (t != null && size > 0) { // advance to first entry
//                    do {} while (index < t.length && (next = t[index++]) == null);
//                }
//            }
//
//            public final boolean hasNext() {
//                return next != null;
//            }
//
//            final Node<K,V> nextNode() {
//                Node<K,V>[] t;
//                Node<K,V> e = next;
//                //map结构改变,抛出异常
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                //节点为null,抛出异常
//                if (e == null)
//                    throw new NoSuchElementException();
//                //如果当前节点e为最后一个节点,则再次为index赋值,找到迭代器的入口.注意此时next=null
//                if ((next = (current = e).next) == null && (t = table) != null) {
//                    do {} while (index < t.length && (next = t[index++]) == null);
//                }
//                //返回节点
//                return e;
//            }
//
//            public final void remove() {
//                Node<K,V> p = current;
//                //节点为null,抛出异常
//                if (p == null)
//                    throw new IllegalStateException();
//                //map结构改变,抛出异常
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                //释放当前节点内存,通知jvm可以对其进行回收
//                current = null;
//                K key = p.key;
//                //删除节点
//                removeNode(hash(key), key, null, false, false);
//                //更新map结构更改次数.
//                expectedModCount = modCount;
//            }
//        }
//
//        //key迭代器,继承hash迭代器
//        final class KeyIterator extends HashIterator
//                implements Iterator<K> {
//            public final K next() { return nextNode().key; }
//        }
//
//        //value迭代器,继承hash迭代器
//        final class ValueIterator extends HashIterator
//                implements Iterator<V> {
//            public final V next() { return nextNode().value; }
//        }
//
//        //entry迭代器,继承hash迭代器
//        final class EntryIterator extends HashIterator
//                implements Iterator<Map.Entry<K,V>> {
//            public final Map.Entry<K,V> next() { return nextNode(); }
//        }
//
//        /* ------------------------------------------------------------ */
//        // spliterators分隔迭代器
//
//        static class HashMapSpliterator<K,V> {
//            final HashMap<K,V> map;
//            Node<K,V> current;          // 当前节点
//            int index;                  // current index, modified on advance/split当前索引,在节点向前或者被分割时,值改变
//            int fence;                  // table最后一个索引值+1
//            int est;                    // 预估size大小
//            int expectedModCount;       // 用于检查map结构是否更改的标准域
//
//            HashMapSpliterator(HashMap<K,V> m, int origin,
//                               int fence, int est,
//                               int expectedModCount) {
//                this.map = m;
//                this.index = origin;
//                this.fence = fence;
//                this.est = est;
//                this.expectedModCount = expectedModCount;
//            }
//
//            //第一次使用时,初始化fence和size的值
//            final int getFence() { // initialize fence and size on first use
//                int hi;
//                if ((hi = fence) < 0) {
//                    HashMap<K,V> m = map;
//                    est = m.size;
//                    expectedModCount = m.modCount;
//                    Node<K,V>[] tab = m.table;
//                    //table=null,则fence=0;否则为table的length
//                    hi = fence = (tab == null) ? 0 : tab.length;
//                }
//                return hi;
//            }
//            //获取size大小
//            public final long estimateSize() {
//                getFence(); // force init
//                return (long) est;
//            }
//        }
//
//        //static final类
//        //key分隔迭代器,继承hash分隔迭代器
//        static final class KeySpliterator<K,V>
//                extends HashMapSpliterator<K,V>
//                implements Spliterator<K> {
//            KeySpliterator(HashMap<K,V> m, int origin, int fence, int est,
//                           int expectedModCount) {
//                super(m, origin, fence, est, expectedModCount);
//            }
//
//            //
//            public KeySpliterator<K,V> trySplit() {
//                int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//                return (lo >= mid || current != null) ? null :
//                        new KeySpliterator<>(map, lo, index = mid, est >>>= 1,
//                                expectedModCount);
//            }
//            //对每一个key执行action接口定义的操作
//            public void forEachRemaining(java.util.function.Consumer<? super K> action) {
//                int i, hi, mc;
//                if (action == null)
//                    throw new NullPointerException();
//                HashMap<K,V> m = map;
//                Node<K,V>[] tab = m.table;
//                if ((hi = fence) < 0) {
//                    mc = expectedModCount = m.modCount;
//                    hi = fence = (tab == null) ? 0 : tab.length;
//                }
//                else
//                    mc = expectedModCount;
//                if (tab != null && tab.length >= hi &&
//                        (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                    Node<K,V> p = current;
//                    current = null;
//                    do {
//                        if (p == null)
//                            p = tab[i++];
//                        else {
//                            //当前节点执行accept操作,就是你定义consumer接口中的操作.
//                            action.accept(p.key);
//                            p = p.next;
//                        }
//                    } while (p != null || i < hi);
//                    //map结构改变,抛出异常.
//                    if (m.modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            //查找table中第一个非空的bucket,如果有,则对其执行action中的操作,并返回true;否则返回false;
//            public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
//                int hi;
//                if (action == null)
//                    throw new NullPointerException();
//                Node<K,V>[] tab = map.table;
//                //hi=table.length
//                if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                    while (current != null || index < hi) {
//                        if (current == null)
//                            current = tab[index++];
//                        else {
//                            K k = current.key;
//                            current = current.next;
//                            action.accept(k);
//                            if (map.modCount != expectedModCount)
//                                throw new ConcurrentModificationException();
//                            return true;
//                        }
//                    }
//                }
//                return false;
//            }
//            //?
//            public int characteristics() {
//                return (fence < 0 || est == map.size ? Spliterator.SIZED : 0) |
//                        Spliterator.DISTINCT;
//            }
//        }
//        //value分隔迭代器,继承自hashmap分隔迭代器,各个方法和key分隔迭代器一样,不解释
//        static final class ValueSpliterator<K,V>
//                extends HashMapSpliterator<K,V>
//                implements Spliterator<V> {
//            ValueSpliterator(HashMap<K,V> m, int origin, int fence, int est,
//                             int expectedModCount) {
//                super(m, origin, fence, est, expectedModCount);
//            }
//
//            public ValueSpliterator<K,V> trySplit() {
//                int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//                return (lo >= mid || current != null) ? null :
//                        new ValueSpliterator<>(map, lo, index = mid, est >>>= 1,
//                                expectedModCount);
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super V> action) {
//                int i, hi, mc;
//                if (action == null)
//                    throw new NullPointerException();
//                HashMap<K,V> m = map;
//                Node<K,V>[] tab = m.table;
//                if ((hi = fence) < 0) {
//                    mc = expectedModCount = m.modCount;
//                    hi = fence = (tab == null) ? 0 : tab.length;
//                }
//                else
//                    mc = expectedModCount;
//                if (tab != null && tab.length >= hi &&
//                        (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                    Node<K,V> p = current;
//                    current = null;
//                    do {
//                        if (p == null)
//                            p = tab[i++];
//                        else {
//                            action.accept(p.value);
//                            p = p.next;
//                        }
//                    } while (p != null || i < hi);
//                    if (m.modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(java.util.function.Consumer<? super V> action) {
//                int hi;
//                if (action == null)
//                    throw new NullPointerException();
//                Node<K,V>[] tab = map.table;
//                if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                    while (current != null || index < hi) {
//                        if (current == null)
//                            current = tab[index++];
//                        else {
//                            V v = current.value;
//                            current = current.next;
//                            action.accept(v);
//                            if (map.modCount != expectedModCount)
//                                throw new ConcurrentModificationException();
//                            return true;
//                        }
//                    }
//                }
//                return false;
//            }
//
//            public int characteristics() {
//                return (fence < 0 || est == map.size ? Spliterator.SIZED : 0);
//            }
//        }
//        //entry分隔迭代器,功能和key分隔迭代器,不解释
//        static final class EntrySpliterator<K,V>
//                extends HashMapSpliterator<K,V>
//                implements Spliterator<Map.Entry<K,V>> {
//            EntrySpliterator(HashMap<K,V> m, int origin, int fence, int est,
//                             int expectedModCount) {
//                super(m, origin, fence, est, expectedModCount);
//            }
//
//            public EntrySpliterator<K,V> trySplit() {
//                int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//                return (lo >= mid || current != null) ? null :
//                        new EntrySpliterator<>(map, lo, index = mid, est >>>= 1,
//                                expectedModCount);
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super Entry<K,V>> action) {
//                int i, hi, mc;
//                if (action == null)
//                    throw new NullPointerException();
//                HashMap<K,V> m = map;
//                Node<K,V>[] tab = m.table;
//                if ((hi = fence) < 0) {
//                    mc = expectedModCount = m.modCount;
//                    hi = fence = (tab == null) ? 0 : tab.length;
//                }
//                else
//                    mc = expectedModCount;
//                if (tab != null && tab.length >= hi &&
//                        (i = index) >= 0 && (i < (index = hi) || current != null)) {
//                    Node<K,V> p = current;
//                    current = null;
//                    do {
//                        if (p == null)
//                            p = tab[i++];
//                        else {
//                            action.accept(p);
//                            p = p.next;
//                        }
//                    } while (p != null || i < hi);
//                    if (m.modCount != mc)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(Consumer<? super Entry<K,V>> action) {
//                int hi;
//                if (action == null)
//                    throw new NullPointerException();
//                Node<K,V>[] tab = map.table;
//                if (tab != null && tab.length >= (hi = getFence()) && index >= 0) {
//                    while (current != null || index < hi) {
//                        if (current == null)
//                            current = tab[index++];
//                        else {
//                            Node<K,V> e = current;
//                            current = current.next;
//                            action.accept(e);
//                            if (map.modCount != expectedModCount)
//                                throw new ConcurrentModificationException();
//                            return true;
//                        }
//                    }
//                }
//                return false;
//            }
//
//            public int characteristics() {
//                return (fence < 0 || est == map.size ? Spliterator.SIZED : 0) |
//                        Spliterator.DISTINCT;
//            }
//        }
//
//        /* ------------------------------------------------------------ */
//        //支持LinkedHashMap功能
//
//
//        /*
//         * The following package-protected methods are designed to be
//         * overridden by LinkedHashMap, but not by any other subclass.
//         * Nearly all other internal methods are also package-protected
//         * but are declared final, so can be used by LinkedHashMap, view
//         * classes, and HashSet.
//         * 下面的包级私方法被设计为由LinkedHashMap重写,但不能由其它任何子类重写.
//         * 几乎所有其它的内部方法都是包级私有,但声明类型都为final,因此LinkedHashMap,视图类,HashSet都可以使用.
//         */
//
//
//        //创建常规节点(即为链表节点,非红黑树节点)
//        Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
//            return new Node<>(hash, key, value, next);
//        }
//
//        //从树节点转为普通节点
//        Node<K,V> replacementNode(Node<K,V> p, Node<K,V> next) {
//            return new Node<>(p.hash, p.key, p.value, next);
//        }
//
//        //创建红黑树节点
//        TreeNode<K,V> newTreeNode(int hash, K key, V value, Node<K,V> next) {
//            return new TreeNode<>(hash, key, value, next);
//        }
//
//        //普通节点转为红黑树节点
//        TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next) {
//            return new TreeNode<>(p.hash, p.key, p.value, next);
//        }
//
//        /**
//         * 重置HashMap实例的一些域到默认状态.
//         * 这一方法只会被clone()和readObject()这两个方法调用.
//         */
//        void reinitialize() {
//            table = null;
//            entrySet = null;
//            keySet = null;
//            values = null;
//            modCount = 0;
//            threshold = 0;
//            size = 0;
//        }
//
//        // 回调以允许LinkedHashMap后置操作(访问,插入,删除)
//        void afterNodeAccess(Node<K,V> p) { }
//        void afterNodeInsertion(boolean evict) { }
//        void afterNodeRemoval(Node<K,V> p) { }
//
//        // 仅从writeObject调用，以确保兼容的排序。
//        void internalWriteEntries(java.io.ObjectOutputStream s) throws IOException {
//            Node<K,V>[] tab;
//            if (size > 0 && (tab = table) != null) {
//                for (int i = 0; i < tab.length; ++i) {
//                    for (Node<K,V> e = tab[i]; e != null; e = e.next) {
//                        s.writeObject(e.key);
//                        s.writeObject(e.value);
//                    }
//                }
//            }
//        }
//
//        /* --------------红黑树--------------- */
//
//        /**
//         * 红黑树entry。扩展LinkedHashMap.Entry（反过来扩展节点),因此可以用作普通或扩展的链表节点。
//         */
//        static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
//            TreeNode<K,V> parent;  //红黑树连接点
//            TreeNode<K,V> left; //左孩子
//            TreeNode<K,V> right; //右孩子
//            TreeNode<K,V> prev;    //删除节点时,需要断开链接,这个节点记录了删除节点的前一个节点.
//            boolean red;
//            TreeNode(int hash, K key, V val, Node<K,V> next) {
//                super(hash, key, val, next);
//            }
//
//            /**
//             * 返回当前节点的树根节点.
//             */
//            final TreeNode<K,V> root() {
//                for (TreeNode<K,V> r = this, p;;) {
//                    //如果r无双亲节点,则r为根节点
//                    if ((p = r.parent) == null)
//                        return r;
//                    r = p;
//                }
//            }
//
//            /**
//             * 确保root节点为tab中的第一个节点
//             * tab:root节点所在红黑树节点数组
//             * 说白了就3个任务:
//             * 1.root节点从原位置删除
//             * 2.root节点插入到tab[index]位置
//             * 3.root作为根节点,更改后继和前驱.
//             */
//            static <K,V> void moveRootToFront(Node<K,V>[] tab, TreeNode<K,V> root) {
//                int n;
//                //如果root节点不为null & tab不为null && tab.length>0
//                //n=tab.length
//                if (root != null && tab != null && (n = tab.length) > 0) {
//                    //获取第一个节点在tab中的索引
//                    int index = (n - 1) & root.hash;
//                    //获取tab[index]节点
//                    TreeNode<K,V> first = (TreeNode<K,V>)tab[index];
//                    //如果root节点不是first节点
//                    if (root != first) {
//                        Node<K,V> rn;
//                        //root节点赋值给tab中第一个节点
//                        tab[index] = root;
//                        //保存root节点的前驱
//                        TreeNode<K,V> rp = root.prev;
//                        //如果root后继不为null
//                        if ((rn = root.next) != null)
//                            //root后继的前驱改为root的前驱,这样就把root从原位置移除掉了
//                            ((TreeNode<K,V>)rn).prev = rp;
//                        //如果root节点前驱的后继不为null,则root前驱的后继指向root的后继.
//                        if (rp != null)
//                            rp.next = rn;
//                        //如果first不为null,则让first的前驱指向root
//                        if (first != null)
//                            first.prev = root;
//                        //root的后继指向first
//                        root.next = first;
//                        //此时root无前驱了,无设为null,完成root在tab中第一的位置.
//                        root.prev = null;
//                    }
//                    assert checkInvariants(root);
//                }
//            }
//
//            /**
//             * Finds the node starting at root p with the given hash and key.
//             * The kc argument caches comparableClassFor(key) upon first use
//             * comparing keys.
//             * 根据给定的key和hash,从红黑树的root节点开始查找.
//             * kc参数存在的意义:第一次使用时,缓存可比较的key.这样下次一样的key,则可以迅速找到该节点(当然map不能改变)
//             * @param h hash值
//             * @param k 查找key
//             * @param kc
//             * @return
//             */
//            final TreeNode<K,V> find(int h, Object k, Class<?> kc) {
//                TreeNode<K,V> p = this;
//                do {
//                    int ph, dir; K pk;
//                    TreeNode<K,V> pl = p.left, pr = p.right, q;
//                    if ((ph = p.hash) > h)
//                        p = pl;
//                    else if (ph < h)
//                        p = pr;
//                    //hash,key都和当前节点p相同,则查找返回p~
//                    else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                        return p;
//                    //左子树为null,则遍历节点转为右子树
//                    else if (pl == null)
//                        p = pr;
//                    //右子树为null,则遍历节点转为左子树
//                    else if (pr == null)
//                        p = pl;
//                    //缓存非空
//                    else if ((kc != null ||
//                            (kc = comparableClassFor(k)) != null) &&
//                            (dir = compareComparables(kc, k, pk)) != 0)
//                        p = (dir < 0) ? pl : pr;
//                    //右子树递归
//                    else if ((q = pr.find(h, k, kc)) != null)
//                        return q;
//                    else
//                        p = pl;
//                } while (p != null);
//                return null;
//            }
//
//            /**
//             * 查找root节点时,本方法被调用.
//             */
//            final TreeNode<K,V> getTreeNode(int h, Object k) {
//                return ((parent != null) ? root() : this).find(h, k, null);
//            }
//
//            /**
//             * Tie-breaking工具是为了插入元素具有相同的hash值且无法进行其它比较时,对插入顺序进行排序.
//             * 我们并不需要一个完全的排序,只需要一个一致的插入规则来维护等价重叠.
//             * 本方法比单纯的检测一个二进制位的方式更有必要.
//             */
//            static int tieBreakOrder(Object a, Object b) {
//                int d;
//                //如果a和b中至少一个为null 或者 a和b类型相同
//                if (a == null || b == null ||
//                        (d = a.getClass().getName().
//                                compareTo(b.getClass().getName())) == 0)
//                    //identityHashCode和hashCode返回相同值
//                    d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
//                            -1 : 1);
//                return d;
//            }
//
//            /**
//             * 整理连接此节点的整棵红黑树上的所有节点.
//             * 此方法用法:在插入,删除节点后,红黑树性质被破坏时,进行结构的调整.
//             * @return 返回树根节点
//             */
//            final void treeify(Node<K,V>[] tab) {
//                TreeNode<K,V> root = null;
//                for (TreeNode<K,V> x = this, next; x != null; x = next) {
//                    next = (TreeNode<K,V>)x.next;
//                    x.left = x.right = null;
//                    if (root == null) {
//                        x.parent = null;
//                        x.red = false;
//                        root = x;
//                    }
//                    else {
//                        K k = x.key;
//                        int h = x.hash;
//                        Class<?> kc = null;
//                        for (TreeNode<K,V> p = root;;) {
//                            int dir, ph;
//                            K pk = p.key;
//                            if ((ph = p.hash) > h)
//                                dir = -1;
//                            else if (ph < h)
//                                dir = 1;
//                            else if ((kc == null &&
//                                    (kc = comparableClassFor(k)) == null) ||
//                                    (dir = compareComparables(kc, k, pk)) == 0)
//                                dir = tieBreakOrder(k, pk);
//
//                            TreeNode<K,V> xp = p;
//                            if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                                x.parent = xp;
//                                if (dir <= 0)
//                                    xp.left = x;
//                                else
//                                    xp.right = x;
//                                root = balanceInsertion(root, x);
//                                break;
//                            }
//                        }
//                    }
//                }
//                moveRootToFront(tab, root);
//            }
//
//            /**
//             * 返回非TreeNode节点的列表，替换那些从此节点链接的节点,此节点作为返回链表的头节点。
//             */
//            final Node<K,V> untreeify(HashMap<K,V> map) {
//                Node<K,V> hd = null, tl = null;
//                for (Node<K,V> q = this; q != null; q = q.next) {
//                    Node<K,V> p = map.replacementNode(q, null);
//                    if (tl == null)
//                        hd = p;
//                    else
//                        tl.next = p;
//                    tl = p;
//                }
//                return hd;
//            }
//
//            /**
//             * Tree version of putVal.
//             */
//            final TreeNode<K,V> putTreeVal(HashMap<K,V> map, Node<K,V>[] tab,
//                                           int h, K k, V v) {
//                Class<?> kc = null;
//                boolean searched = false;
//                TreeNode<K,V> root = (parent != null) ? root() : this;
//                for (TreeNode<K,V> p = root;;) {
//                    int dir, ph; K pk;
//                    if ((ph = p.hash) > h)
//                        dir = -1;
//                    else if (ph < h)
//                        dir = 1;
//                    else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                        return p;
//                    else if ((kc == null &&
//                            (kc = comparableClassFor(k)) == null) ||
//                            (dir = compareComparables(kc, k, pk)) == 0) {
//                        if (!searched) {
//                            TreeNode<K,V> q, ch;
//                            searched = true;
//                            if (((ch = p.left) != null &&
//                                    (q = ch.find(h, k, kc)) != null) ||
//                                    ((ch = p.right) != null &&
//                                            (q = ch.find(h, k, kc)) != null))
//                                return q;
//                        }
//                        //查找插入规则
//                        dir = tieBreakOrder(k, pk);
//                    }
//
//                    TreeNode<K,V> xp = p;
//                    if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                        Node<K,V> xpn = xp.next;
//                        //生成新节点
//                        TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);
//                        if (dir <= 0)
//                            xp.left = x;
//                        else
//                            xp.right = x;
//                        xp.next = x;
//                        x.parent = x.prev = xp;
//                        if (xpn != null)
//                            ((TreeNode<K,V>)xpn).prev = x;
//                        //插入节点后,将树根调整到bucket中
//                        moveRootToFront(tab, balanceInsertion(root, x));
//                        return null;
//                    }
//                }
//            }
//
//            /**
//             * 移除红黑树中的参数节点node,要求在此方法调用前,这个节点必须存在.
//             * 这比典型的红黑删除代码更加混乱，因为我们不能将内部节点的内容与被可访问的,遍历期间独立的“下一个”指针固定的叶子后继交换.
//             * 相反,我们交换了树的连接(因为左旋或者右旋完成的就是改变子树间的连接)
//             * 删除节点后,如果当前红黑树中节点个数太少,到达6个后,就会转为普通链表存储.
//             * (红黑树到链表的转换节点个数标准为:2~6,这具体取决于红黑树结构)
//             */
//            final void removeTreeNode(HashMap<K,V> map, Node<K,V>[] tab,
//                                      boolean movable) {
//                int n;
//                if (tab == null || (n = tab.length) == 0)
//                    return;
//                int index = (n - 1) & hash;
//                TreeNode<K,V> first = (TreeNode<K,V>)tab[index], root = first, rl;
//                TreeNode<K,V> succ = (TreeNode<K,V>)next, pred = prev;
//                if (pred == null)
//                    tab[index] = first = succ;
//                else
//                    pred.next = succ;
//                if (succ != null)
//                    succ.prev = pred;
//                if (first == null)
//                    return;
//                if (root.parent != null)
//                    root = root.root();
//                if (root == null || root.right == null ||
//                        (rl = root.left) == null || rl.left == null) {
//                    tab[index] = first.untreeify(map);  // too small
//                    return;
//                }
//                TreeNode<K,V> p = this, pl = left, pr = right, replacement;
//                if (pl != null && pr != null) {
//                    TreeNode<K,V> s = pr, sl;
//                    while ((sl = s.left) != null) // find successor
//                        s = sl;
//                    boolean c = s.red; s.red = p.red; p.red = c; // swap colors
//                    TreeNode<K,V> sr = s.right;
//                    TreeNode<K,V> pp = p.parent;
//                    if (s == pr) { // p was s's direct parent
//                        p.parent = s;
//                        s.right = p;
//                    }
//                    else {
//                        TreeNode<K,V> sp = s.parent;
//                        if ((p.parent = sp) != null) {
//                            if (s == sp.left)
//                                sp.left = p;
//                            else
//                                sp.right = p;
//                        }
//                        if ((s.right = pr) != null)
//                            pr.parent = s;
//                    }
//                    p.left = null;
//                    if ((p.right = sr) != null)
//                        sr.parent = p;
//                    if ((s.left = pl) != null)
//                        pl.parent = s;
//                    if ((s.parent = pp) == null)
//                        root = s;
//                    else if (p == pp.left)
//                        pp.left = s;
//                    else
//                        pp.right = s;
//                    if (sr != null)
//                        replacement = sr;
//                    else
//                        replacement = p;
//                }
//                else if (pl != null)
//                    replacement = pl;
//                else if (pr != null)
//                    replacement = pr;
//                else
//                    replacement = p;
//                if (replacement != p) {
//                    TreeNode<K,V> pp = replacement.parent = p.parent;
//                    if (pp == null)
//                        root = replacement;
//                    else if (p == pp.left)
//                        pp.left = replacement;
//                    else
//                        pp.right = replacement;
//                    p.left = p.right = p.parent = null;
//                }
//
//                TreeNode<K,V> r = p.red ? root : balanceDeletion(root, replacement);
//
//                if (replacement == p) {  // detach
//                    TreeNode<K,V> pp = p.parent;
//                    p.parent = null;
//                    if (pp != null) {
//                        if (p == pp.left)
//                            pp.left = null;
//                        else if (p == pp.right)
//                            pp.right = null;
//                    }
//                }
//                if (movable)
//                    moveRootToFront(tab, r);
//            }
//
//            /**
//             * 将红黑树中的节点分隔为较低和较高的树形结构,如果树中节点个数为6,则将转为链表.
//             * 这一方法只在resize()时被调用.
//             * 可以查看上面关于分隔位和索引的讨论.
//             * @param index 用于分隔的table索引
//             * @param bit the bit of hash to split on
//             */
//            final void split(HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
//                TreeNode<K,V> b = this;
//                // Relink into lo and hi lists, preserving order
//                TreeNode<K,V> loHead = null, loTail = null;
//                TreeNode<K,V> hiHead = null, hiTail = null;
//                int lc = 0, hc = 0;
//                for (TreeNode<K,V> e = b, next; e != null; e = next) {
//                    next = (TreeNode<K,V>)e.next;
//                    e.next = null;
//                    if ((e.hash & bit) == 0) {
//                        if ((e.prev = loTail) == null)
//                            loHead = e;
//                        else
//                            loTail.next = e;
//                        loTail = e;
//                        ++lc;
//                    }
//                    else {
//                        if ((e.prev = hiTail) == null)
//                            hiHead = e;
//                        else
//                            hiTail.next = e;
//                        hiTail = e;
//                        ++hc;
//                    }
//                }
//
//                if (loHead != null) {
//                    if (lc <= UNTREEIFY_THRESHOLD)
//                        tab[index] = loHead.untreeify(map);
//                    else {
//                        tab[index] = loHead;
//                        if (hiHead != null) // (else is already treeified)
//                            loHead.treeify(tab);
//                    }
//                }
//                if (hiHead != null) {
//                    if (hc <= UNTREEIFY_THRESHOLD)
//                        tab[index + bit] = hiHead.untreeify(map);
//                    else {
//                        tab[index + bit] = hiHead;
//                        if (loHead != null)
//                            hiHead.treeify(tab);
//                    }
//                }
//            }
//
//            /* --------------------红黑树方法--------------------------------- */
//            // Red-black tree methods, all adapted from CLR
//            //左旋方法
//            static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root, TreeNode<K,V> p) {
//                TreeNode<K,V> r, pp, rl;
//                //如果p不为null & p有孩子不为null
//                //r=p.right
//                //不平衡原因:在p的右孩子上面插入节点
//                if (p != null && (r = p.right) != null) {
//                    //rl指向从r上面拿下的左子树
//                    if ((rl = p.right = r.left) != null)
//                        //rl双亲节点改为p
//                        rl.parent = p;
//                    //p为根节点时,r变为根节点,且更改颜色为黑色.
//                    if ((pp = r.parent = p.parent) == null)
//                        (root = r).red = false;
//                    //p为内部节点,且为pp的左孩子
//                    else if (pp.left == p)
//                        pp.left = r;
//                    //p为内部节,且为pp的右孩子
//                    else
//                        pp.right = r;
//                    //r的左孩子指向p
//                    r.left = p;
//                    //p的双亲节点指向r
//                    p.parent = r;
//                }
//                //返回根节点
//                return root;
//            }
//
//            //右旋方法
//            static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root,
//                                                   TreeNode<K,V> p) {
//                TreeNode<K,V> l, pp, lr;
//                //如果p不为null且p的左孩子不为null
//                //红黑树不平衡原因:在p的左孩子上插入一个node
//                if (p != null && (l = p.left) != null) {
//                    //l的右子树变为p的右子树
//                    //lr指向p的左子树
//                    if ((lr = p.left = l.right) != null)
//                        //lr的双亲节点改为p
//                        lr.parent = p;
//                    //如果p为根节点
//                    if ((pp = l.parent = p.parent) == null)
//                        //l节点颜色改为黑色(因为红黑树根节点必须为黑色)
//                        (root = l).red = false;
//                    //如果p为内部节点,且p为右节点
//                    else if (pp.right == p)
//                        pp.right = l;
//                    //p为左节点
//                    else
//                        pp.left = l;
//                    //p为l的右子树
//                    l.right = p;
//                    //p的双亲节点为l
//                    p.parent = l;
//                }
//                //返回根节点
//                return root;
//            }
//
//            //插入节点后,调整平衡(调用左旋+右旋方法+颜色调整)
//            static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
//                                                        TreeNode<K,V> x) {
//                x.red = true;
//                for (TreeNode<K,V> xp, xpp, xppl, xppr;;) {
//                    if ((xp = x.parent) == null) {
//                        x.red = false;
//                        return x;
//                    }
//                    else if (!xp.red || (xpp = xp.parent) == null)
//                        return root;
//                    if (xp == (xppl = xpp.left)) {
//                        if ((xppr = xpp.right) != null && xppr.red) {
//                            xppr.red = false;
//                            xp.red = false;
//                            xpp.red = true;
//                            x = xpp;
//                        }
//                        else {
//                            if (x == xp.right) {
//                                root = rotateLeft(root, x = xp);
//                                xpp = (xp = x.parent) == null ? null : xp.parent;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                if (xpp != null) {
//                                    xpp.red = true;
//                                    root = rotateRight(root, xpp);
//                                }
//                            }
//                        }
//                    }
//                    else {
//                        if (xppl != null && xppl.red) {
//                            xppl.red = false;
//                            xp.red = false;
//                            xpp.red = true;
//                            x = xpp;
//                        }
//                        else {
//                            if (x == xp.left) {
//                                root = rotateRight(root, x = xp);
//                                xpp = (xp = x.parent) == null ? null : xp.parent;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                if (xpp != null) {
//                                    xpp.red = true;
//                                    root = rotateLeft(root, xpp);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            //删除节点后,调整红黑树(左旋方法+右旋方法+颜色调整)
//            static <K,V> TreeNode<K,V> balanceDeletion(TreeNode<K,V> root,
//                                                       TreeNode<K,V> x) {
//                for (TreeNode<K,V> xp, xpl, xpr;;)  {
//                    if (x == null || x == root)
//                        return root;
//                    else if ((xp = x.parent) == null) {
//                        x.red = false;
//                        return x;
//                    }
//                    else if (x.red) {
//                        x.red = false;
//                        return root;
//                    }
//                    else if ((xpl = xp.left) == x) {
//                        if ((xpr = xp.right) != null && xpr.red) {
//                            xpr.red = false;
//                            xp.red = true;
//                            root = rotateLeft(root, xp);
//                            xpr = (xp = x.parent) == null ? null : xp.right;
//                        }
//                        if (xpr == null)
//                            x = xp;
//                        else {
//                            TreeNode<K,V> sl = xpr.left, sr = xpr.right;
//                            if ((sr == null || !sr.red) &&
//                                    (sl == null || !sl.red)) {
//                                xpr.red = true;
//                                x = xp;
//                            }
//                            else {
//                                if (sr == null || !sr.red) {
//                                    if (sl != null)
//                                        sl.red = false;
//                                    xpr.red = true;
//                                    root = rotateRight(root, xpr);
//                                    xpr = (xp = x.parent) == null ?
//                                            null : xp.right;
//                                }
//                                if (xpr != null) {
//                                    xpr.red = (xp == null) ? false : xp.red;
//                                    if ((sr = xpr.right) != null)
//                                        sr.red = false;
//                                }
//                                if (xp != null) {
//                                    xp.red = false;
//                                    root = rotateLeft(root, xp);
//                                }
//                                x = root;
//                            }
//                        }
//                    }
//                    else { // symmetric
//                        if (xpl != null && xpl.red) {
//                            xpl.red = false;
//                            xp.red = true;
//                            root = rotateRight(root, xp);
//                            xpl = (xp = x.parent) == null ? null : xp.left;
//                        }
//                        if (xpl == null)
//                            x = xp;
//                        else {
//                            TreeNode<K,V> sl = xpl.left, sr = xpl.right;
//                            if ((sl == null || !sl.red) &&
//                                    (sr == null || !sr.red)) {
//                                xpl.red = true;
//                                x = xp;
//                            }
//                            else {
//                                if (sl == null || !sl.red) {
//                                    if (sr != null)
//                                        sr.red = false;
//                                    xpl.red = true;
//                                    root = rotateLeft(root, xpl);
//                                    xpl = (xp = x.parent) == null ?
//                                            null : xp.left;
//                                }
//                                if (xpl != null) {
//                                    xpl.red = (xp == null) ? false : xp.red;
//                                    if ((sl = xpl.left) != null)
//                                        sl.red = false;
//                                }
//                                if (xp != null) {
//                                    xp.red = false;
//                                    root = rotateRight(root, xp);
//                                }
//                                x = root;
//                            }
//                        }
//                    }
//                }
//            }
//
//            /**
//             * 检查树是否符合红黑树定义
//             */
//            static <K,V> boolean checkInvariants(TreeNode<K,V> t) {
//                TreeNode<K,V> tp = t.parent, tl = t.left, tr = t.right,
//                        tb = t.prev, tn = (TreeNode<K,V>)t.next;
//                if (tb != null && tb.next != t)
//                    return false;
//                if (tn != null && tn.prev != t)
//                    return false;
//                if (tp != null && t != tp.left && t != tp.right)
//                    return false;
//                if (tl != null && (tl.parent != t || tl.hash > t.hash))
//                    return false;
//                if (tr != null && (tr.parent != t || tr.hash < t.hash))
//                    return false;
//                if (t.red && tl != null && tl.red && tr != null && tr.red)
//                    return false;
//                if (tl != null && !checkInvariants(tl))
//                    return false;
//                if (tr != null && !checkInvariants(tr))
//                    return false;
//                return true;
//            }
//        }
//
//    }
