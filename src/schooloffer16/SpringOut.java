package schooloffer16;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/13.
 * You class are planning for a spring outing. N people are voting for a destination out of K candidate places.....
 * N个人,K个候选春游地方
 */
public class SpringOut {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N,K;
        while (scanner.hasNext()){
            N=scanner.nextInt();
            K=scanner.nextInt();
            //连续输入N行,每行(K+1)个数字
            int[][] prefers=new int[N][K+1];
            for(int i=0;i<N;i++){
                for(int j=0;j<=K;j++){
                    prefers[i][j]=scanner.nextInt();
                }
            }

            //一半景点数目
            int half=(int)Math.ceil(K/2);
            HashMap<Integer,Integer> result=new HashMap<Integer, Integer>();//景点

            //纵向遍历prefers
            boolean isFind=false;
            int area=-1;
            for(int j=0;j<=K && !isFind;j++){
                for(int i=0;i<N && !isFind;i++){
                    int key=prefers[i][j];
                    if(result.containsKey(key)){
                        result.put(key,result.get(key)+1);
                        if(result.get(key)==N && key!=0) {
                            isFind = true;
                            area=key;
                        }
                    }else{
                        result.put(key,1);
                    }
                }
            }
            System.out.println(area);
        }
    }
}
