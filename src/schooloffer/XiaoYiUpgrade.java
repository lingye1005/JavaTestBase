package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/23.
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.....
 */
public class XiaoYiUpgrade {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N;
            int M;
            N=scanner.nextInt();//怪物个数
            M=scanner.nextInt();//小易的初始能量
            int[] energy=new int[N];
            for(int i=0;i<N;i++){
                energy[i]=scanner.nextInt();
                if(M>=energy[i]){
                    M+=energy[i];
                }else{
                    M+=getNum(M,energy[i]);
                }
            }
            System.out.println(M);
        }
    }

    //最大公约数
    private static  int getNum(int a,int b){
        int tmp;
        while(b>0){
            tmp = b;
            b = a % b ;
            a = tmp;
        }
        return a;
    }
}
