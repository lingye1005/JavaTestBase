package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/4 10:02.
 * 考拉有n个字符串字符串...
 */
public class TwoMethodsOfSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine().trim());
            String pre,p;
            int len;
            pre=scanner.nextLine();
            len=pre.length();

            boolean sortByLen=true;
            boolean sortByDic=true;
            for(int i=1;i<n;i++){
                p=scanner.nextLine();//当然输入字符串;
                if(sortByLen==true && p.length()<len){
                    sortByLen=false;
                }else if(sortByLen==true && p.length()>=len){//更新长度
                    len=p.length();
                }
                if(sortByDic==true && !isSortByDic(pre,p)){
                    sortByDic=false;
                }
                pre=p;
            }
            if(sortByDic && sortByLen)
                System.out.println("both");
            else if(sortByDic)
                System.out.println("lexicographically");
            else if(sortByLen)
                System.out.println("lengths");
            else
                System.out.println("none");
        }
    }

    /**
     * 从str1到str2是否符合字典排序规则
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isSortByDic(String str1,String str2){
        int low=0;
        int high1=str1.length(),high2=str2.length();

        while (low<high1 && low<high2){
            if(str2.charAt(low)>str1.charAt(low)){
                return true;
            }else if(str1.charAt(low)<=str2.charAt(low)){
                low++;
                continue;
            }else{
                return false;
            }
        }
        if(high1>high2)
            return false;
        else
            return true;
    }
}
