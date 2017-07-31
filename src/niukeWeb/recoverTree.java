package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/21.
 * 二叉查找树有2个节点位置被替换了,要求利用算法恢复该二叉搜索树.
 * 要求:不改变树的结构,并且空间复杂度为 O(1)
 * 中序遍历:如果整个过程出现了1次逆序,则交换这两个相邻节点即可.如果出现2次逆序,则需要交换这2个非相邻节点
 */
public class recoverTree {

    TreeNode mistakeLeft,mistakRight;
    TreeNode pre; //用于记录上一个出错的节点,来确定是为mistakeLeft还是mistakRight赋值

    public void recoverTree(TreeNode root) {
        Inorder(root);
        if(mistakeLeft!=null && mistakRight!=null){
            int left=mistakeLeft.val;
            mistakeLeft.val=mistakRight.val;
            mistakRight.val=left;
        }
    }
    //中序遍历
    void Inorder(TreeNode root){
        if(root==null)
            return;
        Inorder(root.left);
        if(pre!=null && pre.val>root.val){
            if(mistakeLeft==null){
                mistakeLeft=pre;
                mistakRight=root;
            }else{
                mistakRight=root;
            }
        }
        pre=root;
        Inorder(root.right);
    }

    //test code
    public static void main(String[] args) {
        recoverTree test=new recoverTree();
        TreeNode root=new TreeNode(2);
        TreeNode ch1=new TreeNode(3);
        TreeNode ch2=new TreeNode(1);
        root.left=ch1;
        root.right=ch2;
        ch1.left=null;
        ch1.right=null;
        ch2.left=null;
        ch2.right=null;
        test.recoverTree(root);
        test.InorderTest(root);
    }
    //
    void InorderTest(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            InorderTest(root.left);
            InorderTest(root.right);
        }
    }
}
