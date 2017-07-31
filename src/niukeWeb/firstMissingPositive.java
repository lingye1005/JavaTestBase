package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/7.
 * 给定整数数组,无序,包含正负数.
 * 求正数中,缺失的第一个不连续的数字.
 * 因为时间要求为O(n),故没法用排序等,只能遍历一遍就得出结论
 * 思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;
        int len=A.length;
        int i=0;
        while(i<len){
            if(A[i]!=i+1 && A[i]>=1 && A[i]<=len && A[A[i]-1]!=A[i]){
                //交换A[A[i]-1]和A[i]的值,每次交换保证一个数据放到了正确的为止:i放到i+1的位置;
                //推导过程如下:
                //int temp=A[i]=n;
                //A[i]=A[A[i]-1]=A[n-1];
                //A[A[i]-1]=A[n-1]=n;
                int temp=A[i];
                A[i]=A[A[i]-1];
                A[temp-1]=temp;//保证了A[n-1]存放了n这个数字;
            }else{
                i++;
            }
        }
        for(int j=0;j<len;j++){
            if(A[j]!=j+1)
                return j+1;
        }
        return len+1;
    }

    public static void main(String[] args) {
        firstMissingPositive test=new firstMissingPositive();
        int[] a={3,4,-1,1};
        System.out.println(test.firstMissingPositive(a));
    }
}
