package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/27.
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 */
public class AscentSequence {
    public int findLongest(int[] A, int n) {
        // write code here
        int B[]=new int[n];//!!!!! 注意。这个最后的B[]不是LIS，它只是存储的对应长度LIS的最小末尾。有了这个末尾，我们就可以一个一个地插入数据。
        int left, right, mid, len;
        len=0;

        B[0]=A[0];
        for(int i=1;i<n;i++){//遍历A每一个元素,时间复杂度:O(n)
            left=0;
            right=len;
            while(left<=right){ //插入数据A[i]到B[]中,因为B是有序的,所以插入时使用二分查找,替换数据,或者在B[]结尾增加一个数据,故时间复杂度:O(logN);
                mid=(left+right)/2;
                if(B[mid]<A[i])
                    left=mid+1;
                else
                    right=mid-1;
            }
            B[left]=A[i];//left取值范围:0~len+1,其中0~len为替换数据,而len+1为在结尾处增加一个数据.
            if(left>len)
                len++;
        }
        return len+1;//B[0]~B[len]为插入数据,故长度为len+1

    }

    public static void main(String[] args) {
        AscentSequence t=new AscentSequence();
        int[] a={2,1,4,3,1,5,6};
        System.out.println(t.findLongest(a,7));
    }
}
