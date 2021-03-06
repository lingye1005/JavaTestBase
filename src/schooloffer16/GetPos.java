package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/11.
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 */
public class GetPos {
    public int getPos(int[] A, int n, int val) {
        if(A==null || n<=0)
            return -1;
        int low=0,high=n-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid]==val) {
                while(mid-1>=low && A[mid-1]==val)
                    mid--;
                return mid;
            }
            else if(A[mid]<val)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        GetPos t=new GetPos();
        int[] a={4,4,28,33};
        System.out.println(t.getPos(a,4,4));
    }
}
