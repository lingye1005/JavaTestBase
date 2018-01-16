package zhenti.wangyileihuo17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 21:37
 * @ProjectName: JavaBaseTest
 * <涂棋盘></>
 * 100%
 */
public class ApplyChessboard {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine().trim());//n(1 ≤ n ≤ 50),
            char[][] chessboard=new char[n][n];//w为1,b为0
            for(int i=0;i<n;i++){
                String str=scanner.nextLine();
                for(int j=0;j<n;j++){
                    if(str.charAt(j)=='W')
                        chessboard[i][j]='1';
                    else
                        chessboard[i][j]='0';
                }
            }
            //处理
            int res=0;
            for(int j=0;j<n;j++){
                char pre=chessboard[0][j];
                int tmp=1;
                for(int i=1;i<n;i++){
                    if(pre==chessboard[i][j])
                        tmp++;
                    else{
                        res=Math.max(tmp,res);
                        tmp=1;
                        pre=chessboard[i][j];
                    }
                }
                res=Math.max(res,tmp);
            }
            System.out.println(res);
        }
    }
}
