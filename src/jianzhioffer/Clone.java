package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/27.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 算法思想:遍历两次:
 * 第一次:生成所有节点
 * 第二次:修改random指针
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode root=new RandomListNode(pHead.label);
        //用于复制random指针
        RandomListNode root2=root;
        RandomListNode pHead2=pHead;
        //用于复制next指针
        RandomListNode p=pHead;
        RandomListNode pre=root;
        while(p.next!=null){
            RandomListNode nextNode=new RandomListNode(p.next.label);
            pre.next=nextNode;
            pre=nextNode;
            p=p.next;
        }
        while(root2!=null && pHead2!=null){
            root2.random=pHead2.random;
            root2=root2.next;
            pHead2=pHead2.next;
        }
        return  root;
    }
}
