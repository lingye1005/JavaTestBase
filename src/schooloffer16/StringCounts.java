package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/17.
 * 求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。
 * 题目看了一天,总算是基本明白了
 * 遇到的2个问题:
 * 1.本题的字典排序中,以为一个字符串中各个字符必须是不同的,以为ab..后面只能是c..z,但其实ab后面任意一位都可以是a..z
 * 2.Math.pow()函数使用时,没有强制专为long类型,导致算法写好后,一种结果不对,后来发现是结果类型没有被强制转换.
 */
public class StringCounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            char[] str1=strs[0].toCharArray();
            char[] str2=strs[1].toCharArray();
            int minLen=Integer.valueOf(strs[2]);
            int maxLen=Integer.valueOf(strs[3]);

            long res=0;
            for(int i=minLen;i<=maxLen;i++){
                char a=str1[0];
                char b=str2[0];
                /**
                 * Math.pow(26,i-1)表示:长度为i的字符串,第一位是固定字符的情况下,后面i-1位,每一位均有26种情况,即为a~z;
                 * (b-a)表示:字典排序中,从字符a到字符b有多少种情况
                 * 求两个字符串分别以a和b开头,且长度均为i时,如果用n表示可以出现的所有的字典排序的情况数目,则理想情况下n为26的整数倍.
                 * 比如:ab和bc两个字符串求长度为2的中间字串个数就是刚刚好26个:ac~az,ba~bb; ~理想情况
                 * 但是,ab和ba两个字符串求长度为2的中间字符串个数就是24个:ac~az; ~理想情况-1
                 * ab和bd两个字符串长度为2的中间字符串个数是27个:ac~bc;~理想情况+1
                 */
                res+=(long)Math.pow(26,i-1)*(b-a);

                /**
                 * 为什么会有两个for循环?
                 * 第一个for循环作用:j从1开始,然后分别以str1[j]开头,长度为i-1-j的字符串有多少种字典排序~显然这是长度为i,j=0开始的字符串的子串
                 *                 比如:对于字符串abcdd,i=4时.母串为abcd  &&  子串分别为bcd ; cd; d 这3种情况.
                 * 第二个for循环作用:j从1开始,然后分别以str2[j]开头,长度为i-1-j的字符串有多少种字典排序.
                 * 上面的Math.pow(26,i-1)*(b-a)求出了res可以增加到理想值.而这种赋值在某些情况下会出现多加或者少加的情况:
                 *
                 * 比如:
                 * 例子1:字符串为ab和ba,显然从ac到ba之间的字符串个数=24,那么怎么把多出来的1减掉呢?这就到了两个for循环其作用的时候了.
                 * 每次大循环中,两个小for循环都会进行减值:给出运行过程中关键变量的值:
                 * i=1时,第一个小for循环中,程序运行过程中值变化过程:res=0;sum1=0;sum2=0;res=1;
                 * i=2时,第二个小for循环中,程序运行过程中值变化过程:res==27;sum1=1;sum2=0;res=26;
                 * 显然,第二个小for循环进行了-1操作.
                 *
                 * 例子2:字符串为ab和bc,显然ab到bc之间的字符串个数=27,那么怎么把少的1给加回来,这就到了两个for循环其作用的时候了.
                 * 每次大循环中,两个小for循环都会进行减值:给出运行过程中关键变量的值:
                 * i=1时,第一个小for循环中,程序运行过程中值变化过程:res=1;sum1=0;sum2=0;res=1;
                 * i=2时,第二个小for循环中,程序运行过程中值变化过程:res=27;sum1=1;sum2=2;res=28;
                 * 显然,第二个小for循环进行了+1操作.
                 */
                long sum1=0;
                for(int j=1;j<str1.length;j++){
                    sum1+=(long)Math.pow(26,i-1-j)*(str1[j]-'a');
//                    if(sum1>=1000007)
//                        sum1%=1000007;为什么这里会被注释掉?因为下面涉及两个数的减法sum2-sum1,那就会出现,本来sum2-sum1>0,但是取余后结果确实负值,eg:sum1=1000008,sum2=2000014.
                }
                long sum2=0;
                for(int j=1;j<str2.length;j++){
                    sum2+=(long)Math.pow(26,i-1-j)*(str2[j]-'a');
//                    if(sum2>=1000007)
//                        sum2%=1000007;
                }
                res+=sum2-sum1;
                if(res>=1000007)
                    res%=1000007;
            }
            /**
             * 为什么-1?
             * 因为res中包括了给出的字符串str2的这种情况.
             * 比如:字符串a和字符串b,求i=1的字符串个数
             * 显然:res+=1;  //来源于:res+=Math.pow(26,i-1)*(b-a);
             * 但是显然,a和b之间并没有子字符串.此时就包括了b这个字符串.所以结果得减去1.
             */
            res--;
            System.out.println(res%1000007);
        }
    }
}
