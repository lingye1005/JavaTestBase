package zhenti.wangyixiaozhao18;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 10:53
 * @ProjectName: JavaBaseTest
 * <重排数列></>
 * 10%
 */
public class ReorderArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            for(int i=0;i<n;i++){
                int m=scanner.nextInt();
                long[] p=new long[m];
                for(int j=0;j<m;j++)
                    p[j]=scanner.nextLong();
                //判定
                //第一组判定方式:全是2的倍数,
                boolean isFind=false;
                for(int j=0;j<m;j++){
                    if(p[j]%2!=0)
                        break;
                    else if(j==m-1){
                        System.out.println("Yes");
                        isFind=true;
                        break;
                    }
                }
                if(isFind)
                    continue;
                //第二种判定方式:一半是4的倍数m/2
                for(int j=0;j<m;j++){
                    if(p[j]%4!=0)
                        break;
                    else if(j==m-1){
                        System.out.println("Yes");
                        isFind=true;
                        break;
                    }
                }
                if(isFind)
                    continue;
                //第三种判定方式:
                HashSet<Integer> set=new HashSet<>();
                //先存储2的倍数
                for(int j=0;j<m;j++){
                    if(p[j]%2==0 && p[j]%4!=0)
                        set.add(j);//set存储数据下标
                }
                //再存储4的倍数
                for(int j=0;j<m;j++){
                    if(p[j]%4==0)
                        set.add(j);
                }
                if(set.size()>=m-1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
