package niukeWeb;

import java.util.*;

/**
 * Created by caoxiaohong on 17/5/11.
 * 二叉树节点包含的数字仅仅有:0-9,计算叶子节点的路径上,各个节点相加的和.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class sumNumbers15 {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;//空树
        if(root.left==null && root.right==null) return root.val;

        HashMap<Integer,String> path=new HashMap<Integer, String>();//存放各个节点:从root到自己的路径
        List<Integer> leafNode=new ArrayList<Integer>();//存放有哪些节点是叶子节点
        int sum=0;//记录路径和
        int rear=0;//该节点是第几个被访问到的
        int front=0;
        //采用层序遍历,入队时,记录前驱path

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        path.put(rear++,Integer.toString(root.val));//存放入队节点的路径;

        while(!queue.isEmpty()){ //队列不为空
            TreeNode temp=queue.poll(); //出队

            if(temp.right==null && temp.left==null){  //节点为叶子节点,则被记录,备用求和

                sum+=Integer.parseInt(path.get(front)) ;

            }
            if(temp.left!=null){
                queue.add(temp.left);
                path.put(rear++,path.get(front)+Integer.toString(temp.left.val));
            }
            if(temp.right!=null){
                queue.add(temp.right);
                path.put(rear++,path.get(front)+Integer.toString(temp.right.val));
            }
            front++;//出队,对头+1
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        TreeNode ch1=new TreeNode(3);
        TreeNode ch2=new TreeNode(5);
        TreeNode ch3=new TreeNode(9);
        TreeNode ch4=new TreeNode(9);
        TreeNode ch5=new TreeNode(5);
        root.left=ch1;
        root.right=ch2;

        ch1.left=null;
        ch1.right=ch3;

        ch2.left=null;
        ch2.right=null;

        ch3.left=ch4;
        ch3.right=ch5;

        ch4.left=null;
        ch4.right=null;

        ch5.left=null;
        ch5.right=null;
        sumNumbers15 test=new sumNumbers15();
        System.out.println(test.sumNumbers(root));
    }
}
