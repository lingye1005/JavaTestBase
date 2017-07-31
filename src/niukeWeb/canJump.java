package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/30.
 * 动态规划
 */
public class canJump {
    public boolean canJump(int[] A) {
        int maxCover=0;//覆盖范围
        int len=A.length;
        for(int i=0;i<len-1;i++){
            if(maxCover<i)  //覆盖范围能否到达当前节点,到不了,则不能继续走下去
                return false;
            if(maxCover<i+A[i])  //到达i节点后,查看是否需要修改最大覆盖范围
                maxCover=i+A[i];
        }
        return maxCover>=len-1;
    }

    public static void main(String[] args) {
        canJump test=new canJump();
        int[] a=new int[]{2,0,0};
        int[] b=new int[]{3,2,1,0,4};
        System.out.println(test.canJump(a));
        System.out.println(test.canJump(b));
    }
}
