package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/12.
 * 给定链表和数字k,则在链表中:每k个节点逆置一次.如果后面剩下的节点不够ke个,则不再逆转后面这几个节点.
 * Given this linked list:1->2->3->4->5
 * For k = 2, you should return:2->1->4->3->5
 * For k = 3, you should return:3->2->1->4->5
 */
public class reverseKGroup {
    ArrayList<Integer> valuse=new ArrayList<Integer>();  //记录各个值

    public ListNode reverseKGroup(ListNode head, int k) {
        //求链表长度,并且存储了各个节点的值
        int len=linkedListLength(head);
        //需要逆置次数
        int count=len/k;
        ListNode root;
        if(count==0)  //说明:k>len;
            return head;
        else{//逆置;
            //数组逆置
            arrayReverse(valuse,k,count);
            //重新组成链表;
            int i=0;
            root=new ListNode(valuse.get(0));
            ListNode pre=root;
            while(i<len-1){
                ListNode temp=new ListNode(valuse.get(++i));
                pre.next=temp;
                pre=pre.next;
            }
        }
        return root;
    }
    //求链表长度
    int linkedListLength(ListNode head){
        if(head==null)
            return 0;
        else{
            int len=0;
            ListNode p=head;
            while(p!=null){
                len++;
                valuse.add(p.val);
                p=p.next;
            }
            return len;
        }
    }
    void arrayReverse(ArrayList<Integer> array,int k,int count){
        int[] arr=new int[array.size()];
        for(int i=0;i<array.size();i++){
            arr[i]=array.get(i);
        }
        for(int i=0;i<array.size() && count>0;i=i+k){
                 // i*j ~ i*j+k-1
                 int front=i;
                 int rear=i+k-1;
                 while(front<rear){
                     int temp=arr[front];
                     arr[front]=arr[rear];
                     arr[rear]=temp;
                     front++;
                     rear--;
                 }
                 count--;
        }
        valuse.clear();
        for(int i=0;i<arr.length;i++){
            valuse.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        reverseKGroup test=new reverseKGroup();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode head=test.reverseKGroup(l1,2);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
