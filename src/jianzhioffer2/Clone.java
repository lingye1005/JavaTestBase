package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/24 22:37
 * @ProjectName: JavaBaseTest
 *
 * 剑指offer书上的方法
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        insert(pHead);//更改链表
        randomLink(pHead);
        return getClone(pHead);
    }
    //节点的插入
    private void insert(RandomListNode head){
        RandomListNode p=head;
        while(p!=null){
            RandomListNode newNode=new RandomListNode(p.label);
            newNode.next=p.next;
            p.next=newNode;
            p=newNode.next;
        }
    }
    //完成随机指针的连接
    private void randomLink(RandomListNode head){
        while (head!=null){
            if(head.random!=null)
                head.next.random=head.random.next;
            head=head.next.next;
        }
    }
    //拆分表
    private RandomListNode getClone(RandomListNode pHead){
        RandomListNode original=pHead;
        RandomListNode clone=pHead.next;
        RandomListNode res=clone;
        while (original!=null){
            if(original.next!=null)
                original.next=original.next.next;
            if(clone.next!=null)
                clone.next=clone.next.next;
            original=original.next;
            clone=clone.next;
        }
        return res;

    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
