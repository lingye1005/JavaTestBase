package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 17/12/23 21:09
 * @ProjectName: JavaBaseTest
 * <></>
 */

import java.util.Objects;

/**
 * Represents a function that accepts one argument and produces a result.
 * 接受一个参数,并返回一个结果值.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 * 这是一个函数接口,它的函数方法为:apply
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     * 对给定参数,使用本函数.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);

    /**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     * 此方法返回一个组合函数.
     * 这一函数的执行过程:先对参数执行before函数,然后对结果执行apply函数.
     * before函数和apply函数,任一函数执行出现异常,则异常会被转到组合函数compose那里.
     *
     * ----本函数:体现了前套关系
     *
     * @param <V> the type of input to the {@code before} function, and to the
     *           composed function
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     *
     * @see #andThen(Function)
     */
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     * andThen方法,返回一个组合函数.
     * andThen方法的执行过程:先对输入参数执行apply函数,然后对结果执行after函数.
     * apply函数和apply函数,任一函数执行出现异常,则异常会被转到这一组合函数的调用者那里.
     *
     * ----本函数:转换了嵌套的顺序
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #compose(Function)
     */
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    /**
     * Returns a function that always returns its input argument.
     * 传递自身的函数
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}

