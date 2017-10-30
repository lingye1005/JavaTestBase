package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/30.
 * 二叉树被记录成文件的过程叫做二叉树的序列化...
 */
public class TreeToSequence {
    public String toSequence(TreeNode root) {
        // write code here
        if(root==null)
            return "";
        return helper(root);
    }
    private String helper(TreeNode root){
        if(root==null)
            return "";
        StringBuffer sb=new StringBuffer();
        sb.append("(");
        sb.append(helper(root.left));
        sb.append(helper(root.right));
        sb.append(")");
        return sb.toString();
    }

    //test code
    public static void main(String[] args) {
        TreeToSequence t=new TreeToSequence();
        TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        TreeNode l2=new TreeNode(3);
        TreeNode l3=new TreeNode(4);
        TreeNode l4=new TreeNode(5);
        root.left=l1;
        root.right=l2;
        l1.right=l3;
        l2.left=l4;
        System.out.println(t.toSequence(root));
    }
}
