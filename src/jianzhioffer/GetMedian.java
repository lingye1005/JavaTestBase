package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by caoxiaohong on 17/9/2.
 */
public class GetMedian {
    ArrayList<Integer> result=new ArrayList<Integer>();
    public void Insert(Integer num) {
        result.add(num);
    }

    public Double GetMedian() {
        int len=result.size();
        Collections.sort(result);
        if(len%2==0){
            int idx1=len/2;
            int idx2=len/2-1;
            return (result.get(idx1)+result.get(idx2))/2.0;
        }else{
            int idx=len/2;
            return Double.valueOf(result.get(idx));
        }
    }
}
