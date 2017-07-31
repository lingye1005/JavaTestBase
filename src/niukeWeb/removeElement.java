package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/12.
 * 给定数组和目标数字.
 * 数组从前往后扫描,如果=elem,则用数组从后向前的不为elem的元素替代
 */
public class removeElement {
    public int removeElement(int[] A, int elem) {
        if(A==null || A.length==0)
            return 0;
        else{
            int len=A.length;
            int front=0;
            int rear=len-1;
            for(int i=0;front<=rear && i<len;i++){
                if(A[i]!=elem){
                    front++;
                }else{
                    while(rear>=0 && rear<len && A[rear]==elem && front<=rear){
                        rear--;
                    }
                    if(front>rear){
                        break;
                    }else{
                        A[i]=A[rear];
                        rear--;
                        front++;
                    }
                }
            }
            return front;
        }
    }

    public static void main(String[] args) {
        removeElement test=new removeElement();
        int[] a={1,2,3,4,1};
        int elem=1;
        int h=test.removeElement(a,elem);
        for(int i=0;i<h;i++){
            System.out.println(a[i]);
        }

    }
}
