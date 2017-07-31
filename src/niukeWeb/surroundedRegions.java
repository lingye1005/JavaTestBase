package niukeWeb;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/7/20.
 * 给定二维数组,数组元素为X或者O.被X围上的区域,将里面的O替换成X.
 * 显然最外围层,元素是不会变的.因为最外层的O元素永远不能被X包围.
 * 算法思想:从边上的O开始便利，所有与边上O相连的O都不能变成X（可暂时变为Y），之后再重新遍历一遍矩阵把所有O变成X，所有Y变成O。
 * 听说DFS会超时,就用BFS了
 * 已经ac
 * 注意:之前一直内存溢出,因为每次遇到一个边缘节点O,那我就加入队列,进行遍历.
 * 后来参考了网上的算法.先把所有的边缘节点O都放入队列,然后对这个队列遍历
 * 我倒是觉得我这样更省内存 ,但是为什么不对,没太明白
 */
class Pair{
    int x,y;
    Pair(int x0,int y0){
        this.x=x0;
        this.y=y0;
    }
}
public class surroundedRegions {
    /**
     * 主方法
     * @param board
     */
    LinkedList<Pair> queue=new LinkedList<Pair>();  //存放边缘点为0的点下标

    public void solve(char[][] board) {
        //需要遍历的行号:1~rows-2
        //需要遍历的列号:1~columns-2
        if(board==null || board.length==0)
            return;
        int rows=board.length;  //行数  0~rows-1
        int columns=board[0].length;//列数  0~columns-1
        if(rows<=2 || columns<=2)
            return;
        //第0行
        for(int j=0;j<columns-1;j++){
            if(board[0][j]=='O'){
                queue.add(new Pair(0,j));
            }
        }
        //第rows-1行
        for(int j=0;j<columns;j++){
            if(board[rows-1][j]=='O')
              queue.add(new Pair(rows-1,j));
        }
        //第0列
        for(int i=1;i<rows-1;i++){
            if(board[i][0]=='O')
                queue.add(new Pair(i,0));
        }
        //第columns-1列
        for(int i=1;i<rows-1;i++){
            if(board[i][columns-1]=='O')
                queue.add(new Pair(i,columns-1));
        }
        while(!queue.isEmpty()){
            Pair point=queue.poll();
            int x=point.x;
            int y=point.y;
            changeOToY(x,y,rows,columns,board);
        }
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<columns-1;j++){
                //O转为x,y转为o
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='Y')
                    board[i][j]='O';
            }
        }
    }




    void changeOToY(int i,int j,int rows,int columns,char[][] board){

        Pair point=new Pair(i,j);
        queue.add(point);//O,i,j
        while(!queue.isEmpty()) {
            //获取行号,列号
            Pair temp=queue.poll();
            int row=temp.x;
            int column=temp.y;
            //非边缘节点才转为Y
            if(row!=0 && row!=rows-1 && column!=0 && column!=columns-1)
                board[row][column]='Y';

            //point(row,column)
            //上 (row-1,column)
            if(row-1>0 && column!=0  && column!=columns-1 && board[row-1][column]=='O')
                queue.add(new Pair(row-1,column));
            //下 (row+1,column)
            if(row+1<rows-1 && column!=0  && column!=columns-1 && board[row+1][column]=='O')
                queue.add(new Pair(row+1,column));
            //左 (row,column-1)
            if(column-1>0 && row!=0 && row!=rows-1 && board[row][column-1]=='O')
                queue.add(new Pair(row,column-1));
            //右 (row,column+1)
            if(column+1<columns-1  && row!=0 && row!=rows-1 && board[row][column+1]=='O')
                queue.add(new Pair(row,column+1));
        }
    }

    /**
     *  测试方法
     * @param args
     */
    public static void main(String[] args) {
        surroundedRegions test=new surroundedRegions();
        char[][] a=new char[5][5];
        a[0][0]='O';a[0][1]='X';a[0][2]='X';a[0][3]='O';a[0][4]='X';
        a[1][0]='X';a[1][1]='O';a[1][2]='O';a[1][3]='X';a[1][4]='O';
        a[2][0]='X';a[2][1]='O';a[2][2]='X';a[2][3]='O';a[2][4]='X';
        a[3][0]='O';a[3][1]='X';a[3][2]='O';a[3][3]='O';a[3][4]='O';
        a[4][0]='X';a[4][1]='X';a[4][2]='O';a[4][3]='X';a[4][4]='O';
        test.solve(a);

        for(int i=0;i<4;i++){
            System.out.println(i);
        }
        test.time();
    }

    void time(){
        System.out.println(111);
        System.out.println(23322);
    }
}
