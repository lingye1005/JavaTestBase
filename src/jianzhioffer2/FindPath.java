package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/3/24 21:11
 * @ProjectName: JavaBaseTest
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        helper(root,target,res);
        return res;
    }
    //递归
    ArrayList<Integer> tmp=new ArrayList<>();
    private void helper(TreeNode root,int target,ArrayList<ArrayList<Integer>> res){
        if(root==null || root.val>target)
            return;
        if(root.val==target && root.left==null && root.right==null){
            tmp.add(root.val);
            ArrayList<Integer> clone=(ArrayList<Integer>) tmp.clone();
            res.add(clone);
            tmp.remove(tmp.size()-1);
        }else{
            tmp.add(root.val);
            helper(root.left,target-root.val,res);
            helper(root.right,target-root.val,res);
            tmp.remove(tmp.size()-1);
        }
    }
}
