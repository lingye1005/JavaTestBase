package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/8.
 * 给定有序数组和查找的目标数字,返回该数字在数组中的范围下标.为什么是范围下标呢?因为数组中元素是可以重复的.
 */
public class searchRange {
    public int[] searchRange(int[] A, int target) {
        int len=A.length;
        int index= BinarySearch(A,target);
        if(index==-1){  //没有找到;
            int[] result={-1,-1};
            return result;
        }else{   //存在范围
             int low=index,high=index;
             int i=low,j=high;
             for(;i>=0 || j<len;){
                 if( i>=0 && A[i]==target)
                     i--;
                 if(j<len && A[j]==target)
                     j++;
                 if(i>=0 && j<len && A[i]!=target && A[j]!=target)
                     break;
            }

            int[] result={i+1,j-1};
            return result;
        }
    }
    //折半查找
    int BinarySearch(int[] A,int target){
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
        return -1; //没有找到
    }

    public static void main(String[] args) {
        searchRange test=new searchRange();
        int[] a={5,7,7,8,8,8,8,810};
        int b=8;
        int[] cout=test.searchRange(a,b);
        for( int i:cout)
            System.out.print(i+",");
    }
}
