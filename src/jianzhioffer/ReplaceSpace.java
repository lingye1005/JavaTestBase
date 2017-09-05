package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String temp=str.toString();
        temp=temp.replace(" ","%20");
        return temp;
    }

    public static void main(String[] args) {
        ReplaceSpace test=new ReplaceSpace();
        StringBuffer sb=new StringBuffer();
        sb.append("We Are Happy");
        System.out.println(test.replaceSpace(sb));
    }
}
