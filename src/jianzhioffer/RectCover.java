package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 实质:还是爬楼梯问题,一次可以走1步或者2步.问有多少种走法?
 * f(1)=1,f(2)=2,f(3)=3,f(4)=5...
 */
public class RectCover {
    public int RectCover(int target) {
        if(target==1)
            return 1;
        else if(target==2){
            return 2;
        }else{
            int add1=1,add2=2;
            for(int i=3;i<=target;i++){
                int tmp=add2;
                add2=add1+add2;
                add1=tmp;
            }
            return add2;
        }
    }
}
