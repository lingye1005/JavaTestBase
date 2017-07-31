package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/16.
 *有序递增链表转为平衡二叉树
 */

import apple.laf.JRSUIUtils;

import java.util.*;


public class sortedListToBST {
    private ListNode current=new ListNode(-1);
    //求链表长度
    int getLen(ListNode head){
        if(head==null) return 0;
        int len=0;
        ListNode h=head;
        while(h!=null){
            len++;
            h=h.next;
        }
        return  len;
    }
    //avl生成:中序遍历
    TreeNode getAVL(int size){
        if(size<=0) return null;

        TreeNode left=getAVL(size/2);
        TreeNode root=new TreeNode(current.val);
        current=current.next;
        TreeNode right=getAVL(size-1-size/2);

        root.left=left;
        root.right=right;
        return root;
    }
    public TreeNode sortedListToBST001(ListNode head) {
        int len=getLen(head);
        current=head;
        return getAVL(len);
    }

    public static void main(String[] args) {
        sortedListToBST test=new sortedListToBST();
        ListNode head=new ListNode(1);
        ListNode l1=new ListNode(3);
//        ListNode l2=new ListNode(1);
//        ListNode l3=new ListNode(2);
//        ListNode l4=new ListNode(5);
//        ListNode l5=new ListNode(6);
//        ListNode l6=new ListNode(7);
        head.next=l1;
        l1.next=null;
//        l2.next=l3;
//        l3.next=null;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=null;
        TreeNode root= test.sortedListToBST001(head);
        System.out.println("root.value:"+root.val);
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root) ;
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.println(temp.val);

            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }
}
