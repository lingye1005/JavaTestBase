package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/23.
 * 合并两个有序数组成为一个有序数组:升序
 */
public class merge {
    public void merge(int A[], int m, int B[], int n) {
        int a=0,b=0;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        while(a<m && b<n){
            if(A[a]>B[b]){
                temp.add(B[b]);
                b++;
            }else{
                temp.add(A[a]);
                a++;
            }
        }
        if(a<m-1){
            for(int j=a;j<m;j++){
                temp.add(A[j]);
            }
        }
        if(b<n-1){
            for(int j=b;j<n;j++){
                temp.add(B[j]);
            }
        }
        //将arraylist值赋值为A[]
        int index=0;
        for(int i:temp){
            A[index++]=i;
        }
    }
}
