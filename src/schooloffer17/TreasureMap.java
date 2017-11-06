package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/1.
 * 牛牛拿到了一个藏宝图...
 */
public class TreasureMap {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s,t;
        while (scanner.hasNext()){
            s=scanner.nextLine();
            t=scanner.nextLine();
            int sfrom=0;
            int i;
            for(i=0;i<t.length();i++){
                int j;
                for(j=sfrom;j<s.length();j++){
                    if(t.charAt(i)==s.charAt(j)){
                        sfrom=j+1;
                        break;
                    }
                }
                if(j==s.length()){
                    System.out.println("No");
                    break;
                }
            }
            if(i==t.length())
                System.out.println("Yes");
        }
    }
}
