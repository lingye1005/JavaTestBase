package jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 09:40
 * @ProjectName: JavaBaseTest
 *
 */
public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> res=Permutation("ab");
        res.forEach(s-> System.out.println(s));
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res=new ArrayList<>();
        if(str==null || str.trim().equals(""))
            return res;
        //deal
        char[] strs=str.toLowerCase().toCharArray();
        Arrays.sort(strs);
        res.add(String.valueOf(strs));
        int len=strs.length;
        while(true){
            boolean find=false;
            int i;
            //strs[i-1]>strs[i]
            for(i=len-1;i>0 && find==false;i--){
                if(strs[i-1]>strs[i]){
                    find=true;
                }
            }
            //查找完毕
            if(!find)
                break;
            //还有可以排列的表达式
            int j;
            for(j=len-1;j>=i;j--){
                if(strs[j]>strs[i-1]){
                    break;
                }
            }
            //交换strs[i-1]和strs[j]的值，然后将[i，len－1]的元素升序
            char tmp=strs[i-1];
            strs[i-1]=strs[j];
            strs[j]=tmp;
            int low=i,high=len-1;
            while(low<high){
                tmp=strs[low];
                strs[low]=strs[high];
                strs[high]=tmp;
            }
            res.add(String.valueOf(strs));
        }
        return res;
    }
}
