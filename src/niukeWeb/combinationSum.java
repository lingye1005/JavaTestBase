package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caoxiaohong on 17/7/7.
 * 当然,这道题已经ac了
 * 刷题遇到问题:如果变量被声明为static类型,则会提示:算法超时.所以以后在牛客网写算法,注意不能声明static类型的变量.为什么,不太清楚.
 */
public class combinationSum {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> currResult=new ArrayList<Integer>();
        if(target<=0)
            return result;
        //数组排序,非递减
        Arrays.sort(candidates);
        //QuickSort(candidates,0,candidates.length-1);
        helper(candidates,target,0,currResult,0);
        return result;
    }

    /**
     * 主函数:dfs
     * @param num 原数组
     * @param target 目标和
     * @param index 当前遍历下的数组下标
     * @param currResult 当前遍历的临时结果集
     * @param sum  当前遍历下的和
     */
    private void helper(int[] num,int target,int index,ArrayList<Integer> currResult,int sum){
        if(target<sum)
            return ;
        if(target==sum) {
            //说明:为什么要重新声明一个变量temp?以下连续4行代码都是为此目的服务的.
            //因为:如果不重新申请一块内存,那么后面的for循环代码在修改currResult时,会导致result中刚刚新添加的currResult也会改变,导致rsult结果在保存后出现错误.
            //所以必须重新申请一块java堆空间,保存currResult的值.
            //这一点尤其要注意,容易忘记.
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<currResult.size();i++){
                temp.add(currResult.get(i));
            }
            result.add(temp);
            return; //总是忘记写
        }
        for(int i=index;i<num.length;i++){
            sum+=num[i];
            currResult.add(num[i]);

            helper(num,target,i,currResult,sum);

            sum-=num[i];
            currResult.remove(currResult.size()-1);
        }
    }

    /**
     *  测试函数main
     * @param args
     */
    public static void main(String[] args) {
        combinationSum test=new combinationSum();
        int[] a={2,3,6,7};
        int t=7;
        test.combinationSum(a,t);
        //int count=0;
        System.out.println(test.result.size());
        for(int i=0;i<test.result.size();i++){
            for(int j=0;j<test.result.get(i).size();j++){
                System.out.print(test.result.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
