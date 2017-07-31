package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/19.
 * 给定字符串,求字符串的不同分割，使得分割后的子串都是回文串。并返回所有分割情况.
 * 回溯法:实质就是对图的dfs过程,每个查找过程都是对每种可能情况的枚举;
 */
public class palindromePartitioning {
    static ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();//结果集
    ArrayList<String> temp=new ArrayList<String>();
    public ArrayList<ArrayList<String>> partition(String s) {
        dfs(s,temp,result);
        return result;
    }

    /**
     * 回溯+递归
     * @param s
     * @param temp
     * @param result
     */
    void dfs(String s,ArrayList<String> temp,ArrayList<ArrayList<String>> result){
        if(s.isEmpty()){
            ArrayList<String> a=new ArrayList<String>(temp);
            result.add(a);
            return;
        }
        for(int i=1;i<=s.length();i++){
            String a=s.substring(0,i);
            if(isPalindrome(a)){
                temp.add(a);
                String b=s.substring(i);
                dfs(b,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }

    /**
     * 判定一个字符串是否为回文序列
     * @param str
     * @return
     */
    boolean isPalindrome(String str){
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        palindromePartitioning test=new palindromePartitioning();
        test.partition("aab");
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            for(String str:result.get(i))
                System.out.print(str+",");
            System.out.println();
        }
    }
}
