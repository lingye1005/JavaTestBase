package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/7.
 * 牛客网第13题
 * 给定链表有两个指针,一个为next指针,另一个为随机指针.随机指针指向链表中某个节点或者为 null.
 * 最后给出这个链表的一个深度拷贝deep copy.
 */
class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
}
public class copyRandomList13 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        //1遍扫描:对每个节点进行复制,并插入到对应对旧节点的后面
        RandomListNode node=head;
        while(node!=null){
            RandomListNode temp=new RandomListNode(node.label);
            temp.next=node.next;
            node.next=temp;
            node=temp.next;
        }
        //2遍扫描:为新节点的random赋值,只有通过第1步按顺序复制后,才能找到2次扫描的对应关系,所以第1步很重要.
        node=head;
        while (node!=null){
            if(node.random!=null) node.next.random=node.random.next;
            if(node.next!=null)
                node=node.next.next;
        }
        //3遍扫描:将新节点从新链表中拆分出来
        RandomListNode newHead=head.next;//被拆分出来的链表的头节点
        node=head;
        while(node!=null){
            RandomListNode temp=node.next;//临时存放新节点
            node.next=temp.next;//保存下一个原旧节点;
            if(temp.next!=null) temp.next=node.next.next;
            node=node.next;
        }
        return newHead;
    }
}
