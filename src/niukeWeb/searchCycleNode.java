package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/6.
 * 牛客网第9题
 * 查找给定单链表环开始的节点;如果没有,则返回null
 */
public class searchCycleNode {
    //判定是否有环
    boolean isCircle(ListNode head){
        if (head==null) return false;//无节点
        ListNode fast=head;
        ListNode slow=head;
        do{
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            slow=slow.next;
        }while (fast!=null && fast!=slow);
        if(fast==null)
            return false; //无环
        else
            return true;//有环
    }
    //查找环的连接点
    ListNode detectCycle(ListNode head) {
      if(!isCircle(head)) //无环
          return null;
      //找到第一次碰撞节点的位置
        ListNode fast=head,slow=head;//快慢指针
        do{
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
        }while(fast!=slow);
        while(head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(0);
        ListNode l4=new ListNode(-4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        l4.next=l5;
        l4.next=l5;
        l5.next=l6;
        l6.next=l1;
        searchCycleNode test=new searchCycleNode();
        ListNode circle=test.detectCycle(l1);
        if (circle!=null)
            System.out.println(circle.val);
        else
            System.out.println("circlr is null");
    }
}
