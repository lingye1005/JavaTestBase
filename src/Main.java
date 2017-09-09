import java.util.ArrayList;


//ListNode
class ListNode {
     int val;
     ListNode next = null;
     ListNode(int val) {
         this.val = val;
     }
}
//TreeNode
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);//在线笔试用
        Main t=new Main();
        int[] a={1,2,4,5,3,6};
        int[] b={4,2,5,1,3,6};
        TreeNode r=t.reConstructBinaryTree(a,b);
        System.out.println(r.val);
    }

    //newcoder
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //合法性判定
        if(pre==null || pre.length==0 || in==null || in.length==0 || pre.length!=in.length)
            return null;
        //进入主算法
        ArrayList<Integer> inOrder=new ArrayList<Integer>();
        for(int i:in)
            inOrder.add(i);
        return helper(pre,0,in,0,in.length-1,inOrder);
    }
    TreeNode helper(int[] pre,int index,int[] in,int front,int rear,ArrayList<Integer> list){
        if(front>rear)
            return null;
        TreeNode root=new TreeNode(pre[index]);
        int location=list.indexOf(pre[index]);
        root.left=helper(pre,index+1,in,front,location-1,list);
        root.right=helper(pre,index+(location-front+1),in,location+1,rear,list);
        return root;
    }
}
