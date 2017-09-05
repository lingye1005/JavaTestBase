package jianzhioffer;

import java.util.HashMap;

/**
 * Created by caoxiaohong on 17/8/29.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        double len=array.length;
        double counts=Math.floor(len/2.0);
        HashMap<Integer,Integer> value=new HashMap<Integer,Integer>();
        for(int i:array){
            if(value.containsKey(i)){
                value.put(i,value.get(i)+1);
            }else{
                value.put(i,1);
            }
            if(value.get(i)>counts)
                return i;
        }
        return 0;
    }
}
