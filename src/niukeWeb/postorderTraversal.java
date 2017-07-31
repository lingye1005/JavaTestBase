package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/5/5.
 * 牛客网第6\7题,后序\先序遍历二叉树并输出
 */


public class postorderTraversal {
    ArrayList<Integer> result=new ArrayList<Integer>();
    ArrayList<Integer> postTraversal(TreeNode root) {
        //先序
        if(root==null) return result;
        else
            //do
            result.add(root.val);
        if(root.left!=null) postTraversal(root.left);
        if(root.right!=null) postTraversal(root.right);

        //后序
        if(root==null) return result;
        if(root.left!=null) postTraversal(root.left);
        if(root.right!=null) postTraversal(root.right);
        //do
        result.add(root.val);

        return result;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode ch1=new TreeNode(2);
        TreeNode ch2=new TreeNode(3);
        root.left=null;
        root.right=ch1;
        ch1.left=ch2;
        ch1.right=null;
        ch2.left=null;
        ch2.right=null;
        postorderTraversal test=new postorderTraversal();
        ArrayList<Integer> soutnum=test.postTraversal(root);
        for(int i=0;i<soutnum.size();i++){
            System.out.println(soutnum.get(i));
        }
    }
}
