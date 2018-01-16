package zhenti.wangyineitui18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 16:47
 * @ProjectName: JavaBaseTest
 * <操作序列></>
 * 40%,大数据过不了
 */
public class OperateSequence {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();//整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
            int[] a=new int[n];//n个整数a_i(1 ≤ a_i ≤ 10^9)
            for(int i=0;i<n;i++)
                a[i]=scanner.nextInt();
            StringBuilder res=new StringBuilder();
            for(int i=0;i<n;i++){
                res.append(a[i]);
                //逆置
                res=reverse(res);
            }
            for(int i=0;i<n-1;i++)
                System.out.print(res.charAt(i)+" ");
            System.out.println(res.charAt(n-1));
        }
    }
    private static StringBuilder reverse(StringBuilder sb){
        int len=sb.length();
        for(int i=0;i<len/2;i++){
            char tmp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(len-1-i));
            sb.setCharAt(len-1-i,tmp);
        }
        return sb;
    }
}
