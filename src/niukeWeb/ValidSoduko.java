package niukeWeb;

import java.util.HashSet;

/**
 * Created by caoxiaohong on 17/8/9.
 * 问题描述：判断一个数独游戏是否合法。数独当前可以是部分填充，未填充部分用'.'代替。有效地数独并不是指该游戏是否有解，而仅仅判断当前填充是否有效。
 * 数独有效是指：每一行，每一列，以及每个小得九宫格的当前填充是否有重复数字。
 * 思路：看到题目，分析完成后的直接思路是，分别判断数独的每一行，每一列，每九宫格是否含有相同的数字，如果含有就不是有效地数独。
 */
public class ValidSoduko {
    public boolean isValidSudoku(char[][] board) {
        int rows=board.length;
        int columns=board[0].length;
        //行\列判定
        for(int i=0,j=0;i<rows && j<columns;i++,j++){
            HashSet<Character> mapi=new HashSet<Character>();
            HashSet<Character> mapj=new HashSet<Character>();
            for(int k=0;k<rows;k++){
                //i行
                char stri=board[i][k];
                if(mapi.contains(stri) && stri!='.'){
                    return false;
                }else if(!mapi.contains(stri)){
                    mapi.add(stri);
                }
                //j列
                char strj=board[k][j];
                if(mapj.contains(strj) && strj!='.'){
                    return false;
                }else if(!mapj.contains(strj)){
                    mapj.add(strj);
                }
            }
        }
        //宫判定
        int i,j;
        for( i=0;i<rows-2;){
            for(j=0;j<columns-2;){
                HashSet<Character> set=new HashSet<Character>();
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        if(board[i+x][j+y]!='.'){
                            if(set.contains(board[i+x][j+y]))
                                return false;
                            else
                                set.add(board[i+x][j+y]);
                        }
                    }
                }
                j=j+3;
            }
            i=i+3;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSoduko test=new ValidSoduko();
        char[][] a=new char[9][9];
        a[0][0]='.';a[0][1]='8';a[0][2]='7';a[0][3]='6';a[0][4]='5';a[0][5]='4';a[0][6]='3';a[0][7]='2';a[0][8]='1';
        a[1][0]='2';a[1][1]='.';a[1][2]='.';a[1][3]='.';a[1][4]='.';a[1][5]='.';a[1][6]='.';a[1][7]='.';a[1][8]='.';
        a[2][0]='3';a[2][1]='.';a[2][2]='.';a[2][3]='.';a[2][4]='.';a[2][5]='.';a[2][6]='.';a[2][7]='.';a[2][8]='.';
        a[3][0]='4';a[3][1]='.';a[3][2]='.';a[3][3]='.';a[3][4]='.';a[3][5]='.';a[3][6]='.';a[3][7]='.';a[3][8]='.';
        a[4][0]='5';a[4][1]='.';a[4][2]='.';a[4][3]='.';a[4][4]='.';a[4][5]='.';a[4][6]='.';a[4][7]='.';a[4][8]='.';
        a[5][0]='6';a[5][1]='.';a[5][2]='.';a[5][3]='.';a[5][4]='.';a[5][5]='.';a[5][6]='.';a[5][7]='.';a[5][8]='.';
        a[6][0]='7';a[6][1]='.';a[6][2]='.';a[6][3]='.';a[6][4]='.';a[6][5]='.';a[6][6]='.';a[6][7]='.';a[6][8]='.';
        a[7][0]='8';a[7][1]='.';a[7][2]='.';a[7][3]='.';a[7][4]='.';a[7][5]='.';a[7][6]='.';a[7][7]='.';a[7][8]='.';
        a[8][0]='9';a[8][1]='.';a[8][2]='.';a[8][3]='.';a[8][4]='.';a[8][5]='.';a[8][6]='.';a[8][7]='.';a[8][8]='.';
        System.out.println(test.isValidSudoku(a));
    }
    public final void get(){}
    static final void g(){}
}
