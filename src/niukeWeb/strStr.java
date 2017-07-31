package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/12.
 */
public class strStr {
    public String strStr(String haystack, String needle) {
        if(haystack.equals("") && !needle.equals(""))
            return null;
        else if(haystack.equals("") && needle.equals(""))
            return "";
        else if(!haystack.equals("") && needle.equals(""))
            return haystack;
        else {
            int a = haystack.indexOf(needle);
            if (a == -1)
                return null;
            else
                return haystack.substring(a, haystack.length());
        }
    }

    public static void main(String[] args) {
        strStr s=new strStr();
        System.out.println(s.strStr("mmmaac","ma"));
    }
}
