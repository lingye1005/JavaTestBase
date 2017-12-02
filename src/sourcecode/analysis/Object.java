//package sourcecode.analysis;
//
///**
// * Created by caoxiaohong on 17/11/13 11:08.
// */
//
///**
// * Class {@code Object} is the root of the class hierarchy.
// * Every class has {@code Object} as a superclass. All objects,
// * including arrays, implement the methods of this class.
// *
// * Object类是类继承中的根类.
// * 每一个类都直接或间接的以Object为父类.
// * 所有的对象,包括数组,都实现了Object类的方法.
// * Object类有7个native方法,也就是调用了本地方法.这些方法在java层次不会给出实现,而是在其它语言(C或者C++)的实现文件中.
// * java语言本身不能对操作系统底层进行访问和操作,但是可用通过JNI接口调用其它语言来实现对底层的访问.
// *
// * @author  unascribed
// * @see     java.lang.Class
// * @since   JDK1.0
// */
//
//public class Object {
//    /**
//     * 方法属性分析:
//     * (1)私有:对其它类不可见
//     * (2)静态:不依赖类实例,即可调用.
//     * (3)使用了本地方法:故方法调用时,性能开销加大
//     * (4)返回类型为void
//     */
//    private static native void registerNatives();
//
//    /**
//     * 静态语句块
//     * 调用了上面的registerNatives()方法,故调用了本地方法.
//     *
//     * 静态语句块什么时候被执行?
//     * 根据JVM中类加载机制原理:在类加载的最后一个阶段,就是初始化阶段:要执行类构造器方法clinit().(注意这个方法和实例构造器方法
//     * 或者说类的构造函数是两个东西,那我们通常的一些初始化操作是在实例构造器方法中操作的).clinit()方法都完成
//     * 哪些工作呢?它要执行.class文件的字节码,完成程序员为类变量的真正赋值和执行静态代码块.它就这2个任务.
//     * 所以根据静态语句块的执行时间,我们就知道,在Object类初始化时,此方法会被JVM自动调用.
//     *
//     * 这个静态语句块功能有哪些?
//     * 对几个本地方法进行注册（即初始化java方法映射到C的方法）。需要注意的是，很多类中都有这个方法，但是执行注册的目标是不同的。
//     * System类中也有该方法，但是它注册的方法是另一些方法。
//     *
//     */
//    static {
//        registerNatives();
//    }
//
//    /**
//     * Returns the runtime class of this {@code Object}. The returned
//     * {@code Class} object is the object that is locked by {@code
//     * static synchronized} methods of the represented class.
//     *
//     * <p><b>The actual result type is {@code Class<? extends |X|>}
//     * where {@code |X|} is the erasure of the static type of the
//     * expression on which {@code getClass} is called.</b> For
//     * example, no cast is required in this code fragment:</p>
//     *
//     * native:方法调用了本地方法;
//     * final:方法不可被子类覆写.
//     *
//     * 返回这个对象的运行时类.返回对象来自:代表类的静态同步方法
//     * 当getClass方法被调用时,父类会作为静态类型被擦除,因此实际返回的实际类型为子类类型.
//     * 因此:在这部分代码的执行过程中,不会涉及到类型转换.
//     *
//     * 方法功能:获取当前对象的一个运行时类.
//     *
//     *
//     * 如何理解方法功能?
//     * 例子:code如下:
//        package sourcecode.analysis;
//
//        class A{}
//        class B extends A{}
//        public class testCode  {
//            public static void main(String[] args){
//                A b=new B();
//                System.out.println(b.getClass());//输出结果: class sourcecode.analysis.B
//            }
//        }
//     *
//     *
//     * <p>
//     * {@code Number n = 0;                             }<br>
//     * {@code Class<? extends Number> c = n.getClass(); }
//     * </p>
//     *
//     * @return The {@code Class} object that represents the runtime
//     *         class of this object.
//     * @see    Class Literals, section 15.8.2 of
//     *         <cite>The Java&trade; Language Specification</cite>.
//     */
//    public final native Class<?> getClass();
//
//    /**
//     * Returns a hash code value for the object. This method is
//     * supported for the benefit of hash tables such as those provided by
//     * {@link java.util.HashMap}.
//     * <p>
//     * The general contract of {@code hashCode} is:
//     * <ul>
//     * <li>Whenever it is invoked on the same object more than once during
//     *     an execution of a Java application, the {@code hashCode} method
//     *     must consistently return the same integer, provided no information
//     *     used in {@code equals} comparisons on the object is modified.
//     *     This integer need not remain consistent from one execution of an
//     *     application to another execution of the same application.
//     * <li>If two objects are equal according to the {@code equals(Object)}
//     *     method, then calling the {@code hashCode} method on each of
//     *     the two objects must produce the same integer result.
//     * <li>It is <em>not</em> required that if two objects are unequal
//     *     according to the {@link java.lang.Object#equals(java.lang.Object)}
//     *     method, then calling the {@code hashCode} method on each of the
//     *     two objects must produce distinct integer results.  However, the
//     *     programmer should be aware that producing distinct integer results
//     *     for unequal objects may improve the performance of hash tables.
//     * </ul>
//     * <p>
//     * As much as is reasonably practical, the hashCode method defined by
//     * class {@code Object} does return distinct integers for distinct
//     * objects. (This is typically implemented by converting the internal
//     * address of the object into an integer, but this implementation
//     * technique is not required by the
//     * Java<font size="-2"><sup>TM</sup></font> programming language.)
//     *
//     * 访问类型:public
//     * native:调用了本地方法
//     * int:返回类型
//     * 因为是非final方法,所以可被子类覆写此方法.
//     *
//     * 功能:返回当前对象的哈希值.
//     * 这一方法由哈希表来支持,比如这些哈希值由java.util.HashMap提供.
//     *
//     * 对于哈希值的基本规定:
//     * 在java应用的同一次执行过程中,对同一个对象多次调用hashCode方法,假如用于equals方法的比较信息没有改变,则返回的哈希值必须一致.
//     * 但是注意:在java应用的不同次执行过程中,同一个对象的哈希值不一定一致.
//     * 如果两个对象通过equals方法比较后,返回true,则分别对两个对象调用hashCode方法,返回结果必须一致.
//     * 如果两个对象通过equals方法比较后,返回false,再分别对两对象调用hashCode方法,返回结果可以一致也可以不一致.
//     * 然而,程序员应该意识到,两个不equal的对象,最好能使得它们的哈希值不一致,从而提升哈希表的性能.
//     *
//     * 通过了尽量多的合理的实际测试,(我们发现)通过Object类定义的hashCode方法对不同的对象并没有返回不同的哈希值.(这通常需要将对象的内部
//     * 地址转为一个整数,但是这一实现技术并不是java语言所必须的.)但是,我写了一下测试用例,发现这里给的定义好像不太对,(难道我翻译的有问题
//     * ...),感觉是不是JDK1.8这里改过了,就是两个Object对象分别调用hashCode方法,返回的哈希值是不一样的呢,如下code:
//     *
//     *   package sourcecode.analysis;
//
//         public class testCode  {
//             public static void main(String[] args){
//                 Object a=new Object();
//                 Object b=new Object();
//                 Object c=new Object();
//                 System.out.println("a的哈希值: "+a.hashCode());//a的哈希值: 2016447921
//                 System.out.println("b的哈希值: "+b.hashCode());//b的哈希值: 666988784
//                 System.out.println("c的哈希值: "+c.hashCode());//c的哈希值: 1414644648
//             }
//         }
//     *
//     * @return  a hash code value for this object.
//     * @see     java.lang.Object#equals(java.lang.Object)
//     * @see     java.lang.System#identityHashCode
//     */
//    public native int hashCode();
//
//    /**
//     * Indicates whether some other object is "equal to" this one.
//     * <p>
//     * The {@code equals} method implements an equivalence relation
//     * on non-null object references:
//     * <ul>
//     * <li>It is <i>reflexive</i>: for any non-null reference value
//     *     {@code x}, {@code x.equals(x)} should return
//     *     {@code true}.
//     * <li>It is <i>symmetric</i>: for any non-null reference values
//     *     {@code x} and {@code y}, {@code x.equals(y)}
//     *     should return {@code true} if and only if
//     *     {@code y.equals(x)} returns {@code true}.
//     * <li>It is <i>transitive</i>: for any non-null reference values
//     *     {@code x}, {@code y}, and {@code z}, if
//     *     {@code x.equals(y)} returns {@code true} and
//     *     {@code y.equals(z)} returns {@code true}, then
//     *     {@code x.equals(z)} should return {@code true}.
//     * <li>It is <i>consistent</i>: for any non-null reference values
//     *     {@code x} and {@code y}, multiple invocations of
//     *     {@code x.equals(y)} consistently return {@code true}
//     *     or consistently return {@code false}, provided no
//     *     information used in {@code equals} comparisons on the
//     *     objects is modified.
//     * <li>For any non-null reference value {@code x},
//     *     {@code x.equals(null)} should return {@code false}.
//     * </ul>
//     * <p>
//     * The {@code equals} method for class {@code Object} implements
//     * the most discriminating possible equivalence relation on objects;
//     * that is, for any non-null reference values {@code x} and
//     * {@code y}, this method returns {@code true} if and only
//     * if {@code x} and {@code y} refer to the same object
//     * ({@code x == y} has the value {@code true}).
//     * <p>
//     * Note that it is generally necessary to override the {@code hashCode}
//     * method whenever this method is overridden, so as to maintain the
//     * general contract for the {@code hashCode} method, which states
//     * that equal objects must have equal hash codes.
//     *
//     * 这一方法表明了:一些对象是否和当前这个对象"相等".
//     * equals方法表明了一种非null对象之间的等价关系:注意以下(1)-(4)都是建立在对象为非null的基础上面.
//     * (1)自反性:x.equals(x)始终返回true.
//     * (2)对称性:如果x.equals(y)返回true,则y.equals(x)也返回true.
//     * (3)传递性:如果x.equals(y)返回true,且y.equals(z)返回true,则x.equals(z)一定返回true.
//     * (4)一致性:如果被比较的两个对象,在一次java应用中,被用于equals比较的内容始终没有发生改变,那么在这个应用的多次调用过程中,返回结果
//     * 应该始终为false或者始终为true.
//     * (5)设对象x为非null对象,则x.equals(null)始终返回false.
//     *
//     * Object类的equals方法实现了对象之间的最可能的等价关系;换句话说,任何非null的两个引用对象x和y,当且仅当x和y都指向同一个对象时,
//     * 结果才会返回true.
//     *
//     * 注意:当equals方法被重写时,hashCode方法有必要重写,这是为了维护hashCode方法的规约,当然这也表明了equals结果返回true的两个
//     * 对象一定有相同的哈希值.
//     *
//     * 方法分析:
//     * 访问修饰符:public
//     * 返回类型:boolean
//     * 比较内容:被比较对象是否和当前Object是同一个类,因为用的是==,所以比较的是地址,如果地址相同,那么必须是同一个对象嘛
//     * 本方法:可以被子类覆写.
//     *
//     * 注意:equals方法的最根本实现就是==这里,因此,对于一些自定义的类,如果调用了equals方法,那么两个对象被比较的就是内存地址,所以你是
//     * 直接使用==来比较两个对象,还是通过equals方法来比较对象,其比较的内容都是一样的;
//     * 但是,如果如果类对象覆写了equals方法,来进行两个对象的内容比较,比如String类,那么此时你调用equals方法和直接使用==来比较两个
//     * 对象,比较的实质就不一样了,因为equals比较的是对象的内容,而==比较的是两个对象的地址.
//     * 所以,片面的说==比较的地址,而equals比较的是内容,这一说法是有问题的.
//     *
//     * @param   obj   the reference object with which to compare.
//     * @return  {@code true} if this object is the same as the obj
//     *          argument; {@code false} otherwise.
//     * @see     #hashCode()
//     * @see     java.util.HashMap
//     */
//    public boolean equals(Object obj) {
//        return (this == obj);
//    }
//
//    /**
//     * Creates and returns a copy of this object.  The precise meaning
//     * of "copy" may depend on the class of the object. The general
//     * intent is that, for any object {@code x}, the expression:
//     * <blockquote>
//     * <pre>
//     * x.clone() != x</pre></blockquote>
//     * will be true, and that the expression:
//     * <blockquote>
//     * <pre>
//     * x.clone().getClass() == x.getClass()</pre></blockquote>
//     * will be {@code true}, but these are not absolute requirements.
//     * While it is typically the case that:
//     * <blockquote>
//     * <pre>
//     * x.clone().equals(x)</pre></blockquote>
//     * will be {@code true}, this is not an absolute requirement.
//     * <p>
//     * By convention, the returned object should be obtained by calling
//     * {@code super.clone}.  If a class and all of its superclasses (except
//     * {@code Object}) obey this convention, it will be the case that
//     * {@code x.clone().getClass() == x.getClass()}.
//     * <p>
//     * By convention, the object returned by this method should be independent
//     * of this object (which is being cloned).  To achieve this independence,
//     * it may be necessary to modify one or more fields of the object returned
//     * by {@code super.clone} before returning it.  Typically, this means
//     * copying any mutable objects that comprise the internal "deep structure"
//     * of the object being cloned and replacing the references to these
//     * objects with references to the copies.  If a class contains only
//     * primitive fields or references to immutable objects, then it is usually
//     * the case that no fields in the object returned by {@code super.clone}
//     * need to be modified.
//     * <p>
//     * The method {@code clone} for class {@code Object} performs a
//     * specific cloning operation. First, if the class of this object does
//     * not implement the interface {@code Cloneable}, then a
//     * {@code CloneNotSupportedException} is thrown. Note that all arrays
//     * are considered to implement the interface {@code Cloneable} and that
//     * the return type of the {@code clone} method of an array type {@code T[]}
//     * is {@code T[]} where T is any reference or primitive type.
//     * Otherwise, this method creates a new instance of the class of this
//     * object and initializes all its fields with exactly the contents of
//     * the corresponding fields of this object, as if by assignment; the
//     * contents of the fields are not themselves cloned. Thus, this method
//     * performs a "shallow copy" of this object, not a "deep copy" operation.
//     * <p>
//     * The class {@code Object} does not itself implement the interface
//     * {@code Cloneable}, so calling the {@code clone} method on an object
//     * whose class is {@code Object} will result in throwing an
//     * exception at run time.
//     *
//     * 创建并返回当前对象的一个副本.复制的确切意思,可能依赖于对象的类别.对于任意对象x,复制通常该有的属性包括:
//     * (1)x.clone()!=x 结果为true;
//     * (2)x.clone().getClass() == x.getClass() 结果为true;但这不是绝对的要求.尽管通常情况是这样的.
//     * (3)x.clone().equals(x) 结果为true,但这不是绝对的要求.
//     * 按照惯例,返回对象应该通过super.clone()来获得.如果一个类和它所有的父类(父类除去Object类)都遵守了这一约定,结果就是
//     * x.clone().getClass() == x.getClass()
//     * 按照惯例,通过clone方法返回的对象应该独立于当前对象.为了实现独立性,在返回这个副本之前,很有必要修改这个对象至少一处的域.
//     * 通常,这样就意味着:复制被拷贝对象的所有可更改的对象,然后根据副本来替换这些引用.如果一个类只包含了一个基本类型,或者包含了不可
//     * 更改的对象引用,那就意味着,在这个copy的副本中,在返回之前没有需要更改的域.
//     *
//     * Object类的clone()方法代表了一种特定的复制操作.
//     * 首先,如果对象类没有实现Cloneable接口,CloneNotSupportedException异常将会被抛出.
//     * (注意,所有数组都被认为实现了Cloneable接口,并且不管数组类型是基本类型还是引用类型,那么这个方法返回的数组类型都和原数组保持一致.)
//     * 否则,这一方法会创建一个当前类对象的一个新实例,并且初始化这个新实例对应到原对象的所有字段,这种初始化就和赋值一样;该字段本身并不会克隆.
//     * (初始化和赋值一样 and 该字段本身并不会被克隆 这两句话说明了:clone方法是浅拷贝的,也就是原类中如果有一个引用类型的基本变量,那么
//     * 新实例只是被赋予了一个相同的引用.换句话说,就是原对象和新实例两者都有一个指向同一个对象的引用.注意:这里的理解是非常重要的)
//     * 因此,clone方法获得了当前对象的一个浅拷贝,而不是深拷贝.
//     *
//     * Object类本身并没有实现Cloneable接口,因此如果在一个Object对象上面调用clone方法将会在运行时,抛出异常.
//     *
//     * 方法分析:
//     * 访问级别: protected
//     * 调用本地方法: native
//     * 返回类型: Object
//     * 方法调用,是否创建新对象: YES
//     *
//     *
//     * @return     a clone of this instance.
//     * @exception  CloneNotSupportedException  if the object's class does not
//     *               support the {@code Cloneable} interface. Subclasses
//     *               that override the {@code clone} method can also
//     *               throw this exception to indicate that an instance cannot
//     *               be cloned.
//     * @see java.lang.Cloneable
//     */
//    protected native Object clone() throws CloneNotSupportedException;
//
//    /**
//     * Returns a string representation of the object. In general, the
//     * {@code toString} method returns a string that
//     * "textually represents" this object. The result should
//     * be a concise but informative representation that is easy for a
//     * person to read.
//     * It is recommended that all subclasses override this method.
//     * <p>
//     * The {@code toString} method for class {@code Object}
//     * returns a string consisting of the name of the class of which the
//     * object is an instance, the at-sign character `{@code @}', and
//     * the unsigned hexadecimal representation of the hash code of the
//     * object. In other words, this method returns a string equal to the
//     * value of:
//     * <blockquote>
//     * <pre>
//     * getClass().getName() + '@' + Integer.toHexString(hashCode())
//     * </pre></blockquote>
//     *
//     * 返回当前对象的一个字符串表达式.一般,toString方法返回的是这个对象的文本表达方式.
//     * 返回结果应该是简洁且内容丰富的,这样才能方便人们阅读.
//     * 建议所有Object的子类都重写这一方法.
//     * toString方法由三部分组成:实例类的名称+@+实例类哈希值的一个toHexString的非负值,这一点完全可以通过源码看出来.
//     *
//     * 访问类型:public
//     * 返回类型:String
//     * 没有调用本地方法:没有native
//     * 可以被子类覆写:没有final
//     *
//     * @return  a string representation of the object.
//     */
//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }
//
//    /**
//     * Wakes up a single thread that is waiting on this object's
//     * monitor. If any threads are waiting on this object, one of them
//     * is chosen to be awakened. The choice is arbitrary and occurs at
//     * the discretion of the implementation. A thread waits on an object's
//     * monitor by calling one of the {@code wait} methods.
//     * <p>
//     * The awakened thread will not be able to proceed until the current
//     * thread relinquishes the lock on this object. The awakened thread will
//     * compete in the usual manner with any other threads that might be
//     * actively competing to synchronize on this object; for example, the
//     * awakened thread enjoys no reliable privilege or disadvantage in being
//     * the next thread to lock this object.
//     * <p>
//     * This method should only be called by a thread that is the owner
//     * of this object's monitor. A thread becomes the owner of the
//     * object's monitor in one of three ways:
//     * <ul>
//     * <li>By executing a synchronized instance method of that object.
//     * <li>By executing the body of a {@code synchronized} statement
//     *     that synchronizes on the object.
//     * <li>For objects of type {@code Class,} by executing a
//     *     synchronized static method of that class.
//     * </ul>
//     * <p>
//     * Only one thread at a time can own an object's monitor.
//     *
//     * notify方法,唤醒一个在当前对象监听器上等待的线程.如果其它的线程也在等待这个对象,那么究竟唤醒哪个线程呢?当然是只能选择它们中的一个
//     * 来唤醒了.选择策略可以是任意的,这取决于具体的实现.线程通过调用对象的wait方法,就会成为对象监听器上的等待线程.
//     * 被唤醒的线程并不能立即就能运行,直到当前线程释放了当前对象的锁.被唤醒的线程将会和其它的活跃的线程一起竞争使用这个对象;比如,唤醒的
//     * 线程没有任何可以依赖的优势或者劣势来成为对当前对象加锁的线程.换句话说,就是刚刚被唤醒的线程和其它可以和其竞争当前对象的其它线程
//     * 优先级完全一样.
//     *
//     * 这一方法只能被当前对象监听器所属的线程所调用.
//     * 一个线程成为某个对象的监听器的方式有3种:
//     * (1)执行该对象的一个同步方法.
//     * (2)执行一个同步在该对象上的代码块.
//     * (3)对于类对象,可以是执行该类的一个静态同步代码块.
//     *
//     * 方法分析:
//     * 访问修饰符:public
//     * final:子类不能覆写此方法
//     * native:调用了本地方法
//     * void:返回类型
//     *
//     * @exception  IllegalMonitorStateException  if the current thread is not
//     *               the owner of this object's monitor.
//     * @see        java.lang.Object#notifyAll()
//     * @see        java.lang.Object#wait()
//     */
//    public final native void notify();
//
//    /**
//     * Wakes up all threads that are waiting on this object's monitor. A
//     * thread waits on an object's monitor by calling one of the
//     * {@code wait} methods.
//     * <p>
//     * The awakened threads will not be able to proceed until the current
//     * thread relinquishes the lock on this object. The awakened threads
//     * will compete in the usual manner with any other threads that might
//     * be actively competing to synchronize on this object; for example,
//     * the awakened threads enjoy no reliable privilege or disadvantage in
//     * being the next thread to lock this object.
//     * <p>
//     * This method should only be called by a thread that is the owner
//     * of this object's monitor. See the {@code notify} method for a
//     * description of the ways in which a thread can become the owner of
//     * a monitor.
//     *
//     * 唤醒所有在当前对象监听器上面的线程.一个线程通过调用wait方法,成为当前对象上面的等待线程.
//     * 被唤醒的线程并不能立即对当前对象执行操作,直到当前线程释放了当前对象的锁.被唤醒的线程们和其它也在竞争当前对象的线程们,在竞争
//     * 当前对象的优先级上面,完全是一样的.
//     *
//     * 这一方法和上一个方法一样,只能被当前对象的对象监听器所属线程所调用.
//     *
//     * 方法分析:同上
//     *
//     * @exception  IllegalMonitorStateException  if the current thread is not
//     *               the owner of this object's monitor.
//     * @see        java.lang.Object#notify()
//     * @see        java.lang.Object#wait()
//     */
//    public final native void notifyAll();
//
//    /**
//     * Causes the current thread to wait until either another thread invokes the
//     * {@link java.lang.Object#notify()} method or the
//     * {@link java.lang.Object#notifyAll()} method for this object, or a
//     * specified amount of time has elapsed.
//     * wait方法的调用会使得当前线程阻塞,直到其它的线程调用了对应对象的notify或者notifyAll方法,亦或者等待时间到达.
//     *
//     * <p>
//     * The current thread must own this object's monitor.
//     * 当前线程必须拥有这个对象的监听器.
//     * <p>
//     * This method causes the current thread (call it <var>T</var>) to
//     * place itself in the wait set for this object and then to relinquish
//     * any and all synchronization claims on this object. Thread <var>T</var>
//     * becomes disabled for thread scheduling purposes and lies dormant
//     * until one of four things happens:
//     * <ul>
//     * <li>Some other thread invokes the {@code notify} method for this
//     * object and thread <var>T</var> happens to be arbitrarily chosen as
//     * the thread to be awakened.
//     * <li>Some other thread invokes the {@code notifyAll} method for this
//     * object.
//     * <li>Some other thread {@linkplain Thread#interrupt() interrupts}
//     * thread <var>T</var>.
//     * <li>The specified amount of real time has elapsed, more or less.  If
//     * {@code timeout} is zero, however, then real time is not taken into
//     * consideration and the thread simply waits until notified.
//     * </ul>
//     * wait()方法使得调用这个方法的线程T将自己放在当前对象的等待集合中,并放弃了所有针对这个对象的同步操作声明.线程T不能在参与
//     * 线程调度,并且一直处于休眠状态,直到下面四件事中的某一个发生为止:
//     * (1)其它线程调用了当前对象的notify方法,并且线程T刚刚好是那个被选中唤醒的线程.
//     * (2)其它线程调用了当前对象的notifyAll方法.
//     * (3)其它线程中断了线程T.
//     * (4)线程T的被指定的等待时间到达.然而,如果超时时间在一开始被指定为0,那么这种指定就是失效的,也就是线程并不能立即被使用,而是需要被
//     * 其它线程唤醒才能使用.
//     *
//     *
//     * The thread <var>T</var> is then removed from the wait set for this
//     * object and re-enabled for thread scheduling. It then competes in the
//     * usual manner with other threads for the right to synchronize on the
//     * object; once it has gained control of the object, all its
//     * synchronization claims on the object are restored to the status quo
//     * ante - that is, to the situation as of the time that the {@code wait}
//     * method was invoked. Thread <var>T</var> then returns from the
//     * invocation of the {@code wait} method. Thus, on return from the
//     * {@code wait} method, the synchronization state of the object and of
//     * thread {@code T} is exactly as it was when the {@code wait} method
//     * was invoked.
//     * 当线程T被唤醒后,它将从wait等待集合中删除,且继续可以参与线程调度了.此后,它会和其它线程一样去竞争对当前对象的同步操作;如果线程T获得
//     * 了当前对象的控制权,那么线程T的同步声明都会被恢复到它之前调用wait方法时候的状态.然后线程T就从wait方法返回.因此,从wait方法
//     * 返回,当前对象和线程T的同步状态都会被恢复为wait方法调用的时候(这一点很好理解:线程T调用wait方法,此时线程T的所有状态被保存;当线程T
//     * 被唤醒并且被选中作为当前对象操作的线程,那么线程T在工作之前,必须先恢复它原来的状态,也就调用wait方法时的状态.).
//     * <p>
//     * A thread can also wake up without being notified, interrupted, or
//     * timing out, a so-called <i>spurious wakeup</i>.  While this will rarely
//     * occur in practice, applications must guard against it by testing for
//     * the condition that should have caused the thread to be awakened, and
//     * continuing to wait if the condition is not satisfied.  In other words,
//     * waits should always occur in loops, like this one:
//     * <pre>
//     *     synchronized (obj) {
//     *         while (&lt;condition does not hold&gt;)
//     *             obj.wait(timeout);
//     *         ... // Perform action appropriate to condition
//     *     }
//     * </pre>
//     * (For more information on this topic, see Section 3.2.3 in Doug Lea's
//     * "Concurrent Programming in Java (Second Edition)" (Addison-Wesley,
//     * 2000), or Item 50 in Joshua Bloch's "Effective Java Programming
//     * Language Guide" (Addison-Wesley, 2001).
//     *
//     * 一个线程不被唤醒 or 不被中断 or 等待时间到达,也能自己醒来,这种醒来被称为"伪醒来".尽管这在实践中几乎不会出现,但是应用程序还是应该防范
//     * 这一情况的出现,可以通过测试线程被唤醒的条件 and  什么条件下不能被唤醒,从而达到防御目的.换句话说,wait方法只能在循环中发生,
//     * 比如下面这样:
//     * synchronized (obj) {
//     *         while (condition does not hold)
//     *             obj.wait(timeout);
//     * }
//     * (关于这个问题的更多信息,可以查看Doug Lea的<java并发编程>章节3.2.3)
//     *
//     * <p>If the current thread is {@linkplain java.lang.Thread#interrupt()
//     * interrupted} by any thread before or while it is waiting, then an
//     * {@code InterruptedException} is thrown.  This exception is not
//     * thrown until the lock status of this object has been restored as
//     * described above.
//     * 如果当前线程在wait方法调用前或者正在wait时被其他线程中断,那么会抛出异常InterruptedException.注意这一异常的抛出时间是有规定的:
//     * 这一时间必须是:当前Object被解锁,当前对象和线程T的同步状态都会被恢复为wait方法调用的时候.
//     * <p>
//     * Note that the {@code wait} method, as it places the current thread
//     * into the wait set for this object, unlocks only this object; any
//     * other objects on which the current thread may be synchronized remain
//     * locked while the thread waits.
//     *
//     * 注意:由于wait方法是将当前线程放到了当前对象的wait集合里面,所以当wait方法结束时,解锁的也只是当前这个对象;
//     * 当前线程用于同步的其他对象会保持线程调用wait方法时的锁状态.(关于这句话的理解,举个例子:线程如果因为m(m>1)个资源被阻塞,那么得到1个资源时,
//     * 只是这个资源可以从wait状态回复,其他的(m-1)个资源依旧是wait状态.因为当前线程的运行还需要其他(m-1)个资源,因此此时的线程还是不能够运行的.)
//     *
//     * <p>
//     * This method should only be called by a thread that is the owner
//     * of this object's monitor. See the {@code notify} method for a
//     * description of the ways in which a thread can become the owner of
//     * a monitor.
//     *
//     * wait方法只能被拥有对象的监听器的线程调用.关于成为一个对象的监听器的方法可以查看notify方法,里面写了3种方法.
//     *
//     *
//     * @param      timeout   the maximum time to wait in milliseconds. 等待时间的最长毫秒数.
//     * @exception  IllegalArgumentException      if the value of timeout is
//     *               negative.
//     * @exception  IllegalMonitorStateException  if the current thread is not
//     *               the owner of the object's monitor.
//     * @exception  InterruptedException if any thread interrupted the
//     *             current thread before or while the current thread
//     *             was waiting for a notification.  The <i>interrupted
//     *             status</i> of the current thread is cleared when
//     *             this exception is thrown.
//     * @see        java.lang.Object#notify()
//     * @see        java.lang.Object#notifyAll()
//     */
//    public final native void wait(long timeout) throws InterruptedException;
//
//    /**
//     * Causes the current thread to wait until another thread invokes the
//     * {@link java.lang.Object#notify()} method or the
//     * {@link java.lang.Object#notifyAll()} method for this object, or
//     * some other thread interrupts the current thread, or a certain
//     * amount of real time has elapsed.
//     *
//     * wait方法会使得当前线程处于等待状态,直到另一个执行了对当前对象的notify方法或者notifyAll方法,或者其他线程中断了当前线程,亦或者等待时间
//     * 结束,线程就会恢复wait之前的状态.
//     *
//     * <p>
//     * This method is similar to the {@code wait} method of one
//     * argument, but it allows finer control over the amount of time to
//     * wait for a notification before giving up. The amount of real time,
//     * measured in nanoseconds, is given by:
//     * <blockquote>
//     * <pre>
//     * 1000000*timeout+nanos</pre></blockquote>
//     * <p>
//     *
//     * 这一方法和有一个参数的wait方法类似,区别就是:它能在放弃等待之前,更好的控制被通知的时间.
//     * 按照纳秒计量的真实等待时间,格式如下:
//     * 1000000*timeout+nanos
//     * 所以,通过格式,我们可以看出:timeout参数的单位是毫秒,nanos参数的单位是纳秒.
//     *
//     * In all other respects, this method does the same thing as the
//     * method {@link #wait(long)} of one argument. In particular,
//     * {@code wait(0, 0)} means the same thing as {@code wait(0)}.
//     * <p>
//     * The current thread must own this object's monitor. The thread
//     * releases ownership of this monitor and waits until either of the
//     * following two conditions has occurred:
//     * <ul>
//     * <li>Another thread notifies threads waiting on this object's monitor
//     *     to wake up either through a call to the {@code notify} method
//     *     or the {@code notifyAll} method.
//     * <li>The timeout period, specified by {@code timeout}
//     *     milliseconds plus {@code nanos} nanoseconds arguments, has
//     *     elapsed.
//     * </ul>
//     *
//     * 在其他方面,这一方法和wait(long)方法并不一样.但是有一种特殊情况,两者还是一样的,那就是wait(0)和wait(0,0)是一样的.
//     * 当前线程必须有对象的监听器.当前线程释放监听器的所有权并进行等待,直到下面两个情况中的某一个发生为止:
//     * (1)另一个线程唤醒了对象监听器上的线程们,这一唤醒可以通过调用notify方法或者notifyAll方法.
//     * (2)1000000*timeout+nanos 的等待时间到达.
//     *
//     * <p>
//     * The thread then waits until it can re-obtain ownership of the
//     * monitor and resumes execution.
//     *
//     * 当前线程会一直等待,直到它重新获得对象监听器的控制权,然后恢复运行.
//     *
//     * <p>
//     * As in the one argument version, interrupts and spurious wakeups are
//     * possible, and this method should always be used in a loop:
//     * <pre>
//     *     synchronized (obj) {
//     *         while (&lt;condition does not hold&gt;)
//     *             obj.wait(timeout, nanos);
//     *         ... // Perform action appropriate to condition
//     *     }
//     * </pre>
//     *
//     * 和wait(long)方法中一样,本方法中,中断和伪苏醒也是可能的,并且这一方法应该总是在循环中出现,循环格式类似:
//     * synchronized (obj) {
//     *        while (condition does not hold)
//     *             obj.wait(timeout, nanos);
//     *     }
//     *
//     *
//     * This method should only be called by a thread that is the owner
//     * of this object's monitor. See the {@code notify} method for a
//     * description of the ways in which a thread can become the owner of
//     * a monitor.
//     *
//     * 这一方法只能被对象监听器的拥有者调用.一个线程如何拥有对象的监听器,方式可以参考notify方法.
//     *
//     * @param      timeout   the maximum time to wait in milliseconds.
//     * @param      nanos      additional time, in nanoseconds range
//     *                       0-999999.
//     * @exception  IllegalArgumentException      if the value of timeout is
//     *                      negative or the value of nanos is
//     *                      not in the range 0-999999.
//     * @exception  IllegalMonitorStateException  if the current thread is not
//     *               the owner of this object's monitor.
//     * @exception  InterruptedException if any thread interrupted the
//     *             current thread before or while the current thread
//     *             was waiting for a notification.  The <i>interrupted
//     *             status</i> of the current thread is cleared when
//     *             this exception is thrown.
//     */
//    public final void wait(long timeout, int nanos) throws InterruptedException {
//        if (timeout < 0) {
//            throw new IllegalArgumentException("timeout value is negative");
//        }
//
//        if (nanos < 0 || nanos > 999999) {
//            throw new IllegalArgumentException(
//                    "nanosecond timeout value out of range");
//        }
//
//        if (nanos >= 500000 || (nanos != 0 && timeout == 0)) {
//            timeout++;
//        }
//
//        wait(timeout);
//    }
//
//    /**
//     * Causes the current thread to wait until another thread invokes the
//     * {@link java.lang.Object#notify()} method or the
//     * {@link java.lang.Object#notifyAll()} method for this object.
//     * In other words, this method behaves exactly as if it simply
//     * performs the call {@code wait(0)}.
//     *
//     * 本方法会使得当前线程进入等待当前Object的状态,直到另一个线程调用了针对当前Object的notify或者notifyAll方法.
//     * 换句话说,本方法和wait(0)方法的功能基本一样.
//     *
//     * <p>
//     * The current thread must own this object's monitor. The thread
//     * releases ownership of this monitor and waits until another thread
//     * notifies threads waiting on this object's monitor to wake up
//     * either through a call to the {@code notify} method or the
//     * {@code notifyAll} method. The thread then waits until it can
//     * re-obtain ownership of the monitor and resumes execution.
//     *
//     * 当前线程必须有这个对象的监听器.当前线程调用了wait方法后,会释放对象的监听器,然后进入等待状态,直到另一个线程唤醒在
//     * 这个Object上面等待的进程们.当前线程会继续等待(因为被其他线程唤醒后,不一定能获得对象的监听器权利,,也就是当前线程
//     * 不一定可以继续对Object执行同步操作,因为要对对象Object执行同步操作,必须拥有对象的监听器),直到它获得对象的监听器
//     * 权利,然后开始继续执行.
//     *
//     * <p>
//     * As in the one argument version, interrupts and spurious wakeups are
//     * possible, and this method should always be used in a loop:
//     * <pre>
//     *     synchronized (obj) {
//     *         while (&lt;condition does not hold&gt;)
//     *             obj.wait();
//     *         ... // Perform action appropriate to condition
//     *     }
//     * </pre>
//     *
//     * 和wait(long)方法一样,中断以及伪苏醒都是可能的,并且当前方法应该总是在循环中出现:
//     * 循环格式如下:
//     * synchronized (obj) {
//     *         while (condition does not hold)
//     *             obj.wait();
//     * }
//     *
//     *
//     * This method should only be called by a thread that is the owner
//     * of this object's monitor. See the {@code notify} method for a
//     * description of the ways in which a thread can become the owner of
//     * a monitor.
//     *
//     * 这一方法只能被拥有对象的监听器的线程所调用.一个线程如何拥有对象的监听器,方法可以参见notify方法里面一样.
//     *
//     * @exception  IllegalMonitorStateException  if the current thread is not
//     *               the owner of the object's monitor.
//     * @exception  InterruptedException if any thread interrupted the
//     *             current thread before or while the current thread
//     *             was waiting for a notification.  The <i>interrupted
//     *             status</i> of the current thread is cleared when
//     *             this exception is thrown.
//     * @see        java.lang.Object#notify()
//     * @see        java.lang.Object#notifyAll()
//     */
//    public final void wait() throws InterruptedException {
//        wait(0);
//    }
//
//    /**
//     * Called by the garbage collector on an object when garbage collection
//     * determines that there are no more references to the object.
//     * A subclass overrides the {@code finalize} method to dispose of
//     * system resources or to perform other cleanup.
//     *
//     * 如果一个Obejct没有被其他Object引用,则finalize方法会被Object的垃圾收集器调用,从而回收这个Object.
//     * Object的子类腹泻finalize方法,是为了释放系统资源,或者进行其他的清理工作.
//     *
//     * <p>
//     * The general contract of {@code finalize} is that it is invoked
//     * if and when the Java<font size="-2"><sup>TM</sup></font> virtual
//     * machine has determined that there is no longer any
//     * means by which this object can be accessed by any thread that has
//     * not yet died, except as a result of an action taken by the
//     * finalization of some other object or class which is ready to be
//     * finalized. The {@code finalize} method may take any action, including
//     * making this object available again to other threads; the usual purpose
//     * of {@code finalize}, however, is to perform cleanup actions before
//     * the object is irrevocably discarded. For example, the finalize method
//     * for an object that represents an input/output connection might perform
//     * explicit I/O transactions to break the connection before the object is
//     * permanently discarded.
//     *
//     * finalize方法的通用规范是:如果当前存活的线程没有任何线程会再次使用一个Object,那么就会调用这个Object的finalize方法.除非这个Object
//     * 已经被其他Object或者class作为他们的finalize对象了(也就是,一个Object只能被一个Object或者class作为回收对象).
//     * finalize方法可以采取任何行为,包括使得某个Object成为某个线程的可利用资源(此时,这个Object不会被jvm回收,而是被重新使用);然而,finalize
//     * 方法通常的功能是:在一个Object彻底消失之前,做一些相关的清除工作.
//     * 举个例子:一个输入输出的对象,在它彻底消失之前,它的finalize方法可能会执行一些I/O事务,以断开连接.
//     *
//     * <p>
//     * The {@code finalize} method of class {@code Object} performs no
//     * special action; it simply returns normally. Subclasses of
//     * {@code Object} may override this definition.
//     *
//     * Object类的finalize方法并没有什么执行什么特别的行为;它只是简单正常的返回而已.Object的子类可以覆写这一方法.
//     *
//     * <p>
//     * The Java programming language does not guarantee which thread will
//     * invoke the {@code finalize} method for any given object. It is
//     * guaranteed, however, that the thread that invokes finalize will not
//     * be holding any user-visible synchronization locks when finalize is
//     * invoked. If an uncaught exception is thrown by the finalize method,
//     * the exception is ignored and finalization of that object terminates.
//     *
//     * 对于指定的Object,java语言不会强制约束由哪个线程来执行这个Object的finalize方法.但是,它能保证的是:当一个线程执行finalize方法
//     * 的时候,这个线程不会持有任何用户可见型的同步锁.
//     * 如果finalize方法抛出一个未捕获的异常,异常会被忽略,并且finalize方法执行就此结束.
//     *
//     * <p>
//     * After the {@code finalize} method has been invoked for an object, no
//     * further action is taken until the Java virtual machine has again
//     * determined that there is no longer any means by which this object can
//     * be accessed by any thread that has not yet died, including possible
//     * actions by other objects or classes which are ready to be finalized,
//     * at which point the object may be discarded.
//     *
//     * 一个Object被执行了finalize方法后,就不会再被执行其他的什么操作,直到虚拟机再次确认这个Object确实不会再被当前存活的线程所访问(这时,
//     * 会对这个Object执行回收操作),其他的什么操作包括:其他正在准备执行finalize方法的类或者对象,可能会在某种程度上使得这个Object消失.(这
//     * 一点很好理解,finalize方法基本就是执行清除工作的,那么可能一个对象在做清除工作时,会清除其他对象)
//     *
//     * <p>
//     * The {@code finalize} method is never invoked more than once by a Java
//     * virtual machine for any given object.
//     *
//     * 对于任意一个Object,finalize方法只能最多被执行一次.
//     *
//     * <p>
//     * Any exception thrown by the {@code finalize} method causes
//     * the finalization of this object to be halted, but is otherwise
//     * ignored.
//     *
//     * finalize方法执行过程中,如果抛出异常,这会使得对当前这个Object的finalize工作终止,然而这一情况是被忽略的.(也就是finalize方法
//     * 是否抛出异常,是否完成Object的清除工作,我们并不关心)
//     *
//     * @throws Throwable the {@code Exception} raised by this method
//     */
//    protected void finalize() throws Throwable { }
//}
