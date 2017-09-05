package niukeWeb;

/**
 * Created by caoxiaohong on 17/8/25.
 * p字符串能否转化为s字符串?
 * p中可以包含?和*.其中?可以代表任意一个字符(有且仅有一个),而*可以代表任意长度任意字符串(包括空);
 * 思路:参考网上资料
 * 假设我们用两个指针分别指向s和p字符串中要匹配的位置，首先分析下通配符匹配过程中会有哪些情况是成功：
    s的字符和p的字符相等
    p中的字符是?，这时无论s的字符是什么都可以匹配一个
    p中遇到了一个*，这时无论s的字符是什么都没关系
    之前的都不符合，但是p在之前的位置有一个*，我们可以从上一个*后面开始匹配
    s已经匹配完，但是p后面还有很多连续的`*
    这里1和2的情况比较好处理，关键在于如何处理3和4的情况。当我们遇到一个*时，因为之后可能要退回至该位置重新匹配，我们要将它的下标记录下来，
    比如idxstar。但是，当我们连续遇到两次4的情况，如何保证我还是能继续匹配s，而不是每次都退回idxstar+1导致循环呢？所以我们还要记录一个idxmatch，
    用来记录用上一个*连续匹配到的s中的下标。最后，对于情况5，我们用一个循环跳过末尾的*跳过就行了。
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int idxs=0,idxp=0;//s下标;p下标
        int idxStart=-1;//p上一次出现*的位置
        int idxMatch=0;//s和p上一次匹配*的位置
        while(idxs<s.length()){
            if(idxp<p.length() && (s.charAt(idxs)==p.charAt(idxp) || p.charAt(idxp)=='?')){//s和p比较字符相同 or p比较字符为?
                idxs++;//s比较字符位置后移
                idxp++;//p比较字符位置后移
            }else if(idxp<p.length() && p.charAt(idxp)=='*'){//p比较字符为*
                idxStart=idxp;//记录*出现位置
                idxMatch=idxs;//记录s中和*匹配字符的位置
                idxp++;//p比较字符位置后移
            }else if(idxStart!=-1){
                idxp=idxStart+1;//p重新匹配位置返回到:上次出现*的位置+1处
                idxMatch++;//s匹配*位置后移1位
                idxs=idxMatch;//s比较字符位置重置
            }else{
                return false;
            }
        }
        //如果p还未匹配完
        while(idxp<p.length()){
            if(p.charAt(idxp)!='*')
                break;
            else
                idxp++;
        }
        return idxp==p.length();
    }
}
