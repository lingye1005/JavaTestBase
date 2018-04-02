package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 16:19
 * @ProjectName: JavaBaseTest
 * 面试题3
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        int x=0,y=array[0].length-1;
        while(x<array[0].length && y>=0){
            if(array[x][y]==target)
                return true;
            if(array[x][y]<target)
                x++;
            else
                y--;
        }
        return false;
    }
}
