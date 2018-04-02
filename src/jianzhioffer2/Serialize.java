package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 17:33
 * @ProjectName: JavaBaseTest
 */
public class Serialize {
    String Serialize(TreeNode root) {
        if(root==null)
            return sb.toString();
        seri(root);
        StringBuilder res=sb.delete(sb.length()-1,sb.length());
        return res.toString();
    }
    TreeNode Deserialize(String str) {
        if(str==null || str.equals(""))
            return null;
        String[] nodes=str.split(",");
        return deseri(nodes);
    }
    StringBuilder sb=new StringBuilder();
    void seri(TreeNode root){
        if(root==null){
            sb.append("$,");
        }
        else{
            sb.append(root.val+",");
            seri(root.left);
            seri(root.right);
        }
    }
    //反序列化
    int idx=0;
    TreeNode deseri(String[] nodes){
        if(idx>=nodes.length)
            return null;
        TreeNode root=null;
        if(!nodes[idx].equals("$")){
            root=new TreeNode(Integer.valueOf(nodes[idx++]));
            root.left=deseri(nodes);
            root.right=deseri(nodes);
        }
        return root;
    }
}
