package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/21.
 * 原来是要到醋溜站台乘坐醋溜快车到醋溜港”，亮亮解出了地图隐藏的秘密，赶紧奔向醋溜站台，但到了之后，亮亮忧桑地发现，
 * 从醋溜站台到醋溜港沿途的每个车站都有很多美女被他飒爽的英姿所吸引，只要经过车站就会被这些漂亮的女孩搭讪，但是现在亮亮一心想要寻找楚楚街而没空去搭理她们，
 * 所以亮亮希望在抵达醋溜港的时候被搭讪的次数最少。问亮亮抵达醋溜港最少会被搭讪多少次？
 *
 * 一直ac不过,原来是因为:本题是做无向图处理的,而我当作有向图处理了.所以,添加了第34行代码,就ac了.
 */
public class Trival {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int N=scanner.nextInt();//N个站台
            int M=scanner.nextInt();//M条公路
            int[] tmp=new int[N+1];//每个站台的搭讪美女个数
            for(int i=1;i<=N;i++)
                tmp[i]=scanner.nextInt();
            int[][] weights=new int[N+1][N+1];
            //初始化无穷大
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++)
                    weights[i][j]=Integer.MAX_VALUE;
            }

            for(int i=0;i<M;i++){
                int from=scanner.nextInt();
                int to=scanner.nextInt();
                //因是无向图,所以权重同时有2个被赋值
                weights[from][to]=tmp[to];//这里只是记录了从a到b时候,b的权重,作为边的权重.所以最后整条路径上,自然找了起点的权重.故最后输出结果必须加上起点的权重.
                weights[to][from]=tmp[from];
            }
            System.out.println(dijkstra(weights,1)+tmp[1]);
        }
    }

    /**
     * 单源最短路径
     * @param weights 权重矩阵
     * @param start 开始节点编号
     * @return
     */
    private static int dijkstra(int[][] weights,int start){
        int n=weights.length;//顶点个数+1
        int[] dist=new int[n]; //保存:从start出发,到其他各个顶点的最短路径
        boolean[] isVisited=new boolean[n];//记录节点的最短路径是否已经求出,true表示已经求出
        //初始化第一个节点
        dist[1]=0;
        isVisited[1]=true;

        int k;
        for(int i=2;i<n;i++){ //需要访问所有节点
            k=-1;
            int minValue=Integer.MAX_VALUE;
            for(int j=1;j<n;j++){ //查找一个距离start最近的节点
                if(!isVisited[j] && weights[start][j]<minValue){
                    k=j;
                    minValue=weights[start][j];
                }
            }
            /**注意:可能出现情况:就是n个节点并没有遍历完,但是已经找不到:节点既未被遍历同时,由当前已经遍历的节点能到达这些未被遍历的点.说明这些点,是无法到达的
             * 当然了,如果输入合法的话,这种情况是不会出现的,但是不能保证输入一定合法,也就是一定存在从start到其他各个顶点都有路径,毕竟这是一个有向图
             */
            if(k==-1)
                break;
            //修改节点k的值
            dist[k]=minValue;
            isVisited[k]=true;

            //修改其他未访问节点,在经过中间节点k后,新的最短路径
            for(int j=1;j<n;j++){
                if(!isVisited[j] &&  weights[k][j]!=Integer.MAX_VALUE &&  weights[start][k]+weights[k][j]<weights[start][j] ){
                    weights[start][j]=weights[start][k]+weights[k][j];
                }
            }
        }
        return weights[start][n-1];
    }
}
