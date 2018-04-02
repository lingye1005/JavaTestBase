//    package sourcecode.analysis;
//
//    /**
//     * @Author: cxh
//     * @CreateTime: 18/3/22 17:46
//     * @ProjectName: JavaBaseTest
//     */
//
//    import java.io.Serializable;
//    import java.lang.*;
//    import java.util.*;
//    import java.util.AbstractSet;
//    import java.util.Set;
//    import java.util.function.*;
//    import java.util.function.BiFunction;
//    import java.util.function.Consumer;
//
//    /**
//     *
//     * TreeMap是基于NavigableMap的红黑树的实现.
//     * 其排序标准为:对key的自然排序.(如果实例化时传入比较器,则对key按比较器排序)
//     *
//     * 这一实现在以下方法中提供了log(n)的时间复杂度:
//     * containsKey(),get(), put() , remove().
//     *
//     * 注意:由treemap确定的排序,和其它任何有序map一样,无论是否在实例化时提供比较器,只要有序map实现了
//     * map接口,则必须和equals保持一致.这是因为map接口就equals操作做出了定义,但是有序map使用了它自己的
//     * compareTo方法对所有的key做了排序,因此从有序map的角度,两个key是否equal取决于compareTo方法.
//     * 尽管有序map的排序和equals不一致,,但是其如何排序已经给出明确定义.它只是违反了map接口的通用规定.
//     *
//     * 注意:TreeMap并不是线程同步的.
//     * 如果多个线程并发访问TreeMap,且至少有一个线程修改了map的结构,则必须对TreeMap额外进行同步.
//     * 同步可以这样写:
//     * SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));
//     *
//     * 支持浅拷贝,序列化
//     * 实现了NavigableMap接口
//     *
//     * @see Map
//     * @see HashMap
//     * @see Hashtable
//     * @see java.lang.Comparable
//     * @see Comparator
//     * @see Collection
//     * @since 1.2
//     */
//
//
//public class TreeMap<K,V>
//        extends AbstractMap<K,V>
//        implements NavigableMap<K,V>, Cloneable, java.io.Serializable
//{
//        //对key排序的比较器
//        private final Comparator<? super K> comparator;
//
//        //
//        private transient Entry<K,V> root;
//
//        //map的entry的个数
//        private transient int size = 0;
//
//        /**
//         * The number of structural modifications to the tree.
//         */
//        //treemap结构更改次数
//        private transient int modCount = 0;
//        //构造函数,默认自然排序
//        public TreeMap() {
//            comparator = null;
//        }
//
//        //构造函数,排序由传入比较器决定
//        public TreeMap(Comparator<? super K> comparator) {
//            this.comparator = comparator;
//        }
//
//        /**
//         * 新建一个TreeMap,将参数map中的元素添加到新TreeMap中
//         * key遵守自然排序
//         */
//
//        public TreeMap(Map<? extends K, ? extends V> m) {
//            comparator = null;
//            putAll(m);
//        }
//
//        /**
//         * 构造一个新的TreeMap,并将参数map中元素添加进去
//         * key顺序:和参数一致
//         */
//
//        public TreeMap(SortedMap<K, ? extends V> m) {
//            comparator = m.comparator();
//            try {
//                buildFromSorted(m.size(), m.entrySet().iterator(), null, null);
//            } catch (java.io.IOException cannotHappen) {
//            } catch (ClassNotFoundException cannotHappen) {
//            }
//        }
//
//
//    /*---------查询操作--------*/
//
//        public int size() {
//            return size;
//        }
//
//        public boolean containsKey(Object key) {
//            return getEntry(key) != null;
//        }
//
//        public boolean containsValue(Object value) {
//            for (Entry<K,V> e = getFirstEntry(); e != null; e = successor(e))
//                if (valEquals(value, e.value))
//                    return true;
//            return false;
//        }
//
//        public V get(Object key) {
//            Entry<K,V> p = getEntry(key);
//            return (p==null ? null : p.value);
//        }
//
//        public Comparator<? super K> comparator() {
//            return comparator;
//        }
//
//        //返回最小key
//        public K firstKey() {
//            return key(getFirstEntry());
//        }
//
//        //返回最大key
//        public K lastKey() {
//            return key(getLastEntry());
//        }
//
//        public void putAll(Map<? extends K, ? extends V> map) {
//            int mapSize = map.size();
//            //如果TreeMap没有元素,且参数map为有序map
//            if (size==0 && mapSize!=0 && map instanceof SortedMap) {
//                //获取比较器
//                Comparator<?> c = ((SortedMap<?,?>)map).comparator();
//                //如果TreeMap和参数map比较器等价
//                if (c == comparator || (c != null && c.equals(comparator))) {
//                    ++modCount;
//                    try {
//                        buildFromSorted(mapSize, map.entrySet().iterator(),
//                                null, null);
//                    } catch (java.io.IOException cannotHappen) {
//                    } catch (ClassNotFoundException cannotHappen) {
//                    }
//                    return;
//                }
//            }
//            //调用AbstractMap的方法,进行复制
//            super.putAll(map);
//        }
//
//        //注意:这是一个final类
//        final Entry<K,V> getEntry(Object key) {
//            //为了提高性能，对有比较器的TreeMap单独处理
//            if (comparator != null)
//                return getEntryUsingComparator(key);
//            if (key == null)
//                throw new NullPointerException();
//            //没有比较器时
//            @SuppressWarnings("unchecked")
//            java.lang.Comparable<? super K> k = (java.lang.Comparable<? super K>) key;
//            //获取跟节点
//            Entry<K,V> p = root;
//            //在红黑树中查询
//            while (p != null) {
//                int cmp = k.compareTo(p.key);
//                if (cmp < 0)
//                    p = p.left;
//                else if (cmp > 0)
//                    p = p.right;
//                else
//                    return p;
//            }
//            return null;
//        }
//
//        /**
//         * 使用比较器的getEntry()方法的版本.
//         * 为了提高性能，从getEntry中分离出来.(在大多数方法中,这样做并不值得,尤其是那些对比较器
//         * 不是很依赖的方法中.但是,本方法中这样做很值得)
//         */
//        final Entry<K,V> getEntryUsingComparator(Object key) {
//            @SuppressWarnings("unchecked")
//            K k = (K) key;
//            Comparator<? super K> cpr = comparator;
//            if (cpr != null) {
//                Entry<K,V> p = root;
//                while (p != null) {
//                    int cmp = cpr.compare(k, p.key);
//                    if (cmp < 0)
//                        p = p.left;
//                    else if (cmp > 0)
//                        p = p.right;
//                    else
//                        return p;
//                }
//            }
//            return null;
//        }
//
//        //返回指定>=key对应的entry;优先返回等于,其次返回稍大于的entry
//        final Entry<K,V> getCeilingEntry(K key) {
//            Entry<K,V> p = root;
//            while (p != null) {
//                int cmp = compare(key, p.key);
//                //key<根节点的值,向左下查找
//                if (cmp < 0) {
//                    if (p.left != null)
//                        p = p.left;
//                    else
//                        return p;
//                }
//                //key>根节点的值,向右下查找
//                else if (cmp > 0) {
//                    if (p.right != null) {
//                        p = p.right;
//                    }
//                    //如果p无右孩子
//                    else {
//                        //获取p的双亲节点
//                        Entry<K,V> parent = p.parent;
//                        //获取p节点
//                        Entry<K,V> ch = p;
//                        //如果双亲节点不为空 && p节点为双亲节点的右孩子
//                        while (parent != null && ch == parent.right) {
//                            ch = parent;
//                            parent = parent.parent;
//                        }
//                        /**
//                         *最终ch指向根节点,parent=null.
//                         */
//                        //返回null
//                        return parent;
//                    }
//                } else
//                    return p;
//            }
//            return null;
//        }
//
//        /**
//         * 获取指定key的entry;
//         * 如果不存在,则返回比指定key小的最大key
//         */
//        //返回<=key的entry.优先返回=;其次返回稍小于
//        final Entry<K,V> getFloorEntry(K key) {
//            Entry<K,V> p = root;
//            while (p != null) {
//                int cmp = compare(key, p.key);
//                //如果key>根节点,则右下查找
//                if (cmp > 0) {
//                    if (p.right != null)
//                        p = p.right;
//                    else
//                        return p;
//                }
//                //如果key<跟节点,则左下查找
//                else if (cmp < 0) {
//                    if (p.left != null) {
//                        p = p.left;
//                    } else {
//                        Entry<K,V> parent = p.parent;
//                        Entry<K,V> ch = p;
//                        //最后ch指向跟节点,parent=null
//                        while (parent != null && ch == parent.left) {
//                            ch = parent;
//                            parent = parent.parent;
//                        }
//                        //返回null
//                        return parent;
//                    }
//                } else
//                    return p;
//
//            }
//            return null;
//        }
//
//        /**
//         * 返回比指定key大的最小key的entry.
//         * 如果不存在,则返null
//         */
//        final Entry<K,V> getHigherEntry(K key) {
//            Entry<K,V> p = root;
//            while (p != null) {
//                int cmp = compare(key, p.key);
//                //如果key<根节点,向左下查找
//                if (cmp < 0) {
//                    if (p.left != null)
//                        p = p.left;
//                    else
//                        return p;
//                }
//                //如果key>根节点,向右下查找
//                else {
//                    if (p.right != null) {
//                        p = p.right;
//                    }
//                    //如果右孩子为null
//                    else {
//                        Entry<K,V> parent = p.parent;
//                        Entry<K,V> ch = p;
//                        while (parent != null && ch == parent.right) {
//                            ch = parent;
//                            parent = parent.parent;
//                        }
//                        //返回null
//                        return parent;
//                    }
//                }
//            }
//            return null;
//        }
//
//        /**
//         * 返回比指定key小的最大key的entry.
//         * 如果不存在,则返回null
//         * 返回对象不可更改
//         */
//        final Entry<K,V> getLowerEntry(K key) {
//            Entry<K,V> p = root;
//            while (p != null) {
//                int cmp = compare(key, p.key);
//                //如果key>根节点,右下查询
//                if (cmp > 0) {
//                    if (p.right != null)
//                        p = p.right;
//                    else
//                        return p;
//                }
//                //如果key<=根节点,左下查询
//                else {
//                    if (p.left != null) {
//                        p = p.left;
//                    } else {
//                        Entry<K,V> parent = p.parent;
//                        Entry<K,V> ch = p;
//                        while (parent != null && ch == parent.left) {
//                            ch = parent;
//                            parent = parent.parent;
//                        }
//                        //返回null
//                        return parent;
//                    }
//                }
//            }
//            return null;
//        }
//
//        /**
//         * 红黑树的插入
//         * 分TreeMap有比较器还是无比较器讨论,这主要是从性能角度考虑的.因为无比较器时,元素按自然排序.
//         * @param key
//         * @param value
//         * @return
//         */
//        public V put(K key, V value) {
//            Entry<K,V> t = root;
//            //如果原map为null
//            if (t == null) {
//                compare(key, key); // 类型检查
//
//                root = new Entry<>(key, value, null);
//                size = 1;
//                modCount++;
//                return null;
//            }
//            int cmp;
//            Entry<K,V> parent;
//
//            //将有比较器和无比较器的map分开讨论
//            Comparator<? super K> cpr = comparator;
//
//            //如果比较器不为null
//            if (cpr != null) {
//                do {
//                    parent = t;
//                    cmp = cpr.compare(key, t.key);
//                    //如果key<根节点,则左下查找插入位置
//                    if (cmp < 0)
//                        t = t.left;
//                    //如果key>根节点,则右下查找插入位置
//                    else if (cmp > 0)
//                        t = t.right;
//                    //否则,重置根节点的值
//                    else
//                        return t.setValue(value);
//                } while (t != null);
//            }
//            else {
//                if (key == null)
//                    throw new NullPointerException();
//                //如果没有比较器,就是自然排序喽
//                @SuppressWarnings("unchecked")
//                java.lang.Comparable<? super K> k = (java.lang.Comparable<? super K>) key;
//                do {
//                    parent = t;
//                    cmp = k.compareTo(t.key);
//                    //如果key<根节点,左下查找插入位置
//                    if (cmp < 0)
//                        t = t.left;
//                    //如果key>根节点,右下查找插入位置
//                    else if (cmp > 0)
//                        t = t.right;
//                    //走呃,重置根节点的值
//                    else
//                        return t.setValue(value);
//                } while (t != null);
//            }
//            Entry<K,V> e = new Entry<>(key, value, parent);
//            //如果key<红黑树中最小节点parent,则新节点成为parent的左孩子
//            if (cmp < 0)
//                parent.left = e;
//            //如果key>红黑树中最大节点parent,则新节点成为parent的右孩子
//            else
//                parent.right = e;
//
//            //节点插入完后,需要进行红黑树的调整,调整内容包含:高度+颜色
//            fixAfterInsertion(e);
//            size++;
//            modCount++;
//            return null;
//        }
//
//        //删除指定key的entry.
//        public V remove(Object key) {
//            Entry<K,V> p = getEntry(key);
//            if (p == null)
//                return null;
//
//            V oldValue = p.value;
//            //删除方法下面会有详细分析
//            deleteEntry(p);
//            return oldValue;
//        }
//
//        //清空map,且根节点置为null
//        public void clear() {
//            modCount++;
//            size = 0;
//            root = null;
//        }
//
//        //返回TreeMap实例的浅拷贝,但是key和value本身不做复制.
//        public Object clone() {
//            TreeMap<?,?> clone;
//            try {
//                clone = (TreeMap<?,?>) super.clone();//新建一个TreeMap实例
//            } catch (CloneNotSupportedException e) {
//                throw new InternalError(e);
//            }
//
//            //变量初始化
//            clone.root = null;
//            clone.size = 0;
//            clone.modCount = 0;
//            clone.entrySet = null;
//            clone.navigableKeySet = null;
//            clone.descendingMap = null;
//
//            //构建TreeMap,clone的初始化
//            try {
//                clone.buildFromSorted(size, entrySet().iterator(), null, null);
//            } catch (java.io.IOException cannotHappen) {
//            } catch (ClassNotFoundException cannotHappen) {
//            }
//
//            return clone;
//        }
//
//    /*-----NavigableMap API 方法-------*/
//
//        /**
//         * 获取最小key的entry
//         * enportEntry():返回指定entry;
//         * 如果指定entry为null,则返回null.
//         * @since 1.6
//         */
//        public Map.Entry<K,V> firstEntry() {
//            return exportEntry(getFirstEntry());
//        }
//
//        /**
//         * 获取最大key的entry
//         * @since 1.6
//         */
//        public Map.Entry<K,V> lastEntry() {
//            return exportEntry(getLastEntry());
//        }
//
//        /**
//         * 删除最小key的entry
//         * @since 1.6
//         */
//        public Map.Entry<K,V> pollFirstEntry() {
//            Entry<K,V> p = getFirstEntry();
//            Map.Entry<K,V> result = exportEntry(p);
//            if (p != null)
//                deleteEntry(p);
//            return result;
//        }
//
//        /**
//         * 删除最大key的entry
//         * @since 1.6
//         */
//        public Map.Entry<K,V> pollLastEntry() {
//            Entry<K,V> p = getLastEntry();
//            Map.Entry<K,V> result = exportEntry(p);
//            if (p != null)
//                deleteEntry(p);
//            return result;
//        }
//
//        /**
//         * 返回比指定key小的最大key的entry.
//         * 返回对象为final类型
//         * @since 1.6
//         */
//        public Map.Entry<K,V> lowerEntry(K key) {
//            return exportEntry(getLowerEntry(key));
//        }
//
//        /**
//         * 返回比指定key小的最大key
//         * 先返回entry,再返其key;
//         * 如果entry为null,则返回null.
//         * @since 1.6
//         */
//        public K lowerKey(K key) {
//            return keyOrNull(getLowerEntry(key));
//        }
//
//        /**
//         * 返回指定<=key的entry,优先返回=,其次返回稍小于
//         * @since 1.6
//         */
//        public Map.Entry<K,V> floorEntry(K key) {
//            return exportEntry(getFloorEntry(key));
//        }
//
//        /**
//         * 返回指定key<=entry的key;优先返回=,其次返回稍小于
//         * @since 1.6
//         */
//        public K floorKey(K key) {
//            return keyOrNull(getFloorEntry(key));
//        }
//
//        /**
//         * 获取>=指定key的entry,优先返回=,其次返回稍大于
//         * @since 1.6
//         */
//        public Map.Entry<K,V> ceilingEntry(K key) {
//            return exportEntry(getCeilingEntry(key));
//        }
//
//        /**
//         * 返回>=指定key的entry对于的key;优先返回=,其次返回稍大于
//         * @since 1.6
//         */
//        public K ceilingKey(K key) {
//            return keyOrNull(getCeilingEntry(key));
//        }
//
//        /**
//         * 获取>key的entry
//         * @since 1.6
//         */
//        public Map.Entry<K,V> higherEntry(K key) {
//            return exportEntry(getHigherEntry(key));
//        }
//
//        /**
//         * 获取>key的entry的key;key为null,返回null.
//         * @since 1.6
//         */
//        public K higherKey(K key) {
//            return keyOrNull(getHigherEntry(key));
//        }
//
//    /*------------视图操作方法---------*/
//
//        /**
//         * 第一次调用视图方法时,初始化一个entry实例的视图.
//         * 因为视图是无状态的,所以只需要创建一个entry实例就可以了,不需要创建更多.
//         * 序列化时,这3个域都被置为null
//         */
//        private transient EntrySet entrySet;
//        private transient KeySet<K> navigableKeySet;
//        //降序map,注意:NavigableMap的升序操作比降序操作性能更好
//        private transient NavigableMap<K,V> descendingMap;
//
//        /**
//         * 返回map的key集合;
//         * 注意:
//         * 1.key集合中元素为升序.
//         * 2.set集合的迭代器特性:延迟绑定,快速失效.
//         * 3.set集合的分割器:添加属性值Spliterator.SORTED , Spliterator.ORDERED
//         * 4.如果treemap的比较器为null,则分割器的迭代器也为null;否则,和TreeMap的比较器相同,
//         * 或者对总排序施加和treemap一致的排序.
//         *
//         * 因为返回的是TreeMap的key集合视图,因此视图的改变对keyset有影响,反之亦然.
//         *
//         * 返回set支持remove类操作,包括:Iterator.remove,Set.remove,removeAll,retainAll,
//         * clear.删除key时,同时删除map中的entry.
//         * 返回set不支持add类操作,如:add,addAll操作.为什么不支持add类操作,因为单独添加一个key,没有value
//         * 这是没有意义的,所以不支持add类操作很正常.
//         */
//        public java.util.Set<K> keySet() {
//            //调用下面方法,所以二者返回结果性质完全一致
//            return navigableKeySet();
//        }
//
//        /**
//         * 获取key的升序集合
//         * @since 1.6
//         */
//        public NavigableSet<K> navigableKeySet() {
//            KeySet<K> nks = navigableKeySet;
//            return (nks != null) ? nks : (navigableKeySet = new KeySet<>(this));
//        }
//
//        /**
//         * 获取key的降序集合
//         * @since 1.6
//         */
//        public NavigableSet<K> descendingKeySet() {
//            return descendingMap().navigableKeySet();
//        }
//
//        /**
//         * 返回TreeMap的value视图集合.
//         * value集合的顺序:key的升序排序决定了value的位置
//         * 返回Collection的分割器属性:Spliterator.ORDERED
//         * 因为返回Collection是map的视图,所以Collection的改变直接改变TreeMap,反之亦然.
//         * 返回Collection支持remove类操作,包括:Iterator.remove(),
//         * Collection.remove(), removeAll(),retainAll(), clear().
//         * 不支持add类操作.原因也是因为没有实际意义.
//         */
//        public Collection<V> values() {
//            Collection<V> vs = values;
//            if (vs == null) {
//                //保证了返回vs不会出现空指针异常问题.是不是这里可以改为Optional类?
//                vs = new Values();
//                values = vs;
//            }
//            return vs;
//        }
//
//        /**
//         * 返回entryset集合内部排列顺序:按key递增.
//         *
//         * 返回集合的分割器:延迟绑定,快速失效.
//         * 分割器额外添加属性:Spliterator.SORTED, Spliterator.ORDERED
//         *
//         * 支持remove类操作,如:Iterator.remove(),Set.remove(),removeAll(),retainAll(),clear()
//         * 不支持add类操作.
//         */
//        public java.util.Set<Map.Entry<K,V>> entrySet() {
//            EntrySet es = entrySet;
//            //new的操作保证返回对象非null
//            return (es != null) ? es : (entrySet = new EntrySet());
//        }
//
//        /**
//         * 获取按key降序的map
//         * @since 1.6
//         */
//        public NavigableMap<K, V> descendingMap() {
//            NavigableMap<K, V> km = descendingMap;
//            return (km != null) ? km :
//                    (descendingMap = new DescendingSubMap<>(this,
//                            true, null, true,
//                            true, null, true));
//        }
//
//        /**
//         * 获取按key升序的map
//         * fromInclusive=true,则最小key=fromKey;否则,最小key>fromKey;
//         * toInclusive=true,则最大key=toKey;否则,最大key<toKey.
//         * @since 1.6
//         */
//        public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
//                                        K toKey,   boolean toInclusive) {
//            return new AscendingSubMap<>(this,
//                    false, fromKey, fromInclusive,
//                    false, toKey,   toInclusive);
//        }
//
//        /**
//         * 返回子map,元素升序;
//         * 如果inClusivve=true,最大key=toKey;否则最大key<toKey.
//         * @since 1.6
//         */
//        public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
//            return new AscendingSubMap<>(this,
//                    true,  null,  true,
//                    false, toKey, inclusive);
//        }
//
//        /**
//         * 返回子map,元素升序;
//         * 如果inclusive=true,则最小key=fromKey;
//         * 否则,最小key>fromKey.
//         * @since 1.6
//         */
//        public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive) {
//            return new AscendingSubMap<>(this,
//                    false, fromKey, inclusive,
//                    true,  null,    true);
//        }
//
//        //返回子map,包含下限fromKey,不包含上限toKey
//        public SortedMap<K,V> subMap(K fromKey, K toKey) {
//            return subMap(fromKey, true, toKey, false);
//        }
//
//        //返回不包含上限toKey的子map
//        public SortedMap<K,V> headMap(K toKey) {
//            return headMap(toKey, false);
//        }
//
//        //返回包含下限fromKey的map
//        public SortedMap<K,V> tailMap(K fromKey) {
//            return tailMap(fromKey, true);
//        }
//
//        //利用key和oldValue找到entry,并替换value
//        @Override
//        public boolean replace(K key, V oldValue, V newValue) {
//            Entry<K,V> p = getEntry(key);
//            if (p!=null && Objects.equals(oldValue, p.value)) {
//                p.value = newValue;
//                return true;
//            }
//            return false;
//        }
//
//        //使用指定value替换key对应的value值.
//        @Override
//        public V replace(K key, V value) {
//            Entry<K,V> p = getEntry(key);
//            if (p!=null) {
//                V oldValue = p.value;
//                p.value = value;
//                return oldValue;
//            }
//            return null;
//        }
//
//        //内部迭代方法forEach
//        @Override
//        public void forEach(java.util.function.BiConsumer<? super K, ? super V> action) {
//            Objects.requireNonNull(action);
//            int expectedModCount = modCount;
//            for (Entry<K, V> e = getFirstEntry(); e != null; e = successor(e)) {
//                action.accept(e.key, e.value);
//
//                if (expectedModCount != modCount) {
//                    throw new ConcurrentModificationException();
//                }
//            }
//        }
//
//        //java8新方法,在对值的更改上,比原java中replace更具灵活性
//        @Override
//        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
//            Objects.requireNonNull(function);
//            int expectedModCount = modCount;
//
//            for (Entry<K, V> e = getFirstEntry(); e != null; e = successor(e)) {
//                e.value = function.apply(e.key, e.value);
//
//                if (expectedModCount != modCount) {
//                    throw new ConcurrentModificationException();
//                }
//            }
//        }
//
//    /*------------视图类支持方法------------*/
//
//        //TreeMap的values类
//        class Values extends AbstractCollection<V> {
//            public Iterator<V> iterator() {
//                return new ValueIterator(getFirstEntry());
//            }
//
//            public int size() {
//                return TreeMap.this.size();
//            }
//
//            public boolean contains(Object o) {
//                return TreeMap.this.containsValue(o);
//            }
//
//            public boolean remove(Object o) {
//                for (Entry<K,V> e = getFirstEntry(); e != null; e = successor(e)) {
//                    if (valEquals(e.getValue(), o)) {
//                        deleteEntry(e);
//                        return true;
//                    }
//                }
//                return false;
//            }
//
//            public void clear() {
//                TreeMap.this.clear();
//            }
//
//            public Spliterator<V> spliterator() {
//                return new ValueSpliterator<K,V>(TreeMap.this, null, null, 0, -1, 0);
//            }
//        }
//
//        //TreeMap的EntrySet
//        class EntrySet extends java.util.AbstractSet<Map.Entry<K,V>> {
//            public Iterator<Map.Entry<K,V>> iterator() {
//                return new EntryIterator(getFirstEntry());
//            }
//
//            public boolean contains(Object o) {
//                if (!(o instanceof Map.Entry))
//                    return false;
//                Map.Entry<?,?> entry = (Map.Entry<?,?>) o;
//                Object value = entry.getValue();
//                Entry<K,V> p = getEntry(entry.getKey());
//                return p != null && valEquals(p.getValue(), value);
//            }
//
//            public boolean remove(Object o) {
//                if (!(o instanceof Map.Entry))
//                    return false;
//                Map.Entry<?,?> entry = (Map.Entry<?,?>) o;
//                Object value = entry.getValue();
//                Entry<K,V> p = getEntry(entry.getKey());
//                if (p != null && valEquals(p.getValue(), value)) {
//                    deleteEntry(p);
//                    return true;
//                }
//                return false;
//            }
//
//            public int size() {
//                //调用外围类的size()方法
//                return TreeMap.this.size();
//            }
//
//            public void clear() {
//                //调用外围类的clear()方法
//                TreeMap.this.clear();
//            }
//
//            public Spliterator<Map.Entry<K,V>> spliterator() {
//                return new EntrySpliterator<K,V>(TreeMap.this, null, null, 0, -1, 0);
//            }
//        }
//
//        /**
//         * 和Values,EntrySet不同,KeySet是一个static final类,
//         * 迭代器方法主要定义在SubMap中,为了可以使用SubMap方法,将其行为委托给了NavigableMap,
//         * 代理的使用,消除了需要对Iterator方法进行类型检查的丑陋.---代理模式?
//         */
//
//        //key升序迭代器
//        Iterator<K> keyIterator() {
//            return new KeyIterator(getFirstEntry());
//        }
//
//        //key降序迭代器
//        Iterator<K> descendingKeyIterator() {
//            return new DescendingKeyIterator(getLastEntry());
//        }
//
//        //KeySet类,静态final类型
//        static final class KeySet<E> extends java.util.AbstractSet<E> implements NavigableSet<E> {
//            private final NavigableMap<E, ?> m;
//            KeySet(NavigableMap<E,?> map) { m = map; }
//
//            //key升序迭代器
//            public Iterator<E> iterator() {
//                if (m instanceof TreeMap)
//                    return ((TreeMap<E,?>)m).keyIterator();
//                else
//                    return ((TreeMap.NavigableSubMap<E,?>)m).keyIterator();
//            }
//            //key降序迭代器
//            public Iterator<E> descendingIterator() {
//                if (m instanceof TreeMap)
//                    return ((TreeMap<E,?>)m).descendingKeyIterator();
//                else
//                    return ((TreeMap.NavigableSubMap<E,?>)m).descendingKeyIterator();
//            }
//
//            public int size() { return m.size(); }
//            public boolean isEmpty() { return m.isEmpty(); }
//            public boolean contains(Object o) { return m.containsKey(o); }
//            public void clear() { m.clear(); }
//            public E lower(E e) { return m.lowerKey(e); }
//            public E floor(E e) { return m.floorKey(e); }
//            public E ceiling(E e) { return m.ceilingKey(e); }
//            public E higher(E e) { return m.higherKey(e); }
//            public E first() { return m.firstKey(); }
//            public E last() { return m.lastKey(); }
//            public Comparator<? super E> comparator() { return m.comparator(); }
//            public E pollFirst() {
//                Map.Entry<E,?> e = m.pollFirstEntry();
//                return (e == null) ? null : e.getKey();
//            }
//            public E pollLast() {
//                Map.Entry<E,?> e = m.pollLastEntry();
//                return (e == null) ? null : e.getKey();
//            }
//            public boolean remove(Object o) {
//                int oldSize = size();
//                m.remove(o);
//                return size() != oldSize;
//            }
//            public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
//                                          E toElement,   boolean toInclusive) {
//                return new KeySet<>(m.subMap(fromElement, fromInclusive,
//                        toElement,   toInclusive));
//            }
//            public NavigableSet<E> headSet(E toElement, boolean inclusive) {
//                return new KeySet<>(m.headMap(toElement, inclusive));
//            }
//            public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
//                return new KeySet<>(m.tailMap(fromElement, inclusive));
//            }
//            public SortedSet<E> subSet(E fromElement, E toElement) {
//                return subSet(fromElement, true, toElement, false);
//            }
//            public SortedSet<E> headSet(E toElement) {
//                return headSet(toElement, false);
//            }
//            public SortedSet<E> tailSet(E fromElement) {
//                return tailSet(fromElement, true);
//            }
//            public NavigableSet<E> descendingSet() {
//                return new KeySet<>(m.descendingMap());
//            }
//
//            public Spliterator<E> spliterator() {
//                return keySpliteratorFor(m);
//            }
//        }
//
//        /**TreeMap相关迭代器的辅助类
//         * 相关迭代器包括:
//         * EntryIterator
//         * ValueIterator
//         * KeyIterator
//         * DescendingKeyIterator
//         */
//        abstract class PrivateEntryIterator<T> implements Iterator<T> {
//            Entry<K,V> next;
//            Entry<K,V> lastReturned;
//            int expectedModCount;
//
//            PrivateEntryIterator(Entry<K,V> first) {
//                expectedModCount = modCount;
//                lastReturned = null;
//                next = first;
//            }
//
//            public final boolean hasNext() {
//                return next != null;
//            }
//
//            final Entry<K,V> nextEntry() {
//                Entry<K,V> e = next;
//                if (e == null)
//                    throw new NoSuchElementException();
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                next = successor(e);
//                lastReturned = e;
//                return e;
//            }
//
//            final Entry<K,V> prevEntry() {
//                Entry<K,V> e = next;
//                if (e == null)
//                    throw new NoSuchElementException();
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                next = predecessor(e);
//                lastReturned = e;
//                return e;
//            }
//
//            public void remove() {
//                if (lastReturned == null)
//                    throw new IllegalStateException();
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                // deleted entries are replaced by their successors
//                if (lastReturned.left != null && lastReturned.right != null)
//                    next = lastReturned;
//                deleteEntry(lastReturned);
//                expectedModCount = modCount;
//                lastReturned = null;
//            }
//        }
//
//        /*------以下4个final类都是对上面抽象类PrivateEntryIterator的扩展---*/
//
//        //entry迭代器
//        final class EntryIterator extends PrivateEntryIterator<Map.Entry<K,V>> {
//            EntryIterator(Entry<K,V> first) {
//                super(first);
//            }
//            public Map.Entry<K,V> next() {
//                return nextEntry();
//            }
//        }
//
//        //value迭代器
//        final class ValueIterator extends PrivateEntryIterator<V> {
//            ValueIterator(Entry<K,V> first) {
//                super(first);
//            }
//            public V next() {
//                return nextEntry().value;
//            }
//        }
//
//        //key迭代器
//        final class KeyIterator extends PrivateEntryIterator<K> {
//            KeyIterator(Entry<K,V> first) {
//                super(first);
//            }
//            public K next() {
//                return nextEntry().key;
//            }
//        }
//
//        //key降序迭代器
//        final class DescendingKeyIterator extends PrivateEntryIterator<K> {
//            DescendingKeyIterator(Entry<K,V> first) {
//                super(first);
//            }
//            public K next() {
//                return prevEntry().key;
//            }
//            public void remove() {
//                if (lastReturned == null)
//                    throw new IllegalStateException();
//                if (modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                deleteEntry(lastReturned);
//                lastReturned = null;
//                expectedModCount = modCount;
//            }
//        }
//
//    /*------------小的工具类----------*/
//
//        //分有比较器和无比较器,进行比较
//        @SuppressWarnings("unchecked")
//        final int compare(Object k1, Object k2) {
//            return comparator==null ? ((java.lang.Comparable<? super K>)k1).compareTo((K)k2)
//                    : comparator.compare((K)k1, (K)k2);
//        }
//
//        //测试两个值是否相等。与o1.equals（o2）的区别仅在于它正确地处理了o1为null的情况.
//        static final boolean valEquals(Object o1, Object o2) {
//            return (o1==null ? o2==null : o1.equals(o2));
//        }
//
//        /**
//         * 新建一个entry,映射同参数e,并返回;
//         * 如果参数e为null,则返回null.
//         */
//        static <K,V> Map.Entry<K,V> exportEntry(TreeMap.Entry<K,V> e) {
//            return (e == null) ? null :
//                    new AbstractMap.SimpleImmutableEntry<>(e);
//        }
//
//        /**
//         * key!=null,返回key;
//         * key==null,返回null;
//         */
//        static <K,V> K keyOrNull(TreeMap.Entry<K,V> e) {
//            return (e == null) ? null : e.key;
//        }
//
//        //返回指定entry的key
//        static <K> K key(Entry<K,?> e) {
//            if (e==null)
//                throw new NoSuchElementException();
//            return e.key;
//        }
//
//
//    /*--------SubMaps的操作---------*/
//
//        //虚拟值用作无界SubMapIterator的不可匹配的隔离key
//        private static final Object UNBOUNDED = new Object();
//
//        //升序的subMap,可序列化
//        abstract static class NavigableSubMap<K,V> extends AbstractMap<K,V>
//                implements NavigableMap<K,V>, java.io.Serializable {
//            //序列号
//            private static final long serialVersionUID = -2102997345730753016L;
//            //底层map
//            final TreeMap<K,V> m;
//
//            /**
//             * key的起始点和终点用三元组的形式进行确定:
//             * 起始点决定因素:(fromStart, lo,loInclusive)
//             * 终点决定因素:(toEnd, hi, hiInclusive)
//             * 为true时,包含边界点;
//             * 否则,不包含.
//             */
//            final K lo, hi;
//            final boolean fromStart, toEnd;
//            final boolean loInclusive, hiInclusive;
//
//            NavigableSubMap(TreeMap<K,V> m,
//                            boolean fromStart, K lo, boolean loInclusive,
//                            boolean toEnd,     K hi, boolean hiInclusive) {
//                if (!fromStart && !toEnd) {
//                    if (m.compare(lo, hi) > 0)
//                        throw new IllegalArgumentException("fromKey > toKey");
//                } else {
//                    if (!fromStart) // type check
//                        m.compare(lo, lo);
//                    if (!toEnd)
//                        m.compare(hi, hi);
//                }
//
//                this.m = m;
//                this.fromStart = fromStart;
//                this.lo = lo;
//                this.loInclusive = loInclusive;
//                this.toEnd = toEnd;
//                this.hi = hi;
//                this.hiInclusive = hiInclusive;
//            }
//
//            /*-----内部工具-----*/
//
//            //key是否低于下界
//            final boolean tooLow(Object key) {
//                //如果最小值不是subMap的最小值
//                if (!fromStart) {
//                    //将key和lo做比较
//                    int c = m.compare(key, lo);
//                    //如果key<lo or (key=lo 且 不包含终点),说明参数key不在sumMap的keys范围内,返回true.
//                    if (c < 0 || (c == 0 && !loInclusive))
//                        return true;
//                }
//                //如果最小值为subMap的最小值,则key肯定不会低于下界
//                return false;
//            }
//
//            //key是否超出上界
//            final boolean tooHigh(Object key) {
//                //如果最大值不是subMap的最大值
//                if (!toEnd) {
//                    //key和高位key做比较
//                    int c = m.compare(key, hi);
//                    //如果key>终点值 or (key=终点值 且 keyset不包含终点值)
//                    if (c > 0 || (c == 0 && !hiInclusive))
//                        return true;
//                }
//                //如果最大值是subMap的最大值,则key肯定是合法的,不会超出key的界限
//                return false;
//            }
//
//            //如果key既未超出上界,也未低于下界,则返回结果为true,(lo,hi)
//            final boolean inRange(Object key) {
//                return !tooLow(key) && !tooHigh(key);
//            }
//
//            //key是否在闭区间范围内,闭区间为[lo,hi]
//            final boolean inClosedRange(Object key) {
//                return (fromStart || m.compare(key, lo) >= 0)
//                        && (toEnd || m.compare(hi, key) >= 0);
//            }
//
//            /**
//             * inclusive=true,用于判定key是否在开区间范围内;
//             * inclusive=false,用于判定key是否在闭区间范围内.
//             */
//            final boolean inRange(Object key, boolean inclusive) {
//                return inclusive ? inRange(key) : inClosedRange(key);
//            }
//
//            /*
//             * 关系操作的一些绝对性方法.
//             * 使用类似"sub..."这样名字的方法时,是为了获取降序map.
//             */
//
//            //获取绝对最小entry
//            final TreeMap.Entry<K,V> absLowest() {
//                TreeMap.Entry<K,V> e =
//                        (fromStart ?  m.getFirstEntry() :
//                                (loInclusive ? m.getCeilingEntry(lo) :
//                                        m.getHigherEntry(lo)));
//                return (e == null || tooHigh(e.key)) ? null : e;
//            }
//
//            //获取绝对最大entry
//            final TreeMap.Entry<K,V> absHighest() {
//                TreeMap.Entry<K,V> e =
//                        (toEnd ?  m.getLastEntry() :
//                                (hiInclusive ?  m.getFloorEntry(hi) :
//                                        m.getLowerEntry(hi)));
//                return (e == null || tooLow(e.key)) ? null : e;
//            }
//
//            //获取>=key的绝对最小entry,优先返回=,其次返回<
//            final TreeMap.Entry<K,V> absCeiling(K key) {
//                //如果key<subMap的最小界,则返回subMap的最小entry
//                if (tooLow(key))
//                    return absLowest();
//                //获取<=key的entry
//                TreeMap.Entry<K,V> e = m.getCeilingEntry(key);
//                return (e == null || tooHigh(e.key)) ? null : e;
//            }
//
//            //获取>key的entry
//            final TreeMap.Entry<K,V> absHigher(K key) {
//                if (tooLow(key))
//                    return absLowest();
//                TreeMap.Entry<K,V> e = m.getHigherEntry(key);
//                return (e == null || tooHigh(e.key)) ? null : e;
//            }
//
//            //返回<=key的entry,优先 返回=,其次<
//            final TreeMap.Entry<K,V> absFloor(K key) {
//                if (tooHigh(key))
//                    return absHighest();
//                TreeMap.Entry<K,V> e = m.getFloorEntry(key);
//                return (e == null || tooLow(e.key)) ? null : e;
//            }
//
//            //获取<key的entry
//            final TreeMap.Entry<K,V> absLower(K key) {
//                if (tooHigh(key))
//                    return absHighest();
//                TreeMap.Entry<K,V> e = m.getLowerEntry(key);
//                return (e == null || tooLow(e.key)) ? null : e;
//            }
//
//            /** Returns the absolute high fence for ascending traversal */
//            //升序遍历中,返回绝对最大值
//            final TreeMap.Entry<K,V> absHighFence() {
//                /**if subMap上界为map的最大key,返回null,就是没有绝对最大key
//                 * else if,如果subMap包含上限值,则获取比subMap上限大的entry
//                 * else ,获取key>=hi的entry,优先返回=
//                 * **/
//                return (toEnd ? null : (hiInclusive ?
//                        m.getHigherEntry(hi) :
//                        m.getCeilingEntry(hi)));
//            }
//
//            //降序遍历中,返回绝对最小值
//            final TreeMap.Entry<K,V> absLowFence() {
//                return (fromStart ? null : (loInclusive ?
//                        m.getLowerEntry(lo) :
//                        m.getFloorEntry(lo)));
//            }
//
//            //抽象方法,用于降序or升序类
//            //这些方法会被具体实现到特定的版本中.
//            abstract TreeMap.Entry<K,V> subLowest();
//            abstract TreeMap.Entry<K,V> subHighest();
//            abstract TreeMap.Entry<K,V> subCeiling(K key);
//            abstract TreeMap.Entry<K,V> subHigher(K key);
//            abstract TreeMap.Entry<K,V> subFloor(K key);
//            abstract TreeMap.Entry<K,V> subLower(K key);
//
//            /** Returns ascending iterator from the perspective of this submap */
//            abstract Iterator<K> keyIterator();
//
//            abstract Spliterator<K> keySpliterator();
//
//            /** Returns descending iterator from the perspective of this submap */
//            abstract Iterator<K> descendingKeyIterator();
//
//            /*-------public methods-----*/
//
//            public boolean isEmpty() {
//                return (fromStart && toEnd) ? m.isEmpty() : entrySet().isEmpty();
//            }
//
//            public int size() {
//                return (fromStart && toEnd) ? m.size() : entrySet().size();
//            }
//
//            public final boolean containsKey(Object key) {
//                return inRange(key) && m.containsKey(key);
//            }
//
//            public final V put(K key, V value) {
//                if (!inRange(key))
//                    throw new IllegalArgumentException("key out of range");
//                return m.put(key, value);
//            }
//
//            public final V get(Object key) {
//                return !inRange(key) ? null :  m.get(key);
//            }
//
//            public final V remove(Object key) {
//                return !inRange(key) ? null : m.remove(key);
//            }
//
//            public final Map.Entry<K,V> ceilingEntry(K key) {
//                return exportEntry(subCeiling(key));
//            }
//
//            public final K ceilingKey(K key) {
//                return keyOrNull(subCeiling(key));
//            }
//
//            public final Map.Entry<K,V> higherEntry(K key) {
//                return exportEntry(subHigher(key));
//            }
//
//            public final K higherKey(K key) {
//                return keyOrNull(subHigher(key));
//            }
//
//            public final Map.Entry<K,V> floorEntry(K key) {
//                return exportEntry(subFloor(key));
//            }
//
//            public final K floorKey(K key) {
//                return keyOrNull(subFloor(key));
//            }
//
//            public final Map.Entry<K,V> lowerEntry(K key) {
//                return exportEntry(subLower(key));
//            }
//
//            public final K lowerKey(K key) {
//                return keyOrNull(subLower(key));
//            }
//
//            public final K firstKey() {
//                return key(subLowest());
//            }
//
//            public final K lastKey() {
//                return key(subHighest());
//            }
//
//            public final Map.Entry<K,V> firstEntry() {
//                return exportEntry(subLowest());
//            }
//
//            public final Map.Entry<K,V> lastEntry() {
//                return exportEntry(subHighest());
//            }
//
//            public final Map.Entry<K,V> pollFirstEntry() {
//                TreeMap.Entry<K,V> e = subLowest();
//                Map.Entry<K,V> result = exportEntry(e);
//                if (e != null)
//                    m.deleteEntry(e);
//                return result;
//            }
//
//            public final Map.Entry<K,V> pollLastEntry() {
//                TreeMap.Entry<K,V> e = subHighest();
//                Map.Entry<K,V> result = exportEntry(e);
//                if (e != null)
//                    m.deleteEntry(e);
//                return result;
//            }
//
//            // Views
//            transient NavigableMap<K,V> descendingMapView;
//            transient EntrySetView entrySetView;
//            transient KeySet<K> navigableKeySetView;
//
//            public final NavigableSet<K> navigableKeySet() {
//                KeySet<K> nksv = navigableKeySetView;
//                return (nksv != null) ? nksv :
//                        (navigableKeySetView = new TreeMap.KeySet<>(this));
//            }
//
//            public final java.util.Set<K> keySet() {
//                return navigableKeySet();
//            }
//
//            public NavigableSet<K> descendingKeySet() {
//                return descendingMap().navigableKeySet();
//            }
//
//            public final SortedMap<K,V> subMap(K fromKey, K toKey) {
//                return subMap(fromKey, true, toKey, false);
//            }
//
//            public final SortedMap<K,V> headMap(K toKey) {
//                return headMap(toKey, false);
//            }
//
//            public final SortedMap<K,V> tailMap(K fromKey) {
//                return tailMap(fromKey, true);
//            }
//
//            /*------视图类-----*/
//
//            abstract class EntrySetView extends AbstractSet<Entry<K,V>> {
//                private transient int size = -1, sizeModCount;
//
//                public int size() {
//                    if (fromStart && toEnd)
//                        return m.size();
//                    if (size == -1 || sizeModCount != m.modCount) {
//                        sizeModCount = m.modCount;
//                        size = 0;
//                        Iterator<?> i = iterator();
//                        while (i.hasNext()) {
//                            size++;
//                            i.next();
//                        }
//                    }
//                    return size;
//                }
//
//                public boolean isEmpty() {
//                    TreeMap.Entry<K,V> n = absLowest();
//                    return n == null || tooHigh(n.key);
//                }
//
//                public boolean contains(Object o) {
//                    if (!(o instanceof Map.Entry))
//                        return false;
//                    Map.Entry<?,?> entry = (Map.Entry<?,?>) o;
//                    Object key = entry.getKey();
//                    if (!inRange(key))
//                        return false;
//                    TreeMap.Entry<?,?> node = m.getEntry(key);
//                    return node != null &&
//                            valEquals(node.getValue(), entry.getValue());
//                }
//
//                public boolean remove(Object o) {
//                    if (!(o instanceof Map.Entry))
//                        return false;
//                    Map.Entry<?,?> entry = (Map.Entry<?,?>) o;
//                    Object key = entry.getKey();
//                    if (!inRange(key))
//                        return false;
//                    TreeMap.Entry<K,V> node = m.getEntry(key);
//                    if (node!=null && valEquals(node.getValue(),
//                            entry.getValue())) {
//                        m.deleteEntry(node);
//                        return true;
//                    }
//                    return false;
//                }
//            }
//
//            /**
//             * SubMaps的迭代器
//             */
//            abstract class SubMapIterator<T> implements Iterator<T> {
//                TreeMap.Entry<K,V> lastReturned;
//                TreeMap.Entry<K,V> next;
//                final Object fenceKey;
//                int expectedModCount;
//
//                SubMapIterator(TreeMap.Entry<K,V> first,
//                               TreeMap.Entry<K,V> fence) {
//                    expectedModCount = m.modCount;
//                    lastReturned = null;
//                    next = first;
//                    fenceKey = fence == null ? UNBOUNDED : fence.key;
//                }
//
//                public final boolean hasNext() {
//                    return next != null && next.key != fenceKey;
//                }
//
//                final TreeMap.Entry<K,V> nextEntry() {
//                    TreeMap.Entry<K,V> e = next;
//                    if (e == null || e.key == fenceKey)
//                        throw new NoSuchElementException();
//                    if (m.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                    next = successor(e);
//                    lastReturned = e;
//                    return e;
//                }
//
//                final TreeMap.Entry<K,V> prevEntry() {
//                    TreeMap.Entry<K,V> e = next;
//                    if (e == null || e.key == fenceKey)
//                        throw new NoSuchElementException();
//                    if (m.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                    next = predecessor(e);
//                    lastReturned = e;
//                    return e;
//                }
//
//                final void removeAscending() {
//                    if (lastReturned == null)
//                        throw new IllegalStateException();
//                    if (m.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                    // deleted entries are replaced by their successors
//                    if (lastReturned.left != null && lastReturned.right != null)
//                        next = lastReturned;
//                    m.deleteEntry(lastReturned);
//                    lastReturned = null;
//                    expectedModCount = m.modCount;
//                }
//
//                final void removeDescending() {
//                    if (lastReturned == null)
//                        throw new IllegalStateException();
//                    if (m.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                    m.deleteEntry(lastReturned);
//                    lastReturned = null;
//                    expectedModCount = m.modCount;
//                }
//
//            }
//
//            //entry迭代器,扩展上面的抽象类SubMapIterator
//            final class SubMapEntryIterator extends SubMapIterator<Map.Entry<K,V>> {
//                SubMapEntryIterator(TreeMap.Entry<K,V> first,
//                                    TreeMap.Entry<K,V> fence) {
//                    super(first, fence);
//                }
//                public Map.Entry<K,V> next() {
//                    return nextEntry();
//                }
//                public void remove() {
//                    removeAscending();
//                }
//            }
//
//            //降序subMap迭代器
//            final class DescendingSubMapEntryIterator extends SubMapIterator<Map.Entry<K,V>> {
//                DescendingSubMapEntryIterator(TreeMap.Entry<K,V> last,
//                                              TreeMap.Entry<K,V> fence) {
//                    super(last, fence);
//                }
//
//                public Map.Entry<K,V> next() {
//                    return prevEntry();
//                }
//                public void remove() {
//                    removeDescending();
//                }
//            }
//
//            // Spliterator的最简单实现,作为KeySpliterator备份
//            //对key的迭代器
//            final class SubMapKeyIterator extends SubMapIterator<K>
//                    implements Spliterator<K> {
//                SubMapKeyIterator(TreeMap.Entry<K,V> first,
//                                  TreeMap.Entry<K,V> fence) {
//                    super(first, fence);
//                }
//                public K next() {
//                    return nextEntry().key;
//                }
//                public void remove() {
//                    removeAscending();
//                }
//                public Spliterator<K> trySplit() {
//                    return null;
//                }
//                public void forEachRemaining(java.util.function.Consumer<? super K> action) {
//                    while (hasNext())
//                        action.accept(next());
//                }
//                public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
//                    if (hasNext()) {
//                        action.accept(next());
//                        return true;
//                    }
//                    return false;
//                }
//                public long estimateSize() {
//                    return Long.MAX_VALUE;
//                }
//                public int characteristics() {
//                    return Spliterator.DISTINCT | Spliterator.ORDERED |
//                            Spliterator.SORTED;
//                }
//                public final Comparator<? super K>  getComparator() {
//                    return NavigableSubMap.this.comparator();
//                }
//            }
//
//            //降序map的key迭代器
//            final class DescendingSubMapKeyIterator extends SubMapIterator<K>
//                    implements Spliterator<K> {
//                DescendingSubMapKeyIterator(TreeMap.Entry<K,V> last,
//                                            TreeMap.Entry<K,V> fence) {
//                    super(last, fence);
//                }
//                public K next() {
//                    return prevEntry().key;
//                }
//                public void remove() {
//                    removeDescending();
//                }
//                public Spliterator<K> trySplit() {
//                    return null;
//                }
//                public void forEachRemaining(java.util.function.Consumer<? super K> action) {
//                    while (hasNext())
//                        action.accept(next());
//                }
//                public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
//                    if (hasNext()) {
//                        action.accept(next());
//                        return true;
//                    }
//                    return false;
//                }
//                public long estimateSize() {
//                    return Long.MAX_VALUE;
//                }
//                public int characteristics() {
//                    return Spliterator.DISTINCT | Spliterator.ORDERED;
//                }
//            }
//        }
//
//
//        //升序subMap
//        static final class AscendingSubMap<K,V> extends NavigableSubMap<K,V> {
//            private static final long serialVersionUID = 912986545866124060L;
//
//            AscendingSubMap(TreeMap<K,V> m,
//                            boolean fromStart, K lo, boolean loInclusive,
//                            boolean toEnd,     K hi, boolean hiInclusive) {
//                super(m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
//            }
//
//            public Comparator<? super K> comparator() {
//                return m.comparator();
//            }
//
//            public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
//                                            K toKey,   boolean toInclusive) {
//                if (!inRange(fromKey, fromInclusive))
//                    throw new IllegalArgumentException("fromKey out of range");
//                if (!inRange(toKey, toInclusive))
//                    throw new IllegalArgumentException("toKey out of range");
//                return new AscendingSubMap<>(m,
//                        false, fromKey, fromInclusive,
//                        false, toKey,   toInclusive);
//            }
//
//            public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
//                if (!inRange(toKey, inclusive))
//                    throw new IllegalArgumentException("toKey out of range");
//                return new AscendingSubMap<>(m,
//                        fromStart, lo,    loInclusive,
//                        false,     toKey, inclusive);
//            }
//
//            public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive) {
//                if (!inRange(fromKey, inclusive))
//                    throw new IllegalArgumentException("fromKey out of range");
//                return new AscendingSubMap<>(m,
//                        false, fromKey, inclusive,
//                        toEnd, hi,      hiInclusive);
//            }
//
//            public NavigableMap<K,V> descendingMap() {
//                NavigableMap<K,V> mv = descendingMapView;
//                return (mv != null) ? mv :
//                        (descendingMapView =
//                                new DescendingSubMap<>(m,
//                                        fromStart, lo, loInclusive,
//                                        toEnd,     hi, hiInclusive));
//            }
//
//            Iterator<K> keyIterator() {
//                return new java.util.TreeMap.NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
//            }
//
//            Spliterator<K> keySpliterator() {
//                return new java.util.TreeMap.NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
//            }
//
//            //升序subMap中key的降序迭代器
//            Iterator<K> descendingKeyIterator() {
//                return new java.util.TreeMap.NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
//            }
//
//            final class AscendingEntrySetView extends java.util.TreeMap.NavigableSubMap.EntrySetView {
//                public Iterator<Map.Entry<K,V>> iterator() {
//                    return new java.util.TreeMap.NavigableSubMap.SubMapEntryIterator(absLowest(), absHighFence());
//                }
//            }
//
//            public java.util.Set<Entry<K,V>> entrySet() {
//                java.util.TreeMap.NavigableSubMap.EntrySetView es = entrySetView;
//                return (es != null) ? es : (entrySetView = new AscendingEntrySetView());
//            }
//
//            TreeMap.Entry<K,V> subLowest()       { return absLowest(); }
//            TreeMap.Entry<K,V> subHighest()      { return absHighest(); }
//            TreeMap.Entry<K,V> subCeiling(K key) { return absCeiling(key); }
//            TreeMap.Entry<K,V> subHigher(K key)  { return absHigher(key); }
//            TreeMap.Entry<K,V> subFloor(K key)   { return absFloor(key); }
//            TreeMap.Entry<K,V> subLower(K key)   { return absLower(key); }
//        }
//
//        //降序subMap
//        static final class DescendingSubMap<K,V>  extends NavigableSubMap<K,V> {
//            private static final long serialVersionUID = 912986545866120460L;
//            DescendingSubMap(TreeMap<K,V> m,
//                             boolean fromStart, K lo, boolean loInclusive,
//                             boolean toEnd,     K hi, boolean hiInclusive) {
//                super(m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
//            }
//
//            private final Comparator<? super K> reverseComparator =
//                    Collections.reverseOrder(m.comparator);
//
//            public Comparator<? super K> comparator() {
//                return reverseComparator;
//            }
//
//            public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
//                                            K toKey,   boolean toInclusive) {
//                if (!inRange(fromKey, fromInclusive))
//                    throw new IllegalArgumentException("fromKey out of range");
//                if (!inRange(toKey, toInclusive))
//                    throw new IllegalArgumentException("toKey out of range");
//                return new DescendingSubMap<>(m,
//                        false, toKey,   toInclusive,
//                        false, fromKey, fromInclusive);
//            }
//
//            public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
//                if (!inRange(toKey, inclusive))
//                    throw new IllegalArgumentException("toKey out of range");
//                return new DescendingSubMap<>(m,
//                        false, toKey, inclusive,
//                        toEnd, hi,    hiInclusive);
//            }
//
//            public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive) {
//                if (!inRange(fromKey, inclusive))
//                    throw new IllegalArgumentException("fromKey out of range");
//                return new DescendingSubMap<>(m,
//                        fromStart, lo, loInclusive,
//                        false, fromKey, inclusive);
//            }
//
//            public NavigableMap<K,V> descendingMap() {
//                NavigableMap<K,V> mv = descendingMapView;
//                return (mv != null) ? mv :
//                        (descendingMapView =
//                                new AscendingSubMap<>(m,
//                                        fromStart, lo, loInclusive,
//                                        toEnd,     hi, hiInclusive));
//            }
//
//            Iterator<K> keyIterator() {
//                return new java.util.TreeMap.NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
//            }
//
//            Spliterator<K> keySpliterator() {
//                return new java.util.TreeMap.NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
//            }
//
//            Iterator<K> descendingKeyIterator() {
//                return new java.util.TreeMap.NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
//            }
//
//            final class DescendingEntrySetView extends java.util.TreeMap.NavigableSubMap.EntrySetView {
//                public Iterator<Map.Entry<K,V>> iterator() {
//                    return new java.util.TreeMap.NavigableSubMap.DescendingSubMapEntryIterator(absHighest(), absLowFence());
//                }
//            }
//
//            public java.util.Set<Entry<K,V>> entrySet() {
//                java.util.TreeMap.NavigableSubMap.EntrySetView es = entrySetView;
//                return (es != null) ? es : (entrySetView = new DescendingEntrySetView());
//            }
//
//            TreeMap.Entry<K,V> subLowest()       { return absHighest(); }
//            TreeMap.Entry<K,V> subHighest()      { return absLowest(); }
//            TreeMap.Entry<K,V> subCeiling(K key) { return absFloor(key); }
//            TreeMap.Entry<K,V> subHigher(K key)  { return absLower(key); }
//            TreeMap.Entry<K,V> subFloor(K key)   { return absCeiling(key); }
//            TreeMap.Entry<K,V> subLower(K key)   { return absHigher(key); }
//        }
//
//        /**
//         * 该类仅用于与不支持NavigableMap的以前版本的TreeMap的序列化兼容性.
//         * 它将旧版本的SubMap转换为新版本的AscendingSubMap。这个类从来没有使用过。
//         */
//        private class SubMap extends AbstractMap<K,V>
//                implements SortedMap<K,V>, java.io.Serializable {
//            private static final long serialVersionUID = -6520786458950516097L;
//            private boolean fromStart = false, toEnd = false;
//            private K fromKey, toKey;
//            private Object readResolve() {
//                return new AscendingSubMap<>(TreeMap.this,
//                        fromStart, fromKey, true,
//                        toEnd, toKey, false);
//            }
//            public Set<Entry<K,V>> entrySet() { throw new InternalError(); }
//            public K lastKey() { throw new InternalError(); }
//            public K firstKey() { throw new InternalError(); }
//            public SortedMap<K,V> subMap(K fromKey, K toKey) { throw new InternalError(); }
//            public SortedMap<K,V> headMap(K toKey) { throw new InternalError(); }
//            public SortedMap<K,V> tailMap(K fromKey) { throw new InternalError(); }
//            public Comparator<? super K> comparator() { throw new InternalError(); }
//        }
//
//
//    /*---------红黑树机制--------*/
//
//        private static final boolean RED   = false;
//        private static final boolean BLACK = true;
//
//        /**
//         * Node in the Tree.  Doubles as a means to pass key-value pairs back to
//         * user (see Map.Entry).
//         */
//
//        static final class Entry<K,V> implements Map.Entry<K,V> {
//            K key;
//            V value;
//            Entry<K,V> left;
//            Entry<K,V> right;
//            Entry<K,V> parent;
//            boolean color = BLACK;//true为黑色;false为红色;
//
//            //新建红黑树节点,有双亲,无孩子,颜色为黑色
//            Entry(K key, V value, Entry<K,V> parent) {
//                this.key = key;
//                this.value = value;
//                this.parent = parent;
//            }
//
//            public K getKey() {
//                return key;
//            }
//
//
//            public V getValue() {
//                return value;
//            }
//
//            public V setValue(V value) {
//                V oldValue = this.value;
//                this.value = value;
//                return oldValue;
//            }
//
//            public boolean equals(Object o) {
//                if (!(o instanceof Map.Entry))
//                    return false;
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//
//                return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
//            }
//
//            public int hashCode() {
//                int keyHash = (key==null ? 0 : key.hashCode());
//                int valueHash = (value==null ? 0 : value.hashCode());
//                return keyHash ^ valueHash;
//            }
//
//            public String toString() {
//                return key + "=" + value;
//            }
//        }
//
//        //返回第一个entry,左下遍历,因为红黑树最小节点在最左处
//        final Entry<K,V> getFirstEntry() {
//            Entry<K,V> p = root;
//            if (p != null)
//                while (p.left != null)
//                    p = p.left;
//            return p;
//        }
//
//       //返回最后一个entry,右下遍历,因为红黑树最大节点在最右侧
//        final Entry<K,V> getLastEntry() {
//            Entry<K,V> p = root;
//            if (p != null)
//                while (p.right != null)
//                    p = p.right;
//            return p;
//        }
//
//
//        //返回指定entry的后继;如果没有则返回null.
//        static <K,V> TreeMap.Entry<K,V> successor(Entry<K,V> t) {
//            //t为null,返回null
//            if (t == null)
//                return null;
//            //t右孩子不为null,遍历t的右孩子的左孩子,返回比t稍微大的那个节点
//            else if (t.right != null) {
//                Entry<K,V> p = t.right;
//                while (p.left != null)
//                    p = p.left;
//                return p;
//            }
//            //t右孩子为null,说明没有比t大的节点
//            else {
//                Entry<K,V> p = t.parent;
//                Entry<K,V> ch = t;
//                //最后p=null,ch指向根节点,故最后返回null.
//                while (p != null && ch == p.right) {
//                    ch = p;
//                    p = p.parent;
//                }
//                return p;
//            }
//        }
//
//        //返回指定entry的前驱
//        static <K,V> Entry<K,V> predecessor(Entry<K,V> t) {
//            //t为null,返回nul
//            if (t == null)
//                return null;
//            //如果t的左孩子不为空,说明有比t的key小的entry
//            else if (t.left != null) {
//                Entry<K,V> p = t.left;
//                while (p.right != null)
//                    p = p.right;
//                return p;
//            }
//            //如果t的左孩子为null,说明没有比t的key小的entry,则返回null.
//            else {
//                Entry<K,V> p = t.parent;
//                Entry<K,V> ch = t;
//                while (p != null && ch == p.left) {
//                    ch = p;
//                    p = p.parent;
//                }
//                return p;
//            }
//        }
//
//        /**
//         * 平衡操作
//         *
//         * 在插入,删除节点后的调整平衡操作和CLR版本略有区别.
//         * 我们不是使用虚拟nilnode，而是使用一组能正确处理null的访问器。它们用于避免主要算法中的对null检查
//         * 对周围造成的混乱。
//         * nilnode是红黑树定义中的叶子节点,是null.
//         */
//
//        //返回p节点颜色
//        //p为null,返回黑色;否则,返回实际p的颜色
//        private static <K,V> boolean colorOf(Entry<K,V> p) {
//            return (p == null ? BLACK : p.color);
//        }
//
//        //返回p节点双亲节点
//        private static <K,V> Entry<K,V> parentOf(Entry<K,V> p) {
//            return (p == null ? null: p.parent);
//        }
//
//        //为p节点设定颜色为c
//        private static <K,V> void setColor(Entry<K,V> p, boolean c) {
//            if (p != null)
//                p.color = c;
//        }
//
//        //返回p条目的左孩子
//        private static <K,V> Entry<K,V> leftOf(Entry<K,V> p) {
//            return (p == null) ? null: p.left;
//        }
//
//        //返回p条目的右孩子
//        private static <K,V> Entry<K,V> rightOf(Entry<K,V> p) {
//            return (p == null) ? null: p.right;
//        }
//
//
//        /**
//         * From CLR
//         * 左旋操作
//         * p为非平衡节点的孩子节点,
//         * 平衡后,p的双亲节点的孩子节点变为p的右孩子节点,
//         * p变为p右孩子节点的左孩子
//         * 原p右孩子节点的左孩子变为p的右孩子
//         */
//        private void rotateLeft(Entry<K,V> p) {
//            if (p != null) {
//                //记录p节点的右孩子,
//                Entry<K,V> r = p.right;
//                //p的右孩子变为p的右孩子的左孩子
//                p.right = r.left;
//                //如果p的右孩子的左孩子不为null,则将其双亲变为p
//                if (r.left != null)
//                    r.left.parent = p;
//
//                //p的右孩子的双亲变为p的双亲节点
//                r.parent = p.parent;
//                //如果p的双亲为null,则r变为根节点
//                if (p.parent == null)
//                    root = r;
//                //如果p是根节点的左孩子,则将p的双亲节点的左孩子变为r
//                else if (p.parent.left == p)
//                    p.parent.left = r;
//                //如果p是双亲节点的右孩子,则将p的双亲节点的右孩子变为r
//                else
//                    p.parent.right = r;
//                //r的左孩子变为p
//                r.left = p;
//                //p的双亲节点变为r
//                p.parent = r;
//            }
//        }
//
//        /**
//         * From CLR
//         * 右旋方法
//         */
//        private void rotateRight(Entry<K,V> p) {
//            if (p != null) {
//                //1.记录p的左孩子节点
//                Entry<K,V> l = p.left;
//                //2.p和p新的左孩子的关系设置
//                //2.1p的左孩子变为l的右孩子
//                p.left = l.right;
//                //2.2如p的新左孩子不为null,则修改新左孩子的双亲节点为p
//                if (l.right != null) l.right.parent = p;
//                //3.修改p的双亲节点和p原左孩子的关系
//                //3.1p原左孩子的双亲节点改为p的双亲节点
//                l.parent = p.parent;
//                //3.2如果p节点就是根节点,则根节点修改为p原左孩子
//                if (p.parent == null)
//                    root = l;
//                //3.3如果p节点是双亲节点的右孩子,则l变为p双亲节点的右孩子
//                else if (p.parent.right == p)
//                    p.parent.right = l;
//                //3.4如果p节点是双亲节点的左孩子,则l变为p双亲节点的左孩子
//                else p.parent.left = l;
//                //4.p和p原左孩子之间角色兑换
//                l.right = p;
//                p.parent = l;
//            }
//        }
//
//        //插入节点后,修复红黑树
//        private void fixAfterInsertion(Entry<K,V> x) {
//            x.color = RED;
//
//            while (x != null && x != root && x.parent.color == RED) {
//                if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
//                    Entry<K,V> y = rightOf(parentOf(parentOf(x)));
//                    if (colorOf(y) == RED) {
//                        setColor(parentOf(x), BLACK);
//                        setColor(y, BLACK);
//                        setColor(parentOf(parentOf(x)), RED);
//                        x = parentOf(parentOf(x));
//                    } else {
//                        if (x == rightOf(parentOf(x))) {
//                            x = parentOf(x);
//                            rotateLeft(x);
//                        }
//                        setColor(parentOf(x), BLACK);
//                        setColor(parentOf(parentOf(x)), RED);
//                        rotateRight(parentOf(parentOf(x)));
//                    }
//                } else {
//                    Entry<K,V> y = leftOf(parentOf(parentOf(x)));
//                    if (colorOf(y) == RED) {
//                        setColor(parentOf(x), BLACK);
//                        setColor(y, BLACK);
//                        setColor(parentOf(parentOf(x)), RED);
//                        x = parentOf(parentOf(x));
//                    } else {
//                        if (x == leftOf(parentOf(x))) {
//                            x = parentOf(x);
//                            rotateRight(x);
//                        }
//                        setColor(parentOf(x), BLACK);
//                        setColor(parentOf(parentOf(x)), RED);
//                        rotateLeft(parentOf(parentOf(x)));
//                    }
//                }
//            }
//            root.color = BLACK;
//        }
//
//        //删除红黑树节点
//        private void deleteEntry(Entry<K,V> p) {
//            modCount++;
//            size--;
//
//            // If strictly internal, copy successor's element to p and then make p
//            // point to successor.
//            if (p.left != null && p.right != null) {
//                Entry<K,V> s = successor(p);
//                p.key = s.key;
//                p.value = s.value;
//                p = s;
//            } // p has 2 children
//
//            // Start fixup at replacement node, if it exists.
//            Entry<K,V> replacement = (p.left != null ? p.left : p.right);
//
//            if (replacement != null) {
//                // Link replacement to parent
//                replacement.parent = p.parent;
//                if (p.parent == null)
//                    root = replacement;
//                else if (p == p.parent.left)
//                    p.parent.left  = replacement;
//                else
//                    p.parent.right = replacement;
//
//                // Null out links so they are OK to use by fixAfterDeletion.
//                p.left = p.right = p.parent = null;
//
//                // Fix replacement
//                if (p.color == BLACK)
//                    fixAfterDeletion(replacement);
//            } else if (p.parent == null) { // return if we are the only node.
//                root = null;
//            } else { //  No children. Use self as phantom replacement and unlink.
//                if (p.color == BLACK)
//                    fixAfterDeletion(p);
//
//                if (p.parent != null) {
//                    if (p == p.parent.left)
//                        p.parent.left = null;
//                    else if (p == p.parent.right)
//                        p.parent.right = null;
//                    p.parent = null;
//                }
//            }
//        }
//
//        //节点删除后,调整红黑树
//        private void fixAfterDeletion(Entry<K,V> x) {
//            while (x != root && colorOf(x) == BLACK) {
//                if (x == leftOf(parentOf(x))) {
//                    Entry<K,V> sib = rightOf(parentOf(x));
//
//                    if (colorOf(sib) == RED) {
//                        setColor(sib, BLACK);
//                        setColor(parentOf(x), RED);
//                        rotateLeft(parentOf(x));
//                        sib = rightOf(parentOf(x));
//                    }
//
//                    if (colorOf(leftOf(sib))  == BLACK &&
//                            colorOf(rightOf(sib)) == BLACK) {
//                        setColor(sib, RED);
//                        x = parentOf(x);
//                    } else {
//                        if (colorOf(rightOf(sib)) == BLACK) {
//                            setColor(leftOf(sib), BLACK);
//                            setColor(sib, RED);
//                            rotateRight(sib);
//                            sib = rightOf(parentOf(x));
//                        }
//                        setColor(sib, colorOf(parentOf(x)));
//                        setColor(parentOf(x), BLACK);
//                        setColor(rightOf(sib), BLACK);
//                        rotateLeft(parentOf(x));
//                        x = root;
//                    }
//                } else { // symmetric
//                    Entry<K,V> sib = leftOf(parentOf(x));
//
//                    if (colorOf(sib) == RED) {
//                        setColor(sib, BLACK);
//                        setColor(parentOf(x), RED);
//                        rotateRight(parentOf(x));
//                        sib = leftOf(parentOf(x));
//                    }
//
//                    if (colorOf(rightOf(sib)) == BLACK &&
//                            colorOf(leftOf(sib)) == BLACK) {
//                        setColor(sib, RED);
//                        x = parentOf(x);
//                    } else {
//                        if (colorOf(leftOf(sib)) == BLACK) {
//                            setColor(rightOf(sib), BLACK);
//                            setColor(sib, RED);
//                            rotateLeft(sib);
//                            sib = leftOf(parentOf(x));
//                        }
//                        setColor(sib, colorOf(parentOf(x)));
//                        setColor(parentOf(x), BLACK);
//                        setColor(leftOf(sib), BLACK);
//                        rotateRight(parentOf(x));
//                        x = root;
//                    }
//                }
//            }
//
//            setColor(x, BLACK);
//        }
//
//    /*------序列化相关-------*/
//
//        //序列化号
//        private static final long serialVersionUID = 919286545866124006L;
//
//        //将TreeMap实例的状态保存到stream中,用于序列化
//        private void writeObject(java.io.ObjectOutputStream s)
//                throws java.io.IOException {
//
//            //1.写入一些隐藏信息
//            s.defaultWriteObject();
//
//            //2.写入size
//            s.writeInt(size);
//
//            //3.依次写入key-value对
//            for (Iterator<Map.Entry<K,V>> i = entrySet().iterator(); i.hasNext(); ) {
//                Map.Entry<K,V> e = i.next();
//                s.writeObject(e.getKey());
//                s.writeObject(e.getValue());
//            }
//        }
//
//        //利用输入stream,重构TreeMap实例
//        private void readObject(final java.io.ObjectInputStream s)
//                throws java.io.IOException, ClassNotFoundException {
//
//            //读入隐藏信息
//            s.defaultReadObject();
//
//            //读入size大小
//            int size = s.readInt();
//
//            //创建TreeMap实例
//            buildFromSorted(size, null, s, null);
//        }
//
//        /**仅从TreeSet.readObject中调用*/
//        void readTreeSet(int size, java.io.ObjectInputStream s, V defaultVal)
//                throws java.io.IOException, ClassNotFoundException {
//            buildFromSorted(size, null, s, defaultVal);
//        }
//
//        /**仅从TreeSet.addAll中调用*/
//        void addAllForTreeSet(SortedSet<? extends K> set, V defaultVal) {
//            try {
//                buildFromSorted(set.size(), set.iterator(), null, defaultVal);
//            } catch (java.io.IOException cannotHappen) {
//            } catch (ClassNotFoundException cannotHappen) {
//            }
//        }
//
//
//        /**
//         * 输入数据有序时,建树需要线性时间.
//         * 也可以从迭代器或stream中获取key-value.
//         * 这导致太多参数，但似乎比替代方案更好。这种方法接受的四种格式是:
//         *    1) An iterator of Map.Entries.  (it != null, defaultVal == null).
//         *    2) An iterator of keys.         (it != null, defaultVal != null).
//         *    3) A stream of alternating serialized keys and values.
//         *                                   (it == null, defaultVal == null).
//         *    4) A stream of serialized keys. (it == null, defaultVal != null).
//         *
//         * 这一方法假设TreeMap的比较器在调用这个方法前已经存在.
//         *
//         * @param size 从迭代器或stream中要读取的entry个数
//         * @param it 如果非null,则创建的entry从迭代器读取.
//         * @param str 则新创建的entry会按照序列化的格式进行读取.
//         * @param defaultVal 如果非null,则TreeMap实例的所有的entry的value都被设置为defaultVal
//         */
//        private void buildFromSorted(int size, Iterator<?> it,
//                                     java.io.ObjectInputStream str,
//                                     V defaultVal)
//                throws  java.io.IOException, ClassNotFoundException {
//            this.size = size;
//            root = buildFromSorted(0, 0, size-1, computeRedLevel(size),
//                    it, str, defaultVal);
//        }
//
//        /**
//         * 递归的“辅助方法”，完成了前面方法的实际工作.
//         * 参数功能和命名基本一致.
//         * 此方法调用前,已经假设了TreeMap的比较器和size域存在.
//         *
//         * @param level 树的当前层次,第一次调用时被置为0.
//         * @param lo subtree第一个节点的索引,初始化时被置为0.
//         * @param hi subtree最后一个节点的索引,初始化时被置为size-1.
//         * @param redLevel 节点应该是红色的层,这个数值必须和同样size的红黑树在computeRedLevel方法的结果一致.
//         * 其它参数含义和上一个方法中定义的一致.
//         */
//        @SuppressWarnings("unchecked")
//        private final Entry<K,V> buildFromSorted(int level, int lo, int hi,
//                                                 int redLevel,
//                                                 Iterator<?> it,
//                                                 java.io.ObjectInputStream str,
//                                                 V defaultVal)
//                throws  java.io.IOException, ClassNotFoundException {
//            /**
//             * 策略:
//             * 根节点为中间的元素.为了得到根节点,我们必须先递归调用左子树,以便能获取它所有的元素.
//             * 然后才可以对右子树做操作.
//             *
//             * 参数lo和hi是在构建当前subtree时,从迭代器或stream获取元素的最大和最小索引.
//             * 但是,它们并不是TreeMap的真正索引,这只是标志了顺序获取元素的索引.从而保证获取
//             * 元素的正确性.
//             */
//
//            if (hi < lo) return null;
//
//            //无符号右移一位
//            int mid = (lo + hi) >>> 1;
//
//            Entry<K,V> left  = null;
//            if (lo < mid)
//                left = buildFromSorted(level+1, lo, mid - 1, redLevel,
//                        it, str, defaultVal);
//
//            //从iterator or stream获取entry
//            K key;
//            V value;
//            if (it != null) {
//                if (defaultVal==null) {
//                    Map.Entry<?,?> entry = (Map.Entry<?,?>)it.next();
//                    key = (K)entry.getKey();
//                    value = (V)entry.getValue();
//                } else {
//                    key = (K)it.next();
//                    value = defaultVal;
//                }
//            } else { // use stream
//                key = (K) str.readObject();
//                value = (defaultVal != null ? defaultVal : (V) str.readObject());
//            }
//
//            Entry<K,V> middle =  new Entry<>(key, value, null);
//
//            // color nodes in non-full bottommost level red
//            if (level == redLevel)
//                middle.color = RED;
//
//            if (left != null) {
//                middle.left = left;
//                left.parent = middle;
//            }
//
//            if (mid < hi) {
//                Entry<K,V> right = buildFromSorted(level+1, mid+1, hi, redLevel,
//                        it, str, defaultVal);
//                middle.right = right;
//                right.parent = middle;
//            }
//
//            //返回根节点
//            return middle;
//        }
//
//        /**
//         * 找到向下分配所有BLACK节点的层次.这是buildTree生成的完整二叉树的最后一个“完整”层。
//         * 剩下的节点被标记为红色.(这会为将来的插入提供一个很好的颜色分配。)
//         * 这个层次的数字是通过查找到达第0个节点所需的分割数量来计算的.
//         * 时间复杂度:lg(N)
//         */
//        //返回TreeMap红黑树中有几层红色节点
//        private static int computeRedLevel(int sz) {
//            int level = 0;
//            //通过计算,可以发现,从最底层索引idx=sz-1开始,然后除2再减1,得到上一层红色节点层次.
//            for (int m = sz - 1; m >= 0; m = m / 2 - 1)
//                level++;
//            return level;
//        }
//
//        /**
//         * 目前,无论是降序形式还是默认升序的map,我们都只支持整个map的分割迭代器,因为subMap的
//         * 大小估计会占用很大的性能损耗.
//         * 对key视图的类型检查虽然代码上不是很友好,但是这样做缺可以避免破坏现存类的结构.
//         * 如果返回结果为null,调用者必须使用默认的空分割器.
//         */
//        static <K> Spliterator<K> keySpliteratorFor(NavigableMap<K,?> m) {
//            if (m instanceof TreeMap) {
//                @SuppressWarnings("unchecked") TreeMap<K,Object> t =
//                        (TreeMap<K,Object>) m;
//                return t.keySpliterator();
//            }
//            if (m instanceof DescendingSubMap) {
//                @SuppressWarnings("unchecked") DescendingSubMap<K,?> dm =
//                        (DescendingSubMap<K,?>) m;
//                TreeMap<K,?> tm = dm.m;
//                if (dm == tm.descendingMap) {
//                    @SuppressWarnings("unchecked") TreeMap<K,Object> t =
//                            (TreeMap<K,Object>) tm;
//                    return t.descendingKeySpliterator();
//                }
//            }
//            @SuppressWarnings("unchecked") NavigableSubMap<K,?> sm =
//                    (NavigableSubMap<K,?>) m;
//            return sm.keySpliterator();
//        }
//
//        //上面方法的辅助方法
//        final Spliterator<K> keySpliterator() {
//            return new KeySpliterator<K,V>(this, null, null, 0, -1, 0);
//        }
//
//        //同为上面方法的辅助方法
//        final Spliterator<K> descendingKeySpliterator() {
//            return new DescendingKeySpliterator<K,V>(this, null, null, 0, -2, 0);
//        }
//
//        /**
//         * 分割器的基类.
//         * 迭代从给定的起点开始，继续到但不包括给定的终结点（或者为空）.
//         * 在顶层,对于升序map来说,root节点把map分割成两部分,左侧节点比root节点值小,右侧比root大.
//         * 从此,右子树的分割器使用它的左孩子作为它分割器的原点.左子树同样的分割道理.
//         * 降序map将最后一个节点作为它的起点,且对升序分割原则反向使用.
//         * 这个基类在方向性，或者顶层分割器是否覆盖了整个树这两个方面都是非常规的.
//         * 这也就意味着实际的拆分机制位于子类中.
//         * 一些子类的trySplit方法是相同的(除了返回类型),但并非说这就是好事.
//         *
//         * 目前,子类版本仅适用于整个map(包括利用降序map得到的迭代器).
//         * 其它版本在实现上也是可能的,但是目前并不值得这样做,因为submap需要O(n)的时间来确定它的size.
//         * 这大大限制了自定义Spliterator加速的能力。
//         *
//         * 为了启动初始化,额外构造器使用负数size进行预估:-1代表升序;-2代表降序.
//         */
//        static class TreeMapSpliterator<K,V> {
//            final TreeMap<K,V> tree;
//            TreeMap.Entry<K,V> current; // traverser; initially first node in range
//            TreeMap.Entry<K,V> fence;   // one past last, or null
//            int side;                   // 0: top, -1: is a left split, +1: right
//            int est;                    // size estimate (exact only for top-level)
//            int expectedModCount;       // for CME checks
//
//            TreeMapSpliterator(TreeMap<K,V> tree,
//                               TreeMap.Entry<K,V> origin, TreeMap.Entry<K,V> fence,
//                               int side, int est, int expectedModCount) {
//                this.tree = tree;
//                this.current = origin;
//                this.fence = fence;
//                this.side = side;
//                this.est = est;
//                this.expectedModCount = expectedModCount;
//            }
//
//            final int getEstimate() { // 强制初始化
//                int s; TreeMap<K,V> t;
//                if ((s = est) < 0) {
//                    if ((t = tree) != null) {
//                        current = (s == -1) ? t.getFirstEntry() : t.getLastEntry();
//                        s = est = t.size;
//                        expectedModCount = t.modCount;
//                    }
//                    else
//                        s = est = 0;
//                }
//                return s;
//            }
//
//            public final long estimateSize() {
//                return (long)getEstimate();
//            }
//        }
//
//        //key分割器,扩展自TreeMapSpliterator
//        static final class KeySpliterator<K,V>
//                extends TreeMapSpliterator<K,V>
//                implements Spliterator<K> {
//            KeySpliterator(TreeMap<K,V> tree,
//                           TreeMap.Entry<K,V> origin, TreeMap.Entry<K,V> fence,
//                           int side, int est, int expectedModCount) {
//                super(tree, origin, fence, side, est, expectedModCount);
//            }
//
//            public KeySpliterator<K,V> trySplit() {
//                if (est < 0)
//                    getEstimate(); // force initialization
//                int d = side;
//                TreeMap.Entry<K,V> e = current, f = fence,
//                        s = ((e == null || e == f) ? null :      // empty
//                                (d == 0)              ? tree.root : // was top
//                                        (d >  0)              ? e.right :   // was right
//                                                (d <  0 && f != null) ? f.left :    // was left
//                                                        null);
//                if (s != null && s != e && s != f &&
//                        tree.compare(e.key, s.key) < 0) {        // e not already past s
//                    side = 1;
//                    return new KeySpliterator<>
//                            (tree, e, current = s, -1, est >>>= 1, expectedModCount);
//                }
//                return null;
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super K> action) {
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                TreeMap.Entry<K,V> f = fence, e, p, pl;
//                if ((e = current) != null && e != f) {
//                    current = f; // exhaust
//                    do {
//                        action.accept(e.key);
//                        if ((p = e.right) != null) {
//                            while ((pl = p.left) != null)
//                                p = pl;
//                        }
//                        else {
//                            while ((p = e.parent) != null && e == p.right)
//                                e = p;
//                        }
//                    } while ((e = p) != null && e != f);
//                    if (tree.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
//                TreeMap.Entry<K,V> e;
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                if ((e = current) == null || e == fence)
//                    return false;
//                current = successor(e);
//                action.accept(e.key);
//                if (tree.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//
//            public int characteristics() {
//                return (side == 0 ? Spliterator.SIZED : 0) |
//                        Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;
//            }
//
//            public final Comparator<? super K>  getComparator() {
//                return tree.comparator;
//            }
//
//        }
//
//        //降序key分割器
//        static final class DescendingKeySpliterator<K,V>
//                extends TreeMapSpliterator<K,V>
//                implements Spliterator<K> {
//            DescendingKeySpliterator(TreeMap<K,V> tree,
//                                     TreeMap.Entry<K,V> origin, TreeMap.Entry<K,V> fence,
//                                     int side, int est, int expectedModCount) {
//                super(tree, origin, fence, side, est, expectedModCount);
//            }
//
//            public DescendingKeySpliterator<K,V> trySplit() {
//                if (est < 0)
//                    getEstimate(); // force initialization
//                int d = side;
//                TreeMap.Entry<K,V> e = current, f = fence,
//                        s = ((e == null || e == f) ? null :      // empty
//                                (d == 0)              ? tree.root : // was top
//                                        (d <  0)              ? e.left :    // was left
//                                                (d >  0 && f != null) ? f.right :   // was right
//                                                        null);
//                if (s != null && s != e && s != f &&
//                        tree.compare(e.key, s.key) > 0) {       // e not already past s
//                    side = 1;
//                    return new DescendingKeySpliterator<>
//                            (tree, e, current = s, -1, est >>>= 1, expectedModCount);
//                }
//                return null;
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super K> action) {
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                TreeMap.Entry<K,V> f = fence, e, p, pr;
//                if ((e = current) != null && e != f) {
//                    current = f; // exhaust
//                    do {
//                        action.accept(e.key);
//                        if ((p = e.left) != null) {
//                            while ((pr = p.right) != null)
//                                p = pr;
//                        }
//                        else {
//                            while ((p = e.parent) != null && e == p.left)
//                                e = p;
//                        }
//                    } while ((e = p) != null && e != f);
//                    if (tree.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(java.util.function.Consumer<? super K> action) {
//                TreeMap.Entry<K,V> e;
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                if ((e = current) == null || e == fence)
//                    return false;
//                current = predecessor(e);
//                action.accept(e.key);
//                if (tree.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//
//            public int characteristics() {
//                return (side == 0 ? Spliterator.SIZED : 0) |
//                        Spliterator.DISTINCT | Spliterator.ORDERED;
//            }
//        }
//
//        //value分割器
//        static final class ValueSpliterator<K,V>
//                extends TreeMapSpliterator<K,V>
//                implements Spliterator<V> {
//            ValueSpliterator(TreeMap<K,V> tree,
//                             TreeMap.Entry<K,V> origin, TreeMap.Entry<K,V> fence,
//                             int side, int est, int expectedModCount) {
//                super(tree, origin, fence, side, est, expectedModCount);
//            }
//
//            public ValueSpliterator<K,V> trySplit() {
//                if (est < 0)
//                    getEstimate(); // force initialization
//                int d = side;
//                TreeMap.Entry<K,V> e = current, f = fence,
//                        s = ((e == null || e == f) ? null :      // empty
//                                (d == 0)              ? tree.root : // was top
//                                        (d >  0)              ? e.right :   // was right
//                                                (d <  0 && f != null) ? f.left :    // was left
//                                                        null);
//                if (s != null && s != e && s != f &&
//                        tree.compare(e.key, s.key) < 0) {        // e not already past s
//                    side = 1;
//                    return new ValueSpliterator<>
//                            (tree, e, current = s, -1, est >>>= 1, expectedModCount);
//                }
//                return null;
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super V> action) {
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                TreeMap.Entry<K,V> f = fence, e, p, pl;
//                if ((e = current) != null && e != f) {
//                    current = f; // exhaust
//                    do {
//                        action.accept(e.value);
//                        if ((p = e.right) != null) {
//                            while ((pl = p.left) != null)
//                                p = pl;
//                        }
//                        else {
//                            while ((p = e.parent) != null && e == p.right)
//                                e = p;
//                        }
//                    } while ((e = p) != null && e != f);
//                    if (tree.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(java.util.function.Consumer<? super V> action) {
//                TreeMap.Entry<K,V> e;
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                if ((e = current) == null || e == fence)
//                    return false;
//                current = successor(e);
//                action.accept(e.value);
//                if (tree.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//
//            public int characteristics() {
//                return (side == 0 ? Spliterator.SIZED : 0) | Spliterator.ORDERED;
//            }
//        }
//
//        //entry分割器
//        static final class EntrySpliterator<K,V>
//                extends TreeMapSpliterator<K,V>
//                implements Spliterator<Map.Entry<K,V>> {
//            EntrySpliterator(TreeMap<K,V> tree,
//                             TreeMap.Entry<K,V> origin, TreeMap.Entry<K,V> fence,
//                             int side, int est, int expectedModCount) {
//                super(tree, origin, fence, side, est, expectedModCount);
//            }
//
//            public EntrySpliterator<K,V> trySplit() {
//                if (est < 0)
//                    getEstimate(); // force initialization
//                int d = side;
//                TreeMap.Entry<K,V> e = current, f = fence,
//                        s = ((e == null || e == f) ? null :      // empty
//                                (d == 0)              ? tree.root : // was top
//                                        (d >  0)              ? e.right :   // was right
//                                                (d <  0 && f != null) ? f.left :    // was left
//                                                        null);
//                if (s != null && s != e && s != f &&
//                        tree.compare(e.key, s.key) < 0) {        // e not already past s
//                    side = 1;
//                    return new EntrySpliterator<>
//                            (tree, e, current = s, -1, est >>>= 1, expectedModCount);
//                }
//                return null;
//            }
//
//            public void forEachRemaining(java.util.function.Consumer<? super Map.Entry<K, V>> action) {
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                TreeMap.Entry<K,V> f = fence, e, p, pl;
//                if ((e = current) != null && e != f) {
//                    current = f; // exhaust
//                    do {
//                        action.accept(e);
//                        if ((p = e.right) != null) {
//                            while ((pl = p.left) != null)
//                                p = pl;
//                        }
//                        else {
//                            while ((p = e.parent) != null && e == p.right)
//                                e = p;
//                        }
//                    } while ((e = p) != null && e != f);
//                    if (tree.modCount != expectedModCount)
//                        throw new ConcurrentModificationException();
//                }
//            }
//
//            public boolean tryAdvance(Consumer<? super Map.Entry<K,V>> action) {
//                TreeMap.Entry<K,V> e;
//                if (action == null)
//                    throw new NullPointerException();
//                if (est < 0)
//                    getEstimate(); // force initialization
//                if ((e = current) == null || e == fence)
//                    return false;
//                current = successor(e);
//                action.accept(e);
//                if (tree.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//
//            public int characteristics() {
//                return (side == 0 ? Spliterator.SIZED : 0) |
//                        Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;
//            }
//
//            @Override
//            public Comparator<Map.Entry<K, V>> getComparator() {
//                // Adapt or create a key-based comparator
//                if (tree.comparator != null) {
//                    return Map.Entry.comparingByKey(tree.comparator);
//                }
//                else {
//                    return (Comparator<Map.Entry<K, V>> & Serializable) (e1, e2) -> {
//                        @SuppressWarnings("unchecked")
//                        java.lang.Comparable<? super K> k1 = (java.lang.Comparable<? super K>) e1.getKey();
//                        return k1.compareTo(e2.getKey());
//                    };
//                }
//            }
//        }
//}
