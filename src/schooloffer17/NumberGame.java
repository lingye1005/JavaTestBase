package schooloffer17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/6 11:33.
 * <数字游戏></数字游戏>
 * 小易邀请你玩一个数字游戏...
 */
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;//输入数字个数
        while (scanner.hasNext()){
            n=scanner.nextInt();
            scanner.nextLine();//换行
            ArrayList<Integer> numbers=new ArrayList<Integer>();
            for(int i=0;i<n;i++)
                numbers.add(scanner.nextInt()); // 1 ≤ xi ≤ 100000
            Collections.sort(numbers);
            //如果最小的数字都比1大,那么就不用进行下面的计算了,直接返回1即可.因为1就是最小的不能被表达的数字.
            if(numbers.get(0)>1) {
                System.out.println(1);
                continue;
            }
            /**
             * 迭代过程:
             * 1.min表示:numbers下标从0到i的数字进行组合,能表示的数字范围:[1,min];
             * 2.新增加了数字numbers.get(i)后,要想
             *   [1,min]U[tmp]U[1+tmp,min+tmp]=[1,min+tmp],则要求:tmp<=min+1即可
             * 3.例子:
             *
             */
            int min=1; //min初始化为第一个元素的值
            int tmp;
            for(int i=1;i<n;i++){
                tmp=numbers.get(i);
                if(tmp>min+1)
                    break;
                else{
                    min += tmp;
                }
            }
            System.out.println(min+1);
        }
    }
}
