package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/27.
 * 合并2个有序链表
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2;
        ListNode pre=null;
        ListNode l3=null;
        int count=1;

        if(p1==null && p2==null)
            return null;
        else if(p1==null && p2!=null)
            return l2;
        else if(p1!=null && p2==null)
            return l1;
        else{  //均不为空
            while(p1!=null && p2!=null){
                if(p1.val<=p2.val){
                    if(count==1){ //第一个节点判定
                        ListNode temp=new ListNode(p1.val);
                        l3=temp;
                        pre=l3;
                        p1=p1.next;
                        count++;
                    }else{
                        ListNode temp=new ListNode(p1.val);
                        pre.next=temp;
                        pre=temp;
                        p1=p1.next;
                    }
                }else{
                    if(count==1){
                        ListNode temp=new ListNode(p2.val);
                        l3=temp;
                        pre=l3;
                        p2=p2.next;
                        count++;
                    }else{
                       ListNode temp=new ListNode(p2.val);
                        pre.next=temp;
                        pre=temp;
                        p2=p2.next;
                    }
                }
            }
            if(p1!=null){
                pre.next=p1;
            }else{
                pre.next=p2;
            }
        }
        return l3;
    }

    public static void main(String[] args) {
        mergeTwoLists test=new mergeTwoLists();
        ListNode l10=new ListNode(0);
        ListNode l11=new ListNode(4);
        ListNode l12=new ListNode(6);
        l10.next=l11;
        l11.next=l12;
        l12.next=null;
        ListNode l20=new ListNode(2);
        ListNode l21=new ListNode(3);
        ListNode l22=new ListNode(5);
        l20.next=l21;
        l21.next=l22;
        l22.next=null;

        ListNode re=test.mergeTwoLists(l10,l20);
    }
}

