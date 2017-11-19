package schooloffer17;

import java.util.*;

/**
 * Created by caoxiaohong on 17/11/15 18:19.
 * <餐馆></>
 */


public class Restaurant {
    public static void main(String[] args) {
        int n,m;//n张桌子,m批客人
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//桌子
            m=scanner.nextInt();//客人
            //输入桌子情况
            int[] tables=new int[n];
            for(int i=0;i<n;i++)
                tables[i]=scanner.nextInt();
            Arrays.sort(tables);

            //输入客人情况
            int[][] customers=new int[m][2];
            for(int i=0;i<m;i++){
                customers[i][0]=scanner.nextInt();//人数
                customers[i][1]=scanner.nextInt();//消费金额
            }
            Arrays.sort(customers, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) { //消费金额相同,按照人数升序;否则,按照消费金额降序
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }else{
                        return o2[1]-o1[1];
                    }
                }
            });

            long sum=0;//赚钱总数
            int b,c;
            for(int i=0;i<m;i++){
                b=customers[i][0];//人数
                c=customers[i][1];//消费金额
                for(int j=0;j<n;j++){
                    if(tables[j]>=b){
                        sum+=c;
                        tables[j]=-1;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
