package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/24.
 * 给定一个三角形,从三角形顶部走到底部,每次移动规则:从当前顶点只能到达下一行的与之相邻的2个顶点.
 * 求:在走过的路径中,路径上数字和最小的路径.
 * 分析：从最下面一层开始往上计算，设dp[i][j]是以第i层j个元素为起点的最小路径和，动态规划方程如下
 *      dp[i][j] = value[i][j] + max{dp[i-1][j], dp[i-1][j+1]}
 * 动态规划
 */
public class triangleMinimumTotal {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //行数
        int size=triangle.size();
        //为dp数组赋初始值,即为最后一行的数值.因为需要从最后一行开始,往上进行计算.
        ArrayList<Integer> dp=triangle.get(size-1);
        //循环赋值
        for(int i=size-2;i>-1;i--){  //从倒数第二行开始,往上修改
            for(int j=0;j<=i;j++){   //从左到右开始,修改
                dp.set(j,triangle.get(i).get(j)+Math.min(dp.get(j),dp.get(j+1)));
            }
        }
        return dp.get(0);
    }
}
