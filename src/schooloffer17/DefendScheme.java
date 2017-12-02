package schooloffer17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/1 10:38
 * @ProjectName: JavaBaseTest
 * <保卫方案></>
 * 注意一点:就是两个山之间,如果出现比这两个山高度最低的山高的山,那么这两个山之间是不可见的
 * 90%,最后一个测试用例太大不能通过
 */
public class DefendScheme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[] height=new int[n];
            //输入树高
            for(int i=0;i<n;i++)
                height[i]=scanner.nextInt();

            ArrayList<String> list=new ArrayList<String>();//记录出现的情况
            for(int i=0;i<n;i++){
                int midMax=-1;
                int from=height[i],to;
                int max=n;
                //顺时针
                for(int j=i+1;j<max;j++){
                    if(j==n){
                        j=0;
                        max=i;
                    }
                    to=height[j];
                    if(j==i+1){
                        if(!list.contains(String.valueOf(i)+","+String.valueOf(j)) &&
                                !list.contains(String.valueOf(j)+","+String.valueOf(i)) &&
                                i!=j){
                            list.add(String.valueOf(i)+","+String.valueOf(j));
                        }
                        midMax=height[j];
                        continue;
                    }
                    if(Math.min(from,to)>=midMax){
                        if(!list.contains(String.valueOf(i)+","+String.valueOf(j)) &&
                                !list.contains(String.valueOf(j)+","+String.valueOf(i)) &&
                                i!=j){
                            list.add(String.valueOf(i)+","+String.valueOf(j));
                        }
                    }
                    midMax=Math.max(midMax,to);
                }
                //逆时针
                max=-1;
                for(int j=i-1;j>=max;j--){
                    if(j<0) {
                        j = n - 1;
                        max=i+1;
                    }
                    to=height[j];
                    if(j==i-1 || (i==0 && j==n-1)){
                        if(!list.contains(String.valueOf(i)+","+String.valueOf(j)) &&
                                !list.contains(String.valueOf(j)+","+String.valueOf(i)) &&
                                i!=j){
                            list.add(String.valueOf(i)+","+String.valueOf(j));
                        }
                        midMax=height[j];
                        continue;
                    }
                    if(Math.min(from,to)>=midMax){
                        if(!list.contains(String.valueOf(i)+","+String.valueOf(j)) &&
                                !list.contains(String.valueOf(j)+","+String.valueOf(i)) &&
                                i!=j){
                            list.add(String.valueOf(i)+","+String.valueOf(j));
                        }
                    }
                    midMax=Math.max(midMax,to);
                }
            }
            System.out.println(list.size());
        }
    }
}
