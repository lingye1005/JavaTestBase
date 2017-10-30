package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/17.
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 */
public class IsPalindromic {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.nextLine(); //输入待判定字符串
            int len=str.length();
            int low=0,high=str.length()-1;
            int diff=0;//不同字符个数

            while (low<high){
                if(str.charAt(low)==str.charAt(high)){
                    low++;
                    high--;
                }else{
                    if(low+1<len && str.charAt(low+1)==str.charAt(high)){
                        low++;
                        diff++;
                    }else if(high-1>=0 && str.charAt(high-1)==str.charAt(low)){
                        high--;
                        diff++;
                    }else{
                        diff=3;
                    }
                    if(diff>=2)
                        break;
                }
            }
            if(diff<=1)
                System.out.println(true);
            else
                System.out.println(false);
        }
    }
}
