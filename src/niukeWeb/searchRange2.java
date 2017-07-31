package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/8.
 */
public class searchRange2 {
    public int[] searchRange(int[] A, int target) {
        int len=A.length;
        int low=0,high=len-1;
        if(A[0]>target || A[len-1]<target){
            int[] a={-1,-1};
            return a;
        }
        int front=-1,rear=-1;
        for(int i=low,j=high;i<=high && j>=0;){
            if(A[i]>target || A[j]<target ||(front!=-1 && rear!=-1)){
                break;
            }
            if(A[i]==target && front==-1) {
                front = i;
            }else if(A[i]!=target && front==-1){
                i++;
            }
            if(A[j]==target && rear==-1){
                rear=j;
            }else if(A[j]!=target && rear==-1){
                j--;
            }

        }
        if(front==-1 && rear==-1){
            int[] a={-1,-1};
            return a;
        }else if(front==-1 && rear!=-1){
            int[] a={rear,rear};
            return a;
        }else if(front!=-1 && rear==-1){
            int[] a={front,front};
            return a;
        }else{
            int[] a={front,rear};
            return a;
        }
    }

    public static void main(String[] args) {
        searchRange2 test=new searchRange2();
        int[] a={1,2,2,3,4,4,4};
        int b=4;
        int[] cout=test.searchRange(a,b);
        for( int i:cout)
            System.out.println(i+",");
    }
}
