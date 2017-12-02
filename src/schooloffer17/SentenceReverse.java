package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/26 20:57
 * @ProjectName: JavaBaseTest
 * <句子反转></>
 */
public class SentenceReverse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] str=scanner.nextLine().split(" ");
            for(int i=str.length-1;i>=0;i--){
                if(i>0)
                    System.out.print(str[i]+" ");
                else
                    System.out.println(str[i]);
            }
        }
    }
}
