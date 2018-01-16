package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 18:15
 * @ProjectName: JavaBaseTest
 * <赶去公司></>
 * 50%
 */
public class GoToCompany {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;//打车位置有几个
        int walkTime,taxTime;//走路时间,打车时间
        int companyX,companyY;//公司坐标
        //int res;//输出结果
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[] xi=new int[n];
            int[] yi=new int[n];
            for(int i=0;i<n;i++){
                xi[i]=scanner.nextInt();
                yi[i]=scanner.nextInt();
            }
            companyX=scanner.nextInt();
            companyY=scanner.nextInt();
            walkTime=scanner.nextInt();
            taxTime=scanner.nextInt();

            //走路
            int res1;
            res1=(Math.abs(companyX)+Math.abs(companyY))*walkTime;

            //打车
            int res2=Integer.MAX_VALUE;
            int walk,tax;
            for(int i=0;i<n;i++){
                walk=(Math.abs(xi[i])+Math.abs(yi[i]))*walkTime;
                tax=(Math.abs(xi[i]-companyX)+Math.abs(yi[i]-companyY))*taxTime;
                res2=Math.min(res2,walk+tax);
            }
            System.out.println(res1<res2?res1:res2);
//            res=0;
//            if(walkTime>taxTime){//打车快
//                //找到第一个打车点
//                int x=xi[0],y=yi[0];
//                for(int i=1;i<n;i++){
//                    if(Math.pow(xi[i],2)+Math.pow(yi[i],2)<Math.pow(x,2)+Math.pow(y,2)){
//                        x=xi[i];
//                        y=yi[i];
//                    }
//                }
//                res+=(Math.abs(x)+Math.abs(y))*walkTime;
//                res+=(Math.abs(x-companyX)+Math.abs(y-companyY))*taxTime;
//            }else{
//                res+=(Math.abs(companyX)+Math.abs(companyY))*walkTime;
//            }
//            System.out.println(res);
        }
    }
}
