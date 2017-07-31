package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/8.
 * 给定有序数组和待插入数字,返回数字应该被插入的数组下标
 */
public class searchInsert {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A,target);
    }
    //折半查找
    int binarySearch(int[] A,int target){
        int low=0,high=A.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(target==A[mid])
                return mid;
            else if(target>A[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return high+1; //为什么是high+1呢?因为如果是上限超了,则high=A.length-1;如果是下限超了,则high=-1;所以不管是上限还是下限超了,都适用high+1;
    }

    public static void main(String[] args) {
        searchInsert test=new searchInsert();
        int[] a={2,3,4,8};
        System.out.println(test.searchInsert(a,6));
    }
}
