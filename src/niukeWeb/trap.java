package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/7.
 * 题目需要求的是矩阵作为容器能盛多少体积的水。
 * 思路：考虑到所盛的水取决于容器两端中小的那一端。因此用两个指针，分别指向头和尾，依次向中间移动。
 *1.如果左边小，则左边向右移动一格，这个时候需要判断向右移动一格后
 *    ①如果高度大于原来的就表示盛不下水
 *    ②如果小于原来的则表示有凹下去的部分，这个时候计算高度差就代表能盛多少水。(右边比左边高，可以保证右边不溢出)
 2.如果右边小，则右边向左移动一格，这个时候同1一样判断。
 */
public class trap {
    public int trap(int[] A) {
        if(A==null || A.length==0 || A.length==1)
            return 0;
        int len=A.length;
        int left=0,right=len-1;
        int lnum=A[left],rnum=A[right];
        int water=0;
        while(left<right){  //左右指针碰撞截止
            if(lnum<=rnum){
                left++;
                if(A[left]>=lnum){
                    lnum=A[left];
                }else{
                    water+=lnum-A[left];
                }
            }else{
                if(A[right]>=rnum){
                    rnum=A[right];
                }else{
                    water+=rnum-A[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        trap test=new trap();
        //int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] a={0,2,0};
        System.out.println(test.trap(a));
    }
}
