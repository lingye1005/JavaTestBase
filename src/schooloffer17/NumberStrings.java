package schooloffer17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/26 23:40
 * @ProjectName: JavaBaseTest
 * <数串></>
 */
public class NumberStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNextInt()){
            N=scanner.nextInt();
            ArrayList<String> list=new ArrayList<String>();
            for(int i=0;i<N;i++)
                list.add(String.valueOf(scanner.nextInt()));
            Collections.sort(list);
            //2次排序处理
            helper(list);

            StringBuilder sb=new StringBuilder();
            for(int i=N-1;i>=0;i--)
                sb.append(list.get(i));
            System.out.println(sb.toString());
        }
    }
    private static void  helper(ArrayList<String> list){
        int len=list.size();
        int l1,l2;
        for(int i=len-1;i>0;){
            String s1=list.get(i);
            String s2=list.get(i-1);
            l1=s1.length();
            l2=s2.length();
            if(l1>l2 && s1.indexOf(s2)==0){
                //是否交换位置
                if(Integer.valueOf(s1+s2)<Integer.valueOf(s2+s1)){ //因为每个数字<=1000,所以可以这样拼接字符串比较数字大小
                    list.set(i,s2);
                    list.set(i-1,s1);
                    i=len-1;
                }else{
                    i--;
                }
            }else{
                i--;
            }
        }
    }
}

