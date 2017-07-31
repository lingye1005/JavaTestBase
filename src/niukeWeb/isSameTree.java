package niukeWeb;

import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/6/20.
 * 判定两棵树是否为一样的树
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        else if(p.val!=q.val)
            return false;

        LinkedList<TreeNode> listp=new LinkedList<TreeNode>();
        LinkedList<TreeNode> listq=new LinkedList<TreeNode>();

        int frontp=-1,rearp=-1,frontq=-1,rearq=-1;
        listp.add(p);
        rearp++;
        listq.add(q);
        rearq++;
        while(!listp.isEmpty() && !listq.isEmpty()){
            TreeNode tempp=listp.poll();
            frontp++;
            TreeNode tempq=listq.poll();
            frontq++;
            if(tempp.val!=tempq.val)
                return false;
            else if((tempp.left==null && tempq.left!=null) || (tempp.right==null && tempq.right!=null))
                return false;
            else if((tempp.left!=null && tempq.left==null) || (tempp.right!=null && tempq.right==null))
                return false;
            else if(tempp.left!=null && tempq.left!=null &&(tempp.left.val!=tempq.left.val))
                return false;
            else if(tempp.right!=null && tempq.right!=null && (tempp.right.val!=tempp.right.val))
                return false;
            else{
                if(tempp.left!=null){
                    listp.add(tempp.left);
                    rearp++;
                }
                if(tempp.right!=null){
                    listp.add(tempp.right);
                    rearp++;
                }
                if(tempq.left!=null){
                    listq.add(tempq.left);
                    rearq++;
                }
                if(tempq.right!=null){
                    listq.add(tempq.right);
                    rearq++;
                }
            }
        }
        if(!listp.isEmpty() || !listq.isEmpty())//有任何一个队列不为空
            return false;
        return true;
    }
}
