package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/5 13:27.
 * 小明同学把1到n这n个数字按照一定的顺...
 * <构造队列></构造队列>
 */
public class BuildQueue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        int n;
        while (T-->0){
            n=scanner.nextInt();
            int[] numbers=new int[n];
            int num=1;
            boolean isFind=false;//标识当前弹出元素前面,是否找到一个插入到队尾的元素,只有找到,才能弹出.
            for(int i=0;num<=n;i%=n){
                if(isFind==false && numbers[i]==0){
                    isFind=true;
                    i++;
                }else if(isFind==false && numbers[i]!=0){
                    i++;
                }else if(isFind==true && numbers[i]!=0){
                    i++;
                }else if(isFind==true && numbers[i]==0){
                    numbers[i]=num++;
                    isFind=false;
                    i++;
                }
            }
            //输出
            for(int i=0;i<n;i++){
                if(i<n-1)
                    System.out.print(numbers[i]+" ");
                else
                    System.out.println(numbers[i]);
            }
        }
    }
}
