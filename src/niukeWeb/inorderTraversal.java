package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/22.
 */
public class inorderTraversal {
    ArrayList<Integer> list=new ArrayList<Integer>();//存放节点值

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Inorder(root);
        return list;
    }
    private void Inorder(TreeNode root){
        if(root==null)
            return;
        Inorder(root.left);
        list.add(root.val);
        Inorder(root.right);
    }
}
