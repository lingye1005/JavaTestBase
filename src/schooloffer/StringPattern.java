package schooloffer;

/**
 * Created by caoxiaohong on 17/9/29.
 * 对于两个字符串A，B。请设计一个高效算法，找到B在A中第一次出现的起始位置。若B未在A中出现，则返回-1。
 * 给定两个字符串A和B，及它们的长度lena和lenb，请返回题目所求的答案。
 */
public class StringPattern {
    public int findAppearance(String A, int lena, String B, int lenb) {
        // write code here
        if(lenb>lena)
            return -1;
        else
            return A.indexOf(B);
    }
}
