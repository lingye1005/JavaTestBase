package schooloffer;

import java.util.*;

/**
 * Created by caoxiaohong on 17/10/12.
 * 360员工桂最近申请了一个长假，一个人背着包出去自助游了。
 * 路上，他经过了一个小镇，发现小镇的人们都围在一棵树下争吵....
 * 丢掉题意:镇长满足条件
 * (1)镇长不认识任何人,除去自己.
 * (2)小镇上任何人都认识镇长.
 * 内存溢出
 */
public class SelectMajor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=Integer.valueOf(scanner.nextLine().trim());//输入关系数组数目.
        while (T-->0){
            int n,m;
            n= scanner.nextInt();  //镇上有n个人
            m=scanner.nextInt();   //m个关系
            //连续输入m个关系
            //int[] degrees=new int[n+1];//记录出度关系;求最后值为n-1的数组下标;如果值为-1说明这个人曾经有认识其他人,不能作为镇长,超出内存
            HashMap<Integer,Integer> degrees=new HashMap<Integer, Integer>();

            int num1,num2;
            while (m-->0){
                num1=scanner.nextInt();
                num2=scanner.nextInt();
                if(num1==num2)
                    continue;
                degrees.remove(num1);
                if(degrees.containsKey(num2) && degrees.get(num2)!=-1){
                    degrees.put(num2,degrees.get(num2)+1);
                }else if(!degrees.containsKey(num2)){
                    degrees.put(num2,1);
                }
            }
            //查找符合条件的人
            m=0;
            int key,value;
            for(Map.Entry<Integer,Integer> entry:degrees.entrySet()){
                key=entry.getKey();
                value=entry.getValue();
                if(value==n-1){
                    m=key;
                    break;
                }
            }

            if(m==0){
                System.out.println(0);
                System.out.println();
            }else{
                System.out.println(1);
                System.out.println(m);
            }
        }
    }
}
