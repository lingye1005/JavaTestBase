package sourcecode.analysis;

/**
 * Created by caoxiaohong on 17/11/18 23:14.
 */

import java.util.*;

/**
 * This interface imposes a total ordering on the objects of each class that
 * implements it.  This ordering is referred to as the class's <i>natural
 * ordering</i>, and the class's <tt>compareTo</tt> method is referred to as
 * its <i>natural comparison method</i>.<p>
 *
 * 这一接口会对实现了它的类施加一个整体的顺序.这一顺序被认为是类的自然顺序,类的比较方法compareTo()也被认为是自然比较方法.
 *
 * Lists (and arrays) of objects that implement this interface can be sorted
 * automatically by {@link Collections#sort(List) Collections.sort} (and
 * {@link Arrays#sort(Object[]) Arrays.sort}).  Objects that implement this
 * interface can be used as keys in a {@linkplain SortedMap sorted map} or as
 * elements in a {@linkplain SortedSet sorted set}, without the need to
 * specify a {@linkplain Comparator comparator}.<p>
 *
 * 实现类这一接口的List类对象使用Collections.sort方法实现自动排序(升序),数组使用Arrays.sort()方法实现升序排序.实现这一接口的对象在
 * 有序Map中,有序是按照key进行排序的;在有序Set中,是按照set集合中的元素排序的.而使用这些方法时,我们并不需要指定比较器comparator(说明:
 * 这些排序都是默认升序排序,且排序字段只有一个.如果一个类有多个排序字段,要对这个类集合进行排序,则需要重写比较器方法).
 *
 * The natural ordering for a class <tt>C</tt> is said to be <i>consistent
 * with equals</i> if and only if <tt>e1.compareTo(e2) == 0</tt> has
 * the same boolean value as <tt>e1.equals(e2)</tt> for every
 * <tt>e1</tt> and <tt>e2</tt> of class <tt>C</tt>.  Note that <tt>null</tt>
 * is not an instance of any class, and <tt>e.compareTo(null)</tt> should
 * throw a <tt>NullPointerException</tt> even though <tt>e.equals(null)</tt>
 * returns <tt>false</tt>.<p>
 *
 * 对于类C的任意变量e1和e2,当且仅当e1.compareTo(e2) == 0的和e1.equals(e2)有相同的返回值时,类的自然排序才能被认为是和equals方法的
 * 结果保持一致的.
 * 注意:虽然e.equals(null)返回值为false,但是null不是任何类的实例,所以如果调用方法e.compareTo(null)应该抛出异常NullPointerException
 *
 * It is strongly recommended (though not required) that natural orderings be
 * consistent with equals.  This is so because sorted sets (and sorted maps)
 * without explicit comparators behave "strangely" when they are used with
 * elements (or keys) whose natural ordering is inconsistent with equals.  In
 * particular, such a sorted set (or sorted map) violates the general contract
 * for set (or map), which is defined in terms of the <tt>equals</tt>
 * method.<p>
 *
 * 我们强烈建议(尽管并不是必须的):自然排序应该和equals结果保持一致(这是因为自然排序用到了compare方法,这里的意思是需要满足关系:
 * e1.compareTo(e2) == 0的和e1.equals(e2)有相同的返回值).这是因为没有明确比较器的有序set(和有序map)
 * (什么叫没有明确比较器?对于TreeSet和TreeMap,都有多个实例构造函数,而其中有一个无参构造函数,就指定了比较器comparator = null;同时,
 * 这也说明了,如果你想在建立有序set或者有序map时就指定它的排序方法,那么可以给构造函数传入一个比较器参数即可.),如果自然排序不能和equals方法
 * 保持一致,那么它们会表现出一些诡异的行为.而且,这样的有序set(或者map)和equals中通用规范是矛盾的。
 *
 * For example, if one adds two keys <tt>a</tt> and <tt>b</tt> such that
 * <tt>(!a.equals(b) && a.compareTo(b) == 0)</tt> to a sorted
 * set that does not use an explicit comparator, the second <tt>add</tt>
 * operation returns false (and the size of the sorted set does not increase)
 * because <tt>a</tt> and <tt>b</tt> are equivalent from the sorted set's
 * perspective.<p>
 *
 * 举个例子:如果向一个没有明确比较器的有序set中添加2个值a和b(a.equals(b)值为false,而 a.compareTo(b) == 0 值为true(a==b)),
 * 那么第二次的add操作会失败,因为从有序set的角度看,a和b是等值的.(出现这种事情就很诡异了,明明a在add之后,b再add时,这是两个不同的值,应该被正常
 * 添加到集合中,但是却被拒绝了,因为add时,使用到了方法compare,去比较插入的值是否存在,而根据返回结果为0,这样二者就被认为是相同的值.所以
 * 我们一再强调:为避免这种异常,自然排序要和equals结果保持一致,必须满足e1.compareTo(e2) == 0的和e1.equals(e2)始终有相同的返回值)
 *
 * Virtually all Java core classes that implement <tt>Comparable</tt> have natural
 * orderings that are consistent with equals.  One exception is
 * <tt>java.math.BigDecimal</tt>, whose natural ordering equates
 * <tt>BigDecimal</tt> objects with equal values and different precisions
 * (such as 4.0 and 4.00).<p>
 *
 * 实质上,所有实现了Comparable接口的java核心类,都满足自然排序的要求.唯一的例外类是:BigDecimal类.它的自然排序要求是:值相等而精度是不等的.
 * 所以,精度不同但值相同的两个BigDecimal对象,它们的equals方法返回值应该为true,而compare()方法应该返回0:
 * 测试用例如下:
 * import java.math.BigDecimal;
 *
   public class testCode  {
       public static void main(String[] args){
             BigDecimal a=new BigDecimal(2.30);
             BigDecimal b=new BigDecimal(2.3);
             System.out.println("a.equals(b): "+a.equals(b));
             System.out.println("a.compareTo(b): "+a.compareTo(b));
       }
   }

   输出结果:
   a.equals(b): true
   a.compareTo(b): 0

 *
 * For the mathematically inclined, the <i>relation</i> that defines
 * the natural ordering on a given class C is:<pre>
 *       {(x, y) such that x.compareTo(y) &lt;= 0}.
 * </pre> The <i>quotient</i> for this total order is: <pre>
 *       {(x, y) such that x.compareTo(y) == 0}.
 * </pre>
 *
 * It follows immediately from the contract for <tt>compareTo</tt> that the
 * quotient is an <i>equivalence relation</i> on <tt>C</tt>, and that the
 * natural ordering is a <i>total order</i> on <tt>C</tt>.  When we say that a
 * class's natural ordering is <i>consistent with equals</i>, we mean that the
 * quotient for the natural ordering is the equivalence relation defined by
 * the class's {@link Object#equals(Object) equals(Object)} method:<pre>
 *     {(x, y) such that x.equals(y)}. </pre><p>
 *
 * 商是类C上面的等价关系,自然排序是对类C上面的元素整体的一个排序,这符合compareTo的通用规范.
 * 当我们说一个类的自然排序是和equals结果保持一致.那就意味着自然排序的商是由这个类的equals方法定义的等价关系.
 * Q:什么叫和equals方法结果保持一致呢?
 * A:(1)要知道自然排序是指有序Map和有序Set没有指定比较器,也就是这样的有序Map和有序Set里面的元素是采用默认的升序排序的(Map按照key升序排序,
 * Set按照element升序排序).
 * (2)在自然排序中,用到了方法compare,所谓的自然排序和equals保持一致是指满足这样一个公式:
 * x.compareTo(y)==0和x.equals(y)返回的结果值一致.
 * 至于为什么这样要求,下面会有解释的(因为不一致,会出现很诡异的问题,哈哈哈)
 *
 * This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <T> the type of objects that this object may be compared to
 *
 * @author  Josh Bloch
 * @see java.util.Comparator
 * @since 1.2
 */

public interface Comparable<T> {
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * 将当前对象a和指定对象b进行比较.
     * a>b:返回正数;
     * a=b:返回0;
     * a<b:返回负数;
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception if
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * 实现这一接口的类必须保证对于任意的x和y,都应该满足的条件是:sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
     * 这意味如果y.compareTo(x)抛出异常,则x.compareTo(y)必须抛出异常.
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * 实现这个接口的类还必须保证:联系是具有传递性的:
     * 如果: x.compareTo(y) && y.compareTo(z)成立,则:x.compareTo(z)也成立.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * 最后,实现这个的类必须保证:对于任意的z,如果x.compareTo(y)==0成立,则sgn(x.compareTo(z)) == sgn(y.compareTo(z))也成立.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * 我们强烈建议,但并非严格约定:x.compareTo(y)==0和x.equals(y)的返回值一致.
     * 通常,任何实现了Comparable接口但违反了这一条件的类应该明确的表明这一事实.
     * 作为这一事实的提醒语言,它可以这样写: 注意:这个类的自然排序并没有和equals结果保持一致.
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * 在前面的表述中,用到的符号sgn是数学函数signum的一种表达式,它定义了:
     * sgn的参数为负数,返回-1;
     * sgn的参数为正数,返回1;
     * sgn的参数为0,返回0.
     *
     * @param   o the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     */
    public int compareTo(T o);
}
