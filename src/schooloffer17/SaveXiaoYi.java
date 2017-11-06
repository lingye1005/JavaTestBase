package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/2 10:17.
 * 有一片1000*1000的草地....
 */
public class SaveXiaoYi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[][] traps=new int[1][n];
            int res=Integer.MAX_VALUE;//结果
            for(int i=0;i<1;i++){
                for(int j=0;j<n;j++){
                    traps[i][j]=scanner.nextInt()-1;
                }
            }
            for(int i=0;i<1;i++){
                for(int j=0;j<n;j++){
                    int x=traps[i][j];
                    int y=scanner.nextInt()-1;
                    res=Math.min(res,x+y);
                }
            }
            System.out.println(res);
        }
    }
}
