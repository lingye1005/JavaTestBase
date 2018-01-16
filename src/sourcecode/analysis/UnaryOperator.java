package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 17/12/23 22:03
 * @ProjectName: JavaBaseTest
 */

/**
 * Represents an operation on a single operand that produces a result of the
 * same type as its operand.  This is a specialization of {@code Function} for
 * the case where the operand and result are of the same type.
 * 这一函数只有一个参数,且返回结果和输入参数一致.
 * 这一接口继承于Function接口.
 * 其功能方法为apply.(这一点由其继承接口决定)
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 *
 * @param <T> the type of the operand and result of the operator
 *
 * @see java.util.function.Function
 * @since 1.8
 */
@FunctionalInterface
public interface UnaryOperator<T> extends java.util.function.Function<T, T> {

    /**
     * Returns a unary operator that always returns its input argument.
     *
     * @param <T> the type of the input and output of the operator
     * @return a unary operator that always returns its input argument
     */
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
