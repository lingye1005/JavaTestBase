package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 11:06
 * @ProjectName: JavaBaseTest
 * 此方法为剑指offer书上的方法,但是没提供元素排序的比较器,如果需要,可以自己添加即可.
 */
public class Permutation2 {
    public ArrayList<String> Permutation(String str) {
        helper(str.toCharArray(),0);
        return res;
    }

    ArrayList<String> res=new ArrayList<>();
    private  void helper(char[] strs,int begin){
        if(begin>=strs.length-1) {
            res.add(String.valueOf(strs));
            return;
        }

        //begin后面的每一位都和bigin位置的元素进行交换
        for(int i=begin;i<strs.length;i++){
            //交换begin和i元素
            char tmp=strs[i];
            strs[i]=strs[begin];
            strs[begin]=tmp;

            //begin和i交换元素后,begin+1成为新一轮递归的开始
            helper(strs,begin+1);

            //状态恢复到begin和i未交换的时候,以便begin和i+1交换
            tmp=strs[i];
            strs[i]=strs[begin];
            strs[begin]=tmp;
        }
    }
}
