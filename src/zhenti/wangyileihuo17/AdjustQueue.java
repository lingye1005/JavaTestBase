package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 18:47
 * @ProjectName: JavaBaseTest
 * <调整队形></>
 * 100%
 */
public class AdjustQueue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            char[] chars=scanner.nextLine().trim().toCharArray();//包含G和B的字符串.n不超过50.
            //就两种转化方式,要么GGG...BBB..,要么BBB...GGG...
            int count1=0,count2=0;
            //BBB...GGG
            char[] original=new char[chars.length];
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='G'){
                    original[i]='A';
                }else{
                    original[i]=chars[i];
                }
            }
            count1=bubbleSort(chars);
            //GGG...BBB
            count2=bubbleSort(original);
            System.out.println(count1<count2?count1:count2);
        }
    }
    private static int bubbleSort(char[] chars){
        int len=chars.length;
        int res=0;
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=len-1;j>i;j--){
                if(chars[j-1]>chars[j]){
                    char tmp=chars[j];
                    chars[j]=chars[j-1];
                    chars[j-1]=tmp;
                    res+=1;
                    flag=true;
                }
            }
            if(flag==false)
                break;
        }
        return res;
    }
}
