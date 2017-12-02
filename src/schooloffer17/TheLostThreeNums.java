package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/21 17:22
 * @ProjectName: JavaBaseTest
 * <丢失的三个数字></>
 */
public class TheLostThreeNums {
    public static void main(String[] args) {
        //输入9997个数字
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int[] numbers=new int[9997];
            int idx=0;
            for(int i=0;i<9997;i++){
                numbers[idx++]=scanner.nextInt();
            }
            Arrays.sort(numbers);
            int first=-1,second=-1,third=-1;
            for(int i=1;i<9997;i++){
                if(numbers[i]-numbers[i-1]==2){
                    if(first==-1)
                        first=numbers[i]-1;
                    else if(second==-1)
                        second=numbers[i]-1;
                    else{
                        third=numbers[i]-1;
                        break;
                    }
                }
            }
            String res=String.valueOf(first)+String.valueOf(second)+String.valueOf(third);
            System.out.println(Long.valueOf(res)%7);
        }
    }
}
