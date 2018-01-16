//package sourcecode.analysis;
//
///**
// * Created by caoxiaohong on 17/11/18 21:43.
// */
//
//import java.io.ObjectStreamField;
//import java.io.UnsupportedEncodingException;
//import java.nio.charset.Charset;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;
//
///**
// * The <code>String</code> class represents character strings. All
// * string literals in Java programs, such as <code>"abc"</code>, are
// * implemented as instances of this class.
// *
// * String类表示字符串.java中所有的字符文字,比如"abc",都是这个类的一个实例.
// *
// * <p>
// * Strings are constant; their values cannot be changed after they
// * are created. String buffers support mutable strings.
// * Because String objects are immutable they can be shared. For example:
// * <p><blockquote><pre>
// *     String str = "abc";
// * </pre></blockquote><p>
// * is equivalent to:
// * <p><blockquote><pre>
// *     char data[] = {'a', 'b', 'c'};
// *     String str = new String(data);
// * </pre></blockquote><p>
// * Here are some more examples of how strings can be used:
// * <p><blockquote><pre>
// *     System.out.println("abc");
// *     String cde = "cde";
// *     System.out.println("abc" + cde);
// *     String c = "abc".substring(2,3);
// *     String d = cde.substring(1, 2);
// * </pre></blockquote>
// * <p>
// *
// * String是常量;它们的值一旦被创建,则不会被更改.字符串缓冲区支持可变字符串.
// * 因为String对象不可更改,所以它们能被共享使用.例如:
// * String str="abc"; 和
// * char data[] = {'a', 'b', 'c'};
// * String str = new String(data);
// * 二者是等价的.
// *
// * 下面还有一些String使用的例子:
// * System.out.println("abc");
// * String cde = "cde";
// * System.out.println("abc" + cde);
// * String c = "abc".substring(2,3);
// * String d = cde.substring(1, 2);
// *
// *
// * The class <code>String</code> includes methods for examining
// * individual characters of the sequence, for comparing strings, for
// * searching strings, for extracting substrings, and for creating a
// * copy of a string with all characters translated to uppercase or to
// * lowercase. Case mapping is based on the Unicode Standard version
// * specified by the {@link java.lang.Character Character} class.
// *
// * String类包含了对字符序列中个别字符的一些检查方法,如:比较字符串,查找字符串,截取字符串,创建一个副本,副本是原字符串的大写形式或者小写形式.
// * 大小写映射基于Character类指定的的Unicode标准.
// *
// * <p>
// * The Java language provides special support for the string
// * concatenation operator (&nbsp;+&nbsp;), and for conversion of
// * other objects to strings. String concatenation is implemented
// * through the <code>StringBuilder</code>(or <code>StringBuffer</code>)
// * class and its <code>append</code> method.
// * String conversions are implemented through the method
// * <code>toString</code>, defined by <code>Object</code> and
// * inherited by all classes in Java. For additional information on
// * string concatenation and conversion, see Gosling, Joy, and Steele,
// * <i>The Java Language Specification</i>.
// *
// * java支持通过加号+,来拼接字符串;也支持将其他一些对象转为字符串.字符串拼接功能由StringBuilder和StringBuffer类以及它们的
// * append()方法来实现.
// * 字符串转换功能由toString方法来实现,这一方法是由Object类定义并被其他类继承.
// *
// * <p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor
// * or method in this class will cause a {@link NullPointerException} to be
// * thrown.
// *
// * 除非另有说明,否则,如果把一个null参数传给String类的方法或者参数都将会抛出异常NullPointerException.
// *
// * <p>A <code>String</code> represents a string in the UTF-16 format
// * in which <em>supplementary characters</em> are represented by <em>surrogate
// * pairs</em> (see the section <a href="Character.html#unicode">Unicode
// * Character Representations</a> in the <code>Character</code> class for
// * more information).
// * Index values refer to <code>char</code> code units, so a supplementary
// * character uses two positions in a <code>String</code>.
// * <p>The <code>String</code> class provides methods for dealing with
// * Unicode code points (i.e., characters), in addition to those for
// * dealing with Unicode code units (i.e., <code>char</code> values).
// *
// * String类代表的是UTF-16标准的字符串,在这一标准中,补充字符由代表对替代.
// * 一个字符的索引值是它所在的char代码单元,因此在String中追加字符会占用两个位置(因为UTF-16标准就是:一个字符占两个字节).
// * String类不但提供了处理Unicode代码单元的方法,还提供了处理Unicode代码点的方法.
// *
// * Unicode code points:Unicode代码点,在unicode的世界中，每种字符都有一个唯一的数字编号，这个数字编号就叫Unicode code point.
// * code point的数值范围是0~0x10FFFF，也就是一共可以表示1114112种不同的字符
// *
// * Unicode code units:Unicode代码单元,
// * 由于code point的数值范围比较尴尬，直接用四字节的long类型来存储太浪费空间，直接用双字节的char类型来存储又存不下。
// * 最终有个折衷方案，数值范围较小的code point用一个char存储，数字范围较大的code point用两个char来存储。所以一个char就叫
// * 一个code unit，而这种方案就叫UTF-16。
// *
// * @author  Lee Boynton
// * @author  Arthur van Hoff
// * @author  Martin Buchholz
// * @author  Ulf Zibis
// * @see     java.lang.Object#toString()
// * @see     java.lang.StringBuffer
// * @see     java.lang.StringBuilder
// * @see     java.nio.charset.Charset
// * @since   JDK1.0
// */
//
///**
// * 类名分析:
// * 实现接口:
// * (1)java.io.Serializable:使得String对象可以序列化
// * (2)Comparable<String>:表明String类可以实现自然排序,也就是集合类型为String时,如果不指定比较器,那么集合在排序时,实现的是字典排序.
// * (3)CharSequence:提供了一些对字符序列的只读操作:有4个方法:length(),charAt(),subSequence(),toString().
// * 注意:final是在jdk8开始加上的,在7时还没有.被final修饰的类不能被继承.
// */
//public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
//    /** The value is used for character storage. */
//    /**
//     * char[]数组:用于存放String的字符;
//     * private:说明value[]数组只能被本String类访问.
//     * final说明了:String本身就是不可更改的.所以String是线程安全的.
//     * 注意:这里使用了数组声明的另一种方式:char value[] ,这和char[] value是一样的意思.
//     */
//    private final char value[];
//
//    /** Cache the hash code for the string */
//    /**
//     * 1.缓存了String实例的哈希值
//     * 2.哈希值默认为0
//     * 3.疑问?
//     * Q:为什么要缓存String类的哈希值?
//     * A:很多对象是作为String类型存储的,比如HashMap的key和value都可以存储为String类型;ArrayList也可以存储String类型的对象...
//     * 那么存储在集合中的元素免不了进行比较,一旦涉及比较,就会涉及equals方法和hashcode方法.所以对于一个不可变的String对象缓存了其哈希值
//     * 后,后面在进行比较的时候,就不用每次都进行哈希值的计算了,从而提高了程序的运行速度.
//     *
//     */
//    private int hash; // Default to 0
//
//    /** use serialVersionUID from JDK 1.0.2 for interoperability */
//    //根据之前的分析,这一实例变量是用于序列化和反序列化的.
//    private static final long serialVersionUID = -6849794470754667710L;
//
//    /**
//     * Class String is special cased within the Serialization Stream Protocol.
//     *
//     * A String instance is written initially into an ObjectOutputStream in the
//     * following format:
//     * <pre>
//     *      <code>TC_STRING</code> (utf String)
//     * </pre>
//     * The String is written by method <code>DataOutput.writeUTF</code>.
//     * A new handle is generated to  refer to all future references to the
//     * string instance within the stream.
//     *
//     * 1.String类在序列化流协议中是特殊的.
//     * 2.String实例的初始化是被写入到一个ObjectOutputStream中,格式为:TC_STRING(utf类型)这个String实例由DataOutput.writeUTF方法
//     * 写入.与此同时,会生成一个句柄,未来所有对这个String实例的引用都会使用这个句柄.
//     * Q:句柄是什么?
//     * A:句柄可以直接或者间接的指向一个对象的内存地址.
//     * 3.static final修饰的变量是:常量,故serialPersistentFields是个常量.
//     */
//    private static final ObjectStreamField[] serialPersistentFields =
//            new ObjectStreamField[0];
//
//    //16个实例构造函数,其中两个从JDK8开始不再被建议使用.
//    /**
//     * Initializes a newly created {@code String} object so that it represents
//     * an empty character sequence.  Note that use of this constructor is
//     * unnecessary since Strings are immutable.
//     * 1.无参构造函数.
//     * 2.创建一个空字符串,并存储到value[]中.
//     * 3.从jdk8开始,String类直接被final修饰,从而不能被更改,所以这一构造器的使用是非必需的了.
//     */
//    public String() {
//        this.value = "".value;
//    }
//
//    /**
//     * Initializes a newly created {@code String} object so that it represents
//     * the same sequence of characters as the argument; in other words, the
//     * newly created string is a copy of the argument string. Unless an
//     * explicit copy of {@code original} is needed, use of this constructor is
//     * unnecessary since Strings are immutable.
//     *
//     * 创建一个新的String,并且字符序列和给定的参数是一致的;换句话说,新创建的字符是参数的一个副本.除非需要显式拷贝,否则这个构造函数
//     * 是非必需的,因为String类已经被final修饰了,所以每个String对象都有一个自己的内存地址的(堆内),也就不用这么刻意去拷贝了.
//     *
//     * @param  original
//     *         A {@code String}
//     */
//    public String(String original) {
//        this.value = original.value;
//        this.hash = original.hash;
//    }
//
//    /**
//     * Allocates a new {@code String} so that it represents the sequence of
//     * characters currently contained in the character array argument. The
//     * contents of the character array are copied; subsequent modification of
//     * the character array does not affect the newly created string.
//     *
//     * 创建一个新的String,并且String中的字符和参数数组value完全一致.参数数组value中的内容被拷贝; Arrays.copyOf方法最终实质是
//     * 调用的一个native方法;后期如果参数数组value中的值被更改,刚刚新创建的数组不会受影响.
//     *
//     * @param  value
//     *         The initial value of the string
//     */
//    public String(char value[]) {
//        this.value = Arrays.copyOf(value, value.length);
//    }
//
//    /**
//     * Allocates a new {@code String} that contains characters from a subarray
//     * of the character array argument. The {@code offset} argument is the
//     * index of the first character of the subarray and the {@code count}
//     * argument specifies the length of the subarray. The contents of the
//     * subarray are copied; subsequent modification of the character array does
//     * not affect the newly created string.
//     *
//     * String的又一构造函数,新生成的String是对value数组进行截取的,截取范围为[offset,offset+count);
//     * 参数offset是value数组开始被截取的下标,参数count是被截取的字符个数.子数组存储内容被拷贝;后期对value数组的更改不会影响刚刚
//     * 新生成的这个字符串.
//     *
//     * @param  value
//     *         Array that is the source of characters
//     *
//     * @param  offset
//     *         The initial offset
//     *
//     * @param  count
//     *         The length
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} and {@code count} arguments index
//     *          characters outside the bounds of the {@code value} array
//     */
//    public String(char value[], int offset, int count) {
//        //首先判定下标位移是否合法
//        if (offset < 0) {
//            throw new StringIndexOutOfBoundsException(offset);
//        }
//        //然后判定截取字符个数是否<=0
//        if (count <= 0) {
//            if (count < 0) { //截取个数<0,抛出异常
//                throw new StringIndexOutOfBoundsException(count);
//            }
//            if (offset <= value.length) {//截取字符个数为0,新生成一个字符串,且这个字符串为空字符串.
//                this.value = "".value;//注意这里的写法
//                return;
//            }
//        }
//        // Note: offset or count might be near -1>>>1.
//        //如果需要被截取的字符个数count比从offset开始到value结尾的字符个数多,就是非法的
//        if (offset > value.length - count) {
//            throw new StringIndexOutOfBoundsException(offset + count);
//        }
//        //非法判定完毕,下面就是正式调用native方法进行复制了,新生成一个String,且这个String的value[]被赋值.
//        this.value = Arrays.copyOfRange(value, offset, offset+count);
//    }
//
//    /**
//     * Allocates a new {@code String} that contains characters from a subarray
//     * of the <a href="Character.html#unicode">Unicode code point</a> array
//     * argument.  The {@code offset} argument is the index of the first code
//     * point of the subarray and the {@code count} argument specifies the
//     * length of the subarray.  The contents of the subarray are converted to
//     * {@code char}s; subsequent modification of the {@code int} array does not
//     * affect the newly created string.
//     *
//     * 先说一个术语:code point是什么意思?
//     * code point是字符编码的术语。
//     * 举例如下:
//     * ASCII字符集由于只使用7bit表示字符，因此有128个code point.
//     * Extended ASCII字符集由于使用了8bit表示字符，因此有256个code point.
//     * 所以究竟要不要翻译为代码点,怎么理解都可以,知道是什么意思就行了.反正中文里面翻译是:代码点.
//     *
//     * 新生成一个String,其字符来自参数codePoints的截取,参数codePoints是一个Unicode代码点数组.
//     * 参数offset是子数组第一个代码点的索引;参数count是子数组的长度.
//     * 子数组的内容被转化为字符;
//     * 后期对int[]数组codePoints的修改不用影响新创建的这个字符串.
//     *
//     * 关于这个方法怎么使用,这里举一个例子:
//     * public class Main{
//        public static void main(String[] args) {
//            int[] ints={65,66,67,68,69,70};
//            String str=new String(ints,2,4);
//            System.out.println(str.length());//输出:4
//            System.out.println(str.toString());//输出:CDEF,这里就是将int数字自动转为了字符, ASSII 码为67,68,69,70
//                                               //对应的字母就是CDEF
//        }
//     *}
//     *
//     * @param  codePoints
//     *         Array that is the source of Unicode code points //Unicode代码点数组
//     *
//     * @param  offset
//     *         The initial offset//复制开始的第一个索引
//     *
//     * @param  count
//     *         The length //被复制元素个数
//     *
//     * @throws  IllegalArgumentException
//     *          If any invalid Unicode code point is found in {@code
//     *          codePoints}
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} and {@code count} arguments index
//     *          characters outside the bounds of the {@code codePoints} array
//     *
//     * @since  1.5
//     */
//    public String(int[] codePoints, int offset, int count) {
//        //如果开始索引<0,非法
//        if (offset < 0) {
//            throw new StringIndexOutOfBoundsException(offset);
//        }
//        //如果复制个数<=0
//        if (count <= 0) {
//            //复制个数<0,非法
//            if (count < 0) {
//                throw new StringIndexOutOfBoundsException(count);
//            }
//            //复制个数=0,为value赋值为空串.
//            if (offset <= codePoints.length) {
//                this.value = "".value;
//                return;
//            }
//        }
//        // Note: offset or count might be near -1>>>1.
//        //如果索引开始位置到数组codePoints结尾的字符个数<需要截取的字符个数,非法
//        if (offset > codePoints.length - count) {
//            throw new StringIndexOutOfBoundsException(offset + count);
//        }
//        //声明结尾索引变量:end
//        final int end = offset + count;
//
//        // Pass 1: Compute precise size of char[]
//        /**精确计算char数组的大小
//         * 为什么说精确计算呢?因为从offset到end这之间的正数可能有非法的,要抛出异常;如果合法,但是如果包含了不是bmp中的字符,需要将
//         * n+1,为什么要+1,因为从后面的代码Character.toSurrogates(c, v, j++)这里就能看出:赋值过程中,如果遇到非BMP字符,
//         * 那么要添加一个代理对,也就是原来在位置index的位置处本应该添加一个BMP字符就行,现在要在index和index+1的位置都添加相同的这个非
//         * BMP字符.当然通常我们写的程序,都不会运行的n++这里,因为我们使用的字符都是BMP里面的字符.
//         */
//        int n = count;
//        for (int i = offset; i < end; i++) {
//            int c = codePoints[i];
//            if (Character.isBmpCodePoint(c))
//                continue;
//            else if (Character.isValidCodePoint(c))
//                n++;//注意这里啦
//            else throw new IllegalArgumentException(Integer.toString(c));
//        }
//
//        // Pass 2: Allocate and fill in char[]
//        //现在char[]数组的精确大小已经确定好了,就要声明一个这样的内存空间了,然后赋值.我们看到v被final修饰,故 值不可更改.
//        final char[] v = new char[n];
//
//        for (int i = offset, j = 0; i < end; i++, j++) {
//            int c = codePoints[i];
//            if (Character.isBmpCodePoint(c))//如果c是bmp中的字符,则直接赋值给v数组
//                v[j] = (char)c;
//            else
//                Character.toSurrogates(c, v, j++);//否则,在v[j]和v[j+1]的位置添加c值,也就是添加了代理对(2个字符),同时
//                                                  //可以解释为啥这里j要写成j++,因此这里添加了2个字符.
//        }
//        //将v的值赋值给value
//        this.value = v;
//    }
//
//    /**
//     * Allocates a new {@code String} constructed from a subarray of an array
//     * of 8-bit integer values.
//     *
//     * <p> The {@code offset} argument is the index of the first byte of the
//     * subarray, and the {@code count} argument specifies the length of the
//     * subarray.
//     *
//     * <p> Each {@code byte} in the subarray is converted to a {@code char} as
//     * specified in the method above.
//     *
//     * @deprecated This method does not properly convert bytes into characters.
//     * As of JDK&nbsp;1.1, the preferred way to do this is via the
//     * {@code String} constructors that take a {@link
//     * java.nio.charset.Charset}, charset name, or that use the platform's
//     * default charset.
//     *
//     * 先说一下注解:@Deprecated表示这个方法已经不被赞成使用了.为什么源码中还存在这个方法呢,因为可能有人的代码中在使用,为了
//     * 不对他人的工作产生影响,所以JDK8中还是保留了这个方法.如果你现在写代码引用这个方法,那么代码上面会出现删除线,表示这个方法
//     * 不被赞成使用.
//     *
//     * 新生成一个字符串,这一字符串是参数byte[]数组的子序列.
//     * 参数index是子数组的第一个字节的索引;参数count是子数组的长度.
//     * 子数组中,每一个字节被转为一个字符.
//     * 这一方法不一定能将字节转为对应的字符.就JKD1.1而言,它在实现这个方法时,是通过一个使用了字符集名称或者平台默认的字符集的
//     * 构造器而完成这个功能的.
//     *
//     *
//     * @param  ascii
//     *         The bytes to be converted to characters
//     *
//     * @param  hibyte
//     *         The top 8 bits of each 16-bit Unicode code unit //16位的Unicode代码单元的高8位
//     *
//     * @param  offset
//     *         The initial offset
//     * @param  count
//     *         The length
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} or {@code count} argument is invalid
//     *
//     * @see  #String(byte[], int)
//     * @see  #String(byte[], int, int, java.lang.String)
//     * @see  #String(byte[], int, int, java.nio.charset.Charset)
//     * @see  #String(byte[], int, int)
//     * @see  #String(byte[], java.lang.String)
//     * @see  #String(byte[], java.nio.charset.Charset)
//     * @see  #String(byte[])
//     */
//    @Deprecated
//    public String(byte ascii[], int hibyte, int offset, int count) {
//        checkBounds(ascii, offset, count);
//        char value[] = new char[count];
//
//        if (hibyte == 0) {
//            for (int i = count; i-- > 0;) {//这里的写法注意:i-->0,这里是写for循环时候的简便写法,应该学会这样写,提高程序效率.
//                value[i] = (char)(ascii[i + offset] & 0xff);
//            }
//        } else {
//            hibyte <<= 8;
//            for (int i = count; i-- > 0;) {
//                value[i] = (char)(hibyte | (ascii[i + offset] & 0xff));//求完与,再求或
//            }
//        }
//        this.value = value;
//    }
//
//    /**
//     * Allocates a new {@code String} containing characters constructed from
//     * an array of 8-bit integer values. Each character <i>c</i>in the
//     * resulting string is constructed from the corresponding component
//     * <i>b</i> in the byte array such that:
//     *
//     * <blockquote><pre>
//     *     <b><i>c</i></b> == (char)(((hibyte &amp; 0xff) &lt;&lt; 8)
//     *                         | (<b><i>b</i></b> &amp; 0xff))
//     * </pre></blockquote>
//     *
//     * @deprecated  This method does not properly convert bytes into
//     * characters.  As of JDK&nbsp;1.1, the preferred way to do this is via the
//     * {@code String} constructors that take a {@link
//     * java.nio.charset.Charset}, charset name, or that use the platform's
//     * default charset.
//     *
//     * 显然,注解表明这一方法也是在JDK8中不再被期望使用了.而且这一方法调用了上面的构造函数,自然也不会被期望使用的.
//     * 这一方法会新创建一个字符串,组成字符串的字符来自参数ascii数组中部分整数(当然这些整数会被转为字符存储).
//     * 这一方法不一定能准确把字节转为字符.就JKD1.1而言,它采用了使用带有指定字符集的构造器函数或者使用平台默认的编码方式来实现
//     * 这一方法的.
//     *
//     * @param  ascii //要被转为字符的字节数组
//     *         The bytes to be converted to characters
//     *
//     * @param  hibyte //16位Unicode代码单元的高8位
//     *         The top 8 bits of each 16-bit Unicode code unit
//     *
//     * @see  #String(byte[], int, int, java.lang.String)
//     * @see  #String(byte[], int, int, java.nio.charset.Charset)
//     * @see  #String(byte[], int, int)
//     * @see  #String(byte[], java.lang.String)
//     * @see  #String(byte[], java.nio.charset.Charset)
//     * @see  #String(byte[])
//     */
//    @Deprecated
//    public String(byte ascii[], int hibyte) {
//        this(ascii, hibyte, 0, ascii.length);
//    }
//
//    /* Common private utility method used to bounds check the byte array
//     * and requested offset & length values used by the String(byte[],..)
//     * constructors.
//     * 这是一个私有静态方法,供构造函数使用.用于检查复制边界的合法性问题.
//     */
//    private static void checkBounds(byte[] bytes, int offset, int length) {
//        //复制字符个数是否小于0
//        if (length < 0)
//            throw new StringIndexOutOfBoundsException(length);
//        //开始复制的索引是否小于0
//        if (offset < 0)
//            throw new StringIndexOutOfBoundsException(offset);
//        //从offset处开始的字符到bytes最后一个字符 的总个数,是否小于需要复制的字符个数
//        if (offset > bytes.length - length)
//            throw new StringIndexOutOfBoundsException(offset + length);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified subarray of
//     * bytes using the specified charset.  The length of the new {@code String}
//     * is a function of the charset, and hence may not be equal to the length
//     * of the subarray.
//     *
//     * <p> The behavior of this constructor when the given bytes are not valid
//     * in the given charset is unspecified.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 通过此方法,通过使用指定的字符集,利用参数bytes数组的子数组中的元素,构造出一个新的字符串.这个新字符串的长度依赖于选定的字符集,
//     * 因此这可能和子数组的长度并不一致.
//     * 当给定的bytes数组在指定的字符集下并不是有效字符时,构造器方法会如何运行并没有指定.因此,如果想要尽可能的控制字符转化过程,那么
//     * CharsetDecoder类应该被用到.
//     *
//     * @param  bytes 被转为字符的字节数组
//     *         The bytes to be decoded into characters
//     *
//     * @param  offset 被转为字符的第一个字节的索引
//     *         The index of the first byte to decode
//     *
//     * @param  length 需要转化的字节个数
//     *         The number of bytes to decode
//
//     * @param  charsetName 支持的字符集名称
//     *         The name of a supported {@linkplain java.nio.charset.Charset
//     *         charset}
//     *
//     * @throws  UnsupportedEncodingException
//     *          If the named charset is not supported
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} and {@code length} arguments index
//     *          characters outside the bounds of the {@code bytes} array
//     *
//     * @since  JDK1.1
//     */
//    public String(byte bytes[], int offset, int length, String charsetName)
//            throws UnsupportedEncodingException {
//        //如果字符集名称为null,则抛出异常
//        if (charsetName == null)
//            throw new NullPointerException("charsetName");
//        //检查复制边界合法性
//        checkBounds(bytes, offset, length);
//        //为本String的value数组赋值:具体就是调用类StringCoding的包方法decode()将字节数组转为字符数组.
//        this.value = StringCoding.decode(charsetName, bytes, offset, length);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified subarray of
//     * bytes using the specified {@linkplain java.nio.charset.Charset charset}.
//     * The length of the new {@code String} is a function of the charset, and
//     * hence may not be equal to the length of the subarray.
//     *
//     * <p> This method always replaces malformed-input and unmappable-character
//     * sequences with this charset's default replacement string.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 根据给定的字符集,利用bytes数组的子数组,构造一个新的字符串.
//     * 新字符串的长度和给定的字符集有关系,因此不一定等于子数组的长度.
//     * 在这一方法中:被转化的byte子数组中,如果有错误的字符或者不能使用指定字符集转化的字符,那么新生成的字符串为
//     * 指定字符集的默认字符串.
//     * 字符转化过程中,如果需要尽可能多的控制,可以使用CharsetDecoder类.
//     *
//     * @param  bytes
//     *         The bytes to be decoded into characters
//     *
//     * @param  offset
//     *         The index of the first byte to decode
//     *
//     * @param  length
//     *         The number of bytes to decode
//     *
//     * @param  charset
//     *         The {@linkplain java.nio.charset.Charset charset} to be used to
//     *         decode the {@code bytes}
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} and {@code length} arguments index
//     *          characters outside the bounds of the {@code bytes} array
//     *
//     * @since  1.6 从JDK6开始有这个方法
//     */
//    public String(byte bytes[], int offset, int length, Charset charset) {
//        //如果指定字符集为null,抛异常
//        if (charset == null)
//            throw new NullPointerException("charset");
//        //检查复制边界合法性
//        checkBounds(bytes, offset, length);
//        //调用类StringCoding的包方法decode(),最终调用的是Arrays.copyOf(),将新声明并赋值的char[]赋值给value.
//        this.value =  StringCoding.decode(charset, bytes, offset, length);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified array of bytes
//     * using the specified {@linkplain java.nio.charset.Charset charset}.  The
//     * length of the new {@code String} is a function of the charset, and hence
//     * may not be equal to the length of the byte array.
//     *
//     * <p> The behavior of this constructor when the given bytes are not valid
//     * in the given charset is unspecified.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 根据指定的字符集,将指定字节数组转为字符并生成一个新的字符串.
//     * 新的字符串长度依赖于指定的字符集,因此这可能和字节数组的长度并不一致.
//     * 在指定字符集下,当字节数组bytes无效时,实例构造器方法会有什么异常,在这一方法中并没有明确规定.
//     * 如果想在字符转化过程中获得更多的控制权,可以使用CharsetDecoder类.
//     *
//     * @param  bytes //被转码的字节数组
//     *         The bytes to be decoded into characters
//     *
//     * @param  charsetName //转码用到的字符集
//     *         The name of a supported {@linkplain java.nio.charset.Charset
//     *         charset}
//     *
//     * @throws  UnsupportedEncodingException
//     *          If the named charset is not supported
//     *
//     * @since  JDK1.1
//     */
//    public String(byte bytes[], String charsetName)
//            throws UnsupportedEncodingException {
//        //通过调用另一个构造器方法,将整个bytes数组转化为一个字符串.
//        this(bytes, 0, bytes.length, charsetName);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified array of
//     * bytes using the specified {@linkplain java.nio.charset.Charset charset}.
//     * The length of the new {@code String} is a function of the charset, and
//     * hence may not be equal to the length of the byte array.
//     *
//     * <p> This method always replaces malformed-input and unmappable-character
//     * sequences with this charset's default replacement string.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 这一方法和上面一个方法只有一个不一样的地方:当输入的bytes数组无效时,
//     * 上面的方法:转化能够正常进行,或者会抛出什么异常并没有给出明确的代码表示.
//     * 本方法:使用指定的字符集默认的替代字符串作为生成结果.
//     *
//     * @param  bytes
//     *         The bytes to be decoded into characters
//     *
//     * @param  charset
//     *         The {@linkplain java.nio.charset.Charset charset} to be used to
//     *         decode the {@code bytes}
//     *
//     * @since  1.6 从JDK6开始,且和上面的方法的区别之处就能发现,这一方法是对上面方法的改进.
//     */
//    public String(byte bytes[], Charset charset) {
//        this(bytes, 0, bytes.length, charset);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified subarray of
//     * bytes using the platform's default charset.  The length of the new
//     * {@code String} is a function of the charset, and hence may not be equal
//     * to the length of the subarray.
//     *
//     * <p> The behavior of this constructor when the given bytes are not valid
//     * in the default charset is unspecified.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 使用平台默认编码方式构建一个新的字符串.
//     * 字符串长度和平台的编码方式有关系,因此不一定和子数组的长度一致.
//     * 如果在平台默认的编码方式下,字节数组bytes[]并不是有效的,那么这次转化能否正常进行或者会抛出什么异常,并没有给出
//     * 明确的代码提示.
//     * 如果想要在代码转化过程中获得更多的控制权,可以使用CharsetDecoder类.
//     *
//     * @param  bytes
//     *         The bytes to be decoded into characters
//     *
//     * @param  offset
//     *         The index of the first byte to decode
//     *
//     * @param  length
//     *         The number of bytes to decode
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If the {@code offset} and the {@code length} arguments index
//     *          characters outside the bounds of the {@code bytes} array
//     *
//     * @since  JDK1.1
//     */
//    public String(byte bytes[], int offset, int length) {
//        //检查复制边界的合法性
//        checkBounds(bytes, offset, length);
//        //为存储当前字符串的value[]赋值.
//        this.value = StringCoding.decode(bytes, offset, length);
//    }
//
//    /**
//     * Constructs a new {@code String} by decoding the specified array of bytes
//     * using the platform's default charset.  The length of the new {@code
//     * String} is a function of the charset, and hence may not be equal to the
//     * length of the byte array.
//     *
//     * <p> The behavior of this constructor when the given bytes are not valid
//     * in the default charset is unspecified.  The {@link
//     * java.nio.charset.CharsetDecoder} class should be used when more control
//     * over the decoding process is required.
//     *
//     * 单纯调用了上一个方法,就不分析了.
//     *
//     * @param  bytes
//     *         The bytes to be decoded into characters
//     *
//     * @since  JDK1.1
//     */
//    public String(byte bytes[]) {
//        this(bytes, 0, bytes.length);
//    }
//
//    /**
//     * Allocates a new string that contains the sequence of characters
//     * currently contained in the string buffer argument. The contents of the
//     * string buffer are copied; subsequent modification of the string buffer
//     * does not affect the newly created string.
//     *
//     * 这一方法的调用会生成一个包含参数buffer字符序列的字符串.参数buffer中的字符被复制;后期对buffer的修改不会影响新创建的这个字符串.
//     *
//     * @param  buffer
//     *         A {@code StringBuffer}
//     */
//    public String(StringBuffer buffer) {
//        /**注意:这里使用了synchronized,所以这是一个线程安全的方法
//         * 其实本身StringBuilder就是线程安全的,但这是为了保证各个线程可以正确更改StringBuilder结构,而这里再次用synchronized
//         * 就保证了对当前buffer的value进行加锁,这就保证了本方法执行期间buffer的所有字符不可变,这样才能保证复制方法的正确执行,
//         * 因为复制中会用到当前的各个字符和buffer的长度.
//         */
//        synchronized(buffer) {
//            //buffer.getValue()返回的时buffer的final类型的char[]
//            this.value = Arrays.copyOf(buffer.getValue(), buffer.length());
//        }
//    }
//
//    /**
//     * Allocates a new string that contains the sequence of characters
//     * currently contained in the string builder argument. The contents of the
//     * string builder are copied; subsequent modification of the string builder
//     * does not affect the newly created string.
//     *
//     * <p> This constructor is provided to ease migration to {@code
//     * StringBuilder}. Obtaining a string from a string builder via the {@code
//     * toString} method is likely to run faster and is generally preferred.
//     *
//     * 根据参数builder中的字符序列,生成一个新字符串.builder中的字符会被复制;后期对builder的修改不会影响新生成的这个字符串.
//     * 提供这一构造方法,是为了方便将StringBuilder转为String.然而,通过StringBuilder的toString()方法获得一个字符串貌似
//     * 速度更快,而且toString()方法更通用.
//     *
//     * @param   builder
//     *          A {@code StringBuilder}
//     *
//     * @since  1.5
//     */
//    public String(StringBuilder builder) {
//        this.value = Arrays.copyOf(builder.getValue(), builder.length());
//    }
//
//
//    /*
//    * Package private constructor which shares value array for speed.
//    * this constructor is always expected to be called with share==true.
//    * a separate constructor is needed because we already have a public
//    * String(char[]) constructor that makes a copy of the given char[].
//    *
//    * 这是一个包私有实例构造器方法.这一方法的目的是为了提高程序速度,从而共享了value数组.
//    * 这个方法被调用时,参数share必需为true.
//    */
//    String(char[] value, boolean share) {
//        // assert share : "unshared not supported";
//        this.value = value;
//    }
//
//    //到此为止,所有的构造函数都分析完了
//    /**
//     * Returns the length of this string.
//     * The length is equal to the number of <a href="Character.html#unicode">Unicode
//     * code units</a> in the string.
//     *
//     * 返回字符串的长度.
//     * 长度是指:Unicode代码单元的个数(UTF-8编码方式下:1个字节或者2个字节或者3个字节存放一个字符; UTF-16是2个字节存放一个字符.)
//     * @return  the length of the sequence of characters represented by this
//     *          object.
//     */
//    public int length() {
//        return value.length;
//    }
//
//    /**
//     * Returns {@code true} if, and only if, {@link #length()} is {@code 0}.
//     *
//     * 如果长度为0,返回true;否则,返回false;
//     *
//     * @return {@code true} if {@link #length()} is {@code 0}, otherwise
//     * {@code false}
//     *
//     * @since 1.6
//     */
//    public boolean isEmpty() {
//        //原来isEmpty方法,只有一行代码
//        return value.length == 0;
//    }
//
//    /**
//     * Returns the {@code char} value at the
//     * specified index. An index ranges from {@code 0} to
//     * {@code length() - 1}. The first {@code char} value of the sequence
//     * is at index {@code 0}, the next at index {@code 1},
//     * and so on, as for array indexing.
//     *
//     * 本方法重点:时间复杂度O(1)
//     *
//     * 返回String实例指定索引index处的字符.
//     * 索引参数范围为0~length()-1;调用方法的参数范围不在这个范围里面,则抛出异常.
//     * 因为value[]是个数组,所以查找指定索引处的字符:时间复杂度为O(1);
//     *
//     * <p>If the {@code char} value specified by the index is a
//     * <a href="Character.html#unicode">surrogate</a>, the surrogate
//     * value is returned.
//     * 如果指定的索引index处是一个代理字符,则返回代理字符值.
//     *
//     * @param      index   the index of the {@code char} value.
//     * @return     the {@code char} value at the specified index of this string.
//     *             The first {@code char} value is at index {@code 0}.
//     * @exception  IndexOutOfBoundsException  if the {@code index}
//     *             argument is negative or not less than the length of this
//     *             string.
//     */
//    public char charAt(int index) {
//        if ((index < 0) || (index >= value.length)) {
//            throw new StringIndexOutOfBoundsException(index);
//        }
//        return value[index];
//    }
//
//    /**
//     * Returns the character (Unicode code point) at the specified
//     * index. The index refers to {@code char} values
//     * (Unicode code units) and ranges from {@code 0} to
//     * {@link #length()}{@code  - 1}.
//     *
//     * <p> If the {@code char} value specified at the given index
//     * is in the high-surrogate range, the following index is less
//     * than the length of this {@code String}, and the
//     * {@code char} value at the following index is in the
//     * low-surrogate range, then the supplementary code point
//     * corresponding to this surrogate pair is returned. Otherwise,
//     * the {@code char} value at the given index is returned.
//     *
//     * 本方法返回指定索引index处的字符的代码点值(assii码值).
//     * 举个例子:
//     *  public static void main(String[] args) throws Exception {
//           String str="123456";//3的assii码为51
//           System.out.println(str.codePointAt(2));//输出:51
//       }
//     *
//     * @param      index the index to the {@code char} values
//     * @return     the code point value of the character at the
//     *             {@code index}
//     * @exception  IndexOutOfBoundsException  if the {@code index}
//     *             argument is negative or not less than the length of this
//     *             string.
//     * @since      1.5
//     */
//    public int codePointAt(int index) {
//        if ((index < 0) || (index >= value.length)) {
//            throw new StringIndexOutOfBoundsException(index);
//        }
//        return Character.codePointAtImpl(value, index, value.length);
//    }
//
//    /**
//     * Returns the character (Unicode code point) before the specified
//     * index. The index refers to {@code char} values
//     * (Unicode code units) and ranges from {@code 1} to {@link
//     * java.lang.CharSequence#length() length}.
//     *
//     * <p> If the {@code char} value at {@code (index - 1)}
//     * is in the low-surrogate range, {@code (index - 2)} is not
//     * negative, and the {@code char} value at {@code (index -
//     * 2)} is in the high-surrogate range, then the
//     * supplementary code point value of the surrogate pair is
//     * returned. If the {@code char} value at {@code index -
//     * 1} is an unpaired low-surrogate or a high-surrogate, the
//     * surrogate value is returned.
//     *
//     * @param     index the index following the code point that should be returned
//     * @return    the Unicode code point value before the given index.
//     * @exception IndexOutOfBoundsException if the {@code index}
//     *            argument is less than 1 or greater than the length
//     *            of this string.
//     * @since     1.5
//     */
//    public int codePointBefore(int index) {
//        int i = index - 1;
//        if ((i < 0) || (i >= value.length)) {
//            throw new StringIndexOutOfBoundsException(index);
//        }
//        return Character.codePointBeforeImpl(value, index, 0);
//    }
//
//    /**
//     * Returns the number of Unicode code points in the specified text
//     * range of this {@code String}. The text range begins at the
//     * specified {@code beginIndex} and extends to the
//     * {@code char} at index {@code endIndex - 1}. Thus the
//     * length (in {@code char}s) of the text range is
//     * {@code endIndex-beginIndex}. Unpaired surrogates within
//     * the text range count as one code point each.
//     *
//     * @param beginIndex the index to the first {@code char} of
//     * the text range.
//     * @param endIndex the index after the last {@code char} of
//     * the text range.
//     * @return the number of Unicode code points in the specified text
//     * range
//     * @exception IndexOutOfBoundsException if the
//     * {@code beginIndex} is negative, or {@code endIndex}
//     * is larger than the length of this {@code String}, or
//     * {@code beginIndex} is larger than {@code endIndex}.
//     * @since  1.5
//     */
//    public int codePointCount(int beginIndex, int endIndex) {
//        if (beginIndex < 0 || endIndex > value.length || beginIndex > endIndex) {
//            throw new IndexOutOfBoundsException();
//        }
//        return Character.codePointCountImpl(value, beginIndex, endIndex - beginIndex);
//    }
//
//    /**
//     * Returns the index within this {@code String} that is
//     * offset from the given {@code index} by
//     * {@code codePointOffset} code points. Unpaired surrogates
//     * within the text range given by {@code index} and
//     * {@code codePointOffset} count as one code point each.
//     *
//     * @param index the index to be offset
//     * @param codePointOffset the offset in code points
//     * @return the index within this {@code String}
//     * @exception IndexOutOfBoundsException if {@code index}
//     *   is negative or larger then the length of this
//     *   {@code String}, or if {@code codePointOffset} is positive
//     *   and the substring starting with {@code index} has fewer
//     *   than {@code codePointOffset} code points,
//     *   or if {@code codePointOffset} is negative and the substring
//     *   before {@code index} has fewer than the absolute value
//     *   of {@code codePointOffset} code points.
//     * @since 1.5
//     */
//    public int offsetByCodePoints(int index, int codePointOffset) {
//        if (index < 0 || index > value.length) {
//            throw new IndexOutOfBoundsException();
//        }
//        return Character.offsetByCodePointsImpl(value, 0, value.length,
//                index, codePointOffset);
//    }
//
//    /**
//     * Copy characters from this string into dst starting at dstBegin.
//     * This method doesn't perform any range checking.
//     */
//    void getChars(char dst[], int dstBegin) {
//        System.arraycopy(value, 0, dst, dstBegin, value.length);
//    }
//
//    /**
//     * Copies characters from this string into the destination character
//     * array.
//     * <p>
//     * The first character to be copied is at index {@code srcBegin};
//     * the last character to be copied is at index {@code srcEnd-1}
//     * (thus the total number of characters to be copied is
//     * {@code srcEnd-srcBegin}). The characters are copied into the
//     * subarray of {@code dst} starting at index {@code dstBegin}
//     * and ending at index:
//     * <blockquote><pre>
//     *     dstBegin + (srcEnd-srcBegin) - 1
//     * </pre></blockquote>
//     *
//     * @param      srcBegin   index of the first character in the string
//     *                        to copy.
//     * @param      srcEnd     index after the last character in the string
//     *                        to copy.
//     * @param      dst        the destination array.
//     * @param      dstBegin   the start offset in the destination array.
//     * @exception IndexOutOfBoundsException If any of the following
//     *            is true:
//     *            <ul><li>{@code srcBegin} is negative.
//     *            <li>{@code srcBegin} is greater than {@code srcEnd}
//     *            <li>{@code srcEnd} is greater than the length of this
//     *                string
//     *            <li>{@code dstBegin} is negative
//     *            <li>{@code dstBegin+(srcEnd-srcBegin)} is larger than
//     *                {@code dst.length}</ul>
//     */
//    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
//        if (srcBegin < 0) {
//            throw new StringIndexOutOfBoundsException(srcBegin);
//        }
//        if (srcEnd > value.length) {
//            throw new StringIndexOutOfBoundsException(srcEnd);
//        }
//        if (srcBegin > srcEnd) {
//            throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
//        }
//        System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
//    }
//
//    /**
//     * Copies characters from this string into the destination byte array. Each
//     * byte receives the 8 low-order bits of the corresponding character. The
//     * eight high-order bits of each character are not copied and do not
//     * participate in the transfer in any way.
//     *
//     * <p> The first character to be copied is at index {@code srcBegin}; the
//     * last character to be copied is at index {@code srcEnd-1}.  The total
//     * number of characters to be copied is {@code srcEnd-srcBegin}. The
//     * characters, converted to bytes, are copied into the subarray of {@code
//     * dst} starting at index {@code dstBegin} and ending at index:
//     *
//     * <blockquote><pre>
//     *     dstBegin + (srcEnd-srcBegin) - 1
//     * </pre></blockquote>
//     *
//     * @deprecated  This method does not properly convert characters into
//     * bytes.  As of JDK&nbsp;1.1, the preferred way to do this is via the
//     * {@link #getBytes()} method, which uses the platform's default charset.
//     *
//     * @param  srcBegin
//     *         Index of the first character in the string to copy
//     *
//     * @param  srcEnd
//     *         Index after the last character in the string to copy
//     *
//     * @param  dst
//     *         The destination array
//     *
//     * @param  dstBegin
//     *         The start offset in the destination array
//     *
//     * @throws  IndexOutOfBoundsException
//     *          If any of the following is true:
//     *          <ul>
//     *            <li> {@code srcBegin} is negative
//     *            <li> {@code srcBegin} is greater than {@code srcEnd}
//     *            <li> {@code srcEnd} is greater than the length of this String
//     *            <li> {@code dstBegin} is negative
//     *            <li> {@code dstBegin+(srcEnd-srcBegin)} is larger than {@code
//     *                 dst.length}
//     *          </ul>
//     */
//    @Deprecated
//    public void getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) {
//        if (srcBegin < 0) {
//            throw new StringIndexOutOfBoundsException(srcBegin);
//        }
//        if (srcEnd > value.length) {
//            throw new StringIndexOutOfBoundsException(srcEnd);
//        }
//        if (srcBegin > srcEnd) {
//            throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
//        }
//        Objects.requireNonNull(dst);
//
//        int j = dstBegin;
//        int n = srcEnd;
//        int i = srcBegin;
//        char[] val = value;   /* avoid getfield opcode */
//
//        while (i < n) {
//            dst[j++] = (byte)val[i++];
//        }
//    }
//
//    /**
//     * Encodes this {@code String} into a sequence of bytes using the named
//     * charset, storing the result into a new byte array.
//     *
//     * <p> The behavior of this method when this string cannot be encoded in
//     * the given charset is unspecified.  The {@link
//     * java.nio.charset.CharsetEncoder} class should be used when more control
//     * over the encoding process is required.
//     *
//     * @param  charsetName
//     *         The name of a supported {@linkplain java.nio.charset.Charset
//     *         charset}
//     *
//     * @return  The resultant byte array
//     *
//     * @throws  UnsupportedEncodingException
//     *          If the named charset is not supported
//     *
//     * @since  JDK1.1
//     */
//    public byte[] getBytes(String charsetName)
//            throws UnsupportedEncodingException {
//        if (charsetName == null) throw new NullPointerException();
//        return StringCoding.encode(charsetName, value, 0, value.length);
//    }
//
//    /**
//     * Encodes this {@code String} into a sequence of bytes using the given
//     * {@linkplain java.nio.charset.Charset charset}, storing the result into a
//     * new byte array.
//     *
//     * <p> This method always replaces malformed-input and unmappable-character
//     * sequences with this charset's default replacement byte array.  The
//     * {@link java.nio.charset.CharsetEncoder} class should be used when more
//     * control over the encoding process is required.
//     *
//     * @param  charset
//     *         The {@linkplain java.nio.charset.Charset} to be used to encode
//     *         the {@code String}
//     *
//     * @return  The resultant byte array
//     *
//     * @since  1.6
//     */
//    public byte[] getBytes(Charset charset) {
//        if (charset == null) throw new NullPointerException();
//        return StringCoding.encode(charset, value, 0, value.length);
//    }
//
//    /**
//     * Encodes this {@code String} into a sequence of bytes using the
//     * platform's default charset, storing the result into a new byte array.
//     *
//     * <p> The behavior of this method when this string cannot be encoded in
//     * the default charset is unspecified.  The {@link
//     * java.nio.charset.CharsetEncoder} class should be used when more control
//     * over the encoding process is required.
//     *
//     * @return  The resultant byte array
//     *
//     * @since      JDK1.1
//     */
//    public byte[] getBytes() {
//        return StringCoding.encode(value, 0, value.length);
//    }
//
//    /**
//     * Compares this string to the specified object.  The result is {@code
//     * true} if and only if the argument is not {@code null} and is a {@code
//     * String} object that represents the same sequence of characters as this
//     * object.
//     *
//     * @param  anObject
//     *         The object to compare this {@code String} against
//     *
//     * @return  {@code true} if the given object represents a {@code String}
//     *          equivalent to this string, {@code false} otherwise
//     *
//     * @see  #compareTo(String)
//     * @see  #equalsIgnoreCase(String)
//     */
//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//        if (anObject instanceof String) {
//            String anotherString = (String)anObject;
//            int n = value.length;
//            if (n == anotherString.value.length) {
//                char v1[] = value;
//                char v2[] = anotherString.value;
//                int i = 0;
//                while (n-- != 0) {
//                    if (v1[i] != v2[i])
//                        return false;
//                    i++;
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Compares this string to the specified {@code StringBuffer}.  The result
//     * is {@code true} if and only if this {@code String} represents the same
//     * sequence of characters as the specified {@code StringBuffer}. This method
//     * synchronizes on the {@code StringBuffer}.
//     *
//     * @param  sb
//     *         The {@code StringBuffer} to compare this {@code String} against
//     *
//     * @return  {@code true} if this {@code String} represents the same
//     *          sequence of characters as the specified {@code StringBuffer},
//     *          {@code false} otherwise
//     *
//     * @since  1.4
//     */
//    public boolean contentEquals(StringBuffer sb) {
//        return contentEquals((java.lang.CharSequence)sb);
//    }
//
//    private boolean nonSyncContentEquals(AbstractStringBuilder sb) {
//        char v1[] = value;
//        char v2[] = sb.getValue();
//        int n = v1.length;
//        if (n != sb.length()) {
//            return false;
//        }
//        for (int i = 0; i < n; i++) {
//            if (v1[i] != v2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Compares this string to the specified {@code CharSequence}.  The
//     * result is {@code true} if and only if this {@code String} represents the
//     * same sequence of char values as the specified sequence. Note that if the
//     * {@code CharSequence} is a {@code StringBuffer} then the method
//     * synchronizes on it.
//     *
//     * @param  cs
//     *         The sequence to compare this {@code String} against
//     *
//     * @return  {@code true} if this {@code String} represents the same
//     *          sequence of char values as the specified sequence, {@code
//     *          false} otherwise
//     *
//     * @since  1.5
//     */
//    public boolean contentEquals(java.lang.CharSequence cs) {
//        // Argument is a StringBuffer, StringBuilder
//        if (cs instanceof AbstractStringBuilder) {
//            if (cs instanceof StringBuffer) {
//                synchronized(cs) {
//                    return nonSyncContentEquals((AbstractStringBuilder)cs);
//                }
//            } else {
//                return nonSyncContentEquals((AbstractStringBuilder)cs);
//            }
//        }
//        // Argument is a String
//        if (cs instanceof String) {
//            return equals(cs);
//        }
//        // Argument is a generic CharSequence
//        char v1[] = value;
//        int n = v1.length;
//        if (n != cs.length()) {
//            return false;
//        }
//        for (int i = 0; i < n; i++) {
//            if (v1[i] != cs.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Compares this {@code String} to another {@code String}, ignoring case
//     * considerations.  Two strings are considered equal ignoring case if they
//     * are of the same length and corresponding characters in the two strings
//     * are equal ignoring case.
//     *
//     * <p> Two characters {@code c1} and {@code c2} are considered the same
//     * ignoring case if at least one of the following is true:
//     * <ul>
//     *   <li> The two characters are the same (as compared by the
//     *        {@code ==} operator)
//     *   <li> Applying the method {@link
//     *        java.lang.Character#toUpperCase(char)} to each character
//     *        produces the same result
//     *   <li> Applying the method {@link
//     *        java.lang.Character#toLowerCase(char)} to each character
//     *        produces the same result
//     * </ul>
//     *
//     * @param  anotherString
//     *         The {@code String} to compare this {@code String} against
//     *
//     * @return  {@code true} if the argument is not {@code null} and it
//     *          represents an equivalent {@code String} ignoring case; {@code
//     *          false} otherwise
//     *
//     * @see  #equals(Object)
//     */
//    public boolean equalsIgnoreCase(String anotherString) {
//        return (this == anotherString) ? true
//                : (anotherString != null)
//                && (anotherString.value.length == value.length)
//                && regionMatches(true, 0, anotherString, 0, value.length);
//    }
//
//    /**
//     * Compares two strings lexicographically.
//     * The comparison is based on the Unicode value of each character in
//     * the strings. The character sequence represented by this
//     * {@code String} object is compared lexicographically to the
//     * character sequence represented by the argument string. The result is
//     * a negative integer if this {@code String} object
//     * lexicographically precedes the argument string. The result is a
//     * positive integer if this {@code String} object lexicographically
//     * follows the argument string. The result is zero if the strings
//     * are equal; {@code compareTo} returns {@code 0} exactly when
//     * the {@link #equals(Object)} method would return {@code true}.
//     * <p>
//     * This is the definition of lexicographic ordering. If two strings are
//     * different, then either they have different characters at some index
//     * that is a valid index for both strings, or their lengths are different,
//     * or both. If they have different characters at one or more index
//     * positions, let <i>k</i> be the smallest such index; then the string
//     * whose character at position <i>k</i> has the smaller value, as
//     * determined by using the &lt; operator, lexicographically precedes the
//     * other string. In this case, {@code compareTo} returns the
//     * difference of the two character values at position {@code k} in
//     * the two string -- that is, the value:
//     * <blockquote><pre>
//     * this.charAt(k)-anotherString.charAt(k)
//     * </pre></blockquote>
//     * If there is no index position at which they differ, then the shorter
//     * string lexicographically precedes the longer string. In this case,
//     * {@code compareTo} returns the difference of the lengths of the
//     * strings -- that is, the value:
//     * <blockquote><pre>
//     * this.length()-anotherString.length()
//     * </pre></blockquote>
//     *
//     * @param   anotherString   the {@code String} to be compared.
//     * @return  the value {@code 0} if the argument string is equal to
//     *          this string; a value less than {@code 0} if this string
//     *          is lexicographically less than the string argument; and a
//     *          value greater than {@code 0} if this string is
//     *          lexicographically greater than the string argument.
//     */
//    public int compareTo(String anotherString) {
//        int len1 = value.length;
//        int len2 = anotherString.value.length;
//        int lim = Math.min(len1, len2);
//        char v1[] = value;
//        char v2[] = anotherString.value;
//
//        int k = 0;
//        while (k < lim) {
//            char c1 = v1[k];
//            char c2 = v2[k];
//            if (c1 != c2) {
//                return c1 - c2;
//            }
//            k++;
//        }
//        return len1 - len2;
//    }
//
//    /**
//     * A Comparator that orders {@code String} objects as by
//     * {@code compareToIgnoreCase}. This comparator is serializable.
//     * <p>
//     * Note that this Comparator does <em>not</em> take locale into account,
//     * and will result in an unsatisfactory ordering for certain locales.
//     * The java.text package provides <em>Collators</em> to allow
//     * locale-sensitive ordering.
//     *
//     * @see     java.text.Collator#compare(String, String)
//     * @since   1.2
//     */
//    public static final Comparator<String> CASE_INSENSITIVE_ORDER
//            = new CaseInsensitiveComparator();
//    private static class CaseInsensitiveComparator
//            implements Comparator<String>, java.io.Serializable {
//        // use serialVersionUID from JDK 1.2.2 for interoperability
//        private static final long serialVersionUID = 8575799808933029326L;
//
//        public int compare(String s1, String s2) {
//            int n1 = s1.length();
//            int n2 = s2.length();
//            int min = Math.min(n1, n2);
//            for (int i = 0; i < min; i++) {
//                char c1 = s1.charAt(i);
//                char c2 = s2.charAt(i);
//                if (c1 != c2) {
//                    c1 = Character.toUpperCase(c1);
//                    c2 = Character.toUpperCase(c2);
//                    if (c1 != c2) {
//                        c1 = Character.toLowerCase(c1);
//                        c2 = Character.toLowerCase(c2);
//                        if (c1 != c2) {
//                            // No overflow because of numeric promotion
//                            return c1 - c2;
//                        }
//                    }
//                }
//            }
//            return n1 - n2;
//        }
//
//        /** Replaces the de-serialized object. */
//        private Object readResolve() { return CASE_INSENSITIVE_ORDER; }
//    }
//
//    /**
//     * Compares two strings lexicographically, ignoring case
//     * differences. This method returns an integer whose sign is that of
//     * calling {@code compareTo} with normalized versions of the strings
//     * where case differences have been eliminated by calling
//     * {@code Character.toLowerCase(Character.toUpperCase(character))} on
//     * each character.
//     * <p>
//     * Note that this method does <em>not</em> take locale into account,
//     * and will result in an unsatisfactory ordering for certain locales.
//     * The java.text package provides <em>collators</em> to allow
//     * locale-sensitive ordering.
//     *
//     * @param   str   the {@code String} to be compared.
//     * @return  a negative integer, zero, or a positive integer as the
//     *          specified String is greater than, equal to, or less
//     *          than this String, ignoring case considerations.
//     * @see     java.text.Collator#compare(String, String)
//     * @since   1.2
//     */
//    public int compareToIgnoreCase(String str) {
//        return CASE_INSENSITIVE_ORDER.compare(this, str);
//    }
//
//    /**
//     * Tests if two string regions are equal.
//     * <p>
//     * A substring of this {@code String} object is compared to a substring
//     * of the argument other. The result is true if these substrings
//     * represent identical character sequences. The substring of this
//     * {@code String} object to be compared begins at index {@code toffset}
//     * and has length {@code len}. The substring of other to be compared
//     * begins at index {@code ooffset} and has length {@code len}. The
//     * result is {@code false} if and only if at least one of the following
//     * is true:
//     * <ul><li>{@code toffset} is negative.
//     * <li>{@code ooffset} is negative.
//     * <li>{@code toffset+len} is greater than the length of this
//     * {@code String} object.
//     * <li>{@code ooffset+len} is greater than the length of the other
//     * argument.
//     * <li>There is some nonnegative integer <i>k</i> less than {@code len}
//     * such that:
//     * {@code this.charAt(toffset + }<i>k</i>{@code ) != other.charAt(ooffset + }
//     * <i>k</i>{@code )}
//     * </ul>
//     *
//     * @param   toffset   the starting offset of the subregion in this string.
//     * @param   other     the string argument.
//     * @param   ooffset   the starting offset of the subregion in the string
//     *                    argument.
//     * @param   len       the number of characters to compare.
//     * @return  {@code true} if the specified subregion of this string
//     *          exactly matches the specified subregion of the string argument;
//     *          {@code false} otherwise.
//     */
//    public boolean regionMatches(int toffset, String other, int ooffset,
//                                 int len) {
//        char ta[] = value;
//        int to = toffset;
//        char pa[] = other.value;
//        int po = ooffset;
//        // Note: toffset, ooffset, or len might be near -1>>>1.
//        if ((ooffset < 0) || (toffset < 0)
//                || (toffset > (long)value.length - len)
//                || (ooffset > (long)other.value.length - len)) {
//            return false;
//        }
//        while (len-- > 0) {
//            if (ta[to++] != pa[po++]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Tests if two string regions are equal.
//     * <p>
//     * A substring of this {@code String} object is compared to a substring
//     * of the argument {@code other}. The result is {@code true} if these
//     * substrings represent character sequences that are the same, ignoring
//     * case if and only if {@code ignoreCase} is true. The substring of
//     * this {@code String} object to be compared begins at index
//     * {@code toffset} and has length {@code len}. The substring of
//     * {@code other} to be compared begins at index {@code ooffset} and
//     * has length {@code len}. The result is {@code false} if and only if
//     * at least one of the following is true:
//     * <ul><li>{@code toffset} is negative.
//     * <li>{@code ooffset} is negative.
//     * <li>{@code toffset+len} is greater than the length of this
//     * {@code String} object.
//     * <li>{@code ooffset+len} is greater than the length of the other
//     * argument.
//     * <li>{@code ignoreCase} is {@code false} and there is some nonnegative
//     * integer <i>k</i> less than {@code len} such that:
//     * <blockquote><pre>
//     * this.charAt(toffset+k) != other.charAt(ooffset+k)
//     * </pre></blockquote>
//     * <li>{@code ignoreCase} is {@code true} and there is some nonnegative
//     * integer <i>k</i> less than {@code len} such that:
//     * <blockquote><pre>
//     * Character.toLowerCase(this.charAt(toffset+k)) !=
//     Character.toLowerCase(other.charAt(ooffset+k))
//     * </pre></blockquote>
//     * and:
//     * <blockquote><pre>
//     * Character.toUpperCase(this.charAt(toffset+k)) !=
//     *         Character.toUpperCase(other.charAt(ooffset+k))
//     * </pre></blockquote>
//     * </ul>
//     *
//     * @param   ignoreCase   if {@code true}, ignore case when comparing
//     *                       characters.
//     * @param   toffset      the starting offset of the subregion in this
//     *                       string.
//     * @param   other        the string argument.
//     * @param   ooffset      the starting offset of the subregion in the string
//     *                       argument.
//     * @param   len          the number of characters to compare.
//     * @return  {@code true} if the specified subregion of this string
//     *          matches the specified subregion of the string argument;
//     *          {@code false} otherwise. Whether the matching is exact
//     *          or case insensitive depends on the {@code ignoreCase}
//     *          argument.
//     */
//    public boolean regionMatches(boolean ignoreCase, int toffset,
//                                 String other, int ooffset, int len) {
//        char ta[] = value;
//        int to = toffset;
//        char pa[] = other.value;
//        int po = ooffset;
//        // Note: toffset, ooffset, or len might be near -1>>>1.
//        if ((ooffset < 0) || (toffset < 0)
//                || (toffset > (long)value.length - len)
//                || (ooffset > (long)other.value.length - len)) {
//            return false;
//        }
//        while (len-- > 0) {
//            char c1 = ta[to++];
//            char c2 = pa[po++];
//            if (c1 == c2) {
//                continue;
//            }
//            if (ignoreCase) {
//                // If characters don't match but case may be ignored,
//                // try converting both characters to uppercase.
//                // If the results match, then the comparison scan should
//                // continue.
//                char u1 = Character.toUpperCase(c1);
//                char u2 = Character.toUpperCase(c2);
//                if (u1 == u2) {
//                    continue;
//                }
//                // Unfortunately, conversion to uppercase does not work properly
//                // for the Georgian alphabet, which has strange rules about case
//                // conversion.  So we need to make one last check before
//                // exiting.
//                if (Character.toLowerCase(u1) == Character.toLowerCase(u2)) {
//                    continue;
//                }
//            }
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Tests if the substring of this string beginning at the
//     * specified index starts with the specified prefix.
//     *
//     * @param   prefix    the prefix.
//     * @param   toffset   where to begin looking in this string.
//     * @return  {@code true} if the character sequence represented by the
//     *          argument is a prefix of the substring of this object starting
//     *          at index {@code toffset}; {@code false} otherwise.
//     *          The result is {@code false} if {@code toffset} is
//     *          negative or greater than the length of this
//     *          {@code String} object; otherwise the result is the same
//     *          as the result of the expression
//     *          <pre>
//     *          this.substring(toffset).startsWith(prefix)
//     *          </pre>
//     */
//    public boolean startsWith(String prefix, int toffset) {
//        char ta[] = value;
//        int to = toffset;
//        char pa[] = prefix.value;
//        int po = 0;
//        int pc = prefix.value.length;
//        // Note: toffset might be near -1>>>1.
//        if ((toffset < 0) || (toffset > value.length - pc)) {
//            return false;
//        }
//        while (--pc >= 0) {
//            if (ta[to++] != pa[po++]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Tests if this string starts with the specified prefix.
//     *
//     * @param   prefix   the prefix.
//     * @return  {@code true} if the character sequence represented by the
//     *          argument is a prefix of the character sequence represented by
//     *          this string; {@code false} otherwise.
//     *          Note also that {@code true} will be returned if the
//     *          argument is an empty string or is equal to this
//     *          {@code String} object as determined by the
//     *          {@link #equals(Object)} method.
//     * @since   1. 0
//     */
//    public boolean startsWith(String prefix) {
//        return startsWith(prefix, 0);
//    }
//
//    /**
//     * Tests if this string ends with the specified suffix.
//     *
//     * @param   suffix   the suffix.
//     * @return  {@code true} if the character sequence represented by the
//     *          argument is a suffix of the character sequence represented by
//     *          this object; {@code false} otherwise. Note that the
//     *          result will be {@code true} if the argument is the
//     *          empty string or is equal to this {@code String} object
//     *          as determined by the {@link #equals(Object)} method.
//     */
//    public boolean endsWith(String suffix) {
//        return startsWith(suffix, value.length - suffix.value.length);
//    }
//
//    /**
//     * Returns a hash code for this string. The hash code for a
//     * {@code String} object is computed as
//     * <blockquote><pre>
//     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
//     * </pre></blockquote>
//     * using {@code int} arithmetic, where {@code s[i]} is the
//     * <i>i</i>th character of the string, {@code n} is the length of
//     * the string, and {@code ^} indicates exponentiation.
//     * (The hash value of the empty string is zero.)
//     *
//     * @return  a hash code value for this object.
//     */
//    public int hashCode() {
//        int h = hash;
//        if (h == 0 && value.length > 0) {
//            char val[] = value;
//
//            for (int i = 0; i < value.length; i++) {
//                h = 31 * h + val[i];
//            }
//            hash = h;
//        }
//        return h;
//    }
//
//    /**
//     * Returns the index within this string of the first occurrence of
//     * the specified character. If a character with value
//     * {@code ch} occurs in the character sequence represented by
//     * this {@code String} object, then the index (in Unicode
//     * code units) of the first such occurrence is returned. For
//     * values of {@code ch} in the range from 0 to 0xFFFF
//     * (inclusive), this is the smallest value <i>k</i> such that:
//     * <blockquote><pre>
//     * this.charAt(<i>k</i>) == ch
//     * </pre></blockquote>
//     * is true. For other values of {@code ch}, it is the
//     * smallest value <i>k</i> such that:
//     * <blockquote><pre>
//     * this.codePointAt(<i>k</i>) == ch
//     * </pre></blockquote>
//     * is true. In either case, if no such character occurs in this
//     * string, then {@code -1} is returned.
//     *
//     * @param   ch   a character (Unicode code point).
//     * @return  the index of the first occurrence of the character in the
//     *          character sequence represented by this object, or
//     *          {@code -1} if the character does not occur.
//     */
//    public int indexOf(int ch) {
//        return indexOf(ch, 0);
//    }
//
//    /**
//     * Returns the index within this string of the first occurrence of the
//     * specified character, starting the search at the specified index.
//     * <p>
//     * If a character with value {@code ch} occurs in the
//     * character sequence represented by this {@code String}
//     * object at an index no smaller than {@code fromIndex}, then
//     * the index of the first such occurrence is returned. For values
//     * of {@code ch} in the range from 0 to 0xFFFF (inclusive),
//     * this is the smallest value <i>k</i> such that:
//     * <blockquote><pre>
//     * (this.charAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
//     * </pre></blockquote>
//     * is true. For other values of {@code ch}, it is the
//     * smallest value <i>k</i> such that:
//     * <blockquote><pre>
//     * (this.codePointAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
//     * </pre></blockquote>
//     * is true. In either case, if no such character occurs in this
//     * string at or after position {@code fromIndex}, then
//     * {@code -1} is returned.
//     *
//     * <p>
//     * There is no restriction on the value of {@code fromIndex}. If it
//     * is negative, it has the same effect as if it were zero: this entire
//     * string may be searched. If it is greater than the length of this
//     * string, it has the same effect as if it were equal to the length of
//     * this string: {@code -1} is returned.
//     *
//     * <p>All indices are specified in {@code char} values
//     * (Unicode code units).
//     *
//     * @param   ch          a character (Unicode code point).
//     * @param   fromIndex   the index to start the search from.
//     * @return  the index of the first occurrence of the character in the
//     *          character sequence represented by this object that is greater
//     *          than or equal to {@code fromIndex}, or {@code -1}
//     *          if the character does not occur.
//     */
//    public int indexOf(int ch, int fromIndex) {
//        final int max = value.length;
//        if (fromIndex < 0) {
//            fromIndex = 0;
//        } else if (fromIndex >= max) {
//            // Note: fromIndex might be near -1>>>1.
//            return -1;
//        }
//
//        if (ch < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
//            // handle most cases here (ch is a BMP code point or a
//            // negative value (invalid code point))
//            final char[] value = this.value;
//            for (int i = fromIndex; i < max; i++) {
//                if (value[i] == ch) {
//                    return i;
//                }
//            }
//            return -1;
//        } else {
//            return indexOfSupplementary(ch, fromIndex);
//        }
//    }
//
//    /**
//     * Handles (rare) calls of indexOf with a supplementary character.
//     */
//    private int indexOfSupplementary(int ch, int fromIndex) {
//        if (Character.isValidCodePoint(ch)) {
//            final char[] value = this.value;
//            final char hi = Character.highSurrogate(ch);
//            final char lo = Character.lowSurrogate(ch);
//            final int max = value.length - 1;
//            for (int i = fromIndex; i < max; i++) {
//                if (value[i] == hi && value[i + 1] == lo) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Returns the index within this string of the last occurrence of
//     * the specified character. For values of {@code ch} in the
//     * range from 0 to 0xFFFF (inclusive), the index (in Unicode code
//     * units) returned is the largest value <i>k</i> such that:
//     * <blockquote><pre>
//     * this.charAt(<i>k</i>) == ch
//     * </pre></blockquote>
//     * is true. For other values of {@code ch}, it is the
//     * largest value <i>k</i> such that:
//     * <blockquote><pre>
//     * this.codePointAt(<i>k</i>) == ch
//     * </pre></blockquote>
//     * is true.  In either case, if no such character occurs in this
//     * string, then {@code -1} is returned.  The
//     * {@code String} is searched backwards starting at the last
//     * character.
//     *
//     * @param   ch   a character (Unicode code point).
//     * @return  the index of the last occurrence of the character in the
//     *          character sequence represented by this object, or
//     *          {@code -1} if the character does not occur.
//     */
//    public int lastIndexOf(int ch) {
//        return lastIndexOf(ch, value.length - 1);
//    }
//
//    /**
//     * Returns the index within this string of the last occurrence of
//     * the specified character, searching backward starting at the
//     * specified index. For values of {@code ch} in the range
//     * from 0 to 0xFFFF (inclusive), the index returned is the largest
//     * value <i>k</i> such that:
//     * <blockquote><pre>
//     * (this.charAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &lt;= fromIndex)
//     * </pre></blockquote>
//     * is true. For other values of {@code ch}, it is the
//     * largest value <i>k</i> such that:
//     * <blockquote><pre>
//     * (this.codePointAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &lt;= fromIndex)
//     * </pre></blockquote>
//     * is true. In either case, if no such character occurs in this
//     * string at or before position {@code fromIndex}, then
//     * {@code -1} is returned.
//     *
//     * <p>All indices are specified in {@code char} values
//     * (Unicode code units).
//     *
//     * @param   ch          a character (Unicode code point).
//     * @param   fromIndex   the index to start the search from. There is no
//     *          restriction on the value of {@code fromIndex}. If it is
//     *          greater than or equal to the length of this string, it has
//     *          the same effect as if it were equal to one less than the
//     *          length of this string: this entire string may be searched.
//     *          If it is negative, it has the same effect as if it were -1:
//     *          -1 is returned.
//     * @return  the index of the last occurrence of the character in the
//     *          character sequence represented by this object that is less
//     *          than or equal to {@code fromIndex}, or {@code -1}
//     *          if the character does not occur before that point.
//     */
//    public int lastIndexOf(int ch, int fromIndex) {
//        if (ch < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
//            // handle most cases here (ch is a BMP code point or a
//            // negative value (invalid code point))
//            final char[] value = this.value;
//            int i = Math.min(fromIndex, value.length - 1);
//            for (; i >= 0; i--) {
//                if (value[i] == ch) {
//                    return i;
//                }
//            }
//            return -1;
//        } else {
//            return lastIndexOfSupplementary(ch, fromIndex);
//        }
//    }
//
//    /**
//     * Handles (rare) calls of lastIndexOf with a supplementary character.
//     */
//    private int lastIndexOfSupplementary(int ch, int fromIndex) {
//        if (Character.isValidCodePoint(ch)) {
//            final char[] value = this.value;
//            char hi = Character.highSurrogate(ch);
//            char lo = Character.lowSurrogate(ch);
//            int i = Math.min(fromIndex, value.length - 2);
//            for (; i >= 0; i--) {
//                if (value[i] == hi && value[i + 1] == lo) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Returns the index within this string of the first occurrence of the
//     * specified substring.
//     *
//     * <p>The returned index is the smallest value <i>k</i> for which:
//     * <blockquote><pre>
//     * this.startsWith(str, <i>k</i>)
//     * </pre></blockquote>
//     * If no such value of <i>k</i> exists, then {@code -1} is returned.
//     *
//     * @param   str   the substring to search for.
//     * @return  the index of the first occurrence of the specified substring,
//     *          or {@code -1} if there is no such occurrence.
//     */
//    public int indexOf(String str) {
//        return indexOf(str, 0);
//    }
//
//    /**
//     * Returns the index within this string of the first occurrence of the
//     * specified substring, starting at the specified index.
//     *
//     * <p>The returned index is the smallest value <i>k</i> for which:
//     * <blockquote><pre>
//     * <i>k</i> &gt;= fromIndex {@code &&} this.startsWith(str, <i>k</i>)
//     * </pre></blockquote>
//     * If no such value of <i>k</i> exists, then {@code -1} is returned.
//     *
//     * @param   str         the substring to search for.
//     * @param   fromIndex   the index from which to start the search.
//     * @return  the index of the first occurrence of the specified substring,
//     *          starting at the specified index,
//     *          or {@code -1} if there is no such occurrence.
//     */
//    public int indexOf(String str, int fromIndex) {
//        return indexOf(value, 0, value.length,
//                str.value, 0, str.value.length, fromIndex);
//    }
//
//    /**
//     * Code shared by String and AbstractStringBuilder to do searches. The
//     * source is the character array being searched, and the target
//     * is the string being searched for.
//     *
//     * @param   source       the characters being searched.
//     * @param   sourceOffset offset of the source string.
//     * @param   sourceCount  count of the source string.
//     * @param   target       the characters being searched for.
//     * @param   fromIndex    the index to begin searching from.
//     */
//    static int indexOf(char[] source, int sourceOffset, int sourceCount,
//                       String target, int fromIndex) {
//        return indexOf(source, sourceOffset, sourceCount,
//                target.value, 0, target.value.length,
//                fromIndex);
//    }
//
//    /**
//     * Code shared by String and StringBuffer to do searches. The
//     * source is the character array being searched, and the target
//     * is the string being searched for.
//     *
//     * @param   source       the characters being searched.
//     * @param   sourceOffset offset of the source string.
//     * @param   sourceCount  count of the source string.
//     * @param   target       the characters being searched for.
//     * @param   targetOffset offset of the target string.
//     * @param   targetCount  count of the target string.
//     * @param   fromIndex    the index to begin searching from.
//     */
//    static int indexOf(char[] source, int sourceOffset, int sourceCount,
//                       char[] target, int targetOffset, int targetCount,
//                       int fromIndex) {
//        if (fromIndex >= sourceCount) {
//            return (targetCount == 0 ? sourceCount : -1);
//        }
//        if (fromIndex < 0) {
//            fromIndex = 0;
//        }
//        if (targetCount == 0) {
//            return fromIndex;
//        }
//
//        char first = target[targetOffset];
//        int max = sourceOffset + (sourceCount - targetCount);
//
//        for (int i = sourceOffset + fromIndex; i <= max; i++) {
//            /* Look for first character. */
//            if (source[i] != first) {
//                while (++i <= max && source[i] != first);
//            }
//
//            /* Found first character, now look at the rest of v2 */
//            if (i <= max) {
//                int j = i + 1;
//                int end = j + targetCount - 1;
//                for (int k = targetOffset + 1; j < end && source[j]
//                        == target[k]; j++, k++);
//
//                if (j == end) {
//                    /* Found whole string. */
//                    return i - sourceOffset;
//                }
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Returns the index within this string of the last occurrence of the
//     * specified substring.  The last occurrence of the empty string ""
//     * is considered to occur at the index value {@code this.length()}.
//     *
//     * <p>The returned index is the largest value <i>k</i> for which:
//     * <blockquote><pre>
//     * this.startsWith(str, <i>k</i>)
//     * </pre></blockquote>
//     * If no such value of <i>k</i> exists, then {@code -1} is returned.
//     *
//     * @param   str   the substring to search for.
//     * @return  the index of the last occurrence of the specified substring,
//     *          or {@code -1} if there is no such occurrence.
//     */
//    public int lastIndexOf(String str) {
//        return lastIndexOf(str, value.length);
//    }
//
//    /**
//     * Returns the index within this string of the last occurrence of the
//     * specified substring, searching backward starting at the specified index.
//     *
//     * <p>The returned index is the largest value <i>k</i> for which:
//     * <blockquote><pre>
//     * <i>k</i> {@code <=} fromIndex {@code &&} this.startsWith(str, <i>k</i>)
//     * </pre></blockquote>
//     * If no such value of <i>k</i> exists, then {@code -1} is returned.
//     *
//     * @param   str         the substring to search for.
//     * @param   fromIndex   the index to start the search from.
//     * @return  the index of the last occurrence of the specified substring,
//     *          searching backward from the specified index,
//     *          or {@code -1} if there is no such occurrence.
//     */
//    public int lastIndexOf(String str, int fromIndex) {
//        return lastIndexOf(value, 0, value.length,
//                str.value, 0, str.value.length, fromIndex);
//    }
//
//    /**
//     * Code shared by String and AbstractStringBuilder to do searches. The
//     * source is the character array being searched, and the target
//     * is the string being searched for.
//     *
//     * @param   source       the characters being searched.
//     * @param   sourceOffset offset of the source string.
//     * @param   sourceCount  count of the source string.
//     * @param   target       the characters being searched for.
//     * @param   fromIndex    the index to begin searching from.
//     */
//    static int lastIndexOf(char[] source, int sourceOffset, int sourceCount,
//                           String target, int fromIndex) {
//        return lastIndexOf(source, sourceOffset, sourceCount,
//                target.value, 0, target.value.length,
//                fromIndex);
//    }
//
//    /**
//     * Code shared by String and StringBuffer to do searches. The
//     * source is the character array being searched, and the target
//     * is the string being searched for.
//     *
//     * @param   source       the characters being searched.
//     * @param   sourceOffset offset of the source string.
//     * @param   sourceCount  count of the source string.
//     * @param   target       the characters being searched for.
//     * @param   targetOffset offset of the target string.
//     * @param   targetCount  count of the target string.
//     * @param   fromIndex    the index to begin searching from.
//     */
//    static int lastIndexOf(char[] source, int sourceOffset, int sourceCount,
//                           char[] target, int targetOffset, int targetCount,
//                           int fromIndex) {
//        /*
//         * Check arguments; return immediately where possible. For
//         * consistency, don't check for null str.
//         */
//        int rightIndex = sourceCount - targetCount;
//        if (fromIndex < 0) {
//            return -1;
//        }
//        if (fromIndex > rightIndex) {
//            fromIndex = rightIndex;
//        }
//        /* Empty string always matches. */
//        if (targetCount == 0) {
//            return fromIndex;
//        }
//
//        int strLastIndex = targetOffset + targetCount - 1;
//        char strLastChar = target[strLastIndex];
//        int min = sourceOffset + targetCount - 1;
//        int i = min + fromIndex;
//
//        startSearchForLastChar:
//        while (true) {
//            while (i >= min && source[i] != strLastChar) {
//                i--;
//            }
//            if (i < min) {
//                return -1;
//            }
//            int j = i - 1;
//            int start = j - (targetCount - 1);
//            int k = strLastIndex - 1;
//
//            while (j > start) {
//                if (source[j--] != target[k--]) {
//                    i--;
//                    continue startSearchForLastChar;
//                }
//            }
//            return start - sourceOffset + 1;
//        }
//    }
//
//    /**
//     * Returns a string that is a substring of this string. The
//     * substring begins with the character at the specified index and
//     * extends to the end of this string. <p>
//     * Examples:
//     * <blockquote><pre>
//     * "unhappy".substring(2) returns "happy"
//     * "Harbison".substring(3) returns "bison"
//     * "emptiness".substring(9) returns "" (an empty string)
//     * </pre></blockquote>
//     *
//     * @param      beginIndex   the beginning index, inclusive.
//     * @return     the specified substring.
//     * @exception  IndexOutOfBoundsException  if
//     *             {@code beginIndex} is negative or larger than the
//     *             length of this {@code String} object.
//     */
//    public String substring(int beginIndex) {
//        if (beginIndex < 0) {
//            throw new StringIndexOutOfBoundsException(beginIndex);
//        }
//        int subLen = value.length - beginIndex;
//        if (subLen < 0) {
//            throw new StringIndexOutOfBoundsException(subLen);
//        }
//        return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
//    }
//
//    /**
//     * Returns a string that is a substring of this string. The
//     * substring begins at the specified {@code beginIndex} and
//     * extends to the character at index {@code endIndex - 1}.
//     * Thus the length of the substring is {@code endIndex-beginIndex}.
//     * <p>
//     * Examples:
//     * <blockquote><pre>
//     * "hamburger".substring(4, 8) returns "urge"
//     * "smiles".substring(1, 5) returns "mile"
//     * </pre></blockquote>
//     *
//     * @param      beginIndex   the beginning index, inclusive.
//     * @param      endIndex     the ending index, exclusive.
//     * @return     the specified substring.
//     * @exception  IndexOutOfBoundsException  if the
//     *             {@code beginIndex} is negative, or
//     *             {@code endIndex} is larger than the length of
//     *             this {@code String} object, or
//     *             {@code beginIndex} is larger than
//     *             {@code endIndex}.
//     */
//    public String substring(int beginIndex, int endIndex) {
//        if (beginIndex < 0) {
//            throw new StringIndexOutOfBoundsException(beginIndex);
//        }
//        if (endIndex > value.length) {
//            throw new StringIndexOutOfBoundsException(endIndex);
//        }
//        int subLen = endIndex - beginIndex;
//        if (subLen < 0) {
//            throw new StringIndexOutOfBoundsException(subLen);
//        }
//        return ((beginIndex == 0) && (endIndex == value.length)) ? this
//                : new String(value, beginIndex, subLen);
//    }
//
//    /**
//     * Returns a character sequence that is a subsequence of this sequence.
//     *
//     * <p> An invocation of this method of the form
//     *
//     * <blockquote><pre>
//     * str.subSequence(begin,&nbsp;end)</pre></blockquote>
//     *
//     * behaves in exactly the same way as the invocation
//     *
//     * <blockquote><pre>
//     * str.substring(begin,&nbsp;end)</pre></blockquote>
//     *
//     * @apiNote
//     * This method is defined so that the {@code String} class can implement
//     * the {@link java.lang.CharSequence} interface.
//     *
//     * @param   beginIndex   the begin index, inclusive.
//     * @param   endIndex     the end index, exclusive.
//     * @return  the specified subsequence.
//     *
//     * @throws  IndexOutOfBoundsException
//     *          if {@code beginIndex} or {@code endIndex} is negative,
//     *          if {@code endIndex} is greater than {@code length()},
//     *          or if {@code beginIndex} is greater than {@code endIndex}
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public java.lang.CharSequence subSequence(int beginIndex, int endIndex) {
//        return this.substring(beginIndex, endIndex);
//    }
//
//    /**
//     * Concatenates the specified string to the end of this string.
//     * <p>
//     * If the length of the argument string is {@code 0}, then this
//     * {@code String} object is returned. Otherwise, a
//     * {@code String} object is returned that represents a character
//     * sequence that is the concatenation of the character sequence
//     * represented by this {@code String} object and the character
//     * sequence represented by the argument string.<p>
//     * Examples:
//     * <blockquote><pre>
//     * "cares".concat("s") returns "caress"
//     * "to".concat("get").concat("her") returns "together"
//     * </pre></blockquote>
//     *
//     * @param   str   the {@code String} that is concatenated to the end
//     *                of this {@code String}.
//     * @return  a string that represents the concatenation of this object's
//     *          characters followed by the string argument's characters.
//     */
//    public String concat(String str) {
//        int otherLen = str.length();
//        if (otherLen == 0) {
//            return this;
//        }
//        int len = value.length;
//        char buf[] = Arrays.copyOf(value, len + otherLen);
//        str.getChars(buf, len);
//        return new String(buf, true);
//    }
//
//    /**
//     * Returns a string resulting from replacing all occurrences of
//     * {@code oldChar} in this string with {@code newChar}.
//     * <p>
//     * If the character {@code oldChar} does not occur in the
//     * character sequence represented by this {@code String} object,
//     * then a reference to this {@code String} object is returned.
//     * Otherwise, a {@code String} object is returned that
//     * represents a character sequence identical to the character sequence
//     * represented by this {@code String} object, except that every
//     * occurrence of {@code oldChar} is replaced by an occurrence
//     * of {@code newChar}.
//     * <p>
//     * Examples:
//     * <blockquote><pre>
//     * "mesquite in your cellar".replace('e', 'o')
//     *         returns "mosquito in your collar"
//     * "the war of baronets".replace('r', 'y')
//     *         returns "the way of bayonets"
//     * "sparring with a purple porpoise".replace('p', 't')
//     *         returns "starring with a turtle tortoise"
//     * "JonL".replace('q', 'x') returns "JonL" (no change)
//     * </pre></blockquote>
//     *
//     * @param   oldChar   the old character.
//     * @param   newChar   the new character.
//     * @return  a string derived from this string by replacing every
//     *          occurrence of {@code oldChar} with {@code newChar}.
//     */
//    public String replace(char oldChar, char newChar) {
//        if (oldChar != newChar) {
//            int len = value.length;
//            int i = -1;
//            char[] val = value; /* avoid getfield opcode */
//
//            while (++i < len) {
//                if (val[i] == oldChar) {
//                    break;
//                }
//            }
//            if (i < len) {
//                char buf[] = new char[len];
//                for (int j = 0; j < i; j++) {
//                    buf[j] = val[j];
//                }
//                while (i < len) {
//                    char c = val[i];
//                    buf[i] = (c == oldChar) ? newChar : c;
//                    i++;
//                }
//                return new String(buf, true);
//            }
//        }
//        return this;
//    }
//
//    /**
//     * Tells whether or not this string matches the given <a
//     * href="../util/regex/Pattern.html#sum">regular expression</a>.
//     *
//     * <p> An invocation of this method of the form
//     * <i>str</i>{@code .matches(}<i>regex</i>{@code )} yields exactly the
//     * same result as the expression
//     *
//     * <blockquote>
//     * {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#matches(String, java.lang.CharSequence)
//     * matches(<i>regex</i>, <i>str</i>)}
//     * </blockquote>
//     *
//     * @param   regex
//     *          the regular expression to which this string is to be matched
//     *
//     * @return  {@code true} if, and only if, this string matches the
//     *          given regular expression
//     *
//     * @throws  PatternSyntaxException
//     *          if the regular expression's syntax is invalid
//     *
//     * @see java.util.regex.Pattern
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public boolean matches(String regex) {
//        return Pattern.matches(regex, this);
//    }
//
//    /**
//     * Returns true if and only if this string contains the specified
//     * sequence of char values.
//     *
//     * @param s the sequence to search for
//     * @return true if this string contains {@code s}, false otherwise
//     * @since 1.5
//     */
//    public boolean contains(java.lang.CharSequence s) {
//        return indexOf(s.toString()) > -1;
//    }
//
//    /**
//     * Replaces the first substring of this string that matches the given <a
//     * href="../util/regex/Pattern.html#sum">regular expression</a> with the
//     * given replacement.
//     *
//     * <p> An invocation of this method of the form
//     * <i>str</i>{@code .replaceFirst(}<i>regex</i>{@code ,} <i>repl</i>{@code )}
//     * yields exactly the same result as the expression
//     *
//     * <blockquote>
//     * <code>
//     * {@link java.util.regex.Pattern}.{@link
//     * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
//     * java.util.regex.Pattern#matcher(java.lang.CharSequence) matcher}(<i>str</i>).{@link
//     * java.util.regex.Matcher#replaceFirst replaceFirst}(<i>repl</i>)
//     * </code>
//     * </blockquote>
//     *
//     *<p>
//     * Note that backslashes ({@code \}) and dollar signs ({@code $}) in the
//     * replacement string may cause the results to be different than if it were
//     * being treated as a literal replacement string; see
//     * {@link java.util.regex.Matcher#replaceFirst}.
//     * Use {@link java.util.regex.Matcher#quoteReplacement} to suppress the special
//     * meaning of these characters, if desired.
//     *
//     * @param   regex
//     *          the regular expression to which this string is to be matched
//     * @param   replacement
//     *          the string to be substituted for the first match
//     *
//     * @return  The resulting {@code String}
//     *
//     * @throws  PatternSyntaxException
//     *          if the regular expression's syntax is invalid
//     *
//     * @see java.util.regex.Pattern
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public String replaceFirst(String regex, String replacement) {
//        return Pattern.compile(regex).matcher(this).replaceFirst(replacement);
//    }
//
//    /**
//     * Replaces each substring of this string that matches the given <a
//     * href="../util/regex/Pattern.html#sum">regular expression</a> with the
//     * given replacement.
//     *
//     * <p> An invocation of this method of the form
//     * <i>str</i>{@code .replaceAll(}<i>regex</i>{@code ,} <i>repl</i>{@code )}
//     * yields exactly the same result as the expression
//     *
//     * <blockquote>
//     * <code>
//     * {@link java.util.regex.Pattern}.{@link
//     * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
//     * java.util.regex.Pattern#matcher(java.lang.CharSequence) matcher}(<i>str</i>).{@link
//     * java.util.regex.Matcher#replaceAll replaceAll}(<i>repl</i>)
//     * </code>
//     * </blockquote>
//     *
//     *<p>
//     * Note that backslashes ({@code \}) and dollar signs ({@code $}) in the
//     * replacement string may cause the results to be different than if it were
//     * being treated as a literal replacement string; see
//     * {@link java.util.regex.Matcher#replaceAll Matcher.replaceAll}.
//     * Use {@link java.util.regex.Matcher#quoteReplacement} to suppress the special
//     * meaning of these characters, if desired.
//     *
//     * @param   regex
//     *          the regular expression to which this string is to be matched
//     * @param   replacement
//     *          the string to be substituted for each match
//     *
//     * @return  The resulting {@code String}
//     *
//     * @throws  PatternSyntaxException
//     *          if the regular expression's syntax is invalid
//     *
//     * @see java.util.regex.Pattern
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public String replaceAll(String regex, String replacement) {
//        return Pattern.compile(regex).matcher(this).replaceAll(replacement);
//    }
//
//    /**
//     * Replaces each substring of this string that matches the literal target
//     * sequence with the specified literal replacement sequence. The
//     * replacement proceeds from the beginning of the string to the end, for
//     * example, replacing "aa" with "b" in the string "aaa" will result in
//     * "ba" rather than "ab".
//     *
//     * @param  target The sequence of char values to be replaced
//     * @param  replacement The replacement sequence of char values
//     * @return  The resulting string
//     * @since 1.5
//     */
//    public String replace(java.lang.CharSequence target, java.lang.CharSequence replacement) {
//        return Pattern.compile(target.toString(), Pattern.LITERAL).matcher(
//                this).replaceAll(Matcher.quoteReplacement(replacement.toString()));
//    }
//
//    /**
//     * Splits this string around matches of the given
//     * <a href="../util/regex/Pattern.html#sum">regular expression</a>.
//     *
//     * <p> The array returned by this method contains each substring of this
//     * string that is terminated by another substring that matches the given
//     * expression or is terminated by the end of the string.  The substrings in
//     * the array are in the order in which they occur in this string.  If the
//     * expression does not match any part of the input then the resulting array
//     * has just one element, namely this string.
//     *
//     * <p> When there is a positive-width match at the beginning of this
//     * string then an empty leading substring is included at the beginning
//     * of the resulting array. A zero-width match at the beginning however
//     * never produces such empty leading substring.
//     *
//     * <p> The {@code limit} parameter controls the number of times the
//     * pattern is applied and therefore affects the length of the resulting
//     * array.  If the limit <i>n</i> is greater than zero then the pattern
//     * will be applied at most <i>n</i>&nbsp;-&nbsp;1 times, the array's
//     * length will be no greater than <i>n</i>, and the array's last entry
//     * will contain all input beyond the last matched delimiter.  If <i>n</i>
//     * is non-positive then the pattern will be applied as many times as
//     * possible and the array can have any length.  If <i>n</i> is zero then
//     * the pattern will be applied as many times as possible, the array can
//     * have any length, and trailing empty strings will be discarded.
//     *
//     * <p> The string {@code "boo:and:foo"}, for example, yields the
//     * following results with these parameters:
//     *
//     * <blockquote><table cellpadding=1 cellspacing=0 summary="Split example showing regex, limit, and result">
//     * <tr>
//     *     <th>Regex</th>
//     *     <th>Limit</th>
//     *     <th>Result</th>
//     * </tr>
//     * <tr><td align=center>:</td>
//     *     <td align=center>2</td>
//     *     <td>{@code { "boo", "and:foo" }}</td></tr>
//     * <tr><td align=center>:</td>
//     *     <td align=center>5</td>
//     *     <td>{@code { "boo", "and", "foo" }}</td></tr>
//     * <tr><td align=center>:</td>
//     *     <td align=center>-2</td>
//     *     <td>{@code { "boo", "and", "foo" }}</td></tr>
//     * <tr><td align=center>o</td>
//     *     <td align=center>5</td>
//     *     <td>{@code { "b", "", ":and:f", "", "" }}</td></tr>
//     * <tr><td align=center>o</td>
//     *     <td align=center>-2</td>
//     *     <td>{@code { "b", "", ":and:f", "", "" }}</td></tr>
//     * <tr><td align=center>o</td>
//     *     <td align=center>0</td>
//     *     <td>{@code { "b", "", ":and:f" }}</td></tr>
//     * </table></blockquote>
//     *
//     * <p> An invocation of this method of the form
//     * <i>str.</i>{@code split(}<i>regex</i>{@code ,}&nbsp;<i>n</i>{@code )}
//     * yields the same result as the expression
//     *
//     * <blockquote>
//     * <code>
//     * {@link java.util.regex.Pattern}.{@link
//     * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
//     * java.util.regex.Pattern#split(java.lang.CharSequence,int) split}(<i>str</i>,&nbsp;<i>n</i>)
//     * </code>
//     * </blockquote>
//     *
//     *
//     * @param  regex
//     *         the delimiting regular expression
//     *
//     * @param  limit
//     *         the result threshold, as described above
//     *
//     * @return  the array of strings computed by splitting this string
//     *          around matches of the given regular expression
//     *
//     * @throws  PatternSyntaxException
//     *          if the regular expression's syntax is invalid
//     *
//     * @see java.util.regex.Pattern
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public String[] split(String regex, int limit) {
//        /* fastpath if the regex is a
//         (1)one-char String and this character is not one of the
//            RegEx's meta characters ".$|()[{^?*+\\", or
//         (2)two-char String and the first char is the backslash and
//            the second is not the ascii digit or ascii letter.
//         */
//        char ch = 0;
//        if (((regex.value.length == 1 &&
//                ".$|()[{^?*+\\".indexOf(ch = regex.charAt(0)) == -1) ||
//                (regex.length() == 2 &&
//                        regex.charAt(0) == '\\' &&
//                        (((ch = regex.charAt(1))-'0')|('9'-ch)) < 0 &&
//                        ((ch-'a')|('z'-ch)) < 0 &&
//                        ((ch-'A')|('Z'-ch)) < 0)) &&
//                (ch < Character.MIN_HIGH_SURROGATE ||
//                        ch > Character.MAX_LOW_SURROGATE))
//        {
//            int off = 0;
//            int next = 0;
//            boolean limited = limit > 0;
//            ArrayList<String> list = new ArrayList<>();
//            while ((next = indexOf(ch, off)) != -1) {
//                if (!limited || list.size() < limit - 1) {
//                    list.add(substring(off, next));
//                    off = next + 1;
//                } else {    // last one
//                    //assert (list.size() == limit - 1);
//                    list.add(substring(off, value.length));
//                    off = value.length;
//                    break;
//                }
//            }
//            // If no match was found, return this
//            if (off == 0)
//                return new String[]{this};
//
//            // Add remaining segment
//            if (!limited || list.size() < limit)
//                list.add(substring(off, value.length));
//
//            // Construct result
//            int resultSize = list.size();
//            if (limit == 0) {
//                while (resultSize > 0 && list.get(resultSize - 1).length() == 0) {
//                    resultSize--;
//                }
//            }
//            String[] result = new String[resultSize];
//            return list.subList(0, resultSize).toArray(result);
//        }
//        return Pattern.compile(regex).split(this, limit);
//    }
//
//    /**
//     * Splits this string around matches of the given <a
//     * href="../util/regex/Pattern.html#sum">regular expression</a>.
//     *
//     * <p> This method works as if by invoking the two-argument {@link
//     * #split(String, int) split} method with the given expression and a limit
//     * argument of zero.  Trailing empty strings are therefore not included in
//     * the resulting array.
//     *
//     * <p> The string {@code "boo:and:foo"}, for example, yields the following
//     * results with these expressions:
//     *
//     * <blockquote><table cellpadding=1 cellspacing=0 summary="Split examples showing regex and result">
//     * <tr>
//     *  <th>Regex</th>
//     *  <th>Result</th>
//     * </tr>
//     * <tr><td align=center>:</td>
//     *     <td>{@code { "boo", "and", "foo" }}</td></tr>
//     * <tr><td align=center>o</td>
//     *     <td>{@code { "b", "", ":and:f" }}</td></tr>
//     * </table></blockquote>
//     *
//     *
//     * @param  regex
//     *         the delimiting regular expression
//     *
//     * @return  the array of strings computed by splitting this string
//     *          around matches of the given regular expression
//     *
//     * @throws  PatternSyntaxException
//     *          if the regular expression's syntax is invalid
//     *
//     * @see java.util.regex.Pattern
//     *
//     * @since 1.4
//     * @spec JSR-51
//     */
//    public String[] split(String regex) {
//        return split(regex, 0);
//    }
//
//    /**
//     * Returns a new String composed of copies of the
//     * {@code CharSequence elements} joined together with a copy of
//     * the specified {@code delimiter}.
//     *
//     * <blockquote>For example,
//     * <pre>{@code
//     *     String message = String.join("-", "Java", "is", "cool");
//     *     // message returned is: "Java-is-cool"
//     * }</pre></blockquote>
//     *
//     * Note that if an element is null, then {@code "null"} is added.
//     *
//     * @param  delimiter the delimiter that separates each element
//     * @param  elements the elements to join together.
//     *
//     * @return a new {@code String} that is composed of the {@code elements}
//     *         separated by the {@code delimiter}
//     *
//     * @throws NullPointerException If {@code delimiter} or {@code elements}
//     *         is {@code null}
//     *
//     * @see java.util.StringJoiner
//     * @since 1.8
//     */
//    public static String join(java.lang.CharSequence delimiter, java.lang.CharSequence... elements) {
//        Objects.requireNonNull(delimiter);
//        Objects.requireNonNull(elements);
//        // Number of elements not likely worth Arrays.stream overhead.
//        StringJoiner joiner = new StringJoiner(delimiter);
//        for (java.lang.CharSequence cs: elements) {
//            joiner.add(cs);
//        }
//        return joiner.toString();
//    }
//
//    /**
//     * Returns a new {@code String} composed of copies of the
//     * {@code CharSequence elements} joined together with a copy of the
//     * specified {@code delimiter}.
//     *
//     * <blockquote>For example,
//     * <pre>{@code
//     *     List<String> strings = new LinkedList<>();
//     *     strings.add("Java");strings.add("is");
//     *     strings.add("cool");
//     *     String message = String.join(" ", strings);
//     *     //message returned is: "Java is cool"
//     *
//     *     Set<String> strings = new LinkedHashSet<>();
//     *     strings.add("Java"); strings.add("is");
//     *     strings.add("very"); strings.add("cool");
//     *     String message = String.join("-", strings);
//     *     //message returned is: "Java-is-very-cool"
//     * }</pre></blockquote>
//     *
//     * Note that if an individual element is {@code null}, then {@code "null"} is added.
//     *
//     * @param  delimiter a sequence of characters that is used to separate each
//     *         of the {@code elements} in the resulting {@code String}
//     * @param  elements an {@code Iterable} that will have its {@code elements}
//     *         joined together.
//     *
//     * @return a new {@code String} that is composed from the {@code elements}
//     *         argument
//     *
//     * @throws NullPointerException If {@code delimiter} or {@code elements}
//     *         is {@code null}
//     *
//     * @see    #join(java.lang.CharSequence, java.lang.CharSequence...)
//     * @see    java.util.StringJoiner
//     * @since 1.8
//     */
//    public static String join(java.lang.CharSequence delimiter,
//                              Iterable<? extends java.lang.CharSequence> elements) {
//        Objects.requireNonNull(delimiter);
//        Objects.requireNonNull(elements);
//        StringJoiner joiner = new StringJoiner(delimiter);
//        for (java.lang.CharSequence cs: elements) {
//            joiner.add(cs);
//        }
//        return joiner.toString();
//    }
//
//    /**
//     * Converts all of the characters in this {@code String} to lower
//     * case using the rules of the given {@code Locale}.  Case mapping is based
//     * on the Unicode Standard version specified by the {@link java.lang.Character Character}
//     * class. Since case mappings are not always 1:1 char mappings, the resulting
//     * {@code String} may be a different length than the original {@code String}.
//     * <p>
//     * Examples of lowercase  mappings are in the following table:
//     * <table border="1" summary="Lowercase mapping examples showing language code of locale, upper case, lower case, and description">
//     * <tr>
//     *   <th>Language Code of Locale</th>
//     *   <th>Upper Case</th>
//     *   <th>Lower Case</th>
//     *   <th>Description</th>
//     * </tr>
//     * <tr>
//     *   <td>tr (Turkish)</td>
//     *   <td>&#92;u0130</td>
//     *   <td>&#92;u0069</td>
//     *   <td>capital letter I with dot above -&gt; small letter i</td>
//     * </tr>
//     * <tr>
//     *   <td>tr (Turkish)</td>
//     *   <td>&#92;u0049</td>
//     *   <td>&#92;u0131</td>
//     *   <td>capital letter I -&gt; small letter dotless i </td>
//     * </tr>
//     * <tr>
//     *   <td>(all)</td>
//     *   <td>French Fries</td>
//     *   <td>french fries</td>
//     *   <td>lowercased all chars in String</td>
//     * </tr>
//     * <tr>
//     *   <td>(all)</td>
//     *   <td><img src="doc-files/capiota.gif" alt="capiota"><img src="doc-files/capchi.gif" alt="capchi">
//     *       <img src="doc-files/captheta.gif" alt="captheta"><img src="doc-files/capupsil.gif" alt="capupsil">
//     *       <img src="doc-files/capsigma.gif" alt="capsigma"></td>
//     *   <td><img src="doc-files/iota.gif" alt="iota"><img src="doc-files/chi.gif" alt="chi">
//     *       <img src="doc-files/theta.gif" alt="theta"><img src="doc-files/upsilon.gif" alt="upsilon">
//     *       <img src="doc-files/sigma1.gif" alt="sigma"></td>
//     *   <td>lowercased all chars in String</td>
//     * </tr>
//     * </table>
//     *
//     * @param locale use the case transformation rules for this locale
//     * @return the {@code String}, converted to lowercase.
//     * @see     java.lang.String#toLowerCase()
//     * @see     java.lang.String#toUpperCase()
//     * @see     java.lang.String#toUpperCase(Locale)
//     * @since   1.1
//     */
//    public String toLowerCase(Locale locale) {
//        if (locale == null) {
//            throw new NullPointerException();
//        }
//
//        int firstUpper;
//        final int len = value.length;
//
//        /* Now check if there are any characters that need to be changed. */
//        scan: {
//            for (firstUpper = 0 ; firstUpper < len; ) {
//                char c = value[firstUpper];
//                if ((c >= Character.MIN_HIGH_SURROGATE)
//                        && (c <= Character.MAX_HIGH_SURROGATE)) {
//                    int supplChar = codePointAt(firstUpper);
//                    if (supplChar != Character.toLowerCase(supplChar)) {
//                        break scan;
//                    }
//                    firstUpper += Character.charCount(supplChar);
//                } else {
//                    if (c != Character.toLowerCase(c)) {
//                        break scan;
//                    }
//                    firstUpper++;
//                }
//            }
//            return this;
//        }
//
//        char[] result = new char[len];
//        int resultOffset = 0;  /* result may grow, so i+resultOffset
//                                * is the write location in result */
//
//        /* Just copy the first few lowerCase characters. */
//        System.arraycopy(value, 0, result, 0, firstUpper);
//
//        String lang = locale.getLanguage();
//        boolean localeDependent =
//                (lang == "tr" || lang == "az" || lang == "lt");
//        char[] lowerCharArray;
//        int lowerChar;
//        int srcChar;
//        int srcCount;
//        for (int i = firstUpper; i < len; i += srcCount) {
//            srcChar = (int)value[i];
//            if ((char)srcChar >= Character.MIN_HIGH_SURROGATE
//                    && (char)srcChar <= Character.MAX_HIGH_SURROGATE) {
//                srcChar = codePointAt(i);
//                srcCount = Character.charCount(srcChar);
//            } else {
//                srcCount = 1;
//            }
//            if (localeDependent ||
//                    srcChar == '\u03A3' || // GREEK CAPITAL LETTER SIGMA
//                    srcChar == '\u0130') { // LATIN CAPITAL LETTER I WITH DOT ABOVE
//                lowerChar = ConditionalSpecialCasing.toLowerCaseEx(this, i, locale);
//            } else {
//                lowerChar = Character.toLowerCase(srcChar);
//            }
//            if ((lowerChar == Character.ERROR)
//                    || (lowerChar >= Character.MIN_SUPPLEMENTARY_CODE_POINT)) {
//                if (lowerChar == Character.ERROR) {
//                    lowerCharArray =
//                            ConditionalSpecialCasing.toLowerCaseCharArray(this, i, locale);
//                } else if (srcCount == 2) {
//                    resultOffset += Character.toChars(lowerChar, result, i + resultOffset) - srcCount;
//                    continue;
//                } else {
//                    lowerCharArray = Character.toChars(lowerChar);
//                }
//
//                /* Grow result if needed */
//                int mapLen = lowerCharArray.length;
//                if (mapLen > srcCount) {
//                    char[] result2 = new char[result.length + mapLen - srcCount];
//                    System.arraycopy(result, 0, result2, 0, i + resultOffset);
//                    result = result2;
//                }
//                for (int x = 0; x < mapLen; ++x) {
//                    result[i + resultOffset + x] = lowerCharArray[x];
//                }
//                resultOffset += (mapLen - srcCount);
//            } else {
//                result[i + resultOffset] = (char)lowerChar;
//            }
//        }
//        return new String(result, 0, len + resultOffset);
//    }
//
//    /**
//     * Converts all of the characters in this {@code String} to lower
//     * case using the rules of the default locale. This is equivalent to calling
//     * {@code toLowerCase(Locale.getDefault())}.
//     * <p>
//     * <b>Note:</b> This method is locale sensitive, and may produce unexpected
//     * results if used for strings that are intended to be interpreted locale
//     * independently.
//     * Examples are programming language identifiers, protocol keys, and HTML
//     * tags.
//     * For instance, {@code "TITLE".toLowerCase()} in a Turkish locale
//     * returns {@code "t\u005Cu0131tle"}, where '\u005Cu0131' is the
//     * LATIN SMALL LETTER DOTLESS I character.
//     * To obtain correct results for locale insensitive strings, use
//     * {@code toLowerCase(Locale.ROOT)}.
//     * <p>
//     * @return  the {@code String}, converted to lowercase.
//     * @see     java.lang.String#toLowerCase(Locale)
//     */
//    public String toLowerCase() {
//        return toLowerCase(Locale.getDefault());
//    }
//
//    /**
//     * Converts all of the characters in this {@code String} to upper
//     * case using the rules of the given {@code Locale}. Case mapping is based
//     * on the Unicode Standard version specified by the {@link java.lang.Character Character}
//     * class. Since case mappings are not always 1:1 char mappings, the resulting
//     * {@code String} may be a different length than the original {@code String}.
//     * <p>
//     * Examples of locale-sensitive and 1:M case mappings are in the following table.
//     *
//     * <table border="1" summary="Examples of locale-sensitive and 1:M case mappings. Shows Language code of locale, lower case, upper case, and description.">
//     * <tr>
//     *   <th>Language Code of Locale</th>
//     *   <th>Lower Case</th>
//     *   <th>Upper Case</th>
//     *   <th>Description</th>
//     * </tr>
//     * <tr>
//     *   <td>tr (Turkish)</td>
//     *   <td>&#92;u0069</td>
//     *   <td>&#92;u0130</td>
//     *   <td>small letter i -&gt; capital letter I with dot above</td>
//     * </tr>
//     * <tr>
//     *   <td>tr (Turkish)</td>
//     *   <td>&#92;u0131</td>
//     *   <td>&#92;u0049</td>
//     *   <td>small letter dotless i -&gt; capital letter I</td>
//     * </tr>
//     * <tr>
//     *   <td>(all)</td>
//     *   <td>&#92;u00df</td>
//     *   <td>&#92;u0053 &#92;u0053</td>
//     *   <td>small letter sharp s -&gt; two letters: SS</td>
//     * </tr>
//     * <tr>
//     *   <td>(all)</td>
//     *   <td>Fahrvergn&uuml;gen</td>
//     *   <td>FAHRVERGN&Uuml;GEN</td>
//     *   <td></td>
//     * </tr>
//     * </table>
//     * @param locale use the case transformation rules for this locale
//     * @return the {@code String}, converted to uppercase.
//     * @see     java.lang.String#toUpperCase()
//     * @see     java.lang.String#toLowerCase()
//     * @see     java.lang.String#toLowerCase(Locale)
//     * @since   1.1
//     */
//    public String toUpperCase(Locale locale) {
//        if (locale == null) {
//            throw new NullPointerException();
//        }
//
//        int firstLower;
//        final int len = value.length;
//
//        /* Now check if there are any characters that need to be changed. */
//        scan: {
//            for (firstLower = 0 ; firstLower < len; ) {
//                int c = (int)value[firstLower];
//                int srcCount;
//                if ((c >= Character.MIN_HIGH_SURROGATE)
//                        && (c <= Character.MAX_HIGH_SURROGATE)) {
//                    c = codePointAt(firstLower);
//                    srcCount = Character.charCount(c);
//                } else {
//                    srcCount = 1;
//                }
//                int upperCaseChar = Character.toUpperCaseEx(c);
//                if ((upperCaseChar == Character.ERROR)
//                        || (c != upperCaseChar)) {
//                    break scan;
//                }
//                firstLower += srcCount;
//            }
//            return this;
//        }
//
//        /* result may grow, so i+resultOffset is the write location in result */
//        int resultOffset = 0;
//        char[] result = new char[len]; /* may grow */
//
//        /* Just copy the first few upperCase characters. */
//        System.arraycopy(value, 0, result, 0, firstLower);
//
//        String lang = locale.getLanguage();
//        boolean localeDependent =
//                (lang == "tr" || lang == "az" || lang == "lt");
//        char[] upperCharArray;
//        int upperChar;
//        int srcChar;
//        int srcCount;
//        for (int i = firstLower; i < len; i += srcCount) {
//            srcChar = (int)value[i];
//            if ((char)srcChar >= Character.MIN_HIGH_SURROGATE &&
//                    (char)srcChar <= Character.MAX_HIGH_SURROGATE) {
//                srcChar = codePointAt(i);
//                srcCount = Character.charCount(srcChar);
//            } else {
//                srcCount = 1;
//            }
//            if (localeDependent) {
//                upperChar = ConditionalSpecialCasing.toUpperCaseEx(this, i, locale);
//            } else {
//                upperChar = Character.toUpperCaseEx(srcChar);
//            }
//            if ((upperChar == Character.ERROR)
//                    || (upperChar >= Character.MIN_SUPPLEMENTARY_CODE_POINT)) {
//                if (upperChar == Character.ERROR) {
//                    if (localeDependent) {
//                        upperCharArray =
//                                ConditionalSpecialCasing.toUpperCaseCharArray(this, i, locale);
//                    } else {
//                        upperCharArray = Character.toUpperCaseCharArray(srcChar);
//                    }
//                } else if (srcCount == 2) {
//                    resultOffset += Character.toChars(upperChar, result, i + resultOffset) - srcCount;
//                    continue;
//                } else {
//                    upperCharArray = Character.toChars(upperChar);
//                }
//
//                /* Grow result if needed */
//                int mapLen = upperCharArray.length;
//                if (mapLen > srcCount) {
//                    char[] result2 = new char[result.length + mapLen - srcCount];
//                    System.arraycopy(result, 0, result2, 0, i + resultOffset);
//                    result = result2;
//                }
//                for (int x = 0; x < mapLen; ++x) {
//                    result[i + resultOffset + x] = upperCharArray[x];
//                }
//                resultOffset += (mapLen - srcCount);
//            } else {
//                result[i + resultOffset] = (char)upperChar;
//            }
//        }
//        return new String(result, 0, len + resultOffset);
//    }
//
//    /**
//     * Converts all of the characters in this {@code String} to upper
//     * case using the rules of the default locale. This method is equivalent to
//     * {@code toUpperCase(Locale.getDefault())}.
//     * <p>
//     * <b>Note:</b> This method is locale sensitive, and may produce unexpected
//     * results if used for strings that are intended to be interpreted locale
//     * independently.
//     * Examples are programming language identifiers, protocol keys, and HTML
//     * tags.
//     * For instance, {@code "title".toUpperCase()} in a Turkish locale
//     * returns {@code "T\u005Cu0130TLE"}, where '\u005Cu0130' is the
//     * LATIN CAPITAL LETTER I WITH DOT ABOVE character.
//     * To obtain correct results for locale insensitive strings, use
//     * {@code toUpperCase(Locale.ROOT)}.
//     * <p>
//     * @return  the {@code String}, converted to uppercase.
//     * @see     java.lang.String#toUpperCase(Locale)
//     */
//    public String toUpperCase() {
//        return toUpperCase(Locale.getDefault());
//    }
//
//    /**
//     * Returns a string whose value is this string, with any leading and trailing
//     * whitespace removed.
//     * <p>
//     * If this {@code String} object represents an empty character
//     * sequence, or the first and last characters of character sequence
//     * represented by this {@code String} object both have codes
//     * greater than {@code '\u005Cu0020'} (the space character), then a
//     * reference to this {@code String} object is returned.
//     * <p>
//     * Otherwise, if there is no character with a code greater than
//     * {@code '\u005Cu0020'} in the string, then a
//     * {@code String} object representing an empty string is
//     * returned.
//     * <p>
//     * Otherwise, let <i>k</i> be the index of the first character in the
//     * string whose code is greater than {@code '\u005Cu0020'}, and let
//     * <i>m</i> be the index of the last character in the string whose code
//     * is greater than {@code '\u005Cu0020'}. A {@code String}
//     * object is returned, representing the substring of this string that
//     * begins with the character at index <i>k</i> and ends with the
//     * character at index <i>m</i>-that is, the result of
//     * {@code this.substring(k, m + 1)}.
//     * <p>
//     * This method may be used to trim whitespace (as defined above) from
//     * the beginning and end of a string.
//     *
//     * @return  A string whose value is this string, with any leading and trailing white
//     *          space removed, or this string if it has no leading or
//     *          trailing white space.
//     */
//    public String trim() {
//        int len = value.length;
//        int st = 0;
//        char[] val = value;    /* avoid getfield opcode */
//
//        while ((st < len) && (val[st] <= ' ')) {
//            st++;
//        }
//        while ((st < len) && (val[len - 1] <= ' ')) {
//            len--;
//        }
//        return ((st > 0) || (len < value.length)) ? substring(st, len) : this;
//    }
//
//    /**
//     * This object (which is already a string!) is itself returned.
//     *
//     * @return  the string itself.
//     */
//    public String toString() {
//        return this;
//    }
//
//    /**
//     * Converts this string to a new character array.
//     *
//     * @return  a newly allocated character array whose length is the length
//     *          of this string and whose contents are initialized to contain
//     *          the character sequence represented by this string.
//     */
//    public char[] toCharArray() {
//        // Cannot use Arrays.copyOf because of class initialization order issues
//        char result[] = new char[value.length];
//        System.arraycopy(value, 0, result, 0, value.length);
//        return result;
//    }
//
//    /**
//     * Returns a formatted string using the specified format string and
//     * arguments.
//     *
//     * <p> The locale always used is the one returned by {@link
//     * java.util.Locale#getDefault() Locale.getDefault()}.
//     *
//     * @param  format
//     *         A <a href="../util/Formatter.html#syntax">format string</a>
//     *
//     * @param  args
//     *         Arguments referenced by the format specifiers in the format
//     *         string.  If there are more arguments than format specifiers, the
//     *         extra arguments are ignored.  The number of arguments is
//     *         variable and may be zero.  The maximum number of arguments is
//     *         limited by the maximum dimension of a Java array as defined by
//     *         <cite>The Java&trade; Virtual Machine Specification</cite>.
//     *         The behaviour on a
//     *         {@code null} argument depends on the <a
//     *         href="../util/Formatter.html#syntax">conversion</a>.
//     *
//     * @throws  java.util.IllegalFormatException
//     *          If a format string contains an illegal syntax, a format
//     *          specifier that is incompatible with the given arguments,
//     *          insufficient arguments given the format string, or other
//     *          illegal conditions.  For specification of all possible
//     *          formatting errors, see the <a
//     *          href="../util/Formatter.html#detail">Details</a> section of the
//     *          formatter class specification.
//     *
//     * @return  A formatted string
//     *
//     * @see  java.util.Formatter
//     * @since  1.5
//     */
//    public static String format(String format, Object... args) {
//        return new Formatter().format(format, args).toString();
//    }
//
//    /**
//     * Returns a formatted string using the specified locale, format string,
//     * and arguments.
//     *
//     * @param  l
//     *         The {@linkplain java.util.Locale locale} to apply during
//     *         formatting.  If {@code l} is {@code null} then no localization
//     *         is applied.
//     *
//     * @param  format
//     *         A <a href="../util/Formatter.html#syntax">format string</a>
//     *
//     * @param  args
//     *         Arguments referenced by the format specifiers in the format
//     *         string.  If there are more arguments than format specifiers, the
//     *         extra arguments are ignored.  The number of arguments is
//     *         variable and may be zero.  The maximum number of arguments is
//     *         limited by the maximum dimension of a Java array as defined by
//     *         <cite>The Java&trade; Virtual Machine Specification</cite>.
//     *         The behaviour on a
//     *         {@code null} argument depends on the
//     *         <a href="../util/Formatter.html#syntax">conversion</a>.
//     *
//     * @throws  java.util.IllegalFormatException
//     *          If a format string contains an illegal syntax, a format
//     *          specifier that is incompatible with the given arguments,
//     *          insufficient arguments given the format string, or other
//     *          illegal conditions.  For specification of all possible
//     *          formatting errors, see the <a
//     *          href="../util/Formatter.html#detail">Details</a> section of the
//     *          formatter class specification
//     *
//     * @return  A formatted string
//     *
//     * @see  java.util.Formatter
//     * @since  1.5
//     */
//    public static String format(Locale l, String format, Object... args) {
//        return new Formatter(l).format(format, args).toString();
//    }
//
//    /**
//     * Returns the string representation of the {@code Object} argument.
//     *
//     * @param   obj   an {@code Object}.
//     * @return  if the argument is {@code null}, then a string equal to
//     *          {@code "null"}; otherwise, the value of
//     *          {@code obj.toString()} is returned.
//     * @see     java.lang.Object#toString()
//     */
//    public static String valueOf(Object obj) {
//        return (obj == null) ? "null" : obj.toString();
//    }
//
//    /**
//     * Returns the string representation of the {@code char} array
//     * argument. The contents of the character array are copied; subsequent
//     * modification of the character array does not affect the returned
//     * string.
//     *
//     * @param   data     the character array.
//     * @return  a {@code String} that contains the characters of the
//     *          character array.
//     */
//    public static String valueOf(char data[]) {
//        return new String(data);
//    }
//
//    /**
//     * Returns the string representation of a specific subarray of the
//     * {@code char} array argument.
//     * <p>
//     * The {@code offset} argument is the index of the first
//     * character of the subarray. The {@code count} argument
//     * specifies the length of the subarray. The contents of the subarray
//     * are copied; subsequent modification of the character array does not
//     * affect the returned string.
//     *
//     * @param   data     the character array.
//     * @param   offset   initial offset of the subarray.
//     * @param   count    length of the subarray.
//     * @return  a {@code String} that contains the characters of the
//     *          specified subarray of the character array.
//     * @exception IndexOutOfBoundsException if {@code offset} is
//     *          negative, or {@code count} is negative, or
//     *          {@code offset+count} is larger than
//     *          {@code data.length}.
//     */
//    public static String valueOf(char data[], int offset, int count) {
//        return new String(data, offset, count);
//    }
//
//    /**
//     * Equivalent to {@link #valueOf(char[], int, int)}.
//     *
//     * @param   data     the character array.
//     * @param   offset   initial offset of the subarray.
//     * @param   count    length of the subarray.
//     * @return  a {@code String} that contains the characters of the
//     *          specified subarray of the character array.
//     * @exception IndexOutOfBoundsException if {@code offset} is
//     *          negative, or {@code count} is negative, or
//     *          {@code offset+count} is larger than
//     *          {@code data.length}.
//     */
//    public static String copyValueOf(char data[], int offset, int count) {
//        return new String(data, offset, count);
//    }
//
//    /**
//     * Equivalent to {@link #valueOf(char[])}.
//     *
//     * @param   data   the character array.
//     * @return  a {@code String} that contains the characters of the
//     *          character array.
//     */
//    public static String copyValueOf(char data[]) {
//        return new String(data);
//    }
//
//    /**
//     * Returns the string representation of the {@code boolean} argument.
//     *
//     * @param   b   a {@code boolean}.
//     * @return  if the argument is {@code true}, a string equal to
//     *          {@code "true"} is returned; otherwise, a string equal to
//     *          {@code "false"} is returned.
//     */
//    public static String valueOf(boolean b) {
//        return b ? "true" : "false";
//    }
//
//    /**
//     * Returns the string representation of the {@code char}
//     * argument.
//     *
//     * @param   c   a {@code char}.
//     * @return  a string of length {@code 1} containing
//     *          as its single character the argument {@code c}.
//     */
//    public static String valueOf(char c) {
//        char data[] = {c};
//        return new String(data, true);
//    }
//
//    /**
//     * Returns the string representation of the {@code int} argument.
//     * <p>
//     * The representation is exactly the one returned by the
//     * {@code Integer.toString} method of one argument.
//     *
//     * @param   i   an {@code int}.
//     * @return  a string representation of the {@code int} argument.
//     * @see     java.lang.Integer#toString(int, int)
//     */
//    public static String valueOf(int i) {
//        return Integer.toString(i);
//    }
//
//    /**
//     * Returns the string representation of the {@code long} argument.
//     * <p>
//     * The representation is exactly the one returned by the
//     * {@code Long.toString} method of one argument.
//     *
//     * @param   l   a {@code long}.
//     * @return  a string representation of the {@code long} argument.
//     * @see     java.lang.Long#toString(long)
//     */
//    public static String valueOf(long l) {
//        return Long.toString(l);
//    }
//
//    /**
//     * Returns the string representation of the {@code float} argument.
//     * <p>
//     * The representation is exactly the one returned by the
//     * {@code Float.toString} method of one argument.
//     *
//     * @param   f   a {@code float}.
//     * @return  a string representation of the {@code float} argument.
//     * @see     java.lang.Float#toString(float)
//     */
//    public static String valueOf(float f) {
//        return Float.toString(f);
//    }
//
//    /**
//     * Returns the string representation of the {@code double} argument.
//     * <p>
//     * The representation is exactly the one returned by the
//     * {@code Double.toString} method of one argument.
//     *
//     * @param   d   a {@code double}.
//     * @return  a  string representation of the {@code double} argument.
//     * @see     java.lang.Double#toString(double)
//     */
//    public static String valueOf(double d) {
//        return Double.toString(d);
//    }
//
//    /**
//     * Returns a canonical representation for the string object.
//     * <p>
//     * A pool of strings, initially empty, is maintained privately by the
//     * class {@code String}.
//     * <p>
//     * When the intern method is invoked, if the pool already contains a
//     * string equal to this {@code String} object as determined by
//     * the {@link #equals(Object)} method, then the string from the pool is
//     * returned. Otherwise, this {@code String} object is added to the
//     * pool and a reference to this {@code String} object is returned.
//     * <p>
//     * It follows that for any two strings {@code s} and {@code t},
//     * {@code s.intern() == t.intern()} is {@code true}
//     * if and only if {@code s.equals(t)} is {@code true}.
//     * <p>
//     * All literal strings and string-valued constant expressions are
//     * interned. String literals are defined in section 3.10.5 of the
//     * <cite>The Java&trade; Language Specification</cite>.
//     *
//     * @return  a string that has the same contents as this string, but is
//     *          guaranteed to be from a pool of unique strings.
//     */
//    public native String intern();
//}
