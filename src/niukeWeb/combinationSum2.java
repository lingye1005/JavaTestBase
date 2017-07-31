package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/7.
 * 组合问题:一般都是dfs解决.
 * 给定数组num[],元素无序;给定target,目的和
 * 利用num[]中元素最多一次,求和=target;
 * 求一共有多少中解决方案.
 */
public class combinationSum2 {
    static  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        int index=0;
        ArrayList<Integer> currResult=new ArrayList<Integer>();
        if(target<=0)
            return result;
        //数组排序,非递减
        QuickSort(num,0,num.length-1);
        helper(num,target,0,currResult,0);
        return result;
    }
    //排序算法
    void QuickSort(int[] num,int low,int high){
        if(low<high) {  //开始忘记写if判定,出现栈溢出
            int pivot = Partion(num, low, high);
            QuickSort(num, low, pivot - 1);
            QuickSort(num, pivot + 1, high);
        }
    }
    int Partion(int[] num,int low,int high){
        int pivot=num[low];
        while(low<high){
            while(low<high && num[high]>=pivot)
                high--;
            num[low]=num[high];
            while(low<high && num[low]<=pivot)
                low++;
            num[high]=num[low];
        }
        num[low]=pivot;
        return low;
    }

    //主算法
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

            helper(num,target,i+1,currResult,sum);

            sum-=num[i];
            currResult.remove(currResult.size()-1);

            //为防止有相同的组合
            while(i+1<num.length && num[i]==num[i+1])  //不是太理解,比较难懂呃
                i++;
        }
    }

    public static void main(String[] args) {
        combinationSum2 test=new combinationSum2();
        int[] a={10,1,2,7,6,1,5};
        int t=8;
        test.combinationSum2(a,t);
        //int count=0;
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
