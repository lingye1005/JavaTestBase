package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/5/5.
 * 牛客网第8题
 * 就地:空间复杂度为O(1),且不允许更改节点的值.
 */
public class reorderList {

    void reorderListTest(ListNode head) {
        //断表分为前半部分和后半,且把后半部分链表逆置
        //链表长度为奇数时,前部分长度比后半部分多1
        //链表长度为偶数时,前半部分长度和后半部分长度一样
        //求表长
        if(head==null) return;
        int len=0;
        ListNode p1=head;
        ListNode rfirst=null;//获取后半部分链表的头节点;
        while(p1!=null){
            len++;
            rfirst=p1;
            p1=p1.next;
        }
        //长度为1\2,链表不改变
        if(len==1 || len==2) return;
        //找到断表节点.
        int lmax=(len-1)/2;
        int i=0;
        ListNode p2=head;
        while(i<lmax) {
            p2=p2.next;
            i++;
        }
        ListNode p3=p2.next;//后半部分链表开始指针
        p2.next=null;

        //链表逆置
        ListNode p=p3.next;
        ListNode pre=p3;
        p3.next=null;
       // ListNode rfirst=null;
        while(p!=null){
            //if(p.next!=null) rfirst=p.next;//获取后半部分链表的头节点;
            ListNode pnext=p.next;//记录后继指针
            p.next=pre;
            pre=p;
            p=pnext;
        }

        //前半部分头节点为head,后半部分头节点为rfirst;
        int ci=1;//奇数次修改左边链表指针,偶数次修改右边链表指针
        ListNode lp1=head;//左边链表头指针
        ListNode rp1=rfirst;//右边链表头指针

        while(lp1!=null || rp1!=null){
            if(ci%2==1){
                ListNode lp1next=lp1.next;
                lp1.next=rp1;
                lp1=lp1next;
                ci++;
            }else {
                ListNode rp1next=rp1.next;
                rp1.next=lp1;
                rp1=rp1next;
                ci++;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=null;
        reorderList test=new reorderList();
        test.reorderListTest(l1);
        while(l1!=null) {
            System.out.println(l1.val);
            l1=l1.next;
        }
    }
}
