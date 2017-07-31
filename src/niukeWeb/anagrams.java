package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/3.
 * 给定一个字符串数组,返回数组中是"换位词"的字符串
 * Given an array of strings, return all groups of strings that are anagrams.
 * 算法思想:遍历strs,对于每一个strs[i],首先按字母进行排序,然后查找存放不同str的set,如果存在,则将此str存放到结果集中.
 */
public class anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result=new ArrayList<String>();
        if(strs==null || strs.length==0)
            return result;
        int len=strs.length;
        //为strs排序
        ArrayList<String> sortedStr=new ArrayList<String>(len);
        for(int i=0;i<len;i++){
            String temp=sortedString(strs[i]);
            sortedStr.add(temp);
        }

        for(int i=0;i<len;i++){
            String temp=sortedString(strs[i]);
            if(sortedStr.indexOf(temp)!=sortedStr.lastIndexOf(temp))
                result.add(strs[i]);
        }
        return result;
    }
    //求字符串排序后的结果
    String sortedString(String str){
        int len=str.length();
        if(len==1)
            return str;
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=len-1;j>i;j--){
                if(str.charAt(j)<str.charAt(j-1)){
                    char[] temp=str.toCharArray();
                    char ch1=temp[j];
                    temp[j]=temp[j-1];
                    temp[j-1]=ch1;
                    str=String.valueOf(temp);
                    flag=true;
                }
            }
            if(flag==false)
                break;
        }
        return str;
    }

    public static void main(String[] args) {
        anagrams t=new anagrams();
        String[] a=new String[5];
        a[0]="abc";
        a[1]="bac";
        a[2]="cab";
        a[3]="";
        a[4]="";
        ArrayList<String> list=t.anagrams(a);
        for(String s:list){
            System.out.println("s:"+s);
        }
    }
}
