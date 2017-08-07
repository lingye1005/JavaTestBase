package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/7.
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        helper(result,new ArrayList<Integer>(),n,k,1);
        return result;
    }

    /**
     * 主要算法
     * @param result 最终结果
     * @param temp 临时子集
     * @param n 给定n个数
     * @param k  目前还需要注入k个数字
     * @param start 目前第一个数从哪里开始
     */
    private void helper(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp,int n,int k,int start){
        if(k==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }else{
            for(int i=start;i<=n;i++){
                temp.add(i);
                helper(result,temp,n,k-1,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations test=new Combinations();
        ArrayList<ArrayList<Integer>> s0=test.combine(4,2);
    }
}
