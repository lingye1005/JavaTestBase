package niukeWeb;

import java.util.*;

/**
 * Created by caoxiaohong on 17/5/18.
 * 测试用例都可以,就是A不了,不知道为什么,总是通过率为0.0%
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum
 * 返回的是满足sum的多个路径,以数组形式返回
 */

public class pathSum {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) {
            System.out.println(result);
            return result;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int front=0,rear=0;
        HashMap<Integer,String> hashMap=new HashMap<Integer, String>();//记录各个节点的路径

        String first=Integer.toString(root.val)+","; //第一个节点的路径

        queue.add(root);
        hashMap.put(rear,first); //第一个节点入队
        rear++;

        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            // int value=temp.val;

            if(temp.left==null && temp.right==null){
                String path=hashMap.get(front);
                int len=path.length();
                String[] isOK=path.split(",");
                ArrayList<Integer>  pa=new ArrayList<Integer>();
                int sums=0;
                for(String j:isOK){
                    pa.add(Integer.parseInt(j));
                    sums+=Integer.parseInt(j);
                }
                if(sum==sums){
                    result.add(pa);
                    //test
                    /*for(int i=0;i<pa.size();i++){
                        System.out.println(pa.get(i));
                    }*/
                }
            }
            if(temp.left!=null){
                queue.add(temp.left);
                String preP=hashMap.get(front);
                preP=preP+Integer.toString(temp.left.val)+",";
                hashMap.put(rear++,preP);
            }
            if(temp.right!=null){
                queue.add(temp.right);
                String preP=hashMap.get(front);
                preP=preP+Integer.toString(temp.right.val)+",";
                hashMap.put(rear++,preP);
            }
            front++;
        }
        return result;
    }

    public static void main(String[] args) {
        pathSum test=new pathSum();
        TreeNode root=new TreeNode(0);
        TreeNode ch1=new TreeNode(1);
        TreeNode ch2=new TreeNode(-1);
        TreeNode ch3=new TreeNode(-1);
        TreeNode ch4=new TreeNode(0);
        TreeNode ch5=new TreeNode(0);
        TreeNode ch6=new TreeNode(0);
        TreeNode ch7=new TreeNode(-1);
        TreeNode ch8=new TreeNode(0);
        TreeNode ch9=new TreeNode(0);

        root.left=ch1;
        root.right=ch2;

        ch1.left=ch3;
        ch1.right=null;

        ch2.left=ch4;
        ch2.right=ch5;

        ch3.left=ch6;
        ch3.right=ch7;

        ch4.left=null;
        ch4.right=null;

        ch5.left=ch8;
        ch5.right=ch9;

        ch6.left=null;
        ch6.right=null;
        ch7.left=null;
        ch7.right=null;
        ch8.left=null;
        ch8.right=null;
        ch9.left=null;
        ch9.right=null;

        ArrayList<ArrayList<Integer>> he= test.pathSum(root,-1);

        for(ArrayList<Integer> list:he){
             for(int j:list){
                 System.out.print(j);
                 System.out.print(",");
             }
            System.out.println();
        }
    }
}
