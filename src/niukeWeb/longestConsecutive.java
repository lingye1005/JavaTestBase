package niukeWeb;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoxiaohong on 17/5/13.
 * 给定一个一维整数数组,求数组中最长的连续元素有几个.
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * 时间复杂度:o(n)
 */
public class longestConsecutive {
    //主算法
    public int longestConsecutive(int[] num) {
        //先去重
        Set<Integer> unique=new HashSet<Integer>();
        for(int i:num){
            unique.add(i);
        }
        //遍历新集合unique,maxlen记录每次遍历的最长顺序列
        int maxlen=0;
        for(int k:num){
            int left=k-1;
            int right=k+1;
            int count=0;
            while(unique.contains(left)){
                count++;
                unique.remove(left);
                left--;
            }
            while(unique.contains(right)){
                count++;
                unique.remove(right);
                right++;
            }
            maxlen=Math.max(maxlen,count+1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] test=new int[]{100,4,200,1,3,2};
        longestConsecutive longest=new longestConsecutive();
        int re= longest.longestConsecutive(test);
        System.out.println(re);
    }
}
