package niukeWeb;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by caoxiaohong on 17/5/7.
 * 牛客网第14题
 * 给定整数数组,里面的整数除了1个数字仅仅出现1次,其他数字均出现3次.求出现1次的数字.
 * 时间复杂度O(N),用辅助空间.
 */
public class singleNumber14 {

    public int singleNumber(int[] A) {
        HashMap<Integer,Integer> record=new HashMap<Integer, Integer>();

        for(int i=0;i<A.length;i++){
            if(!record.containsKey(A[i])){
                record.put(A[i],1);
            }else {
                int temp=record.get(A[i])+1;
                record.put(A[i],temp);
            }
        }
        Iterator iterator=record.keySet().iterator();
        int re=0;
        while(iterator.hasNext()){
            int i=Integer.parseInt(iterator.next().toString());
            if(record.get(i)==1){
                re=i;
                break;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] test=new int[]{1,2,3,3,4,5,1,2,3,4,1,2,4};
        singleNumber14 t=new singleNumber14();
        System.out.println(t.singleNumber(test));
    }
}
