package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/7/27.
 * 给定一个int数组,里面元素可重复.返回所有肯能的子集合.并且子集合中元素排列顺序:非递减.
 * 空集合[] 肯定是一个子集合.
 * If S =[1,2,2], a solution is:
     [
         [2],
         [1],
         [1,2,2],
         [2,2],
         [1,2],
         []
     ]
 没有ac,集合内结果是正确的,就是各个数组之间并没有排序.只是数组内部是排好序的.
 */
public class SubsetsIIsubsetsWithDup {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0)
            return result;
        Arrays.sort(num);//排序
        int newArraySize=0;

        ArrayList<Integer> temp=new ArrayList<Integer>();
        result.add(temp);//任何空数组都是第一个被加入的元素;

        temp=new ArrayList<Integer>();
        temp.add(num[0]);
        result.add(temp);
        newArraySize=1;

        for (int i = 1; i < num.length; i++) {
            int size = result.size();
            if (num[i] != num[i - 1]) {
                //对于result中结果都获取一遍,最后增加一个num[i] ;再将这次新的到的所有数组存进result中
                for (int j = size-1; j>0; j--) {
                    temp = new ArrayList<Integer>(result.get(j));
                    temp.add(num[i]);
                    result.add(temp);
                }
                newArraySize = size;//更改新形成的数组的个数
            } else {
                for (int j = size - 1; j > size - 1 - newArraySize; j--) {
                    temp = new ArrayList<Integer>(result.get(j));
                    temp.add(num[i]);
                    result.add(temp);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubsetsIIsubsetsWithDup test=new SubsetsIIsubsetsWithDup();
        int[] num={1,1,2};
        ArrayList<ArrayList<Integer>> a=test.subsetsWithDup(num);
        System.out.println("111");
    }
}
