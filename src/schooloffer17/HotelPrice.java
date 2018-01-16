package schooloffer17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/23 10:48
 * @ProjectName: JavaBaseTest
 * <酒店价格></>
 */


public class HotelPrice {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        while(scanner.hasNext()){
            String[] strs=scanner.nextLine().split(" ");
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            tmp.add(Integer.valueOf(strs[0]));
            tmp.add(Integer.valueOf(strs[1]));
            tmp.add(Integer.valueOf(strs[2]));
            list.add(tmp);
        }

        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)==o2.get(0)){
                    return o1.get(1)-o2.get(1);
                }else{
                    return o1.get(0)-o2.get(0);
                }
            }
        });

        int rows=0;
        int len=list.size();
        int a=-1,b=-1,c=-1;//a:开始时间 b:终止时间 c:金额
        for(int i=0;i<len;i++){
            if(i+1<len && list.get(i).get(1)>=list.get(i+1).get(0)){
                if(a==-1){
                    a=list.get(i).get(0);//只有第一次记录:开始时间
                }
                b=list.get(i+1).get(1);//更新终止时间
                c=list.get(i+1).get(2);//更新价格
            }else if(i+1<len && list.get(i).get(1)+1==list.get(i+1).get(0) && list.get(i).get(2)==list.get(i+1).get(2)){
                if(a==-1){
                    a=list.get(i).get(0);
                    c=list.get(i).get(2);
                }
                b=list.get(i+1).get(1);//更新终止时间
            }else{
                if(a!=-1){
                    ArrayList<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(a);tmp.add(b);tmp.add(c);
                    list.set(rows++,tmp);
                    a=-1;
                    b=-1;
                    c=-1;
                }else{
                    ArrayList<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(list.get(i).get(0));
                    tmp.add(list.get(i).get(1));
                    tmp.add(list.get(i).get(2));
                    list.set(rows++,tmp);
                }
            }
        }
        //输出//[1, 3, 100],
        for(int i=0;i<rows;i++){
            if(i<rows-1)
                System.out.print(list.get(i)+",");
            else
                System.out.println(list.get(i));
        }

        //情况list
        list.clear();
    }
}
