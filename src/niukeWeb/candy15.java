package niukeWeb;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/5/9.
 * 牛客网15题
 * 给线性排列的孩子分糖果,而每个孩子的分数不同,分数高低由rate[]数组决定.分数高的孩子分的糖果要比其邻居孩子的多.且每个孩子最少分一颗糖果.
 * 求满足要求的分发糖果的最少数目.
 */
public class candy15 {
    //分糖果
    public int candy(int[] ratings) {
        int len=ratings.length; //每个孩子开始均分配一个糖果
        int[] candys=new int[len];//存放i孩子获得的糖果数目
        Arrays.fill(candys,1);

        //遍历数组,如果孩子节点的优先级比左边孩子高,则+1;比右边孩子节点高,再+1
        if(len==1) return 1;
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1])
                candys[i]=candys[i-1]+1;
        }

        /*计算总共需要的最少糖果数*/
        int total = candys[len-1];  //先把最后一个children的糖果数加上来
        for (int i=len-2; i>=0; --i){
            //回溯调整
            if (ratings[i] > ratings[i+1] &&  candys[i]<=candys[i+1]){
                candys[i] = candys[i+1]+1;
            }
            total += candys[i];
        }
        return total;
    }

    public static void main(String[] args) {
        candy15 test=new candy15();

        int[] rat1=new int[]{1,3,5};
        int[] rat2=new int[]{1,2,3,4,5};
        int[] rat3=new int[]{1};
        int[] rat4=new int[]{1,2};
        int[] rat5=new int[]{5,3,1};
        System.out.println(test.candy(rat1));

    }
}
