package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/12 09:56.
 * <优雅的点></>
 *
 */
public class ElegantPoints {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int r2;//圆的半径的平方.
        while (scanner.hasNextInt()){
            r2=scanner.nextInt();
            int sum=0;
            int r=(int)Math.sqrt(r2);//圆的半径
            for(int x=0;x<=r;x++){
                if(Math.pow((int)Math.sqrt(r2-(int)Math.pow(x,2)),2)==r2-(int)Math.pow(x,2)){ //得到的y坐标是个整数
                    if(r2-Math.pow(x,2)==0 || x==0){ //y==0 或者 x==0
                        sum+=2;
                    }else{
                        sum+=4;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
