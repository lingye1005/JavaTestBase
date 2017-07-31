package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/18.
 */
public class buildTreeOnPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length)
            return null;
        //将inorder存放在arraylist中,才可以根据preorder中根的位置获取该根在inorder中对应的下标
        ArrayList<Integer> getIndex=new ArrayList<Integer>();
        int len=inorder.length;
        for(int i=0;i<len;i++){
            getIndex.add(inorder[i]);
        }
        return helper(preorder,0,inorder,0,len-1,getIndex);
    }
    TreeNode helper(int[] preorder, int startpre, int[] inorder, int startin, int endin, ArrayList<Integer> getIndex){
        if(startin>endin)
            return  null;
        int value=preorder[startpre];
        TreeNode root=new TreeNode(value);
        int index=getIndex.indexOf(value);
        root.left=helper(preorder,startpre+1,inorder,startin,index-1,getIndex);
        root.right=helper(preorder,startpre+(index-startin+1),inorder,index+1,endin,getIndex);
        return root;
    }
}
