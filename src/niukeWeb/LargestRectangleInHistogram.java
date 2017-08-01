package niukeWeb;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/1.
 * 思路：这题的一个基本思想是以每一个bar为最低点，向左右遍历直到遇到比他小的bar或边界。
 * 这样就能找到一个此bar为最低点的矩形面积。遍历所有的bar之后即可找到最大的矩形面积。
 * 但是向左右遍历寻找比他小的bar的时间复杂度是O(n)，在加上遍历一遍所有的bar，总的时间复杂度将为O(n*n)，是无法通过所有数据的。
 * 因此我们需要寻找一种时间复杂度更低的寻找一个bar左右边界的算法。在网上流传了一个设计极其巧妙的方法，借助一个stack可以将时间复杂度降为O(n)。
 * 算法思想:维护一个递增的栈.栈里面存放的是数组元素的下标.求的是以栈顶元素为下标的数组元素值bar为对应的矩形最低点.
 * 这样,则保证了height[bar]左侧的元素都比它小,故以height[bar]为高的矩形是从数组元素height[bar]开始的.
 * 从第一个元素开始遍历,第一个元素先入栈.如果遇到比栈顶元素小的元素,则栈顶元素出栈,求以height[bar]为矩形高的矩形面积.
 * 栈为空,则所有以height[bar]为高的矩形全部求完一遍.
 * 注意:数组最后需要增加一个元素0,是为了保证所有节点都能从栈出来.因为只有栈顶元素小于数组元素,才能出栈.
 * index:表示压入栈的数组下标.  k:表示数组当前工作下标.
 * i和k共同组成了一个双指针.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0)
            return 0;
        if(height.length==1)
            return height[0];
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
        LargestRectangleInHistogram test=new LargestRectangleInHistogram();
        int[] a=new int[]{2,1,5,6,2,3};
        int b=test.largestRectangleArea(a);
        System.out.println(b);
    }
}
