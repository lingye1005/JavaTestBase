package schooloffer;

/**
 * Created by caoxiaohong on 17/9/25.
 * 给定两个有序数组arr1和arr2，两个数组长度都为N，求两个数组中所有数的上中位数。
 */
public class GetUpMedian {
    public int getUpMedian(int[] arr1, int[] arr2) {

        /**这是一种解法
        int len=arr1.length;
        int[] tmp=new int[2*len];
        System.arraycopy(arr1,0,tmp,0,len);
        System.arraycopy(arr2,0,tmp,len,len);
        Arrays.sort(tmp);
        return tmp[len-1];
         **/

        int len=arr1.length;
        int low1=0,high1=len-1;
        int low2=0,high2=len-1;
        while (low1<high1 && low2<high2){
            int mid1=(low1+high1)/2;
            int mid2=(low2+high2)/2;
            if(arr1[mid1]==arr2[mid2])
                return arr1[mid1];
            else if(arr1[mid1]>arr2[mid2]){
                high1=mid1;
                low2=mid2;
            }else{
                high2=mid2;
                low1=mid1;
            }
        }
        return Math.min(arr1[low1],arr2[low2]);
    }

    public static void main(String[] args) {
        GetUpMedian t=new GetUpMedian();
        int[] arr1 = {1,2,3,5};
        int[] arr2 = {1,4,5,6};
        System.out.println(t.getUpMedian(arr1,arr2));
    }
}
