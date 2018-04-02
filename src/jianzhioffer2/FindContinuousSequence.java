package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 23:33
 * @ProjectName: JavaBaseTest
 */
public class FindContinuousSequence {
    //test
    public static void main(String[] args) {
        FindContinuousSequence t=new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> res=t.FindContinuousSequence(100);
        res.forEach(list->{
            list.forEach(i-> System.out.print(i+","));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(sum<=0)
            return res;
        int small=1,big=2;
        int preSum=3;//用于记录所有的数值和,这样就不用总是求[small,big]的总和了,提高性能.
        while(small<=sum/2){
            if(preSum<sum){
                big++;
                preSum+=big;
            }else if(preSum>sum){
                small++;
                preSum-=small-1;
            }else{
                ArrayList<Integer> tmp=new ArrayList<>();
                for(int i=small;i<=big;i++)
                    tmp.add(i);
                res.add(tmp);

                small++;
                preSum-=small-1;
            }
        }
        return res;
    }
}
