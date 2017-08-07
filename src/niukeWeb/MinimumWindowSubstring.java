package niukeWeb;

import java.util.HashMap;

/**
 * Created by caoxiaohong on 17/8/6.
 * 在字符串s中查找子串,要求子串包含t中所有字母,子串中字母和t中字母顺序可以不同,只要包含就行.求最短的子串.
 * 注意:如果没有找到,则返回空串;如果存在多个最短子串,则默认返回找到的一个就行了.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
         if(S.equals("") || T.equals(""))
             return "";
         HashMap<String,Integer> mapT=getmap(T);
         //比较两个map是否相同
         int subLen=T.length();//在s中截取字符串长度
         for(int k=subLen;k<=S.length();k++) {
             for (int i = 0; i <=S.length() - k; i++) {
                 HashMap<String, Integer> mapS =new HashMap<String, Integer>(mapT);
                 for(int j=0;j<k;j++){
                     String c=S.substring(i+j,i+j+1);
                     if(mapS.containsKey(c)){
                         if(mapS.get(c)==1){
                             mapS.remove(c);
                         }else{
                             mapS.put(c,mapS.get(c)-1);
                         }
                     }
                 }
                 if(mapS.isEmpty())
                     return S.substring(i,i+k);
             }
         }
         return "";
    }

    /**
     * 获取字符串T对应的hashmap
     * @param T
     * @return
     */
    HashMap<String,Integer> getmap(String T){
        HashMap<String,Integer> map=new HashMap<String, Integer>(); //记录t中出现的各个字母的次数
        for(int i=0;i<T.length();i++){
            String s=T.substring(i,i+1);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test=new MinimumWindowSubstring();
        String s="ADOBECODEBANC",t="ABC";
        String sout=test.minWindow(s,t);
        System.out.println(sout);
    }
}
