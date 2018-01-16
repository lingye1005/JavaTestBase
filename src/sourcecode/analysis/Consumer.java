package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 17/12/23 23:35
 * @ProjectName: JavaBaseTest
 */

import java.util.Objects;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 * 本函数接口特点:
 * (1)输入参数只有一个
 * (2)没有返回结果
 *
 * 和其它函数接口的区别:Consumer函数期望通过副作用从而完成操作.
 * 这一函数接口的功能函数为:accept(T t)
 * 
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <T> the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     * 对输入参数执行操作
     * @param t the input argument
     */
    void accept(T t);

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * andThen方法,会执行两次Consumer接口的accept方法,
     * 执行顺序上,先对输入参数执行accept方法;然后再对a输入参数执行after方法.(注意:两次都是对同一个输入参数的操作,而不是第二次是对第一次操作的结果做处理)
     * 任一方法执行出现异常,则异常会被抛给本函数接口的调用者.
     * 如果执行accept方法时出现异常,则after方法不会再被继续执行.
     *
     * Consumer<Integer> consumer1=x->{System.out.println("consumer is :"+x+1);};
       Consumer<Integer> consumer2=x->{System.out.println("con2 is:"+x);};
       consumer1.andThen(consumer2).accept(100);
     * 输出:
     * consumer is :1001
     * con2 is:100
     *
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

