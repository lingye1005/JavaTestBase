package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 17:07
 * @ProjectName: JavaBaseTest
 * <幸运数字></>
 * 注意:这个题目要求的数字都是正数,不包括0,这一点题目没有表述清楚.
 */
public class LuckyNumber {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            int res=0;
            for(int i=0;i<=n;i++){
                if(sumTenCarry(i)==sumTwoCarry(i))
                    res+=1;
            }
            System.out.println(res);
        }
    }

    private static int sumTenCarry(int num){
        String str=String.valueOf(num);
        int len=str.length();
        int res=0;
        for(int i=0;i<len;i++){
            res+=str.charAt(i)-48;
        }
        return res;
    }

    private static int sumTwoCarry(int num){
        int res=0;
        while (num!=0){
            res+=num%2;
            num=num>>1;
        }
        return res;
    }
}
