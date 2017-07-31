package niukeWeb;



/**
 * Created by caoxiaohong on 17/5/23.
 * 将给定的升序数组改为一棵平衡二叉树
 */
public class sortedArrayToBST {

    private TreeNode convertToAVLTree(int left,int right,int[] num){
        if(left>right) return null;
        else if(left==right)
            return new TreeNode(num[left]);
        else {
            int middle;
            if((left+right)%2==0)
                middle=(left+right)/2;
            else
                middle=(left+right)/2+1;
            TreeNode rootTemp=new TreeNode(num[middle]);
            rootTemp.left=convertToAVLTree(left,middle-1,num);
            rootTemp.right=convertToAVLTree(middle+1,right,num);
            return rootTemp;
        }

    }

    public TreeNode sortedArrayToBSTtest(int[] num) {
        int len=num.length;
        if(len==0) return null;
        if(len==1) return new TreeNode(num[0]);

        return convertToAVLTree(0,len-1,num);
    }
}
