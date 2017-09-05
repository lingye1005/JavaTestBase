package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入一个链表，输出该链表中倒数第k个结点
 * 双指针法
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)  //空链表
            return null;
        ListNode pre=head,p=head;
        //pre前进k个位置
        while(k>0 && pre!=null){
            pre=pre.next;
            k--;
        }
        if(k>0)  //k大于链表长度
            return null;
        while(pre!=null){
            pre=pre.next;
            p=p.next;
        }
        return p;
    }
}
