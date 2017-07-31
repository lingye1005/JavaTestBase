package niukeWeb;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/6/18.
 * 树的每一层节点为一个arraylist,故整棵树返回格式为ArrayList<ArrayList<Integer>>
 * 要求:偶数层次节点的顺序为:从右到左;奇数层次节点顺序:从左到右
 * 采用层序遍历
 */
public class zigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return result;
        ArrayList<Integer> levelArray=new ArrayList<Integer>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        int level=1,last=0;
        int front=-1,rear=-1;
        queue.add(root);
        rear++;
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            int value=temp.val;
            levelArray.add(value);
            front++;
            if (temp.left != null) {
                queue.add(temp.left);
                rear++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                rear++;
            }
            if(front==last){
                //偶数层:数据逆置
                if(level%2==0){
                    ArrayList<Integer> ni=new ArrayList<Integer>();
                    int length=levelArray.size();
                    for(int i=length-1;i>-1;i--){
                        ni.add(levelArray.get(i));
                    }
                    levelArray=ni;
                }
                result.add(levelArray);
                levelArray=new ArrayList<Integer>();
                last=rear;
                level++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        zigzagLevelOrder test=new zigzagLevelOrder();
        TreeNode root=new TreeNode(1);
        TreeNode ch1=new TreeNode(2);
        TreeNode ch2=new TreeNode(3);
        TreeNode ch3=new TreeNode(4);
        TreeNode ch4=new TreeNode(5);

        root.left=ch1;
        root.right=ch2;
        ch1.left=ch3;
        ch1.right=null;
        ch2.left=null;
        ch2.right=ch4;
        ch3.left=null;
        ch3.right=null;
        ch4.left=null;
        ch4.right=null;

        ArrayList<ArrayList<Integer>> a=test.zigzagLevelOrder(root);
        for(ArrayList i:a){
            for(int j=0;j<i.size();j++){
                System.out.print(i.get(j)+",");
            }
            System.out.println();
        }
    }
}
