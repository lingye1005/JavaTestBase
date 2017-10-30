package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/12.
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 给定数组A及它的大小n，请返回最大差值。
 */
public class GetDis {
    public int getDis(int[] A, int n) {
        // write code here
        if(A==null || A.length==0)
            return 0;
        int max=0;
        int len=A.length;
        for(int i=0;i<len;i++){
            int maxj=A[i];
            for(int j=i+1;j<len;j++){
                if(A[j]>maxj)
                    maxj=A[j];
            }
            if(maxj-A[i]>max)
                max=maxj-A[i];
        }
        return max;
    }
}
