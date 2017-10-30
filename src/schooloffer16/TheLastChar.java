package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/12.
 * 正在挑战一个CrackMe的你，把需要填写的前面几位密码都正确猜出了，....
 * 输入保证:
 * (1)字符串非空
 * (2)一定有解
 */
public class TheLastChar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        scanner.nextLine();
        while (T-->0){
            String str=scanner.nextLine();
            for(int i=0;i<str.length();i++){
                if(str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i))) {
                    System.out.println(str.charAt(i));
                    break;
                }
            }
        }
    }
}
