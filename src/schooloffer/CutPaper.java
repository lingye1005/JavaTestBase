package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/14.
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。
 * 度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 */
public class CutPaper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//点数,n(2≤n≤1000)
            int[][] location=new int[n][2];
            int left,right;
            int up,down;
            int j=0;
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            int d=scanner.nextInt();
            left=a<c?a:c;
            right=a>c?a:c;
            up=b>d?b:d;
            down=b<d?b:d;

            for(int i=2;i<n;i++){
                location[i][j] = scanner.nextInt();//x
                if(location[i][j]<left)
                    left=location[i][j];
                else if(location[i][j]>right)
                    right=location[i][j];
                j++;

                location[i][j] = scanner.nextInt();//y
                if(location[i][j]>up)
                    up=location[i][j];
                else if(location[i][j]<down)
                    down=location[i][j];
                j--;
            }
            //输出
            System.out.println((int)Math.pow(Math.max(right-left,up-down),2));
        }
    }
}
