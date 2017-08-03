package niukeWeb;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/3.
 * 给定一个矩阵,各个点上值为0或者1.求最大矩形面积:这个矩形里面包含的数字必须都是1
 * 这个题和"LargestRectangleInHistogram"题目很像.
 * 故需要现将matrix每一层都优化为一个一维数组,然后根据优化数组得到直方图.就能计算出最大矩形.
 * 一维数组元素值:从当前节点往上都是1的最高高度.
 * 时间复杂度:o(n*n)
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int maxArea=0;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[][] heights=new int[rows][columns];
        //初始化heights
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i==0){
                    if(matrix[i][j]=='0')
                        heights[i][j]=0;
                    else {
                        heights[i][j]=1;
                    }
                }else{
                    if(matrix[i][j]=='0'){
                        heights[i][j]=0;
                    }else{
                        heights[i][j]=heights[i-1][j]+1;
                    }
                }
            }
        }
        //对heights每一行数组求最大矩形
        for(int i=0;i<rows;i++){
            int temp=getRowMaxArea(heights[i]);
            if(maxArea<temp){
                maxArea=temp;
            }
        }

        return maxArea;
    }
    int  getRowMaxArea(int[] height){
        int len=height.length; //数组长度
        int area=0;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(0);
        for(int k=1;k<len;){
            if(stack.isEmpty() || (!stack.isEmpty() && height[k]>=height[stack.peek()])){
                stack.push(k);
                k++;
            }else{
                while(!stack.isEmpty() && height[k]<height[stack.peek()]){
                    int index=stack.pop();
                    int width=height[index];
                    int length=0;
                    if(!stack.isEmpty()){
                        length=k-stack.peek()-1;
                    }else{
                        length=k;
                    }
                    if(width*length>area)
                        area=width*length;
                }
            }
        }
        //最后stack肯定不为空,需要做处理
        while(!stack.isEmpty()){
            int index=stack.pop();
            int width=height[index];
            int length=0;
            if(!stack.isEmpty()){
                length=len-stack.peek()-1;
            }else{
                length=len;
            }
            //len-index;
            if(width*length>area)
                area=width*length;
        }
        return area;
    }



    public static void main(String[] args) {
        MaximalRectangle a=new MaximalRectangle();
        char[][] t1=new char[1][2];
        t1[0][0]='1';
        t1[0][1]='0';
        System.out.println(a.maximalRectangle(t1));

        char[][] t2=new char[3][3];
        t2[0][0]='0';t2[0][1]='1';t2[0][2]='0';
        t2[1][0]='1';t2[1][1]='1';t2[1][2]='1';
        t2[2][0]='1';t2[2][1]='0';t2[2][2]='0';
        System.out.println(a.maximalRectangle(t2));

        char[][] t3=new char[1][2];
        t3[0][0]='0';
        t3[0][1]='0';
        System.out.println(a.maximalRectangle(t3));
    }
}
