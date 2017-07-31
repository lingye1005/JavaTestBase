package niukeWeb;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/5/3.
 * 牛客网第4\5题
 * 为链表排序,要求空间复杂度为:O(1).
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
                val = x;
                 next = null;
        }
}

//没有头节点
public class sortList {
    public ListNode sortedList(ListNode head) {
        if(head==null)  return null;//空链表

        ListNode frontP=head.next,rearP;//old :从第2个节点开始

        ListNode headNew=new ListNode(head.val);//new 头节点,包含了旧链表的第1个节点
        headNew.next=null;

        while (frontP!=null){ //遍历frontP前面的数据,并插入
            rearP=frontP.next;//记录旧链表指针
            boolean isHead=true;
            ListNode P=headNew; //新链表头节点
            while(P!=null){
                //头部插入
                if(P.val>frontP.val && isHead){
                    isHead=false;
                    ListNode temp1=new ListNode(frontP.val);
                    temp1.next=headNew;
                    headNew=temp1;
                    break;
                }else if(P.val<frontP.val && P.next!=null && P.next.val>=frontP.val ) {  //中间插入
                    ListNode temp2=new ListNode(frontP.val);
                    temp2.next=P.next;
                    P.next=temp2;
                    break;
                }else if(P.next==null){//尾部插入
                    ListNode temp2=new ListNode(frontP.val);
                    P.next=temp2;
                    temp2.next=null;
                    break;
                }
                P = P.next;
            }
            frontP=rearP;
        }
        return headNew;
    }

    public static void main(String[] args) {
        //4,19,14,5,-3,1,8,5,11,15
        ListNode l1=new ListNode(4);
        ListNode l2=new ListNode(19);
        ListNode l3=new ListNode(14);
        ListNode l4=new ListNode(5);
        ListNode l5=new ListNode(-3);
        ListNode l6=new ListNode(1);
        ListNode l7=new ListNode(8);
        ListNode l8=new ListNode(5);
        ListNode l9=new ListNode(11);
        ListNode l10=new ListNode(15);
        //ListNode head=new ListNode(-1);
        //head.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        sortList sl=new sortList();
        ListNode outP= sl.sortedList(l1);
        while(outP!=null){
           // System.out.println(1111);
            System.out.println(outP.val);
            outP=outP.next;
        }
    }
}
