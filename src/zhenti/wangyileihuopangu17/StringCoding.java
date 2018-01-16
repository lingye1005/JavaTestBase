package zhenti.wangyileihuopangu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/17 09:49
 * @ProjectName: JavaBaseTest
 * <字符串编码></>
 * 99%
 * 测试用例最后一个有问题
 */
public class StringCoding {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        char pre;//记录上一个字符
        int count=0;//记录一个字符出现的次数;
        StringBuilder sb=new StringBuilder();//记录结果
        int len;//记录输入字符串的长度
        while (scanner.hasNext()){
            str=scanner.nextLine().trim();//只包括大写英文字母，长度不超过10000
            len=str.length();
            pre=str.charAt(0);
            count=1;
            for(int i=1;i<len;i++){
                if(pre==str.charAt(i)){
                    count++;
                }else{
                    sb.append(count+String.valueOf(pre));
                    pre=str.charAt(i);
                    count=1;
                }
                if(i==len-1){
                    sb.append(count+String.valueOf(pre));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
