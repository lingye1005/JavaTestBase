package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/29.
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，....
 * 实质:满二叉树的中序遍历.根节点为down,其他节点递归定义:左孩子为down && 右孩子为up
 */

public class FoldPaper {
    int idx=0;
    public String[] foldPaper(int n) {
        // write code here
        //高度为n的满二叉树的中序遍历
        String[] ret=new String[(int)Math.pow(2,n)-1];
        inOrder(1,n,ret,true);
        return ret;
    }

    /**
     * 中序遍历
     * @param i 第i次折叠
     * @param n 折叠n次
     * @param ret 结果集
     * @param isLeft 是否是左子树 :true是 & false不是
     */
    private void inOrder(int i,int n,String[] ret,boolean isLeft){
        if(i==n){
            if(isLeft)
                ret[idx++]="down";
            else
                ret[idx++]="up";
            return;
        }else{
            inOrder(i+1,n,ret,true);
            if(isLeft){
                ret[idx++]="down";
            }else{
                ret[idx++]="up";
            }
            inOrder(i+1,n,ret,false);
        }
    }

    public static void main(String[] args) {
        FoldPaper t=new FoldPaper();
        String[] a=t.foldPaper(4);
        for(String s:a)
            System.out.print(s+" ");
    }
}
