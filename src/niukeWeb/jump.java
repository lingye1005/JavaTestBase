package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/4.
 * 数组中每个数字代表在此节点处,可以跳跃步数,求从第一个点到最后一个点的最小跳数是多少.
 * 开始时,处于起始点.
 * 快慢指针法.每次循环,都能往后确定一个新的可到达区域;同时步数+1.直到可到达区域的高位边界可以达到给定数组边界,则完成.
 */
public class jump {
    int low=0,high=0,preHigh=0;//low-high为新区域上下界;preHigh为上一次可到达的区域的上界;
    int step=0; //记录步数

    public int jump(int[] A) {
       int len=A.length;
        if(len==1)
            return 0;
        while(high<len-1){
            step++;
            preHigh=high;//记录上次区域的上界;
            for(int i=low;i<=preHigh;i++){
                high=Math.max(high,i+A[i]);
            }
            low=preHigh+1;
        }
        return step;
    }


    public static void main(String[] args) {
        jump test=new jump();
        int[] a={2,3,1,1,4};
        System.out.println(test.jump(a));
    }
}
