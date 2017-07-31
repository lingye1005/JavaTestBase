package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/1.
 * 给定整数数组,求连续子数组的最大和
 */
public class maxSubArray {
    public int maxSubArray(int[] A) {
        int len=A.length;
        if(len==1)
            return A[0];
        int max=A[0];
        for(int i=0;i<len;i++){
            int sum=0;
            for(int j=i;j<len;j++){
                sum+=A[j];
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArray test=new maxSubArray();
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(a));
    }
}
