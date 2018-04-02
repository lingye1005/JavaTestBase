package jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 12:31
 * @ProjectName: JavaBaseTest
 */
public class TopK {
    //test
    public static void main(String[] args) {
        TopK t=new TopK();
        int[] a={4,5,1,6,2,7,3,8};
        ArrayList<Integer> res=t.GetLeastNumbers_Solution(a,4);
        res.forEach(i-> System.out.print(i+","));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        if(input==null || input.length==0 || k<=0)
            return res;
        //插入前k个数字到大顶堆
        int[] heap=new int[k];
        for(int i=0;i<input.length && i<k;i++){
            insert(heap,input[i],i);
        }
        if(k>=input.length){
            Arrays.stream(heap).forEach(i->res.add(i));
            return res;
        }
        //遍历后续节点
        for(int i=k;i<input.length;i++){
            if(input[i]<heap[0]){
                heap[0]=input[i];
                delete(heap,0,k);
            }
        }
        //最终结果添加到res中
        Arrays.sort(heap);
        Arrays.stream(heap).forEach(i->res.add(i));
        return res;
    }
    //插入，最后一个索引插入，故向上调整
    private void insert(int[] input,int num,int index){
        input[index]=num;
        //向上调整位置
        int parent=(index-1)/2;
        while(input[parent]<num && parent>=0){
            swap(input,index,parent);
            index=parent;
            parent=(index-1)/2;
        }
    }
    //删除，0索引处元素被替换，故向下调整
    private void delete(int[] input,int idx,int heapSize){
        int left=idx*2+1;
        int right=idx*2+2;
        int largest=idx;
        while(left<heapSize){
            if(input[left]>input[idx])
                largest=left;
            if( right<heapSize && input[right]>input[largest])
                largest=right;
            if(input[largest]>input[idx]){
                swap(input,idx,largest);
                idx=largest;
                left=idx*2+1;
                right=idx*2+2;
            }else{
                break;
            }
        }
    }
    //元素交换
    private void swap(int[] input,int idx1,int idx2){
        int tmp=input[idx1];
        input[idx1]=input[idx2];
        input[idx2]=tmp;
    }
}
