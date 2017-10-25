package schooloffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/21.
 * <解密></解密>
 * 亮亮深吸一口气，小心地将盒子打开，里面是一张地图，地图上除了一些奇怪的字母以外没有任何路线信息，这可让亮亮犯了愁，这些字母代表了什么意思呢？
 * 亮亮绞尽脑汁也想不出什么思路，突然，亮亮眼前一亮，“我可以把这些字母所有的排列方式全部写出来，一定可以找到答案！” 于是，亮亮兴奋的开始寻找字母里的秘密。
 */
public class Decipher {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            ArrayList<String> result=new ArrayList<String>();
            String input=scanner.nextLine();//输入字符串
            String str=helper(input);
            result.add(str);//加入结果集

            //开始算法
            char[] tmp=str.toCharArray();
            int len=input.length();//字符串长度
            boolean isFind=false;//是否还存在升序子序列,如果没有,那肯定是遍历完成了
            for(int i=len-1;i>0;){
                if(tmp[i-1]<tmp[i]){
                    isFind=true;
                    //1,从右到左查找tmp[len-1]~tmp[i+1]中,第一个比tmp[i-1]大的数字tmp[x],交换tmp[i-1]和tmp[x].然后将tmp[i]~tmp[len-1]改为升序
                    //2,改变后的tmp[]添加到result中
                    for(int j=len-1;j>=i;j--){
                        if(tmp[j]>tmp[i-1]){
                            char c=tmp[j];
                            tmp[j]=tmp[i-1];
                            tmp[i-1]=c;
                            break;
                        }
                    }
                    //显然:tmp[i]~tmp[len-1]为降序
                    int low=i,high=len-1;
                    while (low<high){
                        char c=tmp[low];
                        tmp[low++]=tmp[high];
                        tmp[high--]=c;
                    }
                    result.add(charToString(tmp));
                }else{
                    i--;
                    isFind=false;
                }
                if(isFind)
                    i=len-1;
            }
            Iterator<String> iterator=result.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    /**
     * 将输入字符串转为按字母升序的字符串
     * @param str
     * @return
     */
    private static String helper(String str){
        char[] tmp=str.toCharArray();
        Arrays.sort(tmp);
        StringBuilder sb=new StringBuilder();
        for(char c:tmp)
            sb.append(c);
        return sb.toString();
    }

    /**
     * char[]转为String
     * @param values
     * @return
     */
    private static String charToString(char[] values){
        StringBuilder sb=new StringBuilder();
        for(char c:values)
            sb.append(c);
        return sb.toString();
    }
}
