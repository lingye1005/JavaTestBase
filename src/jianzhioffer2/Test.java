package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/1/17 19:32
 * @ProjectName: JavaBaseTest
 */
public class Test {
    public int run(TreeNode root) {
        if(root==null)
            return 0;
        int front=-1,rear=-1;
        int last=0,level=0;
        ArrayList<TreeNode> list=new ArrayList<>();
        list.add(root);
        rear++;
        while (!list.isEmpty()){
            TreeNode node=list.get(0);
            list.remove(0);
            front++;
            if(node.left==null && node.right==null)
                break;
            if(node.left!=null){
                list.add(node.left);
                rear++;
            }
            if(node.right!=null){
                list.add(node.right);
                rear++;
            }
            if(front==last){
                level++;
                last=rear;
            }
        }
        return level+1;
    }

    //test
    public static void main(String[] args) {
        Test t=new Test();
        TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        root.right=l1;
        System.out.println(t.run(root));
    }
}
