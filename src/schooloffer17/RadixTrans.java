package schooloffer17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/17 15:13.
 * <进制转换></>
 */
public class RadixTrans {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//正数
            m=scanner.nextInt();//2 ≤ m ≤ 16
            ArrayList<Integer> res=new ArrayList<Integer>();//存放结果,从低位到高位存储;故输出时,逆序输出

            int abs=Math.abs(n);
            while (abs>0){
                res.add(abs%m);
                abs/=m;
            }

            if(n<0)
                System.out.print("-");
            for (int i=res.size()-1;i>=0;i--){
                n=res.get(i);
                if(n<10)
                    System.out.print(n);
                else{
                    switch (n){
                        case 10:
                            System.out.print("A");
                            break;
                        case 11:
                            System.out.print("B");
                            break;
                        case 12:
                            System.out.print("C");
                            break;
                        case 13:
                            System.out.print("D");
                            break;
                        case 14:
                            System.out.print("E");
                            break;
                        case 15:
                            System.out.print("F");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}
