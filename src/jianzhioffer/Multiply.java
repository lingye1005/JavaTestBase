package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if(A==null || A.length==0)
            return null;
        int len=A.length;
        int[] result=new int[len];
        for(int i=0;i<len;i++){//为result[i]赋值
            int mul=1;
            for(int j=0;j<len;j++){
                if(i!=j){
                    mul*=A[j];
                }
            }
            result[i]=mul;
        }
        return result;
    }
}
