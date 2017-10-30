package schooloffer16;

import java.util.HashSet;

/**
 * Created by caoxiaohong on 17/9/11.
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 * 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 */
public class FindFirstRepeat {
    public char findFirstRepeat(String A, int n) {
        if(n<=0)
            return ' ';
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<n;i++){
            if(set.contains(A.charAt(i)))
                return A.charAt(i);
            else
                set.add(A.charAt(i));
        }
        return ' ';
    }
}
