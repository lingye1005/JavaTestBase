package niukeWeb;


/**
 * Created by caoxiaohong on 17/6/23.
 * 删除有序链表的相同元素
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode pre=head,next=head.next;//pre记录保留节点的最后一个节点,next存放后面未被遍历的节点
        ListNode p=next;
        pre.next=null;
        while(p!=null){
            next=p.next;
            if(pre.val<p.val){
                pre.next=p;
                pre=p;
                pre.next=null;
            }
            p=next;
        }
        return head;
    }

    public static void main(String[] args) {
        deleteDuplicates t=new deleteDuplicates();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        ListNode aa=t.deleteDuplicates(l1);
        while(aa!=null){
            System.out.println(aa.val);
            aa=aa.next;
        }
    }
}
