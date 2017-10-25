package schooloffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/23.
 * 拓扑结构相同的树
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        preOrder(A);
        for(TreeNode node:list){
            if(isSame(node,B))
                return true;
        }
        return false;
    }
    //树先序遍历
    static ArrayList<TreeNode> list=new ArrayList<TreeNode>();
    private static void preOrder(TreeNode A){
        if(A!=null){
            list.add(A);
            preOrder(A.left);
            preOrder(A.right);
        }
    }
    //判定两棵树是否一致
    private static boolean isSame(TreeNode a,TreeNode b){
        if(a==null && b==null)
            return true;
        else if( (a==null && b!=null) || (a!=null && b==null))
            return false;
        else if(a!=null && b!=null && a.val!=b.val)
            return false;
        return isSame(a.left,b.left) && isSame(a.right,b.right);
    }

    public static void main(String[] args) {
        IdenticalTree t=new IdenticalTree();
        TreeNode root1=new TreeNode(1);
        TreeNode ch1=new TreeNode(2);
        TreeNode ch2=new TreeNode(3);
        TreeNode ch3=new TreeNode(4);
        root1.left=ch1;
        root1.right=ch2;
        ch1.left=ch3;

        TreeNode root2=new TreeNode(2);
        TreeNode ch4=new TreeNode(4);
        root2.left=ch4;

        System.out.println(t.chkIdentical(root1,root2));
    }
}
