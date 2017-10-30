package schooloffer16;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/23.
 * “呼！！终于到了，可是接下来要怎么走才能到达楚楚街港港呢？”亮亮在醋溜港直发愁。 突然“啾”的一下，一只银色小船出现在亮亮的面前，上面坐着小精灵丹丹“又见面了，有什么可以帮助你的么？....
 * 算法思想:dijkstra
 */
class Range{
    int P,Q,X,Y;
    Range(int p,int q,int x,int y){
        this.P=p;
        this.Q=q;
        this.X=x;
        this.Y=y;
    }
}
public class AirRoute {
    static int minLen=Integer.MAX_VALUE;//结果
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            //N个港，M条航线
            int N=scanner.nextInt();
            int M=scanner.nextInt();

            //每行包含五个整数P,Q(1<=P,Q<=n), K(1<=K<=1000), X,Y(0<=X,Y<=10000),代表P,Q两个港有航线并需要K天，并且该航线在第X天到第Y天天气恶劣不可通行。
            int[][] matrix=new int[N+1][N+1];
            for(int i=0;i<N+1;i++){
                for(int j=0;j<N+1;j++){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
            ArrayList<Range> ranges=new ArrayList<Range>();
            int p,q,k,x,y;
            for(int i=0;i<M;i++){
                p=scanner.nextInt();
                q=scanner.nextInt();
                k=scanner.nextInt();
                x=scanner.nextInt();
                y=scanner.nextInt();
                //if是因为阴天而比普通dijkstra多出来的内容
                if(p==1 || q==1){
                    k= ( (k>=x && k<=y) || (k>=y))?y+k:k;
                }
                matrix[p][q]=k;
                matrix[q][p]=k;

                //下面4行code也是因为阴天而多出来的内容
                Range tmp=new Range(p,q,x,y);
                ranges.add(tmp);
                tmp=new Range(q,p,x,y);
                ranges.add(tmp);

            }
            //调用算法
            dijkstra(matrix,ranges,1);
            System.out.println(matrix[1][N]+1);
        }
    }

    /**
     * 主算法
     * @param matrix 临接矩阵
     * @param ranges 阴雨天时间范围
     * @param start  起点
     */
    private static void dijkstra(int[][] matrix,ArrayList<Range> ranges,int start){
        int n=matrix.length;//0~(n-1):实际上只有n-1个点.
        boolean[] isVisited=new boolean[n];
        isVisited[start]=true;//初始化节点start

        int k;
        for(int i=1;i<=n-2;i++){//将n-1个节点添加进来
            k=-1;
            int minValue=Integer.MAX_VALUE;
            for(int j=1;j<n;j++){//查找从start到j最短的点
                if(j!=start && !isVisited[j] && matrix[start][j]<minValue){
                    k=j;
                    minValue=matrix[start][j];
                }
            }
            isVisited[k]=true;

            //添加了k节点后,修改其他未访问的各个节点的最短路径
            for(int j=1;j<n;j++){
                if(!isVisited[j] && matrix[k][j]!=Integer.MAX_VALUE){
                    //下面的code是和阴天有关系的操作,和普通dijkstra不同的地方
                    int min;
                    int fromDay=-1,toDay=-1;
                    for(int m=0;m<ranges.size();m++){
                        if(ranges.get(m).P==k  && ranges.get(m).Q==j){
                            fromDay=ranges.get(m).X;
                            toDay=ranges.get(m).Y;
                            break;
                        }
                    }
                    if(fromDay==-1)
                        continue;
                    if( (matrix[start][k]>=fromDay && matrix[start][k]<=toDay) || (matrix[start][k]+matrix[k][j]>=fromDay && matrix[start][k]<=fromDay)){
                        min=toDay+matrix[k][j];
                    }else{
                        min=matrix[start][k]+matrix[k][j];
                    }
                    if(min<matrix[start][j])
                        matrix[start][j]=min;
                }
            }
        }
    }
}
