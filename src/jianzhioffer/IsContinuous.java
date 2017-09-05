package jianzhioffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/8/31.
 * ...现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0
 * 0~13各个牌均为4张
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return false;
        int[] a=numbers;
        Arrays.sort(a);
        //没有0
        if(a[0]>0){
            if(a[4]-a[3]==1 && a[3]-a[2]==1 && a[2]-a[1]==1 && a[1]-a[0]==1)
                return true;
            else
                return false;
        }
        //1个0
        else if(a[0]==0 && a[1]>0){
            //各个数字不相同 && max-min<=4;
            if(a[1]!=a[2] && a[1]!=a[3] && a[1]!=a[4] && a[2]!=a[3] && a[2]!=a[4] && a[3]!=a[4] && (a[4]-a[1]<=4))
                return true;
            else
                return false;
        }
        //2个0
        else if(a[1]==0 && a[2]>0){
            //各个数字不相同 && max-min<=4;
            if(a[2]!=a[3] && a[2]!=a[4] && a[3]!=a[4] && (a[4]-a[2]<=4))
                return true;
            else
                return false;
        }
        //3个0
        else if(a[2]==0 && a[3]>0){
            //各个数字不相同 && max-min<=4;
            if(a[3]!=a[4] && (a[4]-a[3]<=4))
                return true;
            else
                return false;
        }
        //4个0
        else if(a[3]==0 && a[4]>0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsContinuous t=new IsContinuous();
        int[] a={1,0,0,5,0};
        System.out.println(t.isContinuous(a));
    }
}
