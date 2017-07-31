package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/18.
 * 求两个链表的和,但链表本身是逆置的
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class addTwoNumbers {
    int count1,count2;//l1长度;l2长度

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re1=l1;
        ListNode re2=l2;
        getLength(l1,0);
        getLength(l2,1);

        if(l1==null && l2==null)
            return null;
        else if(l1==null && l2!=null)
            return l2;
        else if(l1!=null && l2==null)
            return l1;
        else{
            int carry=0;//进位默认为0,且进位只能为0或者1
            if(count1>=count2){  //l1长一些
                ListNode pre=l1;
                while(l2!=null){
                    int temp=l1.val+l2.val+carry;
                    //求进位
                    carry=temp/10;
                    //重置temp1值
                    l1.val=temp%10;
                    //修改指针,进入下一次循环
                    pre=l1;
                    l1=l1.next;
                    l2=l2.next;
                }
                if(carry>0 && l1!=null) {
                   // l1.val += 1;
                    ListNode front=l1;
                    while(l1!=null && carry>0){
                        int temp=l1.val+carry;
                        carry=temp/10;
                        l1.val=temp%10;
                        front=l1;
                        l1=l1.next;
                    }
                    if(carry>0){
                        ListNode a=new ListNode(1);
                        front.next=a;
                    }
                }
                else if(carry>0 && l1==null){
                    ListNode a=new ListNode(1);
                    pre.next=a;
                }
                return re1;
            }else{//l2长一些
                ListNode pre=l2;
                while(l1!=null){
                    int temp=l1.val+l2.val+carry;
                    carry=temp/10;
                    l2.val=temp%10;
                    pre=l2;
                    l1=l1.next;
                    l2=l2.next;
                }
                if(carry>0 && l2!=null) {
                    //l2.val += 1;
                    ListNode front=l2;
                    while(l2!=null && carry>0){
                        int temp=l2.val+carry;
                        carry=temp/10;
                        l2.val=temp%10;
                        front=l2;
                        l2=l2.next;
                    }
                    if(carry>0){
                        ListNode a=new ListNode(1);
                        front.next=a;
                    }
                }
                else if(carry>0 && l2==null){
                    ListNode a=new ListNode(1);
                    pre.next=a;
                }
                return re2;
            }
        }
    }

    /**
     * 链表逆置 + 顺带求链表长度  :这个方法并没有使用到
     * @param head  需要逆置链表的第一个节点
     * @param flag  0:求l1长度;  1:求l2长度
     * @return
     */
    ListNode reversed(ListNode head,int flag){
        if(head==null)
            return head;
        ListNode l1=new ListNode(head.val);
        ListNode p=head.next;//后继链表的第一个节点
        ListNode pre=l1;
        while(p!=null){
            ListNode temp=p.next;
            p.next=pre;
            pre=p;
            p=temp;
            if(flag==0)
                count1++;
            else
                count2++;
        }
        return pre;
    }

    /**
     * 求链表长度
     * @param head
     * @param flag
     */
    void getLength(ListNode head,int flag){
        if(head==null)
            return ;
        ListNode p=head.next;//后继链表的第一个节点
        while(p!=null){
            if(flag==0)
                count1++;
            else
                count2++;
            p=p.next;
        }
    }
    public static void main(String[] args) {
        addTwoNumbers test=new addTwoNumbers();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(9);
//        ListNode l3=new ListNode(3);
        l1.next=l2;
        //l2.next=l3;
        ListNode l4=new ListNode(9);
//        ListNode l5=new ListNode(6);
//        ListNode l6=new ListNode(4);
//        l4.next=l5;
//        l5.next=l6;

        ListNode head=test.addTwoNumbers(l1,l4);
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
}
