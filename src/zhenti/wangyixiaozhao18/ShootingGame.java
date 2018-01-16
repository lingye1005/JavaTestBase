package zhenti.wangyixiaozhao18;

import java.util.*;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 16:24
 * @ProjectName: JavaBaseTest
 * <射击游戏></>
 */
public class ShootingGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//n个怪物,n(1 ≤ n ≤ 50)
            int[] xi=new int[n];//(-1,000,000 ≤ x[i] ≤ 1,000,000)
            int[] yi=new int[n];//(-1,000,000 ≤ y[i] ≤ 1,000,000)
            for(int i=0;i<n;i++)
                xi[i]=scanner.nextInt();
            for(int i=0;i<n;i++)
                yi[i]=scanner.nextInt();

            int res=0;
            //判定
            HashMap<Double,Integer> map=new HashMap<>();//记录同一斜率的点个数
            for(int i=0;i<n;i++){
                if(xi[i]==0 && yi[i]==0){
                    res++;
                    continue;
                }else{
                    double k;
                    if(xi[0]!=0)
                        k=yi[i]/xi[i];
                    else
                        k=1;
                    if(map.containsKey(k)){
                        map.put(k,map.get(k)+1);
                    }else
                        map.put(k,1);
                }
            }
            //求同一斜率上面最多点数
            int max1=Integer.MIN_VALUE;
            Collection<Integer> values=map.values();
            Iterator<Integer> iterator=values.iterator();
            while (iterator.hasNext()){
                max1=Math.max(max1,iterator.next());
            }

            //求斜率相乘为-1的这些线上最多点数
            int max2=Integer.MIN_VALUE;
            Set<Map.Entry<Double,Integer>> entry=map.entrySet();
            Iterator<Map.Entry<Double,Integer>> iterator1=entry.iterator();

            while (iterator1.hasNext()){
                Iterator<Map.Entry<Double,Integer>> iterator2=entry.iterator();
                Map.Entry<Double,Integer> entry1=iterator1.next();
                double k1=entry1.getKey();
                int cnts1=entry1.getValue();
                int tmpCount=0;
                while (iterator2.hasNext()){
                    Map.Entry<Double,Integer> entry2=iterator2.next();
                    double k2=entry2.getKey();
                    int cnts2=entry2.getValue();
                    if(k1*k2==-1)
                        tmpCount+=cnts1+cnts2;
                }
                max2=Math.max(max2,tmpCount);
            }

            System.out.println(res+(max1>max2?max1:max2));
        }
    }
}
