package zhenti.wangyineitui18;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 16:31
 * @ProjectName: JavaBaseTest
 * <交错字符串></>
 * 100%
 */
public class AlternationString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine().trim();//s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
            int len=str.length();
            int res=1;
            char pre=str.charAt(0);
            int from=0,to=0;
            for(int i=1;i<len;i++){
                if(str.charAt(i)!=pre){
                    to=i;
                    pre=str.charAt(i);
                    if(i==len-1)
                        res=Math.max(res,to-from+1);
                }else{
                    res=Math.max(res,to-from+1);
                    from=i;
                    to=i;
                    pre=str.charAt(i);
                }
            }
            System.out.println(res);
        }
    }
}
