package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/17.
 * 现在有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1,y1)。每次移动一步，都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转。问最少需要移动几步。
 */
public class MoveTables {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double r,x,y,x1,y1;
        while (scanner.hasNext()){
            r=scanner.nextDouble();
            x=scanner.nextDouble();
            y=scanner.nextDouble();
            x1=scanner.nextDouble();
            y1=scanner.nextDouble();

            /**double转int
             **double   d   =   12.0;
             **int      i   =   (new   Double(d)).intValue();
             **/
            /**double pathLen=Math.sqrt((new Double(Math.ceil(Math.pow(Math.abs(x-x1),2)+Math.pow(Math.abs(y-y1),2))).intValue()));
             **上行代码:80%通过率,因为求解过程int类型溢出;
             **全部改为double;
            **/
            double pathLen=Math.sqrt((Math.ceil(Math.pow(Math.abs(x-x1),2)+Math.pow(Math.abs(y-y1),2))));
            int counts=(new Double(Math.ceil(pathLen/(2*r)))).intValue();
            System.out.println(counts);
        }
    }
}
