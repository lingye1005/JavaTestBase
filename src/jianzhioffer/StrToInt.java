package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 0~9assii码:48-57
 */
public class StrToInt {
    public int StrToInt(String str) {
        try {
            return Integer.valueOf(str);
        }catch (Exception e){
            return 0;
        }
    }
}
