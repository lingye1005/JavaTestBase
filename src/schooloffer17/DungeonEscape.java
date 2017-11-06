package schooloffer17;

import java.util.*;

/**
 * Created by caoxiaohong on 17/11/3 10:48.
 * <地牢逃脱/>
 * 考察算法:层序遍历BFS
 */
public class DungeonEscape {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;//n行m列矩阵
        int x,y;//其实位置(x,y)
        int k;//牛牛合法的步长数 种类总数

        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            scanner.nextLine();//换行
            //输入地牢情况
            char[][] condition=new char[n][m];
            boolean[][] isVisited=new boolean[n][m];//当前节点是否被访问
            for(int i=0;i<n;i++){
                String tmp=scanner.nextLine();
                for(int j=0;j<m;j++){
                    condition[i][j]=tmp.charAt(j);
                    if(condition[i][j]=='X')
                        isVisited[i][j]=true;//不能被访问的点直接赋值为:已经被访问.
                }
            }

            x=scanner.nextInt();
            y=scanner.nextInt();
            k=scanner.nextInt();

            //输入合法步长情况
            int[][] steps=new int[k][2];
            for(int i=0;i<k;i++){
                steps[i][0]=scanner.nextInt();
                steps[i][1]=scanner.nextInt();
            }

            int front=-1,rear=-1;
            int last=0,level=0;
            Queue<String> queue=new LinkedList<String>();
            queue.add(x+","+y);
            isVisited[x][y]=true;
            rear++;
            while(!queue.isEmpty()){
                String[] xy=queue.poll().split(",");
                front++;
                for(int i=0;i<k;i++){
                    int tox=Integer.valueOf(xy[0])+steps[i][0];
                    int toy=Integer.valueOf(xy[1])+steps[i][1];
                    if(tox>=0 && tox<n && toy>=0 && toy<m && isVisited[tox][toy]==false){
                        queue.add(tox+","+toy);
                        isVisited[tox][toy]=true;
                        rear++;
                    }
                }
                if(front==last){
                    last=rear;
                    level++;
                }
            }
            if(level==1 || !isVisitedAll(isVisited))
                System.out.println(-1);
            else
                System.out.println(level-1);
        }
    }

    /**
     * 是否遍历完所有点
     * @param isVisited
     * @return
     */
    private  static boolean isVisitedAll(boolean[][] isVisited){
        int rows=isVisited.length;
        int cols=isVisited[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isVisited[i][j]==false)
                    return false;
            }
        }
        return true;
    }
}
