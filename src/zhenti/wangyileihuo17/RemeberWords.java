package zhenti.wangyileihuo17;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 21:52
 * @ProjectName: JavaBaseTest
 * <小易记单词></>
 * 100%
 */
public class RemeberWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;//n(1 ≤ n ≤ 50)和m(1 ≤ m ≤ 50)
        while (scanner.hasNext()){
            n=scanner.nextInt();//小易一共写出了n个他能记住的单词,可能重复
            m=scanner.nextInt();//系统提供了m个不同的单词
            scanner.nextLine();//换行

            //输入记忆单词,注意:使用nextLine().split(" ")不能通过大数据,因为一行数据太多了,所以采取一个个单词输入的方式.
            Set<String> remembers=new HashSet<>();//
            String[] strs=new String[n];
            for(int i=0;i<n;i++)
                remembers.add(strs[i]=scanner.next());
            //输入系统单词
            String[] system=new String[m];
            for(int i=0;i<m;i++)
                system[i]=scanner.next();

            n=0;//作为数组索引
            for(String s:remembers){
                for(int i=0;i<m;i++){
                    if(system[i].equals(s))
                        strs[n++]=s;
                }
            }
            m=0;//作为返回结果
            for(int i=0;i<n;i++){
                int len=strs[i].length();
                m+=Math.pow(len,2);
            }
            System.out.println(m);
        }
    }
}
