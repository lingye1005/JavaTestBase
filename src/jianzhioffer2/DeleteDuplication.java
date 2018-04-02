package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 22:50
 * @ProjectName: JavaBaseTest
 */
public class DeleteDuplication {
    //test
    public static void main(String[] args) {
        DeleteDuplication t=new DeleteDuplication();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        ListNode l7=new ListNode(5);
        ListNode l8=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;

        ListNode res=t.deleteDuplication(l1);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }

    }


    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null)
            return null;
        if(pHead.next==null)
            return pHead;
        //>1个节点
        ListNode res=null;//返回链表头节点
        ListNode link=null;//返回链表最后一个节点的指针
        ListNode p=pHead;//中间节点,当前节点
        ListNode next=null;//当前节点的下一个节点
        ListNode pre=null;//当前节点的上一个节点

        while(p!=null){
            //第一个节点
            if(pre==null && p.next.val!=p.val){
                res=p;
                link=res;
                pre=p;
                p=p.next;
                next=p.next;
            }else if(pre==null){
                pre=p;
                p=p.next;
                next=p.next;
            }
            //最后一个节点
            if(next==null && p.val!=pre.val){
                if(res==null) {
                    res = p;
                    link=p;
                }
                else{
                    link.next=p;
                }
                p=p.next;
            }else if(next==null){
                if(link!=null)
                    link.next=null;//删掉尾巴
                p=p.next;
            }
            //中间节点
            if(pre!=null && next!=null && pre.val!=p.val && next.val!=p.val){
                if(res==null){
                    res=p;
                }else{
                    link.next=p;
                }
                link=p;
                pre=p;
                p=p.next;
                next=next.next;
            }else if(pre!=null && next!=null){
                pre=p;
                p=p.next;
                next=next.next;
            }
        }
        return res;
    }
}
