package niukeWeb;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/6/4.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 给定一棵二叉树,从底到上返回每层节点值.每层节点值为数组,整个二叉树为另一个数组,返回即为: ArrayList<ArrayList<Integer>>
 */
public class levelOrderBottom {
    ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();//保存从上到下的结果值

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        //获取层序遍历中从上到下的结果值
        levelTraverse(root);
        //将结果值改为从下到上;
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int len=temp.size();
        for(int i=len-1;i>-1;i--){
            result.add(temp.get(i));
        }
        //返回结果值
        return result;
    }
    //层序遍历遍历算法
    private void levelTraverse(TreeNode root){
        if(root==null) return ;

        int last=0;
        int front=-1,rear=-1;
        ArrayList<Integer> levelList=new ArrayList<Integer>();//按序存储当前层的节点值
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();//层序遍历队列

        list.add(root);
        rear++;
        while(!list.isEmpty()){
            TreeNode node=list.poll();
            front++;
            int value=node.val;//节点值
            levelList.add(value);
            if(node.left!=null){
                list.add(node.left);
                rear++;
            }
            if(node.right!=null){
                list.add(node.right);
                rear++;
            }
            if(front==last){//遍历完一层
                last=rear;
                temp.add(levelList);
                levelList=new ArrayList<Integer>();
            }
        }
    }

    public static void main(String[] args) {
        levelOrderBottom test=new levelOrderBottom();
        TreeNode root=new TreeNode(3);
        TreeNode ch1=new TreeNode(9);
        TreeNode ch2=new TreeNode(20);
        TreeNode ch3=new TreeNode(15);
        TreeNode ch4=new TreeNode(7);
        //TreeNode ch5=new TreeNode();
        root.left=ch1;
        root.right=ch2;
        ch1.left=null;
        ch1.right=null;
        ch2.left=ch3;
        ch2.right=ch4;
        ch3.left=null;
        ch3.right=null;
        ch4.left=null;
        ch4.right=null;
        ArrayList<ArrayList<Integer>> hh= test.levelOrderBottom(root);
        for(int i=0;i<hh.size();i++){
            for(int j=0;j<hh.get(i).size();j++){
                System.out.print(hh.get(i).get(j));
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
