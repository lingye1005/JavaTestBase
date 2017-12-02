package schooloffer17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/20 10:59
 * @ProjectName: JavaBaseTest
 * <头条校招></>
 */
public class HeadlineToday {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine().trim());//n个题目
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<n;i++)
                list.add(scanner.nextInt());
            scanner.nextLine();
            Collections.sort(list);

            int mod=0;//添加次数
            int first,second,third;
            while (list.size()>2){
                first=list.get(0);
                second=list.get(1);
                third=list.get(2);
                if(second-first>20){
                    mod+=2;
                    list.remove(0);
                }else if(second-first>10){
                    mod+=1;
                    list.remove(1);
                    list.remove(0);
                }else{
                    if(third-second>10){
                        mod+=1;
                        list.remove(1);
                        list.remove(0);
                    }else{
                        list.remove(2);
                        list.remove(1);
                        list.remove(0);
                    }
                }
                //Collections.sort(list);
            }
            if(list.get(1)-list.get(0)<=20){
                mod+=1;
            }else{
                mod+=4;
            }
            System.out.println(mod);
        }
    }
}
