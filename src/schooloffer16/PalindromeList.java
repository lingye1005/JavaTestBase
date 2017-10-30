package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/30.
 * 左神书:p50页码
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if(A==null || A.next==null)
            return true;
        //查找中间节点
        ListNode n1=A;//指向节点为中间节点:如果为偶数个节点,则为前半区最后一个节点,如果奇数个节点,则为中间节点
        ListNode n2=A;
        while (n2.next!=null && n2.next.next!=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        //逆置右半区节点
        n2=n1.next;//n2指向右半区第一个节点
        n1.next=null;
        ListNode n3;
        while (n2!=null){
            n3=n2.next;
            n2.next=n1;
            n1=n2;
            n2=n3;
        }
        //查找是否回文
        n3=n1;//保存链表最后一个节点,为后面恢复链表做准备
        n2=A;
        boolean res=true;
        while(n1!=null && n2!=null){
            if(n1.val!=n2.val){
                res=false;
            }
            n1=n1.next;
            n2=n2.next;
        }
        //恢复链表,利用上面保存的n3
        n1=n3.next;
        n3.next=null;
        while (n1!=null){
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;
        }
        //返回结果
        return res;
    }

}
