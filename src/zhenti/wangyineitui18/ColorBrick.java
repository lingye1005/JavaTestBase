package zhenti.wangyineitui18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 16:01
 * @ProjectName: JavaBaseTest
 * <彩色的砖块></>
 * 100%
 */
public class ColorBrick {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();//字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。

            //如果str中包含字母种类>2,必然不能找到合适的解决方案
            int len=s.length();

            Set<Character> set=new HashSet<>();
            for(int i=0;i<len;i++){
                if(set.size()==3){
                    break;
                }else{
                    set.add(s.charAt(i));
                }
            }
            if(set.size()==3){
                System.out.println(0);
            }else if(set.size()==2){
                System.out.println(2);
            }else if(set.size()==1){
                System.out.println(1);
            }
        }
    }
}
