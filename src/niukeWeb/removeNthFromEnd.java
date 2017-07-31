package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/13.
 * 移出链表中:从后向前数第n个节点.
 *          n的范围:1~n
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return helper(head,n);
    }

    /**
     *
     * @param head 第一个节点
     * @param k  倒数第k个
     */
     ListNode helper(ListNode head,int k){
        ListNode p=head;
        ListNode pre=head;
        ListNode present=head;
        while(k>0 && p!=null){
            p=p.next;
            k--;
        }
        if(p==null && k>0)  //k>节点个数
            return head;
        if(p==null && k==0){  //k=节点个数 ,删除第一个节点即可
            head=head.next;
            return head;
        }
        while(p!=null){
            pre=present;
            p=p.next;
            present=present.next;
        }
        pre.next=present.next;
        return head;
    }

    public static void main(String[] args) {
        removeNthFromEnd test=new removeNthFromEnd();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        ListNode head=test.removeNthFromEnd(l1,1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
