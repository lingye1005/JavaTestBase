package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/13.
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
 * 比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 */
public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        // write code here
        if(A==null || A.length==0)
            return 0;
        int maxArea=0;
        int from,to;//两边查找时边界
        for(int i=0;i<n;i++) {
            boolean f1=false,f2=false;
            for(from=i,to=i;;){
                if((f1 && f2) || (from<0 && to>=n))
                    break;
                if(from>=0 && A[from]>=A[i])
                    from--;
                else
                    f1=true;
                if(to<n && A[to]>=A[i])
                    to++;
                else
                    f2=true;
            }

            if(maxArea<A[i]*(to-from-1))
                maxArea=A[i]*(to-from-1);

        }
        return maxArea;
    }

    //test code
    public static void main(String[] args) {
        MaxInnerRec t=new MaxInnerRec();
        int[] a={2,7,9,4,1};
        System.out.println(t.countArea(a,5));
    }
}
