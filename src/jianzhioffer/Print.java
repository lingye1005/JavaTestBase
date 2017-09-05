package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/9/2.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 * 算法:层序遍历
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> reslut=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return reslut;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();//存放当前层次的数字
        int front=-1,rear=-1;
        int last=0;
        queue.add(pRoot);
        rear++;
        while (!queue.isEmpty()){
            TreeNode node=queue.pop();
            front++;
            tmp.add(node.val);
            if(node.left!=null) {
                queue.add(node.left);
                rear++;
            }
            if(node.right!=null) {
                queue.add(node.right);
                rear++;
            }
            if(front==last){
                reslut.add(tmp);
                tmp=new ArrayList<Integer>();
                last=rear;
            }
        }
        //更改奇数行顺序
        for(int i=1;i<reslut.size();i+=2){
            ArrayList<Integer> list=reslut.get(i);
            int low=0,high=list.size()-1;
            while(low<high){
                int x=list.get(low);
                list.set(low,list.get(high));
                list.set(high,x);
                low++;
                high--;
            }
        }
        return reslut;
    }

    public static void main(String[] args) {
        Print t=new Print();
        TreeNode root=new TreeNode(8);//8,6,10,5,7,9,11
        TreeNode t1=new TreeNode(6);
        TreeNode t2=new TreeNode(10);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(7);
        TreeNode t5=new TreeNode(9);
        TreeNode t6=new TreeNode(11);
        root.left=t1;root.right=t2;
        t1.left=t3;t1.right=t4;
        t2.left=t5;t2.right=t6;
        ArrayList<ArrayList<Integer>> a=t.Print(root);
    }
}
