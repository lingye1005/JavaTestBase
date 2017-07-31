package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/25.
 * 给定有序矩阵,每行数据递增;且下一行第一个数据>上一行最后一个数据.查找给定value是否存在
 *
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int rows = matrix.length;//行数
        int columns = matrix[0].length;//列数
        for (int i = 0; i < rows; i++) {
            if (matrix[i][columns - 1] == target)
                return true;
            else if (matrix[i][columns - 1] < target) {//不在当前行
                continue;//继续循环
            } else {//在当前行
                for (int j = 0; j < columns - 1; j++) {
                    if (matrix[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
