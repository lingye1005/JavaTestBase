package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 10:57
 * @ProjectName: JavaBaseTest
 * <彩色宝石项链></>
 */
public class Diamend {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.next();
            if(!str.contains("A") || !str.contains("B") || !str.contains("C") || !str.contains("D") || !str.contains("E")){
                System.out.println(0);
                continue;
            }
            int len=str.length();//长度

            int res=Integer.MIN_VALUE;

            for(int i=0;i<len;i++){
                if(str.charAt(i)<65 || str.charAt(i)>69){
                    continue;
                }

                int cnt1=-1,cnt2=-1,cnt3=-1,cnt4=-1,cnt5=-1;
                int max=len;
                for(int j=i;j<=max;j++){
                    if(j==max){
                        max=i;
                        j=0;
                    }
                    if(cnt1==-1 && str.charAt(j)>=65 && str.charAt(j)<=69){
                        cnt1=j;
                    }else if(cnt2==-1 && str.charAt(j)>=65 && str.charAt(j)<=69){
                        cnt2=j;
                    }else if(cnt3==-1 && str.charAt(j)>=65 && str.charAt(j)<=69){
                        cnt3=j;
                    }else if(cnt4==-1 && str.charAt(j)>=65 && str.charAt(j)<=69){
                        cnt4=j;
                    }else if(cnt5==-1 && str.charAt(j)>=65 && str.charAt(j)<=69){
                        cnt5=j;
                        break;
                    }
                }
                if(cnt1<cnt5){
                    res=Math.max(res,len-cnt5-1+cnt1);
                }else{
                    res=Math.max(res,cnt1-cnt5-1);
                }
            }
            System.out.println(res);
        }
    }
}
