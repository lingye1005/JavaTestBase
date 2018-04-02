        package sourcecode.analysis;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/21 11:14
         * @ProjectName: JavaBaseTest
         */

        import java.util.*;

        /**
         * set集合不包含重复元素.并且至多有一个null元素.
         * 正如其名称所暗示的那样，这个接口模拟了数学的集合抽象.
         *
         * 除了继承了Collection接口,遵从构造器,add,equals,hashcode4个方法的规定外,Set接口还提供了
         * 一些额外的规定.
         * 为方便起见,继承的方法在set集合中也进行了声明.(这些声明附带的规范已根据Set接口定制，但它们
         * 不包含任何其他规定。)
         *
         * 毫不奇怪,在构造器上的额外规定中,所有构造函数都必须创建一个不包含重复元素的集合(如上所定义)
         *
         * 注意:如果可变对象被用做set集合的元素,一定要引起足够重视.
         * 如果set集合中的对象值的改变影响了equals方法的比较结果,会对set产生什么影响并未定义.
         * 特别注意:set元素将自己作为存储元素是被禁止的.
         *
         * 一些set实现类在对它们能存储的元素上有限制.
         * 比如,一些实现类禁止存储null;
         * 一些则对存储元素的类型有限制.
         * 尝试添加非法元素会抛出"空指针异常","类型转化异常".
         * 尝试查询一个非法元素,会抛出异常or只是返回false.
         * 一些实现类将展现前一种行为，一些将展现后者.
         * 更一般的的情况是,插入非法字符会导致插入失败且抛出异常;当然插入也可能成功,这取决于类的实现.
         * 这些异常可以根据不同的实现类有不同的实现方式.
         *
         * set集合是java集合框架的一员.
         *
         * @author  Josh Bloch
         * @author  Neal Gafter
         * @see Collection
         * @see java.util.List
         * @see SortedSet
         * @see HashSet
         * @see TreeSet
         * @see AbstractSet
         * @see Collections#singleton(java.lang.Object)
         * @see Collections#EMPTY_SET
         * @since 1.2
         */

        public interface Set<E> extends Collection<E> {

            /*-----查询操作----*/

            int size();

            boolean isEmpty();

            boolean contains(Object o);


            Iterator<E> iterator();

            /**
             * 返回数组是"安全"的,只要没有原set中的引用指向数组元素.(换句话说,即使set类本身由数组
             * 存储元素,但是这一方法必须分配新的数组空间)
             * 因此方法调用着可以随意更改返回数组.
             */
            Object[] toArray();

            /**
             * 返回set中所有的元素;返回数组类型为参数类型.
             * 如果set和参数数组类型一致,则直接返回set的底层数组;
             * 否则,会新创建一个和set的size大小的数组
             *
             * 如果这个set适合指定的数组，并且有空余的空间（即数组的元素多于这个集合）
             * 紧随该set结尾的数组被设置为null。（这对确定这个长度很有用,只有在调用者知道
             * 该set不包含null时才设置。）
             *
             * 将set<String>实例转为String[]的方式如下:
             *
             * String[] y = x.toArray(new String[0]);
             *
             * 注意:toArray(new Object[0])和toArray()两者在功能上完全相同.
             *
             */
            <T> T[] toArray(T[] a);


            /*------修改操作-----*/

            //如果set中已有要add的元素,则返回false.
            boolean add(E e);


            //如果set包含删除元素,返回true
            boolean remove(Object o);


            /*---------块操作--------*/

            /**
             * 如果set包含指定元素,则返回true;
             * 如果参数e也是一个set且参数e是set的一个subset,则返回true;
             */
            boolean containsAll(Collection<?> c);

            //如果指定的集合也是一个集合，则此操作将有效地修改此集合，使其值为两个集合中的交集
            boolean addAll(Collection<? extends E> c);

            /**
             * 删除set中有,但在参数集合c中没有的元素.
             * 如果指定的集合也是一个集合，则此操作将有效地修改此集合，使其值为两个集合中的交集
             */
            boolean retainAll(Collection<?> c);

            /**
             * 删除set中有,在参数集合c中也有的元素.
             * 如果指定的集合也是一个集合，则此操作将有效地修改此集合，使其值为两个集合中的交集
             */
            boolean removeAll(Collection<?> c);

            void clear();


            /*-------比较和hash操作-------*/

            /**
             * 结果为ture的条件
             * 1.两个都是set
             * 2.同样的size
             * 3.元素等价
             */
            boolean equals(Object o);

            /**
             * hash值定义:sum(set中每一个元素的hash值)
             * 如果元素为null,则hash值定义为0
             */
            int hashCode();

            /**
             * Creates a {@code Spliterator} over the elements in this set.
             * 建立set的一个分割器.
             *
             * set接口定义中:分割器属性值有:DISTINCT
             * set接口的其它实现类如果有额外的分割器属性值,一定要给出文档说明.
             *
             * 创建的分割器属性值额外添加了:SIZED,SUBSIZED.
             *
             * @since 1.8
             */
            @Override
            default Spliterator<E> spliterator() {
                return Spliterators.spliterator(this, Spliterator.DISTINCT);
            }
        }
