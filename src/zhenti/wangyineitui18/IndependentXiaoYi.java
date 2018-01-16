package zhenti.wangyineitui18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 17:04
 * @ProjectName: JavaBaseTest
 * <独立的小易></>
 * 100%
 */
public class IndependentXiaoYi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x,s,d,p;
        while(scanner.hasNextInt()){
            //x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9)
            x=scanner.nextInt();//住宿x元/天
            s=scanner.nextInt();//已有水果s个
            d=scanner.nextInt();//有钱d元
            p=scanner.nextInt();//水果p元/个
            int res=0;
            //是否可以先消耗尽已有苹果
            if(d>=s*x) {
                res = s;
                d-=s*x;
                s=0;
            }
            //此后每天买一个苹果住一天
            while(d>0){
                //有苹果
                if(s<=0){
                    if(d-p>=0){
                        d-=p;
                    }else{
                        break;
                    }
                }else{
                    s--;
                }
                //有住宿
                if(d-x<0)
                    break;
                d-=x;
                res++;
            }
            System.out.println(res);
        }
    }
}
