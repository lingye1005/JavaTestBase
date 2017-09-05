package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/2.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null)
            return pHead;
        ListNode head=null,front=pHead,rear=null;  //head保存新链表头节点,front保存旧链表当前遍历节点,rear保存新链表尾节点
        ListNode pre=null;//pre的存在是为了处理最后一个节点:front.next==null && pre.val!=front.val
        while(front!=null){
            if((front.next!=null && front.val!=front.next.val) || (front.next==null && pre.val!=front.val)){
                if(head==null){
                    head=front;
                    rear=front;
                    pre=front;
                    front=front.next;
                    rear.next=null;
                    continue;
                }else{
                    rear.next=front;
                    rear=front;
                    pre=front;
                    front=front.next;
                    rear.next=null;
                    continue;
                }
            }else{
                if(front.next!=null) {
                    pre=front.next;
                    front = front.next.next;
                }else{
                    pre=front;
                    front=null;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplication t=new DeleteDuplication();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(1);
        ListNode l6=new ListNode(1);
        ListNode l7=new ListNode(1);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;
        ListNode l=t.deleteDuplication(l1);
    }
}
