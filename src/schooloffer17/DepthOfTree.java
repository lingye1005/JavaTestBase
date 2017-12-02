package schooloffer17;

import java.util.*;

/**
 * @Author: cxh
 * @CreateTime: 17/11/26 21:07
 * @ProjectName: JavaBaseTest
 * <树的高度></>
 */
class Node{
    int parent;
    int self;
    Node(int parent,int self){
        this.parent=parent;
        this.self=self;
    }
}
public class DepthOfTree {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            int[][] array=new int[n-1][2];
            for(int i=0;i<n-1;i++){
                array[i][0]=scanner.nextInt();
                array[i][1]=scanner.nextInt();
            }
            Arrays.sort(array, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0]){
                        return o1[1]-o2[1];
                    }else{
                        return o1[0]-o2[0];
                    }
                }
            });
            Queue<Integer>  queue=new LinkedList<Integer>();
            boolean[] isVisited=new boolean[n];
            //层序遍历
            int front=-1,rear=-1;
            int last=0,level=0;
            queue.add(array[0][0]);
            rear++;
            isVisited[array[0][0]]=true;
            int parent;
            while (!queue.isEmpty()){
                parent=queue.poll();
                front++;
                int count=0;//如果一个节点有超过2个孩子,那么后续节点的孩子不再入队,因为题目要求是二叉树.如果没有count的约束,则此代码可以作为多叉树求解
                for(int i=0;i<n-1 && rear<n-1;i++){
                    boolean is=false;
                    if(parent==array[i][0] && isVisited[array[i][1]]==false){
                        queue.add(array[i][1]);
                        rear++;
                        isVisited[array[i][1]]=true;
                        is=true;//第一次找到后,做标记,下次找不到,则应该break,减少遍历时间
                        count++;
                    }else if(parent!=array[i][0] && is){
                        break;
                    }
                    if(count==2)
                        break;
                }
                if(front==last){
                    level++;
                    last=rear;
                }
            }
            System.out.println(level);
        }
    }
}
