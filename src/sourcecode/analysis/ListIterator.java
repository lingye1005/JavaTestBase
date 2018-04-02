        package sourcecode.analysis;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/12 10:33
         * @ProjectName: JavaBaseTest
         */

        import java.util.*;

        /**
         * 这一迭代器允许程序员从list的任意方向对list进行遍历,
         * 在遍历过程中可以修改list,获取迭代器在list中的迭代位置.
         * ListIterator没有当前元素;
         * 它的游标位置总是previous()方法返回的元素和next()方法返回的元素之间.
         *
         * 长度为n的list有(n+1)个游标位置,解释如下:
         * <PRE>
         *                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
         * cursor positions:  ^            ^            ^            ^                  ^
         * </PRE>
         *
         * 注意:remove方法和set方法并不是对游标位置进行定义的;他们是定义在由next()方法 or previous()方法返回的最后
         * 一个元素上的
         *
         * 这一接口是java集合框架中的一员.
         *
         * @since   1.2
         */
        public interface ListIterator<E> extends Iterator<E> {
            /*-------查询操作-------*/

            //从前到后的遍历中,如果list中还有元素未被遍历,则返回true;否则false.
            boolean hasNext();

            //从前到后的遍历中,返回游标后的一个元素.
            E next();

            //从后到前的遍历中,如果list还有元素未被遍历,则返回true;否则false.
            boolean hasPrevious();

            /**
             * 返回将游标位置后退一位的元素.这一方法在list的反向遍历中可以重复 调用.
             * 也可以同next同时混合调用.
             * next和previous相间调用,则重复返回同一个元素.
             */
            E previous();

            // 返回下一个被next调用到元素的索引.
            int nextIndex();

            //返回下一个被previous调用到元素的索引.如果当前游标为0,则下一个返回-1
            int previousIndex();


            /*------修改操作-----*/

            /**
             * 删掉被next()或者previous()方法返回的最后一个元素.
             * 这一方法只能被next或者previous方法调用后,再被调用.
             */
            void remove();

            /**
             * 替换被next()或者previous()返回的元素.
             * 这一方法只能被next或者previous方法调用后,再被调用.
             */
            void set(E e);

            /**
             * 将指定元素插入到list中.
             * 这一元素被插入到next返回值的前面,or插入到被previous返回值的后面.
             */
            void add(E e);
        }
