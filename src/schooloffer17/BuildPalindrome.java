package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/11 09:30.
 * <回文序列></回文序列>
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。....
 */
public class BuildPalindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[] sequ=new int[n];
            for(int i=0;i<n;i++)
                sequ[i]=scanner.nextInt();
            System.out.println(getMinSteps(sequ,n,0,n-1));
        }
    }
    private  static int getMinSteps(int[] sequ,int n,int from,int to){
        int left=sequ[from],right=sequ[to];
        int i=from,j=to;
        int times=0;//更改次数
        while (i<j && left!=right){
            if(left<right){
                left+=sequ[++i];
                times++;
            }else{
                right+=sequ[--j];
                times++;
            }
        }
        if(i>=j)
            return times;
        else{
            return times+getMinSteps(sequ,n,i+1,j-1);
        }
    }
}
