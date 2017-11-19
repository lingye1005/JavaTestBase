package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/15 16:55.
 * <连续最大和></>
 */
public class MaxConsistentSum {
   static  int n;
   static  int res=Integer.MIN_VALUE;
   static  int max=0;
   static  boolean isNegnative=true;//是否全是负数
   static  int maxNeg=Integer.MIN_VALUE;//记录最大的负数

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            res=Integer.MIN_VALUE;
            max=0;
            isNegnative=true;//是否全是负数
            maxNeg=Integer.MIN_VALUE;//记录最大的负数
            for(int i=0;i<n;i++){
                int tmp=scanner.nextInt();
                if(isNegnative && tmp<0){
                    maxNeg=Math.max(maxNeg,tmp);
                }else if(tmp>=0){
                    isNegnative=false;
                }
                if(max+tmp>=0){
                    max+=tmp;
                    res=Math.max(res,max);
                }else{
                    res=Math.max(res,max);
                    max=0;
                }
            }
            //如果全是负数
            if(isNegnative){
                System.out.println(maxNeg);
            }else{ //有正数
                System.out.println(res);
            }
        }
    }
}
