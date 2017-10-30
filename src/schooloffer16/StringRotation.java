package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/9.
 * 对于一个字符串，和字符串中的某一位置，请设计一个算法，将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
 * 给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。
 */
public class StringRotation {
    public String rotateString(String A, int n, int p) {
        // write code here
        StringBuilder sb=new StringBuilder();
        sb.append(A.substring(p+1,n));
        sb.append(A.substring(0,p+1));
        return sb.toString();
    }
}
