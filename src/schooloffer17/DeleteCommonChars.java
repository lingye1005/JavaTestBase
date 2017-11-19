package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 12:02.
 * <删除公共字符></>
 */
public class DeleteCommonChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str1=scanner.nextLine();
            String str2=scanner.nextLine();

            String[] front=str1.split(" ");
            for(int i=0;i<str2.length();i++){
                char tmp=str2.charAt(i);
                for(int j=0;j<front.length;j++){
                    front[j]=front[j].replaceAll(String.valueOf(tmp),"");
                }
            }
            //输出:
            for(int i=0;i<front.length-1;i++){
                System.out.print(front[i]+" ");
            }
            System.out.println(front[front.length-1]);
        }
    }
}
