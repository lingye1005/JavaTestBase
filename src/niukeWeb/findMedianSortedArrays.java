package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/18.
 * 找出2个有序数组的中间的数
 * 运行时间复杂度要求为:O(log (m+n)).
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lena = A.length;
        int lenb = B.length;
        int count=1;
        //从1开始存数,偶数时:a[(lena+lenb)/2]+a[(lena+lenb)/2+1] 求平均值;
        //          奇数时: a[(lena+leanb)/2+1] ;
        int[] a=new int[(lena+lenb)/2+2];
        int i,j;
        for( i=0,j=0;i<lena && j<lenb && count<(lena+lenb)/2+2;){
            if(A[i]<=B[j]){
                a[count++]=A[i];
                i++;
            }else{
                a[count++]=B[j];
                j++;
            }
        }
        if(count<(lena+lenb)/2+2){
            if(i<lena){
                while(count<(lena+lenb)/2+2){
                    a[count++]=A[i++];
                }
            }else{
                while(count<(lena+lenb)/2+2)
                    a[count++]=B[j++];
            }
        }
        if((lena+lenb)%2==0){
            double x=a[(lena+lenb)/2];
            double y=a[(lena+lenb)/2+1];
            return (x+y)/2;
        }else{
            return a[(lena+lenb)/2+1];
        }
    }

    public static void main(String[] args) {
        findMedianSortedArrays test=new findMedianSortedArrays();
        int[] a={-1,9,10};
        int[] b={2,4,4,5};
        System.out.println(test.findMedianSortedArrays(a,b));
    }
}
