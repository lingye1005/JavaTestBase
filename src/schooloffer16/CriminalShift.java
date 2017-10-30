package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/14.
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，
 * 市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
 */
public class CriminalShift {
    //输入第一行:n t c   //n个人 ; t罪行权值和;  c名连续犯人;
    //输入第二行:n个值:罪犯罪行权值
    public static void main(String[] args) {
        //输入2
        try{
            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNext()){
                String str1=scanner.nextLine();
                String str2=scanner.nextLine();
                //获取ntc
                String[] row1=str1.split(" ");
                String[] row2=str2.split(" ");

                int counts= getChoicesNum(row2,Integer.valueOf(row1[2]),Integer.valueOf(row1[1]));
                System.out.println(counts);
            }
        }catch (Exception e){
            System.out.println("-1");
        }
    }

    /**
     * 主算法
     * @param weights
     * @return
     */
    private static int getChoicesNum(String[] weights,int len,int sumWeight){
        int size=weights.length;
        int count=0;
        //滑动窗口各个框值
        int[] values=new int[size-len+1];
        //求values[0];
        for(int i=0;i<len;i++)
            values[0]+=Integer.valueOf(weights[i]);
        if(values[0]<=sumWeight)
            count++;

        for(int i=1;i<size-len+1;i++){
            values[i]=values[i-1]+(Integer.valueOf(weights[i+len-1])-Integer.valueOf(weights[i-1]));
            if(values[i]<=sumWeight)
                count++;
        }
        return count;
    }
}
