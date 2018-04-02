package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 15:30
 * @ProjectName: JavaBaseTest
 *
 * //未a过
 */
public class Print2 {
    //test
    public static void main(String[] args) {
        Print2 t=new Print2();
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
        //输出
        a.forEach(list->{
            list.forEach(i-> System.out.print(i+","));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>() ;
        if(pRoot==null)
            return res;
        return levelTravel(pRoot);
    }
    //层序遍历
    private ArrayList<ArrayList<Integer>> levelTravel(TreeNode root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();//偶数层
        Stack<TreeNode> stack2=new Stack<>();//奇数层
        int front=-1,rear=-1;
        int last=0,level=0;
        stack1.push(root);
        rear++;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            front++;
            if(front==last){
                ArrayList<Integer> tmp=new ArrayList<>();
                if(level%2==0){
                    while(!stack1.isEmpty()){
                        tmp.add(stack1.pop().val);
                    }
                    res.add(tmp);
                }else{
                    while(!stack2.isEmpty()){
                        tmp.add(stack2.pop().val);
                    }
                }
                last=rear;
                level++;
            }

            if(level%2==0){
                TreeNode heap=stack1.peek();
                if(heap.right!=null){
                    stack1.push(heap.right);
                    rear++;
                }
                if(heap.left!=null){
                    stack1.push(heap.left);
                    rear++;
                }
            }else{
                TreeNode heap=stack2.peek();
                if(heap.left!=null){
                    stack2.push(heap.left);
                    rear++;
                }
                if(heap.right!=null){
                    stack2.push(heap.right);
                    rear++;
                }
            }

        }
        return res;
    }
}
