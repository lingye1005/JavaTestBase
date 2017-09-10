package schooloffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by caoxiaohong on 17/9/10.
 * 当且仅当s中的不同字符的数量是斐波那契数时，字符串是LUCKY。 给出一个仅由小写字母组成的字符串，以字典顺序输出所有幸运的非空字符串。 同一子串应打印一次。
 * 注意:字符串长度<=100
 */
public class LuckyString {
    public static void main(String[] args) throws IOException{
        //输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = reader.readLine();

        int len= inputStr.length();
        ArrayList<String> result=new ArrayList<String>();
        ArrayList<Integer> fib= Fibonacci();

        //生成有效字符串
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String tmp=inputStr.substring(i,j);
                int difChar=getDifNum(tmp);
                if(fib.contains(difChar) && !result.contains(tmp)){
                    result.add(tmp);
                }
            }
        }
        //所有字符串:进行字典排序---生序
        Collections.sort(result);
        //输入结果aabcd
        for(String str:result)
            System.out.println(str);
    }
    //生成fibonacci序列
    public static ArrayList<Integer> Fibonacci() {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(1);
        int add1=1,add2=1;
        for(int i=3;;i++){
            int tmp=add2;
            add2=add1+add2;
            add1=tmp;
            list.add(add2);
            if(list.get(i)>=100)
                break;
        }
        return list;
    }
    //求字符串中不同字符的个数
    private static int getDifNum(String str){
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        return set.size();
    }
}
