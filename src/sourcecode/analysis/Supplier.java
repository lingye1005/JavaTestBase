package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 17/12/24 10:31
 * @ProjectName: JavaBaseTest
 */
/**
 * Represents a supplier of results.
 * 这是一个提供结果的函数接口.
 * 特点:
 * (1)只有返回值
 * (2)没有输入参数
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * get()方法被调用时,对于一定要new出一个新对象 or 生成一个和之前结果不同的值 这两方面,都没有强制规定.
 * 这一接口函数的功能方法为:get()
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}

