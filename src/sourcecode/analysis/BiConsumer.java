package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 18/3/8 15:54
 * @ProjectName: JavaBaseTest
 */
import java.util.Objects;

/**
 * to operate via side-effects.
 * 本函数接口特征:
 * 1.输入参数2个.
 * 2.无输出结果
 * 3.本函数接口和Consumer函数接口唯一区别:
 * 4.和其它函数接口不同的是:BiConsumer接口的操作是通过其副作用而完成的.
 * 5.本函数接口功能方法:accept(t,u)
 *
 * @param <T> 第一个操作参数类型
 * @param <U> 第二个操作参数类型
 *
 * @see java.util.function.Consumer
 * @since 1.8
 */
@FunctionalInterface
public interface BiConsumer<T, U> {

    /**
     * 本方法的调用,会对输入参数执行指定的行为
     * @param t 第一个输入参数
     * @param u 第二个输入参数
     */
    void accept(T t, U u);

    /**
     * andThen方法,会执行两次Consumer接口的accept方法.两次执行顺序上,先对输入参数执行accept()方法;然后
     * 再对输入参数执行一次after.accept()方法.(注意:两次均为对输入参数的操作,after操作并不是对第一次accept结果的操作)
     * 这两次任何一次accept操作出现问题,都将抛异常到方法调用者处.
     * 如果执行accept这一操作出现异常,fater操作将不会执行.
     * @return 一个按顺序执行的组合的{BiConsumer} 操作后面跟着{@code after}操作
     */
    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);

        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }
}

