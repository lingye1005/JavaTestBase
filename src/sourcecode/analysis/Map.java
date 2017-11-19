package sourcecode.analysis;

/**
 * Created by caoxiaohong on 17/11/11 11:44.
 * Map接口分析
 */

import java.util.*;

/**
 * An object that maps keys to values.  A map cannot contain duplicate keys;
 * each key can map to at most one value.
 * Map是一个有键值对映射的对象.map不能包含相同的key,每一个key至多能映射一个value.
 *
 * <p>This interface takes the place of the <tt>Dictionary</tt> class, which
 * was a totally abstract class rather than an interface.
 *
 * 这个接口替代了Dictionary这个类,Dictionary是抽象类而非接口.
 *
 * <p>The <tt>Map</tt> interface provides three <i>collection views</i>, which
 * allow a map's contents to be viewed as a set of keys, collection of values,
 * or set of key-value mappings.  The <i>order</i> of a map is defined as
 * the order in which the iterators on the map's collection views return their
 * elements.  Some map implementations, like the <tt>TreeMap</tt> class, make
 * specific guarantees as to their order; others, like the <tt>HashMap</tt>
 * class, do not.
 *
 * Map接口提供了3个集合视图,包括:keys的set集合; values的集合; key-value的set集合.(注意:values集合不是set类型,因为value可相同)
 * Map返回元素的顺序,取决于:map对应的某个集合视图迭代器的顺序.
 * 一些map的实现,比如TreeMap类,对于map返回元素的顺序有特殊的规定;
 * 其它的map实现类,比如HashMap类,就没有特殊的规定.
 *
 * <p>Note: great care must be exercised if mutable objects are used as map
 * keys.  The behavior of a map is not specified if the value of an object is
 * changed in a manner that affects <tt>equals</tt> comparisons while the
 * object is a key in the map.  A special case of this prohibition is that it
 * is not permissible for a map to contain itself as a key.  While it is
 * permissible for a map to contain itself as a value, extreme caution is
 * advised: the <tt>equals</tt> and <tt>hashCode</tt> methods are no longer
 * well defined on such a map.
 *
 * 注意:如果把易变的对象作为map的key,那么一定要引起你的特别关注.
 * 如果map中的一个key发生了改变,并且影响了equals()方法的使用,那么map并不会提示我们.
 * 因此,我们禁止使用map自身作为map的key.
 * 尽管我们允许使用map自身作为value值,但是我们还是要注意:equals()方法和hashCode()方法在这样定义的map里面可能不能正常使用.
 *
 *
 *
 * <p>All general-purpose map implementation classes should provide two
 * "standard" constructors: a void (no arguments) constructor which creates an
 * empty map, and a constructor with a single argument of type <tt>Map</tt>,
 * which creates a new map with the same key-value mappings as its argument.
 * In effect, the latter constructor allows the user to copy any map,
 * producing an equivalent map of the desired class.  There is no way to
 * enforce this recommendation (as interfaces cannot contain constructors) but
 * all of the general-purpose map implementations in the JDK comply.
 *
 * 所有的通用map实现类都应该提供两个"标准"的构造器函数:一个是无参且返回类型为void的函数;
 * 另一个就是仅含有一个参数且类型为map类型的的构造方法,这个方法会使用其参数构造一个新的map,且新的map和参数map有相同的key和value.
 * 结果就是,第二个构造函数允许用户复制任何map,新生成一个和给定map一样的map.
 * 但是,map接口这里没办法强制执行这一建议(因为接口里面不能包含构造器函数),不过JDK里面所有通用的map实现类都是符合这一点要求的.
 *
 * <p>The "destructive" methods contained in this interface, that is, the
 * methods that modify the map on which they operate, are specified to throw
 * <tt>UnsupportedOperationException</tt> if this map does not support the
 * operation.  If this is the case, these methods may, but are not required
 * to, throw an <tt>UnsupportedOperationException</tt> if the invocation would
 * have no effect on the map.  For example, invoking the {@link #putAll(Map)}
 * method on an unmodifiable map may, but is not required to, throw the
 * exception if the map whose mappings are to be "superimposed" is empty.
 *
 * 如果一个操作不被map支持,且这个操作会更改map的结构,这样的操作已经在map接口中做了具体的定义,并且会返回
 * UnsupportedOperationException异常.
 * 如果是上述这种情况,这些方法可能会抛出UnsupportedOperationException异常,但并不是说一定会抛出这个异常.而且调用也不会对map产生什么
 * 影响.
 * 比如,在一个不可更改的map上面调用不被允许的putAll方法,则会抛出异常.
 *
 *
 * <p>Some map implementations have restrictions on the keys and values they
 * may contain.  For example, some implementations prohibit null keys and
 * values, and some have restrictions on the types of their keys.  Attempting
 * to insert an ineligible key or value throws an unchecked exception,
 * typically <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.
 * Attempting to query the presence of an ineligible key or value may throw an
 * exception, or it may simply return false; some implementations will exhibit
 * the former behavior and some will exhibit the latter.  More generally,
 * attempting an operation on an ineligible key or value whose completion
 * would not result in the insertion of an ineligible element into the map may
 * throw an exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 *
 * 一些map的实现类在key和value的取值上面会有一些规定.比如,一些map实现类不允许key或者value为null;
 * 而一些是在key的类型上面做了约束.尝试插入一些不符合规定的key或者value,会抛出非检查型异常,
 * 类似NullPointerException异常,ClassCastException异常.
 * 尝试查询不符合规定的key或者value也会抛出异常,或者仅返回false;具体是上述哪种情况,和具体的map实现类自身相关.
 * 更一般的情况是,对于非法的key或者value进行的操作,插入失败可能会抛出异常,但是也可能插入成功,这取决于具体的map实现类.
 * 这类型的异常被认为是map接口的可选择的.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * map接口是java集合框架中的一个成员.
 *
 * <p>Many methods in Collections Framework interfaces are defined
 * in terms of the {@link Object#equals(Object) equals} method.  For
 * example, the specification for the {@link #containsKey(Object)
 * containsKey(Object key)} method says: "returns <tt>true</tt> if and
 * only if this map contains a mapping for a key <tt>k</tt> such that
 * <tt>(key==null ? k==null : key.equals(k))</tt>." This specification should
 * <i>not</i> be construed to imply that invoking <tt>Map.containsKey</tt>
 * with a non-null argument <tt>key</tt> will cause <tt>key.equals(k)</tt> to
 * be invoked for any key <tt>k</tt>.  Implementations are free to
 * implement optimizations whereby the <tt>equals</tt> invocation is avoided,
 * for example, by first comparing the hash codes of the two keys.  (The
 * {@link Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 *
 *
 * 集合框架接口定义了很多种和equals()方法相关的实现.
 * 比如,containsKey()方法:当前仅当map包含了键k的定义是:key==null ? k==null : key.equals(k)
 * 这一规范的写法,不能被理解为为:如果调用方法使用的是一个非null参数的话,然后只是再调用key.equals(k)方法就可以了.
 * 具体实现可以通过避免调用equals()方法来实现优化,比如,可以先比较两个key的哈希值.
 * (哈希值保证了,如果两个对象的哈希值都不相同,那么这两个对象肯定不会相同).更一般的情况是,大量集合框架接口的实现类可以充分利用
 * 底层对象(Object)的方法的优势,只要实现者认为他们这么做是合理的.
 *
 *
 * 注意啦:这里的containsKey()方法还是和自己想象的不一样的,我真的以为如果key不是null,那就是直接调用equals()方法啦呢.这一点可以通过
 * containsKey()方法调用的getEntry方法源码看出,在if的判定条件中,equals是作为最后一个判定条件出现的,也就是说如果if前面的判定
 * 条件为true,那么是不会调用equals()方法的.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch
 * @see java.util.HashMap
 * @see TreeMap
 * @see Hashtable
 * @see SortedMap
 * @see Collection
 * @see Set
 * @since 1.2
 */
public interface Map<K,V> {
    // Query Operations ,以下为map的查询操作

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * 返回map中key-value映射的个数.如果map包含的key-value个数超过了Integer.MAX_VALUE这个数,
     * 则返回Integer.MAX_VALUE.
     *
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     * 如果map没有存储任何key-value,则返回true.
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this map contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     *
     * 如果map存储了指定的key,则返回true.更一般的情况是,当且仅当map包含了一个key的映射:
     * 映射情况是:key==null ? k==null : key.equals(k),此时返回true.
     *
     * @param key key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified
     *         key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map
     *         does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsKey(Object key);

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value.  More formally, returns <tt>true</tt> if and only if
     * this map contains at least one mapping to a value <tt>v</tt> such that
     * <tt>(value==null ? v==null : value.equals(v))</tt>.  This operation
     * will probably require time linear in the map size for most
     * implementations of the <tt>Map</tt> interface.
     *
     * 如果map中至少有一个key能映射到指定的value,那么就返回true.更一般的情况是,当且仅当value==null ? v==null : value.equals(v)
     * 条件成立,才返回true.
     * 在所有map接口的实现类中,这一操作都需要map大小的线性时间来完成.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     * @throws ClassCastException if the value is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this
     *         map does not permit null values
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsValue(Object value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * 返回指定key映射的value.如果map没有指定的key,则返回null.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * 更一般的情况是:如果map包含了一个满足条件key==null ? k==null :key.equals(k))的映射,
     * 那么方法就会返回对应的value;否则,返回null.(当然这样的映射最多有一个)
     *
     * <p>If this map permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the map
     * contains no mapping for the key; it's also possible that the map
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * 如果map允许null值,返回null值并不一定意味着map不存在指定key的映射;因为这也可能是这个key对应的value值就是null.
     * 因此,get方法也可能被用于区分这两种情况.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this map contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map
     *         does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    V get(Object key);

    // Modification Operations ,以下为修改map的操作

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A map
     * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * put方法是将指定的key-value存储到map里面的操作.如果map之前包含了一个此key对应的映射,那么此key对应的旧value值会被
     * 新的value值替换.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this map
     * @throws NullPointerException if the specified key or value is null
     *         and this map does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this map
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present
     * (optional operation).   More formally, if this map contains a mapping
     * from key <tt>k</tt> to value <tt>v</tt> such that
     * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
     * is removed.  (The map can contain at most one such mapping.)
     *
     * remove方法用于移除map中已有的某个key.更一般的讲,如果map包含了一个满足条件key==null ?  k==null : key.equals(k)
     * 的映射,这一映射就会被移除.(map最多包含一个这样的映射)
     *
     * <p>Returns the value to which this map previously associated the key,
     * or <tt>null</tt> if the map contained no mapping for the key.
     *
     * 本方法会返回移除的key对应的value值,如果map这个key没有对应的value值,则返回null.
     *
     *
     * <p>If this map permits null values, then a return value of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the map
     * contained no mapping for the key; it's also possible that the map
     * explicitly mapped the key to <tt>null</tt>.
     *
     * 如果map允许null值,那么返回null值并不一定表明map不包含对应key的映射值;因为这也可能是key本身对应的value值就是null.
     *
     * <p>The map will not contain a mapping for the specified key once the
     * call returns.
     *
     * 一旦此方法被调用,那么map就不会再包含这个key的映射了.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this
     *         map does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    V remove(Object key);


    // Bulk Operations ,块操作

    /**
     * Copies all of the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,Object) put(k, v)} on this map once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified map.  The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     *
     * putAll方法是将一个指定map的映射拷贝到当前map.这一操作类似于将指定map的key-value对通过put方法一个个拷贝过来.
     * 在拷贝过程中,如果指定的这个map被更改了,那么这时候会出现什么情况,并不清楚.
     *
     * @param m mappings to be stored in this map
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified map prevents it from being stored in this map
     * @throws NullPointerException if the specified map is null, or if
     *         this map does not permit null keys or values, and the
     *         specified map contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified map prevents it from being stored in this map
     */
    void putAll(Map<? extends K, ? extends V> m);

    /**
     * Removes all of the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     *
     * 移除map中所有的映射.
     * 调用此方法后,map会变为空.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this map
     */
    void clear();


    // Views ,视图

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation), the results of
     * the iteration are undefined.  The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
     * operations.
     *
     * 此方法:返回map包含所有的key的一个set集合.
     * 这个set集合由map作为后台支持,因此map的改变会反映在set集合里面,同样的
     * set集合的更改也会反映在map里面.(这和ArrayList中的subList方法一样,任意一方的更改都会在另一方体现出来)
     * 如果在迭代过程中,map被修改了结构(出去通过迭代器的remove方法对map结构的改变),迭代器的输出结果会受到什么影响,
     * 这一点并没有给出规定.
     * 此方法返回的set集合支持移除元素,同时会从map中删除对应的映射.可以删除元素的操作方法有5个:
     * <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>,
     * <tt>removeAll</tt>,
     * <tt>retainAll</tt>,
     * <tt>clear</tt>
     * 此方法返回的set集合不支持add或者addAll操作.
     * 也就是只有删除操作,没有添加操作.毕竟add类型的操作是没有意义的.因为此set集合返回的是map的keys的集合.你添加了key,
     * 但是没有办法同时添加对应的value,只会给后面的操作带来性能影响,没有其它什么意义.
     * 如果你执行了add类型操作会抛出UnsupportedOperationException异常.(这里可以自己运行一下代码)
     *
     * @return a set view of the keys contained in this map
     */
    Set<K> keySet();

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * values方法返回map内存储的所有值的集合(毕竟值集合中,值可以有重复的,所以此方法和上面的返回的key集合的结果类型不一样,因为key肯定
     * 都是不同的).
     * 这一集合也由map集合提供后台支持.因此map的更改会体现在返回的集合里面,反之亦然.(这一点和keySet方法完全一样)
     * 基于这个集合迭代器,对map进行遍历.在遍历过程中,如果map结构发生了改变(改变不包括:迭代器自身执行的remove方法),迭代器的输出结果是否
     * 受到影响,这一点并没有定义.
     * 这一返回集合支持移除元素,这会同时移除map中对应的映射.移除操作类型包括5类:
     * <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>,
     * <tt>removeAll</tt>,
     * <tt>retainAll</tt>,
     * <tt>clear</tt>
     *
     * 注意:返回集合不支持add或者addAll操作.如果你执行add类型操作会抛出UnsupportedOperationException异常.(这里可以自己测试一下,
     * 能加深理解.)
     *
     *
     * @return a collection view of the values contained in this map
     */
    Collection<V> values();

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation, or through the
     * <tt>setValue</tt> operation on a map entry returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
     * <tt>clear</tt> operations.  It does not support the
     * <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * 此方法返回map里存储的所有映射的视图.
     * 当然,这个返回的set集合,也由map作为后台支持(这一点和前两种方法一样),因此对map的改变会体现在set上面,反之亦然.
     * 基于set集合的迭代器在遍历过程中,如果map结构发生了改变(除去迭代器自身的remove方法造成的map结构改变,或者迭代器对map条目调用了setValue
     * 方法),则迭代器对输出结果的影响是怎么样的,并没有给出定义.
     * 返回的set集合支持移除元素,这种移除操作会同时反映在map上面.
     * 移除操作类型包括5种:
     * <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>,
     * <tt>removeAll</tt>,
     * <tt>retainAll</tt>,
     * <tt>clear</tt>
     *
     *
     * @return a set view of the mappings contained in this map
     */
    Set<Map.Entry<K, V>> entrySet();

    /**
     * A map entry (key-value pair).  The <tt>Map.entrySet</tt> method returns
     * a collection-view of the map, whose elements are of this class.  The
     * <i>only</i> way to obtain a reference to a map entry is from the
     * iterator of this collection-view.  These <tt>Map.Entry</tt> objects are
     * valid <i>only</i> for the duration of the iteration; more formally,
     * the behavior of a map entry is undefined if the backing map has been
     * modified after the entry was returned by the iterator, except through
     * the <tt>setValue</tt> operation on the map entry.
     *
     * map条目(key-value对).
     * Map.entrySet方法返回的就是map的集合视图,map视图中的元素就是来源于此类.
     * 获取map条目的唯一方式就是来源于集合视图的迭代器.只有在迭代的过程中,Map.Entry对象才是有效的;
     * 通常,如果通过迭代器获得的map条目,在遍历过程中,作为后台支持的map被修改了,那么map条目会如何被影响,对此
     * 并没有做出具体规定(当然此处说的map修改不包括setValue方法的调用).
     *
     * @see Map#entrySet()
     * @since 1.2
     */
    interface Entry<K,V> {
        /**
         * Returns the key corresponding to this entry.
         * 获取当前map条目对应的key
         *
         * @return the key corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        K getKey();

        /**
         * Returns the value corresponding to this entry.  If the mapping
         * has been removed from the backing map (by the iterator's
         * <tt>remove</tt> operation), the results of this call are undefined.
         *
         * 返回map条目对应的value值.
         * 如果映射从后台map中移除了(通过迭代器的remove方法),这一调用的结果会出现什么影响未被定义.
         *
         * @return the value corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        V getValue();

        /**
         * Replaces the value corresponding to this entry with the specified
         * value (optional operation).  (Writes through to the map.)  The
         * behavior of this call is undefined if the mapping has already been
         * removed from the map (by the iterator's <tt>remove</tt> operation).
         *
         * 用指定值替换当前条目中的value.(这一更改会被写入map中,自己调试一下代码就能知道了).
         * 如果映射从map中被移除了,再调用这一方法,会产生什么异常并没有定义.
         *
         * @param value new value to be stored in this entry
         * @return old value corresponding to the entry
         * @throws UnsupportedOperationException if the <tt>put</tt> operation
         *         is not supported by the backing map
         * @throws ClassCastException if the class of the specified value
         *         prevents it from being stored in the backing map
         * @throws NullPointerException if the backing map does not permit
         *         null values, and the specified value is null
         * @throws IllegalArgumentException if some property of this value
         *         prevents it from being stored in the backing map
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        V setValue(V value);

        /**
         * Compares the specified object with this entry for equality.
         * Returns <tt>true</tt> if the given object is also a map entry and
         * the two entries represent the same mapping.  More formally, two
         * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
         * if<pre>
         *     (e1.getKey()==null ?
         *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
         *     (e1.getValue()==null ?
         *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
         * </pre>
         * This ensures that the <tt>equals</tt> method works properly across
         * different implementations of the <tt>Map.Entry</tt> interface.
         *
         * 将指定对象和当前条目做比较.
         * 如果给定的对象是一个条目并且两个条目代表同一个映射,则返回true.
         * 一般,两个条目拥有相同映射满足的条件是:
         * if(
         *     (e1.getKey()==null ?
         *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &&
         *     (e1.getValue()==null ?
         *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
         * )
         * 上面的两个条件保证了,对Map.Entry接口的不同实现,equals方法都能正确.
         *
         *
         * @param o object to be compared for equality with this map entry
         * @return <tt>true</tt> if the specified object is equal to this map
         *         entry
         */
        boolean equals(Object o);

        /**
         * Returns the hash code value for this map entry.  The hash code
         * of a map entry <tt>e</tt> is defined to be: <pre>
         *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *     (e.getValue()==null ? 0 : e.getValue().hashCode())
         * </pre>
         * This ensures that <tt>e1.equals(e2)</tt> implies that
         * <tt>e1.hashCode()==e2.hashCode()</tt> for any two Entries
         * <tt>e1</tt> and <tt>e2</tt>, as required by the general
         * contract of <tt>Object.hashCode</tt>.
         *
         * 返回map条目的哈希值.
         * map条目的哈希值定义是:二者求异或值
         * (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *     (e.getValue()==null ? 0 : e.getValue().hashCode())
         * 这才能保证两个条目相等时,通过Object.hashCode方法得到的他们的哈希值也一定是相等的.
         *
         * @return the hash code value for this map entry
         * @see Object#hashCode()
         * @see Object#equals(Object)
         * @see #equals(Object)
         */
        int hashCode();
    }

    // Comparison and hashing

    /**
     * Compares the specified object with this map for equality.  Returns
     * <tt>true</tt> if the given object is also a map and the two maps
     * represent the same mappings.  More formally, two maps <tt>m1</tt> and
     * <tt>m2</tt> represent the same mappings if
     * <tt>m1.entrySet().equals(m2.entrySet())</tt>.  This ensures that the
     * <tt>equals</tt> method works properly across different implementations
     * of the <tt>Map</tt> interface.
     *
     * 用于对比两个map是否相等.
     * 如果给定的对象是一个map且两个map的映射一致,则返回true.
     * 一般,两个map的映射一致,要满足的条件是:
     * m1.entrySet().equals(m2.entrySet())
     * 这就保证了实现了map接口的不同类对于equals方法的使用才是正确的.
     *
     * @param o object to be compared for equality with this map
     * @return <tt>true</tt> if the specified object is equal to this map
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this map.  The hash code of a map is
     * defined to be the sum of the hash codes of each entry in the map's
     * <tt>entrySet()</tt> view.  This ensures that <tt>m1.equals(m2)</tt>
     * implies that <tt>m1.hashCode()==m2.hashCode()</tt> for any two maps
     * <tt>m1</tt> and <tt>m2</tt>, as required by the general contract of
     * {@link Object#hashCode}.
     *
     * 返回map的哈希值.
     * map的哈希值被定义为:这个map的entrySet视图的每一个条目的哈希值的总和.
     * 这就保证了任意两个map相等,则他们的哈希值一定相等,这也是Object类对哈希值的普遍要求(哈希值作为两个对象相等的
     * 必要非充分条件).
     *
     * @return the hash code value for this map
     * @see Map.Entry#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();
}

