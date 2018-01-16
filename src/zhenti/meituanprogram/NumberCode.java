package zhenti.meituanprogram;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/13 09:48
 * @ProjectName: JavaBaseTest
 * 50%超时
 */
public class NumberCode {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int l,r;
            l=scanner.nextInt();
            r=scanner.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();//结果记录
            for(int i=1;i<10;i++){
                map.put(i,0);
            }

            for(int i=l;i<=r;i++){
                for(int j=1;j<=Math.sqrt(i);j++){
                    //处理
                    if(i%j==0){
                        int key1=getHighestNum(j);
                        map.put(key1,map.get(key1)+1);
                        int key2=getHighestNum(i/j);
                        if(j!=i/j)
                            map.put(key2,map.get(key2)+1);
                    }
                }
            }

            //输出
            for(int i=1;i<10;i++){
                System.out.println(map.get(i));
            }
        }
    }
    private static int getHighestNum(int num){
        String str=String.valueOf(num);
        return Integer.valueOf(str.charAt(0)-'0');
    }
}
