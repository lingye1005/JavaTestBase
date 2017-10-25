package schooloffer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/19.
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai ，每盏灯可以覆盖到的最远距离为d，为了照明需求，
 * 所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d
 */
public class StreetLight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        int l;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            l=scanner.nextInt();
            int[] location=new int[n];
            for(int i=0;i<n;i++){
                location[i]=scanner.nextInt();
            }
            Arrays.sort(location);
            double maxLen=location[0];
            for(int i=1;i<n;i++){
                if(location[i]-location[i-1]>maxLen)
                    maxLen=location[i]-location[i-1];
            }
            DecimalFormat df=new DecimalFormat("######0.00");
            //处理:第一个路灯 + 最后一个路灯
            if(maxLen/2<location[0] || maxLen/2<l-location[n-1]){
                double res=Math.max(location[0],l-location[n-1]);
                System.out.println(df.format(res));
            }else{
                System.out.println(df.format(maxLen/2));
            }
        }
    }
}
