package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/22.
 * 逆置链表:从m到n位置:1<=m<=n<=length
 */
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode pre=head,p=head,next=head;//pre记录m前驱节点,p记录当前节点.next记录n后面节点指针
        int countpre=1,countnext=1;
        while(countpre!=m || countnext!=n){
            if(countpre!=m){
                countpre++;
                pre=p;
                p=p.next;
            }
            if(countnext!=n){
                countnext++;
                p=p.next;
                if(p.next!=null)
                    next=p.next;
                else
                    next=null;
            }
        }
        //到此为止:pre记录了m前驱指针,p记录了n指针,next记录了n后继指针.
        //从m到n采用尾插法进行链表逆置
        ListNode temp=pre;
        pre=pre.next;
        while(countpre<n){
            ListNode node=pre.next;
            p.next=pre;
            //pre=node;
            countpre++;
            if(countpre<n)
                pre=node;
        }
        pre.next=next;
        temp.next=p;
        return head;
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(0);
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        head.next=a1;
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=null;
        reverseBetween test=new reverseBetween();
        test.reverseBetween(head,2,4);
        while(head.next!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
