package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/19 09:31.
 * <游戏任务标记></>
 */
public class GameTaskMark {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a,b;
        while (scanner.hasNextInt()){
            a=scanner.nextInt();
            b=scanner.nextInt();
            if(a<1 || a>1024 || b<1 || b>1024){
                System.out.println(-1);
                continue;
            }
            if(a==b)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
