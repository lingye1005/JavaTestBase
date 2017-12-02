//package sourcecode.analysis;
//
//import java.util.*;
//
///**
// * Created by caoxiaohong on 17/11/10 19:23.
// */
//
///**
// * This class provides a skeletal implementation of the <tt>Map</tt>
// * interface, to minimize the effort required to implement this interface.
// *
// * 这个类提供了实现Map接口的类的基本方法,从而尽量减少了实现这个接口所需的工作量.
// *
// * <p>To implement an unmodifiable map, the programmer needs only to extend this
// * class and provide an implementation for the <tt>entrySet</tt> method, which
// * returns a set-view of the map's mappings.  Typically, the returned set
// * will, in turn, be implemented atop <tt>AbstractSet</tt>.  This set should
// * not support the <tt>add</tt> or <tt>remove</tt> methods, and its iterator
// * should not support the <tt>remove</tt> method.
// *
// * 为了实现一个不可修改的map,程序员仅仅需要继承这个类,并且给出entrySet方法的实现即可.entrySet方法提供了map映射的一个集合视图.
// * 一般来说,返回的set集合将依次在AbstractSet上依次执行.这个集合不支持add或者remove方法,并且它的迭代器也不支持remove方法.
// *
// *
// * <p>To implement a modifiable map, the programmer must additionally override
// * this class's <tt>put</tt> method (which otherwise throws an
// * <tt>UnsupportedOperationException</tt>), and the iterator returned by
// * <tt>entrySet().iterator()</tt> must additionally implement its
// * <tt>remove</tt> method.
// *
// * 为了实现一个可以修改的map,程序员必须复写这个类的put方法(否则,修改map时会抛出UnsupportedOperationException异常),并且通过
// * entrySet().iterator()方法返回的迭代器也必须额外实现其remove方法.
// *
// * <p>The programmer should generally provide a void (no argument) and map
// * constructor, as per the recommendation in the <tt>Map</tt> interface
// * specification.
// *
// * 根据map接口中的建议,程序员一般应该提供一个无参构造函数.
// *
// * <p>The documentation for each non-abstract method in this class describes its
// * implementation in detail.  Each of these methods may be overridden if the
// * map being implemented admits a more efficient implementation.
// *
// * 这个类里面的每一个非抽象方法给出的文档都详细的描述了它的实现.
// * 如果map想要更高效的工作,那么这里面给出的方法都可能被复习.
// *
// * <p>This class is a member of the
// * <a href="{@docRoot}/../technotes/guides/collections/index.html">
// * Java Collections Framework</a>.
// *
// * @param <K> the type of keys maintained by this map
// * @param <V> the type of mapped values
// *
// * @author  Josh Bloch
// * @author  Neal Gafter
// * @see Map
// * @see Collection
// * @since 1.2
// */
//
///**
// * 类名分析:
// * 只是实现了map接口.
// * 并且这是一个抽象类.
// * @param <K>
// * @param <V>
// */
//
//public abstract class AbstractMap<K,V> implements Map<K,V> {
//    /**
//     * Sole constructor.  (For invocation by subclass constructors, typically
//     * implicit.)
//     * 唯一的构造函数(通常作为子类的构造函数,被隐式调用)
//     */
//    protected AbstractMap() {
//    }
//
//    // Query Operations,查询操作
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation returns <tt>entrySet().size()</tt>.
//     * 返回entrySet().size()的值.也就是返回条目的个数
//     */
//    public int size() {
//        return entrySet().size();
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation returns <tt>size() == 0</tt>.
//     *
//     *
//     */
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation iterates over <tt>entrySet()</tt> searching
//     * for an entry with the specified value.  If such an entry is found,
//     * <tt>true</tt> is returned.  If the iteration terminates without
//     * finding such an entry, <tt>false</tt> is returned.  Note that this
//     * implementation requires linear time in the size of the map.
//     *
//     *  在基于entrySet()的迭代器中查找,有特定值的条目.如果这样的条目被找到,方法返回true.
//     *  如果迭代器遍历完成后,依旧没有找到这样的一个条目,返回false.
//     *  注意:这一操作需要map大小的线性时间.
//     *
//     *  注意:这一方法:也区分了value是否为null的情况,来讨论的.
//     *
//     * @throws ClassCastException   {@inheritDoc}
//     * @throws NullPointerException {@inheritDoc}
//     */
//    public boolean containsValue(Object value) {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        if (value==null) {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (e.getValue()==null)
//                    return true;
//            }
//        } else {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (value.equals(e.getValue()))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation iterates over <tt>entrySet()</tt> searching
//     * for an entry with the specified key.  If such an entry is found,
//     * <tt>true</tt> is returned.  If the iteration terminates without
//     * finding such an entry, <tt>false</tt> is returned.  Note that this
//     * implementation requires linear time in the size of the map; many
//     * implementations will override this method.
//     *
//     * 在基于entrySet()的迭代器中查找:指定key的条目.如果这样的条目被找到,则方法返回true;
//     * 如果迭代器遍历完成后,依旧没有找到这样的条目,则返回false.
//     * 注意:这一方法的完成时间和map存储条目的个数成正比;许多map的实现类都覆写来这个方法.(比如HashMap就在此方法中通过
//     * 调用getEntry(Object key)方法来完成这一功能.)
//     *
//     * @throws ClassCastException   {@inheritDoc}
//     * @throws NullPointerException {@inheritDoc}
//     */
//    public boolean containsKey(Object key) {
//        Iterator<Map.Entry<K,V>> i = entrySet().iterator();
//        if (key==null) {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (e.getKey()==null)
//                    return true;
//            }
//        } else {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (key.equals(e.getKey()))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation iterates over <tt>entrySet()</tt> searching
//     * for an entry with the specified key.  If such an entry is found,
//     * the entry's value is returned.  If the iteration terminates without
//     * finding such an entry, <tt>null</tt> is returned.  Note that this
//     * implementation requires linear time in the size of the map; many
//     * implementations will override this method.
//     *
//     * 这是一个基于entrySet()得到的迭代器来查找包含特定key的条目.
//     * 如果这样的条目被找到,则方法返回这一条目的value值.如果没有找到,则返回null.
//     * 注意:这一方法的完成时间是和map包含的条目个数线性关系的;
//     * 许多map实现类都覆写了这一方法.
//     *
//     * @throws ClassCastException            {@inheritDoc}
//     * @throws NullPointerException          {@inheritDoc}
//     */
//    public V get(Object key) {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        if (key==null) {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (e.getKey()==null)
//                    return e.getValue();
//            }
//        } else {
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (key.equals(e.getKey()))
//                    return e.getValue();
//            }
//        }
//        return null;
//    }
//
//
//    // Modification Operations ,修改操作
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation always throws an
//     * <tt>UnsupportedOperationException</tt>.
//     *
//     * put操作总是会抛出异常UnsupportedOperationException.(因为这个是抽象类呀,不可更改其结构,自然会put时候抛出"操作不支持"异常)
//     * @throws UnsupportedOperationException {@inheritDoc}
//     * @throws ClassCastException            {@inheritDoc}
//     * @throws NullPointerException          {@inheritDoc}
//     * @throws IllegalArgumentException      {@inheritDoc}
//     */
//    public V put(K key, V value) {
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation iterates over <tt>entrySet()</tt> searching for an
//     * entry with the specified key.  If such an entry is found, its value is
//     * obtained with its <tt>getValue</tt> operation, the entry is removed
//     * from the collection (and the backing map) with the iterator's
//     * <tt>remove</tt> operation, and the saved value is returned.  If the
//     * iteration terminates without finding such an entry, <tt>null</tt> is
//     * returned.  Note that this implementation requires linear time in the
//     * size of the map; many implementations will override this method.
//     *
//     * <p>Note that this implementation throws an
//     * <tt>UnsupportedOperationException</tt> if the <tt>entrySet</tt>
//     * iterator does not support the <tt>remove</tt> method and this map
//     * contains a mapping for the specified key.
//     *
//     * 在基于entrySet得到的迭代器基础上,查找一个包含指定key的条目.
//     * 如果这样的条目被找到,首先获取对应的value值,然后通过迭代器的remove方法删除这一条目,然后返回刚刚获取的value值.
//     * 如果没有找到这样的条目,返回null.
//     * 注意:这一操作的完成时间和map存储条目的个数成线性正相关;许多map的实现类会覆写这一方法.
//     *
//     * 注意:如果基于entrySet得到的迭代器不支持remove方法,并且map还包含指定key的条目,则会抛出UnsupportedOperationException异常.
//     *
//     * @throws UnsupportedOperationException {@inheritDoc}
//     * @throws ClassCastException            {@inheritDoc}
//     * @throws NullPointerException          {@inheritDoc}
//     */
//    public V remove(Object key) {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        Entry<K,V> correctEntry = null;
//        if (key==null) {
//            while (correctEntry==null && i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (e.getKey()==null)
//                    correctEntry = e;
//            }
//        } else {
//            while (correctEntry==null && i.hasNext()) {
//                Entry<K,V> e = i.next();
//                if (key.equals(e.getKey()))
//                    correctEntry = e;
//            }
//        }
//
//        V oldValue = null;
//        if (correctEntry !=null) {
//            oldValue = correctEntry.getValue();
//            i.remove();
//        }
//        return oldValue;
//    }
//
//
//    // Bulk Operations ,块操作
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation iterates over the specified map's
//     * <tt>entrySet()</tt> collection, and calls this map's <tt>put</tt>
//     * operation once for each entry returned by the iteration.
//     *
//     * <p>Note that this implementation throws an
//     * <tt>UnsupportedOperationException</tt> if this map does not support
//     * the <tt>put</tt> operation and the specified map is nonempty.
//     *
//     * 这一方法的实现基于entrySet方法获得的条目的迭代,并且迭代过程中,对于每一个条目,会对其调用map的put方法.
//     *
//     * 注意:如果map不支持put操作并且指定的参数map不为空,则这一操作会抛出异常UnsupportedOperationException
//     *
//     * @throws UnsupportedOperationException {@inheritDoc}
//     * @throws ClassCastException            {@inheritDoc}
//     * @throws NullPointerException          {@inheritDoc}
//     * @throws IllegalArgumentException      {@inheritDoc}
//     */
//    public void putAll(Map<? extends K, ? extends V> m) {
//        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
//            put(e.getKey(), e.getValue());
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation calls <tt>entrySet().clear()</tt>.
//     *
//     * <p>Note that this implementation throws an
//     * <tt>UnsupportedOperationException</tt> if the <tt>entrySet</tt>
//     * does not support the <tt>clear</tt> operation.
//     *
//     * 这一操作会调用entrySet()方法,如果entrySet不支持clear操作,则这一操作会抛出异常UnsupportedOperationException
//     *
//     *
//     * @throws UnsupportedOperationException {@inheritDoc}
//     */
//    public void clear() {
//        entrySet().clear();
//    }
//
//
//    // Views, 视图
//
//    /**
//     * Each of these fields are initialized to contain an instance of the
//     * appropriate view the first time this view is requested.  The views are
//     * stateless, so there's no reason to create more than one of each.
//     *
//     * 当第一次请求获取对应的视图集合时,实例变量keySet和values被初始化为一个适当视图的实例变量.
//     * 获得的这两个视图集合都是无状态的,因此这两个视图分别都只创建一个就足够了.(因为map被修改后,这两个集合都得改变.所以在内存中这两个
//     * 实例变量都存在一个就可以了,如果有多个线程同时修改同一个map,而每个map在自己的缓存中都有一个内存keyset或者values的拷贝,那么
//     * 这里会有一个线程同步的问题,就是如果某个线程改了map的结构,它会将自己的修改先更改进内存的keyset或者values集合中,同时如果其它线程
//     * 并提醒其它线程你本地缓存的keyset或者values已经失效了,如果使用需要再重新从内存中重新拷贝一份出来,继续使用.所以说,针对某个实现
//     * map接口的类,在整个内存中,只存储一份keyset或者values的值即可.)
//     *
//     *  非常值得注意的2点:非常重要
//     *  (1)keyset和values变量都是被transient修饰的,所以如果对应的map实现类实现序列化接口是Serializable,那么这两个字段就是不能被
//     *  序列化的.
//     *  (2)这两个变量被volatile修饰,则是线程可见的,也就是如果有线程修改了map的结构,其它线程可以得到最新的keyset集合和最新的value值.
//     *
//     */
//    transient volatile Set<K> keySet = null;
//    transient volatile Collection<V> values = null;
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation returns a set that subclasses {@link AbstractSet}.
//     * The subclass's iterator method returns a "wrapper object" over this
//     * map's <tt>entrySet()</tt> iterator.  The <tt>size</tt> method
//     * delegates to this map's <tt>size</tt> method and the
//     * <tt>contains</tt> method delegates to this map's
//     * <tt>containsKey</tt> method.
//     *
//     * <p>The set is created the first time this method is called,
//     * and returned in response to all subsequent calls.  No synchronization
//     * is performed, so there is a slight chance that multiple calls to this
//     * method will not all return the same set.
//     *
//     * 这一方法会返回一个类型为AbstractSet的内部类.
//     * 这个内部类的迭代器方法会返回一个基于本map的entrySet()迭代器的一个包装对象.
//     * 内部类的size方法实际是调用了外部类map的size方法;同样的,contains方法也是调用外部类的containsKey方法.
//     *
//     * 这个方法再被调用的第一次,会生成一个对应的set集合.并且对于随后的调用返回相同的结果集合.
//     * 由于这个方法是非线程安全的,所以对这个方法的多次调用,可能出现某一次的返回集合和之前的返回结果集合不一样(因为可能map结构
//     * 被修改了嘛,这都是有transient关键字决定的).
//     *
//     *
//     */
//    public Set<K> keySet() {
//        if (keySet == null) {
//            keySet = new AbstractSet<K>() {
//                public Iterator<K> iterator() {
//                    return new Iterator<K>() {
//                        private Iterator<Entry<K,V>> i = entrySet().iterator();
//
//                        public boolean hasNext() {
//                            return i.hasNext();
//                        }
//
//                        public K next() {
//                            return i.next().getKey();
//                        }
//
//                        public void remove() {
//                            i.remove();
//                        }
//                    };
//                }
//
//                public int size() {
//                    return AbstractMap.this.size();
//                }
//
//                public boolean isEmpty() {
//                    return AbstractMap.this.isEmpty();
//                }
//
//                public void clear() {
//                    AbstractMap.this.clear();
//                }
//
//                public boolean contains(Object k) {
//                    return AbstractMap.this.containsKey(k);
//                }
//            };
//        }
//        return keySet;
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>This implementation returns a collection that subclasses {@link
//     * AbstractCollection}.  The subclass's iterator method returns a
//     * "wrapper object" over this map's <tt>entrySet()</tt> iterator.
//     * The <tt>size</tt> method delegates to this map's <tt>size</tt>
//     * method and the <tt>contains</tt> method delegates to this map's
//     * <tt>containsValue</tt> method.
//     *
//     * <p>The collection is created the first time this method is called, and
//     * returned in response to all subsequent calls.  No synchronization is
//     * performed, so there is a slight chance that multiple calls to this
//     * method will not all return the same collection.
//     *
//     * values()方法返回一个内部类AbstractCollection实例.
//     * 这个内部类的迭代器方法是基于外部类AbstractMap的 entrySet()方法得到的一个包装对象.
//     * 这个内部类的size方法也是调用了外部类AbstractMap的size方法;contains方法也是调用外部类AbstractMap的containsValue
//     * 方法.
//     *
//     * 在本方法被调用的第一次就返回一个集合Collection实例.并且对于后续对本方法的调用,也会返回同样的结果.
//     * 然而本方法是非线程安全的,所以有可能出现多这个方法的多个调用会返回不同的结果(如果map未改变,多个调用的返回结果一定是相同的,
//     * 但是如果map发生了改变,则返回结果就和上一次不同了).
//     *
//     *
//     */
//    public Collection<V> values() {
//        if (values == null) {
//            values = new AbstractCollection<V>() {
//                public Iterator<V> iterator() {
//                    return new Iterator<V>() {
//                        private Iterator<Entry<K,V>> i = entrySet().iterator();
//
//                        public boolean hasNext() {
//                            return i.hasNext();
//                        }
//
//                        public V next() {
//                            return i.next().getValue();
//                        }
//
//                        public void remove() {
//                            i.remove();
//                        }
//                    };
//                }
//
//                public int size() {
//                    return AbstractMap.this.size();
//                }
//
//                public boolean isEmpty() {
//                    return AbstractMap.this.isEmpty();
//                }
//
//                public void clear() {
//                    AbstractMap.this.clear();
//                }
//
//                public boolean contains(Object v) {
//                    return AbstractMap.this.containsValue(v);
//                }
//            };
//        }
//        return values;
//    }
//
//    public abstract Set<Entry<K,V>> entrySet();
//
//
//    // Comparison and hashing ,比较 和 哈希
//
//    /**
//     * Compares the specified object with this map for equality.  Returns
//     * <tt>true</tt> if the given object is also a map and the two maps
//     * represent the same mappings.  More formally, two maps <tt>m1</tt> and
//     * <tt>m2</tt> represent the same mappings if
//     * <tt>m1.entrySet().equals(m2.entrySet())</tt>.  This ensures that the
//     * <tt>equals</tt> method works properly across different implementations
//     * of the <tt>Map</tt> interface.
//     *
//     * <p>This implementation first checks if the specified object is this map;
//     * if so it returns <tt>true</tt>.  Then, it checks if the specified
//     * object is a map whose size is identical to the size of this map; if
//     * not, it returns <tt>false</tt>.  If so, it iterates over this map's
//     * <tt>entrySet</tt> collection, and checks that the specified map
//     * contains each mapping that this map contains.  If the specified map
//     * fails to contain such a mapping, <tt>false</tt> is returned.  If the
//     * iteration completes, <tt>true</tt> is returned.
//     *
//     * 将给定map和当前map实例进行比较.
//     * 如果给定的对象也是一个map,并且和当前map实例有相同的映射,则返回true.
//     * 关于相同映射的定义:如果两个map各自的entrySet()返回结果完全一致,也就是m1.entrySet().equals(m2.entrySet()结果返回true,
//     * 那么这两个map肯定是拥有一样的映射.
//     * 如果给定map和当前map实例的映射不一致,则equals方法会返回false.
//     *
//     *
//     * @param o object to be compared for equality with this map
//     * @return <tt>true</tt> if the specified object is equal to this map
//     */
//    public boolean equals(Object o) {
//        //如果参数对象o就是当前对象,那就直接返回true
//        if (o == this)
//            return true;
//
//        //如果参数对象o类型不是map类型,返回false
//        if (!(o instanceof Map))
//            return false;
//        Map<K,V> m = (Map<K,V>) o;
//        //如果给定map和当前map的存储的条目个数不同,则肯定返回false.
//        if (m.size() != size())
//            return false;
//
//        try {
//            Iterator<Entry<K,V>> i = entrySet().iterator();//获取当前map的条目迭代器
//            while (i.hasNext()) {
//                Entry<K,V> e = i.next();
//                K key = e.getKey();
//                V value = e.getValue();
//                if (value == null) {
//                    if (!(m.get(key)==null && m.containsKey(key)))//注意:&&的两个条件必须同时存在,才能是true.
//                        return false;
//                } else {
//                    if (!value.equals(m.get(key))) //对两个map的value调用equals方法
//                        return false;
//                }
//            }
//        } catch (ClassCastException unused) {
//            return false;
//        } catch (NullPointerException unused) {
//            return false;
//        }
//
//        return true;//迭代结束,返回true.
//    }
//
//    /**
//     * Returns the hash code value for this map.  The hash code of a map is
//     * defined to be the sum of the hash codes of each entry in the map's
//     * <tt>entrySet()</tt> view.  This ensures that <tt>m1.equals(m2)</tt>
//     * implies that <tt>m1.hashCode()==m2.hashCode()</tt> for any two maps
//     * <tt>m1</tt> and <tt>m2</tt>, as required by the general contract of
//     * {@link Object#hashCode}.
//     *
//     * <p>This implementation iterates over <tt>entrySet()</tt>, calling
//     * {@link Map.Entry#hashCode hashCode()} on each element (entry) in the
//     * set, and adding up the results.
//     *
//     * 返回当前map实例的哈希值.
//     * 哈希值定义:map哈希值=map存储的所有条目的对应的哈希值的和.
//     * 通过哈希值的定义可以知道:两个map的的equals方法返回true,那么它们的哈希值一定相等.
//     * 而这种定义也符合Object类对哈希值的要求.
//     *
//     * @return the hash code value for this map
//     * @see Map.Entry#hashCode()
//     * @see Object#equals(Object)
//     * @see Set#equals(Object)
//     */
//    public int hashCode() {
//        int h = 0;
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        while (i.hasNext())
//            h += i.next().hashCode();
//        return h;
//    }
//
//    /**
//     * Returns a string representation of this map.  The string representation
//     * consists of a list of key-value mappings in the order returned by the
//     * map's <tt>entrySet</tt> view's iterator, enclosed in braces
//     * (<tt>"{}"</tt>).  Adjacent mappings are separated by the characters
//     * <tt>", "</tt> (comma and space).  Each key-value mapping is rendered as
//     * the key followed by an equals sign (<tt>"="</tt>) followed by the
//     * associated value.  Keys and values are converted to strings as by
//     * {@link String#valueOf(Object)}.
//     *
//     * 返回map的字符串表达式.
//     * 字符串的格式为:由一对{}括起来,大括号里面是key=value的表达式.并且各个表达式之间由逗号和空格隔开.
//     * 而这一拼接过程:基于entrySet().iterator()这一迭代器.
//     *
//     * 如果map中没有映射,则返回{}
//     * 如果map中有映射,则返回字符串的格式类似于{1=33, 2=22, ,...}
//     * 注意:如果map的映射中使用了map本身作为了key,那么字符串格式就是{(this Map)=33, 2=22, ,...}
//     *
//     *
//     * @return a string representation of this map
//     */
//    public String toString() {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        if (! i.hasNext())
//            return "{}";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('{');
//        for (;;) {
//            Entry<K,V> e = i.next();
//            K key = e.getKey();
//            V value = e.getValue();
//            sb.append(key   == this ? "(this Map)" : key);
//            sb.append('=');
//            sb.append(value == this ? "(this Map)" : value);
//            if (! i.hasNext())
//                return sb.append('}').toString();
//            sb.append(',').append(' ');
//        }
//    }
//
//    /**
//     * Returns a shallow copy of this <tt>AbstractMap</tt> instance: the keys
//     * and values themselves are not cloned.
//     *
//     * 此方法会返回AbstractMap实例的一个浅拷贝:key和value不会被拷贝,全为null.
//     *
//     * @return a shallow copy of this map
//     */
//    protected Object clone() throws CloneNotSupportedException {
//        AbstractMap<K,V> result = (AbstractMap<K,V>)super.clone();
//        result.keySet = null;
//        result.values = null;
//        return result;
//    }
//
//    /**
//     * Utility method for SimpleEntry and SimpleImmutableEntry.
//     * Test for equality, checking for nulls.
//     * 这个方法对SimpleEntry和SimpleImmutableEntry是比较实用的.
//     * 使用这个方法可用测试两个对象是否相等,或者是否都为空值.
//     */
//    private static boolean eq(Object o1, Object o2) {
//        return o1 == null ? o2 == null : o1.equals(o2);
//    }
//
//    // Implementation Note: SimpleEntry and SimpleImmutableEntry
//    // are distinct unrelated classes, even though they share
//    // some code. Since you can't add or subtract final-ness
//    // of a field in a subclass, they can't share representations,
//    // and the amount of duplicated code is too small to warrant
//    // exposing a common abstract class.
//    //注意:SimpleEntry 和 SimpleImmutableEntry是两个不同的彼此不相关的类,尽管他们有一些代码是共享的.
//    //接下来就要介绍这两个类了
//
//    /**
//     * An Entry maintaining a key and a value.  The value may be
//     * changed using the <tt>setValue</tt> method.  This class
//     * facilitates the process of building custom map
//     * implementations. For example, it may be convenient to return
//     * arrays of <tt>SimpleEntry</tt> instances in method
//     * <tt>Map.entrySet().toArray</tt>.
//     *
//     * 一个条目包含了一个key和一个value.
//     * 调用条目的setValue方法可用更改value的值.
//     * 这个类有助于构建自定义的map.
//     * 比如:调用SimpleEntry实例的Map.entrySet().toArray方法可用返回一个数组.
//     *
//     *
//     * 类名分析:
//     * 实现接口:
//     * (1)Entry接口:这是Map接口内的接口.
//     *        包含5个方法:
//     *        getKey  &  getValue  &  setValue  &  equals  &  hashCode
//     * (2)Serializable接口:可序列化和反序列化.
//     *
//     * 显然,除去3个成员变量,2个类的构造函数,还有就是toString方法,其它都是对接口Entry的实现方法.此外类中再无其它内容.
//     *
//     * @since 1.6
//     */
//    public static class SimpleEntry<K,V>
//            implements Entry<K,V>, java.io.Serializable
//    {
//        private static final long serialVersionUID = -8499721149061103585L;//序列号:用于序列化
//
//        private final K key;//条目的key,final表示不可更
//        private V value;//条目的value,所有说本条目中的value是可更改的
//
//        /**
//         * Creates an entry representing a mapping from the specified
//         * key to the specified value.
//         *
//         * 根据给定的key和value,为当前静态类的变量key和value赋值
//         *
//         * @param key the key represented by this entry
//         * @param value the value represented by this entry
//         */
//        public SimpleEntry(K key, V value) {
//            this.key   = key;
//            this.value = value;
//        }
//
//        /**
//         * Creates an entry representing the same mapping as the
//         * specified entry.
//         *
//         * 根据指定条目,为当前静态类的变量key和value赋值
//         *
//         * @param entry the entry to copy
//         */
//        public SimpleEntry(Entry<? extends K, ? extends V> entry) {
//            this.key   = entry.getKey();
//            this.value = entry.getValue();
//        }
//
//        /**
//         * Returns the key corresponding to this entry.
//         * 返回本类的实例变量key
//         *
//         * @return the key corresponding to this entry
//         */
//        public K getKey() {
//            return key;
//        }
//
//        /**
//         * Returns the value corresponding to this entry.
//         *
//         * 返回当前静态类的实例变量value值
//         *
//         * @return the value corresponding to this entry
//         */
//        public V getValue() {
//            return value;
//        }
//
//        /**
//         * Replaces the value corresponding to this entry with the specified
//         * value.
//         *
//         * 将当前条目中的value值用新值进行替换.
//         *
//         * @param value new value to be stored in this entry
//         * @return the old value corresponding to the entry
//         */
//        public V setValue(V value) {
//            V oldValue = this.value;
//            this.value = value;
//            return oldValue;
//        }
//
//        /**
//         * Compares the specified object with this entry for equality.
//         * Returns {@code true} if the given object is also a map entry and
//         * the two entries represent the same mapping.  More formally, two
//         * entries {@code e1} and {@code e2} represent the same mapping
//         * if<pre>
//         *   (e1.getKey()==null ?
//         *    e2.getKey()==null :
//         *    e1.getKey().equals(e2.getKey()))
//         *   &amp;&amp;
//         *   (e1.getValue()==null ?
//         *    e2.getValue()==null :
//         *    e1.getValue().equals(e2.getValue()))</pre>
//         * This ensures that the {@code equals} method works properly across
//         * different implementations of the {@code Map.Entry} interface.
//         *
//         * 判定一个对象和当前的条目是否相等.
//         * 首先判定参数类型是否为Map.Entry,如果不是,返回false,如果是,继续向下判定;
//         * 然后如果两个条目的映射一致.如果映射一致,则返回true,否则false.
//         * 关于相同映射的规定:调用了eq方法,分别比较了两个对象的key和value.
//         *
//         *
//         * @param o object to be compared for equality with this map entry
//         * @return {@code true} if the specified object is equal to this map
//         *         entry
//         * @see    #hashCode
//         */
//        public boolean equals(Object o) {
//            //首先,比较的两者类型要一致
//            if (!(o instanceof Map.Entry))
//                return false;
//            Map.Entry e = (Map.Entry)o;
//            return eq(key, e.getKey()) && eq(value, e.getValue());
//        }
//
//        /**
//         * Returns the hash code value for this map entry.  The hash code
//         * of a map entry {@code e} is defined to be: <pre>
//         *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
//         *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
//         * This ensures that {@code e1.equals(e2)} implies that
//         * {@code e1.hashCode()==e2.hashCode()} for any two Entries
//         * {@code e1} and {@code e2}, as required by the general
//         * contract of {@link Object#hashCode}.
//         *
//         * 返回当前map条目的哈希值.
//         * 哈希值定义方式:下面代码中就只有这2行,没有其它的,所有不再写出来.
//         * 注意一点就是:如果条目的key和value都是null,那么哈希值是0和0的异或值,为0.
//         *
//         * @return the hash code value for this map entry
//         * @see    #equals
//         */
//        public int hashCode() {
//            return (key   == null ? 0 :   key.hashCode()) ^
//                    (value == null ? 0 : value.hashCode());
//        }
//
//        /**
//         * Returns a String representation of this map entry.  This
//         * implementation returns the string representation of this
//         * entry's key followed by the equals character ("<tt>=</tt>")
//         * followed by the string representation of this entry's value.
//         *
//         * 返回map这个条目的string表达方式.
//         * 表达方式为:key=value
//         *
//         * @return a String representation of this map entry
//         */
//        public String toString() {
//            return key + "=" + value;
//        }
//
//    }
//
//    /**
//     * An Entry maintaining an immutable key and value.  This class
//     * does not support method <tt>setValue</tt>.  This class may be
//     * convenient in methods that return thread-safe snapshots of
//     * key-value mappings.
//     *
//     * 这个类保存了一个不可更改key和value的条目.
//     * 这个类不支持setValue方法.
//     * 因此这个类对于一些方法是比较方便的,比如:用于返回线程安全的键值映射的快照的方法
//     *
//     *
//     * 类名分析:
//     * 静态内部类
//     * 实现接口:
//     * (1)Entry:这是Map接口内的接口.
//     *          包含5个方法:
//     *          getKey  &  getValue  &  setValue  &  equals  &  hashCode
//     * (2)Serializable:表示当前静态类SimpleImmutableEntry可序列化和反序列化.
//     *
//     *  显然,类中除去3个常量,2个构造函数,还有toString方法外,其它方法都是对Entry接口的实现.
//     *
//     * @since 1.6
//     */
//    public static class SimpleImmutableEntry<K,V>
//            implements Entry<K,V>, java.io.Serializable
//    {
//        private static final long serialVersionUID = 7138329143949025153L; //用于序列化和反序列化
//
//        private final K key;//体现了不可更改key的思想
//        private final V value;//体现了不可更value的思想
//
//        /**
//         * Creates an entry representing a mapping from the specified
//         * key to the specified value.
//         *
//         * 显然,这是一个类的构造函数,完成了为key和value的赋值.
//         *
//         * @param key the key represented by this entry
//         * @param value the value represented by this entry
//         */
//        public SimpleImmutableEntry(K key, V value) {
//            this.key   = key;
//            this.value = value;
//        }
//
//        /**
//         * Creates an entry representing the same mapping as the
//         * specified entry.
//         *
//         * 这又是一个构造函数,只是这个和上面不一样的地方:参数变成了一个条目而已.
//         *
//         * @param entry the entry to copy
//         */
//        public SimpleImmutableEntry(Entry<? extends K, ? extends V> entry) {
//            this.key   = entry.getKey();
//            this.value = entry.getValue();
//        }
//
//        /**
//         * Returns the key corresponding to this entry.
//         *
//         * 返回本类的常量key
//         *
//         * @return the key corresponding to this entry
//         */
//        public K getKey() {
//            return key;
//        }
//
//        /**
//         * Returns the value corresponding to this entry.
//         *
//         * 返回本类中的常量value
//         *
//         * @return the value corresponding to this entry
//         */
//        public V getValue() {
//            return value;
//        }
//
//        /**
//         * Replaces the value corresponding to this entry with the specified
//         * value (optional operation).  This implementation simply throws
//         * <tt>UnsupportedOperationException</tt>, as this class implements
//         * an <i>immutable</i> map entry.
//         *
//         * 用指定值value替换本条目类中的value值.但是但是但是,因为本类中的成员变量value和key是不可以被修改的,
//         * 所有此方法被调用时,会抛出UnsupportedOperationException异常.
//         *
//         * @param value new value to be stored in this entry
//         * @return (Does not return)
//         * @throws UnsupportedOperationException always
//         */
//        public V setValue(V value) {
//            throw new UnsupportedOperationException();
//        }
//
//        /**
//         * Compares the specified object with this entry for equality.
//         * Returns {@code true} if the given object is also a map entry and
//         * the two entries represent the same mapping.  More formally, two
//         * entries {@code e1} and {@code e2} represent the same mapping
//         * if<pre>
//         *   (e1.getKey()==null ?
//         *    e2.getKey()==null :
//         *    e1.getKey().equals(e2.getKey()))
//         *   &amp;&amp;
//         *   (e1.getValue()==null ?
//         *    e2.getValue()==null :
//         *    e1.getValue().equals(e2.getValue()))</pre>
//         * This ensures that the {@code equals} method works properly across
//         * different implementations of the {@code Map.Entry} interface.
//         *
//         * 将指定对象和当前条目类进行比较.
//         * 返回结果为true的标准为:
//         * (1)给定的比较对象类型为entry.
//         * (2)两个entry的映射完全一致.
//         *
//         *
//         * @param o object to be compared for equality with this map entry
//         * @return {@code true} if the specified object is equal to this map
//         *         entry
//         * @see    #hashCode
//         */
//        public boolean equals(Object o) {
//            //比较类型是否一致
//            if (!(o instanceof Map.Entry))
//                return false;
//            //分别比较key和value,只有key和value都一致才能返回true
//            Map.Entry e = (Map.Entry)o;
//            return eq(key, e.getKey()) && eq(value, e.getValue());
//        }
//
//        /**
//         * Returns the hash code value for this map entry.  The hash code
//         * of a map entry {@code e} is defined to be: <pre>
//         *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
//         *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
//         * This ensures that {@code e1.equals(e2)} implies that
//         * {@code e1.hashCode()==e2.hashCode()} for any two Entries
//         * {@code e1} and {@code e2}, as required by the general
//         * contract of {@link Object#hashCode}.
//         *
//         * 返回本条目类的哈希值.
//         * 哈希值定义:哈希值=key的哈希值和value的哈希值做异或运算.
//         * 注意:如果key和value都为0,则返回的哈希值为0.
//         *
//         * @return the hash code value for this map entry
//         * @see    #equals
//         */
//        public int hashCode() {
//            return (key   == null ? 0 :   key.hashCode()) ^
//                    (value == null ? 0 : value.hashCode());
//        }
//
//        /**
//         * Returns a String representation of this map entry.  This
//         * implementation returns the string representation of this
//         * entry's key followed by the equals character ("<tt>=</tt>")
//         * followed by the string representation of this entry's value.
//         *
//         *  返回本条目类的string表达式.
//         *  格式为:key=value
//         *
//         * @return a String representation of this map entry
//         */
//        public String toString() {
//            return key + "=" + value;
//        }
//
//    }
//}
