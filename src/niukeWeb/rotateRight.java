package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/28.
 * 链表旋转,给定k,k表示:将链表的最后k个的元素依次旋转到链表头部.
 * 最好返回头节点
 */
public class rotateRight {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null)
            return null;
        if(n==0)
            return head;
        ListNode front=head;//保存头节点
        ListNode rear=null;
        ListNode p=head; //记录当前节点
        int count=0;
        int codesNum=0;
        while(p!=null){ //rear指向尾节点
            rear=p;
            p=p.next;
            codesNum++;
        }
        if(codesNum==1) //如果只有一个节点,则不旋转
            return head;
        p=head; //重置头节点,开始旋转
        //n对表长取余是为了保证codesNum - n是个正数
        n=n%codesNum;
        while (count < (codesNum - n)) {
            ListNode temp = p.next;
            p.next = null;
            rear.next = p;
            rear = p;
            rear.next = null;
            p = temp;
            count++;
        }
        return p;
    }

    public static void main(String[] args) {
        rotateRight test=new rotateRight();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=null;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        ListNode a=test.rotateRight(l1,3);
        while(a!=null){
            System.out.println(a.val);
            a=a.next;
        }
    }
}
