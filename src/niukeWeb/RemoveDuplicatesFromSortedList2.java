package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/28.
 * 移除有序链表中重复的数字.
 * 注意:不是保留一个重复数字,而是只要这个数字是重复的,则返回列表中就不再有这个数字.
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        //旧链表工作节点1,2
        ListNode pre=head,p=head.next;
        //新链表头节点,尾节点
        ListNode root=null;
        ListNode rear=null;

        //处理第一个节点
        if(pre.val!=p.val) {
            ListNode a=new ListNode(pre.val);
            root=a;
            rear=a;
            rear.next=null;
        }

        while(p!=null){
           if(p.val!=pre.val && p.next==null){ //为新链表添加节点情况1:最后一个节点可以被添加进去
               if(root==null){

                   ListNode a=new ListNode(p.val);
                   root=a;
                   rear=a;
                   //rear.next=null;
                   pre=p;
                   p=p.next;
               }else{
                   ListNode a=new ListNode(p.val);
                   rear.next=a;
                   rear=a;
                   //rear.next=null;
                   pre=p;
                   p=p.next;
               }
           }else if(p.val!=pre.val && p.next!=null && p.val!=p.next.val){  //为新链表添加节点情况2:中间节点可以被添加进去
               if(root==null){
                   ListNode a=new ListNode(p.val);
                   root=a;
                   rear=a;
                   //rear.next=null;
                   pre=p;
                   p=p.next;
               }else{
                   ListNode a=new ListNode(p.val);
                   rear.next=a;
                   rear=a;
                   //rear.next=null;
                   pre=p;
                   p=p.next;
               }
           }else if(p.val==pre.val && p.next==null){  //最后一个节点不能添加进去,停止
               break;
           }else if(p.val==pre.val && p.next!=null && p.val!=p.next.val){  //中间节点,不能添加进去:112...
               //p=p.next;
               pre=p;
               p=p.next;
           }else if(p.val!=pre.val && p.next!=null && p.val==p.next.val){ //中间节点,不能添加进去:122...
               pre=p.next;
               p=p.next.next;
           }else if(p.val==pre.val && p.next!=null && p.val==p.next.val){//中间节点,不能添加进去:111...
               pre=p.next;
               p=p.next.next;
           }
        }
        return root;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 tet=new RemoveDuplicatesFromSortedList2();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(3);
        //ListNode l5=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
//        l4.next=l5;
        ListNode a=tet.deleteDuplicates(l1);

    }
}
