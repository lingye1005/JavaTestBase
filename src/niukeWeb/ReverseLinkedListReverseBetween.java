package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/26.
 * 逆置链表:第m个节点到第n个节点
 * 要求:只能遍历一次链表
 * 注意:链表节点:从第1个开始.当然了,说起来第几个,那肯定是从1开始的.和数组下标是不一样的.
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n)
            return head;
        int count=n-m+1;//相差个数
        int[] values=new int[count];//记录需要更改值
        ListNode pre=head,p=head;
        int num1=1;
        while(num1<m){
            pre=pre.next;
            num1++;
        }
        int i=0;
        while(num1<=n){
            values[i++]=pre.val;
            p=p.next;
            pre=pre.next;
            num1++;
        }
        ListNode p0= head;
        num1=1;
        while(num1<m){
            p0=p0.next;
            num1++;
        }
        //改值
        i=count-1;
        while(num1<=n){
            p0.val=values[i--];
            p0=p0.next;
            num1++;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListReverseBetween test=new ReverseLinkedListReverseBetween();
        //ListNode head= new ListNode(0);
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=null;

        test.reverseBetween(a1,2,4);
        while(a1.next!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }
    }
}
