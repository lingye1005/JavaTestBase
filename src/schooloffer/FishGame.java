package schooloffer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by caoxiaohong on 17/9/14.
 * ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
 */
public class FishGame {
    public static void main(String[] args) {
        try{
            //输入
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int n,m,x,y,t;
            while (reader.ready()){
                String inputStr = reader.readLine();
                String[] num=inputStr.split(" ");
                n=Integer.valueOf(num[0]);
                m=Integer.valueOf(num[1]);
                x=Integer.valueOf(num[2]);
                y=Integer.valueOf(num[3]);
                t=Integer.valueOf(num[4]);

                double[][] rates=new double[n][m];

                double sum=0;
                for(int i=0;i<n;i++){
                    String str=reader.readLine();
                    String[] tmp=str.split(" ");
                    for(int j=0;j<m;j++){
                        rates[i][j]=Double.valueOf(tmp[j]);
                        sum+=rates[i][j];
                    }
                }

                double rateSs=1-Math.pow(1-sum/(n*m),t);
                double rateCc=1-Math.pow(1-rates[x-1][y-1],t);

                //保留2位小数
                DecimalFormat  df = new DecimalFormat("######0.00");
                if(rateSs==rateCc){
                    System.out.println("equal");
                    System.out.println(df.format(rateCc));
                }else if(rateCc>rateSs){
                    System.out.println("cc");
                    System.out.println(df.format(rateCc));
                }else{
                    System.out.println("ss");
                    System.out.println(df.format(rateSs));
                }
            }
        }catch (Exception e){
            System.out.println("-1");
        }
    }
}
