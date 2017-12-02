package schooloffer17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/23 10:27
 * @ProjectName: JavaBaseTest
 * <统计字符></>
 */
public class CountChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine().replace(" ","");//输入包括:字符,数字
            HashMap<Character,Integer> map=new HashMap<Character, Integer>();
            for(int i=0;i<str.length();i++){
                char tmp=str.charAt(i);
                if((tmp>=65 && tmp<=90) || (tmp>=97 && tmp<=122)){ //只对英文字母做处理
                    if(map.containsKey(tmp)){
                        if(map.get(tmp)==2){
                            System.out.println(tmp);
                            break;
                        }else{
                            map.put(tmp,map.get(tmp)+1);
                        }
                    }else{
                        map.put(tmp,1);
                    }
                }
            }
        }
    }
}
