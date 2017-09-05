package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入一个链表，反转链表后，输出链表的所有元素
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode p=head,next=p.next;
        p.next=null;
        while(next!=null){
            ListNode tmp=next;
            next=next.next;
            tmp.next=p;
            p=tmp;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ReverseList test=new ReverseList();
        ListNode root=test.ReverseList(l1);
    }
}
