package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/2.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 算法思想
 * 1.pnode有右子树,返回右子树中序遍历的第一个节点
 * 2.pnode没有右子树,
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null)
            return null;
        else if(pNode.right!=null){  //pnode有右孩子
            return inOrder(pNode.right);
        }
        else if(pNode.right==null && pNode.next!=null && pNode.next.left==pNode){//pnode没有右孩子 && pNode是双亲节点的左子树
            return pNode.next;
        }
        else if(pNode.right==null && pNode.next!=null &&  pNode.next.right==pNode && pNode.next.next!=null && pNode.next.next.left!=null  && pNode.next.next.left.right==pNode)///pnode没有右孩子 && pNode是双亲节点的右子树,且是双亲节点的双亲节点的左子树
            return pNode.next.next;
        else if(pNode.right==null && pNode.next!=null &&  pNode.next.right==pNode && pNode.next.next!=null && pNode.next.next.right!=null && pNode.next.next.right.right==pNode)///pnode没有右孩子 && pNode是双亲节点的右子树,且是双亲节点的双亲节点的右子树
            return null;
        else {
            return null;
        }
    }

    /**
     * 中序遍历,返回第一个节点
     * @param root
     * @return
     */
    TreeLinkNode  inOrder(TreeLinkNode root){
        if(root.left==null)
            return root;
        else{
            return inOrder(root.left);
        }
    }
}
