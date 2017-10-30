package schooloffer16;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/10/9.
 * 对于一个无序数组，数组中元素为互不相同的整数，请返回其中最小的k个数，顺序与原数组中元素顺序一致。
 * 给定一个整数数组A及它的大小n，同时给定k，请返回其中最小的k个数
 * 先写一个时间复杂度为n*logk的吧,还有O(n)的算法,等后期在研究一下
 * 算法思想:堆排序
 */
public class KthNumbers {
    public int[] findKthNumbers(int[] A, int n, int k) {
        // write code here
        int[] kHeap=new int[k+1];
        for(int i=1;i<=k;i++){
            kHeap[i]=A[i-1];
        }
        //建堆
        buildMaxHeap(kHeap,k);
        //调整堆
        for(int i=k;i<n;i++){
            if(A[i]<kHeap[1]){
                kHeap[1]=A[i];
                adjustDown(kHeap,1,k);
            }
        }
        int[] res=new int[k];
        int idx=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=k;i++)
            list.add(kHeap[i]);
        for(int i=0;i<n;i++){
            if(list.contains(A[i]))
                res[idx++]=A[i];
        }
        return res;
    }

    /**
     * 将kHeap中0-(len-1)个元素进行调整,改为大根堆
     * @param kHeap
     * @param len
     */
    private void buildMaxHeap(int[] kHeap,int len){
        for(int i=len/2;i>0;i--){
            adjustDown(kHeap,i,len);
        }
    }
    private void adjustDown(int[] kHeap,int k,int len){
        kHeap[0]=kHeap[k];
        for(int i=2*k;i<=len;i*=2){
            if(i<len && kHeap[i]<kHeap[i+1])
                i++;
            if(kHeap[0]>=kHeap[i])
                break;
            else {
                kHeap[k]=kHeap[i];
                k=i;
            }
        }
        kHeap[k]=kHeap[0];
    }

    //test code
    public static void main(String[] args) {
        KthNumbers t=new KthNumbers();
        int[] a={3188,4522,2526,4085,1621,723,1073};
        int[] b=t.findKthNumbers(a,7,6);
    }
}
