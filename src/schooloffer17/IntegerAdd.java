package schooloffer17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/22 15:41
 * @ProjectName: JavaBaseTest
 * <整数相加></>
 */
public class IntegerAdd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strs=scanner.nextLine().trim().split(" ");
            if(strs[0].length()>strs[1].length()){
                String tmp=strs[0];
                strs[0]=strs[1];
                strs[1]=tmp;
            }
            ArrayList<Integer> res=new ArrayList<Integer>();

            int carry=0;
            int i=strs[0].length()-1,j=strs[1].length()-1;
            for(;i>=0;i--,j--){
                int a=strs[0].charAt(i)-48;
                int b=strs[1].charAt(j)-48;
                if(a<0 || a>9 || b<0 ||b>9){
                    System.out.println("error");
                    break;
                }else{
                    res.add((a+b+carry)%10);
                    carry=(a+b)/10;
                }
            }
            //遇到非数字字符
            if(i!=-1)
                continue;

            for(;j>=0;j--){
                res.add( (strs[1].charAt(j)-48+carry)%10 );
                carry=(strs[1].charAt(j)-48+carry)/10;
            }
            if(carry!=0)
                res.add(carry);
            for(int k=res.size()-1;k>=0;k--)
                System.out.print(res.get(k));
            System.out.println();
        }
    }
}
