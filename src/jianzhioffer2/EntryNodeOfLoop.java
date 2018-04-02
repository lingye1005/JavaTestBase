package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 21:32
 * @ProjectName: JavaBaseTest
 */
public class EntryNodeOfLoop {

    //test
    public static void main(String[] args) {
         EntryNodeOfLoop t=new EntryNodeOfLoop();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l7=new ListNode(7);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l3;
        ListNode res=t.EntryNodeOfLoop(l1);

        System.out.println(res.val);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null || pHead.next==null)
            return null;
        ListNode head=pHead;//保存头节点
        ListNode first=pHead;
        ListNode second=pHead;
        int count1=0;
        do{
            first=first.next.next;
            second=second.next;
        }while(first!=second);
        ListNode meet=first;
        do{
            first=first.next;
            count1++;
        }while(first!=meet);
        int counts=count1;//环中节点个数
        ListNode l1=head;
        ListNode l2=head;
        while(counts-->0){
            l1=l1.next;
        }
        do{
            l1=l1.next;
            l2=l2.next;
        }while(l1!=l2);
        return l1;
    }
}
