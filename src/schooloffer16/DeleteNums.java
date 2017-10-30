package schooloffer16;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/18.有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 */
public class DeleteNums {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N=scanner.nextInt();
            if(N>1000)
                N=1000;
            if(N==1){
                System.out.println(0);
                continue;
            }
            int[] queue=new int[N];
            for(int i=0;i<N;i++){
                queue[i]=i;
            }
            //开始删除
            int count=0;
            int from=0;//每次重新开始遍历位置
            for(int i=from;N>1;){
                if(count==2){
                    for(int j=i;N>1;){
                        if(queue[j]!=-1){
                            queue[j]=-1;
                            count=0;
                            N--;
                            if(i<queue.length-1)
                                i++;
                            else
                                i=0;
                            break;
                        }else if(j==queue.length-1){
                            j=0;
                        }else{
                            j++;
                        }
                    }
                }else{
                    if(queue[i]!=-1){
                        count++;
                        if(i<queue.length-1)
                            i++;
                        else
                            i=0;
                    }else{
                        if(i<queue.length-1)
                            i++;
                        else
                            i=0;
                    }
                }
            }
            for(int i=0;i<queue.length;i++){
                if(queue[i]!=-1){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
