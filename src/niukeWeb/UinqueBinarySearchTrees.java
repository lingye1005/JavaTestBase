package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/12.
 * 给定数字n,求1~n个节点组成的二叉排序树有多少.分别生成这些树,返回这些树的根节点集合.
 * 算法分析:可行的二叉查找树的数量是相应的卡特兰数，不是多项式时间的数量级，
 * 所以我们要求解所有的树，也不可能在多项式时间内求得解。
 * 算法上还是用求解NP问题的方法来求解，思路是每次选取一个结点为根，然后递归求解左右子树的所有结果，
 * 最后根据左右子树的返回的所有子树，依次选取然后接上（每个左边的子树跟所有右边的子树匹配，而每个右边的子树也要跟所有的左边子树匹配，
 * 总共有左右子树数量的乘积种情况），构造好之后作为当前树的结果返回
 *
 * 又是一个np问题
 */
public class UinqueBinarySearchTrees {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if(n==0) {
            result.add(null);
            return result;
        }
        return buildTree(1,n);
    }

    /**
     * 主函数
     * @param start
     * @param end
     * @return
     */
    ArrayList<TreeNode> buildTree(int start,int end){
        ArrayList<TreeNode> trees=new ArrayList<TreeNode>();
        if(start>end){
            trees.add(null);
            return trees;
        }else if(start==end){
            trees.add(new TreeNode(start));
            return trees;
        }
        for(int i=start;i<=end;i++){
            //产生所有以i为根节点的所有子树,i取值从start到end
            ArrayList<TreeNode>  leftTree=buildTree(start,i-1);
            ArrayList<TreeNode>  rightTree=buildTree(i+1,end);

            //将左子树所有的可能和右子树所有的可能  进行连接;这里思想是整个算法的核心,注意一下
            for(int j=0;j<leftTree.size();j++){
                for(int k=0;k<rightTree.size();k++){
                    TreeNode root=new TreeNode(i);
                    root.left=leftTree.get(j);
                    root.right=rightTree.get(k);
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
