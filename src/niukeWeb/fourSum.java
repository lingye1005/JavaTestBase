package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by caoxiaohong on 17/7/13.
 * 给定数组,数组中四个数,相加=target.求出这样的组合有多少组并返回
 * 注意:返回每组数中:各个数字从小到大排列
 */
public class fourSum {
   static  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();//结果
    ArrayList<Integer> temp=new ArrayList<Integer>();//每次临时结果

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        //num排序
        Arrays.sort(num); //源码使用的是快排算法
        if(num.length<4)
            return result;
        int len=num.length;
        int sum=0;
        for(int i=0;i<len-3;i++){
            for(int j=i+1;j<len-2;j++){
                if(num[i]+num[j]+num[j+1]+num[j+2]>target) {
                    break;
                }
                if(num[i]+num[j]+num[len-1]+num[len-2]<target){
                    continue;
                }
                int left=j+1,right=len-1;
                while(left<right){
                    sum=num[i]+num[j]+num[left]+num[right];
                    if(sum<target)
                        left++;
                    else if(sum>target)
                        right--;
                    else{
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[left]);
                        temp.add(num[right]);
                        if(!result.contains(temp)){   //保证了不存重复的组合结果
                            result.add(temp);
                        }
                        temp=new ArrayList<Integer>();
                        left++;
                        right--;
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        fourSum test=new fourSum();
        int[] a={-3,-2,-1,0,0,1,2,3};
        int target=0;
        test.fourSum(a,target);
        for(int i=0;i<result.size();i++){
            for(int j=0;j<4;j++){
                System.out.print(result.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
