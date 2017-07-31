package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/17.
 * 根据中序遍历和后序遍历构造出二叉树
 */
public class buildTreeOnInderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0 || inorder.length!=postorder.length)
            return null;
        //为了获取根节点在中序数组中的下标,需要把inorder复制一份到arraylist,根据indexof函数即可得到.
        ArrayList<Integer> getIndex=new ArrayList<Integer>();
        int len=inorder.length;
        for(int i=0;i<len;i++){
            getIndex.add(inorder[i]);
        }
        return binaryTree(inorder,0,len-1,postorder,len-1,getIndex);
    }
    //因为中序可以确定一棵树:根节点,左子树右子树,因此要有参数startin\endin
    //因为后序可以确定根节点:所以后序要知道最后一个元素的下标是哪里,因此要有参数endPost
    //参数getRootIndex的左右上面已经提到过
    TreeNode binaryTree(int[] inorder,int startin,int endin,int[] postorder,int endPost,ArrayList<Integer> getRootIndex){
        if(startin>endin)
            return null;
        int rootValue=postorder[endPost];
        TreeNode root=new TreeNode(rootValue);//创建根节点
        //获取根节点在中序数组中的位置下标
        int rootIndex=getRootIndex.indexOf(rootValue);//之所以可以根据节点的值获取数组下标:是因为假定了各个节点值都是互不相同的
        root.right=binaryTree(inorder,rootIndex+1,endin,postorder,endPost-1,getRootIndex);
        root.left=binaryTree(inorder,startin,rootIndex-1,postorder,endPost-(endin-rootIndex+1),getRootIndex);
        return root;
    }
}
