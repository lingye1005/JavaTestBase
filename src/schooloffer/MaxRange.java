package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/16.
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 */
public class MaxRange {
    public static void main(String[] args) {
        //BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        Scanner input=new Scanner(System.in);
        int n;
        try{
            while (input.hasNext()){
                String str1=input.nextLine();
                n=Integer.valueOf(str1);//输入n个数 ,范围:1<=n<=100
                if(n<=2){
                    System.out.println(0);
                    break;
                }
                int[] nums=new int[n];
                String str2=input.nextLine();
                String[] str3=str2.split(" ");
                int idx=n;
                while (--idx>=0){
                    nums[idx]=Integer.valueOf(str3[idx]);
                }

                //求未改变时最大间隔max1,max2;依次为最大,次大;
                int max1,max2;
                max1=nums[2]-nums[1];
                max2=-1;
                for(int i=3;i<n;i++){
                    if(nums[i]-nums[i-1]>max1){
                        int tmp=max1;
                        max1=nums[i]-nums[i-1];
                        max2=tmp;
                        continue;
                    }
                    if(nums[i]-nums[i-1]>max2 && nums[i]-nums[i-1]!=max1)
                        max2=nums[i]-nums[i-1];
                }

                //删除数字后,新删除位置肯定会出现更大间隔,但是上个遍历过程中出现的max1一定是在:新旧间隔中最小的那个.所以直接返回max1值既可.
                System.out.println(max1);
            }
        }catch (Exception e){

        }
    }
}
