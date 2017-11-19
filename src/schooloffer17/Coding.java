package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/19 10:54.
 * <编码></>
 */
public class Coding {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.nextLine();
            int res=0;
            int len=str.length();
            res+=(str.charAt(0)-97)*(Math.pow(25,3)+Math.pow(25,2)+25+1);
            if(len>1)
                res+=(str.charAt(1)-97)*(Math.pow(25,2)+25+1)+1;
            if(len>2)
                res+=(str.charAt(2)-97)*(25+1)+1;
            if(len>3)
                res+=(str.charAt(3)-97)*1+1;
            System.out.println(res);
        }
    }
}
