package niukeWeb;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/6/18.
 */
public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int level=0,last=0;
        int front=-1,rear=-1;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        rear++;
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            front++;
            if(temp.left!=null){
                queue.add(temp.left);
                rear++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                rear++;
            }
            if(front==last){
                level++;
                last=rear;
            }
        }
        return level;
    }
}
