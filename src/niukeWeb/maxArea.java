package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/15.
 * 找出给定数组,非负数组元素ai代表:点(i,ai);
 * 找出两个点,垂直向下延长到x轴,和x轴组成一个地面水平的容器.求所有点组合中容器最大的两个点.
 */
public class maxArea {
    public int maxArea(int[] height) {
        if(height==null || height.length<2)
            return 0;
        int len=height.length;
        int maxArea=Integer.MIN_VALUE;
        //从左到右
         for(int i=0;i<len;i++){
             for(int j=i+1;j<len;j++){
                 //数组下标(i,ai),(j,aj)
                 int minHeight=Math.min(height[i],height[j]);
                 if((j-i)*minHeight>maxArea)
                     maxArea=(j-i)*minHeight;

             }
         }
        return maxArea;
    }
}
