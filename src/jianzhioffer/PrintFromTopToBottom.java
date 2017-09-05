package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/8/27.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 实质:层序遍历
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null)
            return result;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmp=queue.pop();
            result.add(tmp.val);
            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
        }
        return result;
    }
}
