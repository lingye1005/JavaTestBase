package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/29.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    ArrayList<TreeNode> result=new ArrayList<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        inOrderTraverse(pRootOfTree);
        //重置各个节点的left,right值;
        for(int i=0;i<result.size();i++){
            if(i==0){//链表第一个节点
                result.get(i).left=null;
                if(i+1<result.size())
                    result.get(i).right=result.get(i+1);
                else
                    result.get(i).right=null;
            }else if(i==result.size()-1){//链表最后一个节点
                if(i-1>0){
                    result.get(i).left=result.get(i-1);
                }else{
                    result.get(i).left=null;
                }
                result.get(i).right=null;
            }else{//中间节点
                result.get(i).left=result.get(i-1);
                result.get(i).right=result.get(i+1);
            }
        }
        return result.get(0);
    }

    /**
     * 中序遍历
     * @param root 当前根节点
     * @return
     */
    void inOrderTraverse(TreeNode root){
        if(root!=null){
            inOrderTraverse(root.left);
            result.add(root);
            inOrderTraverse(root.right);
        }
    }
}
