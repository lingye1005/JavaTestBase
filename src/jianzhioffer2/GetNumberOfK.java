package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 18:49
 * @ProjectName: JavaBaseTest
 */
public class GetNumberOfK {

    //TEST
    public static void main(String[] args) {
        GetNumberOfK t=new GetNumberOfK();
        int[] a={1,3,5,7,0,-1,4,4,7,8,8,8,8,9};
        System.out.println(t.GetNumberOfK(a,7));
    }

    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0 )
            return 0;
        int start=getFirstK(array,k,0,array.length-1);
        int end=getLastK(array,k,0,array.length-1);
        if(start==end && end==-1)
            return 0;
        else if(start==-1 && end!=-1)
            return 1;
        else if(start!=-1 && end==-1)
            return 1;
        else
            return end-start+1;
    }
    //获取第一个k
    private int getFirstK(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(array[mid]==k){
            if(mid==0 || (mid-1>=0 && array[mid-1]!=k))
                return mid;
            else{
                end=mid-1;
            }
        }else if(array[mid]<k){
            start=mid+1;
        }else{
            end=mid-1;
        }
        return getFirstK(array,k,start,end);
    }
    //获取最后一个ke
    private int getLastK(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(array[mid]==k){
            if(mid==array.length-1 || (mid+1<array.length && array[mid+1]!=k)){
                return mid;
            }else{
                start=mid+1;
            }
        }else if(array[mid]<k){
            start=mid+1;
        }else{
            end=mid-1;
        }
        return getLastK(array,k,start,end);
    }
}
