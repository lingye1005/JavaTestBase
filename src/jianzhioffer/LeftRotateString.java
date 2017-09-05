package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(n>str.length())
            return str;
        StringBuilder sb=new StringBuilder();
        sb.append(str.substring(n,str.length()));
        sb.append(str.substring(0,n));
        return sb.toString();
    }
}
