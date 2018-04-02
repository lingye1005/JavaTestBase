package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 14:53
 * @ProjectName: JavaBaseTest
 */
public class Sum_Solution {
    //test
    public static void main(String[] args) {
        Sum_Solution t=new Sum_Solution();
        System.out.println(t.Sum_Solution(4));
    }

    public int Sum_Solution(int n) {
        return helper(n);
    }
    int helper(int num){
        int ans=0;
        boolean bool=num>0 && ((ans=helper(num-1))>0);
        return num+ans;
    }
}
