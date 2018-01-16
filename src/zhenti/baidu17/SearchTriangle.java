package zhenti.baidu17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/7 11:14
 * @ProjectName: JavaBaseTest
 * <寻找三角形></>
 * 三维三角形面积公式:
 * 用两点间的距离公式算出三边长a,b,c,再用海伦公式计算.
 * 面积S=根号(p*(p-a)*(p-b)*(p-c)) 其中p=(a+b+c)/2.
 */
class Info{
    char color;
    int x,y,z;
    Info(char color,int x,int y,int z){
        this.color=color;
        this.x=x;
        this.y=y;
        this.z=z;
    }
}
public class SearchTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while(scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine());
            Info[] rgbs=new Info[n];
            for(int i=0;i<n;i++){
                String[] str=scanner.nextLine().split(" ");
                Info info=new Info(str[0].charAt(0),Integer.valueOf(str[1]),Integer.valueOf(str[2]),Integer.valueOf(str[3]));
            }
        }
    }
}
