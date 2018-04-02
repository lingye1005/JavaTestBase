package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 18:24
 * @ProjectName: JavaBaseTest
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)
            return null;
        int len1=getLen(pHead1);
        int len2=getLen(pHead2);
        ListNode longList=len1>len2?pHead1:pHead2;
        ListNode shortList=len1<len2?pHead1:pHead2;

        int dist=len1>len2?len1-len2:len2-len1;
        while(dist-->0)
            longList=longList.next;
        while(longList!=null && shortList!=null){
            if(longList==shortList)
                return longList;
            else{
                longList=longList.next;
                shortList=shortList.next;
            }
        }
        return null;
    }
    //获取链表长度
    private int getLen(ListNode node){
        int size=0;
        while(node!=null){
            size++;
            node=node.next;
        }
        return size;
    }
}
