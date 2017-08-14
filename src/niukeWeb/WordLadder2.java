package niukeWeb;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by caoxiaohong on 17/8/13.
 * 题意:给定一个开始转化的字符串start,和一个最终需要被转化成的字符串,以及一个字符串字典.
 * 从start开始,每次只能转化一个字符,通过字典中的多个字符串进行转化,最终转化成为一个和end仅仅有一个字符之差的字符串.
 * 找出所有的最短变化字符串序列,并返回;
 *
 * 算法思想:来源于上一个WordLadder题目.
 * 1,dfs首先求出最短路径长度.
 * 2,再次dfs,遍历到该层次时候,如果那个字符串刚刚为end这个字符串,则将此次dfs结果放入结果集中.
 */
public class WordLadder2 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        return null;
    }
}
