package niukeWeb;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/5/22.
 * 给定二叉树,将每层的节点以链表的形式链接起来,每行最后一个节点的next指针为null
 * 层序遍历法
 */
 class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class connect {
    //层序遍历
    public void connectT(TreeLinkNode root) {
        if(root==null) return;

        int last=0;//记录当前行最后一个节点
        int front=-1,rear=-1;
        LinkedList<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();//存放节点
        queue.add(root);
        rear++;
        root.next=null;
        while(!queue.isEmpty()){
            TreeLinkNode temp= queue.pollFirst();//取出对头元素
            front++;
            if(!queue.isEmpty()){
                temp.next=queue.peekFirst();
            }
            if(temp.left!=null){
                queue.addLast(temp.left);
                rear++;
            }
            if(temp.right!=null){
                queue.addLast(temp.right);
                rear++;
            }
            if(front==last){  //当前层次遍历完成
                last=rear;
                temp.next=null;
            }
        }
    }
}
