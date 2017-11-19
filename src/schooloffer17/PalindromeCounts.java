package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/7 16:22.
 * <统计回文>
 * “回文串”是一个正读和反读都一样的字符串
 * </统计回文>
 */
public class PalindromeCounts {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char[] A;
        String B;
        while (scanner.hasNext()){
            A=scanner.nextLine().toCharArray();//字符串长度均小于100且只包含小写字母
            B=scanner.nextLine();
            int sum=0;
            int lena=A.length;
            for(int i=0;i<=lena;i++){//插入位置:在字符串A的第i个字符[不包括第i个]前进行拼接
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<i;j++){
                    sb.append(A[j]);
                }
                sb.append(B);
                for(int j=i;j<lena;j++)
                    sb.append(A[j]);
                if(sb.toString().equals(sb.reverse().toString()))
                    sum++;
            }
            System.out.println(sum);
        }
    }
}
