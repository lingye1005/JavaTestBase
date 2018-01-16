package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 17/12/23 22:12
 * @ProjectName: JavaBaseTest
 */
import java.util.Objects;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * predicate主要是用于推导真价值的.
 * 使用场景:帮助开发一些返回值为boolean值的函数.
 * 功能函数为:test方法
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #test(Object)}.
 *
 *
 * @param <T> the type of the input to the predicate
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     * 将给定参数和预测做对比,返回一个boolean类型的值.
     * 如何和预测一致,返回true;否则,返回false.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * AND of this predicate and another.  When evaluating the composed
     * predicate, if this predicate is {@code false}, then the {@code other}
     * predicate is not evaluated.
     * 这一方法,返回组合函数的值,实质是:对两个test值做与操作.
     * 函数执行过程:先检查传入参数t的test值,如果为false,直接返回false;否则继续
     * 继续检查传入参数t是否满足:other条件
     *
     * <p>Any exceptions thrown during evaluation of either predicate are relayed
     * to the caller; if evaluation of this predicate throws an exception, the
     * {@code other} predicate will not be evaluated.
     *
     * @param other a predicate that will be logically-ANDed with this
     *              predicate
     * @return a composed predicate that represents the short-circuiting logical
     * AND of this predicate and the {@code other} predicate
     * @throws NullPointerException if other is null
     */
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    /**
     * Returns a predicate that represents the logical negation of this
     * predicate.
     * 返回这个逻辑否定的谓词.
     * 使用方式:predicate.negate().test(value)
     * 如果test值为true,则这个表达式返回false;
     * 否则,返回true.
     *
     * @return a predicate that represents the logical negation of this
     * predicate
     */
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * OR of this predicate and another.  When evaluating the composed
     * predicate, if this predicate is {@code true}, then the {@code other}
     * predicate is not evaluated.
     * 这一方法就是求或.
     * 执行过程:先对参数t求test值,如果为true,则返回;
     * 否则,检验t是否满足other条件,如果满足,返回true;否则返回false.
     *
     *
     * <p>Any exceptions thrown during evaluation of either predicate are relayed
     * to the caller; if evaluation of this predicate throws an exception, the
     * {@code other} predicate will not be evaluated.
     *
     * @param other a predicate that will be logically-ORed with this
     *              predicate
     * @return a composed predicate that represents the short-circuiting logical
     * OR of this predicate and the {@code other} predicate
     * @throws NullPointerException if other is null
     */
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    /**
     * Returns a predicate that tests if two arguments are equal according
     * to {@link Objects#equals(Object, Object)}.
     * 如果两个比较参数的内存地址是否相同.
     * 函数返回结果为:一个谓词
     * 使用方式:
     *  Object obj=new Object();
     *  Object obj2=new Object();
     *  System.out.println(Predicate.isEqual(obj).test(obj2));//输出:false
     * @param <T> the type of arguments to the predicate
     * @param targetRef the object reference with which to compare for equality,
     *               which may be {@code null}
     * @return a predicate that tests if two arguments are equal according
     * to {@link Objects#equals(Object, Object)}
     */
    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}
