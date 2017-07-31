package niukeWeb;



/**
 * Created by caoxiaohong on 17/5/19.
 * 求二叉树中任意两个点之间中最长的路径:经过的节点上数字之和
 * 题意：在二叉树中找一条路径，使得该路径的和最大。该路径可以从二叉树任何结点开始，也可以到任何结点结束。

 思路：递归求一条经过root的最大路径，这条路径可能是：
 1) 左边某条路径 + root + 右边某条路径
 2) 左边某条路径 + root
 3) root + 右边某条路径
 4) root
 */
public class maxPathSum {
    int max=Integer.MIN_VALUE;

    public int maxPathSumTest(TreeNode root) {
        if(root==null) return 0;
        //调用递归函数
        recursionHandler(root);
        return max;
    }
    private int recursionHandler(TreeNode node){
        if(node==null) return 0;
        int left=recursionHandler(node.left);//递归求左子树最长路径
        int right=recursionHandler(node.right);//递归求右子树最长路径
        int curr=node.val;//记录当前节点值
        if(left>0)
            curr+=left;
        if(right>0)
            curr+=right;
        if(curr>max){
            max=curr;
        }
        int temp=Math.max(node.val,Math.max(node.val+left,node.val+right));
        return temp;//返回从叶子节点到node的最大路径和
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode lch=new TreeNode(2);
        TreeNode rch=new TreeNode(3);
        root.left=lch;
        root.right=rch;
        lch.left=null;
        lch.right=null;
        rch.left=null;
        rch.right=null;
        maxPathSum test=new maxPathSum();
        System.out.println(test.maxPathSumTest(root));
    }
}
