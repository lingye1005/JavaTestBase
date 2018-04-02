package jianzhioffer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 16:40
 * @ProjectName: JavaBaseTest
 */
public class Print3 {



    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null)
            return res;
        return levelTravel(pRoot);
    }
    private ArrayList<ArrayList<Integer>> levelTravel(TreeNode root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int front=-1,rear=-1;
        int last=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        rear++;
        ArrayList<Integer> tmp=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            tmp.add(node.val);
            front++;
            if(node.left!=null){
                queue.add(node.left);
                rear++;
            }
            if(node.right!=null){
                queue.add(node.right);
                rear++;
            }
            if(front==last){
                last=rear;
                res.add(tmp);
                tmp=new ArrayList<>();
            }
        }
        return res;
    }
}
