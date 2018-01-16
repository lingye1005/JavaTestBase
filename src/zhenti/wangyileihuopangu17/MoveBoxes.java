package zhenti.wangyileihuopangu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/17 13:00
 * @ProjectName: JavaBaseTest
 * <推箱子></>
 * 10%
 */
public class MoveBoxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        int x = 0, y = 0;//记录人的位置
        int box = 0, boy = 0;//箱子位置
        int desx = 0, desy = 0;//目的地位置
        while (scanner.hasNext()) {
            //输入
            n = scanner.nextInt();
            m = scanner.nextInt();
            scanner.nextLine();//换行
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] tmp = scanner.nextLine().toCharArray();
                for(int j=0;j<m;j++)
                    matrix[i][j]=tmp[j];
            }
            //处理

        }
    }
//    private static int getSteps(char[][] matrix,int n,int m,,int stcX,int srcY,int desX,int desY){
//        int[][] dp=new int[n][m];
//        //初始化dp
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(matrix[i][j]=='#')
//                    dp[i][j]=-1;
//            }
//        }
//        while (true){
//            boolean isFind=false;//是否找到可以更新的路径
//
//        }
//    }
}
