package schooloffer16;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/18.
 * 输入一个字符串，求出该字符串包含的字符集合
 */
public class CharCollection {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            ArrayList<Character> set=new ArrayList<Character>();
            for(int i=0;i<str.length();i++){
                if(!set.contains(str.charAt(i))){
                    set.add(str.charAt(i));
                }
            }
            /**
             * 开始并没有用StringBuiler,就是一个个字符串输出到一行,不能ac,而且牛客网上给出我的输出答案很诡异....为什么改成字符串就可以了...不太理解
             */
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<set.size();i++){
                sb.append(set.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}
