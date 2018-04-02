package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 11:13
 * @ProjectName: JavaBaseTest
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null )
            return null;
        //pNode无右孩子，且是双亲节点的左孩子
        if(pNode.right==null && pNode.next!=null && pNode.next.left==pNode)
            return pNode.next;
        //pNode有右孩子，遍历右孩子的最左节点
        if(pNode.right!=null){
            TreeLinkNode pre=pNode;
            pNode=pNode.right;
            while(pNode!=null){
                pre=pNode;
                pNode=pNode.left;
            }
            return pre;
        }
        //pNode无右孩子，且是双亲节点的右孩子
        if(pNode.right==null && pNode.next!=null && pNode.next.right==pNode){
            TreeLinkNode curr=pNode.next;//curr初始化为pNode的双亲节点
            while(curr!=null){
                if(curr.next!=null && curr.next.left==curr)
                    break;
                curr=curr.next;
            }
            if(curr!=null)
                return curr.next;
            else
            return null;
        }
        return null;
    }
}



class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
