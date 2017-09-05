package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null)
            return  null;
        else if(list1!=null && list2==null)
            return list1;
        else if(list2!=null && list1==null)
            return  list2;

        ListNode front,next1,next2;
        ListNode p;
        if(list1.val<=list2.val){
            front=list1;
            next1=list1.next;
            next2=list2;
            p=front;
            p.next=null;
        }else{
            front=list2;
            next1=list1;
            next2=list2.next;
            p=front;
            p.next=null;
        }
        while(next1!=null && next2!=null){
            if(next1.val<=next2.val){
                p.next=next1;
                next1=next1.next;
                p=p.next;
                p.next=null;
            }else{
                p.next=next2;
                next2=next2.next;
                p=p.next;
                p.next=null;
            }
        }
        if(next1!=null){
            p.next=next1;
        }
        if(next2!=null){
            p.next=next2;
        }
        return front;
    }

    public static void main(String[] args) {
        Merge test=new Merge();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(3);
        ListNode l3=new ListNode(5);
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(6);

        l1.next=l2;
        l2.next=l3;

        l4.next=l5;
        l5.next=l6;
        ListNode root=test.Merge(l1,l4);
    }
}
