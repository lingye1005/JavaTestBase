package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 21:20
 * @ProjectName: JavaBaseTest
 * <奇怪的表达式求值></>
 * 100%
 */
public class UniqueExpression {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();//参与计算的数字只有0~9. 保证表达式都是合法的
            if(str.length()==1){//只有一个数字
                System.out.println(str.charAt(0)-48);
                continue;
            }
            char[] chars=str.toCharArray();
            int res=0;

            res=chars[0]-48;
            for(int i=2;i<str.length();i+=2){
                if(chars[i-1]=='+')
                    res+=chars[i]-48;
                else if(chars[i-1]=='-')
                    res-=chars[i]-48;
                else if(chars[i-1]=='*')
                    res*=chars[i]-48;
            }
            System.out.println(res);
        }
    }
}
