package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/29.
 * 旋转填充数组,填充数字从1到n.填充规则如下:
 *Given n =3,
 * You should return the following matrix:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]
 */
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int up=0,down=n-1;
        int left=0,right=n-1;
        if(up==down) {  //n=1
            int[][] a=new int[1][1];
            a[0][0]=1;
            return a;
        }
        int[][] result=new int[n][n];
        int num=1;//填充数字num
        while(up<=down && left<=right){
            //up
            for(int i=left;i<right;i++){
                result[up][i]=num++;
            }
            //right
            for(int i=up;i<down;i++){
                result[i][right]=num++;
            }
            //down
            for(int i=right;i>left;i--){
                result[down][i]=num++;
            }
            //left
            for(int i=down;i>up;i--){
                result[i][left]=num++;
            }
            if(up==down && up==left)  //奇数个节点时,处理最中间的那个节点
                result[up][down]=num;
            //更新up,down,left,right
            up++;
            down--;
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        generateMatrix test=new generateMatrix();
        int[][] a=test.generateMatrix(3);
        int[][] b=test.generateMatrix(4);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("------------");
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+",");
            }
            System.out.println();
        }
    }
}
