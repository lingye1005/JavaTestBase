package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 09:36
 * @ProjectName: JavaBaseTest
 */
public class Convert {
    TreeNode pre=null;
    TreeNode head=null;
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        //中序遍历
        Convert(pRootOfTree.left);
        if(pre==null){
            pre=pRootOfTree;
            head=pRootOfTree;
        }else{
            pre.right=pRootOfTree;
            pRootOfTree.left=pre;
            pre=pRootOfTree;//更新上一个访问节点
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
