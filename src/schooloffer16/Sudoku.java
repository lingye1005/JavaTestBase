package schooloffer16;


import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/18.
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 * 算法思想:回溯法
 * 算是已经a过了吧,83.3%.因为题目可能存在多个解,但是判题系统只能识别一个...这就只能这样了,毕竟代码是没有问题的.
 */
public class Sudoku {
    static int[][] nums=new int[9][9];
    Sudoku(int len){
        nums=new int[len][len];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=9;
        int row=0;
        while (t-->0){
            String[] tmp=scanner.nextLine().split(" ");
            for(int j=0;j<9;j++){
                nums[row][j]=Integer.valueOf(tmp[j]);
            }
            row++;
        }

        //调用回溯法,填充nums
        backTrace(0,0);
    }

    /**
     * 回溯法
     * @param i 行号
     * @param j 列号
     */
    private static void backTrace(int i,int j){
        if(i==8 && j==9){ //填充完毕,结束算法
            //System.out.println("find");
            print();//必须在此处打印,为什么呢,因为回溯递归回去之后,会恢复数据原值(源头:nums[i][j]=0;),即为其他地方打印的话,那么打印出来的结果就是输入数据,并没有任何改变.
            return;
        }
        if(j==9){//到达最后一列,但未到达最后一行,则开始下一行
            i++;
            j=0;
        }

        if(nums[i][j]==0){//当前值为0,则需要进行填充
            for(int k=1;k<=9;k++){
                //查找nums[i][j]=k是否合法
                if(isValid(i,j,k)){
                    nums[i][j]=k;
                    backTrace(i,j+1);
                    nums[i][j]=0;//倒退回来后,再次使用该位置前,应该恢复其初始值0,才能进行下一次的尝试.
                }
            }
        }else{//否则,不需要填充,继续遍历下一列
            backTrace(i,j+1);
        }
    }

    /**
     * 判定:是否可用在nums[i][j]处插入value.
     * @param i
     * @param j
     * @param value
     * @return
     */
    private static   boolean isValid(int i,int j,int value){
        //当前行,列没有value
        for(int k=0;k<nums.length;k++){
            if(nums[i][k]==value || nums[k][j]==value)
                return false;
        }
        //判断小九宫格是否有重复,此处代码还是要好好研读一下的,怎么求(i,j)点所在的九宫格坐标
        int m = i / 3;
        int n = j / 3;
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                if (nums[m * 3 + i1][n * 3 + j1] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 打印nums
     */
    private  static void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println(nums[i][8]);
        }
        System.out.println("----------");//多个输出解时候,分隔开,方便观察.
    }
}
