package niukeWeb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caoxiaohong on 17/5/16.
 * 判定一棵二叉树是否为平衡二叉树
 */
public class isBalanced {
    //深度优先遍历
    int TreeDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else{
            //层序遍历每个节点,求每个节点是否平衡
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                int hl=TreeDepth(temp.left);
                int hr=TreeDepth(temp.right);
                if(Math.abs(hl-hr)>1)
                    return false;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        isBalanced test=new isBalanced();
        TreeNode root=new TreeNode(1);
        TreeNode ch1=new TreeNode(2);
        TreeNode ch2=new TreeNode(3);

        root.left=ch1;
        root.right=null;
        ch1.left=ch2;
        ch1.right=null;
        ch2.left=null;
        ch2.right=null;
        System.out.println(test.isBalanced(root));
    }
}
