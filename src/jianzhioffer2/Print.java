package jianzhioffer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 12:17
 * @ProjectName: JavaBaseTest
 */
public class Print {

    public static void main(String[] args) {
        Print t=new Print();
        TreeNode root=new TreeNode(8);//8,6,10,5,7,9,11
        TreeNode t1=new TreeNode(6);
        TreeNode t2=new TreeNode(10);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(7);
        TreeNode t5=new TreeNode(9);
        TreeNode t6=new TreeNode(11);
        root.left=t1;root.right=t2;
        t1.left=t3;t1.right=t4;
        t2.left=t5;t2.right=t6;
        ArrayList<ArrayList<Integer>> a=t.Print(root);
        a.forEach(list->{
            list.forEach(i-> System.out.print(i+","));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot==null)
            return null;
        return levTraverse(pRoot);
    }
    //层序遍历
    private ArrayList<ArrayList<Integer>> levTraverse(TreeNode root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int front=-1,rear=-1;
        int last=0,level=0;//区分当前是奇数层or偶数层
        ArrayList<Integer> tmp=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);//
        rear++;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            front++;
            tmp.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                rear++;
            }
            if(node.right!=null){
                queue.add(node.right);
                rear++;
            }
            //换层
            if(front==last){
                if(level%2==0){
                    res.add(tmp);
                }else{
                    //逆序
                    int low=0,high=tmp.size()-1;
                    while (low<high){
                        int num=tmp.get(low);
                        tmp.set(low,tmp.get(high));
                        tmp.set(high,num);
                        low++;
                        high--;
                    }
                    res.add(tmp);
                }
                tmp=new ArrayList<>();
                last=rear;
                level++;
            }
        }
        return  res;
    }
}
