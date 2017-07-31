package niukeWeb;


/**
 * Created by caoxiaohong on 17/7/12.
 * 交换给定链表的相邻两个节点的位置.如:0和1交换,2和3交换....依次交换下去
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode p=head;
        while(head!=null && head.next!=null){
            //交换值
            int temp1=head.val;
            int temp2=head.next.val;
            head.val=temp2;
            head.next.val=temp1;
            head=head.next.next;
        }
        return p;
    }

    public static void main(String[] args) {
        swapPairs test=new swapPairs();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode root=test.swapPairs(l1);
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }
}
