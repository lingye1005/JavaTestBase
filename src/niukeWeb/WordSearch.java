package niukeWeb;

/**
 * Created by caoxiaohong on 17/8/15.
 * 给定一个2D板和一个单词，找出这个单词是否存在于网格中。
 * 该单词可以由顺序相邻单元的字母构成，其中“相邻”单元是水平或垂直相邻的单元。 相同的字母单元可能不会被多次使用。
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.equals(""))
            return true;
        if(board==null || board.length==0 )
            return false;
        int rows=board.length;
        int columns=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(word.charAt(0)==board[i][j] && dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board,String word,int row,int column,int index){
        if(index==word.length()-1){  //查找到word最后一个字符,说明已经找到
            return true;
        }
        //改变当前单元格的值,保证下次不会再使用这个单元格的内容.
        char temp=board[row][column];
        board[row][column]='*';
        //up
        if(row-1>=0 && board[row-1][column]==word.charAt(index+1)){
            if(dfs(board,word,row-1,column,index+1)){
                return true;
            }
        }
        //down
        if(row+1<=board.length-1 && board[row+1][column]==word.charAt(index+1)){
            if(dfs(board,word,row+1,column,index+1))
                return true;
        }
        //left
        if(column-1>=0 && board[row][column-1]==word.charAt(index+1)){
            if(dfs(board,word,row,column-1,index+1)){
                return true;
            }
        }
        //right
        if(column+1<=board[0].length-1 && board[row][column+1]==word.charAt(index+1)){
            if(dfs(board,word,row,column+1,index+1)){
                return true;
            }
        }
        //本次dfs结束时候,恢复单元格值,为下个dfs准备好board原值
        board[row][column]=temp;
        return false;
    }

    public static void main(String[] args) {
        WordSearch test=new WordSearch();
        char[][] board=new char[3][4];
        board[0][0]='A';board[0][1]='B';board[0][2]='C';board[0][3]='E';
        board[1][0]='S';board[1][1]='F';board[1][2]='C';board[1][3]='S';
        board[2][0]='A';board[2][1]='D';board[2][2]='E';board[2][3]='E';
        String a="ABCCED";
        String b="SEE";
        String c="ABCB";

        System.out.println(test.exist(board,a));
        System.out.println(test.exist(board,b));
        System.out.println(test.exist(board,c));
    }
}
