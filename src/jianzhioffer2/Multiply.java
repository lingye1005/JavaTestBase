package jianzhioffer2;

import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 17:17
 * @ProjectName: JavaBaseTest
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if(A==null || A.length==0)
            return null;
        int[] res=new int[A.length];
        Arrays.setAll(res,i->{
            int num=1;
            for(int j=0;j<A.length;j++){
                if(j!=i)
                    num*=A[j];
            }
            return num;
        });

        return res;
    }
    //书上解法:
    /*
    public int[] multiply(int[] A) {
        if(A==null || A.length==0)
            return null;
        int len=A.length;
        int[] res=new int[len];
        res[0]=1;
        //从上到下相乘
        for(int i=1;i<len;i++){
            res[i]=res[i-1]*A[i-1];
        }
        //从下到上相乘
        int tmp=1;
        for(int i=len-2;i>=0;i--){
            tmp*=A[i+1];
            res[i]*=tmp;
        }
        return res;
    }
    */
}
