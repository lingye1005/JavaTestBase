package schooloffer;

/**
 * Created by caoxiaohong on 17/10/10.
 * 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。
 * 求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
 */
public class FindMaxGap {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int min=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            int lmax=getMax(A,0,i);
            int rmax=getMax(A,i+1,n-1);
            int a=lmax-rmax;
            min=min>Math.abs(a)?min:Math.abs(a);
        }
        return min;
    }

    /**
     * 获取数组A中,下标从from到to范围内的最大值(索引包含from和to)
     * @param A
     * @param from
     * @param to
     * @return
     */
    private int getMax(int[] A,int from,int to){
        int max=A[from];
        for(int i=from+1;i<=to;i++){
            if(A[i]>max)
                max=A[i];
        }
        return max;
    }

    //test
    public static void main(String[] args) {
        FindMaxGap t=new FindMaxGap();
        int[] a={95,73,15,94,78};
        System.out.println(t.findMaxGap(a,5));
    }
}
