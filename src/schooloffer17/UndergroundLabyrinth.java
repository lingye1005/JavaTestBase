package schooloffer17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 10:47.
 * <地下迷宫></>
 * 水平移动:消耗1个力量;
 * 向上移动:消耗3个力量;
 * 向下移动:不消耗体力;
 */
public class UndergroundLabyrinth {
    public static void main(String[] args) {
        int n,m,p;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            p=scanner.nextInt();
            int[][] lab=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    lab[i][j]=scanner.nextInt();
            }
            recursion(lab,n,m,p,0,0);
            if(isFind){
                System.out.println(sb.toString());
            }else{
                System.out.println("Can not escape!");
            }
        }
    }

    //递归
    static LinkedList<LinkedList<Integer>> path=new LinkedList<LinkedList<Integer>>();
    static boolean isFind=false;
    static int maxRemainPower=0;
    static StringBuilder sb=new StringBuilder();
    /**
     * 查找是否存在路径
     * @param map  迷宫布局情况
     * @param rows 迷宫行数
     * @param cols 迷宫列数
     * @param power 剩余能力
     * @param i 当前到达行号
     * @param j 当前到达列号
     */
    private static void recursion(int[][] map,int rows,int cols,int power,int i,int j){
        if(i<0 || i>=rows || j<0 || j>=cols || map[i][j]==0 || power<0)
            return;
        else{
            LinkedList<Integer> tmp=new LinkedList<Integer>();
            tmp.add(i);
            tmp.add(j);
            path.add(tmp);
            map[i][j]=0;//表示这个点不能再访问
            if(i==0 && j==cols-1){
                if(power>=maxRemainPower){//如果有更节省能量的路径,则路径被更新
                    maxRemainPower=power;
                    updatePath(path);
                }
                isFind=true;
                map[i][j]=1;
                path.removeLast();
                return;
            }
            //up
            recursion(map,rows,cols,power-3,i-1,j);
            //right
            recursion(map,rows,cols,power-1,i,j+1);
            //down
            recursion(map,rows,cols,power,i+1,j);
            //left
            recursion(map,rows,cols,power-1,i,j-1);
            map[i][j]=1;//回退到点(i,j),则恢复该点的原状态.
            path.removeLast();//删除节点(i,j)
        }
    }

    /**
     * 更新路径:保留最节省能量的走法
     * @param list 已经找到的一种路径走法.
     */
    private  static  void updatePath(LinkedList<LinkedList<Integer>> list){
        Iterator<LinkedList<Integer>> iterator=list.iterator();
        while (iterator.hasNext()){
            LinkedList<Integer> tmp=iterator.next();
            sb.append("["+tmp.get(0)+","+tmp.get(1)+"]"+",");
        }
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
    }
}

