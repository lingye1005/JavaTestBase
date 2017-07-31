package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/12.
 * 给定数组是升序排列的,移除数组中的重复元素
 */
public class removeDuplicates2 {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0)
            return 0;
        if(A.length==1)
            return 1;
        int len=A.length;
        int index=0; //index代表的是新数组的最后一个下标
        for(int i=1;i<len;i++){
            if(A[i]!=A[index]){
                index++;
                A[index]=A[i];
            }else{
                continue;
            }
        }
        return index+1;  //返回的是新数组的长度
    }

    public static void main(String[] args) {
        removeDuplicates2 test=new removeDuplicates2();
        int[] a={1,2};
        int b=test.removeDuplicates(a);
        System.out.println(b);
        for(int i=0;i<b;i++){
            System.out.println(a[i]);
        }
    }
}
