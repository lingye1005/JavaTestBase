package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/29.
 * 给定一个包含单词,空格的字符串(单词内不含空格),返回最后一个单词的长度.不存在,则返回0
 *  For example,
 *  Given s ="Hello World",
 *  return5
 */
public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String s1=s.toLowerCase();//转为小写;
        int len=s.length();
        int last=s.lastIndexOf(" ");
        String[] result; //存放结果集
        if(last<len-1) { //单词在最后
            return len-1-last;
        }else { //将s按照空格改为数组
            result=s.split(" ");
            int size=result.length;
            if(size==0)//全部为空格
                return 0;
            else{
                String lastword=result[size-1];
                return lastword.length();
            }

        }
    }

    public static void main(String[] args) {
        lengthOfLastWord test=new lengthOfLastWord();
        String a="     ";
        String b=" word ";
        String c="  world";
        String d=" i  am a girl";
        System.out.println(test.lengthOfLastWord(a));
        System.out.println(test.lengthOfLastWord(b));
        System.out.println(test.lengthOfLastWord(c));
        System.out.println(test.lengthOfLastWord(d));

    }
}
