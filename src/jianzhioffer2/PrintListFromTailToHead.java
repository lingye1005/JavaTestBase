package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/1/17 10:01
 * @ProjectName: JavaBaseTest
 * 面试题5
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursion(listNode);
        return res;
    }
    //递归
    ArrayList<Integer> res=new ArrayList<>();
    private void recursion(ListNode root){
        if(root==null)
            return;
        res.add(0,root.val);
        recursion(root.next);
    }

    //test
    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode r1=new ListNode(2);
        ListNode r2=new ListNode(3);
        root.next=r1;
        r1.next=r2;
        ArrayList<Integer> result=new PrintListFromTailToHead().printListFromTailToHead(root);
        result.stream().forEach(integer -> System.out.println(integer));
    }
}
