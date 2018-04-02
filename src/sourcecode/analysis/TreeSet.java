//    package sourcecode.analysis;
//
//    import java.lang.*;
//    import java.util.*;
//    import java.util.AbstractSet;
//    import java.util.Set;
//
//    /**
//     * @Author: cxh
//     * @CreateTime: 18/3/21 21:29
//     * @ProjectName: JavaBaseTest
//     */
//
//
//    /**
//     * TreeSet是基于TreeMap的NavigableSet实现
//     * 实例化时,如果不提供比较器,则元素存储顺序为:自然排序;
//     * 如果提供比较器,则按照比较器的规则排序.
//     *
//     * TreeSet在add(),remove(),contains()这3个方法中,时间复杂度为:log(n).
//     *
//     * 请注意，Set维护的顺序必须与equals等同(无论是否提供比较器),只要Set正确实现了Set接口.
//     * 这是因为Set接口就equals做过定义,但是TreeSet实例使用它自己的comppareTo()方法对元素排序,
//     * 因此通过这个方法被认为equals的两个元素是从Set对equals的定义出发的.
//     * 即使排序与equals不一致，Set的行为也是明确定义的;它只是没有遵守Set接口的总体规则。
//     *
//     * 注意,这一实现并不是线程同步的.
//     * 如果多个线程并发访问一个treeset,并且至少有一个线程更改了treeset的结构,则必须采取
//     * 额外的同步措施.这通常是通过在一些自然封装集合的对象上进行同步来完成的.
//     * 如果没有这样的对象存在,则set应该使用Collections#synchronizedSortedSet 或者
//     * Collections.synchronizedSortedSet来进行包装.而这一包装操作最好在实例被创建的
//     * 时候就完成,以防止一些非同步的行为.格式如下:
//     * SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));
//     *
//     * 由TreeSet得到的迭代器支持fail-fast功能.
//     *
//     * 注意:迭代器的fail-fast功能是不能保证的,一般来说,在任何非同步的并发修改中,都不能
//     * 给出明确保证.迭代器只是尽可能的抛出异常.
//     *
//     * TreeSet类是java集合框架中的一员.
//     *
//     * @see     Collection
//     * @see     Set
//     * @see     HashSet
//     * @see     java.lang.Comparable
//     * @see     Comparator
//     * @see     TreeMap
//     * @since   1.2
//     *
//     * 支持排序,浅拷贝,序列化.
//     */
//
//    public class TreeSet<E> extends AbstractSet<E>
//            implements NavigableSet<E>, Cloneable, java.io.Serializable
//    {
//        /**
//         * 底层map
//         * 维护一个NavigableMap型变量，NavigableMap是TreeMap的接口
//         * 序列化时,值被置为null
//         */
//        private transient NavigableMap<E,Object> m;
//
//        // PRESENT定义为静态常量，用来填充map的value
//        private static final Object PRESENT = new Object();
//
//        //包级私有构造器:根据指定参数m创建TreeSet的底层map
//        TreeSet(NavigableMap<E,Object> m) {
//            this.m = m;
//        }
//
//        /**
//         * 构造一个新的,空的treeset,元素按自然排序.
//         * 插入set中的所有元素必须实现Comparable接口.
//         * 进一步讲,在set中的任何两个元素e1,e2在进行e1.compareTo(e2)相互比较时,都不能
//         * 抛出类型安全异常ClassCastException.
//         * 如果用户想要插入一个和规定冲突的元素(比如向set<String>集合中插入Integer对象),
//         * 则add方法会抛出异常ClassCastException.
//         */
//        //公有构造器,调用上一个构造器方法,这里可以看出底层map为treemap.
//        public TreeSet() {
//            this(new TreeMap<E,Object>());
//        }
//
//        /**
//         * 构造一个新的,空的treeset,元素存储顺序和传入比较器一致.
//         * 所有被插入这个set的元素都应该可以使用这个比较器,
//         * 即在进行comparator.compare(e1,e2)的比较时,不能抛出类型安全异常
//         * ClassCastException.如果用户尝试添加一个和此约束冲突的元素,则add()方法的
//         * 调用者会抛出类型安全异常.
//         * 如果传入比较器为null,则使用自然排序.
//         */
//        public TreeSet(Comparator<? super E> comparator) {
//            this(new TreeMap<>(comparator));
//        }
//
//        /**
//         * 构造一个新的但包含指定集合元素的treeset,元素顺序为自然排序.
//         * 插入set的所有元素必须实现Comparable接口.
//         */
//        public TreeSet(Collection<? extends E> c) {
//            this();
//            addAll(c);
//        }
//
//        //创建一个新的,元素和给定参数的一致,并且排序和给定的有序set一致.
//        public TreeSet(SortedSet<E> s) {
//            this(s.comparator());
//            addAll(s);
//        }
//
//        //迭代器,此处便可以发现,虽然底层用的是map,但是只是用了map的key对set的元素进行存储.
//        //因为这里返回的是keyset的迭代器.
//        public Iterator<E> iterator() {
//            return m.navigableKeySet().iterator();
//        }
//
//        //返回一个元素降序的迭代器.
//        public Iterator<E> descendingIterator() {
//            return m.descendingKeySet().iterator();
//        }
//
//        public NavigableSet<E> descendingSet() {
//            return new TreeSet<>(m.descendingMap());
//        }
//
//        //返回底层treemap的size
//        public int size() {
//            return m.size();
//        }
//
//        //根据底层treemap,判定是否为空
//        public boolean isEmpty() {
//            return m.isEmpty();
//        }
//
//        //根据底层treemap,判定是否包含o对象.
//        public boolean contains(Object o) {
//            return m.containsKey(o);
//        }
//
//        /**
//         * 调用底层的treemap,进行插入操作.
//         * m.put(e,PRESENT),表示任何插入操作,key对应的value都是静态常量PRESETN,
//         * 也就是底层map利用key对treeset的元素进行保存.
//         */
//        public boolean add(E e) {
//            return m.put(e, PRESENT)==null;
//        }
//
//
//        //调用底层treemap的remove方法,删除元素.
//        public boolean remove(Object o) {
//            return m.remove(o)==PRESENT;
//        }
//
//        //调用底层treemap的方法清空set中的元素
//        public void clear() {
//            m.clear();
//        }
//
//        //方法时间复杂度:线性
//        public  boolean addAll(Collection<? extends E> c) {
//            /**如果
//             * 1.底层Map没有存储元素
//             * 2.参数中包含元素
//             * 3.参数类型为SortedSet
//             * 4.底层map类型为TreeMap
//             */
//            if (m.size()==0 && c.size() > 0 &&
//                    c instanceof SortedSet &&
//                    m instanceof TreeMap) {
//                //类型转化
//                SortedSet<? extends E> set = (SortedSet<? extends E>) c;
//                TreeMap<E,Object> map = (TreeMap<E, Object>) m;
//                //获取参数集合c的比较器.
//                Comparator<?> cc = set.comparator();
//                //获取底层treemap的比较器.
//                Comparator<? super E> mc = map.comparator();
//                //如果两个比较器等价,则进行插入操作;否则不插入.
//                if (cc==mc || (cc != null && cc.equals(mc))) {
//                    map.addAllForTreeSet(set, PRESENT);
//                    return true;
//                }
//            }
//            //调用AbstractCollection方法
//            return super.addAll(c);
//        }
//
//        //根据key值范围,截取set.调用的是NavigableSet的方法
//        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
//                                      E toElement,   boolean toInclusive) {
//            return new TreeSet<>(m.subMap(fromElement, fromInclusive,
//                    toElement,   toInclusive));
//        }
//
//        //返回视图中所有元素的值:<=toElement
//        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
//            return new TreeSet<>(m.headMap(toElement, inclusive));
//        }
//
//       //返回视图中所有元素的值:>=toElement
//        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
//            return new TreeSet<>(m.tailMap(fromElement, inclusive));
//        }
//
//        //参数为true,则包含等于;否则不包含等于.
//        //因此本方中,返回key的范围为:[fromElement,toElement)
//        public SortedSet<E> subSet(E fromElement, E toElement) {
//            return subSet(fromElement, true, toElement, false);
//        }
//
//        //返回key的范围:[,toElement)
//        public SortedSet<E> headSet(E toElement) {
//            return headSet(toElement, false);
//        }
//
//        /**
//         * @throws ClassCastException {@inheritDoc}
//         * @throws NullPointerException if {@code fromElement} is null
//         *         and this set uses natural ordering, or its comparator does
//         *         not permit null elements
//         * @throws IllegalArgumentException {@inheritDoc}
//         */
//        //返回key范围:[,fromElement]
//        public SortedSet<E> tailSet(E fromElement) {
//            return tailSet(fromElement, true);
//        }
//
//        //获取底层treemap的比较器.
//        public Comparator<? super E> comparator() {
//            return m.comparator();
//        }
//
//        //获取第一个key
//        public E first() {
//            return m.firstKey();
//        }
//
//        //获取最后一个key
//        public E last() {
//            return m.lastKey();
//        }
//
//
//        /*--------NavigableSet的API方法---------*/
//        //返回比e小且和e的差最小的key
//        public E lower(E e) {
//            return m.lowerKey(e);
//        }
//
//        //返回<=e的最大key
//        public E floor(E e) {
//            return m.floorKey(e);
//        }
//
//       //返回>=e的最小key
//        public E ceiling(E e) {
//            return m.ceilingKey(e);
//        }
//
//        //返回>e的最小值
//        public E higher(E e) {
//            return m.higherKey(e);
//        }
//
//        //返回最小key;如果底层map为空,则返回null
//        public E pollFirst() {
//            Map.Entry<E,?> e = m.pollFirstEntry();
//            return (e == null) ? null : e.getKey();
//        }
//
//       //返回最大key;如果底层map为空,则返回null
//        public E pollLast() {
//            Map.Entry<E,?> e = m.pollLastEntry();
//            return (e == null) ? null : e.getKey();
//        }
//
//        //返回treeset的浅拷贝(元素本身不会被拷贝)
//        @SuppressWarnings("unchecked")
//        public Object clone() {
//            TreeSet<E> clone;
//            try {
//                clone = (TreeSet<E>) super.clone();
//            } catch (CloneNotSupportedException e) {
//                throw new InternalError(e);
//            }
//
//            //
//            clone.m = new TreeMap<>(m);
//            return clone;
//        }
//
//        //序列化时,将treeset实例的状态写入到流中.
//        private void writeObject(java.io.ObjectOutputStream s)
//                throws java.io.IOException {
//
//            //写入隐藏信息
//            s.defaultWriteObject();
//
//            //写入比较器
//            s.writeObject(m.comparator());
//
//            //写入size
//            s.writeInt(m.size());
//
//            //按序写入所有key
//            for (E e : m.keySet())
//                s.writeObject(e);
//        }
//
//
//        //从读入流重构TreeSet
//        private void readObject(java.io.ObjectInputStream s)
//                throws java.io.IOException, ClassNotFoundException {
//
//            //读入隐藏信息
//            s.defaultReadObject();
//
//            //读入比较器
//            @SuppressWarnings("unchecked")
//            Comparator<? super E> c = (Comparator<? super E>) s.readObject();
//
//            //创建底层TreeMap
//            TreeMap<E,Object> tm = new TreeMap<>(c);
//            m = tm;
//
//            //读入size
//            int size = s.readInt();
//            //读入key,生成TreeMap
//            tm.readTreeSet(size, s, PRESENT);
//        }
//
//        /**
//         * 创建key的分割器
//         * @since 1.8
//         */
//        public Spliterator<E> spliterator() {
//            return TreeMap.keySpliteratorFor(m);
//        }
//
//        //序列化uid
//        private static final long serialVersionUID = -2479143000061671589L;
//    }
//
