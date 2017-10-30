package schooloffer16;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by caoxiaohong on 17/9/19.
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），一只狼从x号洞开始找,下次隔一个洞找(即在x＋2号洞找)，在下次个两个洞找(即在x＋5号洞找)，它找了n次仍然没有找到。问兔子可能在那些洞中。
 */
public class RabbitNest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x,n;//开始查找洞口号,查找次数
        while (scanner.hasNext()){
            int[] nests=new int[20];//0-20
            Arrays.fill(nests,0);

            x=scanner.nextInt();
            n=scanner.nextInt();
            int idx=x-1;//数组下标:0~19
            for(int i=1;i<=n;i++){
                if(idx>19){
                    idx=idx%20;
                }
                nests[idx]=-1;
                idx=idx+i+1;
            }
            //查找可能存在的窝
            boolean ifFind=false;
            for(int i=0;i<20;i++){
                if(nests[i]==0){
                    int tmp=i+1;
                    System.out.print(tmp+" ");
                    ifFind=true;
                }
            }
            if(!ifFind)
                System.out.println(-1);
            System.out.println(-1);
        }
    }
}
