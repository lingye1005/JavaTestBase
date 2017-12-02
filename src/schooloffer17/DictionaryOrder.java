package schooloffer17;

import java.util.*;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 15:28
 * @ProjectName: JavaBaseTest
 * <字典排序></>
 * 内存超限 50%
 */
public class DictionaryOrder {
    public static void main(String[] args) {
        long n,m;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLong()) {
            n = scanner.nextLong();//n个数字排序
            m = scanner.nextLong();//查找排序后的第m个数字


            long res = 1;//从1开始数
            m--;
            while(m!=0){
                long num = 0;
                long start = res,end = res+1;//start和end分别表示范围的左右边界[start,end)
                while(start<=n){
                    num += Math.min(n+1,end)-start;//[start,end)这个范围内可以有多少个数字
                    start*=10;
                    end*=10;
                }
                if(num>m){ //如果可以表示的数字个数比还需要计算的数字个数少,则进入递归,也就是通过在res后面补0进行范围查找.
                    res *= 10;
                    m--;//res*10作为此次找到的第一个数字,故还需要计算的数字个数需要减一
                }else{
                    m-=num;//既然还需要查找的数字个数比当前范围的数字个数大,那么res通过++更改前缀,从而更改范围;同时m还需要减去当前范围内已经找到的数字个数num.
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
