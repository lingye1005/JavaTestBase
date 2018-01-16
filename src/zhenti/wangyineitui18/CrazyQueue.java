package zhenti.wangyineitui18;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/5 19:12
 * @ProjectName: JavaBaseTest
 * <疯狂队列></>
 * 100%
 */
public class CrazyQueue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//n(1 ≤ n ≤ 50),表示学生的人数
            int[] height=new int[n];//h[i](1 ≤ h[i] ≤ 1000)
            for(int i=0;i<n;i++)
                height[i]=scanner.nextInt();
            Arrays.sort(height);
            int res=0;
            Deque<Integer> deque=new LinkedList<>();//双端队列
            deque.add(height[n-1]);//入队最大元素
            if(n>=2) {
                deque.addFirst(height[0]);
                res+=Math.abs(height[n-1]-height[0]);
            }
            if(n>2) {
                deque.addLast(height[1]);
                res+=Math.abs(height[n-1]-height[1]);
            }
            int from=2,end=n-2;
            int head,tail;
            int d1,d2,d3,d4;
            while (from<=end){
                head=deque.peekFirst();
                tail=deque.peekLast();
                d1=Math.abs(head-height[from]);
                d2=Math.abs(head-height[end]);
                d3=Math.abs(tail-height[from]);
                d4=Math.abs(tail-height[end]);
                if(d1>=d2 && d1>=d3 && d1>=d4){
                    res+=d1;
                    deque.addFirst(height[from++]);
                }else if(d2>=d1 && d2>=d3 && d2>=d4){
                    res+=d2;
                    deque.addFirst(height[end--]);
                }else if(d3>=d1 && d3>=d2 && d3>=d4){
                    res+=d3;
                    deque.addLast(height[from++]);
                }else if(d4>=d1 && d4>=d2 && d4>=d3){
                    res+=d4;
                    deque.addLast(height[end--]);
                }
            }
            System.out.println(res);
        }
    }
}
