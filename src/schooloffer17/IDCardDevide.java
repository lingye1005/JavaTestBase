package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/23 10:40
 * @ProjectName: JavaBaseTest
 * <身份证分组></>
 */
public class IDCardDevide {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String card=scanner.nextLine().replaceAll(" ","");
            int len=card.length();

            if(len<=6){
                System.out.println(card);
            }else if(len<=14){
                System.out.println(card.substring(0,6)+" "+card.substring(6,card.length()));
            }else if(len<=18){
                System.out.println(card.substring(0,6)+" "+card.substring(6,14)+" "+card.substring(14,card.length()));
            }else{
                System.out.println(card.substring(0,6)+" "+card.substring(6,14)+" "+card.substring(14,18));
            }
        }
    }
}
