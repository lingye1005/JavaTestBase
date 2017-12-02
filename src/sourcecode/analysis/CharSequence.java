package sourcecode.analysis;

/**
 * Created by caoxiaohong on 17/11/18 23:18.
 */

import java.lang.*;

/**
 * A <tt>CharSequence</tt> is a readable sequence of <code>char</code> values. This
 * interface provides uniform, read-only access to many different kinds of
 * <code>char</code> sequences.
 * A <code>char</code> value represents a character in the <i>Basic
 * Multilingual Plane (BMP)</i> or a surrogate. Refer to <a
 * href="Character.html#unicode">Unicode Character Representation</a> for details.
 *
 * CharSequence就是一个可读的字符序列.对于不同类型的字符序列,这一接口都以统一且只读的方式去读取.
 * 一个字符值代表了BMP中的一个字符或者一个代理.(BMP是什么?BMP包含了现代大多数语言的字符集)
 *
 * <p> This interface does not refine the general contracts of the {@link
 * java.lang.Object#equals(java.lang.Object) equals} and {@link
 * java.lang.Object#hashCode() hashCode} methods.  The result of comparing two
 * objects that implement <tt>CharSequence</tt> is therefore, in general,
 * undefined.  Each object may be implemented by a different class, and there
 * is no guarantee that each class will be capable of testing its instances
 * for equality with those of the other.  It is therefore inappropriate to use
 * arbitrary <tt>CharSequence</tt> instances as elements in a set or as keys in
 * a map. </p>
 *
 * 这一接口,并没有改进Object类定义的equals()方法和hashCode()方法的通用规范.因此,对于两个实现了CharSequence接口的的对象,进行比较时,
 * 通常,其结果也是未定义的(因为对于继承了Object的类来说,根据具体的实现,比较时,是可以有两种选择的,要么比较地址,使用两个等号==,要么比较
 * 内容,使用equals.但是这个接口并没有定义equals方法,也没有用到通常我们做两个对象比较时,用到的equals方法和hashCode方法之间的关系,也就是
 * 你重写equals方法时,必须重写hashCode方法,这一点我之前在Object源码的分析中说过了).
 * 每个对象都可以由不同的类来实现,因此,我们无法保证每个类都有能和其他类实例测试等价性的能力.因此,使用任意的CharSequence实例作为set集合
 * 的元素或者map中的key,这种做法都是不合适的(为什么不合适呢?因为CharSequence实例是没有equals方法和hashCode方法的,这样的两个对象之间
 * 就无法完成比较,所以一旦被比较,出现什么结果都是不可控的,故不适合.).
 *
 * @author Mike McCloskey
 * @since 1.4
 * @spec JSR-51
 */

public interface CharSequence {
    /**
     * Returns the length of this character sequence.  The length is the number
     * of 16-bit <code>char</code>s in the sequence.</p>
     *
     * 返回字符序列的长度.
     * 长度是16bit的整数倍.(因为String类采用的是UTF-16编码,一个字符占用2个字节长度)
     *
     * @return  the number of <code>char</code>s in this sequence
     */
    int length();

    /**
     * Returns the <code>char</code> value at the specified index.  An index ranges from zero
     * to <tt>length() - 1</tt>.  The first <code>char</code> value of the sequence is at
     * index zero, the next at index one, and so on, as for array
     * indexing. </p>
     *
     * 返回指定索引index位置处的字符.索引index的范围是[0,length()-1].
     *
     * <p>If the <code>char</code> value specified by the index is a
     * <a href="{@docRoot}/java/lang/Character.html#unicode">surrogate</a>, the surrogate
     * value is returned.
     *
     * 如果指定索引位置处的字符值为代表(字符)(surrogate的出现原因:因为UTF-16采用2个字节存储一个字符,但是有的字符存储只需要一个字节,比如英文
     * 字符,那么下一个字节也不能继续存储其他的字符,而只能存储一个代表字符,来占用这一个字节的位置,接下来的一个字节处才能继续存储下一个字符),
     * 那么返回的也会是这个代表(字符)值.
     *
     * @param   index   the index of the <code>char</code> value to be returned
     *
     * @return  the specified <code>char</code> value
     *
     * @throws  IndexOutOfBoundsException
     *          if the <tt>index</tt> argument is negative or not less than
     *          <tt>length()</tt>
     */
    char charAt(int index);

    /**
     * Returns a new <code>CharSequence</code> that is a subsequence of this sequence.
     * The subsequence starts with the <code>char</code> value at the specified index and
     * ends with the <code>char</code> value at index <tt>end - 1</tt>.  The length
     * (in <code>char</code>s) of the
     * returned sequence is <tt>end - start</tt>, so if <tt>start == end</tt>
     * then an empty sequence is returned. </p>
     *
     * 返回一个新的字符序列,这个序列是原字符序列的子序列.
     * 子序列的截取开始位置为:原序列中start的位置;
     *        截取结束位置为:原序列中(end-1)的位置.
     * 因此子字符序列的长度为(end-start)
     * 所以,如果传入参数start=end,则返回子序列为空序列.
     *
     * @param   start   the start index, inclusive
     * @param   end     the end index, exclusive
     *
     * @return  the specified subsequence
     *
     * @throws  IndexOutOfBoundsException
     *          if <tt>start</tt> or <tt>end</tt> are negative,
     *          if <tt>end</tt> is greater than <tt>length()</tt>,
     *          or if <tt>start</tt> is greater than <tt>end</tt>
     */
    CharSequence subSequence(int start, int end);

    /**
     * Returns a string containing the characters in this sequence in the same
     * order as this sequence.  The length of the string will be the length of
     * this sequence. </p>
     *
     * 返回字符序列的字符串形式,字符串中字符的顺序和字符序列保持一致.字符串的长度和字符序列一致.
     *
     * @return  a string consisting of exactly this sequence of characters
     */
    public java.lang.String toString();
}
