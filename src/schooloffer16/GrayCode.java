package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/20.
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始
 * 说明:n是指格雷码的长度,而返回字符串各个字符串长度均为n,且各个相邻字符串仅仅相差一个二进制位.
 *
     //递归
     //递归的思路是n位gray码是由n-1位gray码生成，举个例子简单一些：
     //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
     //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
     //添加1后需要顺序反向就变成(110,111,101,100)
     //组合在一起就是(000,001,011,010,110,111,101,100)
 */
public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] result=null;
        if(n==1){
            result=new String[]{"0","1"};
        }else{
            String[] tmp=getGray(n-1);
            result=new String[tmp.length*2];
            for(int i=0;i<tmp.length;i++){
                result[i]="0"+tmp[i];
                result[result.length-1-i]="1"+tmp[i];
            }
        }
        return result;
    }

    //test code
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            GrayCode a=new GrayCode();
            String[] result=a.getGray(n);
            for(String str:result)
                System.out.print(str+" ");
        }
    }
}
