package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caoxiaohong on 17/8/25.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 和leetcode中题目完全一样:buildTreeOnPreorderAndInorder同题
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || pre.length==0 || in==null || in.length==0 || pre.length!=in.length)
            return null;
        //将in数据保存到arraylist中.目的是:根据先序元素值获取该值在in中的位置
        List<Integer> arrayIn=new ArrayList<Integer>();
        for(int i:in){
            arrayIn.add(i);
        }
        //辅助函数
        return helper(pre,0,in,0,in.length-1,arrayIn);
    }

    TreeNode helper(int[] pre,int preStart,int[] in,int inStart,int inEnd,List inPre){
        if(inStart>inEnd)
            return null;
        int value=pre[preStart];
        int idxIn=inPre.indexOf(value);
        TreeNode root=new TreeNode(value);
        root.left=helper(pre,preStart+1,in,inStart,idxIn-1,inPre);
        root.right=helper(pre,preStart+idxIn-inStart+1,in,idxIn+1,inEnd,inPre);
        return root;
    }

    //test <code></code>
    public static void main(String[] args) {
        ReConstructBinaryTree test=new ReConstructBinaryTree();
        int[] pre={1,2,4,3};
        int[] in={4,2,1,3};
        TreeNode rot=test.reConstructBinaryTree(pre,in);
    }
}
