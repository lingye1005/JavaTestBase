package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/12.
 * 给定数字n,表示可以表示的完整括号,然后列举出所有可能的例子:
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class generateParenthesis {
    private ArrayList<String> result=new ArrayList<String>();//存放结果

    public ArrayList<String> generateParenthesis(int n) {
        if(n<1)
            return result;
        while(n>0){
            helper("",n,0);
        }
        return result;
    }

    /**
     * 辅助函数
     * @param str 原字符串
     * @param left str剩余左括号个数
     * @param right str未匹配的右括号个数
     */
    private void helper(String str, int left, int right) {
        if(left==0 && right==0) {
            result.add(str);
            return;
        }
        if(left>0){
            String s=str+"(";
            helper(s,left-1,right+1);
        }
        if(right>0){
            String s=str+")";
            helper(s,left,right-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis test=new generateParenthesis();
        test.generateParenthesis(3);
    }
}
