package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/12.
 * 合并n个有序链表为1个有序链表
 */
public class mergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int len=lists.size();
        //每次合并链表元素个数最少的两个表.需要合并次数:len-1
        if(len==0)
            return null;
        if(len==1)
            return lists.get(0);

        ListNode root=merge(lists.get(0),lists.get(1));
        for(int i=1;i<len-1;i++){  //合并次数
            ListNode temp=merge(root,lists.get(i+1));
            root=temp;
        }
        return root;
    }
    //合并两个链表
    ListNode merge(ListNode l1,ListNode l2){
        if(l1==null && l2==null){
            return null;
        }else if(l1==null && l2!=null){
            return l2;
        }else if(l1!=null && l2==null){
            return l1;
        }
        ListNode root;
        if(l1.val<=l2.val){
            root=new ListNode(l1.val);
            l1=l1.next;
        }else{
            root=new ListNode(l2.val);
            l2=l2.next;
        }
        ListNode p=root;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                ListNode temp=new ListNode(l1.val);
                p.next=temp;
                p=p.next;
                l1=l1.next;
            }else{
                ListNode temp=new ListNode(l2.val);
                p.next=temp;
                p=p.next;
                l2=l2.next;
            }
        }
        if(l1!=null){
            p.next=l1;
        }else if(l2!=null){
            p.next=l2;
        }
        return root;
    }

    public static void main(String[] args) {
        mergeKLists test=new mergeKLists();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(5);
        ListNode l4=new ListNode(10);
        ListNode l5=new ListNode(2);
        ListNode l6=new ListNode(8);
        l1.next=l2;
        l2.next=null;
        l3.next=l4;
        l4.next=null;
        l5.next=l6;
        l6.next=null;
        ArrayList<ListNode> a=new ArrayList<ListNode>();
//        a.add(l1);
//        a.add(l3);
//        a.add(l5);
        a.add(null);
        a.add(null);

        ListNode head=test.mergeKLists(a);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
