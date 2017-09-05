package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0)
            return 0;
        int len=array.length;
        if(array[0]>k || array[len-1]<k)
            return 0;
        int low=0,high=len-1;
        int mid=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(array[mid]==k){
                break;
            }else if(array[mid]>k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        if(low<=high){
            int count=1;
            int front=mid-1,rear=mid+1;
            while(front>=0 && array[front]==k){
                count++;
                front--;
            }
            while (rear<len && array[rear]==k){
                count++;
                rear++;
            }
            return count;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        GetNumberOfK t=new GetNumberOfK();
        int[] a={1,3,3,3,3,4,5};
        System.out.println(t.GetNumberOfK(a,2));
    }
}
