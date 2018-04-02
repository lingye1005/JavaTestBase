    package sourcecode.analysis;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/9 11:08
     * @ProjectName: JavaBaseTest
     */

    import java.util.*;

    /**
     * List属于有序集合.这个接口的使用者可以明确指出元素的插入位置.
     * 使用者也可以通过整数index获取或者查找元素.
     *
     * 和集合set不同,List允许存放重复元素.
     * List允许存放null.
     * 人可能希望通过在用户试图插入时抛出运行时异常来实现禁止重复的列表，这可以理解,但我们预计这种用法很少见
     *
     * List接口在方法上提供了额外的规定,这些规定超出了Collection接口中以下方法的规定:
     * iterator, add, remove,equals,hashCode.
     * 为方便起见,其它继承方法也包含在List接口中了.
     *
     * 为获取指定位置处的元素,List提供了4种方法.
     * List(如java数组)下标index从0开始计数.
     * 注意:List的不同实现类在这4种操作方法中,因为索引index的不同而可能执行时间不同.
     * 因此,方法调用者如果并不知道其具体实现,如果想遍历list中的元素最好通过迭代器实现.
     *
     * List接口提供了一个特殊迭代器:ListIterator,这个迭代器允许元素的插入,替换,以及除了正常操作之外的双向访问.
     * List还提供了一个方法,就是指定迭代器开始访问的位置.
     *
     * List接口提供了2个方法来查找指定对象.
     * 从性能角度来说,应谨慎使用这些方法.
     * 许多实现表现的时间复杂度都是线性的.
     *
     * List接口提供了两种方法来高效地插入和删除列表中任意点的多个元素
     *
     * 注意:因为允许List可以存放它们自身,特别注意:这样的list中,equals和hashcode方法并没有定义.
     *
     * 一些list对它们可以包含的元素给出了限制.比如,一些list不能存放null元素;一些list在存放元素类型上有限制.
     * 1.尝试添加一个不合法的元素会引发异常:如NullPointerException或ClassCastException;
     * 2.尝试查询一个不合法的元素会引发异常,或者单纯返回false;
     * 一些实现会展示前者行为,而一些list则展示后者行为.
     * 更一般地说，在一个非法元素上尝试操作时,其结果可能是元素没有插入list中,也可能插入成功,这取决于其list的实现.
     * 在此规范中，此类例外标记为“可选”界面.
     *
     * List是java集合框架中的一员.
     * @param <E> the type of elements in this list
     *
     * @author  Josh Bloch
     * @author  Neal Gafter
     * @see Collection
     * @see Set
     * @see ArrayList
     * @see LinkedList
     * @see Vector
     * @see Arrays#asList(Object[])
     * @see Collections#nCopies(int, Object)
     * @see Collections#EMPTY_LIST
     * @see AbstractList
     * @see AbstractSequentialList
     * @since 1.2
     */

    public interface List<E> extends Collection<E> {

        /*----查询操作-----*/

        //list中元素个数
        int size();

        //非空查询
        boolean isEmpty();

        //是否包含某对象o
        boolean contains(Object o);

        //迭代器
        Iterator<E> iterator();

        /**
         * 返回的数组将是"安全"的,因为list不会有指向这个数组的引用.(换句话说,即使list后台由数组存储作为存储支撑,
         * 这个方法仍然会返回一个新的数组,这个新数组是通过new获得的,声明了新的内存空间.)
         * 因此调用者可以随意更改这个返回的数组.
         *
         * 这一方法可以看作是:数组和集合api之间转换的桥梁
         * 将list中的元素转为数组形式并返回,元素顺序和list中一致.
         * 注意:返回类型:Object[]
         */
        Object[] toArray();

        /**
         * 返回一个包含list中所有元素的数组(元素顺序和list中一致);
         * 运行时返回类型和参数数组一致.
         *
         * 如果list和其后台数组一致,则返回list后台数组.否则重新生成一个和参数类型一样的数组,大小
         * 和list一致.(这里和上一个toArray()不同,不一定生成新数组,因此可能会节约空间)-----****
         *
         * 如果list后台数组有空余空间(数组比list有更多元素),数组中的元素紧随列表结束后立即设置为null.
         * (只要方法调用者确定list中没有null,这一方法在求list长度上是有用的)
         *
         * 和toArray()方法类似,这一方法充当了数组和集合api的桥梁.进一步讲,这一方法在运行时输出数组类型上有着精确的控制,
         * 也许,在一定的场景下,可以被用来较少内存损耗.
         *
         * 假设list中只存储了String类型元素.下面的代码能够被用作:将list中元素放入一个新生成的String[]数组中.
         *
         * String[] y = x.toArray(new String[0]);
         *
         * 请注意，toArray（new Object [0]）在功能上与toArray（）相同
         *
         * @param a 如果a足够大,list中元素将被存储的到a中;否则,将生成一个新的数组.
         * @return 返回包含list中元素的一个数组.
         */
        <T> T[] toArray(T[] a);


        /*---------修改操作--------*/

        /**
         * 插入元素到list结尾(可选操作)
         * on what elements may be added.
         * 支持这一操作的List将会插入元素的类型进行限制.
         * 特别是,一些List可能会拒绝插入null,其它的List将对可能添加的元素的类型施加限制.
         * List类应该在它们的文档说明中清晰表达它们对添加元素类型对限制这一点.
         */
        boolean add(E e);

        //删除list中首次出现的指定值(如果存在),如果不存在,则不进行任何操作.
        boolean remove(Object o);


        /*-------块修改操作--------*/

        //如果list中包含指定Collection中所有元素,则返回true;否则false;
        boolean containsAll(Collection<?> c);

        /**
         * 将传入参数中包含的所有元素都添加到list中,顺序和它们在原Collection中迭代时一致.
         * 如果指定集合在被添加过程中被其它线程修改了,会出现什么影响未作出定义.
         */
        boolean addAll(Collection<? extends E> c);

        /**
         * 将传入参数插入到指定list的位置,将原来该位置及其以后的元素进行后移.插入到list中的元素顺序和它们
         * 之前在Collection中一致.如果指定集合在被添加过程中被其它线程修改了,会出现什么影响未作出定义.
         */
        boolean addAll(int index, Collection<? extends E> c);

        //删除list中和指定集合中相同的元素.
        boolean removeAll(Collection<?> c);

        //删除list中和指定集合不相同的元素.
        boolean retainAll(Collection<?> c);

        /**
         * 用函数接口的返回结果替代原list中的值.
         *
         * 此方法等价实现代码如下:
         * final ListIterator<E> li = list.listIterator();
         * while (li.hasNext()) {
         *      li.set(operator.apply(li.next()));
         * }
         *
         * 如果list的迭代器不支持set操作,当替换第一个元素时,会抛出异常.
         *
         * @since 1.8
         */
        default void replaceAll(java.util.function.UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            final ListIterator<E> li = this.listIterator();
            while (li.hasNext()) {
                li.set(operator.apply(li.next()));
            }
        }

        /**
         * 根据给定比较器,对list中元素排序.
         * 注意:list中的元素都是可以比较的.
         *
         * 如果指定的比较器为nul,list中所有的元素必须实现Comparable接口,然后元素会实现自然排序.
         *
         * list必须能够进行修改,对于能够进行扩容则不要求.
         *
         * 这一方法的默认实现是:获得一个包含list中所有元素的数组,对这个数组进行排序,并遍历该列表，重置数组中
         * 相应位置的每个元素.(这避免了对链表进行排序的性能消耗)
         *
         * @实现注意
         * 本实现采用归并排序.
         * 归并排序特点:稳定,自适应,迭代.
         * 如果输入数组元素部分有序,则其执行时间远远低于n*log(n);
         * 如果输入数组元素顺序随机,其执行时间和传统的归并排序基本一致.
         * 如果输入数组基本有序,本方法则大概需要n次比较即可.
         * 方法执行过程中,临时存储空间大小范围:
         * 最小:常量级别,此时输入数组基本有序;
         * 最大:输入数组长度的1/2,此时输入数组无序.
         *
         * 输入数组是升序还是降序,对方法的执行影响都一样.
         * 但是,对于同一个输入数组的不同部分,倒是可以利用到升序和降序的优势.
         * 这一方法很适合两到多个有序数组的合并:对数组进行简单的连接,并对结果数组进行排序.
         *
         * 算法核心:
         * 1.将list中元素放到一个新生成的数组中.
         * 2.对新数组调用数组的排序方法.
         * 3.将数组中Object类型的元素,在强制类型转换后,重新放入到list中.
         * @since 1.8
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        default void sort(Comparator<? super E> c) {
            //获取当前list中所有对象
            Object[] a = this.toArray();
            //根据比较器c对a排序
            Arrays.sort(a, (Comparator) c);
            //利用迭代器将数组中的元素类型进行强制转型,到原来list中的类型
            ListIterator<E> i = this.listIterator();
            for (Object e : a) {
                i.next();
                i.set((E) e);
            }
        }

        //移除list中的所有元素.
        void clear();

        /*------比较和hash操作----*/

        /**
         * 比较传入对象o和当前list的等价性.
         * 相等条件:
         * 1.o类型为list
         * 2.二者size大小一样
         * 3.list中包含的元素顺序一致.
         */
        boolean equals(Object o);

        /**
         * 返沪list的hash值.计算方法定义如下:
         * int hashCode = 1;
         * for (E e : list)
         *     hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
         *
         * 这一定义保证了两个listequals为true时,其hash值必定一致.
         */
        int hashCode();

        /*-----对list指定位置元素的访问*/

        E get(int index);

        E set(int index, E element);

        void add(int index, E element);

        E remove(int index);


        /*----查找操作----*/

        /**
         * 查找元素首次在list中出现的位置.
         * 如果list中不存在,则返回-1.
         */
        int indexOf(Object o);

        /**
         * 返回查找元素在list中最后一次出现的索引.
         * 如果list中不存在这个元素,则返回-1.
         */
        int lastIndexOf(Object o);


        /*-------list迭代器------*/


        ListIterator<E> listIterator();


        //返回一个从指定位置开始迭代的迭代器.
        ListIterator<E> listIterator(int index);

        /*------视图-----*/

        /**
         * 返回list中从指定区间的元素,范围:[fromIndex,toIndex)
         * 如果fromIndex=toIndex,则返回list为空
         * 返回的list由原list作为支持,因此返回列表中的非结构性更改将反映在此列表中,反之亦然.
         * 返回list支持原list支持的所有list相关的操作.
         *
         * 此方法消除了对显式范围操作（数组通常存在的那种操作）的需要。任何需要列表的操作都可以
         * 通过传递子列表视图而不是整个列表来用作操作范围。例如，下面的习语从列表中删除了一系列元素：
         *
         * list.subList(from, to).clear();
         *
         * index和lastIndexOf也可以使用类似的风格,在Collection类中算法都可以应用于subList中.
         *
         * 如果后备list(母list)发生了结构更改,而这种更改并非来自返回的子list,则由此方法返回的子list
         * 如何定义并未定义.
         * 说明:结构修改是那些改变这个列表的大小，或以其他方式扰乱它，以致正在进行的迭代可能产生不正确的结果
         *
         */
        List<E> subList(int fromIndex, int toIndex);

        /**
         * 基于list中的元素创建一个并行分隔迭代器.
         *
         * 分隔迭代器有两个属性值:SIZED 和 ORDERED.
         * List接口的实现类如果添加了自己的其他属性值,则应该在其文档说明中写出.
         *
         * 默认实现创建了一个基于Iterator,但后期进行了部分元素绑定的迭代器.(我理解为:因为并行分隔迭代器,同一
         * 时刻几个元素都会进行遍历,所以称之为绑定,而原迭代器是顺序遍历元素)
         *
         * @实现注意:
         * 创建的并行分隔迭代器添加了新的属性值:SUBSIZED
         *
         * @since 1.8
         */
        @Override
        default Spliterator<E> spliterator() {
            return Spliterators.spliterator(this, Spliterator.ORDERED);
        }
    }

