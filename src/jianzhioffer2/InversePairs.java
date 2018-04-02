package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 17:55
 * @ProjectName: JavaBaseTest
 */
public class InversePairs {
    public static void main(String[] args) {
        InversePairs t=new InversePairs();
        int[] ax={1,2,3,4,5,6,7,0};
        System.out.println(t.InversePairs(ax));
    }

    public int InversePairs(int[] array) {
        if(array==null || array.length==0)
            return 0;
        return mergeSort(array,0,array.length-1);
    }
    private int mergeSort(int[] array,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            int left=mergeSort(array,low,mid)%1000000007;
            int right=mergeSort(array,mid+1,high)%1000000007;
            int internal=internalNum(array,low,mid,high)%1000000007;
            left+=right;
            left%=1000000007;
            left+=internal;
            left%=1000000007;
            return left;
            //return left+right+internal;
        }else
            return 0;
    }
    private int internalNum(int[] array,int low,int mid, int high){
        int[] copy=new int[high-low+1];
        int count=0;
        int idx=high-low;
        int k1=mid,k2=high;
        //为copy赋值
        while(k1>=low && k2>=mid+1){
            if(array[k1]>array[k2]){
                //记录逆序对数
                count+=k2-mid;
                copy[idx--]=array[k1--];

                count=count%1000000007;
            }else{
                copy[idx--]=array[k2--];
            }
        }
        //处理尾部剩余元素
        while(k1>=low){
            copy[idx--]=array[k1--];
        }
        while(k2>=mid+1){
            copy[idx--]=array[k2--];
        }
        //利用copy,更新array
        idx=0;
        for(int i=low;i<=high;i++){
            array[i]=copy[idx++];
        }
        return count;
    }
}
