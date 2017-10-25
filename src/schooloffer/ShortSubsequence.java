package schooloffer;

/**
 * Created by caoxiaohong on 17/10/11.
 * 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
 * 算法思想:
 * 首先默认元素A[0]为最大值，然后依次向后扫描，如果当前值比最大值大，则更新当前最大值，并且说明数据从开始位置到目前位置呈现上升趋势，尚没有元素需要排序；
 * 如果当前值比最大值小，则说明数据的上升趋势中断，出现了下降的“拐点”，与此同时需要排序的元素业已出现，继续向后扫描，如果当前值依然比最大值小，那么这个元素依旧是需要排序的元素，
 * 但如果当前值比最大值大，则说明数据恢复了之前的上升趋势并且创造了新的顶点，到此为止，需要排序元素的终点我们就找到了。同理可以寻找待排序元素的起点
 */
public class ShortSubsequence {
    public int findShortest(int[] A, int n) {
        // write code here
        //找出需要排序的终点下标
        int end=-1;
        int max=A[0];
        for(int i=1;i<n;i++){
            if(A[i]>=max)
                max=A[i];
            else
                end=i;
        }
        if(end==-1)
            return 0;
        //找出需要排序的起点下标
        int from=0;
        int min=A[n-1];
        for(int i=n-2;i>=0;i--){
            if(A[i]<=min)
                min=A[i];
            else
                from=i;
        }
        return end-from+1;
    }


    public static void main(String[] args) {
        ShortSubsequence t=new ShortSubsequence();
        int[] a={1,2,3,3,8,9};
        System.out.println(t.findShortest(a,6));
    }
}
