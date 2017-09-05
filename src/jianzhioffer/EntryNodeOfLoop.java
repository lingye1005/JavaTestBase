package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
 来源：牛客网

 假设x为环前面的路程（黑色路程），a为环入口到相遇点的路程（蓝色路程，假设顺时针走）， c为环的长度（蓝色+橙色路程）
 当快慢指针相遇的时候：
 此时慢指针走的路程为Sslow = x + m * c + a
 快指针走的路程为Sfast = x + n * c + a
 2 Sslow = Sfast
 2 * ( x + m*c + a ) = (x + n *c + a)
 从而可以推导出：
 x = (n - 2 * m )*c - a
 = (n - 2 *m -1 )*c + c - a
 即环前面的路程 = 数个环的长度（为可能为0） + c - a
 什么是c - a？这是相遇点后，环后面部分的路程。（橙色路程）
 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
 从相遇点开始走的那个指针也一定刚好到达环入口点。
 所以2者会相遇，且恰好相遇在环的入口点。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null || pHead.next==null)
            return null;
        ListNode front=pHead.next;
        ListNode rear=pHead;
        while(front!=rear){
            front=front.next.next;
            rear=rear.next;
        }
        //快慢指针相遇
        front=pHead;
        rear=rear.next;
        while(front!=rear){
            front=front.next;
            rear=rear.next;
        }
        return front;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop t=new EntryNodeOfLoop();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l3;
        ListNode l=t.EntryNodeOfLoop(l1);
    }
}
