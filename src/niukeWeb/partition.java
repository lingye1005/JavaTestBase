package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/23.
 * 题意：给定一个单链表和一个x，把链表中小于x的放到前面，大于等于x的放到后面，每部分元素的原始相对位置不变。
 * 思路：其实很简单，遍历一遍链表，把小于x的都挂到head1后，把大于等于x的都放到head2后，最后再把大于等于的链表挂到小于链表的后面就可以了。
 */
public class partition {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode head2=null;
        ListNode p=head,l1pre=null,l1next=null;
        ListNode l2rear=null;
        ListNode temp;
        while(p!=null){
            if(p.val<x){
                if(l1pre==null){
                    head=p;
                    l1pre=p;
                    l1next=p.next;
                    l1pre.next=null;
                }else{
                    l1pre.next=p;;
                    l1pre=p;
                    l1next=p.next;
                    l1pre.next=null;
                }
                temp=l1next;
            }else{
                if(head2==null){
                    head2=p;
                    l2rear=p;
                    temp=p.next;
                    l2rear.next=null;
                }else{
                    l2rear.next=p;
                    l2rear=p;
                    temp=p.next;
                    l2rear.next=null;
                }
            }
            p=temp;
        }
        if(head2!=null && l1pre!=null)
            l1pre.next=head2;
        else if(l1pre==null)
            head=head2;
        return head;
    }

    public static void main(String[] args) {
        partition t=new partition();
        ListNode l1=new ListNode(1);
        l1.next=null;
//        ListNode l2=new ListNode(4);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(2);
//        ListNode l5=new ListNode(5);
//        ListNode l6=new ListNode(2);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=null;
        ListNode a=t.partition(l1,0);
        while(a!=null){
            System.out.println(a.val);
            a=a.next;
        }
    }
}
