package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/29.
 * 现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。请设计一个高效算法，计算数组的单调和。
 */
public class MonoSum {
    public int calcMonoSum(int[] A, int n) {
        // write code here
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(A[i]>=A[j])
                    sum+=A[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MonoSum t=new MonoSum();
        int[] a={461,533,323,533,320,191,167};
        System.out.println(t.calcMonoSum(a,7));
    }
}
