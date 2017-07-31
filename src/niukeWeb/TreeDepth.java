package niukeWeb;

//import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caoxiaohong on 17/5/2.
 *  牛客网第1题
 */

 //Definition for binary tree
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//层序遍历:完全二叉树:求最短路径经过点数目
public class TreeDepth {
    int depth(TreeNode root){
        if(root==null) return 0; //树空返回0.结束程序.

        int level=0,last=1;// 记录层次,当前层最后一个节点下标.
        int front=0,rear=0;//头节点下标,尾节点下标.
        boolean flag=true; // 找到第一个叶子节点后,改为false
        Queue<TreeNode> queue=new LinkedList<TreeNode>();//存放节点数据:整型数据
        queue.add(root);
        rear++;
        while(flag){
            TreeNode head= queue.poll();//出队
            front++;
            if(head.left!=null) {
                queue.add(head.left);
                rear++;
            }
            if(head.right!=null) {
                queue.add(head.right);
                rear++;
            }
            if(head.left==null && head.right==null){//找到第一个叶子节点
                flag=false;
            }
            if(front!=last && (head.left==null && head.right==null)){
                level++;
            }
            if(front==last){
                level++;
                last=rear;
            }
        }
        return level;//level是层次
    }

    public static void main(String[] args) {
        TreeDepth td=new TreeDepth();
        //td.depth({});
    }
}
