package zhenti.wangyileihuopangu17;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/17 10:54
 * @ProjectName: JavaBaseTest
 * <赛马></>
 * 10% 超时
 */
public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();//1 <= N <= 1000
            DecimalFormat df=new DecimalFormat("#.0000");
            //对1~n的数字进行字典排序,然后对每个情况求:剩下马匹的数目
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1;i<=n;i++)
                list.add(i);
            double res=0;
            double base=getN(n);//除数
            res+=1;
            while(true){
                int index=-1;//记录需要被调整的数组下标
                for(int i=n-1;i>0;i--){
                    if(list.get(i-1)<list.get(i)){
                        index=i-1;
                        break;
                    }
                }
                if(index==-1)
                    break;
                //从右侧开始查找(范围:n-1~index),第一个比list.get(index)数字大的数字,交换位置;然后将list.get(index+1)~list.get(n-1)的数字升序排序
                for(int i=n-1;i>index;i--){
                    if(list.get(i)>list.get(index)){
                        int tmp=list.get(i);
                        list.set(i,list.get(index));
                        list.set(index,tmp);
                        //升序排序
                        int low=index+1,high=n-1;
                        while (low<high){
                            int num=list.get(low);
                            list.set(low,list.get(high));
                            list.set(high,num);
                            low++;
                            high--;
                        }
                        break;
                    }
                }
                if(list.get(n-1)==n)
                    res+=1;
                else {
                    // 找到最大的数字n的位置
                    int idx=list.indexOf(n);
                    res+=1;
                    if(idx<n-1)
                        res+=remain(list.subList(idx+1,n));
                }
            }
            System.out.println(df.format(res/base));
        }
    }

    /**
     * 求n的阶乘
     * @param n
     * @return
     */
    private static double getN(int n){
        double res=1;
        for(int i=n;i>1;i--)
            res*=i;
        return res;
    }

    /**
     *获取当前序列list中,可以剩余的马匹数目
     * @param list
     * @return
     */
    private static int remain(List<Integer> list){
        int res=0;
        int len=list.size();
        for(int i=0;i<len;i++){
            int j=i+1;
            for(;j<len;j++){
                if(list.get(j)>list.get(i))
                    break;
            }
            if(j==len)
                res++;
        }
        return res;
    }
}
