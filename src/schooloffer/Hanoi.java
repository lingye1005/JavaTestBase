package schooloffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/10/25.
 * 对于传统的汉诺塔游戏我们做一个拓展，我们有从大到小放置的n个圆盘，开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘
 * 都移到右边的柱子上，请实现一个函数打印最优移动轨迹。
 */
public class Hanoi {
    ArrayList<String> res=new ArrayList<String>();
    public ArrayList<String> getSolution(int n) {
        // write code here
        helper(n,"left","right","mid");
        return res;
    }

    /**
     * 递归算法
     * @param n 共计有n个盘子
     * @param from n个盘子开始所在的位置
     * @param to   n个盘子最终要被移动到的位置
     * @param midddle 中间移动过程中,需要借助的位置
     */
    private void helper(int n,String from,String to,String midddle){
        if(n==1){
            res.add("move "+"from "+from+" to "+to);//res.add("move 1"+" from "+from+" to "+to);显示是第几个盘子被移动
        }else{
            helper(n-1,from,midddle,to);
            res.add("move "+"from "+from+" to "+to);//res.add("move "+n+" from "+from+" to "+to);显示是第几个盘子被移动
            helper(n-1,midddle,to,from);
        }
    }

    public static void main(String[] args) {
        Hanoi t=new Hanoi();
        t.getSolution(2);
    }
}
