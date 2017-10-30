package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/16.
 * A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。
 * 这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任一时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？
 * 输入: 四个整数:p q l r
 * 连续p行:a,b对
 * 连续q行:c,d对
 */
public class Chatting {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int p,q,l,r;
        while (scanner.hasNext()){
            p=scanner.nextInt();
            q=scanner.nextInt();
            l=scanner.nextInt();
            r=scanner.nextInt();

            int[][] pin=new int[p][2];
            int[][] qin=new int[q][2];

            for(int i=0;i<p;i++){
                pin[i][0]=scanner.nextInt();//p开始时间
                pin[i][1]=scanner.nextInt();//p结束时间
            }
            for(int i=0;i<q;i++){
                qin[i][0]=scanner.nextInt();//q开始时间
                qin[i][1]=scanner.nextInt();//q结束时间
            }

            int count=0;
            for(int i=l;i<=r;i++){//求有多少个不同的i值
                boolean flag=false;
                for(int j=0;j<q;j++){
                    int from1=qin[j][0]+i;
                    int to1=qin[j][1]+i;
                    for(int k=0;k<p;k++){
                        int from2=pin[k][0];
                        int to2=pin[k][1];
                        if(isIntersection(from1,to1,from2,to2)) {
                            count++;
                            flag=true;
                            break;
                        }
                    }
                    if (flag)
                        break;
                }
            }
            System.out.println(count);
        }
    }

    //判定两个范围有交集:
    static boolean isIntersection(int from1,int to1,int from2,int to2){
        if(to1<from2 || to2<from1)
            return false;
        return true;
        //
//        if((from1<=to2 && from2>=from1 && to1>=to2)||(from1<=from2 && from2<=to1 && to1<=to2) ||
//                (from1<=from2 && to1>=to2) || (from2<=from1 && to1<=to2))
//            return true;
//        return false;
    }
}
