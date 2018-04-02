        package sourcecode.analysis;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/21 20:42
         * @ProjectName: JavaBaseTest
         */

        import java.util.*;

        /**
         * AbstractSet是set接口的骨架实现,它减少了实现set接口的最少操作.
         *
         * 通过扩展此类来实现集合的过程与通过扩展AbstractCollection来实现集合的过程相同，
         * 不同之处在于此类的所有子类中的所有方法和构造函数都必须遵守由 Set接口 强加的额外约束。
         * (例如，add方法不允许将一个对象的多个实例添加到集合中)
         *
         * 注意:AbstractSet并没有覆盖任何AbastractCollection类.
         * 它仅仅添加了equals()和hashcode()方法.
         *
         * AbstractSet是java集合框架中的一员.
         *
         * @since 1.2
         */

        public abstract class AbstractSet<E> extends AbstractCollection<E> implements java.util.Set<E> {

            //唯一构造器方法,目的是为了子类对其调用.
            protected AbstractSet() {
            }

            /*-------比较和hash相关的方法--------*/


            //常见的equals执行步骤
            public boolean equals(Object o) {
                //o是否为当前对象
                if (o == this)
                    return true;

                //类型是否为set
                if (!(o instanceof java.util.Set))
                    return false;
                //强制转化
                Collection<?> c = (Collection<?>) o;
                //比较size
                if (c.size() != size())
                    return false;
                try {
                    //调用AbstractCollection的方法
                    return containsAll(c);
                } catch (ClassCastException unused)   {
                    return false;
                } catch (NullPointerException unused) {
                    return false;
                }
            }

            //hash值=sum(所有元素的hash值)
            public int hashCode() {
                int h = 0;
                Iterator<E> i = iterator();
                while (i.hasNext()) {
                    E obj = i.next();
                    if (obj != null)
                        h += obj.hashCode();
                }
                return h;
            }

            //
            public boolean removeAll(Collection<?> c) {
                //c不能为空
                Objects.requireNonNull(c);

                //set结构更改标志位:初始化为false
                boolean modified = false;

                //如果set的大小>参数集合c的大小
                if (size() > c.size()) {
                    //迭代删除,并更新modified标志位
                    for (Iterator<?> i = c.iterator(); i.hasNext(); )
                        modified |= remove(i.next());
                } else {
                    //如果set的大小<参数集合c的大小,则set进行迭代
                    for (Iterator<?> i = iterator(); i.hasNext(); ) {
                        if (c.contains(i.next())) {
                            //删除上一次迭代访问的元素,达到删除目的
                            i.remove();
                            //更改修改标志位modified
                            modified = true;
                        }
                    }
                }
                return modified;
            }

        }
