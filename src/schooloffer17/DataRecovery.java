package schooloffer17;

import java.util.*;

/**
 * Created by caoxiaohong on 17/11/1 16:55.
 * 牛牛的作业薄上有一个长度为 n 的排列 A....
 * 字典排序加强版
 */
public class DataRecovery {
    public static void main(String[] args) {
        int n,k;
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> notHas=new ArrayList<Integer>();


        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            k=scanner.nextInt();

            for(int i=0;i<n;i++) {
                list.add(scanner.nextInt());
            }

            //查找没有的元素
            for(int i=1;i<=n;i++){
                if(!list.contains(i))
                    notHas.add(i);
            }
            Collections.sort(notHas);//升序

            int size=notHas.size();
            int solutions=0;
            //notHas当前状态是否符合 有k个顺序对
            solutions+=getSolution(list,notHas,k);

            while(true){
                boolean isFind=false;
                for(int i=size-2;i>=0;i--){
                    if(notHas.get(i)<notHas.get(i+1)){
                        isFind=true;
                        for(int j=size-1;j>i;j--){
                            if(notHas.get(j)>notHas.get(i)){
                                int tmp1=notHas.get(j);
                                notHas.set(j,notHas.get(i));
                                notHas.set(i,tmp1);
                                //从i+1~(size-1)进行升序排序
                                int low=i+1,high=size-1;
                                while (low<high){
                                    int tmp2=notHas.get(low);
                                    notHas.set(low,notHas.get(high));
                                    notHas.set(high,tmp2);
                                    low++;
                                    high--;
                                }
                                solutions+=getSolution(list,notHas,k);
                            }
                        }
                    }else{
                        isFind=false;
                    }
                }
                if(!isFind)
                    break;
            }

            System.out.println(solutions);
            //清空输入列表
            list.clear();
            notHas.clear();
        }
    }

    /**对于ArrayList查找顺序对个数
     * 顺序对定义: i < j 且 A[i] < A[j]
     * @param list
     * @return
     */
    private static int getCount(ArrayList<Integer> list){
        int len=list.size();
        int res=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(list.get(j)>list.get(i))
                    res++;
            }
        }
        return res;
    }

    /**
     * 本次字典排序 是否符合顺序对为k个
     * @param list
     * @param notHas
     * @param k
     * @return
     */
    private static int getSolution(ArrayList<Integer> list,ArrayList<Integer> notHas,int k){
        int size=notHas.size();
        ArrayList<Integer> original=new ArrayList<Integer>();
        original.addAll(list);

        //将新生成的字典序数组插入list中元素为0的位置
        int from=0;
        for(int p=0;p<size;p++){
            for(int q=from;q<list.size();q++){
                if(list.get(q)==0){
                    list.set(q,notHas.get(p));
                    from=q+1;
                    break;
                }
            }
        }
        //查询顺序对个数
        int kk=getCount(list);
        //恢复list原值
        Collections.copy(list,original);
        if(kk==k)
            return 1;
        else
            return 0;
    }
}
