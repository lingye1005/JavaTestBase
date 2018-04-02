package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/17 10:24
 * @ProjectName: JavaBaseTest
 * 面试题6
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       return  helper(pre,0,in,0,in.length-1);
    }
    private TreeNode helper(int[] pre,int fromP,int[] in,int fromI,int endI){
        //fromI>endI忘记写
        if(fromP>=pre.length || fromP<0 || fromI<0 ||fromI>=in.length || endI>=in.length || endI<0 ||(fromI>endI))
            return null;
        int value=pre[fromP];
        TreeNode root=new TreeNode(value);
        //查找根节点在中序中的索引
        int idx=-1;
        for(int i=0;i<in.length && idx==-1;i++){
            if(in[i]==value)
                idx=i;
        }
        //左子树递归
        root.left=helper(pre,fromP+1,in,fromI,idx-1);
        //右子树递归
        root.right=helper(pre,fromP+idx-fromI+1,in,idx+1,endI);
        return root;
    }

    //test
    public static void main(String[] args) {
        ReConstructBinaryTree test=new ReConstructBinaryTree();
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
        TreeNode root=test.reConstructBinaryTree(pre,in);
        System.out.println(root.left.val);
    }
}
