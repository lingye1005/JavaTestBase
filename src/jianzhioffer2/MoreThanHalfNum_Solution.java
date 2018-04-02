package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 11:39
 * @ProjectName: JavaBaseTest
 */
public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        MoreThanHalfNum_Solution test=new MoreThanHalfNum_Solution();
        int[] xx={1,2,3,2,2,2,5,4,2};
        System.out.println(test.MoreThanHalfNum_Solution(xx));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        //合法性检查
        if(array==null || array.length==0)
            return 0;
        //查找可能的中位数
        int num=array[0],count=1;
        for(int i=1;i<array.length;i++){
            if(array[i]==num)
                count++;
            else{
                count--;
                if(count==0){
                    num=array[i];
                    count=1;
                }
            }
        }
        //验证是否一定是超过一半的数字
        if(isHalf(array,num))
            return num;
        else
            return 0;
    }
    private boolean isHalf(int[] array,int num){
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==num)
                count++;
        }
        return count>Math.floor(array.length/2);
    }
}
