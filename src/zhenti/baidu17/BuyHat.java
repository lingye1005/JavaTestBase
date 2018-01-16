package zhenti.baidu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/7 09:47
 * @ProjectName: JavaBaseTest
 * <买帽子></>
 * 100%
 */
public class BuyHat {
    static int a,b,c;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNext()){
            N=Integer.valueOf(scanner.nextLine().trim());
            a=0;
            b=0;
            c=0;//a>b>c
            String[] nums=scanner.nextLine().split(" ");
            for(int i=0;i<N ;i++){
                int num=Integer.valueOf(nums[i]);
                set(a,b,c,num);
            }
            if(a!=0 && b!=0 && c!=0)
                System.out.println(c);
            else
                System.out.println(-1);
        }
    }
    private static void set(int x,int y,int z,int inNum){
        if(x==0)
            a=inNum;
        else if(y==0 && x!=inNum)
            b=inNum;
        else if(y!=0 && z==0 && x!=inNum && y!=inNum)
            c=inNum;
        else if(x!=0 && y!=0 && z!=0){ //输入数据是否替换x,y,z
           if(inNum<a){
               c=b;
               b=a;
               a=inNum;
           }else if(inNum>a && inNum<b){
               c=b;
               b=inNum;
           }else if(inNum>b && inNum<c){
               c=inNum;
           }
        }
    }
}
