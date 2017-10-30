package schooloffer16;

import java.util.*;

/**
 * Created by caoxiaohong on 17/10/29.
 * suppose you are holding your mobile phone with single hand....
 */

public class NumericKeypad {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] matrix={
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        //输入第一行:T ,测试用例个数
        int T=Integer.valueOf(scanner.nextLine().trim());
        //输入第二行:K ,每组测试用例对应的最大数字(能出现这个最大的数字,则输出这个数字,否则输出最接近这个这个数字的最大数字)
        String K;
        for(int i=0;i<T;i++){
            K=scanner.nextLine();

        }


    }
    private void getMax(int K){

    }
}
