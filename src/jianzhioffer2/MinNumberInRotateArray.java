package jianzhioffer2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: cxh
 * @CreateTime: 18/1/17 22:13
 * @ProjectName: JavaBaseTest
 */
public class MinNumberInRotateArray {
    /**
     * 使用lambda表达式的方式
    public int minNumberInRotateArray(int [] array) {
        List<Integer> list= IntStream.of(array).boxed().collect(Collectors.toList());
        return list.stream().min(Integer::compareTo).get();
    }
     **/

    /**
     * 考虑最全面的方法
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array){
        int len=array.length;
        int from=0,end=len-1;
        int mid=from;//
        while(array[from]>=array[end]){//while循环条件和mid=from搭配使用.如果while不执行,则直接使用mid值.
            if(from+1==end){//循环跳出条件
                mid=end;
                break;
            }
            mid=(from+end)/2;
            if(array[mid]==array[from] && array[mid]==array[end])//此时只能使用顺序查找
                return seqSearch(array,from,end);
            if(array[mid]>=array[from])
                from=mid;
            else if(array[mid]<=array[end])
                end=mid;
        }
        return array[mid];
    }
    //顺序查找
    private int seqSearch(int[] array,int from,int to){
        List<Integer>  list= IntStream.of(array).boxed().collect(Collectors.toList());
        return list.stream().min(Integer::compareTo).get();
    }
    //test
    public static void main(String[] args) {
        MinNumberInRotateArray test=new MinNumberInRotateArray();
        int a= test.minNumberInRotateArray(new int[]{0,1,1,1,1});
        System.out.println(a);
    }
}
