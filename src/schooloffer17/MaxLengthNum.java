package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 11:06.
 * <字符串中找出连续的最长的数字串></>
 * 开始这题目理解偏了,以为是连续子序列呢,原来不过是获得一个字符串中包含的一个一个子串,而这个子串呢,必须是数字,求最长的这一一个子串就行了.
 */
public class MaxLengthNum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.nextLine();
            int resFrom=0,resTo=0;
            int from=-1,to=-1;//[from,to]
            int len=str.length();
            for(int i=0;i<len;i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57){
                    if(from==-1)
                        from=i;
                    to=i;
                }else{
                    if(to-from>resTo-resFrom){
                        resFrom=from;
                        resTo=to;
                    }
                    from=-1;
                    to=-1;
                }
            }
            //i==len时跳出循环,可能未完成最长的数字串判定
            if(to-from>resTo-resFrom){
                resFrom=from;
                resTo=to;
            }

            System.out.println(str.substring(resFrom,resTo+1));
        }
    }
}
