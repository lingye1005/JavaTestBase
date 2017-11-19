package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/11 10:43.
 * <混合颜料></>
 * 本题实质:求矩阵的秩
 * 虽然最后求出来的不一定是类似线性代数的最简表达式,但是只要矩阵中的行表达式的真值!=0,则,这就是当前行没办法被其它行表示,那么就必须作为1阶存在.
 * 所以最后求完之后,只要查找矩阵中有多少个非零的行,就是矩阵的秩.也就是所求.
 */
public class MergeColors {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;//n种颜色,1 ≤ n ≤ 50
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            //输入n个数xi(1 ≤ xi ≤ 1,000,000,000)
            int[] xi=new int[n];
            for(int i=0;i<n;i++)
                xi[i]=scanner.nextInt();

            Arrays.sort(xi);//升序,目的是:为求xi[i]的最高位1做准备.

            for(int i=n-1;i>0;i--){//每循环一次:则行号为[i,n-1]已经不再改变
                for(int j=i-1;j>=0;j--){
                    if(getHighestBit(xi[i])==getHighestBit(xi[j])){
                        xi[j]^=xi[i];
                    }
                }
                Arrays.sort(xi);
            }

            //查找非零行
            int count=0;
            for(int i=0;i<n;i++){
                if(xi[i]!=0)
                    count++;
            }
            System.out.println(count);
        }
    }

    /**
     * 求数字number的二进制表达式中,最高位的1是第多少位
     * @param nunmber
     * @return
     */
    private static int getHighestBit(int nunmber){
        int tmp;
        for(int i=31;i>=0;i--){
            tmp=nunmber>>i;
            tmp&=1;
            if(tmp!=0)
                return i+1;
        }
        return 0;
    }
}
