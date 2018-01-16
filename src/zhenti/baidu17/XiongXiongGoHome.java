package zhenti.baidu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/7 10:35
 * @ProjectName: JavaBaseTest
 * <熊熊回家></>
 * 100%
 */
public class XiongXiongGoHome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        int a,b=0;
        while (scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine().trim());
            String[] nums=scanner.nextLine().split(" ");
            int res=Integer.MAX_VALUE;
            for(int k=1;k<n-1;k++){//跳过元素的数组索引
                int count=0;
                for(int i=1;i<n;i++){
                    if(i==k)
                        continue;
                     a=Integer.valueOf(nums[i]);
                     if(i==k+1)
                        b=Integer.valueOf(nums[i-2]);
                     else
                        b=Integer.valueOf(nums[i-1]);
                     count+=a>b?a-b:b-a;
                }
                res=Math.min(res,count);
            }
            System.out.println(res);
        }
    }
}
