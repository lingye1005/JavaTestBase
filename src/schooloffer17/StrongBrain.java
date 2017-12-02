package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/20 10:13
 * @ProjectName: JavaBaseTest
 * <最强大脑></>
 */
public class StrongBrain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String path,a,b;
        while (scanner.hasNext()){
            path=scanner.nextLine().trim();//N到M的路径
            a=scanner.nextLine().trim();//小B看到的第一个旗子
            b=scanner.nextLine().trim();//小B看到的第二个旗子

            StringBuilder sb=new StringBuilder(path).reverse();
            String str=sb.toString();
            if(path.indexOf(a)!=-1 && path.indexOf(b)!=-1 && path.indexOf(a)+a.length()-1<path.lastIndexOf(b) &&
                    str.indexOf(b)!=-1 && str.indexOf(a)!=-1 && str.indexOf(a)+a.length()-1<str.lastIndexOf(b)){
                System.out.println("both");
            }else if(path.indexOf(a)!=-1 && path.indexOf(b)!=-1 && path.indexOf(a)+a.length()-1<path.lastIndexOf(b)){
                System.out.println("forward");
            }else if(str.indexOf(b)!=-1 && str.indexOf(a)!=-1 && str.indexOf(a)+a.length()-1<str.lastIndexOf(b)){
                System.out.println("backward");
            }else{
                System.out.println("invalid");
            }
        }
    }
}
