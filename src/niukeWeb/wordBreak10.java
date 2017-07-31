package niukeWeb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoxiaohong on 17/5/6.
 * 牛客网第10题:动态规划
 * 根据给定的字符串和词典,求将字符串划分为词典里的词且整个字符串刚刚好分配完成的组合方式有多少种.例子如下:
 * s ="catsanddog",dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class wordBreak10 {

    //判定string能否分解为单词
    boolean wordBreakCanDo(String s,Set<String> dict){
        s="#"+s;//为二重for循环的&&做准备
        boolean[] canSegment=new boolean[s.length()];
        canSegment[0]=true;
        for(int i=1;i<s.length();i++){
            for(int k=0;k<i;k++){
                canSegment[i]=canSegment[k] && dict.contains(s.substring(k+1,i+1));//这里的思想:1-k可分,且k+1到i+1可分.则i可分.
                if(canSegment[i]) break;
            }
        }
        return canSegment[s.length()-1];
    }
    //对string连续深搜DFS,直到分词的起始位置超过了string长度[第一次深搜字符串起始位置是从0开始的]
    //startIndex:当前进行wordbreak的起点.也就说如果前面已经break了,再break应该从后面的字符开始.
    //preWords:string已经break的前半部分
    //result:用来存储string每次被彻底break后的结果集
    void dfs(String s,Set<String> dict,int startIndex,String preWords,ArrayList<String> result){
        if(startIndex>=s.length()){
            result.add(preWords);
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            String temp=s.substring(startIndex,i+1);
            if(dict.contains(temp)){
                String newPreWord;
                if(preWords.length()>0){
                    newPreWord=preWords+" "+temp;
                }else {
                    newPreWord=temp;
                }
                dfs(s,dict,i+1,newPreWord,result);
            }
        }
    }
    //主算法
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result=new ArrayList<String>();
        if(s.equals("") || s==null || !wordBreakCanDo(s,dict))
            return result;
        dfs(s,dict,0,"",result);
        return result;
    }

    public static void main(String[] args) {
        wordBreak10 test=new wordBreak10();
        String s="catsanddog";
        Set<String> dict=new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> re=new ArrayList<String>();
        re=test.wordBreak(s,dict);
        System.out.println(re.size());
        System.out.println(s.substring(0,2));
        for(int i=0;i<re.size();i++){
            System.out.println(re.get(i));
        }
    }
}
