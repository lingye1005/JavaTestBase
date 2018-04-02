//package sourcecode.analysis;
//
///**
// * Created by caoxiaohong on 17/11/11 11:44.
// * Map接口分析
// */
//
//import java.io.Serializable;
//import java.lang.*;
//import java.util.*;
//import java.util.function.*;
//import java.util.function.BiFunction;
//
///**
// *
// * Map是一个有键值对映射的对象.map不能包含相同的key,每一个key至多能映射一个value.
// *
// * 这个接口替代了Dictionary这个类,Dictionary是抽象类而非接口.
// * (替代原因:接口总是优于抽象类,原因可查看<<effective java>>第18条)
// *
// * Map接口提供了3个集合视图,包括:keys的set集合; values的集合; key-value的set集合.(注意:values集合不是set类型,因为value可相同)
// * Map返回元素的顺序,取决于:map对应的某个集合视图迭代器的顺序.
// * 一些map的实现,比如TreeMap类,对于map返回元素的顺序有特殊的规定;
// * 其它的map实现类,比如HashMap类,就没有特殊的规定.
// *
// * 注意:如果把易变的对象作为map的key,那么一定要引起你的特别关注.
// * 如果map中的一个key发生了改变,并且影响了equals()方法的使用,那么map并不会提示我们.
// * 因此,我们禁止使用map自身作为map的key.
// * 尽管我们允许使用map自身作为value值,但是我们还是要注意:equals()方法和hashCode()方法在这样定义的map里面可能不能正常使用.
// *
// * 所有的通用map实现类都应该提供两个"标准"的构造器函数:
// * 一个是无参且返回类型为void的函数;
// * 另一个就是仅含有一个参数且类型为map类型的的构造方法,这个方法会使用其参数构造一个新的map,且新的map和参数map有相同的key和value.
// * 结果就是,第二个构造函数允许用户复制任何map,新生成一个和给定map一样的map.
// * 但是,map接口这里没办法强制执行这一建议(因为接口里面不能包含构造器函数),不过JDK里面所有通用的map实现类都是符合这一点要求的.
// *
// * 如果一个操作不被map支持,且这个操作会更改map的结构,这样的操作已经在map接口中做了具体的定义,并且会返回
// * UnsupportedOperationException异常.
// * 如果是上述这种情况,这些方法可能会抛出UnsupportedOperationException异常,但并不是说一定会抛出这个异常.而且调用也不会对map产生什么
// * 影响.比如,在一个不可更改的map上面调用不被允许的putAll方法,则会抛出异常.
// *
// * 一些map的实现类在key和value的取值上面会有一些规定.比如,一些map实现类不允许key或者value为null;
// * 而一些是在key的类型上面做了约束.尝试插入一些不符合规定的key或者value,会抛出非检查型异常,
// * 类似NullPointerException异常,ClassCastException异常.
// * 尝试查询不符合规定的key或者value也会抛出异常,或者仅返回false;具体是上述哪种情况,和具体的map实现类自身相关.
// * 更一般的情况是,对于非法的key或者value进行的操作,插入失败可能会抛出异常,但是也可能插入成功,这取决于具体的map实现类.
// * 这类型的异常被认为是map接口的可选择的.
// *
// * map接口是java集合框架中的一个成员.
// *
// * 集合框架接口定义了很多种和equals()方法相关的实现.
// * 比如,containsKey()方法:当前仅当map包含了键k的定义是:key==null ? k==null : key.equals(k)
// * 这一规范的写法,不能被理解为为:如果调用方法使用的是一个非null参数的话,然后只是再调用key.equals(k)方法就可以了.
// * 具体实现可以通过避免调用equals()方法来实现优化,比如,可以先比较两个key的哈希值.
// * (哈希值保证了,如果两个对象的哈希值都不相同,那么这两个对象肯定不会相同).更一般的情况是,大量集合框架接口的实现类可以充分利用
// * 底层对象(Object)的方法的优势,只要实现者认为他们这么做是合理的.
// *
// *
// * 注意啦:这里的containsKey()方法还是和自己想象的不一样的,我真的以为如果key不是null,那就是直接调用equals()方法啦呢.这一点可以通过
// * containsKey()方法调用的getEntry方法源码看出,在if的判定条件中,equals是作为最后一个判定条件出现的,也就是说如果if前面的判定
// * 条件为true,那么是不会调用equals()方法的.
// *
// * @author  Josh Bloch
// * @see java.util.HashMap
// * @see TreeMap
// * @see Hashtable
// * @see SortedMap
// * @see Collection
// * @see Set
// * @since 1.2
// */
//public interface Map<K,V> {
//    //以下为map的查询操作
//
//    /**
//     * 返回map中key-value映射的个数.如果map包含的key-value个数超过了Integer.MAX_VALUE这个数,
//     * 则返回Integer.MAX_VALUE.
//     */
//    int size();
//
//    /**
//     * 如果map没有存储任何key-value,则返回true.
//     */
//    boolean isEmpty();
//
//    /**
//     * 如果map存储了指定的key,则返回true.更一般的情况是,当且仅当map包含了一个key的映射:
//     * 映射情况是:key==null ? k==null : key.equals(k),此时返回true.
//     */
//    boolean containsKey(Object key);
//
//    /**
//     * 如果map中至少有一个key能映射到指定的value,那么就返回true.更一般的情况是,当且仅当value==null ? v==null : value.equals(v)
//     * 条件成立,才返回true.
//     * 在所有map接口的实现类中,这一操作都需要map大小的线性时间来完成.
//     */
//    boolean containsValue(Object value);
//
//    /**
//     * 返回指定key映射的value.如果map没有指定的key,则返回null.
//     *
//     * 更一般的情况是:如果map包含了一个满足条件key==null ? k==null :key.equals(k))的映射,
//     * 那么方法就会返回对应的value;否则,返回null.(当然这样的映射最多有一个)
//     *
//     * 如果map允许null值,返回null值并不一定意味着map不存在指定key的映射;因为这也可能是这个key对应的value值就是null.
//     * 因此,get方法也可能被用于区分这两种情况.
//     */
//    V get(Object key);
//
//    // Modification Operations ,以下为修改map的操作
//
//    /**
//     * put方法是将指定的key-value存储到map里面的操作.如果map之前包含了一个此key对应的映射,那么此key对应的旧value值会被
//     * 新的value值替换.
//     */
//    V put(K key, V value);
//
//    /**
//     * remove方法用于移除map中已有的某个key.更一般的讲,如果map包含了一个满足条件key==null ?  k==null : key.equals(k)
//     * 的映射,这一映射就会被移除.(map最多包含一个这样的映射)
//     *
//     * 本方法会返回移除的key对应的value值,如果map这个key没有对应的value值,则返回null.
//     *
//     * 如果map允许null值,那么返回null值并不一定表明map不包含对应key的映射值;因为这也可能是key本身对应的value值就是null.
//     *
//     * 一旦此方法被调用,那么map就不会再包含这个key的映射了.
//     */
//    V remove(Object key);
//
//
//    //块操作
//
//    /**
//     * putAll方法是将一个指定map的映射拷贝到当前map.这一操作类似于将指定map的key-value对通过put方法一个个拷贝过来.
//     * 在拷贝过程中,如果指定的这个map被更改了,那么这时候会出现什么情况,并不清楚.
//     */
//    void putAll(Map<? extends K, ? extends V> m);
//
//    /**
//     * 移除map中所有的映射.
//     * 调用此方法后,map会变为空.
//     */
//    void clear();
//
//
//    // Views ,视图
//
//    /**
//     * 此方法:返回map包含所有的key的一个set集合视图.
//     * 这个set集合由map作为后台支持,因此map的改变会反映在set集合里面,同样的
//     * set集合的更改也会反映在map里面.(这和ArrayList中的subList方法一样,任意一方的更改都会在另一方体现出来)
//     * 如果在迭代过程中,map被修改了结构(出去通过迭代器的remove方法对map结构的改变),迭代器的输出结果会受到什么影响,
//     * 这一点并没有给出规定.
//     * 此方法返回的set集合支持移除元素,同时会从map中删除对应的映射.可以删除元素的操作方法有5个:
//     * <tt>Iterator.remove</tt>,
//     * <tt>Set.remove</tt>,
//     * <tt>removeAll</tt>,
//     * <tt>retainAll</tt>,
//     * <tt>clear</tt>
//     * 此方法返回的set集合不支持add或者addAll操作.
//     * 也就是只有删除操作,没有添加操作.毕竟add类型的操作是没有意义的.因为此set集合返回的是map的keys的集合.你添加了key,
//     * 但是没有办法同时添加对应的value,只会给后面的操作带来性能影响,没有其它什么意义.
//     * 如果你执行了add类型操作会抛出UnsupportedOperationException异常.(这里可以自己运行一下代码)
//     */
//    Set<K> keySet();
//
//    /**
//     * values方法返回map内存储的所有值的集合(毕竟值集合中,值可以有重复的,所以此方法和上面的返回的key集合的结果类型不一样,因为key肯定
//     * 都是不同的).
//     * 这一集合也由map集合提供后台支持.因此map的更改会体现在返回的集合里面,反之亦然.(这一点和keySet方法完全一样)
//     * 基于这个集合迭代器,对map进行遍历.在遍历过程中,如果map结构发生了改变(改变不包括:迭代器自身执行的remove方法),迭代器的输出结果是否
//     * 受到影响,这一点并没有定义.
//     * 这一返回集合支持移除元素,这会同时移除map中对应的映射.移除操作类型包括5类:
//     * <tt>Iterator.remove</tt>,
//     * <tt>Collection.remove</tt>,
//     * <tt>removeAll</tt>,
//     * <tt>retainAll</tt>,
//     * <tt>clear</tt>
//     *
//     * 注意:返回集合不支持add或者addAll操作.如果你执行add类型操作会抛出UnsupportedOperationException异常.(这里可以自己测试一下,
//     * 能加深理解.)
//     *
//     *
//     * @return a collection view of the values contained in this map
//     */
//    Collection<V> values();
//
//    /**
//     * 此方法返回map里存储的所有映射的视图.
//     * 当然,这个返回的set集合,也由map作为后台支持(这一点和前两种方法一样),因此对map的改变会体现在set上面,反之亦然.
//     * 基于set集合的迭代器在遍历过程中,如果map结构发生了改变(除去迭代器自身的remove方法造成的map结构改变,或者迭代器对map条目调用了setValue
//     * 方法),则迭代器对输出结果的影响是怎么样的,并没有给出定义.
//     * 返回的set集合支持移除元素,这种移除操作会同时反映在map上面.
//     * 移除操作类型包括5种:
//     * <tt>Iterator.remove</tt>,
//     * <tt>Set.remove</tt>,
//     * <tt>removeAll</tt>,
//     * <tt>retainAll</tt>,
//     * <tt>clear</tt>
//     */
//    Set<Map.Entry<K, V>> entrySet();
//
//    /**
//     * map条目(key-value对).
//     * Map.entrySet方法返回的就是map的集合视图,map视图中的元素就是来源于此类.
//     * 获取map条目的唯一方式就是来源于集合视图的迭代器.只有在迭代的过程中,Map.Entry对象才是有效的;
//     * 通常,如果通过迭代器获得的map条目,在遍历过程中,作为后台支持的map被修改了,那么map条目会如何被影响,对此
//     * 并没有做出具体规定(当然此处说的map修改不包括setValue方法的调用).
//     */
//    interface Entry<K,V> {
//        /**
//         * 获取当前map条目对应的key
//         */
//        K getKey();
//
//        /**
//         * 返回map条目对应的value值.
//         * 如果映射从后台map中移除了(通过迭代器的remove方法),这一调用的结果会出现什么影响未被定义.
//         */
//        V getValue();
//
//        /**
//         * 用指定值替换当前条目中的value.(这一更改会被写入map中,自己调试一下代码就能知道了).
//         * 如果映射从map中被移除了,再调用这一方法,会产生什么异常并没有定义.
//         */
//        V setValue(V value);
//
//        /**
//         * 将指定对象和当前条目做比较.
//         * 如果给定的对象是一个条目并且两个条目代表同一个映射,则返回true.
//         * 一般,两个条目拥有相同映射满足的条件是:
//         * if(
//         *     (e1.getKey()==null ?
//         *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &&
//         *     (e1.getValue()==null ?
//         *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
//         * )
//         * 上面的两个条件保证了,对Map.Entry接口的不同实现,equals方法都能正确.
//         */
//        boolean equals(Object o);
//
//        /**
//         * 返回map条目的哈希值.
//         * map条目的哈希值定义是:二者求异或值
//         * (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
//         *     (e.getValue()==null ? 0 : e.getValue().hashCode())
//         * 这才能保证两个条目相等时,通过Object.hashCode方法得到的他们的哈希值也一定是相等的.
//         */
//        int hashCode();
//    }
//
//    // 比较和hash操作
//    /**
//     * 用于对比两个map是否相等.
//     * 如果给定的对象是一个map且两个map的映射一致,则返回true.
//     * 一般,两个map的映射一致,要满足的条件是:
//     * m1.entrySet().equals(m2.entrySet())
//     * 这就保证了实现了map接口的不同类对于equals方法的使用才是正确的.
//     */
//    boolean equals(Object o);
//
//    /**
//     * 返回map的哈希值.
//     * map的哈希值被定义为:这个map的entrySet视图的每一个条目的哈希值的总和.
//     * 这就保证了任意两个map相等,则他们的哈希值一定相等,这也是Object类对哈希值的普遍要求(哈希值作为两个对象相等的
//     * 必要非充分条件).
//     * @see Map.Entry#hashCode()
//     * @see Object#equals(Object)
//     * @see #equals(Object)
//     */
//    int hashCode();
//
//
//    /*----------以下均为jdk8新增内容-----------*/
//    /**
//     * 返回一个比较map.entry的比较器,按照key的自然顺序排序.
//     * 返回的比较器支持序列化.
//     * 如果map中的entry有key=null情况,则抛出空指针异常(因为返回结果要按照key排序)
//     * 注意:传入参数k必须支持Comparable接口,因为需要按照key排序.
//     * @see java.lang.Comparable
//     * @since 1.8
//     */
//    public static <K extends java.lang.Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey() {
//        return (Comparator<Map.Entry<K, V>> & Serializable)
//                (c1, c2) -> c1.getKey().compareTo(c2.getKey());
//    }
//
//    /**
//     * 返回一个map.enty的比较器,按照value的自然顺序排序.
//     * 返回的比较器支持序列化.
//     * 如果map中的entry有value=null情况,则抛出空指针异常(因为返回结果要按照value排序)
//     * 注意:传入参数value必须支持Comparable接口,因为按照value排序.
//     * @see java.lang.Comparable
//     * @since 1.8
//     */
//    public static <K, V extends java.lang.Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
//        return (Comparator<Map.Entry<K, V>> & Serializable)
//                (c1, c2) -> c1.getValue().compareTo(c2.getValue());
//    }
//
//    /**
//     * 返回一个map.entry的比较器,根据传入比较器对key排序.
//     * 如果传入的比较器支持序列化,则返回的结果比较器也支持序列化.
//     * @since 1.8
//     */
//    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
//        Objects.requireNonNull(cmp);
//        return (Comparator<Map.Entry<K, V>> & Serializable)
//                (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
//    }
//
//    /**
//     * 返回一个map.entry的比较器,根据传入比较器对value排序.
//     * 如果传入的比较器支持序列化,则返回的结果比较器也支持序列化.
//     * @since 1.8
//     */
//    public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
//        Objects.requireNonNull(cmp);
//        return (Comparator<Map.Entry<K, V>> & Serializable)
//                (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
//    }
//}
//
//    /*----以下为:比较方法  and  hash方法-----*/
//    /**
//     * 将传入对象和当前map进行比较.
//     * 返回结果为true需要满足两个条件:
//     * 1.传入对象类型为map类型
//     * 2.传入对象和当前map键值对完全一致.
//     * 更标准的讲,两个map的entrySet在equals结果为true,则表示键值对一致.这才能保证对于实现map接口的不同类在
//     * equals方法调用过程中正常使用.
//     */
//    boolean equals(Object o);
//
//    /**
//     * 返回map的哈希值.
//     * map的哈希值=sum(每一个entry的哈希值).
//     * map的哈希值求法保证了:如果map1.equals(map2)结果为true,则map1.hashCode()=map2.hashCode(),
//     * 当然这样的设计也符合Object中对hashCode的定义.
//     * @see Map.Entry#hashCode()
//     * @see Object#equals(Object)
//     * @see #equals(Object)
//     */
//    int hashCode();
//
//
//    /*---------以下为默认方法--------*/
//    /**
//     * 返回指定key对应的value,如果没有对应的映射,则返回传入参数中的默认值defaultValue.
//     * @implSpec
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * @since 1.8
//     */
//    default V getOrDefault(Object key, V defaultValue) {
//        V v;
//        return (((v = get(key)) != null) || containsKey(key))
//                ? v
//                : defaultValue;
//    }
//
//    /**
//     * 对map中每一个entry执行action中定义对操作,直到全部entry执行完成or执行中出现异常为止.
//     * 除非map的实现类有规定,否则forEach的执行顺序为entrySet中entry的顺序.
//     * 执行中的异常最终抛给方法的调用者.
//     * @implSpec
//     * The default implementation is equivalent to, for this {@code map}:
//     * 本方法的默认实现和下面的代码是等价的:
//     * for (Map.Entry<K, V> entry : map.entrySet())
//     *     action.accept(entry.getKey(), entry.getValue());
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     *
//     * @since 1.8
//     */
//    default void forEach(BiConsumer<? super K, ? super V> action) {
//        Objects.requireNonNull(action);
//        for (Map.Entry<K, V> entry : entrySet()) {
//            K k;
//            V v;
//            try {
//                k = entry.getKey();
//                v = entry.getValue();
//            } catch(IllegalStateException ise) {
//                // this usually means the entry is no longer in the map.
//                throw new ConcurrentModificationException(ise);
//            }
//            action.accept(k, v);
//        }
//    }
//
//    /**
//     * 对于map中每一个entry,将其value替换成BiFunction接口返回的值.直到所有entry替换完or出现异常为止.
//     * 如果执行过程中出现异常,则抛给调用者.
//     * @implSpec
//     * 本方法的默认执行和下面代码等价:
//     * for (Map.Entry<K, V> entry : map.entrySet())
//     *     entry.setValue(function.apply(entry.getKey(), entry.getValue()));
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     *
//     * @since 1.8
//     */
//    default void replaceAll(java.util.function.BiFunction<? super K, ? super V, ? extends V> function) {
//        Objects.requireNonNull(function);
//        for (Map.Entry<K, V> entry : entrySet()) {
//            K k;
//            V v;
//            try {
//                k = entry.getKey();
//                v = entry.getValue();
//            } catch(IllegalStateException ise) {
//                // this usually means the entry is no longer in the map.
//                throw new ConcurrentModificationException(ise);
//            }
//
//            // ise thrown from function is not a cme.
//            v = function.apply(k, v);
//
//            try {
//                entry.setValue(v);
//            } catch(IllegalStateException ise) {
//                // this usually means the entry is no longer in the map.
//                throw new ConcurrentModificationException(ise);
//            }
//        }
//    }
//
//    /**
//     * 如果指定的键尚未与值相关联（或被映射为null）,则将它与给定的值相关联并返回null，否则返回当前值。
//     * @implSpec
//     * 本方法的默认执行和下面的代码等价:
//     * V v = map.get(key);
//     * if (v == null)
//     *     v = map.put(key, value);
//     * return v;
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     *
//     * @since 1.8
//     */
//    default V putIfAbsent(K key, V value) {
//        V v = get(key);
//        if (v == null) {
//            v = put(key, value);
//        }
//
//        return v;
//    }
//
//    /**
//     * 如果给定的参数key和value在map中是一个entry,则删除这个entry.
//     * @implSpec
//     * 本方法的默认实现和下面代码等价:
//     * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
//     *     map.remove(key);
//     *     return true;
//     * } else
//     *     return false;
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     *
//     * @since 1.8
//     */
//    default boolean remove(Object key, Object value) {
//        Object curValue = get(key);
//        if (!Objects.equals(curValue, value) ||
//                (curValue == null && !containsKey(key))) {
//            return false;
//        }
//        remove(key);
//        return true;
//    }
//
//    /**
//     * Replaces the entry for the specified key only if currently
//     * mapped to the specified value.
//     * 如果给定的key和value在map中有entry,则为指定key的entry,用新value替换旧的value.
//     * @implSpec
//     * 本方法的默认实现和下面代码等价:
//     * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
//     *     map.put(key, newValue);
//     *     return true;
//     * } else
//     *     return false;
//     * }
//     *
//     * 对于不支持value为null的map来说,如果旧value为null,本方法默认不抛出异常,除非新value也是null.
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * @since 1.8
//     */
//    default boolean replace(K key, V oldValue, V newValue) {
//        Object curValue = get(key);
//        if (!Objects.equals(curValue, oldValue) ||
//                (curValue == null && !containsKey(key))) {
//            return false;
//        }
//        put(key, newValue);
//        return true;
//    }
//
//    /**
//     * 如果指定key在map中有value,则用参数value进行替换.
//     * 本方法的默认实现和下面代码等价:
//     * if (map.containsKey(key)) {
//     *     return map.put(key, value);
//     * } else
//     *     return null;
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     *
//     * @since 1.8
//     */
//    default V replace(K key, V value) {
//        V curValue;
//        if (((curValue = get(key)) != null) || containsKey(key)) {
//            curValue = put(key, value);
//        }
//        return curValue;
//    }
//
//    /**
//     * 如果指定key在map中没有对应的value,则使用输入参数,即函数接口mappingfunction为其计算一个value.
//     * 如果计算value不为null,则将value插入map中.
//     *
//     * 如果计算function返回结果为null,则不插入任何映射.如果函数function本身抛出(非检查型)异常,则异常会被重新抛出,自然
//     * 也不会插入任何映射.
//     * 最常见的用法是构造一个新的对象作为初始映射值或memoized结果，如下所示：
//     * map.computeIfAbsent(key, k -> new Value(f(k)));
//     *
//     * or是为了实现一个多value的map(如Map<k,Collection<v>>),从而支持一个key对应多个value.
//     *
//     * map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
//     * }</pre>
//     *
//     * 本方法的默认实现和下面代码等价:
//     * if (map.get(key) == null) {
//     *     V newValue = mappingFunction.apply(key);
//     *     if (newValue != null)
//     *         map.put(key, newValue);
//     * }
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * 特别是,所有ConcurrentMap的子接类,必须给出说明:如果当前value不存在,赋值的function操作是否为原子性的.
//     * @since 1.8
//     */
//    default V computeIfAbsent(K key,
//                              java.util.function.Function<? super K, ? extends V> mappingFunction) {
//        Objects.requireNonNull(mappingFunction);
//        V v;
//        if ((v = get(key)) == null) {
//            V newValue;
//            if ((newValue = mappingFunction.apply(key)) != null) {
//                put(key, newValue);
//                return newValue;
//            }
//        }
//
//        return v;
//    }
//
//    /**
//     * 如果map中存在指定key对应的value,且不为null,则本方法会尝试使用function,并利用key生成一个新的value.
//     *
//     * 如果function接口返回null,map中原entry则被移除.如果function本身抛出异常,则当前map不会发生改变.
//     *
//     * 本方法的默认实现和下面的代码等价:
//     * if (map.get(key) != null) {
//     *     V oldValue = map.get(key);
//     *     V newValue = remappingFunction.apply(key, oldValue);
//     *     if (newValue != null)
//     *         map.put(key, newValue);
//     *     else
//     *         map.remove(key);
//     * }
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * 特别是,所有ConcurrentMap的子接类,必须给出说明:如果当前value不存在,赋值的function操作是否为原子性的.
//     *
//     * @since 1.8
//     */
//    default V computeIfPresent(K key,
//                               java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//        Objects.requireNonNull(remappingFunction);
//        V oldValue;
//        if ((oldValue = get(key)) != null) {
//            V newValue = remappingFunction.apply(key, oldValue);
//            //如果新value不为null,则更新value
//            if (newValue != null) {
//                put(key, newValue);
//                return newValue;
//            }
//            //如果新value为null,则删除map中原entry
//            else {
//                remove(key);
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * 利用指定key和value计算一个新映射.
//     * 比如:向一个value映射中新增或者拼接一个String.
//     *
//     * 下面的merge()方法在这样的用途上面通常使用更方便一些.
//     *
//     * 如果function接口返回null,则map中原entry被移除(如果本来就不存在,则不执行移除操作).
//     * 如果function本身抛出(非检查型)异常,异常会被重新抛出,当前map也不会发生改变.
//     *
//     * 本方法的默认实现和下面代码等价:
//     * V oldValue = map.get(key);
//     * V newValue = remappingFunction.apply(key, oldValue);
//     * if (oldValue != null ) {
//     *    if (newValue != null)
//     *       map.put(key, newValue);
//     *    else
//     *       map.remove(key);
//     * } else {
//     *    if (newValue != null)
//     *       map.put(key, newValue);
//     *    else
//     *       return null;
//     * }
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * 特别是,所有ConcurrentMap的子接类,必须给出说明:如果当前value不存在,赋值的function操作是否为原子性的.
//     *
//     * @since 1.8
//     */
//    default V compute(K key,
//                      java.util.function.BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
//        Objects.requireNonNull(remappingFunction);
//        //获取旧value
//        V oldValue = get(key);
//        //利用key和旧value生成新value
//        V newValue = remappingFunction.apply(key, oldValue);
//        //如果新value为null
//        if (newValue == null) {
//            //如果旧value不为null,或者map存在key,则删除旧entry
//            if (oldValue != null || containsKey(key)) {
//                // something to remove
//                remove(key);
//                return null;
//            } else {
//                //什么也不做
//                return null;
//            }
//        } else {
//            // 添加or覆盖原映射
//            put(key, newValue);
//            return newValue;
//        }
//    }
//
//    /**
//     * 如果指定key没有value,或者其value为null,则将其改为给定的非null的value.
//     * 否则,用给定的function返回值替换原value.
//     * 如果给定参数value和function返回结果都为null,则删除map中这个entry.
//     * 这一方法常用于:对一个key合并多个映射的value时.
//     * 比如:要创建或追加一个String给一个值映射.
//     *
//     * 如果function返回null,则map中原entry被移除.如果function本身抛出异常,则异常会被重新抛出,且
//     * 当前map不会发生更改.
//     *
//     * 本方法的默认实现和下面代码等价,返回结果为当前value或者null
//     * V oldValue = map.get(key);
//     * V newValue = (oldValue == null) ? value :
//     *              remappingFunction.apply(oldValue, value);
//     * if (newValue == null)
//     *     map.remove(key);
//     * else
//     *     map.put(key, newValue);
//     * }
//     *
//     * 此默认方法对于线程同步和执行过程的原子性并不能保证.
//     * 任何实施提供原子性保证必须重写此方法并记录其方法.
//     * 特别是,所有ConcurrentMap的子接类,必须给出说明:如果当前value不存在,赋值的function操作是否为原子性的
//     *
//     * @since 1.8
//     */
//    default V merge(K key, V value,
//                    BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
//        Objects.requireNonNull(remappingFunction);
//        Objects.requireNonNull(value);
//        //获取旧value
//        V oldValue = get(key);
//        //如果旧value为null,则newValue=参数value;
//        //如果旧value不为null,则newValue=function接口返回值
//        V newValue = (oldValue == null) ? value :
//                remappingFunction.apply(oldValue, value);
//        //如果newValue=null,则删除map中的entry,说明参数value=null或者function接口返回值为null
//        if(newValue == null) {
//            remove(key);
//        }
//        //否则,为原entry插入新value.
//        else {
//            put(key, newValue);
//        }
//        //返回新value
//        return newValue;
//    }
//}
//
