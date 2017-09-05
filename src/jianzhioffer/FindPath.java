package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/2.
 */
public class FindPath {
    ArrayList<Integer> array=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return result;
        path(root,target,result);
        return result;
    }

    /**
     * 先序遍历
     * @param root
     * @param target
     * @param list
     */
    private void path(TreeNode root,int target,ArrayList<ArrayList<Integer>> list){
        if(root==null)
            return;
        //如果是叶子节点，并且满足和为给定的那个数，则把这条路径存入list中，然后再去掉最后一次加的数返回上一个节点
        if(target==root.val && root.left==null && root.right==null){
            array.add(root.val);
            list.add((ArrayList<Integer>)array.clone());
            array.remove(array.size()-1);
        }else {
            array.add(root.val);
            //如果没有达到上面的要求则向左子树查找
            if(root.left!=null){
                path(root.left,target-root.val,list);
            }
            //如果没有达到上面的要求则向右子树查找
            if(root.right!=null){
                path(root.right,target-root.val,list);
            }
            //最后在向上一步，查找下一个分支
            array.remove(array.size()-1);
        }
    }


    //test code
    public static void main(String[] args) {
        FindPath t=new FindPath();
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(2);
        TreeNode t5=new TreeNode(3);
        TreeNode t6=new TreeNode(1);
        t1.left=t2;t1.right=t3;
        t2.left=t4;t2.right=t5;
        t3.right=t6;
        t.FindPath(t1,7);
    }
}
