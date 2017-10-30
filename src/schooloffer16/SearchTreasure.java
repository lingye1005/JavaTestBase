package schooloffer16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/21.
 * 亮亮解出了卷轴隐藏的秘密，来到了一片沼泽地。这里有很多空地，而面试直通卡可能埋在任意一块空地中，好在亮亮发现了一堆木材，....
 * 算法思想:并查集+最小生成树
 * 求:最小生成树中:权值最大的那个路径
 */

public class SearchTreasure {
    static class Edge{
        private int x;
        private int y;
        private int weight;
        Edge(int x,int y,int weight){
            this.x=x;
            this.y=y;
            this.weight=weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N,M;
        while (scanner.hasNext()){
            String[] str=scanner.nextLine().split(" ");
            N=Integer.valueOf(str[0]);
            M=Integer.valueOf(str[1]);

            Edge[] values=new Edge[M];
            for(int i=0;i<M;i++){
                String[] w=scanner.nextLine().split(" ");
                int x=Integer.valueOf(w[0]);
                int y=Integer.valueOf(w[1]);
                int weight=Integer.valueOf(w[2]);
                Edge edge=new Edge(x,y,weight);
                values[i]=edge;
            }
            System.out.println(solution(values,N,M));
        }
    }
    //并查集:初始化
    private static void init(int[] father,int n){
        for(int i=0;i<=n;i++)
            father[i]=i;
    }
    //并查集:查找根节点
    private static int getFather(int[] father,int x){
        int r=x;
        while (father[r]!=r) // father[x]=y:表示x点对应对根节点为y
            r=father[r];
        //压缩路径:
        int i=x;
        while (i!=r) {
            int j=father[i];
            father[i]=r;
            i=j;
        }
        return r;
    }
    //并查集:合并
    private static void mergeSet(int[] father,int fx,int fy){
        if(fx>fy){
            father[fx]=fy;
        }else {
            father[fy]=fx;
        }
    }
    //总算法
    private static int solution(Edge[] values,int n,int m){
        int result=0;
        //初始化
        int[] father=new int[n+1];
        init(father,n);
        //对valuse[]按照weight排序
        Arrays.sort(values, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        for(int i=0;i<m;i++){
            int fx=getFather(father,values[i].x);
            int fy=getFather(father,values[i].y);
            if(fx!=fy){
                if(result<values[i].weight)
                    result=values[i].weight;
                //合并节点
                mergeSet(father,fx,fy);
            }
        }
        return result;
    }
}
