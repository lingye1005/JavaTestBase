package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/13.
 * 给出数字字符串,然后对比数字在电话键盘桑对应的英文字母,写出可能的英文字母组合情况.并返回.
 * 树的深度优先搜索
 */
public class letterCombinations {
    ArrayList<String> result=new ArrayList<String>();  //存放结果 ,注意此处:如果是声明为staic,则会自动在编译期间添加一个""进去,导致oj结果错误,但是本地代码测试时缺并没有"".

    public ArrayList<String> letterCombinations(String digits) {
        if(digits.length()==0){
            result.add("");
            return result;
        }else {
            String[] table = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//数字0~9依次对应的字符
            StringBuilder temp = new StringBuilder();
            dfs(table, 0, temp, digits);
            return result;
        }
    }

    /**
     *
     * @param table  数字,字符对照表
     * @param count  当前扫描到digits第几个字符
     * @param temp   当前已经拼接完成的字符串
     * @param digits 数字字符串
     */
    private void dfs(String[] table,int count,StringBuilder temp,String digits){
        if(count==digits.length()){
            if(temp.length()!=0)
                result.add(temp.toString());
        }else{
            //找出当前数字对应可能的字母
            String str=table[digits.charAt(count)-'0'];
            //对str深度搜索
            for(int i=0;i<str.length();i++){
                temp.append(String.valueOf(str.charAt(i)));
                dfs(table,count+1,temp,digits);
                temp.deleteCharAt(temp.length()-1); //深搜时,去除的都是最后一个节点.
            }
        }
    }
}
