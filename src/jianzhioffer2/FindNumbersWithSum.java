package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 23:04
 * @ProjectName: JavaBaseTest
 */
public class FindNumbersWithSum {

    //test
    public static void main(String[] args) {
        FindNumbersWithSum t=new FindNumbersWithSum();
        int[] a={1,4,6,7,9,13};
        ArrayList<Integer> res=t.FindNumbersWithSum(a,13);
        res.forEach(i-> System.out.println(i));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        int low=0,high=array.length-1;
        while(low<high){
            int sum0=array[low]+array[high];
            if(sum0==sum){
                if(list.size()==0){
                    list.add(array[low]);
                    list.add(array[high]);
                }else{
                    if(list.get(0)*list.get(1)>array[low]*array[high]){
                        list.clear();
                        list.add(array[low]);
                        list.add(array[high]);
                    }
                }
                low++;
                high--;
            }else if(sum0>sum){
                high--;
            }else{
                low++;
            }
        }
        return list;
    }

}
