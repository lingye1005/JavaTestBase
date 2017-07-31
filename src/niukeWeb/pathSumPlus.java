package niukeWeb;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoxiaohong on 17/5/18.
 * 和pathSum一个题,只是此处代码是从网上找来的:递归算法
 */
public class pathSumPlus {
    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
        if(root==null) return res;
        handler(root,sum,new ArrayList<Integer>());
        return res;
    }
    private  void handler(TreeNode root, int sum, List<Integer> pre){
        if(root==null)  return;
        ArrayList<Integer> curr=new ArrayList<Integer>(pre);
        curr.add(root.val);
        if(root.left==null && root.right==null && sum==root.val){
            res.add(curr);
            return;
        }
        handler(root.left,sum-root.val,curr);
        handler(root.right,sum-root.val,curr);
    }

}
