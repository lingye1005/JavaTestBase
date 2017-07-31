package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/24.
 * 红白蓝颜色排序,相同颜色排列到一起.
 */
public class sortColors {
    boolean flag;
    public void sortColors(int[] A) {
        if(A==null)
            return;
        bubbleSort(A);
    }
    //冒泡排序
    void bubbleSort(int[] A){
        int len=A.length;
        for(int i=0;i<len-1;i++){
            flag=false;
            for(int j=len-1;j>i;j--){
                if(A[j-1]>A[j]){
                    int temp=A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                    flag=true;
                }
            }
            if(flag==false)
                break;
        }
    }

    public static void main(String[] args) {
        sortColors test=new sortColors();
        int[] a=new int[]{0,2,1};
        test.sortColors(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
