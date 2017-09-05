package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //冒泡排序
        if(array==null || array.length==0)
            return;
        int size=array.length;
        for(int i=0;i<size;i++){
            boolean flag=false;
            for(int j=size-1;j>i;j--){
                if(array[j]%2==1 && array[j-1]%2==0){
                    int tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
    }

    public static void main(String[] args) {
        ReOrderArray test=new ReOrderArray();
        int[] a={4,2,1,2,9,0,11};
        test.reOrderArray(a);
        for(int i:a)
            System.out.println(i);
    }
}
