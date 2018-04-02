package jianzhioffer2;

import java.util.stream.IntStream;

/**
 * @Author: cxh
 * @CreateTime: 18/1/18 17:50
 * @ProjectName: JavaBaseTest
 */
public class JumpFloor2 {
    public int JumpFloorII(int target) {
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        //求出前n－1项的fabonacci
        int[] fab=new int[target];
        fab[0]=1;
        fab[1]=1;
        for(int i=2;i<target;i++){
            for(int j=0;j<i;j++)
                fab[i]+=fab[j];
        }
        //求和
        return IntStream.of(fab).sum();
    }
}
