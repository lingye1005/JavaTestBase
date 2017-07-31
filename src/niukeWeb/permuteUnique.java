package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/7/4.
 *给定数组num,里面的数值可以重复.求数组中所有元素的全排列.
 * 字典序法,回溯法.
 * 根据字典序法,需要先对数组元素进行排序
 * n个元素进行全排列,最多有n!个排序,故此题还需要使用递归算法,求出n!
 */
public class permuteUnique {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num); //排序
        //字典表法,全排列是从小到大的数字的集合
        //首先,排好序的初始数组是全排列当中最小的.故先加入

        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i:num){
            list.add(i);
        }
        result.add(list); //此时返回结果包含了:全排列所有情况中的最小的组合情况

        //每次循环新增一个排列结果
        for(int i=1;i<factorial(num.length);i++){
            nextPermutation(num);
        }
        return result;
    }
    //求n!
    int factorial(int n){
        return n==0?1:n*factorial(n-1);
    }

    private void nextPermutation(int[] num){
        int len=num.length;
        //找到num数组最右侧的正序:(i-1)~i是正序,i~nun.length-1是逆序
        int i=len-1;
        while(i>0 && num[i-1]>=num[i]){
            i--;
        }
        if(i<=0)
            return;  //num[0]~num[len-1]为逆序,所有全排列情况查找结束.算法结束

        //找出num数组最右侧比num[i-1]大的数字,用j来记录
        int j=len-1;
        while(j>=i && num[j]<=num[i-1]){
            j--;
        }

        //交换num[i-1]和num[j]的值
        int temp=num[i-1];
        num[i-1]=num[j];
        num[j]=temp;

        //对数组num中:(i-1)~num.length-1 的元素排为正序 ;;;这一步保证了新出现的排列数与上一个排列数差值最小.
        Arrays.sort(num,i,len);

        //新的结果添加到返回结果中
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int k:num){
            list.add(k);
        }
        result.add(list);
    }

    public static void main(String[] args) {
        permuteUnique test=new permuteUnique();
        int[] a={1,2,3};
        ArrayList<ArrayList<Integer>> out=test.permuteUnique(a);
        for(ArrayList i:out){
            System.out.print(i);
            System.out.println();
        }
    }
}
