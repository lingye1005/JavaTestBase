package equalsVs;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caoxiaohong on 17/3/5.
 * 比较 equals() 和 ==,前者比较内容,后者比较地址.
 */
public class EqualsAndHengdengyu {
    public static void main(String[] args) {
        int a1=3,a2=3;
        System.out.println(a1==a2);//true
        //System.out.println(a1.equals(a2));非法写法

        String str1="ccc";
        String str2=new String("ccc");
        String str3=str1;
        System.out.println(str1.equals(str2));//true
        System.out.println(str1==str2);//false
        System.out.println(str1.equals(str3));//true;
        System.out.println(str1==str3);//true;
        System.out.println(str2.equals(str3));//true;
        System.out.println(str2==str3);//false
        System.out.println(new SimpleDateFormat("yyyy-MM-ss-hh-mm").format(new Date()));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ss-hh-mm");
        System.out.println(sdf.format(new Date()));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
