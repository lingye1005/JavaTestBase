package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/27.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * 算法思想:在后续遍历得到的序列中，最后一个元素为树的根结点。从头开始扫描这个序列，比根结点小的元素都应该位于序列的左半部分；
 * 从第一个大于跟结点开始到跟结点前面的一个元素为止，所有元素都应该大于跟结点，因为这部分元素对应的是树的右子树。
 * 根据这样的划分，把序列划分为左右两部分，我们递归地确认序列的左、右两部分是不是都是二元查找树。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len=sequence.length;
        return helper(sequence,0,len-2,sequence[len-1]);
    }

    /**
     * 辅助函数
     * @param sequence
     * @param from 比较起点
     * @param to 比较终点
     * @param compNum 根节点值
     * @return
     */
    private boolean helper(int[] sequence,int from,int to,int compNum){
        if(from>=to)
            return true;
        boolean find=false;
        int i,index=from;
        for(i=from;i<=to;i++){
            if(find && sequence[i]<compNum)
                return false;
            if(sequence[i]>compNum) {
                find = true;
                index=i;
            }
        }
        if(index>from)//左子树,右子树均有
            return helper(sequence,from,index-2,sequence[index-1]) && helper(sequence,index,to-1,sequence[to]);
        else //只有右子树
            return helper(sequence,index,to-1,sequence[to]);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST t=new VerifySquenceOfBST();
        int[] a={5,7,6,9,11,10,8};
        int[] b={7,4,6,5};
        System.out.println(t.VerifySquenceOfBST(a));
        System.out.println(t.VerifySquenceOfBST(b));
    }
}
