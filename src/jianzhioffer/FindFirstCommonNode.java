package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)
            return null;
        int len1=getLength(pHead1);
        int len2=getLength(pHead2);
        if(len1==len2){
            while(pHead1!=pHead2 && pHead1!=null && pHead2!=null) {
                pHead1 = pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }else if(len1>len2){
            while (len1-len2>0){
                pHead1=pHead1.next;
                len1--;
            }
            while(pHead1!=pHead2 && pHead1!=null && pHead2!=null) {
                pHead1 = pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }else{
            while (len2-len1>0){
                pHead2=pHead2.next;
                len2--;
            }
            while(pHead1!=pHead2 && pHead1!=null && pHead2!=null) {
                pHead1 = pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }
    }

    /**
     * 求链表长度
     * @param head
     * @return
     */
    private int getLength(ListNode head){
        int len=0;
        while (head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
