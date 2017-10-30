package schooloffer16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoxiaohong on 17/10/25.
 * 有一个int数组arr其中只含有1、2和3，分别代表所有圆盘目前的状态，1代表左柱，2代表中柱，3代表右柱....
 * 算法思想:其实这道题主要算法思想还是和基本Hanoi2一样,就是多添加了几个状态left,right,mid,用来存放移动中的中间状态,
 * 以方便查看每次移动结束后,是否已经达到目标状态.
 */
public class Hanoi2 {
    Set<Integer> left=new HashSet<Integer>();//存放:第一根柱子上面各个盘子的编号
    Set<Integer> mid=new HashSet<Integer>();//存放:第二根竹子上面各个盘子的编号
    Set<Integer> right=new HashSet<Integer>();//存放:第三根柱子上面各个盘子的编号
    int isFind=0;//标志:找到时,移动次数是第几次
    int times=0;//递归次数:为isFind赋值

    public int chkStep(int[] arr, int n) {
        // write code here
        if(n==1 && arr[0]==1)
            return 0;
        if(n==1 && (arr[0]==2 || arr[0]==3))
            return 1;
        //初始化
        int count=n;
        while (count>0)
            left.add(count--);
        //调用递归算法
        helper(n,1,3,2,arr);
        return isFind;
    }

    /**
     * 递归移动
     * @param n 一个n个盘子
     * @param from 盘子初始位置
     * @param to 盘子要被移动到的位置
     * @param depend 移动过程中的辅助位置
     * @param arr 目标状态
     */
    private void helper(int n,int from,int to ,int depend,int[] arr){
        if(n==1){
            move(1,from,to,arr);
        }else{
            helper(n-1,from,depend,to,arr);
            move(n,from,to,arr);
            helper(n-1,depend,to,from,arr);
        }
    }

    /**
     * 移动一次
     * @param idx 当前被移动的盘子的编号
     * @param from 盘子的初始位置
     * @param to 盘子要被移动到的位置
     * @param arr 目标状态
     */
    private void move(int idx,int from,int to,int[] arr){
        if(from==1)
            left.remove(idx);
        else if(from==2)
            mid.remove(idx);
        else if(from==3)
            right.remove(idx);

        if(to==1)
            left.add(idx);
        else if(to==2)
            mid.add(idx);
        else if(to==3)
            right.add(idx);
        //是否和arr一致
        int i;
        for(i=0;i<arr.length;i++){
            if(arr[i]==1 && !left.contains(i+1))
                break;
            else if(arr[i]==2 && !mid.contains(i+1))
                break;
            else if(arr[i]==3 && !right.contains(i+1))
                break;
        }
        times++;
        if(i==arr.length)
            isFind=times;
    }

    //test code
    public static void main(String[] args) {
        Hanoi2 t=new Hanoi2();
        int[] a={3};
        System.out.println(t.chkStep(a,1));
    }
}
