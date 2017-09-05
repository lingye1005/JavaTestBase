package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/30.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str.equals(""))
            return -1;
        for(int i=0;i<str.length();i++){
            char tmp=str.charAt(i);
            if(str.indexOf(tmp)==str.lastIndexOf(tmp))
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar t=new FirstNotRepeatingChar();
        System.out.println(t.FirstNotRepeatingChar("google"));
    }
}
