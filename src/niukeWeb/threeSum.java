package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/7/14.
 * 给定数组,求数组中3个数字和为0的组合,且组合不重复.
 * 返回结果中单个分组的3个数字是升序排列
 */
public class threeSum {
    static ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();//结果
    ArrayList<Integer> temp=new ArrayList<Integer>();//临时存放结果

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num==null || num.length<3)
            return result;
        helper(num);
        return result;
    }

    /**
     *
     * @param num 被查找数组
     */
    private  void helper(int[] num){
        Arrays.sort(num);//先排序,升序
        int len=num.length;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){   //第一次j从1开始,后面就不是了
                int left=j+1,right=len-1;
                while(left<=right && left<len ){
                    if(num[i]+num[j]+num[left]==0){
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[left]);
                        if(!result.contains(temp))
                            result.add(temp);
                        temp=new ArrayList<Integer>();
                        break;
                    }
                    if(num[i]+num[j]+num[right]==0){
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[right]);
                        if(!result.contains(temp))
                            result.add(temp);
                        temp=new ArrayList<Integer>();
                        break;
                    }
                    if(num[i]+num[j]+num[left]<0)
                        left++;
                    if(num[i]+num[j]+num[right]>0)
                        right--;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a={3,0,-2,-1,1,2};
        threeSum test=new threeSum();
        test.threeSum(a);
        System.out.println(result.size());
    }
}
